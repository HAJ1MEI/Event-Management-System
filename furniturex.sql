-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: furniturex
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'https://images.pexels.com/photos/1457842/pexels-photo-1457842.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Living Room Furniture'),(2,'https://images.pexels.com/photos/237371/pexels-photo-237371.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Bedroom Furniture'),(3,'https://images.pexels.com/photos/31837790/pexels-photo-31837790/free-photo-of-cozy-restaurant-interior-with-set-table.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Dining Room Furniture'),(4,'https://images.pexels.com/photos/31726561/pexels-photo-31726561/free-photo-of-bright-modern-home-office-desk-setup-with-plants.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Office Furniture'),(5,'https://images.pexels.com/photos/238385/pexels-photo-238385.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Outdoor Furniture'),(6,'https://images.pexels.com/photos/273062/pexels-photo-273062.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Kids & Baby Furniture'),(7,'https://images.pexels.com/photos/6315808/pexels-photo-6315808.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Storage & Organization'),(8,'https://images.pexels.com/photos/1090638/pexels-photo-1090638.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Home Decor & Accessories'),(9,'https://images.pexels.com/photos/1571463/pexels-photo-1571463.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1','Luxury & Premium Furniture');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Living Room Furniture','Handpicked by guest curator and aesthete Feroze Gujral, the Nzete Coffee Table draws inspiration from the raw, primal beauty of nature and tribal crafts from Africa. ','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/n/z/nzete_coffee_table_700x700_1.jpg',115000,'Nzete Coffee Table'),(2,'Living Room Furniture','Citron makes a bold statement with its minimalist style and striking hue. Its overstretched, elongated lines and asyemmetrical curves subtly evoke a contemporary influence.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/c/i/citron_curved_sofa_lime_700x700.jpg',246000,'Citron Curved Sofa'),(3,'Living Room Furniture','Part of an exclusive collection developed in collaboration with guest curator and aesthete Feroze Gujral, the Makasi Bar Cabinet is a study in contrasts - rugged yet refined, tactile yet sleek','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/m/a/makasi_bar_cabinet_700x700.jpg',330000,'Makasi Bar Cabinet'),(4,'Bedroom Furniture','Featuring ample storage where you need it most without compromising on style, the Sake Cabinet showcases a solid hardwood frame and textured brass grille shutters for added appeal.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/s/a/sake_cabinet_700x700_ms2_1.jpg',198000,' Sake Cabinet'),(5,'Dining Room Furniture','Handpicked by guest curator and all-round aesthete Feroze Gujral, this Baroque-inspired chair is a striking fusion of opulence and drama.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/n/o/noir_baroque_accent_chair_700x700_1.jpg',55000,' Noir Baroque Accent Chair'),(6,'Living Room Furniture','With a strong mix between a solid wood frame and textured brass grille shutters, the Saga Media Unit sits in harmony with its multiple finishes. ','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/s/a/saga_media_unit_700x700up.jpg',162000,' Saga Media Unit'),(7,'Bedroom Furniture','A tribute to the natural beauty of burl wood, the Bastille Bedside Table features a gridded design composed of burl panels with molding details & antique gold pulls paired with natural oak grain','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/b/a/bastille_burl_bedside_table_700x700_1.jpg',65000,' Bastille Burl Bedside Table'),(8,'Office Furniture','Discover the timeless allure of Bocca® Unlimited, the latest version of Studio65’s iconic 1970 \'Lip Sofa.\' Originally limited to classic red, Bocca® now expands to an open edition in rich, dynamic hues, preserving its bold, radical spirit.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/7/0/700x_700__bocca_unlimited_cherry_716.jpg',700000,'Bocca Unlimited Cherry Red by Studio65'),(9,'Outdoor Furniture','Designed for sunlit corners and open-air lounging, the Solace Rope Armchair brings together form and function with effortless charm. Its powder-coated aluminium frame offers strength without weight','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/7/0/700_x_700_te.jpg',57500,' Solace Rope Armchair'),(10,'Office Furniture','Transport your living spaces into a serene realm with the Oom Coffee Table. Crafted from marble and cast metal, it seamlessly brings the calming essence of water into your home.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/o/o/oom_coffee_table_700x700_1.jpg',400000,'Oom Coffee Table By Santiago Luna'),(11,'Luxury & Premium Furniture','With its floating marble top and slender, sculptural legs, the Eterna Dining Table is adorned with delicate brass ball links - a nod to Udaipur’s rich heritage. ','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/e/t/eterna_dining_table_700x700.jpg',239000,'Eterna Dining Table'),(12,'Bedroom Furniture','A bold interplay of form and finish, the Zenith Bed merges vintage flair with modern refinement. Framed in slender brass posts and grounded in deep black oak','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/z/e/zenith_bed_700_x700.jpg',543500,' Zenith Bed'),(13,'Outdoor Furniture','A study in geometry and craftsmanship, the Weave Bench is sculpted from premium teak wood, adorned with brass accents, and defined by an intricate lattice that seamlessly merges structure and seat. ','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/9/5/95.jpg',306800,' Weave Bench - Intent Made'),(14,'Home Decor & Accessories','Inspired by the fluid contours of mountain ranges, Sierra is a harmonious blend of raw textures and refined detail. A patinated brass top, reminiscent of a tranquil lake','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/1/2/120.jpg',250000,' Sierra Coffee Table - Art Attaichi'),(15,'Kids & Baby Furniture','Endowed with a touch of poetry, heritage, and beauty, the Sorelle Inlay Credenza with its elemental silhouette and exceptional craftsmanship boasts of an architectural quality.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/s/o/sorelle_inlay_credenza_700x700_1.jpg',130000,'Sorelle Inlay Credenza'),(16,'Home Decor & Accessories','A table as a canvas; its glass top a mirror to the sky, its base firmly rooted to the earth. A reflection of shifting horizons, where light and space intertwine. ','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/e/d/edge_of_time_coffee_table_by_creatomy_700x700.jpg',247800,' Edge of Time Coffee Table by Creatomy'),(17,'Storage & Organization','The Ying Yang Cabinet holds all the secrets you want to reveal. Designed to display your most prized collectibles, the cabinet discloses itself only on careful inspection. ','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/y/i/ying_yang_cabinet_by_objectry_700x700_1.jpg',333110,' Ying Yang Cabinet by Objectry'),(18,'Home Decor & Accessories','Rooted in the philosophy of the Gurukul system, \"Vidya Vrtta\" symbolizes transformation through communal learning. The bench, with its undulating texture, evokes the ebbs and flows of water','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/v/i/vidya_vrtta_bench_by_nitush_aroosh_700x700.jpg',645000,' Vidya Vrtta Bench by Nitush & Aroosh'),(19,'Home Decor & Accessories','The Ganges Room Divider is inspired from the deltas and flow of the Ganges river system. This piece of furniture translates the flow of the holy Ganga river onto its surface with lines hand finished by skilled craftsmen','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/d/i/divider_700_x_700.jpg',272000,' Ganges Room Divider by Parth Shukla for The House Of Things'),(20,'Dining Room Furniture','Inspired by yogic energy flow, this sculptural ceramic stool doubles as a functional statement piece. Its intertwined form reflects the balance of rest and vulnerability reimagining home as a grounding and introspective space','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/k/u/kundalini_stool_by_sharol_ahluwalia_700_x_700.jpg',194700,'Kundalini Stool by Sharol Ahluwalia'),(21,'Home Decor & Accessories','Urmika, is the Sanskrit word for waves – where the shelves epitomize and accentuate the curves formed when waves are generated. It captures the essence of undulating waves and the graceful transformation of shape under pressure.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/u/r/urmika_shelves_by_the_vakr_collective_700x700.jpg',401200,' Urmika Shelves by The Vakr Collective'),(22,'Storage & Organization','Crafted with meticulous attention to detail, this credenza combines an antique brass finish with sculptural accents, embodying a seamless blend of form and function. Elevate your living space with this uncompromisingly elegant addition.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/d/i/dimitra_credenza_700x700_1.jpg',415000,' Dimitra 4 Doors Credenza'),(23,'Kids & Baby Furniture','Meet the Fossil Console Table – a time capsule waiting to jazz up your living spaces. Crafted with fossilized texture glass that’s as intriguing to touch as it is to behold','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/t/h/thot10845_700x700_1_fratured.jpg',158400,' Fossil Console'),(24,'Dining Room Furniture','The luxurious golden hue of my matte finished gold body and amber glass can add a really large dose of oomph to living spaces. You can have me as a single piece, in pairs or 3.','https://thot-media.thehouseofthings.com/media/catalog/product/cache/23805d0b5733a0fa8b043eb92f9a261d/p/y/pyramid_coffee_table_700x700.jpg',35990,' Pyramid Coffee Tables - Set of 3');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `booking_date` datetime(6) DEFAULT NULL,
  `payment_id` varchar(255) DEFAULT NULL,
  `razorpay_order_id` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `ticket_count` int NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `event_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK43g2yroy6l7lfomw37wajkqrn` (`event_id`),
  CONSTRAINT `FK43g2yroy6l7lfomw37wajkqrn` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,194700,'2025-05-03 14:59:32.304240','pay_QQPHfrMFojrDfj','order_QQPHLH0honNfPK','Paid',1,NULL,'prash',20);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'prash','USER','prash'),(2,'admin','ADMIN','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `event_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKob1plrt0hpmngjl3jgbg0wirp` (`event_id`),
  KEY `FKtrd6335blsefl2gxpb8lr0gr7` (`user_id`),
  CONSTRAINT `FKob1plrt0hpmngjl3jgbg0wirp` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  CONSTRAINT `FKtrd6335blsefl2gxpb8lr0gr7` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
/*!40000 ALTER TABLE `wishlist` DISABLE KEYS */;
INSERT INTO `wishlist` VALUES (1,20,1);
/*!40000 ALTER TABLE `wishlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-03 15:39:42
