package com.ruoyi.common.core.domain.industry224;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//沥青溶解度试验检测记录表
public class CL10 {
    private String jlbh;        //    jlbh        varchar(64) not null comment '记录编号',
    private String jcdwmc;      //    jcdwmc      varchar(64) not null comment '检测单位名称',
    private String gcmc;        //    gcmc        varchar(64) not null comment '工程名称',
    private String htd;         //    htd         varchar(64) not null comment '合同段',
    private String sgdw;        //    sgdw        varchar(64) not null comment '施工单位',
    private String jldw;        //    jldw        varchar(64) not null comment '监理单位',
    private String gcbw_yt;     //    gcbw_yt     varchar(64) not null comment '工程部位/用途',
    private String ypxx;        //    ypxx        varchar(64) not null comment '样品信息',
    private String fjsm;        //    fjsm        varchar(64) null comment '附加声明'

    private float sytj_ssd;           //    sytj_ssd    float         null comment '试验条件：摄氏度',
    private float sytj_xdsd;          //    sytj_xdsd   float    null comment '试验条件：相对湿度',
    private String jcyj;            //    jcyj        varchar(64) null comment '检测依据',
    private String pdyj;            //    pdyj        varchar(64) null comment '判定依据',
    private String zyyqsbmcjbh;     //    zyyqsbmcjbh varchar(64) null comment '主要仪器设备名称及编号	 ',
    private String lqzl;            //    lqzl        varchar(64) null comment '沥青种类',
    private String lqbh;            //    lqbh        varchar(64) null comment '沥青标号',
    private String sccj;            //    sccj        varchar(64) null comment '生产厂家',
    private String scph;             //    ph          varchar(64) null comment '生产批号',
    public float m1;               //    m1          float       null comment '第一次 古氏坩埚与玻璃纤维滤纸合计质量(g)',
    public float m2;               //    m2          float       null comment '第一次 锥形瓶与玻璃棒合计质量(g）',
    public float m3;               //    m3          float       null comment '第一次 锥形瓶、玻璃棒与沥青试样合计质量(g)	',
    public float m4;               //    m4          float       null comment '第一次 古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)',
    public float m5;               //    m5          float       null comment '第一次 锥形瓶、玻璃棒与黏附不溶物合计质量(g)',
    public float a1;               //    a1          varchar(64) null comment '第二次 古氏坩埚与玻璃纤维滤纸合计质量(g)',
    public float a2;               //    a2          float       null comment '第二次 锥形瓶与玻璃棒合计质量(g)',
    public float a3;               //    a3          float       null comment '第二次 锥形瓶、玻璃棒与沥青试样合计质量(g)	',
    public float a4;               //    a4          float       null comment '第二次 古氏坩埚、玻璃纤维滤纸与不溶物合计质量(g)',
    public float a5;               //    a5          float       null comment '第二次 锥形瓶、玻璃棒与黏附不溶物合计质量(g)					 ',
    private float sb1;      //    sb1 float       null comment '沥青试样溶解度(%)第一次单值',
    private float sb2;     //    sb2 float       null comment '沥青试样溶解度(%)第二次单值',
    private float sb;      //    sb float       null comment '沥青试样溶解度(%)平均值',


    private int id;             //不在excel表内
    private String userid;         //采集人员编号

    private String position;    //记录采集地点

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date syjcrq;            //    syjcrq      datetime    null comment '试验检测日期',

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date scrq;            //    scrq        datetime    null comment '生产日期',

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;       //记录创建日期，不在excel表内

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedTime;   //最近修改日期，不在excel表内

    public CL10() {}

    public CL10(String jlbh) {
        this.jlbh = jlbh;
    }

    public String getJlbh() {
        return jlbh;
    }

    public void setJlbh(String jlbh) {
        this.jlbh = jlbh;
    }

    public String getJcdwmc() {
        return jcdwmc;
    }

    public void setJcdwmc(String jcdwmc) {
        this.jcdwmc = jcdwmc;
    }

    public String getGcmc() {
        return gcmc;
    }

