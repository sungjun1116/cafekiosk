package sample.cafekiosk.spring.api.controller.order.request;

import jakarta.validation.constraints.NotEmpty;
import sample.cafekiosk.spring.api.service.order.request.OrderCreateServiceRequest;

import java.util.List;

public record OrderCreateRequest(
    @NotEmpty(message = "상품 번호 리스트는 필수입니다.")
    List<String> productNumbers
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<String> productNumbers;

        public Builder productNumbers(List<String> productNumbers) {
            this.productNumbers = productNumbers;
            return this;
        }

        public OrderCreateRequest build() {
            return new OrderCreateRequest(productNumbers);
        }
    }

    public OrderCreateServiceRequest toServiceRequest() {
        return OrderCreateServiceRequest.builder()
            .productNumbers(productNumbers)
            .build();
    }
}
