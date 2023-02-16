create Database QuanLyCafe
go
USE [QuanLyCafe]
GO
/****** Object:  Table [dbo].[Ban]    Script Date: 5/20/2022 10:57:00 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ban](
	[SoBan] [int] NOT NULL,
 CONSTRAINT [PK_Ban] PRIMARY KEY CLUSTERED 
(
	[SoBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaCTHD] [varchar](6) NOT NULL,
	[MaHD] [varchar](6) NOT NULL,
	[MaNV] [varchar](6) NOT NULL,
	[MaMon] [varchar](6) NOT NULL,
	[TenMon] [nvarchar](50) NOT NULL,
	[Gia] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [bigint] NOT NULL,
	[NgayLapHD] [datetime] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[MaCV] [varchar](6) NOT NULL,
	[TenCV] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[MaCV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DangNhap]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DangNhap](
	[TenDangNhap] [varchar](20) NOT NULL,
	[MatKhau] [varchar](10) NOT NULL,
 CONSTRAINT [PK_DangNhap_1] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DoUong]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DoUong](
	[MaMon] [varchar](6) NOT NULL,
	[MaLoai] [varchar](6) NOT NULL,
	[TenMon] [nvarchar](50) NOT NULL,
	[Gia] [int] NOT NULL,
 CONSTRAINT [PK_DoUong] PRIMARY KEY CLUSTERED 
(
	[MaMon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [varchar](6) NOT NULL,
	[MaNV] [varchar](6) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiDoUong]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiDoUong](
	[MaLoai] [varchar](6) NOT NULL,
	[TenLoai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiDoUong] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguyenLieu]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguyenLieu](
	[MaNL] [varchar](6) NOT NULL,
	[MaMon] [varchar](6) NOT NULL,
	[MaNCC] [varchar](6) NOT NULL,
	[TenNL] [nvarchar](50) NOT NULL,
	[DVT] [varchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[Tien] [int] NOT NULL,
 CONSTRAINT [PK_NguyenLieu] PRIMARY KEY CLUSTERED 
(
	[MaNL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [varchar](6) NOT NULL,
	[TenNCC] [nvarchar](50) NOT NULL,
	[SDT] [varchar](10) NOT NULL,
	[DiaChi] [nvarchar](300) NOT NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/20/2022 10:57:01 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](6) NOT NULL,
	[MaCV] [varchar](6) NOT NULL,
	[TenNV] [nvarchar](50) NOT NULL,
	[GT] [bit] NOT NULL,
	[SDT] [varchar](10) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (1)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (2)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (3)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (4)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (5)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (6)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (7)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (8)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (9)
GO
INSERT [dbo].[Ban] ([SoBan]) VALUES (10)
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD1', N'HD1', N'NV1', N'SD1', N'SoDa Việt Quất', 29000, 3, 87000, CAST(N'2019-11-15T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD2', N'HD1', N'NV1', N'CFS', N'Cà Phê Sữa', 22000, 3, 66000, CAST(N'2019-11-15T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD3', N'HD2', N'NV2', N'DXC', N'Đá Xay Chocolate', 35000, 5, 175000, CAST(N'2019-04-23T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD4', N'HD2', N'NV2', N'NE1', N'Nước Ép Táo', 30000, 5, 150000, CAST(N'2019-04-23T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD5', N'HD1', N'NV1', N'SD1', N'SoDa Việt Quất', 29000, 3, 87000, CAST(N'2022-05-18T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD6', N'HD2', N'NV3', N'SD1', N'SoDa Việt Quất', 29000, 5, 145000, CAST(N'1900-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD7', N'HD3', N'QL1', N'DXC', N'Đá Xay Chocolate', 35000, 5, 175000, CAST(N'2022-05-18T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD8', N'HD3', N'QL1', N'DXC', N'Đá Xay Chocolate', 35000, 5, 175000, CAST(N'1900-01-01T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaNV], [MaMon], [TenMon], [Gia], [SoLuong], [TongTien], [NgayLapHD]) VALUES (N'CTHD9', N'HD1', N'NV2', N'DXC', N'Đá Xay Chocolate', 35000, 3, 105000, CAST(N'2022-05-18T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (N'GX', N'Giữ Xe')
GO
INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (N'NV', N'Nhân Viên')
GO
INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (N'QL', N'Quản Lý')
GO
INSERT [dbo].[DangNhap] ([TenDangNhap], [MatKhau]) VALUES (N'Admin', N'123')
GO
INSERT [dbo].[DoUong] ([MaMon], [MaLoai], [TenMon], [Gia]) VALUES (N'CFD', N'CF', N'Cà Phê Đen', 22000)
GO
INSERT [dbo].[DoUong] ([MaMon], [MaLoai], [TenMon], [Gia]) VALUES (N'CFS', N'CF', N'Cà Phê Sữa', 22000)
GO
INSERT [dbo].[DoUong] ([MaMon], [MaLoai], [TenMon], [Gia]) VALUES (N'DXC', N'DX', N'Đá Xay Chocolate', 35000)
GO
INSERT [dbo].[DoUong] ([MaMon], [MaLoai], [TenMon], [Gia]) VALUES (N'NE1', N'NE', N'Nước Ép Táo', 30000)
GO
INSERT [dbo].[DoUong] ([MaMon], [MaLoai], [TenMon], [Gia]) VALUES (N'SD1', N'SD', N'SoDa Việt Quất', 29000)
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaNV]) VALUES (N'HD1', N'NV1')
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaNV]) VALUES (N'HD2', N'NV2')
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaNV]) VALUES (N'HD3', N'NV3')
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaNV]) VALUES (N'HD4', N'NV1')
GO
INSERT [dbo].[LoaiDoUong] ([MaLoai], [TenLoai]) VALUES (N'CF', N'Cà Phê')
GO
INSERT [dbo].[LoaiDoUong] ([MaLoai], [TenLoai]) VALUES (N'DX', N'Đá Xay ')
GO
INSERT [dbo].[LoaiDoUong] ([MaLoai], [TenLoai]) VALUES (N'NE', N'Nước Ép ')
GO
INSERT [dbo].[LoaiDoUong] ([MaLoai], [TenLoai]) VALUES (N'SD', N'SoDa')
GO
INSERT [dbo].[NguyenLieu] ([MaNL], [MaMon], [MaNCC], [TenNL], [DVT], [SoLuong], [Tien]) VALUES (N'NL1', N'CFD', N'NCC1', N'Đường', N'Kilogram', 10, 100000)
GO
INSERT [dbo].[NguyenLieu] ([MaNL], [MaMon], [MaNCC], [TenNL], [DVT], [SoLuong], [Tien]) VALUES (N'NL2', N'CFS', N'NCC2', N'Sữa Đặc', N'H?p', 9, 90000)
GO
INSERT [dbo].[NguyenLieu] ([MaNL], [MaMon], [MaNCC], [TenNL], [DVT], [SoLuong], [Tien]) VALUES (N'NL3', N'DXC', N'NCC3', N'Sốt Chocolate', N'H?p', 10, 1000000)
GO
INSERT [dbo].[NguyenLieu] ([MaNL], [MaMon], [MaNCC], [TenNL], [DVT], [SoLuong], [Tien]) VALUES (N'NL4', N'NE1', N'NCC4', N'Táo', N'Kilogram', 80, 800000)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [SDT], [DiaChi]) VALUES (N'NCC1', N'Nguyễn Thanh Đạt', N'0912123456', N'269 Lê Văn Việt, p.Tăng Nhơn Phú B')
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [SDT], [DiaChi]) VALUES (N'NCC2', N'Trần Thanh Phong', N'0912345768', N'911 Xa Lộ Hà Nội')
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [SDT], [DiaChi]) VALUES (N'NCC3', N'Nguyễn Thanh A', N'0912345678', N'234  Nguyễn Thị Minh Khai')
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [TenNCC], [SDT], [DiaChi]) VALUES (N'NCC4', N'Trần Thanh B', N'0923453456', N'345 Lê Văn Trí')
GO
INSERT [dbo].[NhanVien] ([MaNV], [MaCV], [TenNV], [GT], [SDT]) VALUES (N'NV1', N'NV', N'Bùi Văn A', 0, N'0907345678')
GO
INSERT [dbo].[NhanVien] ([MaNV], [MaCV], [TenNV], [GT], [SDT]) VALUES (N'NV2', N'NV', N'Nguyễn Thanh Đạt', 1, N'0907123451')
GO
INSERT [dbo].[NhanVien] ([MaNV], [MaCV], [TenNV], [GT], [SDT]) VALUES (N'NV3', N'NV', N'Trần Thanh B', 1, N'0907123567')
GO
INSERT [dbo].[NhanVien] ([MaNV], [MaCV], [TenNV], [GT], [SDT]) VALUES (N'QL1', N'QL', N'Nguyễn Thanh Đạt', 0, N'0907123456')
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_DoUong] FOREIGN KEY([MaMon])
REFERENCES [dbo].[DoUong] ([MaMon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_DoUong]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon1] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon1]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_NhanVien]
GO
ALTER TABLE [dbo].[DoUong]  WITH CHECK ADD  CONSTRAINT [FK_DoUong_LoaiDoUong] FOREIGN KEY([MaLoai])
REFERENCES [dbo].[LoaiDoUong] ([MaLoai])
GO
ALTER TABLE [dbo].[DoUong] CHECK CONSTRAINT [FK_DoUong_LoaiDoUong]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien1] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien1]
GO
ALTER TABLE [dbo].[NguyenLieu]  WITH CHECK ADD  CONSTRAINT [FK_NguyenLieu_DoUong] FOREIGN KEY([MaMon])
REFERENCES [dbo].[DoUong] ([MaMon])
GO
ALTER TABLE [dbo].[NguyenLieu] CHECK CONSTRAINT [FK_NguyenLieu_DoUong]
GO
ALTER TABLE [dbo].[NguyenLieu]  WITH CHECK ADD  CONSTRAINT [FK_NguyenLieu_NhaCungCap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[NhaCungCap] ([MaNCC])
GO
ALTER TABLE [dbo].[NguyenLieu] CHECK CONSTRAINT [FK_NguyenLieu_NhaCungCap]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([MaCV])
REFERENCES [dbo].[ChucVu] ([MaCV])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
