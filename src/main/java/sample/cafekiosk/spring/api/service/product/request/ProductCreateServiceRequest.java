package sample.cafekiosk.spring.api.service.product.request;

import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

public record ProductCreateServiceRequest(
    ProductType type,
    ProductSellingStatus sellingStatus,
    String name,
    int price
) {
    public Product toEntity(String nextProductNumber) {
        return Product.builder()
            .productNumber(nextProductNumber)
            .type(type)
            .sellingStatus(sellingStatus)
            .name(name)
            .price(price)
            .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ProductType type;
        private ProductSellingStatus sellingStatus;
        private String name;
        private int price;

        public Builder type(ProductType type) {
            this.type = type;
            return this;
        }

        public Builder sellingStatus(ProductSellingStatus sellingStatus) {
            this.sellingStatus = sellingStatus;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public ProductCreateServiceRequest build() {
            return new ProductCreateServiceRequest(type, sellingStatus, name, price);
        }
    }
}
