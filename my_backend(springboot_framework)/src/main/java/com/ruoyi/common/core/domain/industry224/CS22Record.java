package com.ruoyi.common.core.domain.industry224;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ruoyi.common.core.domain.BaseEntity;

/*
* 路面混凝土配合比设计试验检测记录表（二）
* 砼试表CS22
* */
import java.util.Date;
// 路面混凝土配合比设计试验检测记录表（二）
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CS22Record extends BaseEntity {
    private  int id;
    private String jcdwmc ; // 检测单位名称
    private String jlbh ; // 记录编号
    private String gcmc ; // 工程名称
    private String htd ; // 合同段
    private String sgdw ; // 施工单位
    private String jldw ; // 监理单位
    private String gcbwyt ; // 工程部位/用途
    private String ypxx ; // 样品信息

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date syjcrq ; // 试验检测日期


    // 自己搞
    private float sytj_wd ; // 实验条件_温度
    private float sytj_sd ; // 实验条件_湿度

    private String csyj ; // 测试依据
    private String pdyj ; // 判定依据
    private String zyyjsbmcjbh ; //主要仪器设备名称和编号
    private String sbhntxnphb ; //试扮混泥土性能,提出试伴配合比
    private int dld_A1 ; // 坍落度a1
    private int dld_A2 ; // 坍落度a2
    private float dld_A ; // 坍落度a

    private int kzd_B1 ; // 扩展度b1
    private int kzd_B2 ; // 扩展度b2
    private float kzd_B ; // 扩展度b
    private String tbhw_gd ; // 砼拌合物_棍度
    private String tbhw_hsqk ; // 砼拌合物_含沙情况
    private String tbhw_njx ; // 砼拌合物_粘聚性
    private String tbhw_bsx ; // 砼拌合物_保水性

    private String bz ; // 备注
    private float sjb_C ; // 水胶比
    private float t_tzl_D1 ; // 筒+砼质量1
    private float t_tzl_D2 ; // 筒+砼质量2
    private float t_zl_E1 ; // 筒质量1
    private float t_zl_E2 ; // 桶质量2
    private float t_zl_F1 ; // 砼质量1
    private float t_zl_F2 ; // 砼质量2
    private float t_rj_G1 ; // 筒容积1
    private float t_rj_G2 ; // 筒容积2
    private float scbgmd_dz_H1 ; // 实测表观密度单值1
    private float scbgmd_dz_H2 ; // 实测表观密度单值2
    private float scbgmd_dz_H ; // 实测表观密度平均值
    private float bjmdjsz_p ; // 表观密度计算值
    private float phjjzxs_sigma ; // 配合比较正系数sigma
    private String sbpb_1 ; // 试板配比1
    private String sbpb_2 ; // 试板配比2
    private float jjsjb ; // 基准水胶比
    private String sjjsff ; // 设计计算方法
    private int jdmd ; // 假定密度
    private float sjb_I1 ; // 水胶比1
    private float sjb_I2 ; // 水胶比2
    private float sn_J1 ; // 水泥1
    private float sn_J2 ; // 水泥2
    private float xjl_K1 ; // 细集料1
    private float xjl_K2 ; // 细集料2
    private float cjl_L1 ; // 粗集料1
    private float cjl_L2 ; // 粗集料2
    private float s_M1 ; // 水1
    private float s_M2 ; // 水2
    private String wjj_mc1 ; // 外加剂名称1
    private float wjjzlmc1_N1 ; // 外加剂1质量1
    private float wjjzlmc1_N2 ; // 外加剂1质量2
    private String wjj_mc2 ; // 外加剂名称2
    private float wjjzlmc2_O1 ; // 外加剂2质量1
    private float wjjzlmc2_O2 ; // 外加剂2质量2
    private String kwchl_mc1 ; // 矿物掺和料名称1
    private float kwchlmc1_P1 ; // 矿物掺和料名称1质量1
    private float kwchlmc1_P2 ; // 矿物掺和料名称1质量2
    private String kwchl_mc2 ; // 矿物掺和料名称2
    private float kwchlmc2_Q1 ; // 矿物掺和料名称2质量1
    private float kwchlmc2_Q2 ; // 矿物掺和料名称2质量2
    private float sl_R1 ; // 砂率1
    private float sl_R2 ;// 砂率2

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

    public String getGcbwyt() {
        return gcbwyt;
    }

    public void setGcbwyt(String gcbwyt) {
        this.gcbwyt = gcbwyt;
    }

    public String getYpxx() {
        return ypxx;
    }

    public void setYpxx(String ypxx) {
        this.ypxx = ypxx;
    }

    public Date getSyjcrq() {
        return syjcrq;
    }

    public void setSyjcrq(Date syjcrq) {
        this.syjcrq = syjcrq;
    }

    public float getSytj_wd() {
        return sytj_wd;
    }

    public void setSytj_wd(float sytj_wd) {
        this.sytj_wd = sytj_wd;
    }

    public float getSytj_sd() {
        return sytj_sd;
    }

    public void setSytj_sd(float sytj_sd) {
        this.sytj_sd = sytj_sd;
    }

    public String getCsyj() {
        return csyj;
    }

    public void setCsyj(String csyj) {
        this.csyj = csyj;
    }

    public String getPdyj() {
        return pdyj;
    }

    public void setPdyj(String pdyj) {
        this.pdyj = pdyj;
    }

    public String getZyyjsbmcjbh() {
        return zyyjsbmcjbh;
    }

    public void setZyyjsbmcjbh(String zyyjsbmcjbh) {
        this.zyyjsbmcjbh = zyyjsbmcjbh;
    }

    public String getSbhntxnphb() {
        return sbhntxnphb;
    }

    public void setSbhntxnphb(String sbhntxnphb) {
        this.sbhntxnphb = sbhntxnphb;
    }

    public int getDld_A1() {
        return dld_A1;
    }

    public void setDld_A1(int dld_A1) {
        this.dld_A1 = dld_A1;
    }

    public int getDld_A2() {
        return dld_A2;
    }

    public void setDld_A2(int dld_A2) {
        this.dld_A2 = dld_A2;
    }

    public float getDld_A() {
        return dld_A;
    }

    public void setDld_A(float dld_A) {
        this.dld_A = dld_A;
    }

    public int getKzd_B1() {
        return kzd_B1;
    }

    public void setKzd_B1(int kzd_B1) {
        this.kzd_B1 = kzd_B1;
    }

    public int getKzd_B2() {
        return kzd_B2;
    }

    public void setKzd_B2(int kzd_B2) {
        this.kzd_B2 = kzd_B2;
    }

    public float getKzd_B() {
        return kzd_B;
    }

    public void setKzd_B(float kzd_B) {
        this.kzd_B = kzd_B;
    }

    public String getTbhw_gd() {
        return tbhw_gd;
    }

    public void setTbhw_gd(String tbhw_gd) {
        this.tbhw_gd = tbhw_gd;
    }

    public String getTbhw_hsqk() {
        return tbhw_hsqk;
    }

    public void setTbhw_hsqk(String tbhw_hsqk) {
        this.tbhw_hsqk = tbhw_hsqk;
    }

    public String getTbhw_njx() {
        return tbhw_njx;
    }

    public void setTbhw_njx(String tbhw_njx) {
        this.tbhw_njx = tbhw_njx;
    }

    public String getTbhw_bsx() {
        return tbhw_bsx;
    }

    public void setTbhw_bsx(String tbhw_bsx) {
        this.tbhw_bsx = tbhw_bsx;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public float getSjb_C() {
        return sjb_C;
    }

    public void setSjb_C(float sjb_C) {
        this.sjb_C = sjb_C;
    }

    public float getT_tzl_D1() {
        return t_tzl_D1;
    }

    public void setT_tzl_D1(float t_tzl_D1) {
        this.t_tzl_D1 = t_tzl_D1;
    }

    public float getT_tzl_D2() {
        return t_tzl_D2;
    }

    public void setT_tzl_D2(float t_tzl_D2) {
        this.t_tzl_D2 = t_tzl_D2;
    }

    public float getT_zl_E1() {
        return t_zl_E1;
    }

    public void setT_zl_E1(float t_zl_E1) {
        this.t_zl_E1 = t_zl_E1;
    }

    public float getT_zl_E2() {
        return t_zl_E2;
    }

    public void setT_zl_E2(float t_zl_E2) {
        this.t_zl_E2 = t_zl_E2;
    }

    public float getT_zl_F1() {
        return t_zl_F1;
    }

    public void setT_zl_F1(float t_zl_F1) {
        this.t_zl_F1 = t_zl_F1;
    }

    public float getT_zl_F2() {
        return t_zl_F2;
    }

    public void setT_zl_F2(float t_zl_F2) {
        this.t_zl_F2 = t_zl_F2;
    }

    public float getT_rj_G1() {
        return t_rj_G1;
    }

    public void setT_rj_G1(float t_rj_G1) {
        this.t_rj_G1 = t_rj_G1;
    }

    public float getT_rj_G2() {
        return t_rj_G2;
    }

    public void setT_rj_G2(float t_rj_G2) {
        this.t_rj_G2 = t_rj_G2;
    }

    public float getScbgmd_dz_H1() {
        return scbgmd_dz_H1;
    }

    public void setScbgmd_dz_H1(float scbgmd_dz_H1) {
        this.scbgmd_dz_H1 = scbgmd_dz_H1;
    }

    public float getScbgmd_dz_H2() {
        return scbgmd_dz_H2;
    }

    public void setScbgmd_dz_H2(float scbgmd_dz_H2) {
        this.scbgmd_dz_H2 = scbgmd_dz_H2;
    }

    public float getScbgmd_dz_H() {
        return scbgmd_dz_H;
    }

    public void setScbgmd_dz_H(float scbgmd_dz_H) {
        this.scbgmd_dz_H = scbgmd_dz_H;
    }

    public float getBjmdjsz_p() {
        return bjmdjsz_p;
    }

    public void setBjmdjsz_p(float bjmdjsz_p) {
        this.bjmdjsz_p = bjmdjsz_p;
    }

    public float getPhjjzxs_sigma() {
        return phjjzxs_sigma;
    }

    public void setPhjjzxs_sigma(float phjjzxs_sigma) {
        this.phjjzxs_sigma = phjjzxs_sigma;
    }

    public String getSbpb_1() {
        return sbpb_1;
    }

    public void setSbpb_1(String sbpb_1) {
        this.sbpb_1 = sbpb_1;
    }

    public String getSbpb_2() {
        return sbpb_2;
    }

    public void setSbpb_2(String sbpb_2) {
        this.sbpb_2 = sbpb_2;
    }

    public float getJjsjb() {
        return jjsjb;
    }

    public void setJjsjb(float jjsjb) {
        this.jjsjb = jjsjb;
    }

    public String getSjjsff() {
        return sjjsff;
    }

    public void setSjjsff(String sjjsff) {
        this.sjjsff = sjjsff;
    }

    public int getJdmd() {
        return jdmd;
    }

    public void setJdmd(int jdmd) {
        this.jdmd = jdmd;
    }

    public float getSjb_I1() {
        return sjb_I1;
    }

    public void setSjb_I1(float sjb_I1) {
        this.sjb_I1 = sjb_I1;
    }

    public float getSjb_I2() {
        return sjb_I2;
    }

    public void setSjb_I2(float sjb_I2) {
        this.sjb_I2 = sjb_I2;
    }

    public float getSn_J1() {
        return sn_J1;
    }

    public void setSn_J1(float sn_J1) {
        this.sn_J1 = sn_J1;
    }

    public float getSn_J2() {
        return sn_J2;
    }

    public void setSn_J2(float sn_J2) {
        this.sn_J2 = sn_J2;
    }

    public float getXjl_K1() {
        return xjl_K1;
    }

    public void setXjl_K1(float xjl_K1) {
        this.xjl_K1 = xjl_K1;
    }

    public float getXjl_K2() {
        return xjl_K2;
    }

    public void setXjl_K2(float xjl_K2) {
        this.xjl_K2 = xjl_K2;
    }

    public float getCjl_L1() {
        return cjl_L1;
    }

    public void setCjl_L1(float cjl_L1) {
        this.cjl_L1 = cjl_L1;
    }

    public float getCjl_L2() {
        return cjl_L2;
    }

    public void setCjl_L2(float cjl_L2) {
        this.cjl_L2 = cjl_L2;
    }

    public float getS_M1() {
        return s_M1;
    }

    public void setS_M1(float s_M1) {
        this.s_M1 = s_M1;
    }

    public float getS_M2() {
        return s_M2;
    }

    public void setS_M2(float s_M2) {
        this.s_M2 = s_M2;
    }

    public String getWjj_mc1() {
        return wjj_mc1;
    }

    public void setWjj_mc1(String wjj_mc1) {
        this.wjj_mc1 = wjj_mc1;
    }

    public float getWjjzlmc1_N1() {
        return wjjzlmc1_N1;
    }

    public void setWjjzlmc1_N1(float wjjzlmc1_N1) {
        this.wjjzlmc1_N1 = wjjzlmc1_N1;
    }

    public float getWjjzlmc1_N2() {
        return wjjzlmc1_N2;
    }

    public void setWjjzlmc1_N2(float wjjzlmc1_N2) {
        this.wjjzlmc1_N2 = wjjzlmc1_N2;
    }

    public String getWjj_mc2() {
        return wjj_mc2;
    }

    public void setWjj_mc2(String wjj_mc2) {
        this.wjj_mc2 = wjj_mc2;
    }

    public float getWjjzlmc2_O1() {
        return wjjzlmc2_O1;
    }

    public void setWjjzlmc2_O1(float wjjzlmc2_O1) {
        this.wjjzlmc2_O1 = wjjzlmc2_O1;
    }

    public float getWjjzlmc2_O2() {
        return wjjzlmc2_O2;
    }

    public void setWjjzlmc2_O2(float wjjzlmc2_O2) {
        this.wjjzlmc2_O2 = wjjzlmc2_O2;
    }

    public String getKwchl_mc1() {
        return kwchl_mc1;
    }

    public void setKwchl_mc1(String kwchl_mc1) {
        this.kwchl_mc1 = kwchl_mc1;
    }

    public float getKwchlmc1_P1() {
        return kwchlmc1_P1;
    }

    public void setKwchlmc1_P1(float kwchlmc1_P1) {
        this.kwchlmc1_P1 = kwchlmc1_P1;
    }

    public float getKwchlmc1_P2() {
        return kwchlmc1_P2;
    }

    public void setKwchlmc1_P2(float kwchlmc1_P2) {
        this.kwchlmc1_P2 = kwchlmc1_P2;
    }

    public String getKwchl_mc2() {
        return kwchl_mc2;
    }

    public void setKwchl_mc2(String kwchl_mc2) {
        this.kwchl_mc2 = kwchl_mc2;
    }

    public float getKwchlmc2_Q1() {
        return kwchlmc2_Q1;
    }

    public void setKwchlmc2_Q1(float kwchlmc2_Q1) {
        this.kwchlmc2_Q1 = kwchlmc2_Q1;
    }

    public float getKwchlmc2_Q2() {
        return kwchlmc2_Q2;
    }

    public void setKwchlmc2_Q2(float kwchlmc2_Q2) {
        this.kwchlmc2_Q2 = kwchlmc2_Q2;
    }

    public float getSl_R1() {
        return sl_R1;
    }

    public void setSl_R1(float sl_R1) {
        this.sl_R1 = sl_R1;
    }

    public float getSl_R2() {
        return sl_R2;
    }

    public void setSl_R2(float sl_R2) {
        this.sl_R2 = sl_R2;
    }

    @Override
    public String toString() {
        return "CS22Record{" +
                "id=" + id +
                ", jcdwmc='" + jcdwmc + '\'' +
                ", jlbh='" + jlbh + '\'' +
                ", gcmc='" + gcmc + '\'' +
                ", htd='" + htd + '\'' +
                ", sgdw='" + sgdw + '\'' +
                ", jldw='" + jldw + '\'' +
                ", gcbwyt='" + gcbwyt + '\'' +
                ", ypxx='" + ypxx + '\'' +
                ", syjcrq=" + syjcrq +
                ", sytj_wd=" + sytj_wd +
                ", sytj_sd=" + sytj_sd +
                ", csyj='" + csyj + '\'' +
                ", pdyj='" + pdyj + '\'' +
                ", zyyjsbmcjbh='" + zyyjsbmcjbh + '\'' +
                ", sbhntxnphb='" + sbhntxnphb + '\'' +
                ", dld_A1=" + dld_A1 +
                ", dld_A2=" + dld_A2 +
                ", dld_A=" + dld_A +
                ", kzd_B1=" + kzd_B1 +
                ", kzd_B2=" + kzd_B2 +
                ", kzd_B=" + kzd_B +
                ", tbhw_gd='" + tbhw_gd + '\'' +
                ", tbhw_hsqk='" + tbhw_hsqk + '\'' +
                ", tbhw_njx='" + tbhw_njx + '\'' +
                ", tbhw_bsx='" + tbhw_bsx + '\'' +
                ", bz='" + bz + '\'' +
                ", sjb_C=" + sjb_C +
                ", t_tzl_D1=" + t_tzl_D1 +
                ", t_tzl_D2=" + t_tzl_D2 +
                ", t_zl_E1=" + t_zl_E1 +
                ", t_zl_E2=" + t_zl_E2 +
                ", t_zl_F1=" + t_zl_F1 +
                ", t_zl_F2=" + t_zl_F2 +
                ", t_rj_G1=" + t_rj_G1 +
                ", t_rj_G2=" + t_rj_G2 +
                ", scbgmd_dz_H1=" + scbgmd_dz_H1 +
                ", scbgmd_dz_H2=" + scbgmd_dz_H2 +
                ", scbgmd_dz_H=" + scbgmd_dz_H +
                ", bjmdjsz_p=" + bjmdjsz_p +
                ", phjjzxs_sigma=" + phjjzxs_sigma +
                ", sbpb_1='" + sbpb_1 + '\'' +
                ", sbpb_2='" + sbpb_2 + '\'' +
                ", jjsjb=" + jjsjb +
                ", sjjsff='" + sjjsff + '\'' +
                ", jdmd=" + jdmd +
                ", sjb_I1=" + sjb_I1 +
                ", sjb_I2=" + sjb_I2 +
                ", sn_J1=" + sn_J1 +
                ", sn_J2=" + sn_J2 +
                ", xjl_K1=" + xjl_K1 +
                ", xjl_K2=" + xjl_K2 +
                ", cjl_L1=" + cjl_L1 +
                ", cjl_L2=" + cjl_L2 +
                ", s_M1=" + s_M1 +
                ", s_M2=" + s_M2 +
                ", wjj_mc1='" + wjj_mc1 + '\'' +
                ", wjjzlmc1_N1=" + wjjzlmc1_N1 +
                ", wjjzlmc1_N2=" + wjjzlmc1_N2 +
                ", wjj_mc2='" + wjj_mc2 + '\'' +
                ", wjjzlmc2_O1=" + wjjzlmc2_O1 +
                ", wjjzlmc2_O2=" + wjjzlmc2_O2 +
                ", kwchl_mc1='" + kwchl_mc1 + '\'' +
                ", kwchlmc1_P1=" + kwchlmc1_P1 +
                ", kwchlmc1_P2=" + kwchlmc1_P2 +
                ", kwchl_mc2='" + kwchl_mc2 + '\'' +
                ", kwchlmc2_Q1=" + kwchlmc2_Q1 +
                ", kwchlmc2_Q2=" + kwchlmc2_Q2 +
                ", sl_R1=" + sl_R1 +
                ", sl_R2=" + sl_R2 +
                '}';
    }
}
