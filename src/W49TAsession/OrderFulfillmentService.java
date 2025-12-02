package W49TAsession;

class Order {
    private final String orderId;
    private double subtotal;

    public Order(String orderId) {
        this.orderId = orderId;
        this.subtotal = 100.00;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getSubtotal() {
        return subtotal;
    }
}


class Shipment {
    private final Order order;

    public Shipment(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}


interface DeliveryMethod {
    String getName();
}

class StandardDelivery implements DeliveryMethod {
    @Override
    public String getName() {
        return "Standard Delivery";
    }
}

class ExpressDelivery implements DeliveryMethod {
    @Override
    public String getName() {
        return "Express Delivery";
    }
}


class Warehouse {
    public static Order pickItems(String orderId) {
        System.out.println("Warehouse: picking items for order " + orderId);
        return new Order(orderId);
    }
}


class SupplierGateway {
    public static void ensureStock(Order order) {
        System.out.println("SupplierGateway: ensuring stock from suppliers for order " + order.getOrderId());
    }
}


class PackagingService {
    public static Shipment pack(Order order) {
        System.out.println("PackagingService: packing order " + order.getOrderId());
        return new Shipment(order);
    }
}


class TaxCalculator {
    public static double calculateTax(Order order) {
        double tax = order.getSubtotal() * 0.25;
        System.out.println("TaxCalculator: calculated tax " + tax + " for order " + order.getOrderId());
        return tax;
    }
}


class PaymentProcessor {
    public static void charge(Order order, double totalAmount) {
        System.out.println("PaymentProcessor: charging " + totalAmount + " for order " + order.getOrderId());
    }
}


class DeliveryService {
    public static String scheduleDelivery(Shipment pack, DeliveryMethod method) {
        String trackingId = "TRK-" + pack.getOrder().getOrderId() + "-" + method.getName().replace(" ", "_");
        System.out.println("DeliveryService: scheduling " + method.getName() + " for order " + pack.getOrder().getOrderId() + " with tracking ID " + trackingId);
        return trackingId;
    }
}


public class OrderFulfillmentService {
    public static String processOrder(String orderId, String deliveryType) {
        Order order = Warehouse.pickItems(orderId);
        SupplierGateway.ensureStock(order);
        Shipment pack = PackagingService.pack(order);

        double tax = TaxCalculator.calculateTax(order);
        double total = order.getSubtotal() + tax;

        PaymentProcessor.charge(order, total);
        DeliveryMethod deliveryMethod;
        if ("express".equalsIgnoreCase(deliveryType)) {
            deliveryMethod = new ExpressDelivery();
        } else {
            deliveryMethod = new StandardDelivery();
        }

        String trackingId = DeliveryService.scheduleDelivery(pack, deliveryMethod);
        return trackingId;
    }

    private static void saveTrackingInfo(String trackingId) {
        System.out.println("Application: saving tracking info: " + trackingId);
    }

    public static void main(String[] args) {
        String trackingId = processOrder("ORDER-12345", "express");
        saveTrackingInfo(trackingId);
    }
}