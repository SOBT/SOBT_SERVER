#-*- coding:utf-8 -*-

import sys
import json
import requests
import urllib

def papago(sent, ko2en=True):
    # --------------------파파고----------------------
    sent = urllib.unquote_plus(sent);
    headers = {'x-naver-client-id':'labspace'}
    if ko2en: payload = {'source':'ko','target':'en'}
    else:     payload = {'source':'en','target':'ko'}
    payload['text'] = sent
    url = 'http://labspace.naver.com/api/n2mt/translate'
    # ---------------------------------------------------
    recv = requests.post(url, data=payload, headers=headers)
    resp = json.loads(recv.text)
    return resp['message']['result']['translatedText']


# print(urllib.unquote_plus("%EB%B2%88%EC%97%AD%EC%9D%B4+%EC%9E%98+%EC%95%88%EB%90%98%EB%84%A4%EC%9A%94%3F"))