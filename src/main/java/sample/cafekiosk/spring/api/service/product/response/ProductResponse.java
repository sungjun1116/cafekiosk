package sample.cafekiosk.spring.api.service.product.response;

import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

public record ProductResponse(
        Long id,
        String productNumber,
        ProductType type,
        ProductSellingStatus sellingStatus,
        String name,
        int price
) {
    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .productNumber(product.getProductNumber())
                .type(product.getType())
                .sellingStatus(product.getSellingStatus())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String productNumber;
        private ProductType type;
        private ProductSellingStatus sellingStatus;
        private String name;
        private int price;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder productNumber(String productNumber) {
            this.productNumber = productNumber;
            return this;
        }

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

        public ProductResponse build() {
            return new ProductResponse(null, productNumber, type, sellingStatus, name, price);
        }
    }

}
