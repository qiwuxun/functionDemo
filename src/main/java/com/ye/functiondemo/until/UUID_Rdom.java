package com.ye.functiondemo.until;

import java.util.UUID;

public class UUID_Rdom {
 public static String getUUID_30()
 {
  String uuid = UUID.randomUUID().toString();
  char[] ar = uuid.toCharArray();
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < ar.length; i++)
  {
   if (ar[i] != '-')
   {
    sb.append(ar[i]);
   }
  }
  sb.delete(0,2);
  return sb.toString();
 }
}
