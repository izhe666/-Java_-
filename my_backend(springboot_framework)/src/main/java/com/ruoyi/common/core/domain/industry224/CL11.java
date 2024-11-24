package com.ruoyi.common.core.domain.industry224;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)

 public class CL11 extends BaseEntity {

    private int id;
    private String jcdwmc;     //检测单位名称
    private String jlbh;       //记录编号
    private String gcmc;       //工程名称
    private String htd;        //合同段
    private String sgdw;       //施工单位
    private String jldw;       //监理单位
    private String gcbw;       //工程部位/用途
    private String ypxx;       //样品信息
    private String sytj;       //试验条件
    private String wd;         // 温度
    private String xdsd;       // 相对湿度
    private String jcyj;       // 检测依据
    private String pdyj;       // 判定依据
    private String zyyqsbmchbh;// 主要仪器设备名称和标号
    private String lqzl;       // 沥青种类
    private String lqbh;       // 沥青标号
    private String sccj;       // 生产厂家
    private String ph;         // 批号
    private String sycs;       // 试验次数
    private Float cswd1;       // 初始温度1（℃）
    private Float cswd2;       // 初始温度2（℃）
    private Float a1;          // 1组第1次温度记录
    private Float a2;          // 1组第2次温度记录
    private Float a3;          // 1组第3次温度记录
    private Float a4;          // 1组第4次温度记录
    private Float a5;          // 1组第5次温度记录
    private Float a6;          // 1组第6次温度记录
    private Float a7;          // 1组第7次温度记录
    private Float a8;          // 1组第8次温度记录
    private Float a9;          // 1组第9次温度记录
    private Float a10;         // 1组第10次温度记录
    private Float a11;         // 1组第11次温度记录
    private Float a12;         // 1组第12次温度记录
    private Float a13;         // 1组第13次温度记录
    private Float a14;         // 1组第14次温度记录
    private Float b1;          // 2组第1次温度记录
    private Float b2;          // 2组第2次温度记录
    private Float b3;          // 2组第3次温度记录
    private Float b4;          // 2组第4次温度记录
    private Float b5;          // 2组第5次温度记录
    private Float b6;          // 2组第6次温度记录
    private Float b7;          // 2组第7次温度记录
    private Float b8;          // 2组第8次温度记录
    private Float b9;          // 2组第9次温度记录
    private Float b10;         // 2组第10次温度记录
    private Float b11;         // 2组第11次温度记录
    private Float b12;         // 2组第12次温度记录
    private Float b13;         // 2组第13次温度记录
    private Float b14;         // 2组第14次温度记录
    private Float dqyq;        // 大气压强（kPa）
    private Float qyxzz;       // 气压修正值（℃）
    private Float sdcz1;       // 闪点测值1
    private Float sdcz2;       // 闪点测值2
    private Float sdpjz;       // 闪点平均值
    private Float sdxcz;       // 闪点修正值
    private Float rdcz1;       // 燃点测值1
    private Float rdcz2;       // 燃点测值2
    private Float rdpjz;       // 燃点平均值
    private Float rdxcz;       // 燃点修正值
    private String fjsm;       // 附加声明
    private String position;   // 地点
    private String userid;     // 采集人员编号


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date syjcrq;//试验检测日期

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date scrq;// 生产日期

    //计算闪点平均值
    public void setSdpjz(){
        this.sdpjz=(sdcz1+sdcz2)/2;
    }

    public void setRdpjz() {
        this.rdpjz = (rdcz1 + rdcz2) / 2;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJcdwmc() {
        return jcdwmc;
    }

    public void setJcdwmc(String jcdwmc) {
        this.jcdwmc = jcdwmc;
    }

    public String getJlbh() {
        return jlbh;
    }

    public void setJlbh(String jlbh) {
        this.jlbh = jlbh;
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

    public String getGcbw() {
        return gcbw;
    }

    public void setGcbw(String gcbw) {
        this.gcbw = gcbw;
    }

    public String getYpxx() {
        return ypxx;
    }

    public void setYpxx(String ypxx) {
        this.ypxx = ypxx;
    }

    public String getSytj() {
        return sytj;
    }

    public void setSytj(String sytj) {
        this.sytj = sytj;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getXdsd() {
        return xdsd;
    }

    public void setXdsd(String xdsd) {
        this.xdsd = xdsd;
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

    public String getZyyqsbmchbh() {
        return zyyqsbmchbh;
    }

    public void setZyyqsbmchbh(String zyyqsbmchbh) {
        this.zyyqsbmchbh = zyyqsbmchbh;
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

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getSycs() {
        return sycs;
    }

    public void setSycs(String sycs) {
        this.sycs = sycs;
    }

    public Float getCswd1() {
        return cswd1;
    }

    public void setCswd1(Float cswd1) {
        this.cswd1 = cswd1;
    }

    public Float getCswd2() {
        return cswd2;
    }

    public void setCswd2(Float cswd2) {
        this.cswd2 = cswd2;
    }

    public Float getA1() {
        return a1;
    }

    public void setA1(Float a1) {
        this.a1 = a1;
    }

    public Float getA2() {
        return a2;
    }

    public void setA2(Float a2) {
        this.a2 = a2;
    }

    public Float getA3() {
        return a3;
    }

    public void setA3(Float a3) {
        this.a3 = a3;
    }

    public Float getA4() {
        return a4;
    }

    public void setA4(Float a4) {
        this.a4 = a4;
    }

    public Float getA5() {
        return a5;
    }

    public void setA5(Float a5) {
        this.a5 = a5;
    }

    public Float getA6() {
        return a6;
    }

    public void setA6(Float a6) {
        this.a6 = a6;
    }

    public Float getA7() {
        return a7;
    }

    public void setA7(Float a7) {
        this.a7 = a7;
    }

    public Float getA8() {
        return a8;
    }

    public void setA8(Float a8) {
        this.a8 = a8;
    }

    public Float getA9() {
        return a9;
    }

    public void setA9(Float a9) {
        this.a9 = a9;
    }

    public Float getA10() {
        return a10;
    }

    public void setA10(Float a10) {
        this.a10 = a10;
    }

    public Float getA11() {
        return a11;
    }

    public void setA11(Float a11) {
        this.a11 = a11;
    }

    public Float getA12() {
        return a12;
    }

    public void setA12(Float a12) {
        this.a12 = a12;
    }

    public Float getA13() {
        return a13;
    }

    public void setA13(Float a13) {
        this.a13 = a13;
    }

    public Float getA14() {
        return a14;
    }

    public void setA14(Float a14) {
        this.a14 = a14;
    }

    public Float getB1() {
        return b1;
    }

    public void setB1(Float b1) {
        this.b1 = b1;
    }

    public Float getB2() {
        return b2;
    }

    public void setB2(Float b2) {
        this.b2 = b2;
    }

    public Float getB3() {
        return b3;
    }

    public void setB3(Float b3) {
        this.b3 = b3;
    }

    public Float getB4() {
        return b4;
    }

    public void setB4(Float b4) {
        this.b4 = b4;
    }

    public Float getB5() {
        return b5;
    }

    public void setB5(Float b5) {
        this.b5 = b5;
    }

    public Float getB6() {
        return b6;
    }

    public void setB6(Float b6) {
        this.b6 = b6;
    }

    public Float getB7() {
        return b7;
    }

    public void setB7(Float b7) {
        this.b7 = b7;
    }

    public Float getB8() {
        return b8;
    }

    public void setB8(Float b8) {
        this.b8 = b8;
    }

    public Float getB9() {
        return b9;
    }

    public void setB9(Float b9) {
        this.b9 = b9;
    }

    public Float getB10() {
        return b10;
    }

    public void setB10(Float b10) {
        this.b10 = b10;
    }

    public Float getB11() {
        return b11;
    }

    public void setB11(Float b11) {
        this.b11 = b11;
    }

    public Float getB12() {
        return b12;
    }

    public void setB12(Float b12) {
        this.b12 = b12;
    }

    public Float getB13() {
        return b13;
    }

    public void setB13(Float b13) {
        this.b13 = b13;
    }

    public Float getB14() {
        return b14;
    }

    public void setB14(Float b14) {
        this.b14 = b14;
    }

    public Float getDqyq() {
        return dqyq;
    }

    public void setDqyq(Float dqyq) {
        this.dqyq = dqyq;
    }

    public Float getQyxzz() {
        return qyxzz;
    }

    public void setQyxzz(Float qyxzz) {
        this.qyxzz = qyxzz;
    }

    public Float getSdcz1() {
        return sdcz1;
    }

    public void setSdcz1(Float sdcz1) {
        this.sdcz1 = sdcz1;
    }

    public Float getSdcz2() {
        return sdcz2;
    }

    public void setSdcz2(Float sdcz2) {
        this.sdcz2 = sdcz2;
    }

    public Float getSdpjz() {
        return sdpjz;
    }

    public void setSdpjz(Float sdpjz) {
        this.sdpjz = sdpjz;
    }

    public Float getSdxcz() {
        return sdxcz;
    }

    public void setSdxcz(Float sdxcz) {
        this.sdxcz = sdxcz;
    }

    public Float getRdcz1() {
        return rdcz1;
    }

    public void setRdcz1(Float rdcz1) {
        this.rdcz1 = rdcz1;
    }

    public Float getRdcz2() {
        return rdcz2;
    }

    public void setRdcz2(Float rdcz2) {
        this.rdcz2 = rdcz2;
    }

    public Float getRdpjz() {
        return rdpjz;
    }

    public void setRdpjz(Float rdpjz) {
        this.rdpjz =rdpjz;
    }

    public Float getRdxcz() {
        return rdxcz;
    }

    public void setRdxcz(Float rdxcz) {
        this.rdxcz = rdxcz;
    }

    public String getFjsm() {
        return fjsm;
    }

    public void setFjsm(String fjsm) {
        this.fjsm = fjsm;
    }

    public Date getSyjcrq() {
        return syjcrq;
    }

    public void setSyjcrq(Date syjcrq) {
        this.syjcrq = syjcrq;
    }

    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }

    @Override
    public String toString() {
        return "CL11{" +
                "id=" + id +
                ", jcdwmc='" + jcdwmc + '\'' +
                ", jlbh='" + jlbh + '\'' +
                ", gcmc='" + gcmc + '\'' +
                ", htd='" + htd + '\'' +
                ", sgdw='" + sgdw + '\'' +
                ", jldw='" + jldw + '\'' +
                ", gcbw='" + gcbw + '\'' +
                ", ypxx='" + ypxx + '\'' +
                ", sytj='" + sytj + '\'' +
                ", wd='" + wd + '\'' +
                ", xdsd='" + xdsd + '\'' +
                ", jcyj='" + jcyj + '\'' +
                ", pdyj='" + pdyj + '\'' +
                ", zyyqsbmchbh='" + zyyqsbmchbh + '\'' +
                ", lqzl='" + lqzl + '\'' +
                ", lqbh='" + lqbh + '\'' +
                ", sccj='" + sccj + '\'' +
                ", ph='" + ph + '\'' +
                ", sycs='" + sycs + '\'' +
                ", cswd1=" + cswd1 +
                ", cswd2=" + cswd2 +
                ", a1=" + a1 +
                ", a2=" + a2 +
                ", a3=" + a3 +
                ", a4=" + a4 +
                ", a5=" + a5 +
                ", a6=" + a6 +
                ", a7=" + a7 +
                ", a8=" + a8 +
                ", a9=" + a9 +
                ", a10=" + a10 +
                ", a11=" + a11 +
                ", a12=" + a12 +
                ", a13=" + a13 +
                ", a14=" + a14 +
                ", b1=" + b1 +
                ", b2=" + b2 +
                ", b3=" + b3 +
                ", b4=" + b4 +
                ", b5=" + b5 +
                ", b6=" + b6 +
                ", b7=" + b7 +
                ", b8=" + b8 +
                ", b9=" + b9 +
                ", b10=" + b10 +
                ", b11=" + b11 +
                ", b12=" + b12 +
                ", b13=" + b13 +
                ", b14=" + b14 +
                ", dqyq=" + dqyq +
                ", qyxzz=" + qyxzz +
                ", sdcz1=" + sdcz1 +
                ", sdcz2=" + sdcz2 +
                ", sdpjz=" + sdpjz +
                ", sdxcz=" + sdxcz +
                ", rdcz1=" + rdcz1 +
                ", rdcz2=" + rdcz2 +
                ", rdpjz=" + rdpjz +
                ", rdxcz=" + rdxcz +
                ", fjsm='" + fjsm + '\'' +
                ", syjcrq=" + syjcrq +
                ", scrq=" + scrq +
                '}';
    }
}