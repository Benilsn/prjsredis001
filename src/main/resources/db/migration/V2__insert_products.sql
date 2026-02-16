-- =========================================
-- V2 - INSERT TEST PRODUCTS
-- =========================================
CREATE EXTENSION IF NOT EXISTS pgcrypto;

INSERT INTO products (
    id,
    name,
    description,
    price,
    cost_price,
    stock_quantity,
    active,
    rating,
    review_count,
    sku,
    brand,
    category,
    weight,
    height,
    width,
    length,
    created_at,
    updated_at
) VALUES
(gen_random_uuid(), 'Gaming Mouse', 'High precision gaming mouse', 199.90, 120.00, 50, true, 4.5, 120, 'SKU-001', 'LogiTech', 'Electronics', 0.2, 4.0, 6.0, 12.0, now(), now()),
(gen_random_uuid(), 'Mechanical Keyboard', 'RGB mechanical keyboard', 499.90, 300.00, 30, true, 4.8, 220, 'SKU-002', 'HyperX', 'Electronics', 0.9, 3.0, 15.0, 45.0, now(), now()),
(gen_random_uuid(), 'Wireless Headset', 'Noise cancelling headset', 799.90, 500.00, 20, true, 4.6, 150, 'SKU-003', 'Sony', 'Electronics', 0.5, 8.0, 18.0, 20.0, now(), now()),
(gen_random_uuid(), 'Office Chair', 'Ergonomic office chair', 1299.00, 800.00, 10, true, 4.3, 75, 'SKU-004', 'DXRacer', 'Furniture', 12.0, 120.0, 60.0, 60.0, now(), now()),
(gen_random_uuid(), 'Monitor 27"', '4K UHD Monitor', 1899.90, 1200.00, 15, true, 4.7, 95, 'SKU-005', 'Samsung', 'Electronics', 4.5, 40.0, 60.0, 10.0, now(), now()),
(gen_random_uuid(), 'USB-C Hub', 'Multiport USB-C hub', 149.90, 80.00, 100, true, 4.2, 60, 'SKU-006', 'Anker', 'Accessories', 0.1, 2.0, 8.0, 12.0, now(), now()),
(gen_random_uuid(), 'Smartphone Stand', 'Adjustable aluminum stand', 59.90, 20.00, 200, true, 4.1, 45, 'SKU-007', 'Ugreen', 'Accessories', 0.3, 10.0, 8.0, 8.0, now(), now()),
(gen_random_uuid(), 'Laptop Backpack', 'Water resistant backpack', 249.90, 120.00, 40, true, 4.4, 80, 'SKU-008', 'Dell', 'Bags', 0.8, 45.0, 30.0, 15.0, now(), now()),
(gen_random_uuid(), 'External SSD 1TB', 'High speed external SSD', 699.90, 450.00, 25, true, 4.9, 140, 'SKU-009', 'SanDisk', 'Storage', 0.2, 1.0, 5.0, 8.0, now(), now()),
(gen_random_uuid(), 'Webcam HD', '1080p streaming webcam', 299.90, 150.00, 60, true, 4.0, 55, 'SKU-010', 'LogiTech', 'Electronics', 0.15, 5.0, 7.0, 7.0, now(), now()),
(gen_random_uuid(), 'Gaming Laptop', 'High performance gaming laptop', 7999.90, 6000.00, 8, true, 4.9, 310, 'SKU-011', 'Asus', 'Electronics', 2.5, 2.5, 36.0, 25.0, now(), now()),
(gen_random_uuid(), 'Bluetooth Speaker', 'Portable waterproof speaker', 349.90, 180.00, 70, true, 4.6, 190, 'SKU-012', 'JBL', 'Electronics', 0.8, 10.0, 20.0, 8.0, now(), now()),
(gen_random_uuid(), 'Smart Watch', 'Fitness tracking smartwatch', 1299.90, 800.00, 40, true, 4.7, 150, 'SKU-013', 'Apple', 'Wearables', 0.1, 4.0, 4.0, 1.0, now(), now()),
(gen_random_uuid(), 'Desk Lamp', 'LED adjustable desk lamp', 199.90, 90.00, 60, true, 4.2, 60, 'SKU-014', 'Philips', 'Furniture', 1.2, 40.0, 15.0, 15.0, now(), now()),
(gen_random_uuid(), 'Wireless Charger', 'Fast charging pad', 129.90, 60.00, 120, true, 4.3, 85, 'SKU-015', 'Samsung', 'Accessories', 0.2, 1.5, 10.0, 10.0, now(), now()),
(gen_random_uuid(), 'Mechanical Pencil', 'Professional drafting pencil', 19.90, 5.00, 300, true, 4.1, 40, 'SKU-016', 'Faber-Castell', 'Stationery', 0.05, 1.0, 1.0, 15.0, now(), now()),
(gen_random_uuid(), 'Office Desk', 'Wood office desk', 999.90, 600.00, 12, true, 4.5, 55, 'SKU-017', 'Ikea', 'Furniture', 20.0, 75.0, 120.0, 60.0, now(), now()),
(gen_random_uuid(), 'Gaming Chair', 'Premium ergonomic gaming chair', 1899.90, 1200.00, 6, true, 4.8, 130, 'SKU-018', 'Secretlab', 'Furniture', 22.0, 130.0, 70.0, 70.0, now(), now()),
(gen_random_uuid(), 'Router WiFi 6', 'High speed dual band router', 799.90, 500.00, 25, true, 4.4, 110, 'SKU-019', 'TP-Link', 'Networking', 0.6, 5.0, 25.0, 18.0, now(), now()),
(gen_random_uuid(), 'Power Bank 20000mAh', 'Fast charging power bank', 249.90, 120.00, 80, true, 4.6, 140, 'SKU-020', 'Xiaomi', 'Accessories', 0.4, 2.0, 7.0, 15.0, now(), now()),
(gen_random_uuid(), '4TB HDD', 'High capacity hard drive', 699.90, 450.00, 30, true, 4.3, 90, 'SKU-021', 'Seagate', 'Storage', 0.7, 2.5, 10.0, 14.0, now(), now()),
(gen_random_uuid(), 'Graphic Tablet', 'Digital drawing tablet', 1299.90, 800.00, 15, true, 4.7, 100, 'SKU-022', 'Wacom', 'Electronics', 0.9, 2.0, 35.0, 25.0, now(), now()),
(gen_random_uuid(), 'Microphone USB', 'Streaming microphone', 599.90, 350.00, 35, true, 4.6, 125, 'SKU-023', 'Blue', 'Audio', 0.5, 15.0, 8.0, 8.0, now(), now()),
(gen_random_uuid(), 'Tripod Camera', 'Professional camera tripod', 499.90, 250.00, 22, true, 4.2, 70, 'SKU-024', 'Manfrotto', 'Photography', 1.8, 60.0, 10.0, 10.0, now(), now()),
(gen_random_uuid(), 'Action Camera', '4K waterproof action camera', 1599.90, 1000.00, 18, true, 4.5, 95, 'SKU-025', 'GoPro', 'Photography', 0.3, 4.0, 6.0, 3.0, now(), now()),
(gen_random_uuid(), 'Smart TV 55"', '4K Smart LED TV', 3499.90, 2500.00, 10, true, 4.8, 210, 'SKU-026', 'LG', 'Electronics', 15.0, 75.0, 125.0, 10.0, now(), now()),
(gen_random_uuid(), 'Keyboard Wrist Rest', 'Memory foam wrist rest', 89.90, 30.00, 150, true, 4.0, 35, 'SKU-027', 'HyperX', 'Accessories', 0.4, 2.0, 45.0, 10.0, now(), now()),
(gen_random_uuid(), 'Laptop Cooling Pad', 'RGB cooling pad', 199.90, 100.00, 90, true, 4.3, 60, 'SKU-028', 'CoolerMaster', 'Accessories', 0.8, 3.0, 35.0, 25.0, now(), now()),
(gen_random_uuid(), 'Ergonomic Mouse Pad', 'Large gaming mouse pad', 79.90, 25.00, 200, true, 4.4, 45, 'SKU-029', 'Razer', 'Accessories', 0.3, 0.5, 90.0, 40.0, now(), now()),
(gen_random_uuid(), 'VR Headset', 'Virtual reality headset', 2999.90, 2000.00, 5, true, 4.7, 75, 'SKU-030', 'Meta', 'Electronics', 1.2, 20.0, 25.0, 15.0, now(), now());

-- INSERT TAGS
INSERT INTO product_tags (product_id, tag)
SELECT id, 'gaming' FROM products WHERE sku IN ('SKU-001','SKU-002','SKU-011','SKU-018','SKU-029');

INSERT INTO product_tags (product_id, tag)
SELECT id, 'electronics' FROM products WHERE category = 'Electronics';

INSERT INTO product_tags (product_id, tag)
SELECT id, 'office' FROM products WHERE category = 'Furniture';

INSERT INTO product_tags (product_id, tag)
SELECT id, 'portable' FROM products WHERE sku IN ('SKU-012','SKU-020','SKU-025');

INSERT INTO product_tags (product_id, tag)
SELECT id, 'premium' FROM products WHERE rating >= 4.7;

INSERT INTO product_tags (product_id, tag)
SELECT id, 'accessory' FROM products WHERE category = 'Accessories';

INSERT INTO product_tags (product_id, tag)
SELECT id, 'storage' FROM products WHERE category = 'Storage';

INSERT INTO product_tags (product_id, tag)
SELECT id, 'audio' FROM products WHERE category = 'Audio';

INSERT INTO product_tags (product_id, tag)
SELECT id, 'photography' FROM products WHERE category = 'Photography';