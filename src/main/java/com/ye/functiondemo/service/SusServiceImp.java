package com.ye.functiondemo.service;

import com.ye.functiondemo.dao.SusDao;
import com.ye.functiondemo.model.TbXwKyxsRy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SusServiceImp implements  SusService {

 @Autowired
 private SusDao susDao;

 @Override
 public List<TbXwKyxsRy> getSelTbXwKyxsRyList() {
  return susDao.getSelTbXwKyxsRyList();
 }

 @Override
 public List<TbXwKyxsRy> getSelMapTbXwList(Map<String, Object> map1) {
  return susDao.getSelMapTbXwList(map1);
 }

 @Override
 public int qrySusCount(Map<String, Object> map1) {
  return susDao.qrySusCount(map1);
 }

 @Override
 public int insertSus(TbXwKyxsRy tbXwKyxsRy) {
  return susDao.insertSus(tbXwKyxsRy);
 }

 @Override
 public TbXwKyxsRy qrySusById(String xxzjbh) {
  return susDao.qrySusById(xxzjbh);
 }

 @Override
 public int updateTbXwKyxsRy(TbXwKyxsRy tbXwKyxsRy) {
  return susDao.updateTbXwKyxsRy(tbXwKyxsRy);
 }

 @Override
 public int delTbXwKyxs(String xxzjbh) {
  return susDao.delTbXwKyxs(xxzjbh);
 }
}
