USE [PRJ_Assignment_Spring2022]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 3/24/2022 10:04:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Image] [nvarchar](250) NULL,
	[Description] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 3/24/2022 10:04:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customers](
	[Id] [int] NOT NULL,
	[ContactName] [nvarchar](50) NULL,
	[UserName] [nvarchar](50) NULL,
	[PassWord] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 3/24/2022 10:04:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Id] [int] NOT NULL,
	[OrderDate] [date] NULL,
	[ShippedDate] [date] NULL,
	[ShippedAddress] [nvarchar](50) NULL,
	[TotalAmount] [int] NULL,
	[CustomerId] [int] NULL,
	[ShipperId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders Details]    Script Date: 3/24/2022 10:04:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders Details](
	[ProductId] [int] NOT NULL,
	[OrderId] [int] NOT NULL,
	[UnitPrice] [int] NULL,
	[Quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC,
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 3/24/2022 10:04:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Image] [nvarchar](250) NULL,
	[UnitPrice] [int] NULL,
	[UnitStock] [int] NULL,
	[Detail] [nvarchar](300) NULL,
	[CategoryId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shippers]    Script Date: 3/24/2022 10:04:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shippers](
	[Id] [int] NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Categories] ([Id], [Name], [Image], [Description]) VALUES (1, N'Sneakers', N'https://travelgear.vn/blog/wp-content/uploads/2020/01/sneaker-l%C3%A0-g%C3%AC2.jpg', N'Beautiful, Healthy, Active')
