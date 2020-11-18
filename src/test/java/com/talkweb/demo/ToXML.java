package com.talkweb.demo;

import java.util.HashMap;
import java.util.Map;

import static com.talkweb.demo.ToJson.*;

/**
 * @author liuzixuan
 * @date 2020/9/28
 */
public class ToXML {
    public static String s88 ="MachineType,MachineCode,DataTime,TotalTime,BV_CurrentVelocity,XX_CurrentVelocity,XX_Status,XX_GoodProduction,XX_RejectedProduction,XX_EliminatingRate,XX_UtilizationRate,XX_TotalField,BV_Status,BV_GoodProduction,BV_RejectedProduction,BV_EliminatingRate,BV_UtilizationRate,BV_TotalField,Param1,Param2,Param3,Param4,Param5,Param6,Param7,Param8,Param9,Param10,Param11,Param12,Param13,Param14,Param15,Param16,Param17,Param18,Param19,Param20,Param21,Param22,Param23,Param24,Param25,Param26,Param27,Param28,Param29,Param30,Param31,Param32,Param33,Param34,Param35,Param36,Param37,Param38,Param39,Param40,Param41,Param42,Param43,XX_MATERIAL_7,XX_MATERIAL_4,XX_MATERIAL_6,XX_MATERIAL_8,BV_MATERIAL_7,BV_MATERIAL_21,BV_MATERIAL_3,Param44,Param45,Param46,Param47,Param48,Param49,Param50,Param51,Param52,Param53,Param54,Param55,Param56,Param57,Param58,Param59";

    public static String s99 = "XX_StartTime,XX_EndTime,XX_Text,XX_DurationTime,BV_StartTime,BV_EndTime,BV_Text,BV_DurationTime";

    public static String replaceStr = "<BrowseElement ElementName=\"${key}\">  <Item><Value xsi:type=\"xsd:String\"   >0</Value></Item>    </BrowseElement>";

    public static String replaceKey ="${key}";

    public static Map<String,String> map;

    static
    {
        map = new HashMap<String,String>();

        map.put("GDX6-001", s88);
        map.put("GDX6-002", s99);
    }


    public static String generateXml(String deviceId,String groupen,String splitStr[])
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<BrowseElement ElementName=\"").append(groupen).append(".").append(deviceId).append("\">").append("\r\n");
        sb.append("<Children>").append("\rn");

        int size = splitStr.length;

        for (int i=0;i<size;i++)
        {
            sb.append(replaceStr.replace(replaceKey, splitStr[i])).append("\r\n");
        }

        sb.append("</Children>\r\n" +
                "</BrowseElement>\r\n");
        return sb.toString();
    }


    public static void main(String args[])
    {
        String deviceId = "14007q";
        for(Map.Entry<String, String> entry : map.entrySet())
        {
            String groupName = entry.getKey();
            String mapValue = entry.getValue();
            String splitStr[] = mapValue.split(",");

            System.out.println(generateXml(deviceId,groupName,splitStr));
        }

    }

}
