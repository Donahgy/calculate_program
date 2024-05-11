package entity.merchandistype;

import entity.merchandise.Merchandise;

import java.util.List;

/**
 *  商品类别
 */
public class MerchandiseType {

    // 类别名称
    private String merchandiseName;

    private List<Merchandise> merchandiseInfo;

    public MerchandiseType() {
    }

    public MerchandiseType(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }

    public String getMerchandiseName() {
        return merchandiseName;
    }

    public void setMerchandiseName(String merchandiseName) {
        this.merchandiseName = merchandiseName;
    }
}
