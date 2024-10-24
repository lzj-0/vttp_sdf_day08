package day08;
import java.util.Date;

public class Product {
    private Long id;
    private String prodName;
    private String prodDesc;
    private String prodCategory;
    private Float price;
    private Date createdDate;
    private static Long COUNTER = (long) 1;

    public Product(String prodName, String prodDesc, String prodCategory, Float price) {
        this.id = COUNTER;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodCategory = prodCategory;
        this.price = price;
        this.createdDate = new Date();
        COUNTER++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(String prodCategory) {
        this.prodCategory = prodCategory;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodCategory="
                + prodCategory + ", createdDate=" + createdDate + "]";
    }

    
}
