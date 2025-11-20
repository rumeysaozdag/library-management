📚 Kütüphane Yönetim Sistemi (Library Management System)

Bu proje, Spring Boot kullanılarak geliştirilmiş, Katmanlı Mimari (Layered Architecture) prensiplerine dayanan profesyonel bir RESTful API uygulamasıdır. Kütüphane üyelerini, kitapları ve ödünç alma süreçlerini yönetmek için tasarlanmıştır.

🚀 Proje Özellikleri (Features)

Bu proje, modern yazılım geliştirme standartlarına uygun olarak aşağıdaki özellikleri içerir:

✅ Tamamlanan Modüller

1. Kitap Yönetimi (Book):

Kitap Ekleme, Listeleme, Güncelleme, Silme (CRUD).

Veritabanı seviyesinde ISBN tekilliği (unique constraint) kontrolü.

2. Üye Yönetimi (Member):

Üye Kaydı, Listeleme, Güncelleme, Silme (CRUD).

E-posta adresi tekilliği kontrolü.

3. Ödünç Alma Sistemi (Loan):

Kitap ve Üye arasında İlişkisel Bağlantı (@ManyToOne).

Ödünç verme ve geri alma (tarih güncelleme) işlemleri.

API çıktılarında "Zenginleştirilmiş DTO" (ID yerine Kitap/Üye isimlerini gösterme) yapısı.

🛡️ Gelişmiş Özellikler (Aşama 4)

Global Hata Yönetimi (Global Exception Handling):

null döndürmek yerine, özel ResourceNotFoundException fırlatma.

@ControllerAdvice ile hataları yakalayıp, kullanıcıya standart ve temiz JSON hata mesajları (404 Not Found) döndürme.

Girdi Validasyonu (Input Validation):

@NotEmpty, @Size, @Email gibi anotasyonlarla veri doğrulama.

Geçersiz veriler için 400 Bad Request ve detaylı hata raporu döndürme.

🛠️ Kullanılan Teknolojiler

Java 17

Spring Boot 3.x

Spring Web (REST API)

Spring Data JPA (Veritabanı Erişimi)

Spring Boot Validation (Veri Doğrulama)

PostgreSQL (Veritabanı)

Lombok (Kod sadeleştirme)

Maven (Bağımlılık Yönetimi)

🏗️ Proje Mimarisi

Proje, "Interface-Based Programming" (Arayüze Dayalı Programlama) ve "Separation of Concerns" (Sorumlulukların Ayrılması) ilkelerine sıkı sıkıya bağlıdır.


### Dizin Yapısı (`com.enesbayram.library`)

```text
src/main/java
└── com.enesbayram.library
    ├── configuration       (Gelecek Planı: Güvenlik ayarları)
    ├── controller          (API Sözleşmeleri - Interfaces)
    │   └── impl            (API Uygulamaları - Implementations)
    ├── dto                 (Veri Aktarım Nesneleri)
    ├── entities            (Veritabanı Tablo Modelleri)
    ├── exception           (Özel Hata Sınıfları ve Global Handler)
    ├── repository          (Veritabanı Erişimi - JPA Interfaces)
    ├── services            (İş Mantığı Sözleşmeleri - Interfaces)
    │   └── impl            (İş Mantığı Uygulamaları - Implementations)
    └── starter             (Uygulama Başlatıcı)


🔌 API Endpoints (Nasıl Kullanılır?)

Proje çalıştığında aşağıdaki adreslerden API'ye erişilebilir:

1. Kitaplar (Books)

POST /api/v1/books - Yeni kitap ekle

GET /api/v1/books - Tüm kitapları listele

GET /api/v1/books/{id} - ID ile kitap getir

PUT /api/v1/books/{id} - Kitap güncelle

DELETE /api/v1/books/{id} - Kitap sil

2. Üyeler (Members)

POST /api/v1/members - Yeni üye ekle

GET /api/v1/members - Tüm üyeleri listele

GET /api/v1/members/{id} - ID ile üye getir

PUT /api/v1/members/{id} - Üye güncelle

DELETE /api/v1/members/{id} - Üye sil

3. Ödünç Alma (Loans)

POST /api/v1/loans - Kitap ödünç ver

Gövde: { "bookId": 1, "memberId": 1, "loanDate": "2025-01-01", "dueDate": "2025-01-15" }

GET /api/v1/loans - Tüm işlemleri listele (Kitap ve Üye isimleriyle birlikte)

PUT /api/v1/loans/{id} - İade Tarihi (returnDate) güncelle

🔜 Gelecek Planları (Roadmap)

Proje geliştirmeye devam edilmektedir. Sıradaki hedefler:

[ ] Aşama 5: Güvenlik (Security)

[ ] Spring Security entegrasyonu.

[ ] JWT (JSON Web Token) ile kimlik doğrulama.

[ ] Kullanıcı Rolleri (ADMIN, USER) ve Yetkilendirme.

👨‍💻 Geliştirici

Rumeysa Gül Özdağ

GitHub: @rumeysaozdag

LinkedIn: www.linkedin.com/in/rumeysaozdag
