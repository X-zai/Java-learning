#!/usr/bin/python3
# -*- coding: UTF-8 -*-

import getopt
import json
import sys
import urllib.request
import uuid

# Consul注册地址(手动配置)
CONSUL_REGISTRATION_ADDRESS = "http://172.16.11.67:8500"


def usage():
    """ 使用说明 """
    print(
        """
        ----------------------------- Welcome to use sd4monitoring ------------------------------------------------------------------------------
        
        准备：
        请先配置Consul注册地址：配置Python脚本的 CONSUL_REGISTRATION_ADDRESS 为实际地址
        
        使用：
        -h or --help          查看帮助信息
        -v or --version       查看版本
        --action              操作类型                                                     例子：--action=register[,deregister]
        --id                  服务标识(唯一，自动生成)                                     例子：--id=36574485-663f-11e9-a299-acde48001122
        --name                服务名称(不唯一，可以多个服务共用一个服务名，比如：node)     例子：--name=node
        --tags                服务标签(多个逗号分隔)                                       例子：--tags=monitoring[,node,microservice,middleware,ops-exporter]
        --address             服务地址                                                     例子：--address=192.168.1.101
        --port                服务端口                                                     例子：--port=8080
        --meta                服务元数据(node类型需要使用：group，alias)                   例子：--meta=group:technology-center-coll,alias:app-api1                  
        --check.address       服务校验地址                                                 例子：--check.address=http://172.16.102.49:9100/metrics[,tcp://172.16.102.49:9100]
        
        服务注册：--action=register     需要的参数：--name,--tags,--address,--port,--check.address
        服务注销：--action=deregister   需要的参数：--id
        """
    )


def version():
    """ 版本 """
    print("1.0.0")


def register(param):
    """ 注册服务到Consul """
    id = str(uuid.uuid1())
    param["id"] = id
    url = CONSUL_REGISTRATION_ADDRESS + "/v1/agent/service/register"
    data = json.dumps(param)
    http(url, data, {'Content-Type': 'application/json'})
    print("id:", id)


def deregister(name):
    """ 从Consul注销服务 """
    url = CONSUL_REGISTRATION_ADDRESS + "/v1/agent/service/deregister/" + name
    http(url)


def http(url, data=None, header={}):
    """ HTTP请求 """
    try:
        if data is None:
            req = urllib.request.Request(url, None, header, method="PUT")
        else:
            req = urllib.request.Request(url, bytes(data, 'utf-8'), header, method="PUT")
        response = urllib.request.urlopen(req)
        if response.getcode() == 200:
            print("Success")
    except Exception as e:
        print("【HTTP 请求异常】", e, ", url:", url)


def parseOpt(opts):
    """ 解析与校验命令行参数 """

    param = {"id": "", "name": "", "tags": [], "address": "", "port": 0, "meta": {},
             "check": ""}
    action = ""

    # 解析
    for flag, arg in opts:
        if flag == "--action":
            action = arg
        if flag == "--id":
            param["id"] = arg
        if flag == "--name":
            param["name"] = arg
        elif flag == "--tags":
            param["tags"] = arg.split(",")
        elif flag == "--address":
            param["address"] = arg
        elif flag == "--port":
            param["port"] = int(arg)
        elif flag == "--meta" and arg != "":
            try:
                for pair in arg.split(","):
                    key = pair.split(":")[0]
                    value = pair.split(":")[1]
                    param["meta"][key] = value
            except Exception:
                print("【非法 --meta】", arg, ", 请查看帮助信息 --help")
                sys.exit()
        elif flag == "--check.address":
            if arg.startswith("http"):
                param["check"] = {"http": arg, "method": "GET", "interval": "30s", "timeout": "5s"}
            elif arg.startswith("tcp"):
                param["check"] = {"tcp": arg[6:], "interval": "30s", "timeout": "5s"}
            else:
                print("【非法 --check.address】", arg, ", 请查看帮助信息 --help")
                sys.exit()

    # 校验
    if action not in ("register", "deregister"):
        print("【非法 --action 或 --action为空】", action, ", 请查看帮助信息 --help")
        sys.exit()
    elif action == "register":
        if param["name"] == "" or len(param["tags"]) == 0 or param["address"] == "" or param[
            "port"] == 0:
            print("【非法 --xxx】参数不能为空，", param, ", 请查看帮助信息 --help")
            sys.exit()
        valid = False
        for tag in param["tags"]:
            if tag in ["monitoring", "node", "microservice", "middleware","ops-exporter"]:
                valid = True
                break
        if not valid:
            print("【非法 --tags】没有包含指定值，", param["tags"], ", 请查看帮助信息 --help")
            sys.exit()
    else:
        if param["id"] == "":
            print("【非法 --id】--id不能为空，", "请查看帮助信息 --help")
            sys.exit()

    return action, param


if __name__ == '__main__':

    try:
        opts, args = getopt.getopt(sys.argv[1:], "hv",
                                   ["help", "version", "action=", "id=", "name=", "tags=", "address=", "port=", "meta=",
                                    "check.address="])
    except getopt.GetoptError as e:
        print("【非法 Command】", e, ", 请查看帮助信息 --help")
        sys.exit()

    for flag, arg in opts:
        if flag in ("-h", "--help"):
            usage()
            sys.exit()
        if flag in ("-v", "--version"):
            version()
            sys.exit()

    action, param = parseOpt(opts)

    if action == "register":
        register(param)
    else:
        deregister(param["id"])
