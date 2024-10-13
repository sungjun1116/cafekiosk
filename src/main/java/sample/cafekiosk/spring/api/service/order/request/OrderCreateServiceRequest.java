package sample.cafekiosk.spring.api.service.order.request;

import java.util.List;

public record OrderCreateServiceRequest(
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

        public OrderCreateServiceRequest build() {
            return new OrderCreateServiceRequest(productNumbers);
        }

    }
}
