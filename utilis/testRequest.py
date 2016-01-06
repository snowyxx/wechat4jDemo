#!/usr/bin/python
# -*- coding: utf-8 -*-
'''
Use this scrtip to raise httprequest from product as an action
e.g. C:\python27\python d:\testRequest.py APM "$RCAMSG_PLAINTEXT" >out.txt

'''
import urllib2
import urllib
import sys

reload(sys)
sys.setdefaultencoding("utf-8")

url = 'http://203.88.167.220/wechatDemo/pass'

product = sys.argv[1]
message = sys.argv[2]
message = message.decode('GBK').encode('UTF-8')  # this is for Chinese Windows
print product
print message
para = {'product': product, 'message': message}
postdata = urllib.urlencode(para)
print postdata
req = urllib2.Request(url, postdata)
resp = urllib2.urlopen(req)
print resp.read()
