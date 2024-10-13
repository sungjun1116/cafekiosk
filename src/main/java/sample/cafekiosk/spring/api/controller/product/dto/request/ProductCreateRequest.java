package sample.cafekiosk.spring.api.controller.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import sample.cafekiosk.spring.api.service.product.request.ProductCreateServiceRequest;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

public record ProductCreateRequest(
    @NotNull(message = "상품 타입은 필수입니다.")
    ProductType type,

    @NotNull(message = "상품 판매상태는 필수입니다.")
    ProductSellingStatus sellingStatus,

    @NotBlank(message = "상품 이름은 필수입니다.")
    String name,

    @Positive(message = "상품 가격은 양수여야 합니다.")
    int price
) {
    public ProductCreateServiceRequest toServiceRequest() {
        return ProductCreateServiceRequest.builder()
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

        public ProductCreateRequest build() {
            return new ProductCreateRequest(type, sellingStatus, name, price);
        }
    }
}
