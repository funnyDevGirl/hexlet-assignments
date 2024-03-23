package exercise.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductCreateDTO {
    private String title;
    private int price;
    private long vendorCode;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(long vendorCode) {
        this.vendorCode = vendorCode;
    }
}