    public void setGcmc(String gcmc) {
        this.gcmc = gcmc;
    }

    public String getHtd() {
        return htd;
    }

    public void setHtd(String htd) {
        this.htd = htd;
    }
    public String getSgdw() {
        return sgdw;
    }

    public void setSgdw(String sgdw) {
        this.sgdw = sgdw;
    }

    public String getJldw() {
        return jldw;
    }

    public void setJldw(String jldw) {
        this.jldw = jldw;
    }

    public String getGcbw_yt() {
        return gcbw_yt;
    }

    public void setGcbw_yt(String gcbw_yt) {
        this.gcbw_yt = gcbw_yt;
    }

    public String getYpxx() {
        return ypxx;
    }

    public void setYpxx(String ypxx) {
        this.ypxx = ypxx;
    }

    public String getFjsm() {
        return fjsm;
    }

    public void setFjsm(String fjsm) {
        this.fjsm = fjsm;
    }

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public Date getCreatedTime() {
        return createdTime;
    }

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public String getZyyqsbmcjbh() {
        return zyyqsbmcjbh;
    }

    public void setZyyqsbmcjbh(String zyyqsbmcjbh) {
        this.zyyqsbmcjbh = zyyqsbmcjbh;
    }

    public float getSytj_ssd() {
        return sytj_ssd;
    }

    public float getSytj_xdsd() {
        return sytj_xdsd;
    }

    public String getJcyj() {
        return jcyj;
    }

    public void setJcyj(String jcyj) {
        this.jcyj = jcyj;
    }

    public String getPdyj() {
        return pdyj;
    }

    public void setPdyj(String pdyj) {
        this.pdyj = pdyj;
    }

    public String getLqzl() {
        return lqzl;
    }

    public void setLqzl(String lqzl) {
        this.lqzl = lqzl;
    }

    public String getLqbh() {
        return lqbh;
    }

    public void setLqbh(String lqbh) {
        this.lqbh = lqbh;
    }

    public String getSccj() {
        return sccj;
    }

    public void setSccj(String sccj) {
        this.sccj = sccj;
    }

    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }

    public String getScph() {
        return scph;
    }

    public void setScph(String scph) {
        this.scph = scph;
    }

    public float getM1() {
        return m1;
    }

    public void setM1(float m1) {
        this.m1 = m1;
    }

    public float getM2() {
        return m2;
    }

    public void setM2(float m2) {
        this.m2 = m2;
    }

    public float getM3() {
        return m3;
    }

    public void setM3(float m3) {
        this.m3 = m3;
    }

    public float getM4() {
        return m4;
    }

    public void setM4(float m4) {
        this.m4 = m4;
    }

    public float getM5() {
        return m5;
    }

    public void setM5(float m5) {
        this.m5 = m5;
    }

    public float getA1() {
        return a1;
    }

    public void setA1(float a1) {
        this.a1 = a1;
    }

    public float getA2() {
        return a2;
    }

    public void setA2(float a2) {
        this.a2 = a2;
    }

    public float getA3() {
        return a3;
    }

    public void setA3(float a3) {
        this.a3 = a3;
    }

    public float getA4() {
        return a4;
    }

    public void setA4(float a4) {
        this.a4 = a4;
    }

    public float getA5() {
        return a5;
    }

    public void setA5(float a5) {
        this.a5 = a5;
    }

    public float getSb1() {
        return sb1;
    }

    public void setSb1(float sb1) {
        this.sb1 = sb1;
    }
    
    public float getSb() {
        return sb;
    }

    public void setSb(float sb) {
        this.sb = sb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSyjcrq() {
        return syjcrq;
    }

    public void setSyjcrq(Date syjcrq) {
        this.syjcrq = syjcrq;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public float getSb2() {
        return sb2;
    }

    public void setSb2(float sb2) {
        this.sb2 = sb2;
    }

    public void setSytj_ssd(float sytj_ssd) {
        this.sytj_ssd = sytj_ssd;
    }

    public void setSytj_xdsd(float sytj_xdsd) {
        this.sytj_xdsd = sytj_xdsd;
    }
}
