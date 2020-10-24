package com.ye.functiondemo.dao;

import com.ye.functiondemo.model.TbXwKyxsRy;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface SusDao {
 List<TbXwKyxsRy> getSelTbXwKyxsRyList();

 List<TbXwKyxsRy> getSelMapTbXwList(Map<String, Object> map1);

 int qrySusCount(Map<String, Object> map1);

 int insertSus(TbXwKyxsRy tbXwKyxsRy);

 TbXwKyxsRy qrySusById(String xxzjbh);

 int updateTbXwKyxsRy(TbXwKyxsRy tbXwKyxsRy);

 int delTbXwKyxs(String xxzjbh);
}
