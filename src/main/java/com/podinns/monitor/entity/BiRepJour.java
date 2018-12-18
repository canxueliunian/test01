package com.podinns.monitor.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.podinns.monitor.common.annotion.Excel;
import com.podinns.monitor.common.annotion.ParamBegin;
import com.podinns.monitor.common.annotion.ParamEnd;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author canxue
 * @since 2018-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BiRepJour extends Model<BiRepJour> {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 酒店ID
     */
    private Long hotelId;
    @Excel(name = "code")
    @TableField(exist = false)
    private String ncHotelcode;
    @TableField(exist = false)
    @Excel(name = "店名")
    private String hotelDescript;
    /**
     * 营业日期
     */
    private LocalDateTime bizDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(exist = false)
    @ParamBegin("biz_date")
    private LocalDate bizDateBegin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField(exist = false)
    @ParamEnd("biz_date")
    private LocalDate bizDateEnd;
    /**
     * 酒店房数,06100
     */
    private BigDecimal rmTtl;
    @TableField(exist = false)
    @ParamBegin("rm_ttl")
    private BigDecimal rmTtlStart;
    @TableField(exist = false)
    @ParamEnd("rm_ttl")
    private BigDecimal rmTtlEnd;
    /**
     * 自用房数,06130
     */
    private BigDecimal rmHse;
    @TableField(exist = false)
    @ParamBegin("rm_hse")
    private BigDecimal rmHseStart;
    @TableField(exist = false)
    @ParamEnd("rm_hse")
    private BigDecimal rmHseEnd;
    /**
     * 维修房数,06120
     */
    private BigDecimal rmOoo;
    @TableField(exist = false)
    @ParamBegin("rm_ooo")
    private BigDecimal rmOooStart;
    @TableField(exist = false)
    @ParamEnd("rm_ooo")
    private BigDecimal rmOooEnd;
    /**
     * 可出租房数,06110
     */
    private BigDecimal rmAvl;

    /**
     * 出租客房数,06200
     */
    private BigDecimal rmSold;

    /**
     * 出租率,rm_sold/rm_avl*100
     */
    private BigDecimal rmOcc;
    @TableField(exist = false)
    @ParamBegin("rm_occ")
    private BigDecimal rmOccStart;
    @TableField(exist = false)
    @ParamEnd("rm_occ")
    private BigDecimal rmOccEnd;
    /**
     * 过夜客房数,06210
     */
    private BigDecimal rmStayover;

    /**
     * 过夜出租率,rm_stayover/rm_avl*100
     */
    private BigDecimal rmOccStayover;
    @TableField(exist = false)
    @ParamBegin("rm_occ_stayover")
    private BigDecimal rmOccStayoverStart;
    @TableField(exist = false)
    @ParamEnd("rm_occ_stayover")
    private BigDecimal rmOccStayoverEnd;
    /**
     * 全天房数,06220
     */
    private BigDecimal rmDay;

    /**
     * 钟点房数,06230
     */
    private BigDecimal rmHrs;

    /**
     * 钟点出租率,rm_hrs/rm_avl*100
     */
    private BigDecimal rmOccHrs;
    @TableField(exist = false)
    @ParamBegin("rm_occ_hrs")
    private BigDecimal rmOccHrsStart;
    @TableField(exist = false)
    @ParamEnd("rm_occ_hrs")
    private BigDecimal rmOccHrsEnd;
    /**
     * 平均房价,rev_rm/rm_sold
     */
    private BigDecimal rmAvg;
    @TableField(exist = false)
    @ParamBegin("rm_avg")
    private BigDecimal rmAvgStart;
    @TableField(exist = false)
    @ParamEnd("rm_avg")
    private BigDecimal rmAvgEnd;
    /**
     * 过夜平均房价,rev_rm/rm_stayover
     */
    private BigDecimal rmGyavg;
    @TableField(exist = false)
    @ParamBegin("rm_gyavg")
    private BigDecimal rmGyavgStart;
    @TableField(exist = false)
    @ParamEnd("rm_gyavg")
    private BigDecimal rmGyavgEnd;
    /**
     * 总收入,01000
     */
    private BigDecimal revTtl;
    @TableField(exist = false)
    @ParamBegin("rev_ttl")
    private BigDecimal revTtlStart;
    @TableField(exist = false)
    @ParamEnd("rev_ttl")
    private BigDecimal revTtlEnd;
    /**
     * 客房收入,01030,01040,01050
     */
    private BigDecimal revRm;
    @TableField(exist = false)
    @ParamBegin("rev_rm")
    private BigDecimal revRmStart;
    @TableField(exist = false)
    @ParamEnd("rev_rm")
    private BigDecimal revRmEnd;
    /**
     * 手工房费,01070,01080
     */
    private BigDecimal revSgrm;
    @TableField(exist = false)
    @ParamBegin("rev_sgrm")
    private BigDecimal revSgrmStart;
    @TableField(exist = false)
    @ParamEnd("rev_sgrm")
    private BigDecimal revSgrmEnd;
    /**
     * 钟点房费,01060
     */
    private BigDecimal revHrs;
    @TableField(exist = false)
    @ParamBegin("rev_hrs")
    private BigDecimal revHrsStart;
    @TableField(exist = false)
    @ParamEnd("rev_hrs")
    private BigDecimal revHrsEnd;
    /**
     * 餐饮收入,01801
     */
    private BigDecimal revFb;
    @TableField(exist = false)
    @ParamBegin("rev_fb")
    private BigDecimal revFbStart;
    @TableField(exist = false)
    @ParamEnd("rev_fb")
    private BigDecimal revFbEnd;
    /**
     * 小商品收入,02005
     */
    private BigDecimal revGoods;
    @TableField(exist = false)
    @ParamBegin("rev_goods")
    private BigDecimal revGoodsStart;
    @TableField(exist = false)
    @ParamEnd("rev_goods")
    private BigDecimal revGoodsEnd;
    /**
     * 会员卡费收入,03010,03020,03030,03040,03050,03060
     */
    private BigDecimal revMemKf;
    @TableField(exist = false)
    @ParamBegin("rev_mem_kf")
    private BigDecimal revMemKfStart;
    @TableField(exist = false)
    @ParamEnd("rev_mem_kf")
    private BigDecimal revMemKfEnd;
    /**
     * 会员升级费收入,03070,03080,03090,03100,03110
     */
    private BigDecimal revMemSj;
    @TableField(exist = false)
    @ParamBegin("rev_mem_sj")
    private BigDecimal revMemSjStart;
    @TableField(exist = false)
    @ParamEnd("rev_mem_sj")
    private BigDecimal revMemSjEnd;
    /**
     * 其他杂项,04000
     */
    private BigDecimal revOthZx;

    /**
     * 返现收入,05100
     */
    private BigDecimal revCashback;

    /**
     * 电子券,05200
     */
    private BigDecimal revCoupon;

    /**
     * 其他收入,05300,05400,05500,05600)
     */
    private BigDecimal revOth;

    /**
     * 卡激活数,06900
     */
    private BigDecimal memTtl;

    /**
     * 中介佣金,06710
     */
    @TableField("Intermediary_cms")
    private BigDecimal intermediaryCms;

    /**
     * 抵扣券抵用额,06720
     */
    @TableField("Discount_coupon")
    private BigDecimal discountCoupon;

    /**
     * 钟点卡积分抵用额,06730
     */
    private BigDecimal hrscardPoint;

    /**
     * 其他卡积分抵用额,06740
     */
    private BigDecimal othercardPoint;

    /**
     * 净收入,06910
     */
    private BigDecimal revNet;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
