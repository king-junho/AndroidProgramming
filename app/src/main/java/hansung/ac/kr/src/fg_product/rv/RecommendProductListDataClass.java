package hansung.ac.kr.src.fg_product.rv;

import java.io.Serializable;

public class RecommendProductListDataClass implements Serializable {
    private int title_image;
    private int image_1;
    private int image_2;
    private int image_3;
    private String title;

    public RecommendProductListDataClass(int title_image, int image_1, int image_2, int image_3, String title) {
        this.title_image = title_image;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.title = title;
    }

    public int getTitle_image() {
        return title_image;
    }

    public void setTitle_image(int title_image) {
        this.title_image = title_image;
    }

    public int getImage_1() {
        return image_1;
    }

    public void setImage_1(int image_1) {
        this.image_1 = image_1;
    }

    public int getImage_2() {
        return image_2;
    }

    public void setImage_2(int image_2) {
        this.image_2 = image_2;
    }

    public int getImage_3() {
        return image_3;
    }

    public void setImage_3(int image_3) {
        this.image_3 = image_3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
