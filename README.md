

```markdown
                        # 🏨 Otel Rezervasyon Sistemi

Bu proje, kullanıcıların çeşitli otelleri görüntüleyip rezervasyon yapabildiği,
basit ve kullanıcı dostu bir **otel rezervasyon web uygulamasıdır**.
Yönetici paneli ile otel ve kullanıcı yönetimi de yapılabilmektedir.

## 🔧 Teknolojiler

- **Java 17**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf**
- **H2 Database (geliştirme aşamasında)**
- **Bootstrap 5**

## 📁 Proje Yapısı

```

otel-rezervasyon/

├── src/

│   ├── main/

│   │   ├── java/com/otelrezervasyon/

│   │   │   ├── controller/

│   │   │   ├── model/

│   │   │   ├── repository/

│   │   │   ├── service/

│   │   │   └── RezervasyonApplication.java

│   │   └── resources/

│   │       ├── templates/

│   │       ├── static/

│   │       └── application.properties

├── fotograflar/

│   ├── 1.png
│   ├── 2.png
│   ├── 3.png
│   ├── 4.png
│   ├── 5.png
│   ├── 6.png
│   └── 7.png

└── pom.xml

````

## 🚀 Başlatma Talimatları

1. **Projeyi klonlayın:**

```bash
git clone https://github.com/kullaniciadi/otel-rezervasyon.git
cd otel-rezervasyon
````

2. **IDE ile açın (IntelliJ önerilir).**

3. **Uygulamayı başlatın:**

```bash
mvn spring-boot:run
```

4. **Tarayıcıdan erişin:**

```
http://localhost:8080
```

## 🧪 Özellikler

* ✅ Kullanıcı kayıt ve giriş sistemi
* ✅ Otel listeleme
* ✅ Otel detayları ve rezervasyon oluşturma
* ✅ Kullanıcıya özel rezervasyon listesi
* ✅ Admin paneli ile:

  * Otel yönetimi (ekle, sil, güncelle)
  * Kullanıcı ve rezervasyon görüntüleme

## 🖼️ Ekran Görüntüleri



![Ana Sayfa](fotograflar/1.png)

![Kayıt Sayfası](fotograflar/2.png)

![Otel Listeleme](fotograflar/4.png)

![Rezervasyon](fotograflar/5.png)

![Kullanıcı Rezervasyonları](fotograflar/6.png)

![Admin Paneli](fotograflar/7.png)

## 🔒 Güvenlik

* Yetkilendirme ile admin sayfalarına sadece yönetici erişebilir.
* (İsteğe bağlı olarak) Spring Security ile giriş kontrolleri yapılabilir.

## 👨‍💻 Geliştirici

**Adınız Soyadınız**
E-posta: [yourmail@example.com](mailto:rojinothan.39@egmail.com)
LinkedIn: [linkedin.com/in/kullaniciadi](https://www.linkedin.com/in/rojin-orhan/)

---


