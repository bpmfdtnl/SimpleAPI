package zizheng.simpleapi;

import java.util.Objects;

/**
 * @author: billwang
 * @create: 10/5/20
 */
public class Product {

    String productId;
    String title;
    String brandID;
    String brandName;
    String categoryId;
    String categoryName;

    public Product() {
    }

    public Product(String productId, String title, String brandID, String brandName, String categoryId, String categoryName) {
        this.productId = productId;
        this.title = title;
        this.brandID = brandID;
        this.brandName = brandName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", title='" + title + '\'' +
                ", brandID='" + brandID + '\'' +
                ", brandName='" + brandName + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getProductId(), product.getProductId()) &&
                Objects.equals(getTitle(), product.getTitle()) &&
                Objects.equals(getBrandID(), product.getBrandID()) &&
                Objects.equals(getBrandName(), product.getBrandName()) &&
                Objects.equals(getCategoryId(), product.getCategoryId()) &&
                Objects.equals(getCategoryName(), product.getCategoryName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getTitle(), getBrandID(), getBrandName(), getCategoryId(), getCategoryName());
    }
}
