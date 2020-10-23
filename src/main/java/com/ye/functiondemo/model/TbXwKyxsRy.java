package com.ye.functiondemo.model;

public class TbXwKyxsRy {
 /*表字段           中文描述
  XXZJBH         信息主键编号
  ASJBH          案事件编号
  KYXSRY_ZJHM    证件号码
  KYXSRY_KYYJ    可疑依据
  DJSJ           登记时间
  GXSJ           更新时间
  XXSC_PDBZ      信息删除判断标志
*/
 private String xxzjbh;
 private  String asjbh;
 private String  kyxsry_Zjhm;
 private  String kyxsry_kyyj;
 private  String  djsj;
 private  String  gxsj;
 private  String xxsc_Pdbz;

 @Override
 public String toString() {
  return "TbXwKyxsRy{" +
   "xxzjbh='" + xxzjbh + '\'' +
   ", asjbh='" + asjbh + '\'' +
   ", kyxsry_Zjhm='" + kyxsry_Zjhm + '\'' +
   ", kyxsry_kyyj='" + kyxsry_kyyj + '\'' +
   ", djsj='" + djsj + '\'' +
   ", gxsj='" + gxsj + '\'' +
   ", xxsc_Pdbz='" + xxsc_Pdbz + '\'' +
   '}';
 }

 public String getXxzjbh() {
  return xxzjbh;
 }

 public void setXxzjbh(String xxzjbh) {
  this.xxzjbh = xxzjbh;
 }

 public String getAsjbh() {
  return asjbh;
 }

 public void setAsjbh(String asjbh) {
  this.asjbh = asjbh;
 }

 public String getKyxsry_Zjhm() {
  return kyxsry_Zjhm;
 }

 public void setKyxsry_Zjhm(String kyxsry_Zjhm) {
  this.kyxsry_Zjhm = kyxsry_Zjhm;
 }

 public String getKyxsry_kyyj() {
  return kyxsry_kyyj;
 }

 public void setKyxsry_kyyj(String kyxsry_kyyj) {
  this.kyxsry_kyyj = kyxsry_kyyj;
 }

 public String getDjsj() {
  return djsj;
 }

 public void setDjsj(String djsj) {
  this.djsj = djsj;
 }

 public String getGxsj() {
  return gxsj;
 }

 public void setGxsj(String gxsj) {
  this.gxsj = gxsj;
 }

 public String getXxsc_Pdbz() {
  return xxsc_Pdbz;
 }

 public void setXxsc_Pdbz(String xxsc_Pdbz) {
  this.xxsc_Pdbz = xxsc_Pdbz;
 }
}