INSERT [dbo].[Categories] ([Id], [Name], [Image], [Description]) VALUES (2, N'Slip-Ons', N'https://www.giaytot.com/media/wysiwyg/14570345_1077279118987685_889681404393264031_n.jpg', N'Young, Elegant, Polite')
INSERT [dbo].[Categories] ([Id], [Name], [Image], [Description]) VALUES (3, N'Boots', N'https://olug.vn/uploads/products/1/slide/giay-boot-da.jpg', N'Beautiful, Neat, Tall')
INSERT [dbo].[Categories] ([Id], [Name], [Image], [Description]) VALUES (4, N'Sandals', N'https://nypost.com/wp-content/uploads/sites/2/2021/03/shoes.jpg?quality=80&strip=all', N'Neat, Comfortable, Cool')
GO
INSERT [dbo].[Customers] ([Id], [ContactName], [UserName], [PassWord], [Email], [Phone], [Address]) VALUES (1, N'Mr Thanh', N'thanh123', N'thanh05052001', N'thanhpn05052001@gmail.com', N'0381234567', N'Hai Phong')
INSERT [dbo].[Customers] ([Id], [ContactName], [UserName], [PassWord], [Email], [Phone], [Address]) VALUES (2, N'Mr Chieu', N'chieu123', N'chieu02042001', N'chieu02042001@gmail.com', N'0351234567', N'Hung Yen')
INSERT [dbo].[Customers] ([Id], [ContactName], [UserName], [PassWord], [Email], [Phone], [Address]) VALUES (3, N'Mr Toan', N'toan123', N'toan24122001', N'toan24122001@gmail.com', N'0381234567', N'Bac Ninh')
INSERT [dbo].[Customers] ([Id], [ContactName], [UserName], [PassWord], [Email], [Phone], [Address]) VALUES (4, N'Nam', N'namnguyen', N'he151296', N'namnguyen@gmail.com', N'0357996xxx', N'Ha Noi')
INSERT [dbo].[Customers] ([Id], [ContactName], [UserName], [PassWord], [Email], [Phone], [Address]) VALUES (5, N'x', N'user1', N'123456', N'x@gmail.com', N'0123456xxx', N'xxx')
GO
INSERT [dbo].[Orders] ([Id], [OrderDate], [ShippedDate], [ShippedAddress], [TotalAmount], [CustomerId], [ShipperId]) VALUES (1, CAST(N'2022-03-15' AS Date), CAST(N'2022-03-16' AS Date), N'Hai Phong', 130, 1, 1)
INSERT [dbo].[Orders] ([Id], [OrderDate], [ShippedDate], [ShippedAddress], [TotalAmount], [CustomerId], [ShipperId]) VALUES (2, CAST(N'2022-03-15' AS Date), CAST(N'2022-03-18' AS Date), N'Hung Yen', 100, 2, 1)
INSERT [dbo].[Orders] ([Id], [OrderDate], [ShippedDate], [ShippedAddress], [TotalAmount], [CustomerId], [ShipperId]) VALUES (3, CAST(N'2022-03-15' AS Date), CAST(N'2022-03-23' AS Date), N'Bac Ninh', 120, 3, 1)
INSERT [dbo].[Orders] ([Id], [OrderDate], [ShippedDate], [ShippedAddress], [TotalAmount], [CustomerId], [ShipperId]) VALUES (4, CAST(N'2022-03-15' AS Date), CAST(N'2022-03-24' AS Date), N'Bac Ninh', 90, 2, 2)
INSERT [dbo].[Orders] ([Id], [OrderDate], [ShippedDate], [ShippedAddress], [TotalAmount], [CustomerId], [ShipperId]) VALUES (5, CAST(N'2022-03-15' AS Date), CAST(N'2022-03-23' AS Date), N'Hai Phong', 75, 1, 2)
INSERT [dbo].[Orders] ([Id], [OrderDate], [ShippedDate], [ShippedAddress], [TotalAmount], [CustomerId], [ShipperId]) VALUES (6, CAST(N'2022-03-16' AS Date), CAST(N'2022-03-18' AS Date), N'Bac Ninh', 55, 3, 1)
INSERT [dbo].[Orders] ([Id], [OrderDate], [ShippedDate], [ShippedAddress], [TotalAmount], [CustomerId], [ShipperId]) VALUES (7, CAST(N'2022-03-16' AS Date), CAST(N'2022-03-18' AS Date), N'Hai Phong', 185, 2, 2)
GO
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (1, 4, 30, 3)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (3, 1, 20, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (4, 3, 25, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (4, 5, 25, 3)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (5, 1, 35, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (6, 1, 25, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (8, 1, 30, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (8, 2, 30, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (8, 3, 30, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (14, 2, 30, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (19, 2, 17, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (22, 2, 13, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (24, 3, 15, 1)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (24, 6, 15, 3)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (25, 7, 55, 3)
INSERT [dbo].[Orders Details] ([ProductId], [OrderId], [UnitPrice], [Quantity]) VALUES (28, 3, 50, 1)
GO
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (1, N'Brooks Addiction Walker', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/brook51495_160710_hd1.jpg', 25, 15, N'Get addicted to your daily walking routine with the Brooks Addiction Walker 2 Walking Sneaker. This walking sneaker features Extended Progressive Diagonal Rollbar (PDRB) support system that strategically positions arch support to guide and keep your body in its natural path of motion.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (2, N'Brooks Beast', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/brook883701_531621_hd1.jpg', 30, 10, N'Enjoy soft and cushioned comfort with the Brooks Beast 20 Running Shoe.
This running shoe features the BioMoGo DNA midsole cushioning and GuideRails® technology to keep excess movement in check.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (3, N'Propet Stability Fly', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/prope843436_262864_hd1.jpg', 15, 30, N'Stay ahead of your limits in every outdoor adventure with the Propet Stability Fly Sneaker.
This lace-up sneaker features a polyurethane insole with a gel heel pad and cushioning ridges for superior shock absorption, stability, and protection.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (4, N'ECCO Soft', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/eccou885357_533498_hd1.jpg', 20, 25, N'Classic, laid-back, and elegant, the ECCO Soft 7 Tred Urban Sneaker has all the elements to create a stylish look.
This sneaker features HYDROMAX™ technology-enabled water-repellent construction and textile lining for softness and breathability.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (5, N'SAS Journey', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/sassh841128_473476_hd1.jpg', 30, 10, N'The SAS Journey Sneaker features a refined style for a supportive fit and all-day comfort.
This lace-up sneaker features removable OrthoLite® CoolSTEP™ Duo footbed that keeps the foot cool and dry and offers maximum comfort.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (6, N'Vans Classic Slip', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/vansi288663_28450_hd1.jpg', 20, 25, N'Exceptional comfort and sporty style merge in the Vans Classic Slip On Sneaker.
This classic slip-on features a flexible canvas and mesh upper, and the side elastic gores keep your feet comfortable with a snug fit throughout the day.', 2)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (7, N'Skechers Relaxed Fit', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/64109ew-blu-sbc__1.jpg', 15, 30, N'Sporty style combines with relaxed comfort in the Skechers Relaxed Fit Expected Gomel Slip On Sneaker.
This slip-on sneaker features the Relaxed Fit® design for a roomy and comfortable fit, and the Memory Foam™ cushioned insole offers added comfort.', 2)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (8, N'V-Strap 2', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/brook876773_160710_hd1.jpg', 25, 15, N'Enjoy a slower pace and experience optimum comfort with the Brooks Addiction Walker V-Strap 2 Slip On Sneaker.
This slip-on sneaker features Brooks Extended Progressive Diagonal Rollbar (PDRB), which acts as a support system for the entire body.', 2)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (9, N'Clarks Escalade Step', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/thecl776567_406742_hd1.jpg', 20, 25, N'Dress to impress with the Escalade Step Slip-On by Clarks, Polyurethane outsole
Textile lining and sockliner, Polyurethane outsole.', 2)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (10, N'ECCO Classic', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/eccou754704_29675_hd1.jpg', 30, 10, N'Make a style statement with the ECCO Classic Moc 2.0. Featuring a moccasin-inspired design, this shoe adds a fashionable touch to your outfit.
The slip-on style of this pair makes it easy to wear. It has a cemented rubber outsole.', 2)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (11, N'Wolverine Floorhand Waterproof', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/wolve781177_268517_hd1.jpg', 15, 30, N'The Wolverine Floorhand Waterproof 6" Steel Toe Work Boot combines classic rugged style with a utilitarian profile.
This work boot features a waterproof full-grain leather upper that offers year-around wearability and removable full-cushion footbed molds to the foot to provide comfort.', 3)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (12, N'Clarks Un Brawley', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/26151780__1.jpg', 10, 35, N'Look your stylish best while keeping your feet at ease with the Clarks Un Brawley Up Ankle Boot.
Part of the Unstructured Collection, Nubuck detailing at the tongue and collar for visual interest', 3)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (13, N'Propet Cliff Walker', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/prope121474_27156_jb1.jpg', 25, 15, N'The Propet Cliff Walker Ankle Boot introduces warm comfort while offering complete stability all day long.
This ankle boot features the Sealtex® waterproof technology that not only keeps your feet from getting wet but also keeps them from getting cold.', 3)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (14, N'ECCO Citytray Avant', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/52182401283__1.jpg', 25, 15, N'A classic silhouette that offers avant-garde comfort, the ECCO Citytray Avant Chukka Boot is all set to upscale your fashion to a whole new level.
This ankle boot features ECCO TRAYTECH™ Technology.', 3)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (15, N'Clarks Un Brawley', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/drmar655245_7679_hd1.jpg', 20, 25, N'Look your stylish best while keeping your feet at ease with the Clarks Un Brawley Up Ankle Boot.
Part of the Unstructured Collection, Nubuck detailing at the tongue and collar for visual interest.', 3)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (16, N'Birkenstock Arizona Birkibuc', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/birke153685_33895_hd1.jpg', 10, 35, N'Keep your feet comfortable and exude timeless elegance wearing the Birkenstock Arizona Birkibuc Slide.
This two-strapped slide sandal feels very soft underfoot with a contoured cork footbed, and the lightweight EVA outsole ensures shock absorption and traction.', 4)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (17, N'Propet Jack Fisherman', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/prope882977_27178_hd1.jpg', 11, 30, N'Exceptional comfort and rugged style merge in the Propet Jack Fisherman Sandal.
This fisherman sandal features a removable foam-padded footbed and microfiber lining that offers optimum comfort to make this silhouette a casual wardrobe staple.', 4)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (18, N'Teva Hurricane', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/decke829424_459773_hd1.jpg', 9, 40, N'Explore the bright and airy outdoors wearing the Teva Hurricane XLT2 Active Sandal.
This sandal features quick-dry webbing made from recycled plastic using traceable, verifiable REPREVE® polyester yarn by Unifi®.', 4)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (19, N'Reef Fanning', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/ci7072__1.jpg', 12, 25, N'The Reef Fanning Slide brings the legacy of the Fanning series and takes your style to new heights.
This slide sandal features a comfortable EVA footbed and the "bottle opener" TQT technology at the bottom of the sole, ensuring that you never miss a party ever again.', 4)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (20, N'Reef Flex Perforated', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/reef889317_537903_hd1.jpg', 10, 35, N'Step out wearing the Reef Flex Perforated Flip Flop and flaunt that perfect beach look. This is a water-friendly flip flop that features a soft high-rebound EVA footbed with signature herringbone texture.
The non-marking rubber outsole offers grip and traction wherever you go.', 4)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (21, N'Reef Cushion Coast Mid', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/ci8108__1.jpg', 9, 43, N'A laid-back silhouette upgraded with a metallic touch, the Reef Cushion Coast Mid Slip On Sneaker makes you stand out in any setting.
This slip-on features high-energy rebound, arch support, and heel cupping for all-day support.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (22, N'Propet Visp', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/moa012mblu__1.jpg', 8, 45, N'Take on the trails with confidence and elevate your style wearing the Propet Visp Sneaker.
This lace-up sneaker features a Scotchgard™ treated water and stain-resistant upper and Vibram® Arctic Grip® outsole with Wet-Ice Technology for three-season traction on any surface.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (23, N'Propet Stability X', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/maa012mdgr__1.jpg', 7, 50, N'Glide through your day comfortably with the Propet Stability X Sneaker.
This sneaker features a soft cushioned polyurethane forefoot with comfort ridges, a memory foam topper, and a rubber outsole that offers long-lasting comfort throughout the day.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (24, N'Rockport XCS Spruce', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/ci6308__1.jpg', 10, 35, N'Conquer your walking limits and stay active wearing the Rockport XCS Spruce Peak Blucher Sneaker.
This lace-up walking sneaker features a lightweight truTECH® technology that absorbs shock at the heel and an anti-microbial liner that keeps your feet fresh all day long.', 1)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (25, N'Martens 2976 Chelsea', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/drmar655245_7679_hd1.jpg', 50, 5, N'Incorporate a versatile yet modern style with Dr. Martens 2976 Chelsea Boot.
This chelsea boot is designed with the Goodyear® welt construction, featuring a heat-sealed upper with a sturdy, cushioned, and slip-resistant sole to keep you steady on your feet.', 3)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (26, N'Naot Business Chelsea', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/yalee755596_387361_hd1.jpg', 55, 3, N'The Business Chelsea Boot is classically good looking. It will look great whether you are in with jeans or slacks.
The attractive leather upper has a rounded toe and double elastic insets, for easy on and off, as well as a comfortable fit. The removable cork and latex insole.', 3)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (27, N'Propet Cliff Walker', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/prope843392_222885_hd1.jpg', 60, 4, N'The Propet Cliff Walker Ankle Boot introduces warm comfort while offering complete stability all day long.
This ankle boot features the Sealtex® waterproof technology that not only keeps your feet from getting wet but also keeps them from getting cold.', 3)
INSERT [dbo].[Products] ([Id], [Name], [Image], [UnitPrice], [UnitStock], [Detail], [CategoryId]) VALUES (28, N'Terra Venom Mid', N'https://d3d71ba2asa5oz.cloudfront.net/12037791/images/kodia812026_444054_hd1.jpg', 45, 6, N'Stay protected on the job with the Terra Venom Mid 6" Composite Toe Safety Work Boot.
Premium water-resistant suede and full-grain leather upper, Low-profile, CSA-certified for sole and toe protection, and static-dissipative sole.', 3)
GO
INSERT [dbo].[Shippers] ([Id], [Name], [Phone], [Status]) VALUES (1, N'Shipper1', N'0352345678', 1)
INSERT [dbo].[Shippers] ([Id], [Name], [Phone], [Status]) VALUES (2, N'Shipper2', N'0383456789', 1)
INSERT [dbo].[Shippers] ([Id], [Name], [Phone], [Status]) VALUES (3, N'Shipper3', N'0384567890', 0)
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customers] ([Id])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([ShipperId])
REFERENCES [dbo].[Shippers] ([Id])
GO
ALTER TABLE [dbo].[Orders Details]  WITH CHECK ADD FOREIGN KEY([OrderId])
REFERENCES [dbo].[Orders] ([Id])
GO
ALTER TABLE [dbo].[Orders Details]  WITH CHECK ADD FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
GO
