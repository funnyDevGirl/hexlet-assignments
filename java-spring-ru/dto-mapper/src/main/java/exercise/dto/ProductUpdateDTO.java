package exercise.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductUpdateDTO {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
