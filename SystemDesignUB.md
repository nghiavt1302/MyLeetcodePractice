# Ghi nhớ khóa học System Design

> **Mục tiêu:** Xây dựng nền tảng tư duy để thiết kế các hệ thống phần mềm có khả năng mở rộng, ổn định, hiệu năng cao và dễ bảo trì; đồng thời chuẩn bị cho phỏng vấn System Design.

---

## Phần 1 — Introduction

### Bài 1. Welcome

#### Khóa học này nói về điều gì?

Khóa học bắt đầu từ những kiến thức nền tảng của **System Design**, sau đó từng bước đi sâu vào cách thiết kế các hệ thống phần mềm hiện đại và phức tạp.

Các chủ đề chính gồm:

- **Scalability:** hệ thống có thể phục vụ lượng người dùng và lưu lượng ngày càng lớn.
- **Caching:** lưu tạm dữ liệu để giảm độ trễ và tải cho hệ thống.
- **Performance:** tối ưu tốc độ phản hồi và khả năng xử lý.
- **Databases:** lựa chọn, tổ chức và vận hành nơi lưu trữ dữ liệu.
- **Distributed systems:** xây dựng hệ thống gồm nhiều máy hoặc nhiều dịch vụ phối hợp với nhau.
- **Reliability:** duy trì hoạt động ổn định ngay cả khi một số thành phần gặp lỗi.

Sau phần nguyên lý nền tảng, khóa học sẽ phân tích các tình huống thực tế:

- Cách thiết kế ứng dụng quy mô lớn.
- Cách hệ thống có lưu lượng truy cập cao vận hành.
- Cách các công ty công nghệ lớn giải quyết những bài toán kiến trúc.

#### Kết quả mong đợi

Sau khóa học, người học có thể:

1. Hiểu System Design là gì và vì sao nó quan trọng.
2. Tiếp cận một bài toán thiết kế hệ thống theo quy trình có cấu trúc.
3. Phân tích và lựa chọn giữa các phương án kiến trúc khác nhau.
4. Tự tin giải thích những đánh đổi (*trade-off*) trong thiết kế.
5. Thiết kế phần mềm có khả năng mở rộng, đáng tin cậy và hiệu năng cao.

Kiến thức này hữu ích cho cả ba mục tiêu: xây dựng phần mềm tốt hơn, phát triển năng lực kiến trúc và chuẩn bị cho phỏng vấn System Design.

---

### Bài 2. System Design là gì?

#### Định nghĩa ngắn gọn

**System Design là quá trình chuyển một bài toán hoặc yêu cầu kinh doanh thành kiến trúc kỹ thuật phù hợp.**

Sơ đồ, máy chủ, cơ sở dữ liệu và các mẫu kiến trúc chỉ là những thành phần của System Design. Mục đích cuối cùng vẫn là **giải quyết vấn đề kinh doanh bằng công nghệ**.

Có thể hình dung bản thiết kế hệ thống giống như bản vẽ của một tòa nhà. Trước khi viết một lượng lớn mã nguồn, kỹ sư cần xác định các thành phần của hệ thống, trách nhiệm của từng thành phần và cách chúng phối hợp với nhau.

#### System Design là quá trình ra quyết định

Khi thiết kế một hệ thống, cần trả lời những câu hỏi như:

- Người dùng sẽ tương tác với hệ thống bằng cách nào?
- Dữ liệu sẽ được lưu ở đâu và theo hình thức nào?
- Các thành phần giao tiếp với nhau ra sao?
- Điều gì xảy ra khi lưu lượng tăng gấp 10 lần?
- Hệ thống phản ứng như thế nào khi một thành phần gặp lỗi?

Không tồn tại một thiết kế tốt nhất cho mọi hoàn cảnh. Mỗi quyết định đều phụ thuộc vào yêu cầu, quy mô, chi phí và những đánh đổi mà đội ngũ chấp nhận.

#### Một hệ thống tốt cần những phẩm chất nào?

Ngoài việc cung cấp đúng chức năng, hệ thống còn cần:

| Phẩm chất | Ý nghĩa |
|---|---|
| **Scalable — Có khả năng mở rộng** | Có thể đáp ứng khi số người dùng, dữ liệu hoặc lưu lượng tăng lên. |
| **Reliable — Đáng tin cậy** | Tiếp tục cung cấp dịch vụ đúng đắn, kể cả khi có thành phần gặp sự cố. |
| **Performant — Hiệu năng tốt** | Phản hồi nhanh và sử dụng tài nguyên hiệu quả. |
| **Maintainable — Dễ bảo trì** | Dễ hiểu, sửa đổi, vận hành và phát triển thêm trong tương lai. |

Khi hệ thống phát triển lớn hơn, các phẩm chất này thường trở nên quan trọng không kém, thậm chí quan trọng hơn việc bổ sung tính năng mới.

#### Ranh giới trách nhiệm rõ ràng

Một nhiệm vụ quan trọng của System Design là xác định **boundary** — ranh giới giữa các thành phần:

- Thành phần hoặc dịch vụ nào chịu trách nhiệm cho việc gì?
- Các dịch vụ được phép tương tác với nhau theo cách nào?
- Dữ liệu đi qua hệ thống theo luồng nào?
- Thành phần nào sở hữu và được quyền thay đổi dữ liệu?

Ranh giới tốt giúp giảm độ phức tạp, hạn chế sự phụ thuộc chặt chẽ giữa các thành phần và giúp hệ thống dễ thay đổi theo thời gian.

#### Công thức ghi nhớ

> **Yêu cầu kinh doanh → Quyết định kỹ thuật → Kiến trúc hệ thống → Đáp ứng hiện tại và thích nghi với tương lai**

Một bản thiết kế tốt không chỉ giải quyết nhu cầu hôm nay mà còn tạo điều kiện để hệ thống mở rộng và thay đổi trong tương lai.

#### Ý chính cần nhớ

- System Design không đơn thuần là vẽ sơ đồ kiến trúc.
- Điểm xuất phát luôn là bài toán và yêu cầu kinh doanh.
- Thiết kế hệ thống chủ yếu là quá trình đưa ra quyết định và cân nhắc trade-off.
- Chức năng đúng là chưa đủ; hệ thống còn phải mở rộng được, ổn định, nhanh và dễ bảo trì.
- Ranh giới trách nhiệm rõ ràng giúp kiểm soát độ phức tạp.
- Kiến trúc cần phù hợp với hiện tại nhưng cũng phải có khả năng tiến hóa trong tương lai.

---

### Bài 3. Vì sao System Design quan trọng?

#### Không chỉ phục vụ phỏng vấn

Một hiểu lầm phổ biến là System Design chỉ cần thiết khi chuẩn bị phỏng vấn. Trên thực tế, kiến thức này càng trở nên quan trọng khi **hệ thống, đội ngũ và phạm vi trách nhiệm của kỹ sư ngày càng lớn**.

Viết mã có thể giải quyết một vấn đề ở thời điểm hiện tại. System Design giúp bảo đảm giải pháp đó vẫn hoạt động khi số người dùng tăng từ 10 lên 10.000, thậm chí hàng triệu người.

Đây là lý do các yếu tố như **khả năng mở rộng** và **độ tin cậy** rất quan trọng. Một ứng dụng chạy hoàn hảo trong môi trường phát triển vẫn có thể sụp đổ hoàn toàn trước lưu lượng thực tế nếu ngay từ đầu không được thiết kế để tăng trưởng.

#### System Design thay đổi cách tư duy của kỹ sư

Khi chỉ xây dựng một tính năng, ta thường tập trung vào một đoạn mã hoặc một thành phần riêng lẻ. Tư duy System Design buộc ta quan sát **toàn bộ hệ thống** và mối quan hệ giữa các phần.

Trước một quyết định kiến trúc, kỹ sư cần cân nhắc đồng thời:

- Mục tiêu kinh doanh.
- Yêu cầu kỹ thuật.
- Các giới hạn hiện có.
- Chi phí xây dựng và vận hành.
- Hiệu năng mong muốn.
- Độ phức tạp khi triển khai, giám sát và bảo trì.

Nhờ đó, câu hỏi không còn đơn thuần là _“Giải pháp này có chạy không?”_, mà trở thành:

> “Giải pháp này có phù hợp với yêu cầu, quy mô, ngân sách và khả năng vận hành của tổ chức không?”

#### Vai trò trong quá trình phát triển nghề nghiệp

System Design ngày càng có giá trị khi một kỹ sư tiến lên các vị trí có phạm vi ảnh hưởng lớn hơn.

Senior Engineer, Tech Lead và Software Architect thường được kỳ vọng có thể:

- Đưa ra quyết định kiến trúc.
- Đánh giá nhiều phương án khác nhau.
- Giải thích ưu và nhược điểm của từng phương án.
- Định hướng kỹ thuật cho đội ngũ.
- Dự đoán tác động dài hạn của một quyết định.

System Design cung cấp một khung tư duy để thực hiện các trách nhiệm này một cách có hệ thống, thay vì chỉ dựa vào trực giác.

#### Không có thiết kế hoàn hảo

Trong thực tế, hiếm khi tồn tại một phương án tốt nhất về mọi mặt. Hầu hết quyết định kiến trúc đều chứa **trade-off**: lựa chọn một lợi ích thường đồng nghĩa với việc chấp nhận thêm chi phí hoặc hạn chế ở khía cạnh khác.

Ví dụ:

| Lựa chọn | Lợi ích | Chi phí hoặc hạn chế có thể gặp |
|---|---|---|
| Thêm cache | Phản hồi nhanh hơn, giảm tải cơ sở dữ liệu | Dữ liệu có thể cũ; hệ thống khó đồng bộ hơn |
| Nhân bản dữ liệu | Tăng khả năng đọc và độ sẵn sàng | Tốn thêm tài nguyên; khó đảm bảo tính nhất quán |
| Chia nhỏ thành nhiều dịch vụ | Có thể triển khai và mở rộng từng phần độc lập | Giao tiếp, giám sát và vận hành phức tạp hơn |
| Tăng số lượng máy chủ | Xử lý được lưu lượng lớn hơn | Chi phí hạ tầng và điều phối tăng |

Khả năng nhận diện, phân tích và giải thích những đánh đổi này là một đặc điểm quan trọng của kỹ sư giàu kinh nghiệm.

#### System Design và phỏng vấn

System Design đúng là một phần quan trọng trong nhiều cuộc phỏng vấn kỹ thuật. Tuy nhiên, mục tiêu học tập không nên chỉ là ghi nhớ các “đáp án mẫu”.

Khi thực sự hiểu nguyên lý của hệ thống có khả năng mở rộng và đáng tin cậy, người học sẽ:

1. Có thể lập luận trước những bài toán chưa từng gặp.
2. Giải thích được vì sao mình chọn một phương án.
3. Điều chỉnh thiết kế khi yêu cầu thay đổi.
4. Làm tốt hơn trong phỏng vấn như một hệ quả tự nhiên.
5. Quan trọng hơn, xây dựng được hệ thống hoạt động hiệu quả trong thực tế.

#### Ý chính cần nhớ

- System Design không chỉ dành cho phỏng vấn mà là kỹ năng thực tế của kỹ sư phần mềm.
- Mã nguồn giải quyết vấn đề trước mắt; thiết kế tốt giúp giải pháp tiếp tục hoạt động khi quy mô tăng.
- Một hệ thống chạy tốt trong môi trường phát triển chưa chắc chịu được lưu lượng thực tế.
- Tư duy System Design chuyển trọng tâm từ một tính năng riêng lẻ sang toàn bộ hệ thống.
- Quyết định kiến trúc phải xét đến kinh doanh, kỹ thuật, chi phí, hiệu năng và vận hành.
- Không có thiết kế hoàn hảo; điều quan trọng là hiểu và giải thích được trade-off.
- Năng lực System Design trở nên thiết yếu khi đảm nhận vai trò Senior Engineer, Tech Lead hoặc Architect.
- Hiểu sâu nguyên lý sẽ giúp ích cho cả công việc thực tế lẫn phỏng vấn.

#### Công thức ghi nhớ

> **Code giúp giải quyết vấn đề hôm nay; System Design giúp giải pháp tiếp tục tồn tại khi quy mô và yêu cầu thay đổi.**

---

### Bài 4. Sự phát triển của System Design trong 25 năm qua

#### Vì sao cần nhìn lại lịch sử?

Muốn hiểu kiến trúc hiện đại, ta nên biết phần mềm đã phát triển như thế nào trong vài thập kỷ gần đây. Phần lớn công nghệ, mẫu thiết kế và thực hành tốt ngày nay không xuất hiện một cách ngẫu nhiên. Chúng được tạo ra để giải quyết những vấn đề mới khi hệ thống ngày càng lớn.

Nói cách khác:

> **Quy mô tăng → Kiến trúc cũ bộc lộ giới hạn → Vấn đề mới xuất hiện → Giải pháp và mẫu kiến trúc mới ra đời.**

#### Dòng thời gian phát triển

| Giai đoạn | Bối cảnh và kiến trúc phổ biến | Vấn đề hoặc thay đổi chính |
|---|---|---|
| Cuối thập niên 1990 – đầu những năm 2000 | Ứng dụng nguyên khối kết nối với một cơ sở dữ liệu | Lưu lượng còn nhỏ, yêu cầu của người dùng chưa cao và ít hệ thống phải hoạt động trên phạm vi toàn cầu |
| Internet tăng trưởng mạnh | Bổ sung load balancer, cache, CDN và database replication | Mạng xã hội, thương mại điện tử và số người dùng Internet tăng nhanh khiến kiến trúc đơn giản bắt đầu chạm giới hạn |
| Kỷ nguyên cloud computing | Cấp phát hạ tầng theo nhu cầu thay vì tự mua và quản lý máy chủ vật lý | Cách triển khai, vận hành và mở rộng hệ thống thay đổi đáng kể |
| Hệ thống và tổ chức tiếp tục mở rộng | NoSQL, microservices, event-driven architecture, API gateway và messaging platform trở nên phổ biến | Cần mở rộng cả năng lực công nghệ lẫn khả năng làm việc độc lập của nhiều đội ngũ |
| Hiện nay | Nền tảng toàn cầu, trải nghiệm thời gian thực, ứng dụng AI và edge computing | Kiến trúc ưu tiên độ trễ thấp, co giãn linh hoạt, khả năng quan sát, bảo mật và sức chống chịu khi vận hành |

#### Giai đoạn 1: Monolith và một cơ sở dữ liệu

Cuối thập niên 1990 và đầu những năm 2000, nhiều ứng dụng có kiến trúc khá đơn giản:

```text
Người dùng → Ứng dụng nguyên khối → Cơ sở dữ liệu
```

Toàn bộ chức năng thường nằm trong một ứng dụng duy nhất và kết nối với một cơ sở dữ liệu. Cách thiết kế này thường đã đủ vì:

- Lượng người dùng và lưu lượng còn thấp.
- Kỳ vọng về tốc độ và độ sẵn sàng chưa cao như hiện nay.
- Hệ thống hiếm khi phải phục vụ người dùng trên toàn cầu.

Monolith không mặc nhiên là một kiến trúc xấu. Nó phù hợp với nhiều hệ thống nhỏ và giúp phát triển ban đầu nhanh hơn. Vấn đề xuất hiện khi quy mô vượt quá khả năng đáp ứng của kiến trúc hiện tại.

#### Giai đoạn 2: Internet tăng trưởng và hệ thống phân tán

Khi mạng xã hội, thương mại điện tử và Internet phát triển nhanh, những kiến trúc đơn giản dần chạm giới hạn. Để xử lý lưu lượng lớn hơn và cải thiện hiệu năng, các hệ thống bắt đầu sử dụng:

- **Load balancing:** phân phối yêu cầu đến nhiều máy chủ.
- **Caching:** phục vụ nhanh những dữ liệu được truy cập thường xuyên.
- **CDN:** đưa nội dung đến vị trí gần người dùng hơn.
- **Database replication:** tạo nhiều bản sao cơ sở dữ liệu để tăng khả năng đọc và độ sẵn sàng.

Thay vì chỉ dựa vào một ứng dụng và một cơ sở dữ liệu, hệ thống bắt đầu gồm nhiều thành phần phối hợp với nhau. Đây là bước chuyển quan trọng sang các **hệ thống phân tán quy mô lớn**.

#### Giai đoạn 3: Cloud computing

Cloud computing tạo ra một thay đổi lớn về cách sở hữu và sử dụng hạ tầng. Trước đây, tổ chức thường phải mua, lắp đặt và tự quản lý máy chủ vật lý. Với cloud, họ có thể cấp phát tài nguyên theo nhu cầu.

Sự thay đổi này giúp:

- Triển khai hạ tầng nhanh hơn.
- Tăng hoặc giảm tài nguyên linh hoạt theo lưu lượng.
- Thử nghiệm và đưa sản phẩm ra thị trường nhanh hơn.
- Chuyển một phần chi phí đầu tư ban đầu thành chi phí sử dụng thực tế.

Từ đây, kiến trúc không chỉ được thiết kế cho một số lượng máy chủ cố định mà còn có thể tận dụng tài nguyên co giãn.

#### Giai đoạn 4: NoSQL và sự phân rã hệ thống

Khi dữ liệu đạt quy mô rất lớn, cơ sở dữ liệu quan hệ truyền thống gặp khó khăn trong một số loại bài toán. Các hệ quản trị **NoSQL** xuất hiện để phục vụ những nhu cầu như mở rộng theo chiều ngang, xử lý khối lượng dữ liệu lớn hoặc hỗ trợ mô hình dữ liệu linh hoạt.

NoSQL không thay thế hoàn toàn cơ sở dữ liệu quan hệ. Mỗi loại phù hợp với những yêu cầu và trade-off khác nhau.

Đồng thời, nhiều tổ chức bắt đầu chia monolith lớn thành các dịch vụ nhỏ hơn. Những mô hình và thành phần sau trở nên phổ biến:

- **Microservices:** chia hệ thống thành các dịch vụ có trách nhiệm riêng.
- **Event-driven architecture:** các thành phần phản ứng với sự kiện thay vì phụ thuộc hoàn toàn vào lời gọi trực tiếp.
- **API gateway:** cung cấp một điểm vào chung và điều phối yêu cầu đến các dịch vụ phía sau.
- **Messaging platform:** truyền thông điệp giữa các thành phần theo cách bất đồng bộ.

Mục tiêu không chỉ là mở rộng công nghệ. Việc tách hệ thống còn cho phép nhiều đội ngũ phát triển, triển khai và mở rộng từng phần tương đối độc lập.

Tuy nhiên, kiến trúc phân tán cũng làm tăng độ phức tạp về giao tiếp mạng, dữ liệu, giám sát, xử lý lỗi và vận hành. Vì vậy, không nên lựa chọn microservices chỉ vì nó phổ biến.

#### Giai đoạn 5: Kiến trúc hiện đại

Ngày nay, các hệ thống phải hỗ trợ trải nghiệm thời gian thực, ứng dụng có AI, nền tảng toàn cầu và xử lý tại biên mạng (*edge computing*). Vì thế, kiến trúc hiện đại ngày càng chú trọng:

| Thuộc tính | Mục tiêu |
|---|---|
| **Low latency** | Giảm thời gian từ lúc gửi yêu cầu đến khi nhận phản hồi. |
| **Elasticity** | Tự tăng hoặc giảm tài nguyên theo nhu cầu thực tế. |
| **Observability** | Hiểu trạng thái bên trong hệ thống thông qua log, metric và trace. |
| **Security** | Bảo vệ hệ thống, dữ liệu và người dùng ở mọi lớp. |
| **Operational resilience** | Tiếp tục vận hành hoặc phục hồi nhanh khi xảy ra lỗi. |

#### Điều thay đổi và điều không đổi

System Design luôn tiến hóa:

- Công nghệ thay đổi.
- Mẫu kiến trúc thay đổi.
- Quy mô hệ thống thay đổi.
- Kỳ vọng của người dùng thay đổi.

Nhưng mục tiêu nền tảng vẫn giống nhau: **thiết kế một hệ thống đáp ứng yêu cầu kinh doanh và vẫn có khả năng mở rộng, đáng tin cậy, dễ bảo trì khi phát triển.**

#### Ý chính cần nhớ

- Các mẫu kiến trúc hiện đại được sinh ra để giải quyết những giới hạn thực tế của giai đoạn trước.
- Monolith từng đáp ứng tốt khi quy mô hệ thống còn nhỏ và vẫn có thể là lựa chọn phù hợp ngày nay.
- Load balancing, caching, CDN và replication giúp hệ thống xử lý lưu lượng ngày càng lớn.
- Cloud computing biến hạ tầng thành tài nguyên có thể cấp phát và co giãn theo nhu cầu.
- NoSQL giải quyết một số bài toán dữ liệu quy mô lớn mà mô hình quan hệ khó đáp ứng hiệu quả.
- Microservices và kiến trúc hướng sự kiện giúp mở rộng hệ thống và đội ngũ, nhưng làm tăng độ phức tạp vận hành.
- Kiến trúc hiện đại chú trọng độ trễ, tính co giãn, khả năng quan sát, bảo mật và khả năng chống chịu.
- Không nên chạy theo công nghệ mới; phải hiểu vấn đề mà công nghệ đó được tạo ra để giải quyết.

#### Công thức ghi nhớ

> **Công nghệ và mẫu kiến trúc sẽ tiếp tục thay đổi; mục tiêu cốt lõi vẫn là đáp ứng nhu cầu kinh doanh bằng một hệ thống có thể mở rộng, đáng tin cậy và dễ bảo trì.**

---

### Bài 5. Cấu trúc của khóa học

#### Vì sao thứ tự học quan trọng?

System Design là một lĩnh vực rộng và các khái niệm phụ thuộc chặt chẽ vào nhau. Vì vậy, nội dung khóa học được sắp xếp theo hướng **xây dựng kiến thức từng lớp**, từ nền tảng đến ứng dụng thực tế.

Ví dụ:

- Khó hiểu cơ sở dữ liệu phân tán nếu chưa nắm được khả năng mở rộng.
- Khó phân tích độ tin cậy nếu chưa hiểu kiến trúc hệ thống và các kiểu giao tiếp.
- Khó tối ưu hiệu năng nếu chưa biết dữ liệu được lưu trữ, truy xuất và truyền đi như thế nào.

Việc học theo đúng trình tự giúp người học không chỉ biết từng khái niệm riêng lẻ mà còn hiểu vì sao chúng tồn tại và liên hệ với nhau ra sao.

#### Bản đồ nội dung khóa học

Khóa học phát triển theo trình tự tổng quát sau:

```text
Nền tảng System Design
          ↓
Nguyên lý ra quyết định kiến trúc
          ↓
Networking và các kiểu giao tiếp
          ↓
Kỹ thuật mở rộng hệ thống
          ↓
Hệ thống lưu trữ
          ↓
Tối ưu hiệu năng
          ↓
Reliability Engineering
          ↓
Kiến trúc bảo mật
          ↓
Các bài toán System Design thực tế
```

Các lớp kiến thức chính gồm:

| Lớp kiến thức | Câu hỏi trọng tâm |
|---|---|
| **Nền tảng System Design** | Một hệ thống gồm những gì và quyết định kiến trúc dựa trên nguyên tắc nào? |
| **Networking** | Yêu cầu và dữ liệu di chuyển qua mạng như thế nào? |
| **Communication patterns** | Các thành phần giao tiếp đồng bộ, bất đồng bộ hoặc thông qua sự kiện ra sao? |
| **Scalability** | Làm thế nào để hệ thống xử lý được nhiều người dùng và dữ liệu hơn? |
| **Storage systems** | Dữ liệu nên được lưu, tổ chức, sao chép và truy xuất như thế nào? |
| **Performance optimization** | Làm thế nào để giảm độ trễ và tăng thông lượng? |
| **Reliability engineering** | Hệ thống duy trì dịch vụ và phục hồi như thế nào khi có lỗi? |
| **Security architecture** | Làm thế nào để bảo vệ người dùng, dữ liệu và các thành phần hệ thống? |
| **Case studies** | Kết hợp các nguyên lý trên để giải quyết một bài toán thực tế như thế nào? |

#### Các chủ đề tác động lẫn nhau

System Design không phải tập hợp các mảng kiến thức độc lập. Một quyết định ở một phần có thể tạo ra tác động dây chuyền tới toàn bộ kiến trúc:

```text
Scalability → Storage → Performance → Reliability → Architecture
```

Cụ thể:

- Yêu cầu mở rộng ảnh hưởng đến cách lựa chọn và phân chia nơi lưu trữ.
- Cách lưu trữ và truy xuất dữ liệu ảnh hưởng trực tiếp đến hiệu năng.
- Đặc tính hiệu năng có thể ảnh hưởng đến độ ổn định khi hệ thống chịu tải cao.
- Yêu cầu về độ tin cậy quyết định cách tổ chức thành phần, dự phòng và xử lý lỗi.
- Kiến trúc tổng thể lại tạo ra những giới hạn hoặc cơ hội mở rộng mới.

Trên thực tế, mối quan hệ này không chỉ đi theo một chiều. Các quyết định thường tác động qua lại, do đó thiết kế hệ thống là một quá trình lặp: đề xuất, đánh giá, điều chỉnh và kiểm chứng.

#### Tư duy toàn hệ thống

Một lập trình viên thường tập trung vào việc hoàn thành tốt thành phần mình phụ trách. Khi tư duy như một kiến trúc sư, phạm vi quan sát cần rộng hơn:

- Thành phần này tác động đến phần còn lại của hệ thống như thế nào?
- Một quyết định cục bộ có tạo ra vấn đề ở nơi khác không?
- Giải pháp có đáp ứng mục tiêu chung của sản phẩm và tổ chức không?
- Hệ thống có còn vận hành tốt khi tải, dữ liệu hoặc đội ngũ tăng lên không?

Khả năng nhìn thấy và phân tích những mối liên hệ này là điểm khác biệt quan trọng giữa tư duy kiến trúc và việc chỉ tối ưu từng thành phần riêng lẻ.

#### Học qua các bài toán thực tế

Sau khi xây dựng đủ nền tảng, khóa học sẽ kết hợp các khái niệm thông qua những **case study về hệ thống quy mô lớn**.

Khi phân tích một hệ thống thực tế, điều quan trọng không chỉ là biết kiến trúc cuối cùng gồm những thành phần nào. Cần hiểu:

1. Bài toán và yêu cầu ban đầu là gì?
2. Những ràng buộc nào ảnh hưởng đến thiết kế?
3. Vì sao một phương án được lựa chọn?
4. Những phương án nào đã được cân nhắc nhưng không sử dụng?
5. Thiết kế chấp nhận những trade-off nào?

Tư duy đằng sau quyết định có giá trị lâu dài hơn việc ghi nhớ sơ đồ của một hệ thống cụ thể.

#### Khung giải quyết bài toán System Design

Xuyên suốt khóa học, người học sẽ xây dựng một quy trình có cấu trúc để tiếp cận bài toán:

```text
Làm rõ yêu cầu
      ↓
Xác định ràng buộc và quy mô
      ↓
Đề xuất kiến trúc tổng quan
      ↓
Phân tích từng thành phần quan trọng
      ↓
Đánh giá trade-off và điểm nghẽn
      ↓
Điều chỉnh và giải thích quyết định
```

Khung tư duy này phục vụ hai mục đích:

- Thiết kế hệ thống thực tế một cách có phương pháp.
- Trình bày rõ ràng quá trình suy nghĩ trong thảo luận kiến trúc và phỏng vấn System Design.

#### Mục tiêu thật sự của khóa học

Mục tiêu không phải là học thuộc tên công nghệ, sơ đồ hay một kiến trúc mẫu. Công nghệ có thể thay đổi và cùng một bài toán có thể có nhiều phương án phù hợp.

Năng lực cần phát triển là:

- Lập luận về hành vi của toàn bộ hệ thống.
- Kết nối các khái niệm kỹ thuật với yêu cầu kinh doanh.
- Nhận diện ràng buộc và điểm nghẽn.
- So sánh các phương án dựa trên trade-off.
- Đưa ra và giải thích quyết định kiến trúc hợp lý.
- Áp dụng nguyên lý ngay cả khi công nghệ cụ thể thay đổi.

#### Ý chính cần nhớ

- Nội dung được học theo từng lớp vì nhiều khái niệm System Design phụ thuộc lẫn nhau.
- Cần nắm nền tảng trước khi tiếp cận cơ sở dữ liệu phân tán, reliability hoặc kiến trúc phức tạp.
- Scalability, storage, performance, reliability và architecture ảnh hưởng qua lại.
- Tư duy kiến trúc đòi hỏi nhìn toàn hệ thống thay vì chỉ một thành phần.
- Case study được dùng để kết nối nguyên lý với bài toán thực tế.
- Cần hiểu lý do đằng sau một quyết định, không chỉ ghi nhớ kiến trúc cuối cùng.
- Một khung giải quyết có cấu trúc giúp cả thiết kế thực tế lẫn giao tiếp trong phỏng vấn.
- Mục tiêu cuối cùng là biết lập luận và đánh giá trade-off, bất kể công nghệ được sử dụng.

#### Công thức ghi nhớ

> **Không học thuộc kiến trúc; hãy học cách đặt câu hỏi, kết nối các yếu tố, đánh giá trade-off và giải thích quyết định.**

---

### Bài 6. Cách học khóa System Design hiệu quả

#### Học System Design là xây dựng một cách tư duy

System Design không phải là tập hợp những chủ đề độc lập để học thuộc. Đây là cách suy nghĩ về một hệ thống phức tạp trong các điều kiện thực tế như:

- Quy mô ngày càng tăng.
- Yêu cầu về độ tin cậy.
- Giới hạn chi phí và tài nguyên.
- Độ phức tạp trong triển khai và vận hành.
- Những trade-off giữa các mục tiêu khác nhau.

Cách nhanh nhất để hình thành tư duy này là học theo tiến trình đã được thiết kế: **nắm nền tảng trước, sau đó mới đi sâu vào các thành phần và kiến trúc phức tạp**.

#### Nền tảng giúp giảm việc học thuộc

Phần kiến thức nền tảng xây dựng các mô hình tư duy mà kiến trúc sư sử dụng hằng ngày. Khi nền tảng đủ chắc, việc học cache, cơ sở dữ liệu, hệ thống messaging hoặc kiến trúc phân tán sẽ tập trung vào câu hỏi quan trọng hơn:

> “Trong hoàn cảnh này, vì sao ta chọn giải pháp đó và phải chấp nhận những đánh đổi nào?”

Nền tảng tốt giúp giảm lượng kiến thức phải ghi nhớ máy móc. Khi quên một giải pháp cụ thể, ta vẫn có thể suy luận từ yêu cầu, ràng buộc và nguyên lý để tìm ra phương án hợp lý.

#### Đừng bắt đầu case study bằng sơ đồ

Khi học một bài toán thực tế, người học thường muốn xem ngay sơ đồ kiến trúc. Tuy nhiên, những ô vuông và mũi tên chỉ thể hiện kết quả cuối cùng; chúng không tự giải thích được quá trình ra quyết định.

Trong dự án và phỏng vấn thực tế, chất lượng giải pháp phụ thuộc vào việc hiểu đúng bài toán trước khi vẽ. Trình tự nên là:

```text
Hiểu yêu cầu
      ↓
Xác định phạm vi và ràng buộc
      ↓
Ước lượng quy mô cần thiết
      ↓
Xác định các thuộc tính ưu tiên
      ↓
Phân tích trade-off
      ↓
Đề xuất và vẽ kiến trúc
```

Một sơ đồ đẹp nhưng dựa trên yêu cầu chưa rõ ràng vẫn có thể là một thiết kế sai.

Khung phân tích được sử dụng xuyên suốt khóa học nhằm biến quá trình suy nghĩ này thành một thói quen **có cấu trúc và có thể lặp lại**.

#### Khi gặp khái niệm chưa biết

Khái niệm mới không phải là chướng ngại khiến ta phải bỏ dở toàn bộ bài học. Cách xử lý hiệu quả là:

1. Tạm dừng tại điểm chưa hiểu.
2. Ghi lại thuật ngữ và câu hỏi cụ thể.
3. Dành vài phút tìm hiểu định nghĩa và mục đích cơ bản.
4. Quay lại bài học và đặt khái niệm vào đúng ngữ cảnh.
5. Bổ sung mối liên hệ với những kiến thức đã học.

Không nhất thiết phải nghiên cứu mọi chi tiết ngay lần đầu. Mục tiêu trước mắt là hiểu đủ để theo dõi quyết định thiết kế; có thể đào sâu sau nếu khái niệm đó quan trọng đối với bài toán.

#### Học chủ động thay vì chỉ xem liên tục

Chuyên môn System Design được hình thành bằng cách kết nối nhiều khái niệm nhỏ theo thời gian, không phải bằng việc xem liên tục toàn bộ video từ đầu đến cuối.

Sau mỗi bài, nên tự kiểm tra bằng các câu hỏi:

- Khái niệm này giải quyết vấn đề gì?
- Khi nào nên và không nên sử dụng nó?
- Nó cải thiện thuộc tính nào của hệ thống?
- Nó làm tăng chi phí hoặc độ phức tạp ở đâu?
- Nó liên quan đến những chủ đề đã học như thế nào?
- Nếu yêu cầu thay đổi, quyết định này có còn phù hợp không?

Có thể củng cố kiến thức bằng cách tự giải thích lại nội dung, phác thảo luồng xử lý hoặc áp dụng nguyên lý vào một hệ thống quen thuộc.

#### Mọi quyết định đều có tác động dây chuyền

Khi học sâu hơn, ta sẽ thấy gần như mọi chủ đề trong System Design đều liên quan đến nhau:

```text
Tối ưu performance
        ↓
Thay đổi khả năng scalability
        ↓
Ảnh hưởng đến reliability
        ↓
Làm tăng cost hoặc complexity
```

Ví dụ, thêm nhiều bản sao dữ liệu có thể tăng khả năng đọc và độ sẵn sàng, nhưng đồng thời làm tăng chi phí và độ phức tạp của việc giữ dữ liệu nhất quán.

Kỹ sư có kinh nghiệm không chỉ nhìn vào lợi ích trực tiếp của một quyết định. Họ còn tìm những tác động bậc hai: quyết định đó ảnh hưởng như thế nào đến các phần khác và đến việc vận hành lâu dài.

#### Vì sao nên học lại lần thứ hai?

Sau khi hoàn thành khóa học một lần, nên quay lại xem và ôn tập lần thứ hai:

| Lượt học | Mục tiêu chính |
|---|---|
| **Lần thứ nhất** | Hiểu từng khái niệm, thành phần và kỹ thuật riêng lẻ. |
| **Lần thứ hai** | Nhìn thấy mối quan hệ giữa các khái niệm và cách toàn bộ hệ thống phối hợp. |

Ở lần đầu, nhiều thuật ngữ còn mới nên sự chú ý chủ yếu dành cho từng thành phần. Sau khi đã có một bức tranh tổng quan, lần học thứ hai giúp nhận ra vì sao các quyết định liên kết với nhau.

Sự chuyển đổi từ **học từng thành phần** sang **hiểu mối quan hệ giữa các thành phần** chính là điểm khởi đầu của tư duy kiến trúc.

#### Quy trình học đề xuất

```text
Học theo đúng trình tự
        ↓
Ghi lại khái niệm và câu hỏi
        ↓
Tạm nghiên cứu khi gặp điểm chưa hiểu
        ↓
Tự giải thích vấn đề và trade-off
        ↓
Áp dụng vào case study
        ↓
Hoàn thành toàn bộ khóa học
        ↓
Ôn lại để kết nối các chủ đề
```

#### Ý chính cần nhớ

- Hãy học System Design như một cách tư duy, không phải danh sách công nghệ cần thuộc.
- Theo đúng tiến trình để nền tảng hỗ trợ các chủ đề phức tạp ở phần sau.
- Hiểu nguyên lý giúp tự suy luận khi không nhớ một giải pháp cụ thể.
- Với case study, phải làm rõ yêu cầu, ràng buộc và trade-off trước khi vẽ sơ đồ.
- Khi gặp thuật ngữ lạ, hãy tạm tìm hiểu rồi quay lại bài học thay vì xem tiếp trong trạng thái không hiểu.
- Học chủ động bằng cách đặt câu hỏi và kết nối kiến thức hiệu quả hơn chỉ xem video liên tục.
- Mỗi quyết định có thể tác động đến performance, scalability, reliability, cost và complexity.
- Lần học đầu giúp hiểu thành phần; lần học thứ hai giúp hiểu các mối quan hệ.
- Tư duy kiến trúc bắt đầu khi ta nhìn thấy toàn hệ thống thay vì từng bộ phận riêng lẻ.

#### Công thức ghi nhớ

> **Lượt đầu học các thành phần; lượt sau học các mối quan hệ; mỗi lần giải bài đều bắt đầu từ yêu cầu và trade-off, không phải từ sơ đồ.**

---

### Tổng kết Phần 1 — Introduction

Sau phần mở đầu, cần nắm được bức tranh tổng quát sau:

1. System Design là quá trình chuyển yêu cầu kinh doanh thành kiến trúc kỹ thuật.
2. Một hệ thống tốt không chỉ đúng chức năng mà còn cần khả năng mở rộng, độ tin cậy, hiệu năng và khả năng bảo trì.
3. Thiết kế hệ thống là quá trình ra quyết định trong điều kiện có nhiều ràng buộc và không có phương án hoàn hảo.
4. Các kiến trúc hiện đại hình thành từ những bài toán tăng trưởng thực tế của 25 năm qua.
5. Các chủ đề System Design phụ thuộc lẫn nhau và cần được học theo từng lớp.
6. Mục tiêu là phát triển khả năng lập luận, đánh giá trade-off và giải thích quyết định.
7. Hiểu mối quan hệ giữa các thành phần quan trọng hơn việc ghi nhớ sơ đồ hoặc tên công nghệ.

> **Tư duy cốt lõi của Phần 1:** Bắt đầu từ bài toán, hiểu các ràng buộc, nhìn toàn hệ thống và đưa ra quyết định dựa trên trade-off.

---

## Phần 2 — Networking & Communication (System Design Fundamentals)

### Bài 7. Nhập môn Networking trong System Design

#### Networking giữ vai trò gì trong hệ thống?

Networking là lớp giao tiếp kết nối các thành phần của một hệ thống phân tán. Nó cho phép request, dữ liệu và dịch vụ di chuyển giữa trình duyệt, API, máy chủ ứng dụng, cache, cơ sở dữ liệu và các dịch vụ bên ngoài.

Khi mới học System Design, ta thường chú ý nhiều đến mã nguồn, cơ sở dữ liệu và hạ tầng. Tuy nhiên, khi quy mô tăng lên, một thực tế quan trọng xuất hiện:

> **Nhiều thành phần dành nhiều thời gian để giao tiếp với nhau hơn là thực hiện tính toán.**

Vì vậy, mạng trở thành một lớp “vô hình” nhưng có ảnh hưởng lớn đến hiệu quả vận hành của toàn hệ thống.

#### Một thao tác đơn giản có thể đi qua nhiều thành phần

Các hành động như mở trang web, đặt hàng hoặc gửi tin nhắn có vẻ đơn giản đối với người dùng, nhưng phía sau có thể kích hoạt một chuỗi giao tiếp:

```text
Người dùng
    ↓
Trình duyệt hoặc ứng dụng
    ↓
API / API Gateway
    ↓
Máy chủ ứng dụng
    ├──→ Cache
    ├──→ Cơ sở dữ liệu
    └──→ Dịch vụ bên ngoài
```

Không thành phần nào trong số này tạo ra đầy đủ giá trị nếu hoạt động riêng lẻ. Networking biến chúng thành một hệ thống phối hợp thống nhất.

#### Networking tác động đến các thuộc tính chất lượng

Khi hệ thống còn nhỏ, mạng thường chưa phải điểm nghẽn: số máy ít, lưu lượng dễ kiểm soát và thời gian phản hồi khá ổn định. Khi hệ thống lớn lên, những giả định đó không còn đúng.

Networking bắt đầu ảnh hưởng trực tiếp đến:

| Thuộc tính | Ảnh hưởng của networking |
|---|---|
| **Scalability** | Request phải được phân phối hợp lý đến nhiều máy; dữ liệu phải di chuyển giữa các dịch vụ mà không tạo điểm nóng. |
| **Performance** | Độ trễ mạng và số lần truyền qua các thành phần có thể chiếm phần lớn thời gian phản hồi. |
| **Reliability** | Đường truyền phải tiếp tục hoạt động hoặc được thay thế khi máy, liên kết mạng hay khu vực gặp lỗi. |
| **Availability** | Lưu lượng cần được chuyển hướng đến những thành phần và khu vực còn hoạt động. |
| **Security** | Dữ liệu phải được bảo vệ trong quá trình truyền và lưu lượng phải được kiểm soát. |
| **User experience** | Độ trễ, lỗi kết nối và chi phí giao tiếp cuối cùng đều thể hiện thành trải nghiệm nhanh, chậm hoặc gián đoạn. |

#### Scalability không chỉ là thêm máy chủ

Khi hàng triệu người dùng cùng truy cập một dịch vụ, bài toán không chỉ là có đủ năng lực xử lý. Hệ thống còn phải **đưa request đến đúng nơi một cách hiệu quả**.

Để mở rộng theo chiều ngang, cần giải quyết các vấn đề như:

- Phân phối lưu lượng giữa nhiều máy.
- Tránh một máy hoặc dịch vụ trở thành điểm nóng (*hotspot*).
- Di chuyển dữ liệu giữa các microservice hiệu quả.
- Sử dụng cân bằng tài nguyên trên toàn hệ thống.
- Phát hiện thành phần gặp lỗi và ngừng gửi request đến đó.

Vì vậy, kiến trúc mạng tốt là điều kiện giúp **horizontal scaling** trở nên khả thi.

#### Chi phí giao tiếp có thể lớn hơn chi phí tính toán

Một truy vấn cơ sở dữ liệu chỉ mất vài mili giây vẫn chưa đủ để tạo ra phản hồi nhanh nếu request phải mất nhiều thời gian để đi đến cơ sở dữ liệu và quay trở lại.

Thời gian phản hồi tổng thể có thể hình dung đơn giản như sau:

```text
Response time
= Thời gian truyền qua mạng
+ Thời gian chờ
+ Thời gian xử lý
+ Thời gian truyền kết quả về
```

Khi kiến trúc ngày càng phân tán, request có thể đi qua nhiều dịch vụ. Mỗi chặng mạng (*network hop*) đều làm tăng độ trễ và tạo thêm một điểm có khả năng xảy ra lỗi.

Do đó, kiến trúc sư thường tìm cách:

- Giảm các network hop không cần thiết.
- Hạn chế những lời gọi dịch vụ quá nhỏ và quá thường xuyên.
- Đưa dữ liệu hoặc nội dung đến gần người dùng hơn.
- Lựa chọn giao tiếp đồng bộ hay bất đồng bộ phù hợp.
- Cache dữ liệu tại vị trí hợp lý.

#### Networking là nền tảng của resilience

Trong môi trường production, lỗi phần cứng, máy chủ quá tải, đứt kết nối và sự cố cả khu vực là điều sớm muộn sẽ xảy ra.

Hệ thống lớn duy trì hoạt động nhờ khả năng:

- Chuyển hướng lưu lượng khỏi thành phần bị lỗi.
- Cô lập lỗi để tránh lan sang toàn hệ thống.
- Duy trì nhiều đường giao tiếp hoặc phương án dự phòng.
- Phân phối dịch vụ trên nhiều máy hoặc khu vực.
- Khôi phục kết nối và hoạt động sau sự cố.

Reliability vì thế không chỉ là xử lý lỗi trong mã nguồn. Nó còn phụ thuộc vào việc đường giao tiếp có tiếp tục hoạt động khi một máy, một liên kết hoặc cả một region gặp vấn đề hay không.

#### Vai trò trong kiến trúc cloud-native

Các mô hình hiện đại phụ thuộc rất mạnh vào giao tiếp mạng:

- **Microservices:** nhiều dịch vụ trao đổi request hoặc message liên tục.
- **Distributed databases:** dữ liệu được sao chép và đồng bộ giữa nhiều node.
- **Multi-region deployment:** người dùng và dịch vụ được phục vụ từ nhiều khu vực địa lý.
- **Hybrid cloud:** hệ thống giao tiếp giữa hạ tầng tại chỗ và nhiều môi trường cloud.

Ở quy mô lớn, muốn hiểu hành vi của ứng dụng thì phải hiểu thông tin di chuyển giữa các thành phần như thế nào. Hành vi của mạng thường định hình hành vi của toàn hệ thống.

#### Những quyết định kiến trúc thực chất là quyết định networking

Nhiều chủ đề quen thuộc trong System Design đều là cơ chế quản lý giao tiếp:

| Thành phần hoặc kỹ thuật | Bài toán giao tiếp được giải quyết |
|---|---|
| **Load balancer** | Phân phối request đến nhiều máy hoặc instance. |
| **Cache** | Giảm số lần phải truyền request đến nguồn dữ liệu phía sau. |
| **CDN** | Phục vụ nội dung từ vị trí gần người dùng để giảm độ trễ. |
| **Proxy** | Đứng giữa các bên giao tiếp để định tuyến, kiểm soát hoặc che giấu chi tiết hệ thống. |
| **API gateway** | Quản lý điểm vào, định tuyến, bảo mật và chính sách truy cập dịch vụ. |
| **Messaging system** | Cho phép các thành phần giao tiếp bất đồng bộ và giảm phụ thuộc trực tiếp. |
| **Global deployment** | Đưa dịch vụ đến nhiều khu vực và định tuyến người dùng đến vị trí phù hợp. |

#### Nội dung networking sẽ học trong phần này

Mục tiêu của phần này không phải đào tạo người học thành kỹ sư mạng chuyên sâu. Mục tiêu là hiểu những khái niệm networking trực tiếp ảnh hưởng đến quyết định kiến trúc trong hệ thống phân tán.

Lộ trình dự kiến:

```text
Định danh và tìm kiếm dịch vụ
        ↓
IP Addressing và DNS
        ↓
Mô hình Client–Server
        ↓
Proxy
        ↓
Load Balancing
        ↓
API Gateway
        ↓
CDN
```

Các câu hỏi chính sẽ lần lượt được trả lời:

1. Các máy nhận diện nhau bằng cách nào?
2. Request tìm đúng địa chỉ đích ra sao?
3. Client và server phối hợp như thế nào?
4. Vì sao cần đặt proxy giữa người dùng và dịch vụ?
5. Làm thế nào để hệ thống vượt qua giới hạn của một máy?
6. API gateway quản lý lưu lượng và bảo mật ra sao?
7. CDN giảm độ trễ cho người dùng toàn cầu bằng cách nào?

Khi học, nên tập trung vào **bài toán kiến trúc mà mỗi cơ chế giải quyết**, thay vì ghi nhớ một sản phẩm hoặc công nghệ cụ thể.

#### Networking không tách rời System Design

Networking không phải một chủ đề phụ nằm bên ngoài System Design. Mỗi request, lần gọi cơ sở dữ liệu, tương tác giữa dịch vụ và trải nghiệm người dùng đều phụ thuộc vào hiệu quả giao tiếp.

Khi hệ thống lớn và phân tán hơn, quyết định networking ảnh hưởng đến gần như mọi thuộc tính quan trọng: scalability, performance, reliability, availability và security.

#### Ý chính cần nhớ

- Networking là lớp kết nối và phối hợp mọi thành phần trong hệ thống phân tán.
- Ở quy mô lớn, chi phí giao tiếp có thể quan trọng hơn chi phí tính toán.
- Horizontal scaling chỉ hiệu quả khi lưu lượng được phân phối tốt giữa nhiều máy.
- Độ trễ mạng và số network hop ảnh hưởng trực tiếp đến thời gian phản hồi.
- Reliability còn phụ thuộc vào khả năng chuyển hướng lưu lượng, cô lập lỗi và duy trì đường giao tiếp.
- Microservices, distributed databases và multi-region deployment đều dựa vào mạng.
- Load balancer, cache, CDN, proxy, API gateway và messaging system đều giải quyết các khía cạnh của giao tiếp.
- Hãy học vấn đề mà mỗi cơ chế giải quyết, không chỉ học tên công nghệ.
- Hiểu mạng là điều kiện để hiểu cách hệ thống phân tán quy mô lớn thực sự vận hành.

#### Công thức ghi nhớ

> **Trong hệ thống phân tán, các thành phần chỉ tạo ra giá trị khi giao tiếp được với nhau; vì vậy, thiết kế luồng giao tiếp chính là một phần cốt lõi của System Design.**

---

### Bài 8. Tìm hiểu về IP Address

#### IP Address là gì?

Trước khi một request có thể được định tuyến qua Internet, mạng cần biết request đó xuất phát từ đâu và phải đi đến đâu. **IP address** cung cấp lớp định danh và định vị cần thiết cho quá trình này.

Mỗi thiết bị hoặc endpoint tham gia giao tiếp mạng — như client, server, load balancer hay dịch vụ — cần một địa chỉ mà các hệ thống khác có thể sử dụng để liên lạc.

```text
Nguồn gửi ── packet có địa chỉ nguồn và đích ──→ Mạng ──→ Đích nhận
```

Nếu không có cơ chế định địa chỉ:

- Packet không có đích đến rõ ràng.
- Router không biết phải chuyển dữ liệu theo hướng nào.
- Phản hồi không biết đường quay lại nguồn gửi.
- Các thành phần trong hệ thống phân tán không thể tìm thấy nhau một cách đáng tin cậy.

Ở quy mô nhỏ, IP chỉ giống như “địa chỉ của một máy”. Ở quy mô System Design, IP addressing là một phần của kiến trúc vì nó ảnh hưởng đến định tuyến, mở rộng, phân vùng mạng, bảo mật và khả năng vận hành.

#### IPv4

**IPv4** sử dụng địa chỉ dài 32 bit, thường được biểu diễn thành bốn số thập phân ngăn cách bằng dấu chấm, ví dụ:

```text
192.0.2.10
```

Với 32 bit, không gian IPv4 có khoảng:

```text
2³² ≈ 4,3 tỷ địa chỉ
```

Con số này từng được xem là rất lớn khi Internet còn nhỏ. Tuy nhiên, IPv4 không được thiết kế cho thế giới có hàng tỷ điện thoại, máy chủ cloud, thiết bị IoT và ứng dụng phân tán.

Khi Internet phát triển vượt xa những giả định ban đầu, địa chỉ IPv4 công cộng trở nên khan hiếm. Ngành công nghệ phải sử dụng các cơ chế như **private IP** và **NAT** để nhiều thiết bị có thể chia sẻ một số lượng public IP nhỏ hơn.

Những giải pháp này giúp IPv4 tiếp tục hoạt động ở quy mô lớn, nhưng cũng tạo thêm độ phức tạp:

- Khó duy trì kết nối end-to-end trực tiếp.
- Khó theo dõi một kết nối qua nhiều lớp chuyển đổi địa chỉ.
- Việc chẩn đoán sự cố phức tạp hơn.
- Cần quản lý thêm bảng ánh xạ và trạng thái NAT.
- Có thể làm mờ danh tính thật của endpoint phía sau địa chỉ chung.

Bài học kiến trúc quan trọng: **một giới hạn trong thành phần nền tảng có thể trở thành điểm nghẽn về khả năng mở rộng của toàn bộ hệ sinh thái**.

#### IPv6

**IPv6** ra đời để giải quyết giới hạn cơ bản về không gian địa chỉ. IPv6 sử dụng địa chỉ 128 bit, thường được biểu diễn bằng các nhóm số hệ thập lục phân, ví dụ:

```text
2001:db8::10
```

Việc tăng từ 32 bit lên 128 bit tạo ra không gian địa chỉ cực lớn:

```text
IPv4: 2³² địa chỉ
IPv6: 2¹²⁸ địa chỉ
```

Đây không chỉ là thay đổi về cách viết địa chỉ. IPv6 là một thiết kế hướng tới quy mô Internet dài hạn, nơi gần như mọi thiết bị, dịch vụ, cảm biến hoặc endpoint đều có thể cần một địa chỉ riêng.

Lợi ích kiến trúc quan trọng gồm:

- Giảm áp lực khan hiếm địa chỉ.
- Giảm nhu cầu phụ thuộc vào việc chia sẻ địa chỉ chỉ để tiết kiệm không gian IP.
- Có khả năng đưa mạng gần hơn với mô hình kết nối end-to-end.
- Phù hợp hơn với cloud quy mô lớn, mạng di động, edge computing và IoT.
- Giảm một phần độ phức tạp tích lũy từ các giải pháp đối phó với việc cạn kiệt IPv4.

IPv6 cho thấy một bài học về khả năng mở rộng dài hạn: khi mô hình nền tảng đã đạt giới hạn, tối ưu nhỏ có thể không đủ; đôi khi cần thiết kế lại chính mô hình đó.

#### So sánh IPv4 và IPv6

| Tiêu chí | IPv4 | IPv6 |
|---|---|---|
| Độ dài địa chỉ | 32 bit | 128 bit |
| Quy mô không gian | Khoảng 4,3 tỷ địa chỉ | Không gian địa chỉ cực lớn |
| Ví dụ | `192.0.2.10` | `2001:db8::10` |
| Bối cảnh thiết kế | Internet với số thiết bị còn tương đối ít | Thế giới có số lượng thiết bị và dịch vụ kết nối rất lớn |
| Khan hiếm địa chỉ | Là vấn đề thực tế | Được giảm đáng kể |
| Phụ thuộc vào NAT để tiết kiệm địa chỉ | Phổ biến | Ít cần hơn cho mục đích tiết kiệm địa chỉ |
| Kết nối end-to-end | Thường bị phức tạp bởi các lớp NAT | Có điều kiện tiến gần hơn tới kết nối trực tiếp |
| Mức độ phổ biến | Vẫn được sử dụng rộng rãi | Đang được triển khai nhưng chưa thay thế hoàn toàn IPv4 |

IPv6 có nhiều ưu điểm kỹ thuật nhưng IPv4 vẫn tồn tại rộng rãi. Đây là một nguyên lý thực tế quan trọng:

> **Công nghệ tốt hơn về kỹ thuật không nhất thiết được áp dụng ngay lập tức.**

Hạ tầng hiện có, yêu cầu tương thích, chi phí chuyển đổi, kỹ năng vận hành và rủi ro migration đều có thể làm chậm quá trình áp dụng một công nghệ mới.

#### Public IP và Private IP

Không phải mọi máy trong hệ thống đều nên được truy cập trực tiếp từ Internet. Trong kiến trúc production, phần lớn hạ tầng thường được đặt trong mạng private và chỉ một số ít thành phần làm điểm vào công cộng.

| Tiêu chí | Public IP | Private IP |
|---|---|---|
| Phạm vi sử dụng | Có thể được định tuyến trên Internet | Dùng trong mạng nội bộ riêng |
| Tính duy nhất | Phải được quản lý để không xung đột trên Internet | Có thể được tái sử dụng trong các mạng private tách biệt |
| Vai trò | Cung cấp khả năng tiếp cận từ bên ngoài | Cung cấp giao tiếp nội bộ và sự cô lập |
| Thành phần thường dùng | Public load balancer, API gateway, reverse proxy | Database, cache, internal API, message broker, backend service |
| Mức độ phơi bày | Có thể trở thành điểm truy cập từ Internet | Thông thường không được định tuyến trực tiếp từ Internet |

Mô hình phổ biến:

```text
Internet
   ↓
Public endpoint
(Load Balancer / API Gateway / Reverse Proxy)
   ↓
──────────────── Private Network ────────────────
   ↓                 ↓                  ↓
Backend Service    Cache             Database
```

Người dùng chỉ nhìn thấy public endpoint. Request sau đó có thể đi qua nhiều lớp hạ tầng private trước khi tới thành phần xử lý thực sự.

#### Vì sao cần Private IP?

Private IP giải quyết hai nhóm vấn đề chính.

**1. Khả năng mở rộng địa chỉ**

Một tổ chức có thể vận hành hàng nghìn hoặc hàng triệu laptop, server, container, máy ảo, database và thiết bị khác. Nếu mọi thiết bị đều cần một public IPv4 riêng, không gian địa chỉ sẽ cạn nhanh hơn nữa.

Các dải private có thể được tái sử dụng độc lập trong vô số mạng nội bộ. Hai tổ chức khác nhau có thể dùng cùng một private IP mà không xung đột, miễn là các mạng đó được tách biệt.

**2. Giảm bề mặt tấn công**

Database, cache, message broker và internal API thường không cần tiếp nhận kết nối trực tiếp từ người dùng Internet. Đặt chúng trong private network giúp giới hạn đường tiếp cận và chỉ cho phép lưu lượng qua những điểm được kiểm soát.

Tuy nhiên, cần lưu ý:

> **Private IP tự nó không phải là một cơ chế bảo mật đầy đủ.**

Mức độ bảo vệ thực tế còn phụ thuộc vào firewall rule, access control, network segmentation, xác thực, mã hóa và cấu hình định tuyến. Private addressing hỗ trợ cô lập nhưng không thay thế các lớp kiểm soát bảo mật khác.

#### NAT hoạt động ở mức khái niệm

**NAT — Network Address Translation** cho phép nhiều thiết bị private chia sẻ một hoặc một số public IP khi giao tiếp với Internet.

```text
10.0.1.10 ─┐
10.0.1.11 ─┼─→ NAT Gateway ─→ 203.0.113.20 ─→ Internet
10.0.1.12 ─┘
```

Từ phía Internet, các kết nối có thể cùng xuất hiện dưới một public IP. NAT duy trì thông tin ánh xạ để phản hồi được chuyển về đúng thiết bị bên trong.

Lợi ích:

- Tiết kiệm public IPv4.
- Cho phép nhiều tài nguyên private truy cập dịch vụ bên ngoài.
- Hạn chế việc tài nguyên nội bộ phải có địa chỉ công cộng trực tiếp.

Trade-off:

- Tăng một lớp hạ tầng và vận hành.
- Có thể trở thành điểm nghẽn hoặc điểm lỗi nếu không được thiết kế phù hợp.
- Làm việc truy vết và khắc phục sự cố khó hơn.
- Làm phức tạp kết nối trực tiếp từ bên ngoài vào endpoint bên trong.

#### Vai trò của IP trong System Design

Ở quy mô lớn, quản lý IP ảnh hưởng tới nhiều quyết định kiến trúc:

**Định tuyến và mở rộng**

- Đưa người dùng tới đúng data center hoặc region.
- Phân phối lưu lượng qua nhiều máy chủ.
- Thay thế máy lỗi mà không làm gián đoạn dịch vụ.

**Bảo mật và cô lập**

- Xác định thành phần nào được tiếp cận từ Internet.
- Tách frontend, backend, database và hệ thống quản trị thành các network segment.
- Kiểm soát đường giao tiếp bằng firewall, VPN và policy.
- Hỗ trợ kiến trúc zero trust, trong đó vị trí mạng không tự động tạo ra sự tin cậy.

**Hạ tầng động trên cloud**

- Server, container và service liên tục được tạo, mở rộng, thay thế hoặc xóa.
- Địa chỉ cụ thể của một instance có thể thay đổi theo thời gian.
- Lớp discovery, DNS và load balancing cần che giấu sự thay đổi này khỏi client.

**Microservices**

- Một request của người dùng có thể đi qua hàng chục dịch vụ.
- Phần lớn giao tiếp diễn ra hoàn toàn trên mạng private.
- Người dùng không thấy IP nội bộ nhưng ứng dụng vẫn phụ thuộc vào việc định tuyến nội bộ hoạt động chính xác.

**Disaster recovery và multi-region**

- Lưu lượng cần được chuyển tới khu vực còn hoạt động khi một region gặp sự cố.
- IP addressing, network boundary và routing policy ảnh hưởng trực tiếp đến kế hoạch chuyển vùng.

#### Mô hình phụ thuộc cần ghi nhớ

Các lớp trừu tượng của hệ thống được xây dựng chồng lên nhau:

```text
Application
    ↓ phụ thuộc vào
Service
    ↓ phụ thuộc vào
Network
    ↓ phụ thuộc vào
Addressing
```

Nếu lớp định địa chỉ hoặc mạng hoạt động sai, những lớp phía trên cũng không thể giao tiếp ổn định. Hiểu nền tảng IP sẽ giúp việc học DNS, load balancing, cloud networking, microservices và distributed systems trực quan hơn.

#### Nội dung phụ — Bộ câu hỏi phỏng vấn về IP Address

Khi trả lời câu hỏi kỹ thuật, có thể dùng cấu trúc ba bước:

```text
Định nghĩa khái niệm
        ↓
Giải thích vì sao nó quan trọng
        ↓
Đưa ra ví dụ hoặc trade-off thực tế
```

Không nên chỉ đọc lại định nghĩa. Một câu trả lời tốt cần liên hệ khái niệm với scalability, reliability, security hoặc chi phí vận hành của hệ thống.

##### Câu 1. IPv4 và IPv6 khác nhau như thế nào?

**Những điểm nên đề cập:**

- IPv4 dùng địa chỉ 32 bit; IPv6 dùng địa chỉ 128 bit.
- IPv4 được viết theo dạng bốn số thập phân phân tách bằng dấu chấm; IPv6 dùng các nhóm số hệ thập lục phân phân tách bằng dấu hai chấm.
- IPv6 có không gian địa chỉ lớn hơn rất nhiều và hỗ trợ khả năng tự cấu hình tốt hơn.
- IPv6 giảm nhu cầu sử dụng NAT chỉ với mục đích tiết kiệm địa chỉ.
- Việc chuyển đổi chậm do hạ tầng hiện có, yêu cầu tương thích và rủi ro vận hành.

**Câu trả lời mẫu:**

> IPv4 sử dụng địa chỉ 32 bit nên chỉ cung cấp khoảng 4,3 tỷ địa chỉ, trong khi IPv6 dùng 128 bit và gần như loại bỏ vấn đề khan hiếm địa chỉ. Không gian lớn hơn giúp IPv6 phù hợp với cloud, mobile và IoT, đồng thời giảm nhu cầu chia sẻ địa chỉ qua NAT. Tuy nhiên, IPv4 vẫn phổ biến vì chi phí migration và yêu cầu tương thích với hạ tầng cũ.

**Lưu ý về IPsec:** IPv6 được thiết kế với sự hỗ trợ chuẩn hóa cho IPsec, nhưng điều đó không có nghĩa mọi lưu lượng IPv6 mặc định đều được mã hóa. IPv4 cũng có thể sử dụng IPsec. Vì vậy, không nên trả lời rằng “IPv6 luôn an toàn hơn vì có mã hóa tích hợp” nếu không giải thích phần cấu hình và chính sách bảo mật.

##### Câu 2. Vì sao cần private IP trong System Design?

**Những điểm nên đề cập:**

- Cho phép tái sử dụng cùng dải địa chỉ trong các mạng nội bộ độc lập.
- Giảm nhu cầu sử dụng public IPv4 khan hiếm và thường có chi phí.
- Giữ database, cache và backend service khỏi việc được định tuyến trực tiếp từ Internet.
- Giúp chia hệ thống thành các vùng mạng có đường giao tiếp được kiểm soát.
- Thường kết hợp NAT hoặc proxy để tài nguyên private giao tiếp với bên ngoài.

**Câu trả lời mẫu:**

> Private IP cho phép tổ chức xây dựng mạng nội bộ quy mô lớn mà không cần cấp public IP cho mọi máy. Các dải địa chỉ có thể được tái sử dụng trong những mạng tách biệt, nhờ đó tiết kiệm không gian IPv4 và chi phí. Về kiến trúc, private networking cũng giúp database, cache và backend không bị công khai trực tiếp, qua đó giảm attack surface. Tuy nhiên, mức độ bảo vệ vẫn phụ thuộc vào firewall, access control và network policy.

##### Câu 3. NAT giúp giải quyết tình trạng thiếu IPv4 như thế nào?

**Những điểm nên đề cập:**

- Nhiều thiết bị có private IP có thể chia sẻ một public IP.
- NAT hoặc PAT phân biệt các kết nối thông qua bảng ánh xạ địa chỉ và port.
- ISP và doanh nghiệp có thể vận hành mạng lớn với ít public IPv4 hơn.
- NAT kéo dài tuổi thọ của IPv4 nhưng làm phức tạp kết nối end-to-end và troubleshooting.

**Câu trả lời mẫu:**

> NAT chuyển đổi địa chỉ private của nhiều thiết bị thành một hoặc một số public IP khi lưu lượng đi ra Internet. Với PAT, các kết nối còn được phân biệt bằng port, nên rất nhiều client có thể cùng chia sẻ một địa chỉ công cộng. Cơ chế này làm giảm nhu cầu public IPv4, nhưng tạo thêm trạng thái ánh xạ, tăng độ phức tạp vận hành và khiến kết nối end-to-end khó hơn.

**Lưu ý bảo mật:** NAT che giấu cấu trúc địa chỉ nội bộ và thường không cho phép kết nối từ ngoài vào nếu chưa có ánh xạ phù hợp. Dù vậy, NAT không thay thế firewall, authentication hay chính sách truy cập.

##### Câu 4. Load balancer phân phối lưu lượng dựa trên IP như thế nào?

Có thể giải thích ở ba cấp độ:

| Cấp độ | Cơ chế định tuyến |
|---|---|
| **DNS load balancing** | Domain trả về một hoặc nhiều IP; DNS có thể lựa chọn kết quả theo vị trí, health hoặc policy. |
| **Layer 4 load balancing** | Phân phối kết nối dựa trên thông tin tầng vận chuyển như địa chỉ IP và port của TCP/UDP. |
| **Layer 7 load balancing** | Hiểu giao thức ứng dụng và định tuyến theo hostname, URL path, HTTP header, cookie hoặc dữ liệu request. |

Luồng tổng quát:

```text
Client
  ↓ phân giải domain
DNS trả về IP của điểm vào
  ↓
Load Balancer
  ├──→ Server A
  ├──→ Server B
  └──→ Server C
```

**Câu trả lời mẫu:**

> Load balancer cung cấp một điểm vào ổn định rồi phân phối lưu lượng đến nhiều server khỏe mạnh, nhờ đó tăng khả năng mở rộng và độ sẵn sàng. Ở Layer 4, nó định tuyến chủ yếu dựa trên IP, port và giao thức vận chuyển. Ở Layer 7, nó có thể dùng thông tin HTTP như hostname, URL hoặc header để chọn backend. Ở phạm vi rộng hơn, DNS cũng có thể trả về các IP khác nhau theo khu vực hoặc tình trạng endpoint.

##### Câu 5. DNS phân giải domain thành IP trong hệ thống quy mô lớn như thế nào?

Quy trình cơ bản:

```text
Client hỏi DNS Resolver
          ↓
Resolver kiểm tra cache
          ↓ cache miss
Root DNS Server
          ↓
TLD DNS Server (.com, .org, ...)
          ↓
Authoritative DNS Server
          ↓
Trả bản ghi IP cho Resolver và Client
          ↓
Client kết nối tới IP và kết quả được cache theo TTL
```

**Các bước cần nhớ:**

1. Client yêu cầu resolver tìm địa chỉ của domain.
2. Resolver trả ngay nếu đã có kết quả hợp lệ trong cache.
3. Nếu cache miss, resolver lần lượt tìm thông tin từ root, TLD và authoritative DNS server.
4. Authoritative server trả bản ghi phù hợp, chẳng hạn địa chỉ IPv4 hoặc IPv6.
5. Resolver trả kết quả cho client và cache theo TTL để giảm số lần truy vấn sau.

**Câu trả lời mẫu:**

> Client thường gửi truy vấn tới recursive DNS resolver. Nếu resolver chưa có cache, nó tìm authoritative server thông qua hệ thống phân cấp root và TLD, nhận bản ghi IP rồi trả cho client. Các lớp cache giúp giảm latency và tải truy vấn. Trong hệ thống toàn cầu, DNS còn có thể trả kết quả khác nhau theo vị trí, health hoặc chính sách định tuyến để đưa người dùng tới endpoint phù hợp.

CDN thường kết hợp DNS để điều hướng người dùng tới edge location gần hoặc phù hợp, sau đó phục vụ nội dung đã cache tại edge. CDN không thay thế toàn bộ quy trình phân giải DNS.

#### Câu hỏi tư duy mở rộng

Sau bộ câu hỏi trên, hãy tiếp tục lập luận với các tình huống sau:

1. Thành phần nào của hệ thống cần public IP? Thành phần nào phải ở private network?
2. Người dùng truy cập backend private thông qua những lớp nào?
3. Nếu địa chỉ của container thay đổi liên tục, các dịch vụ tìm thấy nhau bằng cách nào?
4. Làm thế nào để định tuyến người dùng tới region phù hợp?
5. Network segmentation giúp hạn chế phạm vi sự cố hoặc tấn công ra sao?
6. Khi nào cần hỗ trợ dual stack IPv4/IPv6 trong giai đoạn chuyển đổi?
7. Điều gì xảy ra nếu DNS, NAT gateway hoặc load balancer trở thành single point of failure?

#### Ý chính cần nhớ

- IP address là nền tảng định danh và định vị cho giao tiếp mạng.
- IPv4 có không gian 32 bit, tương đương khoảng 4,3 tỷ địa chỉ.
- Sự khan hiếm IPv4 dẫn tới việc sử dụng rộng rãi private IP và NAT.
- IPv6 sử dụng 128 bit và được thiết kế cho khả năng mở rộng dài hạn của Internet.
- IPv6 không thay thế IPv4 ngay lập tức vì còn chi phí migration, tương thích và rủi ro vận hành.
- Public IP cung cấp khả năng tiếp cận; private IP hỗ trợ giao tiếp nội bộ và cô lập.
- Phần lớn database, cache và backend service không nên được công khai trực tiếp.
- Private IP giúp giảm attack surface nhưng không thay thế firewall, authentication và các kiểm soát bảo mật khác.
- Trong hạ tầng động, DNS, service discovery và load balancer giúp client không phụ thuộc vào IP của từng instance.
- IP addressing ảnh hưởng trực tiếp đến scalability, availability, security, disaster recovery và giao tiếp service-to-service.

#### Công thức ghi nhớ

> **Public IP để được tiếp cận, private IP để giao tiếp có kiểm soát và cô lập; IPv6 mở rộng mô hình địa chỉ cho quy mô dài hạn.**

---

### Bài 9. DNS hoạt động như thế nào?

#### DNS là gì?

**DNS — Domain Name System** là hệ thống thư mục phân tán của Internet. Nó chuyển tên miền dễ nhớ đối với con người, chẳng hạn `example.com`, thành thông tin mà máy tính sử dụng để giao tiếp, thường là địa chỉ IP.

```text
Tên miền dễ nhớ
example.com
      ↓ DNS resolution
Địa chỉ mạng mà máy có thể kết nối
203.0.113.10 hoặc 2001:db8::10
```

Nếu không có DNS, người dùng sẽ phải nhớ địa chỉ IP của từng website hoặc dịch vụ. Nhưng vai trò của DNS không chỉ nằm ở tính tiện dụng.

Trong hệ thống hiện đại:

- Một ứng dụng có thể chạy trên nhiều server, data center và cloud region.
- IP của hạ tầng phía sau có thể thay đổi theo thời gian.
- Endpoint phù hợp có thể khác nhau tùy vị trí hoặc tình trạng hệ thống.

DNS tạo ra một lớp trừu tượng ổn định: người dùng tiếp tục dùng cùng một domain trong khi hạ tầng bên dưới được thay đổi, mở rộng hoặc chuyển vùng.

> **Domain là giao diện ổn định; IP và hạ tầng phía sau có thể tiến hóa.**

#### DNS thường là bước đầu tiên của request

Trước khi trình duyệt kết nối tới server, nó phải tìm ra server đó ở đâu. Vì vậy, với phần lớn ứng dụng Internet, DNS là một trong những hệ thống phân tán đầu tiên tham gia vào request.

```text
Người dùng nhập domain
        ↓
DNS tìm endpoint
        ↓
Client mở kết nối tới endpoint
        ↓
Gửi HTTP request
        ↓
Ứng dụng xử lý và trả response
```

Nếu DNS chậm hoặc không hoạt động, người dùng có thể không truy cập được ứng dụng dù toàn bộ server ứng dụng vẫn khỏe mạnh.

#### DNS không phải một máy chủ duy nhất

DNS là một hệ thống phân cấp và phân tán. Mỗi loại server đảm nhận một trách nhiệm riêng:

| Thành phần | Trách nhiệm |
|---|---|
| **Recursive resolver** | Nhận yêu cầu từ client, kiểm tra cache và thay mặt client tìm câu trả lời. |
| **Root name server** | Chỉ resolver tới hệ thống máy chủ của top-level domain phù hợp. |
| **TLD name server** | Chỉ tới authoritative name server của domain cần tìm. |
| **Authoritative name server** | Nguồn có thẩm quyền lưu và trả DNS record của domain. |

Ví dụ với `shop.example.com`:

```text
Recursive Resolver
       ↓ hỏi root
Root Name Server
       ↓ “hãy hỏi hệ thống quản lý .com”
.com TLD Name Server
       ↓ “hãy hỏi authoritative server của example.com”
Authoritative Name Server
       ↓ trả record của shop.example.com
Recursive Resolver
       ↓ trả kết quả
Client
```

Root và TLD server thường không giữ địa chỉ cuối cùng của mọi website. Chúng chỉ biết đủ để hướng resolver tới lớp tiếp theo. Cơ chế **phân quyền và ủy quyền — delegation** này giúp DNS mở rộng trên quy mô toàn Internet mà không cần một cơ sở dữ liệu trung tâm chứa và xử lý mọi thứ.

#### Quy trình phân giải tên miền

Khi người dùng nhập một domain vào trình duyệt, quá trình thường diễn ra như sau:

1. **Trình duyệt kiểm tra cache:** nếu đã có kết quả còn hiệu lực, nó dùng ngay địa chỉ đó.
2. **Hệ điều hành kiểm tra cache:** nếu browser không có, lớp phân giải của hệ điều hành có thể đã lưu kết quả.
3. **Client hỏi recursive resolver:** resolver thường do ISP, tổ chức hoặc nhà cung cấp DNS vận hành.
4. **Resolver kiểm tra cache:** nếu có kết quả hợp lệ, nó trả lời mà không cần truy vấn toàn bộ hệ thống phân cấp.
5. **Resolver hỏi root server:** root chỉ tới TLD server phù hợp.
6. **Resolver hỏi TLD server:** TLD chỉ tới authoritative server của domain.
7. **Resolver hỏi authoritative server:** authoritative server trả DNS record được yêu cầu.
8. **Resolver cache kết quả:** bản ghi được giữ trong thời gian cho phép bởi TTL.
9. **Resolver trả kết quả cho client:** client cũng có thể cache kết quả.
10. **Client kết nối tới endpoint:** từ đây quá trình giao tiếp ứng dụng mới bắt đầu.

Luồng rút gọn:

```text
Browser Cache
      ↓ miss
OS Cache
      ↓ miss
Recursive Resolver Cache
      ↓ miss
Root → TLD → Authoritative DNS
      ↓
DNS record
      ↓
Cache kết quả → Trả client → Kết nối endpoint
```

Nhờ cache, phần lớn lookup không phải thực hiện toàn bộ chuỗi root → TLD → authoritative. Toàn bộ quá trình thường diễn ra rất nhanh dù có thể liên quan đến nhiều hệ thống phân tán.

#### Vì sao DNS có thể mở rộng toàn cầu?

DNS kết hợp ba nguyên lý quan trọng:

**1. Hierarchy — Phân cấp**

Không có một server phải quản lý toàn bộ namespace. Trách nhiệm được phân chia theo root, TLD, domain và subdomain.

**2. Delegation — Ủy quyền**

Mỗi lớp chỉ giữ thông tin cần thiết để chỉ tới lớp có thẩm quyền tiếp theo. Chủ sở hữu domain có thể quản lý bản ghi của mình mà không cần cập nhật một cơ sở dữ liệu toàn cầu duy nhất.

**3. Caching — Lưu kết quả tạm thời**

Kết quả được cache ở browser, hệ điều hành và resolver. Điều này giảm latency, giảm tải cho upstream DNS server và ngăn phần lớn truy vấn phải đi hết hệ thống phân cấp.

```text
Hierarchy + Delegation + Caching
                ↓
Scalability + Performance + Resilience
```

#### DNS caching

Mỗi DNS lookup đều là một hoặc nhiều network call, do đó tạo thêm độ trễ. Caching giúp trả lời ngay các truy vấn lặp lại.

Các lớp cache thường gặp:

```text
Browser cache
      ↓
Operating system cache
      ↓
Local / recursive resolver cache
      ↓
Upstream DNS hierarchy
```

Lợi ích của cache:

- Giảm thời gian phân giải domain.
- Giảm số network call.
- Giảm lưu lượng tới DNS infrastructure toàn cầu.
- Giảm tải cho authoritative server.
- Cho phép một số truy vấn vẫn được trả lời mà không phải liên hệ mọi lớp upstream.

#### TTL và trade-off giữa freshness với performance

DNS record không được cache vĩnh viễn. **TTL — Time to Live** quy định thời gian một kết quả có thể được giữ trong cache trước khi cần kiểm tra lại.

| Lựa chọn | Lợi ích | Trade-off |
|---|---|---|
| **TTL dài** | Nhiều cache hit hơn, lookup nhanh hơn, giảm tải và chi phí DNS | Thay đổi record, migration hoặc failover mất nhiều thời gian hơn để được nhìn thấy rộng rãi |
| **TTL ngắn** | Có thể thay đổi endpoint và routing nhanh hơn | Tăng số truy vấn, latency, tải hạ tầng DNS và phụ thuộc vào availability của DNS |

TTL vì vậy là một quyết định vận hành và kiến trúc, không chỉ là một trường cấu hình.

Ví dụ khi migration:

```text
Trước migration: giảm TTL sớm
        ↓
Chờ cache cũ hết hiệu lực
        ↓
Đổi DNS record sang hạ tầng mới
        ↓
Theo dõi lỗi và lưu lượng
        ↓
Ổn định xong: tăng TTL trở lại
```

TTL thấp không bảo đảm mọi client cập nhật tức thì; một số resolver hoặc lớp trung gian có thể có hành vi cache khác kỳ vọng. Vì vậy, migration an toàn vẫn cần giai đoạn chồng lấp, giám sát và kế hoạch quay lui.

#### DNS trong hệ thống quy mô lớn

Ở quy mô Internet, DNS không chỉ tìm IP mà còn trở thành một công cụ kiến trúc.

##### 1. Global traffic routing

DNS có thể trả về endpoint khác nhau tùy theo:

- Vị trí địa lý hoặc độ gần mạng của người dùng.
- Trạng thái health của endpoint hoặc region.
- Năng lực hiện có.
- Trọng số và chính sách phân phối lưu lượng.
- Kế hoạch canary, migration hoặc disaster recovery.

```text
User ở châu Á ──→ DNS ──→ Asia endpoint
User ở châu Âu ─→ DNS ──→ Europe endpoint
```

DNS-based routing có độ phân giải không hoàn toàn chính xác theo từng người dùng, vì authoritative DNS thường nhìn thấy resolver thay vì địa chỉ client trực tiếp. Ngoài ra, kết quả đã cache sẽ tiếp tục được dùng đến khi hết hiệu lực.

##### 2. Load distribution

Một domain có thể liên kết với nhiều endpoint. DNS có thể hỗ trợ phân phối lưu lượng ở lớp đầu tiên trước khi request tới load balancer hoặc ứng dụng.

DNS load distribution thường có độ chi tiết thấp hơn application load balancer vì:

- Quyết định bị cache theo TTL.
- DNS không theo dõi từng request ứng dụng.
- Client có thể không sử dụng các IP được trả về theo cách đồng đều.

Vì vậy, hệ thống thường kết hợp DNS routing ở phạm vi global với load balancer ở region hoặc data center.

```text
Global DNS Routing
        ↓
Chọn region
        ↓
Regional Load Balancer
        ↓
Chọn server / service instance
```

##### 3. Disaster recovery và failover

Nếu một data center hoặc region gặp sự cố, DNS có thể chuyển kết quả sang endpoint dự phòng còn khỏe mạnh.

Hiệu quả failover phụ thuộc vào:

- Tốc độ và độ chính xác của health check.
- TTL hiện tại và cache còn tồn tại.
- Khả năng chịu tải của region dự phòng.
- DNS provider có còn hoạt động không.
- Dữ liệu và các dependency đã sẵn sàng tại nơi dự phòng chưa.

DNS có thể chuyển hướng người dùng, nhưng không tự giải quyết việc đồng bộ dữ liệu hoặc khôi phục application state.

##### 4. Tích hợp CDN

DNS giúp CDN xác định edge location phù hợp để phục vụ người dùng:

```text
User hỏi DNS cho static.example.com
               ↓
DNS/CDN chọn edge phù hợp
               ↓
User kết nối tới CDN Edge gần hơn
               ↓ cache miss nếu có
CDN Edge lấy nội dung từ Origin
```

Đưa nội dung đến gần người dùng giúp giảm latency và giảm tải cho origin server.

##### 5. Anycast

Với **anycast**, nhiều máy hoặc địa điểm có thể quảng bá cùng một địa chỉ IP. Hệ thống định tuyến mạng đưa request tới một địa điểm phù hợp, thường là nơi “gần” theo topology mạng.

DNS provider sử dụng anycast để:

- Giảm lookup latency.
- Phân tán lưu lượng toàn cầu.
- Tăng khả năng chống chịu khi một địa điểm gặp sự cố.
- Hấp thụ hoặc phân tán một phần lưu lượng tấn công.

Cần phân biệt:

- **DNS routing:** DNS trả về endpoint nào cho ứng dụng.
- **Anycast DNS:** request truy vấn DNS được đưa tới DNS node nào.

#### DNS và bảo mật

DNS nằm ở “cửa trước” của phần lớn ứng dụng Internet, nên là mục tiêu có giá trị cao.

**Cache poisoning**

Kẻ tấn công cố đưa bản ghi sai vào cache của resolver, khiến người dùng bị chuyển tới endpoint không mong muốn.

**DDoS**

Một lượng truy vấn cực lớn có thể làm quá tải DNS infrastructure. Nếu DNS không phản hồi, ứng dụng có thể trở nên không thể truy cập dù backend vẫn hoạt động.

Các biện pháp kiến trúc thường dùng:

- **DNSSEC:** ký dữ liệu DNS để bên nhận có thể kiểm tra tính xác thực và toàn vẹn của câu trả lời.
- **Redundant DNS providers:** tránh phụ thuộc hoàn toàn vào một nhà cung cấp hoặc một hệ thống quản trị.
- **Anycast network:** phân tán truy vấn tới nhiều điểm hiện diện.
- **Traffic filtering và rate limiting:** phát hiện và hạn chế lưu lượng độc hại.
- **Monitoring:** theo dõi latency, error rate, record correctness và thay đổi cấu hình.
- **Access control:** giới hạn người và hệ thống có quyền sửa DNS record.

DNSSEC giúp xác thực dữ liệu DNS nhưng không mã hóa nội dung truy vấn và cũng không tự ngăn mọi loại DDoS.

#### Reliability của DNS

Vì DNS là dependency nằm trước ứng dụng, thiết kế cần tránh biến nó thành single point of failure.

Checklist cơ bản:

- Có nhiều authoritative name server độc lập.
- Phân tán server qua nhiều failure domain hoặc region.
- Sử dụng DNS provider có anycast và khả năng chống DDoS phù hợp.
- Giám sát cả quá trình phân giải từ bên ngoài hệ thống.
- Bảo vệ tài khoản và quy trình thay đổi DNS.
- Kiểm thử failover thay vì chỉ giả định nó hoạt động.
- Chọn TTL dựa trên mục tiêu recovery và tải DNS.
- Nếu dùng nhiều provider, bảo đảm cấu hình record được đồng bộ chính xác.

#### Nội dung phụ — Bộ câu hỏi và trả lời phỏng vấn về DNS

##### Câu 1. Hãy giải thích quá trình DNS resolution theo từng bước

**Các bước cần trình bày:**

1. Người dùng nhập domain vào trình duyệt.
2. Trình duyệt kiểm tra DNS cache cục bộ.
3. Hệ điều hành kiểm tra cache và cấu hình phân giải tên.
4. Nếu chưa có kết quả, truy vấn được gửi tới recursive resolver đã cấu hình.
5. Resolver kiểm tra cache của mình.
6. Nếu cache miss, resolver lần lượt hỏi root, TLD và authoritative name server.
7. Authoritative server trả record được yêu cầu, chẳng hạn `A` hoặc `AAAA`.
8. Resolver cache câu trả lời theo TTL rồi trả kết quả cho client.
9. Client sử dụng địa chỉ nhận được để bắt đầu kết nối tới dịch vụ.

**Câu trả lời mẫu:**

> Khi người dùng nhập một domain, browser và hệ điều hành kiểm tra cache trước. Nếu chưa có, client hỏi recursive resolver. Khi resolver cũng cache miss, nó lần theo DNS hierarchy: root chỉ tới TLD, TLD chỉ tới authoritative name server, rồi authoritative server trả record của domain. Resolver lưu kết quả theo TTL, trả lại cho client và client mới bắt đầu kết nối tới endpoint.

**Điểm cộng khi phỏng vấn:**

- Root server trả referral chứ thường không trả IP cuối cùng của website.
- Hệ thống root có **13 danh tính root server logic**, nhưng mỗi danh tính được triển khai thành nhiều instance vật lý trên toàn cầu, phần lớn nhờ anycast. Vì vậy, không nên hiểu là toàn Internet chỉ dựa vào đúng 13 máy vật lý.
- TLD referral thường cung cấp `NS` record và có thể kèm **glue record** cần thiết để tìm authoritative server.

##### Câu 2. Recursive DNS server và authoritative DNS server khác nhau thế nào?

| Tiêu chí | Recursive Resolver | Authoritative Name Server |
|---|---|---|
| Làm việc cho ai? | Thay mặt client đi tìm câu trả lời | Là nguồn có thẩm quyền cho một DNS zone |
| Nhiệm vụ chính | Kiểm tra cache, truy vấn các lớp DNS khác và trả kết quả cho client | Lưu và phục vụ các record như A, AAAA, CNAME, MX, NS |
| Nguồn dữ liệu | Cache hoặc câu trả lời từ hệ thống DNS phía trên | Zone data do chủ domain hoặc DNS provider quản lý |
| Tính chất câu trả lời | Có thể là dữ liệu được cache | Câu trả lời có thẩm quyền cho zone mà nó quản lý |
| Đơn vị thường vận hành | ISP, doanh nghiệp hoặc public resolver provider | Chủ domain, hosting provider hoặc authoritative DNS provider |

**Câu trả lời mẫu:**

> Recursive resolver làm việc thay cho client: nó tìm dữ liệu qua DNS hierarchy và cache kết quả. Authoritative name server là nguồn chính thức giữ record của một zone và trả câu trả lời có thẩm quyền. Nói ngắn gọn, resolver đi lấy dữ liệu; authoritative server sở hữu và công bố dữ liệu DNS của domain.

##### Câu 3. DNS caching cải thiện hiệu năng ra sao và xuất hiện ở đâu?

DNS caching giúp:

- Giảm latency vì không cần lặp lại toàn bộ lookup.
- Giảm lưu lượng tới root, TLD và authoritative server.
- Giảm tải và chi phí cho DNS infrastructure.
- Cải thiện trải nghiệm người dùng nhờ phân giải gần client hơn.
- Tăng khả năng mở rộng vì một câu trả lời có thể phục vụ nhiều truy vấn.

Các vị trí cache phổ biến:

```text
Browser
   ↓
Operating System / Local Stub Resolver
   ↓
Recursive Resolver
   ↓
DNS hierarchy nếu vẫn cache miss
```

**Câu trả lời mẫu:**

> DNS caching lưu lại câu trả lời đã phân giải để các truy vấn tiếp theo không phải đi lại toàn bộ DNS hierarchy. Cache có thể nằm ở browser, hệ điều hành và recursive resolver. Điều này giảm latency và tải cho upstream DNS server, nhưng khiến thay đổi record không được nhìn thấy ngay cho đến khi cache hết hiệu lực.

##### Câu 4. TTL trong DNS là gì và vì sao quan trọng?

TTL quy định thời gian một DNS record có thể được cache. Nó kiểm soát trade-off giữa hiệu năng và tốc độ cập nhật:

| TTL | Hệ quả |
|---|---|
| Ngắn, ví dụ 60 giây | Thay đổi và failover có thể được nhìn thấy sớm hơn, nhưng query volume và phụ thuộc vào DNS tăng |
| Dài, ví dụ 24 giờ | Cache hiệu quả, ít truy vấn hơn, nhưng migration và failover bị chậm bởi record cũ |

**Câu trả lời mẫu:**

> TTL là thời gian resolver được phép dùng một DNS record đã cache trước khi phải truy vấn lại. TTL dài tăng cache hit và giảm tải, nhưng làm thay đổi hạ tầng lan truyền chậm hơn. TTL ngắn linh hoạt hơn cho migration hoặc failover, đổi lại là nhiều truy vấn và tải DNS hơn. Vì vậy TTL phải được chọn theo mục tiêu vận hành, không có một giá trị tốt nhất cho mọi hệ thống.

**Điểm cần tránh:** “Propagation” không phải một thao tác DNS chủ động đẩy record mới đến mọi nơi. Phần lớn sự chậm trễ đến từ các cache đang giữ record cũ cho đến khi TTL hết hạn.

##### Câu 5. DNS-based load balancing hoạt động như thế nào ở quy mô lớn?

Authoritative DNS có thể trả các endpoint khác nhau cho cùng một domain dựa trên policy:

- **Round-robin:** luân phiên thứ tự hoặc tập IP được trả về.
- **Weighted routing:** chia tỷ lệ lưu lượng theo trọng số.
- **Geolocation hoặc latency-based routing:** hướng người dùng tới region phù hợp.
- **Failover routing:** chỉ công bố hoặc ưu tiên endpoint còn khỏe mạnh.

```text
Client → Resolver → Authoritative DNS Policy
                          ├──→ Region A IP
                          ├──→ Region B IP
                          └──→ Backup IP
```

**Câu trả lời mẫu:**

> DNS-based load balancing phân phối người dùng bằng cách trả các IP khác nhau cho cùng một domain, dựa trên round-robin, trọng số, vị trí, latency hoặc health policy. Nó phù hợp để chọn region hoặc điểm vào ở phạm vi global. Tuy nhiên, kết quả bị cache theo TTL và DNS không quan sát từng HTTP request, nên thường được kết hợp với load balancer trong từng region.

**Hiệu chỉnh quan trọng:**

- Resolver thông thường không tự biết một application server đã lỗi để “xóa nó khỏi danh sách”. Health checker và control plane của authoritative DNS hoặc traffic manager mới là lớp cập nhật record hay policy; resolver chỉ nhận và cache câu trả lời.
- **Anycast DNS** thường đưa chính truy vấn DNS tới DNS node phù hợp. Nó khác với việc authoritative DNS trả một application endpoint dựa trên policy, dù anycast cũng có thể được dùng ở các lớp hạ tầng khác.
- DNS round-robin không bảo đảm mỗi server nhận đúng số request bằng nhau vì cache, hành vi client và thời lượng kết nối có thể khác nhau.

##### Câu 6. Các mối đe dọa DNS phổ biến và cách giảm thiểu

| Mối đe dọa | Mô tả | Cách giảm thiểu |
|---|---|---|
| **DNS spoofing / cache poisoning** | Đưa câu trả lời giả vào quá trình phân giải hoặc cache để chuyển hướng người dùng | DNSSEC validation, source-port và transaction-ID randomization, resolver được vá và cấu hình an toàn |
| **DDoS vào DNS** | Làm quá tải resolver hoặc authoritative infrastructure khiến domain không thể phân giải | Anycast, nhiều instance/provider, capacity planning, traffic filtering, rate limiting và DDoS protection |
| **Man-in-the-middle trên đường truy vấn** | Nghe lén hoặc sửa truy vấn và phản hồi giữa client với resolver | DoH hoặc DoT cho chặng client–resolver; DNSSEC để xác thực dữ liệu DNS khi được triển khai đúng |
| **NXDOMAIN flood / random-subdomain attack** | Tạo lượng lớn truy vấn tên không tồn tại để buộc resolver và authoritative server xử lý | Negative caching, rate limiting, DNS firewall, anomaly detection và đủ năng lực xử lý |
| **Chiếm quyền thay đổi DNS** | Kẻ tấn công có quyền sửa record hoặc nameserver của domain | MFA, least privilege, registry lock, audit log và quy trình phê duyệt thay đổi |

**Câu trả lời mẫu:**

> Các rủi ro DNS chính gồm cache poisoning, DDoS, can thiệp trên đường truyền và flood truy vấn không tồn tại. DNSSEC giúp xác thực nguồn gốc và tính toàn vẹn của record; DoH hoặc DoT mã hóa kết nối giữa client và recursive resolver; anycast, redundancy, filtering và rate limiting giúp chống quá tải. Ngoài ra cần bảo vệ control plane bằng MFA, least privilege và giám sát thay đổi DNS.

**Phân biệt các cơ chế bảo vệ:**

| Cơ chế | Bảo vệ chính | Không tự giải quyết |
|---|---|---|
| **DNSSEC** | Tính xác thực và toàn vẹn của dữ liệu DNS | Không mã hóa truy vấn; không ngăn DDoS |
| **DoH / DoT** | Mã hóa chặng giao tiếp giữa client và recursive resolver | Không bảo đảm authoritative data đúng nếu không có validation phù hợp |
| **Anycast** | Phân tán lưu lượng và tăng resilience của hạ tầng | Không xác thực record và không loại bỏ mọi cuộc tấn công |
| **Rate limiting / RRL** | Hạn chế một số dạng lạm dụng và khuếch đại phản hồi | Không thay thế DNSSEC hoặc kiểm soát quyền thay đổi |

#### Câu hỏi tư duy và phỏng vấn

1. Hãy mô tả đầy đủ quá trình phân giải `www.example.com` khi không có cache.
2. Recursive resolver, root, TLD và authoritative server khác nhau thế nào?
3. Vì sao DNS dùng hierarchy và delegation thay vì một cơ sở dữ liệu tập trung?
4. TTL dài và TTL ngắn ảnh hưởng đến performance và failover ra sao?
5. Nếu đổi IP của service, làm thế nào giảm nguy cơ client tiếp tục dùng địa chỉ cũ?
6. DNS-based load balancing khác application load balancing ở điểm nào?
7. DNS hỗ trợ multi-region và disaster recovery như thế nào?
8. Điều gì xảy ra nếu authoritative DNS provider gặp sự cố?
9. DNSSEC bảo vệ điều gì và không bảo vệ điều gì?
10. Anycast hỗ trợ hạ tầng DNS toàn cầu như thế nào?

#### Ý chính cần nhớ

- DNS ánh xạ tên ổn định, dễ nhớ tới endpoint mạng có thể thay đổi.
- DNS thường là một trong những hệ thống phân tán đầu tiên tham gia vào request.
- DNS là hệ thống phân cấp gồm resolver, root, TLD và authoritative name server.
- Delegation giúp mỗi lớp chỉ cần biết đủ để chỉ tới lớp tiếp theo.
- Caching tại browser, OS và resolver là yếu tố thiết yếu cho performance và scalability.
- TTL tạo trade-off giữa dữ liệu mới và hiệu quả cache.
- DNS có thể hỗ trợ global routing, load distribution, failover và CDN.
- DNS routing thường được kết hợp với regional load balancer thay vì thay thế hoàn toàn nó.
- Anycast giúp đưa truy vấn DNS tới hạ tầng phù hợp và tăng resilience.
- DNS là mục tiêu của cache poisoning và DDoS nên cần DNSSEC, redundancy, monitoring và bảo vệ thay đổi cấu hình.
- DNS khỏe không đồng nghĩa ứng dụng khỏe; và ứng dụng khỏe cũng chưa đủ nếu DNS bị lỗi.

#### Công thức ghi nhớ

> **DNS dùng hierarchy để phân quyền, delegation để tìm đúng nguồn, caching để tăng tốc và TTL để kiểm soát trade-off giữa hiệu năng với độ mới của dữ liệu.**

---

### Bài 10. Mô hình Client–Server

#### Client–Server Model là gì?

**Client–server** là mô hình kiến trúc trong đó client yêu cầu dữ liệu hoặc dịch vụ, còn server tiếp nhận, xử lý và trả kết quả.

```text
Client ── request ──→ Server
Client ←─ response ── Server
```

Mô hình này xuất hiện trong hầu hết hệ thống hiện đại:

- Trình duyệt yêu cầu trang từ web server.
- Ứng dụng di động gọi backend API.
- Email client giao tiếp với mail server.
- Ứng dụng yêu cầu video từ streaming service.
- Game client gửi hành động tới game server.
- Application server truy vấn database server.
- Một microservice gọi API của microservice khác.

Điểm cốt lõi là **tách trách nhiệm**. Client tập trung vào việc tiếp nhận tương tác và trình bày kết quả; server tập trung vào xử lý tập trung, business logic, chính sách bảo mật và dữ liệu.

Sự tách biệt này cho phép thay đổi và mở rộng hai phía tương đối độc lập, chẳng hạn bổ sung server, đặt load balancer, thêm cache hoặc thay đổi backend mà không cần đưa toàn bộ dữ liệu và logic vào client.

#### Ba thành phần nền tảng

Mọi tương tác client–server phụ thuộc vào ba thành phần:

| Thành phần | Trách nhiệm chính | Ví dụ |
|---|---|---|
| **Client** | Thu thập input, khởi tạo request, xử lý và trình bày response | Browser, mobile app, desktop app, service gọi API |
| **Server** | Thực thi business logic, xác thực và phân quyền, xử lý dữ liệu, phối hợp dependency | Web server, API server, database server, game server |
| **Network** | Truyền request và response giữa hai phía | Internet, LAN, Wi-Fi, mạng private trong cloud |

Nhiều quyết định System Design thực chất là quyết định **công việc nên được thực hiện ở đâu** và **ba thành phần này giao tiếp như thế nào**.

##### Client

Client thường là điểm vào của người dùng hoặc hệ thống gọi dịch vụ. Nó có thể:

- Thu thập thao tác và dữ liệu đầu vào.
- Kiểm tra dữ liệu cơ bản để cải thiện trải nghiệm.
- Gửi request theo protocol và API contract.
- Hiển thị response hoặc trạng thái lỗi.
- Cache một số dữ liệu và tài nguyên cục bộ.

Không nên tin tưởng hoàn toàn dữ liệu hoặc quyết định bảo mật từ client, vì client thường nằm ngoài vùng kiểm soát của server và có thể bị sửa đổi.

##### Server

Server thường:

- Xác thực danh tính và kiểm tra quyền truy cập.
- Thực thi business rule.
- Đọc hoặc ghi dữ liệu.
- Gọi cache, database, queue và dịch vụ bên ngoài.
- Quản lý concurrency, resource limit và lỗi.
- Trả response theo contract đã thống nhất.

Khi hệ thống phát triển, server thường là trọng tâm của các bài toán scalability, availability, performance và reliability.

##### Network

Network không phải đường truyền hoàn hảo. Kiến trúc cần giả định:

- Có latency và jitter.
- Packet có thể mất, trễ hoặc đến không đúng thời điểm kỳ vọng.
- Kết nối có thể bị ngắt giữa chừng.
- Bandwidth có giới hạn.
- Hai phía có thể bất đồng về trạng thái sau timeout.
- Một request có thể được gửi lại và xử lý nhiều lần nếu thiết kế không cẩn thận.

Vì vậy, hệ thống cần timeout, retry có kiểm soát, idempotency, circuit breaker, giới hạn kích thước payload và quan sát được lỗi giao tiếp.

#### Một thành phần có thể vừa là client vừa là server

“Client” và “server” là vai trò trong một tương tác, không nhất thiết là loại máy cố định.

```text
Mobile App
   ↓ request
API Service        ← API Service là server đối với Mobile App
   ↓ query
Database           ← API Service lại là client đối với Database
```

Trong microservices, một service thường là server khi nhận request từ upstream và là client khi gọi downstream dependency.

#### Giao tiếp Client–Server

Mô hình khái niệm rất đơn giản:

1. Client yêu cầu một thao tác hoặc tài nguyên.
2. Request đi qua mạng và các lớp trung gian.
3. Server xác thực, xử lý và có thể gọi dependency.
4. Server tạo response.
5. Response quay về client.
6. Client diễn giải hoặc hiển thị kết quả.

Một cú nhấp của người dùng có thể tạo ra nhiều lời gọi:

```text
Client
  ↓
DNS → CDN / Proxy → Load Balancer → API Server
                                      ├──→ Cache
                                      ├──→ Service B
                                      └──→ Database
```

Giao tiếp không miễn phí. Mỗi request:

- Làm tăng latency.
- Tiêu thụ connection, CPU, memory và bandwidth.
- Tạo thêm điểm có thể timeout hoặc thất bại.
- Có thể khuếch đại tải qua nhiều downstream call.

Ở quy mô lớn, cần giảm round-trip không cần thiết, gom hoặc song song hóa lời gọi phù hợp, tối ưu payload và lựa chọn đúng kiểu giao tiếp.

#### HTTP request–response cycle

Khi người dùng mở `https://example.com`, luồng tổng quát có thể gồm:

```text
1. Browser phân tích URL
2. DNS phân giải domain thành endpoint
3. Thiết lập kết nối mạng và bảo mật cần thiết
4. Gửi HTTP request
5. Các lớp trung gian định tuyến request
6. Server xử lý business logic và dependency
7. Server trả HTTP response
8. Browser phân tích và render nội dung
9. Browser gửi thêm request cho CSS, JS, ảnh và API
```

Ví dụ request và response rút gọn:

```http
GET /products/42 HTTP/1.1
Host: example.com
Accept: application/json
```

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"id": 42, "name": "Example product"}
```

Response thường chứa:

- **Status code:** kết quả ở mức protocol, chẳng hạn thành công, lỗi client hoặc lỗi server.
- **Headers:** metadata về nội dung, cache, authentication và cách xử lý response.
- **Body:** dữ liệu thực tế nếu response cần nội dung.

Một trang web hiếm khi chỉ là một request. HTML ban đầu có thể làm browser yêu cầu thêm font, CSS, JavaScript, ảnh và API data. Tổng trải nghiệm phụ thuộc vào số request, thứ tự dependency, kích thước tài nguyên và khả năng tải song song.

#### Request–response và persistent connection

Hai kiểu tương tác phổ biến:

| Kiểu | Đặc điểm | Phù hợp với |
|---|---|---|
| **Request–response** | Client gửi yêu cầu và server trả một kết quả tương ứng | Web page, CRUD API, truy vấn dữ liệu, tác vụ ngắn |
| **Persistent bidirectional connection** | Kênh được giữ mở để hai phía có thể trao đổi nhiều message | Chat, collaborative editing, live dashboard, game thời gian thực |

**WebSocket** cung cấp kết nối lâu dài và giao tiếp hai chiều, cho phép server chủ động gửi update mà không cần client liên tục polling.

Trade-off của persistent connection:

- Server phải duy trì rất nhiều connection lâu dài.
- Cần heartbeat và phát hiện connection chết.
- Việc deploy, reconnect và failover phức tạp hơn.
- State kết nối có thể gắn với một server cụ thể.
- Load balancer và proxy phải hỗ trợ connection lifetime dài.

**Hiệu chỉnh quan trọng:** request–response không có nghĩa mỗi HTTP request luôn phải mở một TCP connection mới. HTTP hiện đại có thể tái sử dụng connection; HTTP/2 còn multiplex nhiều request trên một connection, và HTTP/3 sử dụng QUIC. Khác biệt cốt lõi với WebSocket nằm ở mô hình tương tác và khả năng trao đổi hai chiều liên tục, không chỉ ở việc “mở kết nối mới”.

#### Synchronous và Asynchronous Communication

Sự khác nhau nằm ở việc bên gọi có phải chờ công việc hoàn thành trước khi tiếp tục hay không.

| Tiêu chí | Synchronous | Asynchronous |
|---|---|---|
| Hành vi bên gọi | Chờ kết quả trước khi tiếp tục luồng phụ thuộc | Gửi công việc rồi tiếp tục; kết quả được xử lý sau |
| Ưu điểm | Đơn giản, dễ hiểu, kết quả ngay | Tách rời thời gian xử lý, phù hợp tác vụ dài hoặc tải biến động |
| Hạn chế | Latency và lỗi downstream tác động trực tiếp tới caller | Khó theo dõi trạng thái, lỗi, retry, ordering và duplicate |
| Ví dụ | API đọc thông tin cần hiển thị ngay | Queue xử lý email, event workflow, background job |

```text
Synchronous:
Client → Request → Server
Client ← chờ ← Response

Asynchronous:
Client → Submit work → Queue / Server
Client ← Acknowledgement
... xử lý sau ...
Result → Event / Callback / Polling / Push
```

Hệ thống thực tế thường kết hợp cả hai:

- Đồng bộ cho thao tác người dùng cần kết quả ngay.
- Bất đồng bộ cho notification, background processing và event-driven workflow.
- Trả acknowledgement nhanh rồi cho client polling trạng thái hoặc nhận callback.

**Lưu ý:** WebSocket mô tả một kênh giao tiếp hai chiều và lâu dài; nó không tự động biến mọi business operation thành asynchronous workflow. AJAX cũng có thể không chặn UI ở phía browser, nhưng lời gọi HTTP phía dưới vẫn theo request–response. Cần phân biệt **waiting model**, **connection lifetime** và **directionality**.

#### Stateless và Stateful Server

##### Stateless server

Server không phụ thuộc vào session state được giữ cục bộ từ request trước để xử lý request hiện tại. Mỗi request mang đủ context cần thiết hoặc server lấy state từ hệ thống dùng chung.

```text
Request A → Server 1
Request B → Server 2
Request C → Server 3
```

Lợi ích:

- Bất kỳ instance nào cũng có thể xử lý request.
- Dễ load balance và horizontal scaling.
- Instance lỗi có thể được thay thế dễ hơn.
- Deploy và autoscaling ít phụ thuộc vào session cục bộ.

Trade-off:

- Request có thể phải mang thêm context hoặc token.
- State vẫn tồn tại ở nơi khác như database, cache hoặc session store.
- Dependency lưu state trở nên quan trọng và cần được mở rộng, bảo vệ.

##### Stateful server

Server duy trì context liên quan đến client hoặc interaction qua nhiều request/message. Ví dụ:

- Connection state của WebSocket.
- Trạng thái phiên game đang diễn ra.
- Phiên collaborative editing.
- Stream hoặc transaction dài cần continuity.

Trade-off:

- Có thể phải route client về cùng instance bằng session affinity.
- Failover cần khôi phục hoặc đồng bộ state.
- Rebalancing connection khó hơn.
- Deploy và scale-in phải xử lý connection đang hoạt động.

Kiến trúc thường ưu tiên stateless application server khi hợp lý và đưa durable/shared state vào database, cache hoặc distributed session store. Tuy nhiên, state không biến mất; nó chỉ được đặt tại vị trí dễ quản lý hơn.

> **Stateless không có nghĩa hệ thống không có state; nó có nghĩa server instance không dựa vào state cục bộ giữa các request.**

#### Caching trong Client–Server Model

Caching giảm việc tải hoặc tính toán lặp lại:

| Lớp cache | Nội dung thường cache | Lợi ích |
|---|---|---|
| **Browser cache** | CSS, JavaScript, font, ảnh và response được phép cache | Giảm latency và network traffic |
| **CDN / edge cache** | Static asset, media và một số HTTP response | Đưa nội dung gần người dùng, giảm tải origin |
| **Reverse proxy cache** | Response dùng chung ở trước application server | Giảm request tới backend |
| **Application / distributed cache** | Object, query result hoặc computed data | Giảm tính toán và tải database |
| **Database internal cache** | Page, index hoặc execution data do database quản lý | Tăng tốc truy cập storage |

Caching cải thiện performance và scalability nhưng tạo bài toán invalidation, consistency, freshness và cache stampede. Redis hoặc Memcached thường là application/distributed cache đứng trước database, không nhất thiết là “database cache” nội bộ.

#### Load Balancing trong Client–Server Model

```text
Clients
   ↓
Load Balancer
   ├──→ Server 1
   ├──→ Server 2
   └──→ Server 3
```

Load balancer:

- Phân phối request qua nhiều server.
- Tránh gửi request tới instance không khỏe.
- Hỗ trợ scale-out và thay thế instance.
- Tạo điểm vào ổn định trong khi backend thay đổi.
- Có thể kết thúc TLS, định tuyến theo path hoặc áp dụng policy.

Một số thuật toán:

| Thuật toán | Ý tưởng | Lưu ý |
|---|---|---|
| **Round robin** | Luân phiên qua các server | Đơn giản nhưng không phản ánh tải thực tế |
| **Least connections** | Chọn server có ít connection đang hoạt động | Hữu ích khi connection có thời lượng khác nhau |
| **Weighted routing** | Server mạnh hơn nhận trọng số cao hơn | Cần cấu hình và điều chỉnh phù hợp |
| **IP hash** | Ánh xạ client IP tới backend | Có thể tạo affinity nhưng phân phối lệch do NAT hoặc proxy |

Load balancer bản thân cũng phải được triển khai có redundancy; nếu chỉ có một instance không dự phòng, nó có thể trở thành single point of failure.

#### Những hạn chế và rủi ro

| Rủi ro | Hệ quả | Hướng xử lý |
|---|---|---|
| Server hoặc dependency tập trung | Bottleneck hoặc single point of failure | Replication, load balancing, failover, multi-zone |
| Lưu lượng tăng nhanh | Quá tải CPU, memory, connection hoặc database | Horizontal scaling, caching, backpressure, rate limiting |
| Network không ổn định | Timeout, retry storm, trạng thái không chắc chắn | Timeout budget, retry có backoff/jitter, idempotency, circuit breaker |
| Centralized data | Mục tiêu có giá trị cao cho tấn công | Encryption, authentication, authorization, segmentation, audit |
| Client không đáng tin | Input giả, sửa request, lạm dụng API | Server-side validation, access control, abuse prevention |
| Dependency chain dài | Latency và lỗi bị khuếch đại | Giảm fan-out, cache, bulkhead, async processing |

Các đe dọa phổ biến:

- **MITM:** giảm thiểu bằng TLS/HTTPS được xác thực và cấu hình đúng.
- **DDoS:** sử dụng CDN/DDoS protection, capacity, rate limiting và filtering; không có một biện pháp đơn lẻ đủ cho mọi cuộc tấn công.
- **SQL injection:** dùng parameterized query, validation và quyền database tối thiểu.
- **XSS:** output encoding, sanitization phù hợp, CSP và tránh chèn dữ liệu không tin cậy vào executable context.
- **Authentication/session attack:** bảo vệ credential, token, cookie và session lifecycle.

#### Thiết kế hệ thống Client–Server chịu tải cao

Không nên bắt đầu bằng danh sách công nghệ. Trước tiên cần làm rõ workload, latency target, availability target, read/write ratio, dữ liệu và consistency.

Một kiến trúc tham khảo:

```text
Users
  ↓
DNS / Global Routing
  ↓
CDN / Edge Protection
  ↓
Load Balancer
  ↓
Stateless Application Servers
  ├──→ Distributed Cache
  ├──→ Message Queue / Workers
  └──→ Database + Read Replicas
```

Checklist thiết kế:

1. Dùng load balancer và nhiều application instance qua các failure domain.
2. Giữ application server stateless khi phù hợp để dễ scale-out.
3. Cache ở đúng lớp và xác định chiến lược invalidation.
4. Đưa static content tới CDN.
5. Tối ưu database bằng schema, index, query và replication phù hợp.
6. Dùng queue cho công việc dài hoặc tải đột biến nếu semantics cho phép.
7. Đặt timeout, retry budget, circuit breaker và backpressure.
8. Áp dụng authentication, authorization, encryption và rate limiting.
9. Quan sát latency, throughput, error rate và saturation.
10. Kiểm thử overload, dependency failure và recovery.

**Microservices không phải yêu cầu bắt buộc.** Monolith có cấu trúc tốt vẫn có thể scale ngang và thường dễ vận hành hơn ở giai đoạn đầu. Chỉ tách service khi ranh giới domain, nhu cầu triển khai độc lập, quy mô đội ngũ hoặc đặc tính tải tạo ra lợi ích lớn hơn chi phí phân tán.

#### Nội dung phụ — 14 câu hỏi phỏng vấn Client–Server

##### Nhóm 1. Câu hỏi nền tảng

**1. Client–server model là gì và hoạt động ra sao?**

> Đây là mô hình trong đó client khởi tạo yêu cầu, server lắng nghe, xử lý và trả kết quả qua protocol thống nhất. Việc tách vai trò giúp tập trung business logic và dữ liệu ở server, đồng thời cho phép client và server phát triển, bảo mật và mở rộng tương đối độc lập.

**2. Client giao tiếp với server bằng cách nào?**

> Client tìm endpoint, thiết lập kết nối phù hợp rồi trao đổi message qua protocol như HTTP, WebSocket, SMTP hoặc database protocol. Chất lượng giao tiếp phụ thuộc vào latency, bandwidth, timeout, retry và contract giữa hai phía, không chỉ vào code xử lý.

**3. Các ví dụ thực tế là gì?**

- Browser ↔ web server.
- Mobile app ↔ backend API.
- Email client ↔ SMTP/IMAP server.
- Streaming app ↔ CDN/media service.
- Game client ↔ authoritative game server.
- Application service ↔ database server.

**4. Client và server khác nhau như thế nào?**

> Client thường khởi tạo yêu cầu và tiêu thụ dịch vụ; server lắng nghe và cung cấp dịch vụ. Đây là vai trò theo từng interaction: một API service có thể đồng thời là server đối với mobile app và client đối với database.

##### Nhóm 2. Request–response cycle

**5. Giải thích HTTP request–response cycle bằng ví dụ.**

> Browser phân giải domain, kết nối tới endpoint và gửi request như `GET /products/42`. Server định tuyến request, xác thực, thực thi logic, gọi dependency nếu cần rồi trả status code, header và body. Browser xử lý response và có thể gửi thêm nhiều request cho tài nguyên liên quan.

**6. Synchronous và asynchronous communication khác nhau thế nào?**

> Với synchronous communication, luồng gọi phụ thuộc vào kết quả và phải chờ. Với asynchronous communication, công việc được tiếp nhận để xử lý sau và kết quả đến qua event, callback, polling hoặc message. Đồng bộ đơn giản hơn; bất đồng bộ giúp tách tải và thời gian nhưng làm retry, ordering, duplicate và observability phức tạp hơn.

**7. Browser tải một webpage như thế nào?**

> Browser phân tích URL, kiểm tra cache, phân giải DNS, thiết lập kết nối bảo mật, gửi HTTP request và nhận HTML. Sau khi phân tích HTML, browser tải thêm CSS, JavaScript, font và ảnh, xây dựng cấu trúc render rồi hiển thị trang. Các request có thể qua CDN, proxy và load balancer trước khi tới origin.

##### Nhóm 3. Architecture và Design

**8. Stateless và stateful server khác nhau ra sao?**

> Stateless instance không dựa vào session state cục bộ từ request trước, nên request có thể được xử lý bởi bất kỳ instance nào. Stateful server giữ context giữa các interaction, phù hợp connection hoặc workflow cần continuity nhưng làm load balancing, scale và failover phức tạp hơn.

**9. Caching cải thiện hiệu năng thế nào?**

> Cache phục vụ dữ liệu gần nơi sử dụng hơn và tránh tải hoặc tính toán lặp lại. Có thể cache ở browser, CDN, proxy hoặc application layer. Lợi ích là giảm latency và backend load; trade-off là freshness, invalidation, consistency và nguy cơ stampede.

**10. Load balancer hoạt động ra sao?**

> Load balancer tạo điểm vào ổn định, kiểm tra health và phân phối request qua nhiều backend bằng thuật toán như round robin, least connections hoặc weighted routing. Nó giúp scale-out và failover, nhưng cũng cần redundancy và capacity phù hợp.

##### Nhóm 4. Câu hỏi nâng cao

**11. Các thách thức bảo mật phổ biến là gì?**

> Cần xét MITM, DDoS, injection, XSS, credential theft, session abuse và broken access control. Các lớp bảo vệ gồm TLS, server-side validation, parameterized query, authentication, authorization, least privilege, rate limiting, filtering và monitoring.

**12. WebSocket khác request–response truyền thống thế nào?**

> WebSocket giữ một kênh hai chiều để cả client và server gửi message theo thời gian thực. HTTP thường tổ chức tương tác thành request và response, dù có thể tái sử dụng connection. WebSocket phù hợp chat và live update nhưng đòi hỏi quản lý connection, heartbeat, reconnect, backpressure và state phức tạp hơn.

**13. Hạn chế của client–server model và cách xử lý?**

> Server tập trung có thể thành bottleneck hoặc điểm lỗi; network tạo latency và partial failure; dữ liệu tập trung là mục tiêu tấn công. Có thể xử lý bằng replication, load balancing, scale-out, caching, multi-zone, timeout/retry đúng cách và nhiều lớp bảo mật. Tuy nhiên, mỗi biện pháp lại thêm chi phí và operational complexity.

**14. Thiết kế hệ thống client–server chịu lưu lượng cao như thế nào?**

> Bắt đầu từ yêu cầu và ước lượng tải. Dùng DNS/global routing, CDN, load balancer và nhiều stateless application instance; cache dữ liệu nóng; tách background work qua queue khi phù hợp; tối ưu và mở rộng database; triển khai redundancy, rate limiting và observability. Chọn monolith hay microservices dựa trên ranh giới và trade-off thực tế, không theo mặc định.

#### Câu hỏi tư duy mở rộng

1. Nếu client timeout nhưng server đã hoàn thành thao tác ghi, retry có tạo duplicate không?
2. Khi nào polling đơn giản hơn WebSocket và vẫn đáp ứng yêu cầu?
3. Session state nên nằm ở cookie, application server, cache hay database?
4. Một synchronous call chain dài ảnh hưởng latency và reliability thế nào?
5. Nếu load balancer lỗi, client còn đường nào tới server?
6. Làm thế nào deploy server mới mà không làm rơi persistent connection?
7. Khi cache trả dữ liệu cũ, nghiệp vụ có chấp nhận được không?
8. Làm thế nào bảo vệ backend khi client gửi tải vượt khả năng xử lý?

#### Ý chính cần nhớ

- Client yêu cầu dịch vụ; server xử lý và cung cấp kết quả; network kết nối hai phía.
- Client và server là vai trò, nên một service có thể đảm nhiệm cả hai trong các interaction khác nhau.
- Giao tiếp tạo latency, chi phí tài nguyên và failure point.
- HTTP request–response là nền tảng của web nhưng một trang thường cần nhiều request.
- HTTP có thể tái sử dụng connection; không nên đồng nhất request–response với “mỗi request một kết nối mới”.
- WebSocket hỗ trợ kết nối hai chiều lâu dài nhưng làm quản lý connection và failover phức tạp hơn.
- Synchronous/asynchronous, stateless/stateful và connection lifetime là các chiều thiết kế khác nhau.
- Stateless application server dễ load balance và scale, nhưng state vẫn phải tồn tại ở nơi khác.
- Cache và load balancer cải thiện scalability nhưng đều tạo trade-off và yêu cầu vận hành riêng.
- Hệ thống chịu tải cao cần bảo vệ database, dependency và chính server khỏi overload.
- Microservices không mặc nhiên cần thiết; kiến trúc phải xuất phát từ yêu cầu và ràng buộc.

#### Công thức ghi nhớ

> **Client yêu cầu, server xử lý, network truyền tải; thiết kế tốt phải quyết định rõ công việc và state nằm ở đâu, giao tiếp theo cách nào, và hệ thống phản ứng ra sao khi mạng hoặc server gặp lỗi.**

---

### Bài 11. Forward Proxy và Reverse Proxy

#### Proxy là gì?

**Proxy** là thành phần trung gian nằm trên đường giao tiếp giữa hai phía. Thay vì client trao đổi trực tiếp với server đích, request đi qua proxy; proxy có thể kiểm tra, chặn, sửa đổi, định tuyến, cache hoặc ghi nhận lưu lượng trước khi chuyển tiếp.

```text
Client ──→ Proxy ──→ Destination Server
Client ←── Proxy ←── Destination Server
```

Proxy tạo ra một **control point** trong kiến trúc. Nhờ đó, tổ chức có thể triển khai các concern dùng chung mà không phải lặp lại trong mọi client hoặc backend:

- Access control và policy enforcement.
- Traffic filtering và rate limiting.
- Logging, metrics và tracing.
- Caching và compression.
- Routing và load balancing.
- TLS termination hoặc TLS origination.
- Che giấu topology phía sau một interface ổn định.

Tuy nhiên, proxy cũng tạo thêm:

- Một network hop và latency.
- Một dependency có thể lỗi hoặc quá tải.
- Một trust boundary có khả năng nhìn thấy metadata hoặc nội dung traffic.
- Chi phí cấu hình, quan sát và vận hành.

Điểm phân biệt quan trọng nhất giữa hai loại proxy không phải là “proxy làm gì”, mà là **proxy đại diện cho phía nào**.

#### Forward Proxy

**Forward proxy đại diện cho client** khi client truy cập server bên ngoài.

```text
Clients                       Internet
 C1 ─┐
 C2 ─┼─→ Forward Proxy ──→ Destination Servers
 C3 ─┘
```

Server đích nhận kết nối từ forward proxy và có thể không nhìn thấy địa chỉ mạng trực tiếp của client ban đầu. Client hoặc network của client biết và chủ động sử dụng proxy; server đích không nhất thiết biết danh tính cụ thể phía sau proxy.

Các use case phổ biến:

- Kiểm soát website hoặc dịch vụ mà nhân viên được phép truy cập.
- Chặn domain, content category hoặc destination độc hại.
- Ghi log và audit outbound traffic.
- Quét malware hoặc data loss policy trên lưu lượng phù hợp.
- Cache nội dung được nhiều client nội bộ truy cập.
- Cung cấp một egress point ổn định cho network private.
- Định tuyến outbound traffic qua một vị trí hoặc network cụ thể.

Forward proxy giải quyết câu hỏi:

> **Client của tôi được đi đâu và lưu lượng đi ra được kiểm soát như thế nào?**

#### Forward Proxy và privacy

Destination thường thấy IP của proxy thay vì IP trực tiếp của client. Điều này có thể giảm mức độ lộ địa chỉ client, nhưng không tự động tạo ra ẩn danh hoàn toàn.

Danh tính vẫn có thể lộ qua:

- Login account và cookie.
- Browser fingerprint.
- HTTP header hoặc application metadata.
- DNS leak hoặc traffic đi ngoài proxy.
- Log do proxy lưu giữ.
- Mẫu hành vi và correlation giữa các request.

Proxy cũng không mặc nhiên mã hóa traffic. Khả năng mã hóa phụ thuộc vào protocol và mô hình triển khai, chẳng hạn HTTPS tunnel hoặc VPN.

**VPN và Tor không hoàn toàn đồng nghĩa với forward proxy:**

- VPN tạo tunnel ở lớp mạng hoặc transport cho phạm vi traffic rộng hơn.
- Tor là mạng overlay nhiều hop được thiết kế để giảm khả năng liên kết nguồn với đích.
- Forward proxy thường chuyển tiếp một số protocol hoặc application traffic cụ thể.

Chúng có điểm chung là trung gian hóa outbound traffic, nhưng kiến trúc, trust model và security property khác nhau.

#### Reverse Proxy

**Reverse proxy đại diện cho backend server** và đứng trước hạ tầng ứng dụng.

```text
Internet Clients
       ↓
Reverse Proxy
   ├──→ Backend A
   ├──→ Backend B
   └──→ Backend C
```

Đối với client, reverse proxy trông giống endpoint của ứng dụng. Client không cần biết server nào thực sự xử lý request hoặc backend topology thay đổi như thế nào.

Các use case phổ biến:

- Load balancing qua nhiều backend.
- Health check và ngừng gửi traffic tới instance lỗi.
- TLS termination và quản lý certificate tập trung.
- Caching response có thể cache.
- Routing theo hostname, path, header hoặc version.
- Rate limiting, bot filtering và WAF integration.
- Compression và protocol translation.
- Che giấu origin address và internal topology.
- Centralized logging, metrics và request tracing.

Reverse proxy giải quyết câu hỏi:

> **Ai được vào ứng dụng của tôi, request đi tới backend nào và các backend được bảo vệ ra sao?**

#### So sánh Forward Proxy và Reverse Proxy

| Tiêu chí | Forward Proxy | Reverse Proxy |
|---|---|---|
| Đại diện cho | Client | Backend server hoặc application |
| Vị trí logic | Giữa client và Internet/destination | Giữa Internet/client và backend |
| Ai thường cấu hình hoặc kiểm soát? | Người dùng, doanh nghiệp hoặc network phía client | Chủ sở hữu dịch vụ hoặc nền tảng backend |
| Che giấu chủ yếu | Client/network nguồn đối với destination | Backend topology và origin đối với client |
| Hướng traffic chính | Outbound từ client | Inbound vào application |
| Mục tiêu phổ biến | Egress control, filtering, privacy, outbound audit | Load balancing, TLS, caching, routing, backend protection |
| Cache | Có thể cache nội dung dùng chung cho client | Có thể cache response để giảm tải backend |
| Ví dụ triển khai | Corporate HTTP proxy, egress proxy | Web reverse proxy, ingress, CDN edge, API entry layer |

Cách nhớ nhanh:

```text
Forward Proxy  → đứng về phía CLIENT  → quản lý đường ĐI RA
Reverse Proxy  → đứng về phía SERVER  → quản lý đường ĐI VÀO
```

#### Reverse Proxy và Load Balancing

Reverse proxy có thể chọn backend cho mỗi request hoặc connection:

```text
Request
   ↓
Reverse Proxy
   ├── health? weight? active connections? ──→ Backend A
   ├── path? hostname? header? ──────────────→ Backend B
   └── session affinity? ────────────────────→ Backend C
```

Một số thuật toán thường gặp:

- Round robin.
- Weighted round robin.
- Least connections.
- Consistent hash hoặc IP hash trong một số trường hợp.
- Routing theo content ở Layer 7.

Lợi ích:

- Phân phối tải và tránh một server nhận toàn bộ request.
- Hỗ trợ scale-out hoặc thay thế backend mà client không cần biết.
- Chuyển traffic khỏi instance không khỏe.
- Cho phép canary, blue–green deployment hoặc traffic splitting.

Reverse proxy và load balancer có vùng chức năng giao nhau. Một reverse proxy thường có khả năng load balancing; một load balancer Layer 4 có thể không hiểu nội dung HTTP và không nhất thiết thực hiện đầy đủ các chức năng của reverse proxy Layer 7.

#### Reverse Proxy Caching

Reverse proxy có thể trả response từ cache mà không gọi backend:

```text
Client → Reverse Proxy Cache
              ├── cache hit  ─→ trả response ngay
              └── cache miss ─→ gọi backend → lưu → trả response
```

Lợi ích:

- Giảm response time.
- Giảm request tới application server và database.
- Hấp thụ traffic spike cho nội dung phổ biến.
- Tăng khả năng phục vụ static hoặc public content.

Rủi ro:

- Phục vụ dữ liệu cũ.
- Cache nhầm response riêng tư giữa các user.
- Cache key thiếu header, query hoặc identity quan trọng.
- Cache invalidation khó.
- Cache stampede khi một object nóng hết hạn.

Chỉ cache khi semantics cho phép. Cần xác định rõ cache key, TTL, header như `Cache-Control`, cơ chế purge và cách xử lý nội dung có authentication/cookie.

#### TLS Termination ở Reverse Proxy

Thuật ngữ hiện đại chính xác hơn là **TLS termination**, dù nhiều tài liệu vẫn gọi là SSL termination.

```text
Client ══ HTTPS/TLS ══> Reverse Proxy ── HTTP hoặc TLS ──> Backend
```

Reverse proxy:

1. Trình bày certificate của domain cho client.
2. Hoàn thành TLS handshake.
3. Giải mã request để định tuyến hoặc áp dụng policy Layer 7.
4. Chuyển tiếp request tới backend.

Lợi ích:

- Quản lý certificate và TLS policy tập trung.
- Giảm logic lặp lại trên từng backend.
- Cho phép reverse proxy đọc HTTP để routing, caching hoặc filtering.
- Đơn giản hóa rotation và cấu hình cipher/protocol.

Các mô hình kết nối tới backend:

| Mô hình | Đặc điểm | Trade-off |
|---|---|---|
| **TLS termination rồi HTTP nội bộ** | Backend nhận plaintext trong private network | Đơn giản nhưng traffic nội bộ không được mã hóa |
| **TLS re-encryption** | Proxy mở một TLS connection mới tới backend | Bảo vệ traffic nội bộ nhưng tăng certificate và compute management |
| **mTLS tới backend** | Cả proxy và backend xác thực lẫn nhau | Identity mạnh hơn nhưng vận hành PKI phức tạp hơn |
| **TLS passthrough** | Proxy không giải mã, chuyển connection TLS tới backend | Giữ end-to-end encryption nhưng hạn chế routing/inspection Layer 7 |

TLS termination không có nghĩa backend mặc nhiên an toàn. Nếu threat model yêu cầu mã hóa nội bộ hoặc zero trust, cần TLS/mTLS ở chặng proxy–backend.

#### Bảo toàn thông tin Client

Do backend nhận connection trực tiếp từ reverse proxy, source IP ở tầng transport thường là IP của proxy. Nếu backend cần biết client ban đầu, proxy có thể chuyển metadata qua header như `Forwarded` hoặc `X-Forwarded-For`.

Rủi ro quan trọng:

- Client có thể tự gửi header giả.
- Backend chỉ nên tin header được proxy tin cậy ghi đè hoặc chuẩn hóa.
- Danh sách trusted proxy phải được cấu hình chính xác.
- Không nên dùng client IP làm cơ chế authentication.

#### Reverse Proxy và DDoS Protection

Reverse proxy có thể hỗ trợ:

- Traffic filtering và bot detection.
- Rate limiting và connection limit.
- WAF rule.
- Cache để giảm tải origin.
- Phân phối request qua nhiều backend.
- Ẩn origin IP để attacker khó đi vòng qua proxy.

Nhưng một reverse proxy đơn lẻ không tự động chống được DDoS lớn. Nếu attack làm đầy đường truyền hoặc vượt capacity của proxy, backend vẫn không thể phục vụ.

Thiết kế chống DDoS thường cần:

- Hạ tầng edge phân tán và đủ capacity.
- Anycast hoặc scrubbing network.
- Upstream filtering.
- Rate limit nhiều chiều, không chỉ theo một IP.
- Origin firewall chỉ nhận traffic từ proxy tin cậy.
- Autoscaling, degradation và incident response.

Load distribution chỉ chia tải; nó không biến traffic độc hại thành traffic hợp lệ và có thể khiến toàn bộ backend cùng bị quá tải nếu không có filtering/backpressure.

#### Proxy như một Control Point và Failure Point

Centralization mang lại tính nhất quán nhưng cũng tạo rủi ro:

| Lợi ích | Rủi ro tương ứng |
|---|---|
| Policy tập trung | Cấu hình sai ảnh hưởng toàn bộ traffic |
| Logging tập trung | Có thể lưu dữ liệu nhạy cảm và cần bảo vệ log |
| TLS tập trung | Certificate/key tại proxy trở thành tài sản quan trọng |
| Routing tập trung | Proxy lỗi có thể làm toàn bộ backend không truy cập được |
| Filtering tập trung | False positive có thể chặn người dùng hợp lệ |

Checklist production:

- Nhiều proxy instance qua nhiều failure domain.
- Health check và failover được kiểm thử.
- Capacity cho peak traffic và connection spike.
- Timeout, retry và connection pool phù hợp.
- Cấu hình được review, version hóa và rollback.
- Metrics về latency, error, saturation và backend health.
- Log không vô tình chứa secret hoặc dữ liệu cá nhân.
- Bảo vệ certificate, private key và control plane.
- Backend không bị truy cập trực tiếp nếu proxy là security boundary.

#### Khi nào dùng loại nào?

| Nhu cầu | Forward Proxy | Reverse Proxy |
|---|:---:|:---:|
| Kiểm soát outbound Internet của nhân viên | ✓ |  |
| Tạo egress IP ổn định | ✓ |  |
| Lọc website đích | ✓ |  |
| Ẩn backend topology |  | ✓ |
| Load balance nhiều backend |  | ✓ |
| TLS termination cho application |  | ✓ |
| Cache nội dung | Có thể | Có thể |
| Bảo vệ origin và quản lý inbound traffic |  | ✓ |

Một hệ thống có thể sử dụng cả hai:

```text
Internal Client
      ↓
Forward / Egress Proxy
      ↓ Internet
Reverse Proxy của dịch vụ đích
      ↓
Backend Servers
```

#### Nội dung phụ — 10 câu hỏi phỏng vấn về Proxy

##### 1. Proxy server là gì và tại sao được sử dụng?

> Proxy là trung gian nhận traffic từ một phía rồi chuyển tiếp tới phía còn lại. Nó tạo control point để áp dụng routing, security policy, caching, access control, optimization và observability mà không buộc mọi endpoint tự triển khai. Trade-off là thêm latency, dependency và trust boundary.

##### 2. Khác biệt chính giữa forward proxy và reverse proxy?

> Forward proxy đại diện cho client và quản lý outbound access; destination thấy proxy thay cho kết nối trực tiếp từ client. Reverse proxy đại diện cho server, cung cấp một entry point trước backend để routing, load balancing, TLS, caching và protection. Câu hỏi phân biệt nhanh nhất là: proxy này do phía nào kiểm soát và nó che giấu phía nào?

##### 3. Forward proxy cải thiện security và privacy như thế nào?

> Nó có thể che địa chỉ trực tiếp của client, kiểm soát destination, lọc nội dung độc hại và ghi audit outbound traffic. Tuy nhiên, privacy phụ thuộc vào proxy có đáng tin không, traffic có được mã hóa không và application có lộ identity qua account, cookie hoặc fingerprint không. Proxy không mặc nhiên bảo đảm ẩn danh.

##### 4. Reverse proxy hỗ trợ load balancing và caching ra sao?

> Nó chọn backend dựa trên health, load hoặc routing policy; đồng thời có thể trả cached response mà không gọi origin. Hai chức năng này giảm overload và latency, nhưng cần health check chính xác, cache key đúng, invalidation và bảo đảm proxy không thành điểm lỗi duy nhất.

##### 5. Ví dụ thực tế của hai loại proxy?

- Forward proxy: corporate web proxy, egress proxy và privacy proxy.
- Các hệ thống tunnel như VPN hoặc Tor có mục tiêu gần nhau ở một số use case nhưng không hoàn toàn là cùng một kiến trúc.
- Reverse proxy: web ingress, CDN edge, application gateway, Nginx hoặc HAProxy được cấu hình phía trước backend, cloud load balancer Layer 7.

##### 6. Khi nào dùng forward proxy và khi nào dùng reverse proxy?

> Dùng forward proxy khi cần kiểm soát hoặc quan sát đường đi ra của client. Dùng reverse proxy khi cần quản lý đường đi vào application và che giấu backend. Dùng cả hai nếu một tổ chức vừa cần egress control, vừa cần bảo vệ các dịch vụ inbound.

##### 7. Một số công cụ và công nghệ phổ biến?

| Nhóm | Ví dụ | Lưu ý |
|---|---|---|
| Forward proxy | Squid, enterprise secure web gateway, egress proxy | Khả năng thay đổi tùy protocol và cấu hình |
| Reverse proxy | Nginx, HAProxy, Envoy, cloud application load balancer, CDN/reverse-proxy service | Một sản phẩm có thể đảm nhiệm nhiều vai trò |
| Tunnel/overlay liên quan | VPN, Tor, Shadowsocks | Không nên đồng nhất hoàn toàn với HTTP forward proxy |

Tên sản phẩm ít quan trọng hơn capability: Layer 4 hay Layer 7, protocol support, health check, TLS, caching, policy, observability và operational model.

##### 8. Reverse proxy bảo vệ backend khỏi DDoS như thế nào?

> Nó có thể lọc request, giới hạn tốc độ, cache response, chặn bot và giấu origin. Nhưng để chống volumetric DDoS, proxy phải nằm trên hạ tầng edge có đủ network capacity; origin phải chặn đường truy cập trực tiếp. Một reverse proxy nhỏ đặt cùng data center với backend không thể cứu hệ thống nếu đường truyền đã bị bão hòa.

##### 9. TLS termination hoạt động thế nào?

> Client thiết lập TLS với reverse proxy; proxy giữ certificate và private key, giải mã traffic rồi áp dụng routing hoặc policy. Sau đó proxy có thể gửi HTTP nội bộ, re-encrypt bằng TLS hoặc dùng mTLS tới backend. Lựa chọn phụ thuộc threat model, compliance, hiệu năng và độ phức tạp PKI.

##### 10. Lựa chọn reverse proxy dựa trên tiêu chí nào?

Thay vì ghi nhớ “công cụ nào tốt nhất”, hãy đánh giá:

- Layer 4 hay Layer 7.
- Protocol và WebSocket/streaming support.
- Load-balancing algorithm và health check.
- TLS, mTLS và certificate automation.
- Caching, compression, WAF và rate limiting.
- Global edge/DDoS capacity nếu cần.
- Dynamic configuration và service discovery.
- Metrics, logs, tracing và debugging.
- High availability, upgrade và rollback.
- Chi phí, đội ngũ vận hành và mức độ phụ thuộc nhà cung cấp.

#### Câu hỏi tư duy mở rộng

1. Nếu reverse proxy lỗi, client còn đường nào tới backend?
2. Có nên cho phép origin nhận traffic trực tiếp từ Internet không?
3. Cache key cần chứa gì để không trả nhầm dữ liệu giữa người dùng?
4. Khi proxy terminate TLS, traffic tới backend có cần được mã hóa lại không?
5. Làm thế nào truyền client IP mà không tin header giả từ Internet?
6. Forward proxy có thể đọc HTTPS payload trong điều kiện nào và rủi ro là gì?
7. Persistent WebSocket connection ảnh hưởng scale và deploy proxy ra sao?
8. Khi nào Layer 4 proxy phù hợp hơn Layer 7 reverse proxy?
9. Proxy retry một request ghi có thể tạo duplicate operation không?
10. Làm sao tránh proxy trở thành bottleneck khi traffic tăng đột biến?

#### Ý chính cần nhớ

- Proxy là trung gian và control point trên đường giao tiếp.
- Forward proxy đại diện client và quản lý outbound traffic.
- Reverse proxy đại diện server và quản lý inbound traffic.
- Forward proxy có thể hỗ trợ privacy nhưng không mặc nhiên tạo ẩn danh hoặc mã hóa.
- Reverse proxy thường thực hiện routing, load balancing, TLS, caching và protection.
- Reverse proxy caching chỉ an toàn khi cache key và policy được thiết kế đúng.
- TLS termination cần quyết định rõ cách bảo vệ chặng proxy–backend.
- Header chứa client IP chỉ đáng tin khi được proxy tin cậy chuẩn hóa.
- Reverse proxy đơn lẻ không đủ chống mọi DDoS; cần edge capacity và bảo vệ origin.
- Proxy tập trung cross-cutting concern nhưng cũng có thể trở thành bottleneck và failure point.
- Công cụ chỉ là cách triển khai; quyết định kiến trúc phải dựa trên vị trí, trách nhiệm và trade-off.

#### Công thức ghi nhớ

> **Forward proxy đứng về phía client và quản lý đường đi ra; reverse proxy đứng về phía server và quản lý đường đi vào.**

---

### Bài 12. Nhập môn Load Balancing

#### Vì sao cần Load Balancing?

Phần lớn ứng dụng bắt đầu với một server vì kiến trúc này đơn giản, nhanh triển khai và tiết kiệm chi phí:

```text
Clients ──→ Single Server
```

Khi lượng người dùng và request tăng, server dần chạm giới hạn CPU, memory, storage I/O, network bandwidth, connection hoặc downstream dependency. Dấu hiệu thường thấy:

- Response time tăng.
- Request phải xếp hàng lâu hơn.
- Timeout và error xuất hiện nhiều hơn.
- Một số tài nguyên đạt saturation.
- Deploy hoặc bảo trì làm gián đoạn toàn bộ dịch vụ.

Single server tạo ra hai vấn đề:

1. **Capacity limit:** một máy chỉ có thể xử lý tới một mức tải hữu hạn.
2. **Single point of failure:** nếu máy đó lỗi, toàn bộ ứng dụng có thể ngừng phục vụ.

Vì vậy, load balancing không chỉ là tối ưu hiệu năng. Khi hệ thống cần nhiều server hoặc yêu cầu availability cao, nó trở thành một thành phần kiến trúc nền tảng.

#### Vertical Scaling và giới hạn

Phản ứng đầu tiên khi server quá tải thường là tăng CPU, memory, storage hoặc network capacity. Đây là **vertical scaling — scale up**.

```text
Server nhỏ → Server mạnh hơn → Server rất mạnh
```

Ưu điểm:

- Đơn giản hơn vì vẫn vận hành ít node.
- Không cần phân phối request giữa nhiều application instance.
- Có thể là cách nhanh nhất để mua thêm thời gian.
- Hợp lý với workload khó phân chia hoặc giai đoạn đầu.

Giới hạn:

- Có trần vật lý và giới hạn của nhà cung cấp.
- Máy lớn thường tăng giá nhanh hơn mức tăng capacity.
- Upgrade có thể cần downtime hoặc migration.
- Vẫn phụ thuộc nhiều vào một failure domain.
- Không giải quyết bản chất của single point of failure nếu chỉ có một máy.

Vertical scaling là một công cụ hợp lệ, không phải lựa chọn sai. Vấn đề xuất hiện khi nó không còn đáp ứng mục tiêu tăng trưởng hoặc availability.

#### Horizontal Scaling tạo ra bài toán điều phối

**Horizontal scaling — scale out** bổ sung nhiều server để chia workload:

```text
            ┌→ Server A
Clients ────┼→ Server B
            └→ Server C
```

Capacity tổng thể tăng và hệ thống bớt phụ thuộc vào một application instance. Nhưng một câu hỏi mới xuất hiện:

- Request nên tới server nào?
- Server nào đang khỏe?
- Làm sao tránh một server quá tải trong khi server khác rảnh?
- Client có cần biết mọi server không?
- Khi thêm hoặc xóa server, client có phải cập nhật không?

Đây là một pattern quen thuộc của System Design:

> **Giải quyết bottleneck về capacity thường tạo ra bài toán coordination.**

Client không nên tự giữ danh sách và lựa chọn từng backend, vì như vậy client bị coupling chặt với topology nội bộ. Hệ thống cần một lớp phân phối traffic.

#### Load Balancer là gì?

**Load balancer** nhận traffic từ client rồi chọn một backend phù hợp để xử lý.

```text
Clients
   ↓ stable endpoint
Load Balancer
   ├──→ Server A
   ├──→ Server B
   └──→ Server C
```

Đối với client, hệ thống cung cấp một interface ổn định. Phía sau interface đó, backend có thể được thêm, thay thế, nâng cấp hoặc loại khỏi rotation mà client không cần biết chi tiết.

Các trách nhiệm thường gặp:

- Phân phối connection hoặc request.
- Theo dõi health của backend.
- Không gửi traffic mới tới backend không khỏe.
- Đưa backend mới vào rotation.
- Hỗ trợ connection draining khi deploy hoặc bảo trì.
- Có thể terminate TLS hoặc định tuyến Layer 7.
- Ghi nhận metrics về traffic và backend health.

#### Luồng xử lý cơ bản

```text
1. Client gửi request tới endpoint của load balancer
2. Load balancer kiểm tra pool backend khả dụng
3. Áp dụng thuật toán hoặc routing policy
4. Chuyển request/connection tới backend được chọn
5. Backend xử lý và trả response
6. Response quay về client, thường qua load balancer
```

Tùy kiến trúc, load balancer có thể hoạt động như proxy đầy đủ, chuyển tiếp connection ở Layer 4, hoặc dùng cơ chế định tuyến khác. Điểm chung là client không tự điều phối từng backend.

#### Load Balancing cải thiện Scalability

Load balancer cho phép tăng capacity theo từng bước:

```text
Traffic tăng
    ↓
Thêm backend instance
    ↓
Đăng ký instance vào backend pool
    ↓
Health check thành công
    ↓
Load balancer bắt đầu gửi traffic
```

Lợi ích:

- Scale-out mà không đổi endpoint phía client.
- Sử dụng capacity của nhiều máy.
- Hỗ trợ autoscaling theo tải.
- Phân phối nhiều loại request tới pool phù hợp.
- Cho phép capacity tăng hoặc giảm dần theo nhu cầu.

Tuy nhiên, load balancer không tự làm ứng dụng trở nên horizontally scalable. Application vẫn phải xử lý đúng khi chạy nhiều instance:

- Tránh phụ thuộc vào local session state hoặc dùng shared session store.
- Đồng bộ hoặc quản lý shared data đúng cách.
- Thiết kế idempotency và concurrency.
- Database và dependency phải chịu được tổng tải tăng.
- Background job không được xử lý trùng ngoài ý muốn.

Nếu database vẫn là bottleneck, thêm nhiều application server có thể chỉ làm database quá tải nhanh hơn.

#### Load Balancing cải thiện Reliability và Availability

Với nhiều backend, hệ thống có thể tiếp tục phục vụ khi một instance lỗi:

```text
              Server A ✓
Load Balancer Server B ✗  → loại khỏi rotation
              Server C ✓
```

Sự thay đổi tư duy quan trọng:

> Không cố giữ mọi server sống mãi; hãy giữ dịch vụ tiếp tục hoạt động khi server riêng lẻ đến và đi.

Điều này hỗ trợ:

- Chịu lỗi của từng instance.
- Rolling deployment.
- Nâng cấp hoặc bảo trì từng máy.
- Thay thế instance không khỏe.
- Scale-in và scale-out ít gián đoạn hơn.

Nhưng availability chỉ được cải thiện khi đồng thời thỏa các điều kiện:

- Có nhiều backend qua các failure domain độc lập.
- Load balancer hoặc lớp entry không phải single point of failure.
- Health check phát hiện lỗi đủ nhanh và đủ chính xác.
- Các backend còn lại có đủ capacity sau sự cố.
- Session/state không bị mất hoặc khóa vào instance đã lỗi.
- Dependency dùng chung như database vẫn hoạt động.

#### Health Check

Load balancer cần biết backend nào có thể nhận traffic.

| Loại check | Kiểm tra | Ưu điểm | Hạn chế |
|---|---|---|---|
| **TCP check** | Có mở được connection tới port không | Nhẹ và nhanh | Process vẫn có thể mở port nhưng ứng dụng không hoạt động đúng |
| **HTTP shallow check** | Endpoint đơn giản trả status mong đợi không | Hiểu application hơn TCP | Có thể bỏ sót dependency quan trọng |
| **Deep health check** | Kiểm tra thêm dependency hoặc luồng nghiệp vụ | Phản ánh khả năng phục vụ thực tế hơn | Đắt, dễ tạo tải và có thể loại hàng loạt backend khi shared dependency lỗi |

Hai khái niệm nên tách biệt:

- **Liveness:** process có còn sống và cần restart không?
- **Readiness:** instance hiện có sẵn sàng nhận traffic không?

Health check luôn có khoảng trễ phát hiện. Request đang xử lý trên server vừa lỗi vẫn có thể thất bại. Load balancing giảm blast radius chứ không làm lỗi biến mất hoàn toàn.

#### Connection Draining

Khi deploy hoặc loại một server khỏi pool, không nên cắt ngay mọi connection đang hoạt động.

```text
Đánh dấu backend “draining”
        ↓
Ngừng gửi request/connection mới
        ↓
Cho request hiện tại hoàn thành trong giới hạn
        ↓
Đóng connection còn lại và dừng instance
```

Draining đặc biệt quan trọng với upload lớn, streaming, WebSocket và long-lived request.

#### Stable Interface, Dynamic Infrastructure

Một nguyên lý kiến trúc quan trọng là:

> **Client tương tác với interface ổn định; hệ thống tự quản lý sự thay đổi của hạ tầng phía sau.**

Backend có thể là tài nguyên ngắn hạn:

- Được tạo bởi autoscaler.
- Bị thay thế khi lỗi.
- Thay đổi IP.
- Chuyển phiên bản trong rolling deployment.
- Được phân bổ lại giữa zone.

Load balancer kết hợp service discovery và health state để che giấu những thay đổi này khỏi client.

#### Load Balancing không đồng nghĩa “chia đều” tuyệt đối

Mục tiêu thực tế là phân phối tải **phù hợp**, không nhất thiết mỗi server nhận cùng số request.

Hai request có thể tiêu thụ tài nguyên rất khác nhau. Ngoài ra:

- Connection có thời lượng khác nhau.
- Server có capacity khác nhau.
- Request có thể cần session affinity.
- Một backend đang warm-up hoặc draining.
- Cache locality ảnh hưởng lựa chọn.

Thuật toán phổ biến sẽ được học sâu hơn, nhưng ở mức nhập môn có thể nhớ:

| Phương pháp | Ý tưởng |
|---|---|
| **Round robin** | Luân phiên backend |
| **Weighted round robin** | Backend mạnh hơn nhận nhiều traffic hơn |
| **Least connections** | Chọn backend có ít connection hoạt động hơn |
| **Hash-based routing** | Ánh xạ key như client hoặc object tới backend |

Không có thuật toán tốt nhất cho mọi workload. Cần hiểu đơn vị tải thực sự là request, connection, CPU time, byte truyền hay một tài nguyên khác.

#### Các Failure Mode cần nghĩ tới

| Failure mode | Điều có thể xảy ra | Hướng thiết kế |
|---|---|---|
| Backend crash | Request mới không nên tới server đó | Health check, removal, retry có kiểm soát |
| Load balancer lỗi | Toàn bộ entry point có thể mất | Nhiều instance, multi-zone, managed HA hoặc failover |
| Health check sai | Backend khỏe bị loại hoặc backend lỗi vẫn nhận traffic | Threshold, nhiều tín hiệu, check phù hợp |
| Backend còn lại thiếu capacity | Sự cố một node làm các node khác quá tải dây chuyền | Headroom, autoscaling, load shedding |
| Retry storm | Proxy/client retry làm tải tăng mạnh | Retry budget, backoff, jitter, idempotency |
| Session gắn vào server lỗi | Người dùng mất session hoặc request fail | Stateless server, shared state, affinity có recovery |
| Slow backend | Connection và queue tích tụ | Timeout, least-load policy, circuit breaking |
| Uneven traffic | Hotspot dù có nhiều server | Thuật toán phù hợp, metrics và rebalance |

#### Khi nào nên đưa Load Balancer vào hệ thống?

Không cần chờ tới khi server quá tải. Load balancer trở nên có giá trị khi có ít nhất một trong các yêu cầu:

- Cần nhiều application instance.
- Cần availability cao hơn khả năng của một server.
- Muốn rolling deployment hoặc bảo trì không downtime.
- Cần scale theo traffic.
- Cần stable endpoint trước dynamic backend.
- Cần health-based routing hoặc multi-zone.
- Cần central TLS/routing policy.

Trade-off là thêm chi phí, latency nhỏ, cấu hình và operational complexity. Với prototype nhỏ không có uptime requirement, một server có thể vẫn là lựa chọn hợp lý.

#### Quá trình tiến hóa kiến trúc

```text
Giai đoạn 1: Single Server
Clients → Server
        đơn giản, rẻ nhưng có giới hạn và SPOF

Giai đoạn 2: Vertical Scaling
Clients → Bigger Server
        thêm capacity nhưng vẫn có trần và SPOF

Giai đoạn 3: Horizontal Scaling
Clients → Nhiều Servers
        thêm capacity nhưng phát sinh coordination

Giai đoạn 4: Load-Balanced Architecture
Clients → HA Load Balancer Layer → Backend Pool
        stable interface + traffic distribution + health routing
```

#### Nội dung phụ — 12 câu hỏi phỏng vấn Load Balancing

##### 1. Load balancing giải quyết vấn đề gì?

> Nó phân phối traffic qua nhiều backend để tránh phụ thuộc vào capacity và availability của một server. Nhờ đó hệ thống có thể scale-out, sử dụng tài nguyên hiệu quả hơn và giới hạn tác động khi một instance gặp lỗi.

##### 2. Vì sao single server cuối cùng trở thành bottleneck?

> Mọi máy đều có tài nguyên hữu hạn. Khi workload tăng, CPU, memory, I/O, bandwidth hoặc connection đạt saturation; queue dài lên, latency tăng và request bắt đầu timeout. Một máy mạnh hơn chỉ nâng giới hạn chứ không loại bỏ giới hạn và single point of failure.

##### 3. Vertical scaling và horizontal scaling khác nhau thế nào?

> Vertical scaling tăng tài nguyên cho một máy; horizontal scaling thêm nhiều máy và chia workload. Scale up đơn giản hơn nhưng có trần và vẫn tập trung rủi ro. Scale out có đường tăng trưởng dài hơn và hỗ trợ redundancy, nhưng làm state, coordination, networking và operations phức tạp hơn.

##### 4. Vì sao horizontal scaling thường được ưu tiên?

> Nó cho phép bổ sung capacity theo từng đơn vị, phân tán failure domain và thay thế instance linh hoạt. Tuy nhiên, “thường được ưu tiên” không có nghĩa luôn tốt hơn: workload khó phân chia, database đặc thù hoặc hệ thống nhỏ có thể phù hợp với vertical scaling hơn.

##### 5. Thách thức nào xuất hiện khi ứng dụng chạy trên nhiều server?

> Hệ thống phải chọn server cho từng request, phát hiện server lỗi, tránh phân phối lệch và quản lý state dùng chung. Client không nên biết topology động; load balancer và service discovery giải quyết phần định tuyến, còn application vẫn phải xử lý session, concurrency và shared data.

##### 6. Load balancer đóng vai trò gì trong distributed system?

> Nó cung cấp entry point ổn định trước backend pool, chọn backend theo health và policy, đồng thời che giấu topology nội bộ. Nó biến nhiều server thành một logical service đối với client, nhưng lớp load balancer cũng phải có high availability.

##### 7. Load balancing cải thiện scalability ra sao?

> Khi traffic tăng, thêm backend vào pool và load balancer đưa traffic tới capacity mới mà không đổi endpoint client. Dù vậy, tổng scalability vẫn bị giới hạn bởi database, cache, queue, network và những dependency dùng chung.

##### 8. Load balancing cải thiện availability ra sao?

> Request mới có thể được chuyển khỏi instance lỗi sang instance khỏe. Điều này giảm phụ thuộc vào một server và hỗ trợ maintenance không downtime. Availability chỉ thực sự tăng nếu load balancer có redundancy, backend phân tán failure domain và capacity dự phòng đủ lớn.

##### 9. Điều gì xảy ra khi một server trong pool bị lỗi?

> Health check phát hiện lỗi sau một khoảng thời gian, load balancer loại server khỏi rotation và gửi traffic mới tới backend khác. Request đang chạy có thể vẫn thất bại; retry chỉ nên áp dụng khi an toàn. Khi server phục hồi và vượt qua readiness threshold, nó có thể được đưa lại vào pool.

##### 10. Vì sao load balancing là thành phần nền tảng?

> Khi hệ thống vượt quá một instance, nó cần cơ chế điều phối traffic. Load balancing cung cấp nền tảng cho horizontal scaling, health-based routing, rolling deployment, redundancy và fault isolation — những thuộc tính phổ biến của cloud-native và distributed architecture.

##### 11. Khi nào nên đưa load balancer vào?

> Khi cần nhiều instance, uptime cao, rolling deployment, autoscaling hoặc stable endpoint. Không nhất thiết đợi performance suy giảm; availability requirement có thể là lý do đưa load balancer vào sớm hơn.

##### 12. Mô tả quá trình từ single server tới kiến trúc có load balancer

> Ứng dụng thường bắt đầu trên một server. Khi tải tăng, đội ngũ có thể scale up để kéo dài tuổi thọ kiến trúc. Khi giới hạn capacity hoặc availability không còn đáp ứng, họ thêm nhiều instance. Điều này tạo bài toán phân phối traffic, nên một load-balancer layer có redundancy được đặt phía trước để cung cấp endpoint ổn định, health check và routing tới backend pool.

#### Câu hỏi tư duy mở rộng

1. Nếu load balancer chỉ có một instance, kiến trúc đã high availability chưa?
2. Health check nên kiểm tra sâu tới database hay chỉ kiểm tra application process?
3. Backend còn lại cần bao nhiêu headroom để chịu được một node hoặc zone bị mất?
4. Khi nào retry ở load balancer gây duplicate write?
5. Session affinity ảnh hưởng scale và failover thế nào?
6. Làm sao drain server đang có WebSocket connection lâu dài?
7. Nếu request có chi phí rất khác nhau, round robin còn phù hợp không?
8. Autoscaler và load balancer cần phối hợp lifecycle của instance ra sao?
9. Khi database là bottleneck, thêm application server có tác dụng gì?
10. Load balancer nên fail open hay fail closed khi policy service không phản hồi?

#### Ý chính cần nhớ

- Single server vừa có capacity limit vừa là single point of failure.
- Vertical scaling đơn giản và hữu ích nhưng có trần và không tự tạo redundancy.
- Horizontal scaling tăng capacity nhưng phát sinh coordination, state và routing complexity.
- Load balancer cung cấp stable interface trước dynamic backend pool.
- Load balancing hỗ trợ scalability, deployment và fault isolation.
- Health check phải phân biệt liveness với readiness và luôn có detection delay.
- Server lỗi không có nghĩa mọi request đều tự động thành công; in-flight request vẫn có thể mất.
- Load balancer cần redundancy, capacity và phân tán failure domain.
- Backend còn lại phải đủ headroom để gánh tải sau sự cố.
- Load balancer không sửa được application state hoặc downstream bottleneck.
- Mục tiêu là phân phối tải phù hợp, không nhất thiết chia đều số request.
- Load balancer có thể được đưa vào vì availability và deployability trước cả khi gặp bottleneck.

#### Công thức ghi nhớ

> **Horizontal scaling tạo thêm capacity; load balancing biến capacity phân tán đó thành một dịch vụ thống nhất, có thể định tuyến quanh lỗi.**

---

### Bài 13. API Gateway là gì?

#### Bài toán khi số lượng API và Service tăng

Khi hệ thống còn nhỏ, client có thể gọi trực tiếp một vài backend. Nhưng khi số client và service tăng, mô hình này nhanh chóng trở nên khó kiểm soát:

```text
Web Client ─┬→ Auth Service
            ├→ Product Service
            ├→ Order Service
            └→ Payment Service

Mobile App ─┬→ Auth Service
            ├→ Product Service
            ├→ Order Service
            └→ Payment Service
```

Mỗi client phải biết:

- Service nằm ở đâu.
- Endpoint và protocol của từng service.
- Cách authentication cho từng API.
- Chính sách retry, timeout và rate limit.
- Phiên bản và contract của nhiều service.
- Cách ghép nhiều response thành một màn hình.

Hệ quả là client bị coupling với topology nội bộ; policy bị triển khai lặp lại; backend bị lộ trực tiếp; thay đổi service có thể lan tới nhiều client.

#### API Gateway là gì?

**API Gateway** là một entry layer ở phía trước backend API. Nó nhận API traffic từ consumer, áp dụng policy dùng chung và định tuyến request tới service thích hợp.

```text
Web / Mobile / Partner / IoT Clients
                 ↓
             API Gateway
       ┌─────────┼─────────┐
       ↓         ↓         ↓
  Auth API   Product API  Order API
```

Đối với client, gateway là “cửa trước” của API ecosystem. Client tương tác với một interface ổn định trong khi gateway che giấu service location và internal topology.

API Gateway thường là một **reverse proxy chuyên cho API**, bổ sung các chức năng quản trị và policy ở Layer 7.

#### API Gateway hoạt động như thế nào?

Luồng tổng quát:

```text
1. Client gửi API request
2. Gateway terminate hoặc passthrough TLS theo thiết kế
3. Xác thực credential/token
4. Áp dụng authorization policy ở mức phù hợp
5. Kiểm tra quota và rate limit
6. Chọn route và upstream service
7. Có thể transform, cache hoặc aggregate
8. Forward request tới backend
9. Nhận và chuẩn hóa response
10. Ghi metrics/log/trace rồi trả client
```

Không phải mọi request đều cần toàn bộ bước trên. Mỗi route nên chỉ bật policy cần thiết để tránh latency và độ phức tạp không cần thiết.

#### Cross-Cutting Concerns

Gateway có giá trị vì tập trung các concern xuất hiện trên nhiều API:

| Concern | Vai trò của gateway |
|---|---|
| **Routing** | Chọn service, version hoặc upstream dựa trên host, path, header hay method |
| **Authentication** | Xác minh credential hoặc token trước khi request vào backend |
| **Coarse-grained authorization** | Kiểm tra scope, role hoặc policy chung ở lớp biên |
| **Rate limiting và quota** | Giới hạn mức sử dụng theo consumer, tenant, token, route hoặc plan |
| **Request/response transformation** | Thay đổi header, path, payload hoặc protocol khi cần |
| **Caching** | Trả response cacheable mà không gọi backend |
| **API composition** | Gọi nhiều service và hợp nhất response cho một use case cụ thể |
| **Observability** | Ghi metrics, access log, correlation ID và trace context |
| **Traffic management** | Canary, version routing, traffic splitting và timeout policy |
| **Security enforcement** | TLS, request size limit, schema validation và WAF integration |

Backend nhờ đó tập trung hơn vào business logic. Tuy nhiên, không nên biến gateway thành nơi chứa toàn bộ business logic, vì điều đó tạo một “smart gateway” khó phát triển và trở thành bottleneck tổ chức.

#### Lợi ích kiến trúc

##### 1. Đơn giản hóa client

Client không cần biết từng service instance hoặc internal protocol. Gateway cung cấp contract phù hợp cho consumer và che giấu sự thay đổi phía sau.

##### 2. Giảm public attack surface

Thay vì công khai hàng chục service, hệ thống chỉ công khai một số entry point được harden. Origin service có thể nằm trong private network và chỉ nhận traffic từ gateway tin cậy.

##### 3. Policy nhất quán

Authentication, quota, logging và header policy được áp dụng tại một lớp chung, giảm nguy cơ mỗi team triển khai khác nhau.

##### 4. Bảo vệ backend khỏi overload

Rate limit, request size limit, timeout và admission control giúp chặn một phần tải trước khi nó lan vào service.

##### 5. Giảm network round-trip cho client

Gateway có thể aggregate một số API call liên quan để client nhận một response phù hợp với màn hình hoặc use case.

##### 6. Điểm quan sát tập trung

Vì API traffic đi qua gateway, đây là nơi tốt để đo request rate, latency, error rate, status code, consumer usage và dấu hiệu abuse.

#### API Gateway, Reverse Proxy và Load Balancer

Ba khái niệm có vùng chức năng chồng lấp:

| Thành phần | Trọng tâm chính | Thường hiểu request ở mức nào? | Capability điển hình |
|---|---|---|---|
| **Load Balancer** | Phân phối traffic giữa nhiều backend | Layer 4 hoặc Layer 7 | Health check, load distribution, failover |
| **Reverse Proxy** | Đại diện backend và kiểm soát inbound traffic | Thường Layer 7, cũng có thể Layer 4 | Routing, TLS, caching, filtering |
| **API Gateway** | Quản trị và bảo vệ API ecosystem | Layer 7 và API-aware | Auth, quota, rate limit, transformation, composition, analytics, lifecycle policy |

Điểm cần nhớ:

- API Gateway thường thực hiện chức năng reverse proxy.
- API Gateway có thể load balance giữa các service instance, hoặc gọi một load balancer/service discovery phía sau.
- Load balancer Layer 7 cũng có thể route theo path và terminate TLS.
- Tên sản phẩm không quyết định vai trò; capability và vị trí trong kiến trúc mới quan trọng.

```text
Internet
   ↓
Global / Edge Load Balancer
   ↓
API Gateway Instances
   ↓
Internal Load Balancer / Service Discovery
   ↓
Service Instances
```

Không phải hệ thống nào cũng cần đủ mọi lớp này. Cần tránh xếp nhiều hop chỉ vì mỗi sản phẩm mang một nhãn khác nhau.

#### Authentication và Authorization

Gateway có thể xác minh identity trước khi request tới backend:

```text
Client → Credential/Token → API Gateway
                               ├── invalid → reject
                               └── valid   → add verified context → Backend
```

Các cơ chế thường gặp:

| Cơ chế | Dùng cho | Lưu ý |
|---|---|---|
| **API key** | Nhận diện application/consumer và áp quota | Không nên mặc định coi là danh tính người dùng; phải bảo vệ như secret nếu có quyền truy cập |
| **OAuth 2.0 access token** | Ủy quyền truy cập tài nguyên theo scope | OAuth 2.0 là authorization framework, không tự định nghĩa login người dùng |
| **OpenID Connect** | Authentication xây trên OAuth 2.0 | Cung cấp identity layer và ID token |
| **JWT** | Một định dạng token chứa claim có chữ ký | JWT không phải giao thức auth; cần kiểm tra signature, issuer, audience, expiry và algorithm |
| **mTLS** | Xác thực hai endpoint bằng certificate và mã hóa transport | Thường dùng cho machine/client identity, không tự biểu diễn quyền nghiệp vụ |
| **SAML / enterprise IdP** | Federation và SSO trong hệ thống doanh nghiệp | Gateway thường tích hợp với IdP thay vì tự thay thế identity system |

Gateway nên áp dụng **defense in depth**:

- Gateway kiểm tra token validity, scope chung và policy ở lớp biên.
- Backend vẫn kiểm tra authorization gắn với resource và business rule.

Ví dụ, gateway có thể xác minh token có scope `orders:read`, nhưng Order Service mới biết user có quyền đọc **đơn hàng cụ thể này** hay không.

Không nên tin header identity do client tự gửi. Gateway phải xóa hoặc ghi đè header nhạy cảm rồi truyền verified identity context tới backend qua kênh tin cậy.

#### Rate Limiting, Quota và Throttling

Các cơ chế này bảo vệ backend và thực thi chính sách sử dụng.

- **Rate limit:** giới hạn số request trong một khoảng thời gian hoặc tốc độ trung bình.
- **Quota:** giới hạn tổng mức sử dụng trong chu kỳ dài hơn, chẳng hạn mỗi ngày hoặc mỗi tháng.
- **Burst allowance:** cho phép spike ngắn trong giới hạn.
- **Throttling:** thuật ngữ có thể chỉ việc làm chậm, xếp hàng hoặc từ chối traffic vượt policy; nghĩa cụ thể phụ thuộc implementation.

Các dimension để đặt limit:

- User hoặc account.
- API key hoặc OAuth client.
- Tenant.
- IP hoặc network — nhưng IP có thể bị chia sẻ qua NAT.
- Route hoặc operation.
- Cost unit thay vì chỉ đếm request.

Thuật toán phổ biến:

| Thuật toán | Ý tưởng | Trade-off |
|---|---|---|
| **Fixed window** | Đếm request trong cửa sổ cố định | Đơn giản nhưng có burst ở ranh giới cửa sổ |
| **Sliding window** | Ước lượng hoặc đếm trên cửa sổ trượt | Công bằng hơn nhưng tốn state/compute hơn |
| **Token bucket** | Token được bổ sung theo tốc độ; request tiêu thụ token | Hỗ trợ burst có kiểm soát |
| **Leaky bucket** | Làm phẳng output theo tốc độ định trước | Hạn chế spike nhưng có thể tạo queue hoặc reject |

Trong gateway phân tán, rate-limit state cần được phối hợp. Nếu mỗi instance giữ counter riêng, tổng limit có thể bị nhân lên. Counter dùng chung tăng tính chính xác nhưng thêm latency và dependency. Có thể chấp nhận approximate limit tùy mục tiêu.

Khi từ chối vì rate limit, API thường trả status phù hợp và hướng dẫn retry nếu contract cho phép. Retry thiếu backoff có thể khiến overload nặng hơn.

#### Caching tại API Gateway

Gateway có thể cache response để giảm latency và backend load:

```text
Client → Gateway
            ├── cache hit  → response
            └── cache miss → Backend → cache → response
```

Các quyết định quan trọng:

- Route nào được cache?
- Cache key gồm path, query, header, locale, tenant hay identity nào?
- TTL bao lâu?
- Response riêng tư có được cache không?
- Invalidation hoặc purge ra sao?
- Có chấp nhận stale data khi backend lỗi không?
- Làm sao tránh cache stampede?

Các lớp có thể dùng:

- Local in-process cache trong gateway instance.
- Distributed cache bên ngoài như Redis/Memcached.
- Response cache tích hợp trong gateway.
- CDN/edge cache ở trước gateway.

Redis hoặc Memcached là distributed cache, không mặc nhiên là “in-memory cache bên trong gateway”.

GET thường dễ cache hơn vì có semantics đọc, nhưng HTTP caching không nên được quyết định chỉ bằng method. Cần dựa vào cache directive, tính riêng tư, side effect và contract; không nên mặc định cache POST response dù một số trường hợp kỹ thuật có thể hỗ trợ.

#### Request Transformation và Protocol Translation

Gateway có thể:

- Đổi path hoặc hostname.
- Thêm, xóa hoặc chuẩn hóa header.
- Chuyển payload shape.
- Chuyển JSON ↔ XML khi thực sự cần.
- Bridge REST/HTTP tới gRPC hoặc protocol nội bộ.
- Chuẩn hóa error response.

Transformation giúp client và service tiến hóa độc lập, nhưng cũng có rủi ro:

- Tăng latency và CPU.
- Che giấu contract mismatch quá lâu.
- Khó debug vì payload bị thay đổi giữa đường.
- Logic transformation phức tạp làm gateway khó maintain.

Nên giữ transformation rõ ràng, versioned, testable và tránh biến gateway thành nơi chứa domain logic.

#### API Composition và Aggregation

Gateway có thể gọi nhiều service rồi ghép response:

```text
Mobile Client → /home
                   ↓
               API Gateway
          ┌────────┼────────┐
          ↓        ↓        ↓
       Profile  Orders  Recommendations
          └────────┼────────┘
                   ↓
          Consolidated Response
```

Lợi ích:

- Giảm round-trip từ mobile hoặc mạng có latency cao.
- Che giấu internal service topology.
- Tạo response phù hợp với một client/use case.

Trade-off:

- Fan-out làm latency phụ thuộc nhiều downstream.
- Một dependency chậm có thể kéo chậm toàn response.
- Cần timeout, partial response và error semantics.
- Gateway dễ tích lũy business logic.

Khi composition khác nhau nhiều theo client, có thể dùng pattern **Backend for Frontend — BFF**, tạo gateway/aggregation layer riêng cho web, mobile hoặc partner thay vì một gateway khổng lồ cho mọi nhu cầu.

#### Observability

Gateway là điểm tốt để thu thập:

- Request rate và response status.
- Latency toàn phần và upstream latency.
- Rate-limit decision.
- Authentication failure.
- Route/version usage.
- Payload size và connection count.
- Trace/correlation ID.
- Backend error và timeout.

Nhưng cần tránh:

- Log access token, password, API key hoặc PII.
- High-cardinality label làm metrics quá đắt.
- Chỉ nhìn gateway latency mà bỏ qua downstream breakdown.
- Synchronous logging chặn request path.

Gateway nên truyền trace context tới backend để theo dõi toàn bộ request chain.

#### API Gateway và DDoS

Gateway có thể bảo vệ application-level traffic bằng:

- Rate limiting và quota.
- Request size/connection limit.
- WAF và bot-management integration.
- Authentication sớm để loại request không hợp lệ.
- Caching để giảm request tới backend.
- IP/network policy khi phù hợp.

Nhưng gateway đơn lẻ không chống được volumetric DDoS nếu network link đã bị bão hòa trước khi traffic tới gateway. Kiến trúc thường cần CDN/edge network, anycast, upstream DDoS protection và origin lockdown.

TLS bảo vệ confidentiality và integrity trên đường truyền khi được cấu hình đúng; TLS termination tự nó không phải cơ chế chặn DDoS và vẫn tiêu tốn tài nguyên handshake.

CAPTCHA phù hợp với một số luồng có người dùng tương tác, không phù hợp với machine-to-machine API nói chung.

#### Khi nào nên dùng API Gateway?

API Gateway có giá trị khi:

- Có nhiều backend service và client cần unified entry point.
- Web, mobile, partner và IoT có yêu cầu khác nhau.
- Cần policy auth, rate limit, quota và logging nhất quán.
- Cần che giấu internal topology và giảm public exposure.
- Cần API version routing, transformation hoặc composition.
- Cần governance và analytics ở quy mô nền tảng.

Không nhất thiết dùng khi:

- Monolith đơn giản chỉ có vài API.
- Low-traffic internal service có trust boundary rõ ràng.
- Reverse proxy/load balancer hiện tại đã đáp ứng đủ yêu cầu.
- Chi phí vận hành gateway lớn hơn complexity mà nó loại bỏ.

Nguyên lý:

> **Dùng gateway khi nó làm giảm complexity của toàn hệ thống, không phải khi nó chỉ chuyển complexity sang một component mới.**

#### Self-Managed và Managed Gateway

| Mô hình | Lợi ích | Trade-off |
|---|---|---|
| **Self-managed** | Kiểm soát cấu hình, runtime, extension và deployment | Tự chịu trách nhiệm scale, patch, security, upgrade và on-call |
| **Managed service** | Giảm operational overhead, tích hợp cloud và autoscaling tiện hơn | Chi phí, quota, giới hạn tùy biến và vendor dependency |

API Gateway là architectural pattern, không phải một sản phẩm cụ thể. Việc lựa chọn phải dựa trên protocol, scale, policy, extension model, latency, operations và cost.

#### Control Plane và Data Plane

Ở quy mô lớn, nên tách:

- **Control plane:** quản lý route, policy, certificate, consumer, deployment và configuration.
- **Data plane:** xử lý request thực tế trên hot path.

```text
Operators / CI/CD → Control Plane → phân phối config
                                      ↓
Clients → Data Plane Gateway Instances → Services
```

Data plane nên tiếp tục phục vụ với cấu hình gần nhất nếu control plane tạm thời lỗi. Configuration rollout cần versioning, validation, canary và rollback để tránh một thay đổi sai làm hỏng toàn bộ API traffic.

#### Thiết kế API Gateway quy mô lớn

```text
Users
  ↓
DNS / Global Routing
  ↓
CDN / DDoS Protection / WAF
  ↓
Regional Load Balancer
  ↓
Stateless API Gateway Fleet
  ├──→ Auth / Policy Dependencies
  ├──→ Distributed Rate-Limit State
  ├──→ Cache
  └──→ Backend Services
```

Checklist:

1. Nhiều stateless gateway instance qua nhiều zone.
2. Autoscaling theo request rate, latency, CPU và connection.
3. Capacity/headroom cho peak và failover.
4. Timeout, retry budget, circuit breaker và load shedding.
5. Không retry unsafe write nếu thiếu idempotency.
6. Auth key/token verification không phụ thuộc synchronous call cho mọi request nếu có thể cache an toàn.
7. Distributed rate limiting với mức consistency phù hợp.
8. Config rollout có validation, canary và rollback.
9. Multi-region nếu availability và latency yêu cầu.
10. Observability theo route, consumer và upstream nhưng bảo vệ dữ liệu nhạy cảm.
11. Bảo vệ origin để client không bypass gateway.
12. Kiểm thử gateway overload, dependency failure và control-plane outage.

#### Failure Mode và Trade-off

| Rủi ro | Hệ quả | Giảm thiểu |
|---|---|---|
| Gateway là SPOF | Toàn bộ API không truy cập được | Nhiều instance, multi-zone, load balancing, failover |
| Gateway quá tải | Latency và error tăng cho mọi service | Scale-out, headroom, load shedding, tối ưu policy hot path |
| Auth dependency lỗi | Request hợp lệ có thể bị chặn hoặc treo | Local verification/cache, timeout, policy fail-open/fail-closed rõ ràng |
| Config sai | Phạm vi ảnh hưởng rất lớn | Schema validation, staged rollout, canary, rollback |
| Transformation phức tạp | Khó debug và tăng latency | Giới hạn logic, contract test, versioning |
| Aggregation fan-out | Một dependency chậm kéo theo toàn response | Parallel call, timeout budget, partial response, bulkhead |
| Distributed rate-limit store lỗi | Limit sai hoặc request path bị chặn | Chọn degraded behavior, local fallback hoặc approximate limit |
| Central logging quá nặng | Tăng latency, rò rỉ dữ liệu | Async logging, sampling, redaction |

#### Nội dung phụ — 10 câu hỏi phỏng vấn API Gateway

##### 1. API Gateway là gì và tại sao sử dụng?

> API Gateway là Layer 7 entry point trước backend API. Nó định tuyến request và áp dụng cross-cutting policy như authentication, rate limit, quota, transformation, caching và observability. Mục tiêu là đơn giản hóa client, giảm public exposure và thực thi policy nhất quán; trade-off là thêm latency và critical infrastructure.

##### 2. API Gateway khác Load Balancer như thế nào?

> Load balancer tập trung phân phối traffic và health-based failover ở Layer 4 hoặc Layer 7. API Gateway hiểu API contract và consumer hơn, nên thường xử lý auth, quota, versioning, transformation và composition. Hai vai trò có thể nằm trong cùng sản phẩm hoặc thành các lớp riêng.

##### 3. Lợi ích chính của API Gateway?

- Unified API entry point.
- Authentication và coarse-grained authorization.
- Rate limiting, quota và overload protection.
- Routing, transformation và version management.
- Caching và aggregation khi phù hợp.
- Logging, metrics, tracing và analytics.
- Che giấu service topology và giảm attack surface.

##### 4. Gateway xử lý authentication và authorization ra sao?

> Gateway xác minh credential hoặc token, chẳng hạn OAuth access token hay mTLS identity, rồi truyền verified identity context tới backend. Nó có thể kiểm tra scope/role chung, nhưng backend vẫn phải kiểm tra quyền ở mức resource và business rule. OAuth 2.0 là authorization framework; OIDC mới bổ sung identity layer; JWT chỉ là token format.

##### 5. Rate limiting và throttling là gì?

> Rate limiting kiểm soát tốc độ hoặc số request theo identity, tenant, key, route hay cost. Token bucket hỗ trợ burst; sliding window giảm burst ở ranh giới. “Throttling” có thể là reject, delay hoặc shaping tùy hệ thống. Trong gateway phân tán cần cân bằng độ chính xác của counter với latency và availability.

##### 6. Các chiến lược cache tại gateway?

> Có thể cache local, dùng distributed cache, response cache theo route hoặc kết hợp CDN. Phải thiết kế cache key, TTL, privacy, invalidation và stampede protection. Không cache chỉ vì request là GET; cần hiểu semantics và header. Nội dung theo user phải được tách key hoặc không cache dùng chung.

##### 7. Gateway hỗ trợ chống DDoS như thế nào?

> Gateway có thể rate limit, xác thực sớm, lọc request, giới hạn payload và tích hợp WAF/bot control. Nhưng volumetric DDoS cần edge capacity, anycast/upstream protection và không cho bypass origin. Gateway application-level không thể xử lý traffic chưa bao giờ tới được nó do link bị bão hòa.

##### 8. Khi nào dùng API Gateway trong microservices?

> Khi client cần unified entry point trước nhiều service, hoặc platform cần auth, quota, governance, versioning và observability nhất quán. Không nên thêm chỉ vì hệ thống gọi là microservices; nếu direct/internal communication đơn giản hơn và policy ít, gateway có thể chưa mang lại đủ giá trị.

##### 9. Thiết kế API Gateway cho hàng triệu user?

> Triển khai stateless gateway fleet qua nhiều zone/region, đặt sau global routing và edge protection, autoscale, giữ headroom, dùng distributed rate limiting/cache phù hợp, bảo vệ auth dependency, version cấu hình, quan sát theo route/upstream và kiểm thử degraded mode. Control plane lỗi không nên lập tức làm data plane ngừng phục vụ.

##### 10. Các thách thức khi triển khai API Gateway?

> Gateway có thể thành SPOF, bottleneck, nguồn latency và nơi tích lũy policy/business logic. Route/version management và config rollout có blast radius lớn. Giảm thiểu bằng HA, scale-out, cấu hình khai báo có version, canary/rollback, giới hạn transformation/composition và ownership rõ ràng.

#### Câu hỏi tư duy mở rộng

1. Policy nào nên nằm ở gateway và policy nào phải nằm trong service?
2. Nếu auth provider lỗi, gateway nên fail open hay fail closed?
3. Làm sao global rate limit hoạt động khi gateway chạy nhiều region?
4. Cache key nào ngăn response của user A bị trả cho user B?
5. Khi aggregation gọi năm service, timeout budget nên phân bổ thế nào?
6. Gateway có nên retry POST request không?
7. Client có thể bypass gateway để gọi service trực tiếp không?
8. Làm sao rollout route/config mới mà không làm gián đoạn toàn hệ thống?
9. Khi nào nên tách BFF cho mobile và web?
10. Nếu gateway thêm 20 ms cho mọi request, lợi ích policy có đáng không?

#### Ý chính cần nhớ

- API Gateway là reverse proxy chuyên cho API và là front door của API ecosystem.
- Nó che giấu internal topology và cung cấp interface ổn định cho client.
- Gateway tập trung routing, auth, rate limit, caching, transformation và observability.
- API Gateway, reverse proxy và load balancer có capability chồng lấp.
- OAuth 2.0, OIDC và JWT không phải cùng một khái niệm.
- Gateway chỉ nên xử lý authorization chung; service vẫn bảo vệ resource và business rule.
- Distributed rate limiting tạo trade-off giữa accuracy, latency và availability.
- Caching cần cache key, TTL và privacy policy chính xác.
- Aggregation giảm round-trip nhưng tăng fan-out và failure coupling.
- Gateway không tự chống được volumetric DDoS nếu thiếu edge protection.
- Gateway là critical infrastructure nên phải HA, scalable và có cấu hình rollback được.
- Không phải mọi hệ thống đều cần API Gateway; chỉ thêm khi nó giảm complexity tổng thể.

#### Công thức ghi nhớ

> **API Gateway là cửa trước có hiểu API: nó che giấu backend, thực thi policy chung và định tuyến consumer tới đúng service — nhưng không nên trở thành nơi chứa toàn bộ business logic.**

---

### Bài 14. CDN — Content Delivery Network

#### CDN giải quyết vấn đề gì?

Khi người dùng ở xa origin server, mỗi request phải đi qua nhiều network và khoảng cách địa lý lớn. Dù origin xử lý rất nhanh, propagation delay và network path vẫn làm latency tăng.

```text
User ở xa ───────── nhiều network hop ─────────→ Origin
```

Khi traffic tăng, ba vấn đề chính xuất hiện:

1. **Distance creates latency:** khoảng cách và network path làm response chậm.
2. **Origin becomes a bottleneck:** mọi request tập trung vào backend hoặc một region.
3. **Bandwidth and cost increase:** static asset và media bị truyền lặp lại từ origin.

**CDN — Content Delivery Network** giải quyết bằng cách triển khai một mạng edge phân tán toàn cầu, đưa content và một số xử lý tới gần user hơn.

```text
Users → Nearby / Optimal Edge → Origin chỉ khi cần
```

CDN không chỉ là performance optimization. Ở quy mô lớn, nó còn là lớp hấp thụ traffic, tăng resilience, tối ưu nội dung và bảo vệ origin.

#### Kiến trúc CDN

Ba thành phần nền tảng:

| Thành phần | Vai trò |
|---|---|
| **Origin** | Nguồn dữ liệu hoặc hệ thống tạo nội dung gốc |
| **Edge server** | Server gần user hơn, phục vụ cache và xử lý edge |
| **Request routing system** | Chọn PoP/edge phù hợp dựa trên network, health, capacity và policy |

```text
                         ┌→ Edge / PoP A ─┐
Users → Request Routing ─┼→ Edge / PoP B ─┼→ Origin / Origin Shield
                         └→ Edge / PoP C ─┘
```

##### Origin Server

Origin là nguồn gốc của nội dung hoặc response. Nó có thể là:

- Object storage chứa ảnh, video và static asset.
- Web server hoặc application server.
- API Gateway hoặc backend API.
- Một cụm multi-region thay vì một máy duy nhất.

CDN không thay thế hoàn toàn origin. Khi cache miss, revalidation hoặc nội dung không cacheable, edge vẫn cần gọi origin/upstream.

##### Edge Server

Edge server nằm trong PoP gần user về mặt network. Nó có thể:

- Cache và phục vụ content.
- Terminate TLS.
- Nén hoặc chuyển đổi asset.
- Áp dụng WAF, bot filtering và rate limit.
- Chạy edge function nhẹ.
- Duy trì connection tối ưu tới origin.

##### PoP — Point of Presence

PoP là địa điểm CDN có hạ tầng edge. Một PoP thường chứa nhiều server và network connection.

Nhiều PoP hơn không tự động bảo đảm nhanh hơn. Chất lượng còn phụ thuộc:

- Vị trí và độ gần network thực tế.
- Peering với ISP.
- Capacity của PoP.
- Cache hit ratio.
- Routing quality.
- Health và congestion.

#### Request Routing

Khi user gọi một hostname dùng CDN, routing layer chọn edge phù hợp. “Gần nhất” thường có nghĩa **tốt nhất theo network và policy**, không đơn thuần là khoảng cách địa lý.

Các tín hiệu có thể gồm:

- Geography.
- Measured/estimated latency.
- BGP topology và peering.
- PoP health.
- Current load và capacity.
- Content/service availability.
- Business hoặc compliance policy.

Hai cơ chế thường được kết hợp:

- **DNS-based steering:** DNS trả endpoint hoặc hostname phù hợp.
- **Anycast:** nhiều PoP quảng bá cùng IP và network routing đưa connection tới một PoP phù hợp.

Routing không hoàn hảo. Route có thể thay đổi, ISP topology khác geography và PoP “gần” có thể đang quá tải.

#### Luồng request: Cache Hit và Cache Miss

```text
Client → CDN Edge
           ├── Cache Hit  → trả content từ edge
           └── Cache Miss → gọi origin/shield
                                ↓
                         nhận response
                                ↓
                         cache nếu được phép
                                ↓
                         trả content cho client
```

**Cache hit:** object phù hợp đã có trong cache và còn usable theo policy. Edge trả ngay mà không gọi origin.

**Cache miss:** object chưa có, đã bị evict hoặc không cacheable. Edge gọi upstream; response chỉ được lưu nếu cache policy cho phép.

Không phải mọi miss đều nhất thiết đi thẳng tới origin. CDN có thể có nhiều tầng cache hoặc **origin shield** để gom miss từ nhiều edge.

#### Các trạng thái cache quan trọng

| Trạng thái | Ý nghĩa |
|---|---|
| **Fresh hit** | Object có trong cache và còn fresh |
| **Miss** | Không có object phù hợp |
| **Stale** | Object có nhưng vượt freshness lifetime |
| **Revalidated** | Edge hỏi origin và xác nhận object cũ vẫn hợp lệ |
| **Expired fetch** | Object hết hạn và cần lấy phiên bản mới |
| **Bypass** | Policy yêu cầu không dùng cache cho request này |

Khi object stale, edge có thể gửi conditional request với validator như ETag hoặc thời gian sửa đổi. Nếu origin xác nhận chưa thay đổi, edge tiếp tục dùng object cũ mà không tải lại toàn bộ body.

#### TTL và Freshness

TTL/freshness lifetime quyết định object có thể được dùng từ cache trong bao lâu trước khi cần kiểm tra lại.

| TTL | Lợi ích | Trade-off |
|---|---|---|
| **Dài** | Hit ratio cao, origin offload lớn, latency thấp | Thay đổi nhìn thấy chậm hơn nếu không version/purge |
| **Ngắn** | Nội dung mới được kiểm tra thường xuyên hơn | Nhiều revalidation/miss, tăng origin load |

**Hiệu chỉnh quan trọng:** TTL hết hạn thường chỉ đánh dấu object là stale. CDN không nhất thiết tự tải phiên bản mới ngay thời điểm TTL chạm 0; request tiếp theo có thể kích hoạt revalidation hoặc fetch tùy policy.

Freshness có thể đến từ:

- `Cache-Control`.
- `Expires`.
- CDN configuration override.
- Route/content-type policy.

Không nên đặt TTL chỉ dựa trên mong muốn “nhanh”. Cần xét mức chấp nhận stale data, tần suất thay đổi và khả năng purge/versioning.

#### Cache Key

CDN cần biết hai request có thể dùng chung response hay không. Quyết định này nằm trong **cache key**.

Cache key thường có thể gồm:

- Scheme/host.
- Path.
- Query parameter được chọn.
- Một số header theo `Vary` hoặc policy.
- Device/format/language variant.
- Tenant hoặc identity trong trường hợp cache riêng tư được thiết kế cẩn thận.

Cache key quá hẹp có thể trả nhầm dữ liệu giữa user. Cache key quá rộng làm cache fragmentation và giảm hit ratio.

Rủi ro nghiêm trọng:

- Cache response có cookie/auth nhưng không tách user.
- Bỏ qua query parameter ảnh hưởng nội dung.
- Tin header do client tự điều khiển để tạo cache poisoning.
- Cache error response quá lâu.

#### Cache Invalidation

Cache invalidation cần thiết khi content thay đổi trước TTL hoặc không thể chấp nhận stale copy.

| Chiến lược | Cách hoạt động | Trade-off |
|---|---|---|
| **Purge/Invalidate** | Yêu cầu CDN xóa hoặc đánh dấu stale object | Có propagation delay, API/cost/rate limit tùy provider |
| **Versioned URL** | Đổi URL khi nội dung đổi, thường dùng content hash | Rất an toàn cho immutable asset nhưng cần build/deploy discipline |
| **Short TTL** | Cho object hết fresh sớm | Tăng origin/revalidation load |
| **Stale-while-revalidate** | Tạm trả stale trong khi refresh nền | Latency tốt nhưng user có thể thấy dữ liệu cũ ngắn hạn |
| **Stale-if-error** | Trả stale khi origin lỗi | Tăng resilience nhưng phải chấp nhận stale data |

Với static asset versioned:

```text
app.a1b2c3.js  → Cache-Control: long-lived, immutable
Deploy mới     → app.d4e5f6.js
HTML mới trỏ tới URL mới
```

Cách này tránh phải purge asset cũ và cho phép TTL rất dài.

#### Origin Shield và Request Coalescing

Khi một object phổ biến hết hạn ở nhiều PoP, hàng nghìn miss có thể cùng dồn về origin — **thundering herd/cache stampede**.

```text
Many Edge PoPs → Origin Shield → Origin
```

Origin shield tạo tầng cache trung gian, giúp:

- Tăng hit ratio tổng thể.
- Gom miss từ nhiều PoP.
- Giảm connection và request tới origin.
- Bảo vệ origin trong traffic spike.

**Request coalescing/collapsing** cho phép nhiều request đồng thời chờ một upstream fetch thay vì mỗi request tự gọi origin.

#### CDN cải thiện Performance

CDN giảm latency và thời gian tải nhờ:

- Phục vụ content từ edge gần hơn về network.
- Giảm round-trip tới origin xa.
- Tái sử dụng connection và tối ưu route tới origin.
- TLS termination gần user.
- HTTP/2 hoặc HTTP/3 tùy nền tảng.
- Compression với Gzip/Brotli khi client hỗ trợ.
- Image resize/format conversion như WebP hoặc AVIF.
- Range request và streaming optimization.

Minification CSS/JavaScript thường nên được thực hiện trong build pipeline để predictable và testable. Một số CDN có thể hỗ trợ transform/minify, nhưng đây không phải capability mặc định của mọi CDN.

Compression cần `Vary`/cache variant phù hợp để không trả encoding client không hỗ trợ.

#### CDN cải thiện Scalability và Cost

Hai metric quan trọng:

- **Cache hit ratio:** tỷ lệ request được phục vụ từ cache.
- **Byte hit ratio:** tỷ lệ byte được phục vụ từ cache.

Byte hit ratio đặc biệt quan trọng với media lớn. Một số request nhỏ có thể nhiều nhưng một vài video miss mới chiếm phần lớn bandwidth origin.

CDN giúp:

- Giảm request per second tới origin.
- Giảm origin egress bandwidth.
- Hấp thụ flash crowd.
- Phân phối tải qua global edge fleet.

Nhưng cost có thể tăng nếu:

- Egress CDN lớn.
- Purge hoặc edge compute đắt.
- Hit ratio thấp do cache key fragmentation.
- Dynamic content không cacheable.
- Multi-CDN làm cache bị phân mảnh.

#### Static Content, Dynamic Content và API

##### Static Content

Phù hợp nhất với CDN:

- Images, CSS, JavaScript, fonts.
- Video/audio segments.
- Software packages và downloads.
- Static HTML.

Nên dùng versioned immutable URL cho asset có thể fingerprint.

##### Dynamic Content

Ngay cả khi response không cache được, CDN vẫn có thể:

- Chọn optimized network path.
- Giữ warm/persistent connection tới origin.
- Terminate TLS gần user.
- Áp dụng security policy ở edge.
- Cache phần public hoặc common nếu contract cho phép.

##### API Response

API đọc phổ biến có thể cache theo TTL ngắn hoặc validator. Cần đặc biệt chú ý:

- Authorization và dữ liệu theo user.
- Query/header ảnh hưởng response.
- Invalidation khi write xảy ra.
- Error caching.
- Consistency requirement.

Không cache API response chỉ vì nó là `GET`; phải hiểu semantics và privacy.

#### Edge Computing

CDN hiện đại có thể chạy logic gần user:

- Redirect và rewrite.
- Request validation.
- A/B routing.
- Authentication check nhẹ.
- Personalization giới hạn.
- Header/cookie transformation.
- Image/media transformation.

Lợi ích:

- Giảm latency.
- Chặn request sớm.
- Offload origin.

Trade-off:

- Runtime/resource bị giới hạn.
- Debug distributed edge khó hơn.
- Deploy/config sai có blast radius toàn cầu.
- Data locality và consistency phức tạp.
- Vendor-specific API tạo lock-in.

Không nên chuyển domain logic cần transactional state mạnh ra edge chỉ vì muốn giảm latency.

#### Reliability và PoP Failure

Khi một PoP lỗi hoặc quá tải, routing layer có thể chuyển user sang PoP khác.

```text
User → PoP A ✗
       reroute
User → PoP B ✓
```

Nhưng failover không bảo đảm tuyệt đối “không gián đoạn”:

- Connection đang hoạt động có thể bị rơi.
- DNS/BGP/routing cần thời gian hội tụ.
- PoP kế tiếp có thể xa hơn và latency tăng.
- Cache ở PoP mới có thể lạnh, làm origin load tăng.
- Nếu origin cũng lỗi, cache miss vẫn thất bại.

Cached stale content có thể giúp phục vụ khi origin lỗi nếu policy cho phép. Cần thiết kế capacity và failover path, không chỉ giả định CDN tự xử lý mọi sự cố.

#### Security

CDN là lớp đầu tiên user thường gặp, nên có thể cung cấp:

- DDoS absorption và anycast distribution.
- WAF và bot filtering.
- Rate limiting.
- TLS termination tại edge.
- Signed URL hoặc signed cookie cho private content.
- Origin IP hiding.
- Geo/IP/network policy.

Để bảo vệ origin thực sự:

- Origin firewall chỉ cho phép traffic từ CDN hoặc authenticated origin connection.
- Không để lộ alternate hostname/IP bypass CDN.
- Dùng TLS từ edge tới origin; cân nhắc mTLS.
- Rotate secret/certificate.
- Kiểm tra header do CDN thêm và xóa header giả từ client.

CDN không tự giải quyết mọi security problem. Application vẫn cần authentication, authorization, validation và secure coding.

#### TLS tại Edge

```text
Client ══ TLS ══> CDN Edge ══ TLS/mTLS ══> Origin
```

Edge thường terminate TLS để cache, filter và transform HTTP. Nên mã hóa lại tới origin, đặc biệt khi traffic đi qua network không được tin cậy.

Lợi ích:

- Handshake gần user hơn.
- Certificate management tập trung.
- Edge có thể hiểu HTTP để cache và security filtering.

Trade-off:

- CDN trở thành trusted intermediary có thể thấy plaintext.
- Certificate/private key và configuration cần được bảo vệ.
- Edge-to-origin security phải được thiết kế riêng.

#### Multi-CDN

Multi-CDN dùng nhiều nhà cung cấp CDN để tăng redundancy, coverage hoặc leverage về cost/performance.

```text
Users → Traffic Steering
          ├──→ CDN A → Origin
          └──→ CDN B → Origin
```

Lợi ích:

- Giảm phụ thuộc một provider.
- Tối ưu theo geography/ISP.
- Có lựa chọn failover.
- Đàm phán capacity và cost linh hoạt hơn.

Trade-off:

- Cấu hình cache/security phải nhất quán.
- Certificate, purge và log phân tán.
- Cache fragmentation làm giảm hit ratio.
- Traffic steering và health detection phức tạp.
- Failover có thể làm origin spike vì CDN dự phòng có cold cache.
- Khó debug hơn vì cùng request có thể đi qua provider khác nhau.

Multi-CDN chỉ tăng resilience nếu failover được kiểm thử và các dependency như DNS, origin, certificate, configuration không còn là điểm lỗi chung.

#### Video Streaming qua CDN

Video thường được chia thành nhiều segment với nhiều bitrate/quality.

```text
Video Source
   ↓ encode/transcode
Manifest + Segments ở nhiều bitrate
   ↓ origin/object storage
CDN Edge Cache
   ↓
Player chọn segment phù hợp theo bandwidth/buffer
```

Các yếu tố thiết kế:

- **Adaptive bitrate streaming:** player chuyển bitrate theo bandwidth và buffer.
- **Segmented delivery:** video chia thành segment nhỏ để cache và tải dần.
- **Range request:** hỗ trợ seek hoặc tải một phần object.
- **Origin shield:** bảo vệ origin khi segment mới trở nên phổ biến.
- **Cache policy:** segment immutable có thể TTL dài; manifest live cần TTL ngắn hơn.
- **Prefetch/preposition:** làm nóng content dự kiến hot nếu kinh tế và workload phù hợp.
- **Signed URL/cookie:** giới hạn quyền xem private/premium content.
- **Multi-CDN steering:** phân phối viewer hoặc failover provider.

Các segment thường được cache on-demand tại PoP có user yêu cầu; không cần cố định “mỗi chunk chỉ nằm ở một PoP”. Một segment hot có thể tồn tại tại nhiều edge.

#### Nội dung phụ — 16 câu hỏi phỏng vấn CDN

##### 1. CDN là gì và hoạt động thế nào?

> CDN là mạng edge phân tán đứng trước origin. Request được route tới PoP phù hợp; edge trả object nếu cache hit, hoặc lấy từ upstream khi miss rồi cache nếu policy cho phép. Mục tiêu là giảm latency, origin load và tăng resilience/security.

##### 2. Vì sao cần CDN trong System Design?

> Vì distance tạo latency, origin có capacity hữu hạn và việc truyền lặp asset làm tăng bandwidth/cost. CDN đưa content gần user hơn, hấp thụ traffic spike và tạo lớp bảo vệ trước origin.

##### 3. Lợi ích chính của CDN?

- Giảm latency.
- Giảm request và byte từ origin.
- Tăng khả năng chịu flash crowd.
- Hỗ trợ failover/rerouting.
- Edge security và TLS.
- Content optimization và edge compute.

##### 4. Origin và edge server khác nhau thế nào?

> Origin là nguồn tạo hoặc lưu nội dung gốc; edge là bản sao/cache và processing layer gần user. Edge giảm nhu cầu gọi origin nhưng vẫn phụ thuộc origin cho miss, revalidation và dynamic request.

##### 5. PoP là gì?

> PoP là địa điểm CDN chứa edge capacity và network connectivity. Số lượng PoP chỉ là một yếu tố; peering, routing, load, health và cache hit ratio mới quyết định chất lượng thực tế.

##### 6. Request routing trong CDN hoạt động ra sao?

> DNS steering và/hoặc anycast đưa user tới PoP dựa trên topology, latency, health, capacity và policy. “Gần” nên hiểu theo network performance, không chỉ geography.

##### 7. Cache hit và cache miss là gì?

> Hit xảy ra khi edge có object phù hợp và usable; miss khi không có hoặc policy bypass. Với miss, edge gọi shield/origin và chỉ cache response nếu cache rule cho phép. Cần theo dõi cả hit ratio và byte hit ratio.

##### 8. TTL và cache expiration hoạt động thế nào?

> TTL xác định freshness lifetime. Khi hết TTL, object thành stale; request sau có thể revalidate hoặc fetch lại. TTL dài tăng offload nhưng tăng thời gian stale nếu không version/purge; TTL ngắn tăng origin load.

##### 9. Các chiến lược invalidation?

> Purge cho thay đổi khẩn cấp, versioned URL/content hash cho immutable asset, TTL ngắn cho nội dung biến động, stale-while-revalidate để refresh nền và stale-if-error để tăng resilience. Versioning thường là lựa chọn tốt nhất cho static build artifact.

##### 10. CDN dùng load balancing để tăng reliability ra sao?

> Routing layer phân phối user qua nhiều PoP theo latency, health và capacity. Bên trong PoP, traffic tiếp tục được cân bằng qua nhiều edge server. Cần capacity dự phòng và origin protection để failover không gây overload dây chuyền.

##### 11. Điều gì xảy ra nếu PoP lỗi?

> Traffic mới có thể được route sang PoP khác, nhưng connection hiện tại có thể rơi, latency tăng và cold cache làm origin chịu spike. Failover cần được kiểm thử; không nên hứa “không gián đoạn” tuyệt đối.

##### 12. CDN dùng compression/minification nào?

> Edge có thể dùng Gzip/Brotli, image resize và chuyển WebP/AVIF theo client capability. Minification CSS/JS thường phù hợp hơn ở build pipeline, dù một số CDN hỗ trợ. Cache variant phải phân biệt encoding/format đúng cách.

##### 13. CDN bảo vệ DDoS như thế nào?

> Anycast và global capacity phân tán traffic; filtering, WAF, rate limit và bot control loại request độc hại. Origin phải bị khóa để attacker không bypass CDN. Khả năng chống DDoS phụ thuộc capacity và upstream network, không chỉ một rule rate-limit.

##### 14. TLS offloading tại CDN là gì?

> CDN terminate TLS ở edge, giảm handshake latency và cho phép cache/filter HTTP. Nên re-encrypt tới origin và xác thực origin. “Offload” không có nghĩa có thể bỏ qua bảo mật chặng edge–origin.

##### 15. Multi-CDN hoạt động ra sao?

> Traffic-steering layer chọn giữa nhiều provider dựa trên health, performance, geography hoặc cost. Nó tăng redundancy nhưng làm cache, config, purge, certificate, log và incident response phức tạp hơn. Cold-cache failover có thể đẩy tải lớn về origin.

##### 16. Thiết kế CDN cho video streaming quy mô lớn?

> Encode video thành nhiều bitrate và segment, đặt manifest/segment ở origin storage, cache on-demand tại edge, dùng ABR ở player, origin shield, range request, long TTL cho immutable segment và short TTL cho live manifest. Thêm signed access, capacity planning, QoE monitoring và multi-CDN nếu yêu cầu.

#### Câu hỏi tư duy mở rộng

1. Cache key nào ngăn dữ liệu cá nhân bị chia sẻ giữa user?
2. Nếu một asset thay đổi, nên purge hay đổi versioned URL?
3. Khi CDN dự phòng cold cache, origin có chịu được failover không?
4. Nội dung nào được phép stale-if-error và trong bao lâu?
5. Làm sao origin chỉ chấp nhận traffic hợp lệ từ CDN?
6. TTL nào phù hợp cho live manifest so với immutable video segment?
7. Cache hit ratio cao nhưng byte hit ratio thấp cho thấy điều gì?
8. Edge function nên fail open hay fail closed khi dependency lỗi?
9. CDN có thể cache response API theo user an toàn bằng cách nào?
10. Làm sao phát hiện một PoP đang route user tới đường mạng kém?

#### Ý chính cần nhớ

- CDN đưa content và một số xử lý tới edge gần user hơn về network.
- Origin là source; edge giảm số lần phải gọi origin chứ không thay thế hoàn toàn.
- Request routing dựa trên topology, latency, health và capacity, không chỉ geography.
- Cache hit giảm latency và origin load; cache miss có thể đi qua origin shield.
- TTL hết hạn làm object stale; fetch/revalidation thường xảy ra khi có request tiếp theo.
- Cache key sai có thể gây rò rỉ dữ liệu hoặc giảm hit ratio.
- Versioned URL phù hợp cho immutable static asset.
- Origin shield và request collapsing giúp tránh cache stampede.
- Dynamic content vẫn hưởng lợi từ network acceleration và edge security.
- PoP failover có thể làm rơi connection, tăng latency và tạo cold-cache spike.
- CDN bảo vệ DDoS tốt khi có global capacity và origin không thể bị bypass.
- TLS tại edge cần đi kèm bảo vệ chặng edge–origin.
- Multi-CDN tăng redundancy nhưng thêm complexity và cache fragmentation.
- Video segment được cache theo nhu cầu tại nhiều edge, kết hợp adaptive bitrate.

#### Công thức ghi nhớ

> **CDN đưa content tới gần user, giữ traffic xa origin và dùng edge làm lớp tăng tốc, hấp thụ tải, tối ưu và bảo vệ hệ thống toàn cầu.**

---

### Tổng kết Phần 2 — Networking & Communication

#### Bức tranh toàn cảnh

Các chủ đề trong phần Networking & Communication không tồn tại độc lập. Chúng tạo thành nền tảng giúp các thành phần của hệ thống phân tán tìm thấy nhau, trao đổi dữ liệu và tiếp tục hoạt động khi quy mô hoặc sự cố tăng lên.

Phần này phát triển theo một chuỗi logic:

```text
Networking fundamentals
        ↓
IP Addressing — máy và endpoint được định vị thế nào?
        ↓
DNS — tên dịch vụ được ánh xạ tới đâu?
        ↓
Client–Server — hai phía tương tác theo mô hình nào?
        ↓
Proxy — traffic được kiểm soát và trung gian hóa ra sao?
        ↓
Load Balancer — nhiều backend cùng phục vụ thế nào?
        ↓
API Gateway — API traffic và policy được quản trị ra sao?
        ↓
CDN — content được đưa tới gần user và bảo vệ ở edge thế nào?
```

Mỗi lớp giải quyết một vấn đề do lớp trước hoặc sự tăng trưởng của hệ thống tạo ra.

#### Một request thực tế đi qua các lớp như thế nào?

Ví dụ user mở ứng dụng và gọi một API:

```text
User / Client
     ↓ nhập domain
DNS Resolution
     ↓ tìm global endpoint
CDN / Edge / DDoS Protection
     ├── cache hit → trả content ngay
     └── dynamic request
              ↓
       Reverse Proxy / Load Balancer
              ↓ chọn gateway instance khỏe
          API Gateway
              ├── authentication
              ├── rate limiting
              ├── routing
              └── observability
                    ↓
             Backend Service
                    ├──→ Cache
                    ├──→ Database
                    └──→ Downstream Service
```

Trong cùng một request path:

- IP cung cấp nền tảng định địa chỉ.
- DNS cung cấp service discovery ở cấp Internet.
- CDN chọn edge và có thể trả cached content.
- Reverse proxy hoặc load balancer chọn backend khỏe.
- API Gateway áp dụng API policy và định tuyến tới service.
- Client–server communication diễn ra ở từng interaction.
- Private network và proxy boundary hạn chế việc backend bị truy cập trực tiếp.

#### Mỗi thành phần giải quyết vấn đề gì?

| Thành phần | Câu hỏi kiến trúc chính | Thuộc tính được tác động |
|---|---|---|
| **IP Addressing** | Endpoint được định danh và định tuyến như thế nào? | Reachability, isolation, scalability |
| **DNS** | Client tìm endpoint ổn định từ domain ra sao? | Discoverability, global routing, failover |
| **Client–Server Model** | Bên nào yêu cầu, bên nào xử lý và state nằm ở đâu? | Coupling, scalability, interaction model |
| **Forward Proxy** | Outbound traffic của client được kiểm soát thế nào? | Egress security, access control, privacy |
| **Reverse Proxy** | Inbound traffic và backend exposure được quản lý ra sao? | Security, routing, caching, TLS |
| **Load Balancer** | Traffic được phân phối qua nhiều backend thế nào? | Horizontal scaling, availability, fault isolation |
| **API Gateway** | API policy và service routing được tập trung ở đâu? | Governance, auth, rate limiting, observability |
| **CDN** | Content và protection được đưa tới edge ra sao? | Latency, origin offload, global resilience, security |

#### Những mối liên hệ quan trọng

##### DNS và CDN

DNS có thể hướng user tới CDN hoặc global endpoint. CDN tiếp tục chọn edge và phục vụ cache. Nếu DNS sai hoặc không hoạt động, CDN khỏe vẫn có thể không được user tìm thấy.

##### CDN và Origin

CDN giảm request và byte tới origin, nhưng cache miss, revalidation và dynamic request vẫn phụ thuộc upstream. Origin phải chịu được miss spike và không được để attacker bypass CDN.

##### Reverse Proxy, Load Balancer và API Gateway

Ba vai trò có capability chồng lấp:

- Reverse proxy đại diện backend và kiểm soát inbound traffic.
- Load balancer tập trung phân phối traffic qua backend pool.
- API Gateway chuyên quản trị API contract, consumer và policy Layer 7.

Có thể dùng chung một sản phẩm hoặc nhiều lớp, nhưng mỗi hop bổ sung latency và operational complexity. Không nên xếp lớp chỉ vì tên gọi khác nhau.

##### Load Balancer và Stateless Server

Load balancer dễ phân phối request khi application server không giữ session state cục bộ. Nếu state gắn với instance, cần affinity, shared state hoặc cơ chế phục hồi phức tạp hơn.

##### Proxy/Gateway và Security

Lớp trung gian giúp tập trung TLS, authentication, rate limit và filtering. Tuy nhiên, backend vẫn cần authorization và validation của riêng nó. Security boundary chỉ có ý nghĩa nếu client không thể đi vòng và gọi origin/service trực tiếp.

##### Caching ở nhiều lớp

Một request có thể gặp cache tại:

```text
Browser → DNS Resolver → CDN → Reverse Proxy → API Gateway → Application → Database
```

Mỗi cache giảm latency hoặc tải nhưng thêm trade-off về freshness, invalidation và consistency. Cần xác định rõ cache nào sở hữu policy gì, tránh cache dữ liệu riêng tư sai cách.

#### Các thuộc tính chất lượng đều phụ thuộc networking

| Thuộc tính | Những quyết định networking ảnh hưởng trực tiếp |
|---|---|
| **Scalability** | Load distribution, horizontal scaling, cache, connection management |
| **Performance** | Network latency, hop count, payload size, protocol, edge location |
| **Reliability** | Timeout, retry, health check, failover, redundancy |
| **Availability** | DNS/CDN/LB/gateway HA, failure domain, capacity dự phòng |
| **Security** | TLS, private network, proxy boundary, auth, filtering, origin lockdown |
| **Cost** | Bandwidth, egress, cache hit ratio, proxy/gateway/CDN capacity |
| **Operability** | Logging, metrics, tracing, config rollout và incident response |

Kiến trúc tốt không tối ưu một thuộc tính riêng lẻ. Ví dụ, thêm nhiều proxy layer có thể tăng security control nhưng cũng tăng latency và số failure point.

#### Nguyên tắc thiết kế cần ghi nhớ

**1. Network không đáng tin tuyệt đối**

Luôn giả định latency thay đổi, connection bị ngắt, packet có thể mất và timeout không cho biết chắc remote side đã xử lý hay chưa.

**2. Interface ổn định, infrastructure động**

Client nên gọi domain hoặc logical service endpoint; DNS, load balancer và service discovery che giấu IP/instance thay đổi.

**3. Mọi lớp trung gian vừa là control point vừa là failure point**

Proxy, gateway và CDN tập trung policy nhưng cần HA, capacity, monitoring và rollback.

**4. Retry phải có giới hạn và hiểu semantics**

Retry thiếu backoff/jitter có thể tạo retry storm. Retry thao tác ghi thiếu idempotency có thể tạo duplicate.

**5. Health check không đồng nghĩa backend hoàn toàn khỏe**

Cần phân biệt liveness và readiness; check quá sâu có thể tạo failure cascade, check quá nông có thể bỏ sót lỗi.

**6. Caching luôn là trade-off**

Cache tăng tốc nhưng đặt ra freshness, cache key, invalidation, privacy và stampede.

**7. Security cần defense in depth**

Edge/gateway lọc sớm; service vẫn xác thực context, kiểm tra authorization, validate input và bảo vệ dữ liệu.

**8. Thiết kế cho failure, không chỉ happy path**

Hỏi điều gì xảy ra khi DNS provider, PoP, load balancer, gateway, backend, region hoặc shared dependency bị lỗi.

#### Checklist phân tích request path

Khi thiết kế một hệ thống, hãy lần theo request từ user tới dữ liệu và quay lại:

1. User tìm hệ thống bằng domain nào?
2. DNS trả endpoint nào và TTL/failover được thiết kế ra sao?
3. Traffic đi qua edge/CDN hay trực tiếp tới region?
4. Thành phần nào terminate TLS?
5. Ai chịu trách nhiệm DDoS protection và origin có bị bypass được không?
6. Load balancer chọn backend theo health và policy nào?
7. Authentication, authorization và rate limiting nằm ở đâu?
8. Request đi qua bao nhiêu network hop?
9. Timeout budget được chia cho từng downstream call thế nào?
10. Lớp nào có thể retry và thao tác có idempotent không?
11. Response được cache ở đâu, theo cache key và TTL nào?
12. Khi một component lỗi, traffic được reroute hay degraded ra sao?
13. Capacity còn lại có đủ sau khi mất một node, zone hoặc region không?
14. Có metrics, log và trace để tìm chặng gây latency/lỗi không?

#### Những lỗi tư duy phổ biến

- Cho rằng thêm server là đủ mà không cần traffic distribution.
- Cho rằng private IP tự nó bảo đảm security.
- Xem NAT như firewall hoặc authentication layer.
- Coi DNS failover là tức thời và không bị ảnh hưởng bởi cache.
- Cho rằng load balancer tự làm application horizontally scalable.
- Tin rằng gateway có thể thay thế authorization trong service.
- Xếp nhiều proxy/gateway/load-balancer layer mà không có trách nhiệm rõ ràng.
- Cache theo method hoặc URL mà không xét identity và `Vary` dimension.
- Cho rằng CDN luôn phục vụ từ PoP gần nhất về geography.
- Cho rằng PoP failover hoặc retry bảo đảm mọi request thành công.
- Bảo vệ CDN/gateway nhưng để lộ origin có thể truy cập trực tiếp.

#### Nội dung sẽ học tiếp theo

Phần tiếp theo đi sâu hơn vào các protocol và communication pattern tạo nên những interaction trên:

- **TCP và UDP:** reliability, ordering, connection và latency trade-off.
- **HTTP và REST:** request–response, semantics, caching và API design.
- **WebSocket:** persistent bidirectional communication.
- **gRPC:** contract-first RPC và efficient service communication.
- **GraphQL:** client-driven query và API aggregation trade-off.

Câu hỏi trọng tâm không chỉ là “protocol hoạt động thế nào?”, mà còn là:

> **Khi nào nên chọn protocol này, phải chấp nhận trade-off nào và lựa chọn đó ảnh hưởng scalability, reliability, latency, observability ra sao?**

#### Ý chính cần nhớ

- Networking là nền tảng liên kết toàn bộ distributed system.
- IP giúp định địa chỉ; DNS giúp tìm service bằng tên ổn định.
- Client–server định hình vai trò và interaction.
- Proxy kiểm soát luồng traffic ở phía client hoặc server.
- Load balancer biến nhiều backend thành một logical service.
- API Gateway quản lý API consumer, route và policy Layer 7.
- CDN đưa content và security control tới edge.
- Các thành phần này cùng xuất hiện trên một request path và tác động lẫn nhau.
- Performance, scalability, reliability, availability và security đều phụ thuộc networking decision.
- Mỗi abstraction layer giảm complexity cho phía sử dụng nhưng tạo thêm dependency cần vận hành.
- Thiết kế phải xem xét cả happy path, degraded mode và recovery path.

#### Công thức ghi nhớ

> **IP xác định địa chỉ, DNS tìm điểm đến, proxy kiểm soát đường đi, load balancer chọn backend, API Gateway quản lý API và CDN đưa nội dung tới edge — tất cả phối hợp để một request được phục vụ nhanh, an toàn và bền bỉ.**

---

## Phần 3 — Protocols

### Bài 16. Bắt đầu với Protocol

#### Vì sao lựa chọn Protocol quan trọng?

Communication là nền tảng của mọi distributed system. Các thành phần chỉ phối hợp được khi thống nhất về cách thiết lập kết nối, biểu diễn dữ liệu, truyền message, xử lý lỗi và kết thúc tương tác.

**Protocol** định nghĩa những quy tắc đó. Lựa chọn protocol tác động trực tiếp tới:

- **Performance:** overhead, latency, throughput và kích thước payload.
- **Scalability:** số connection, resource per connection và khả năng multiplex.
- **Reliability:** delivery, ordering, retry và failure semantics.
- **User experience:** thời gian phản hồi, real-time responsiveness và chất lượng khi mạng kém.
- **Operability:** debugging, observability, compatibility và tooling.
- **Security:** encryption, authentication và bề mặt tấn công.

Vì vậy, “các service giao tiếp như thế nào?” thường là một trong những quyết định quan trọng nhất của System Design.

#### Bản đồ nội dung Phần 3

Phần này đi từ transport layer lên các application protocol và API style:

```text
Transport Layer
TCP ↔ UDP
reliability, ordering, overhead, latency
        ↓
Web Communication
HTTP và REST
request–response, semantics, caching
        ↓
Real-Time Communication
WebSocket
persistent bidirectional messaging
        ↓
Service-to-Service Communication
gRPC
contract, RPC, streaming, efficiency
        ↓
Client-Driven API
GraphQL
query flexibility, aggregation, complexity
        ↓
Architectural Decision
Chọn protocol theo requirement và trade-off
```

Mục tiêu không phải ghi nhớ protocol nào “nhanh nhất” hay “hiện đại nhất”. Cần hiểu:

1. Protocol cung cấp guarantee gì?
2. Nó không cung cấp guarantee gì?
3. Chi phí của guarantee đó là gì?
4. Workload và user experience cần điều gì?
5. Failure sẽ biểu hiện như thế nào?
6. Hạ tầng, client và network có hỗ trợ không?

#### Công thức ghi nhớ

> **Không chọn protocol theo độ phổ biến; hãy chọn theo communication pattern, guarantee cần thiết và trade-off mà hệ thống chấp nhận.**

---

### Bài 17. TCP và UDP

#### Transport Layer giải quyết điều gì?

IP giúp packet tìm đường giữa các máy, nhưng application còn cần cơ chế giao tiếp giữa các process thông qua **port**. TCP và UDP là hai transport protocol cốt lõi cung cấp hai mô hình khác nhau trên nền IP.

```text
Application: HTTP, DNS, game, voice, database...
                         ↓
Transport:          TCP hoặc UDP
                         ↓
Network:                 IP
```

Mạng vốn không ổn định tuyệt đối:

- Packet có thể mất.
- Packet có thể đến trễ.
- Packet có thể đến sai thứ tự.
- Packet có thể bị lặp.
- Route có thể thay đổi.
- Bandwidth và congestion thay đổi theo thời gian.

TCP che giấu phần lớn sự bất định này bằng một reliable ordered byte stream. UDP cung cấp datagram delivery tối giản và để application quyết định cần bổ sung cơ chế nào.

#### TCP — Transmission Control Protocol

TCP là transport protocol **connection-oriented**, cung cấp một luồng byte hai chiều có thứ tự và đáng tin cậy giữa hai endpoint.

```text
Application A ⇄ Reliable Ordered Byte Stream ⇄ Application B
```

TCP phù hợp khi dữ liệu cần đầy đủ và đúng thứ tự trước khi application xử lý tiếp.

#### Three-Way Handshake

Trước khi truyền application data, TCP thiết lập connection:

```text
Client                         Server
  | ------ SYN --------------> |
  | <----- SYN + ACK ---------- |
  | ------ ACK ---------------> |
  |       Connection ready      |
```

Mục đích ở mức khái niệm:

- Hai phía xác nhận có thể giao tiếp.
- Đồng bộ sequence number ban đầu.
- Thiết lập state cần thiết cho connection.

Handshake tạo thêm ít nhất một network round-trip trước khi application data được trao đổi theo cách thông thường. TLS handshake là một lớp riêng và có thể tạo thêm bước, dù protocol hiện đại có nhiều cơ chế giảm round-trip hoặc tái sử dụng connection.

#### TCP tạo Reliability như thế nào?

##### 1. Sequence Number và Ordering

TCP đánh số byte/segment để receiver sắp xếp dữ liệu đúng thứ tự trước khi đưa lên application.

```text
Gửi:   1, 2, 3, 4
Đến:   1, 3, 2, 4
TCP:   sắp lại → 1, 2, 3, 4
```

##### 2. Acknowledgement

Receiver gửi ACK để báo đã nhận dữ liệu tới một vị trí. Sender dùng ACK để biết phần nào đã đến.

##### 3. Retransmission

Nếu dữ liệu không được ACK trong điều kiện phù hợp hoặc TCP suy ra loss, sender truyền lại.

##### 4. Duplicate Handling

Sequence number giúp TCP nhận diện dữ liệu bị lặp và tránh đưa duplicate byte lên application stream.

##### 5. Error Detection

Checksum giúp phát hiện một số corruption trong quá trình truyền; segment không hợp lệ bị loại và dữ liệu có thể được truyền lại.

##### 6. Flow Control

Receiver thông báo khả năng nhận để sender không gửi nhanh hơn buffer phía nhận có thể xử lý.

##### 7. Congestion Control

TCP điều chỉnh tốc độ dựa trên tín hiệu congestion/loss để tránh làm mạng quá tải và chia sẻ capacity hợp lý hơn.

```text
Reliability của TCP
= sequence + ACK + retransmission + ordering
+ flow control + congestion control
```

#### TCP cung cấp và không cung cấp điều gì?

TCP cung cấp:

- Ordered byte stream.
- Retransmission khi phát hiện loss.
- Duplicate suppression ở transport stream.
- Flow control và congestion control.
- Full-duplex communication.

TCP không cung cấp:

- Message boundary: application phải tự framing message.
- Application-level exactly-once processing.
- Transaction semantics.
- Guarantee remote business operation chưa chạy khi client timeout.
- Guarantee connection không bao giờ lỗi.
- Tự động mã hóa; cần TLS hoặc lớp bảo mật khác.

Ví dụ, client gửi payment request qua TCP rồi connection mất trước khi nhận response. TCP không thể nói payment đã được application xử lý hay chưa. API vẫn cần idempotency key và transaction design.

#### Chi phí và hạn chế của TCP

- Connection setup.
- State và buffer cho mỗi connection.
- ACK và retransmission overhead.
- Ordering có thể làm dữ liệu phía sau chờ phần bị mất.
- Congestion control có thể giảm sending rate.
- Connection recovery và timeout cần được quản lý.

**Head-of-line blocking ở TCP:** nếu một đoạn byte bị mất, byte đến sau không được giao lên application theo thứ tự cho đến khi phần thiếu được phục hồi, dù những byte sau đã tới network stack.

Điều này bảo vệ ordering nhưng có thể làm tăng latency cho real-time data đã nhanh chóng mất giá trị.

#### Use Case phù hợp với TCP

- Web/API qua HTTP/1.1 và HTTP/2.
- File transfer.
- Email protocol.
- Database connection.
- SSH và remote administration.
- Payment hoặc business transaction.
- Workload cần complete ordered stream.

TCP thường được chọn khi loss hoặc sai thứ tự làm dữ liệu không thể sử dụng hoặc gây hậu quả nghiệp vụ.

#### UDP — User Datagram Protocol

UDP là transport protocol **connectionless** với overhead nhỏ. Application gửi từng **datagram** độc lập mà không cần transport handshake.

```text
Sender ---- Datagram 1 ----> Receiver
Sender ---- Datagram 2 ----> Receiver
Sender ---- Datagram 3 ----> Receiver

Không có ACK/retransmission/ordering mặc định từ UDP
```

UDP giữ ranh giới datagram: mỗi lần gửi tạo một message/datagram ở transport layer, khác với byte stream liên tục của TCP.

“Connectionless” mô tả protocol. Một số socket API vẫn cho phép `connect` UDP socket để cố định peer và đơn giản hóa API, nhưng điều đó không tạo TCP-style handshake hay delivery guarantee.

#### UDP ưu tiên điều gì?

UDP loại bỏ phần lớn cơ chế mà TCP cung cấp:

- Không handshake ở transport layer.
- Không ACK mặc định.
- Không retransmission mặc định.
- Không đảm bảo ordering.
- Không loại duplicate theo delivery semantics của application.
- Không cung cấp congestion control chung như TCP.

Lợi ích:

- Ít protocol overhead.
- Có thể gửi ngay mà không đợi connection setup.
- Application tự chọn recovery phù hợp.
- Hỗ trợ communication pattern như multicast trong môi trường phù hợp.
- Phù hợp dữ liệu ngắn hạn, tần suất cao hoặc loss-tolerant.

Trade-off:

- Datagram có thể mất, lặp hoặc sai thứ tự.
- Application phải tự xây reliability nếu cần.
- Message quá lớn có nguy cơ fragmentation và loss cao hơn.
- NAT/firewall có thể quản lý UDP state khác TCP.
- Nếu application gửi không kiểm soát, nó có thể gây congestion hoặc unfairness.

UDP “nhẹ” không có nghĩa application xây trên UDP luôn nhanh hơn. Nếu application tự bổ sung ACK, retransmission, encryption và congestion control, tổng độ phức tạp có thể lớn. Lợi ích là nó có thể thiết kế các guarantee phù hợp hơn với workload.

#### Use Case phù hợp với UDP

- Voice/video real-time qua RTP/WebRTC trong nhiều kiến trúc.
- Online game state update.
- DNS query thông thường.
- Telemetry hoặc metric chấp nhận mất một phần.
- Market data multicast trong network được kiểm soát.
- Discovery protocol.
- QUIC/HTTP/3 làm nền transport ở user space trên UDP.

**Nuance quan trọng:**

- Video streaming theo yêu cầu phổ biến thường dùng HTTP qua TCP hoặc QUIC, không phải lúc nào cũng dùng raw UDP.
- DNS thường dùng UDP cho query nhỏ nhưng có thể dùng TCP hoặc transport khác khi response lớn, bị truncated hoặc trong một số hoạt động.
- QUIC chạy trên UDP nhưng tự cung cấp reliability, encryption, congestion control và multiplexing ở lớp phía trên. Vì vậy, “dùng UDP” không đồng nghĩa “không đáng tin cậy” nếu application protocol bổ sung guarantee.

#### Tại sao Real-Time Workload thường thích UDP?

Không phải mọi dữ liệu đều giữ nguyên giá trị theo thời gian.

```text
Payment instruction 2 giây trước → vẫn phải xử lý chính xác
Voice packet 2 giây trước        → thường đã quá muộn để phát lại
Player position 2 giây trước     → có thể đã lỗi thời
```

Với voice/game/live interaction, retransmit dữ liệu cũ có thể gây delay lớn hơn lợi ích nhận đủ. Application có thể:

- Bỏ packet quá muộn.
- Interpolate game state.
- Che giấu loss bằng audio concealment.
- Dùng forward error correction.
- Chỉ retransmit loại message quan trọng.
- Tách reliable control message và unreliable real-time update.

Đây là lý do cốt lõi để chọn UDP: không phải “UDP luôn nhanh”, mà là application được quyền quyết định dữ liệu nào còn giá trị và reliability nào đáng trả chi phí.

#### So sánh TCP và UDP

| Tiêu chí | TCP | UDP |
|---|---|---|
| Mô hình | Connection-oriented byte stream | Connectionless datagram |
| Setup | Three-way handshake | Không có transport handshake |
| Delivery | Reliable trong phạm vi connection theo transport semantics | Best-effort, không guarantee |
| Ordering | Có | Không |
| Retransmission | Có | Không mặc định |
| ACK | Có | Không mặc định |
| Message boundary | Không giữ | Giữ datagram boundary |
| Flow control | Có | Application tự xử lý nếu cần |
| Congestion control | Có | Application/protocol phía trên tự xử lý nếu cần |
| Overhead | Cao hơn | Thấp hơn |
| Multicast/broadcast | Không phải mô hình TCP | UDP có thể hỗ trợ trong network phù hợp |
| Phù hợp | Dữ liệu phải đầy đủ, đúng thứ tự | Dữ liệu time-sensitive hoặc workload cần custom guarantee |

#### Reliability và Latency không phải hai lựa chọn tuyệt đối

Không nên hiểu đơn giản:

```text
TCP = chậm nhưng đúng
UDP = nhanh nhưng mất dữ liệu
```

Thực tế:

- TCP connection được tái sử dụng có thể rất hiệu quả.
- Loss thấp thì retransmission không phải lúc nào cũng xảy ra.
- UDP application thiếu congestion control có thể hoạt động tệ trên Internet.
- QUIC trên UDP cung cấp reliable streams và giảm một số head-of-line interaction giữa stream.
- Protocol có thể dùng UDP cho real-time data và một reliable channel cho control message.
- End-to-end latency còn phụ thuộc application, serialization, network path và server load.

Kiến trúc sư chọn **communication semantics**, không chỉ chọn tên transport.

#### Cách chọn TCP hay UDP

Đặt các câu hỏi:

1. Mất một message có chấp nhận được không?
2. Dữ liệu cũ còn giá trị sau bao lâu?
3. Có cần đúng thứ tự không?
4. Có cần message boundary không?
5. Có cần multicast không?
6. Application có khả năng tự xây reliability/congestion control không?
7. Network, firewall và NAT có hỗ trợ ổn định không?
8. Cần interoperability với browser/proxy hiện có không?
9. Connection setup latency có đáng kể với workload không?
10. Security/encryption sẽ được cung cấp ở lớp nào?

Decision guide đơn giản:

```text
Mất dữ liệu gây sai nghiệp vụ?
  ├── Có → TCP hoặc reliable protocol/stream
  └── Không hoàn toàn
        ↓
Dữ liệu mất giá trị rất nhanh và latency cực quan trọng?
  ├── Có → cân nhắc UDP/custom protocol
  └── Không → TCP thường đơn giản và an toàn hơn
```

#### Failure Semantics và Retry

##### Với TCP

Connection error cho biết kênh bị lỗi, nhưng không nhất thiết cho biết remote application đã xử lý request chưa. Retry thao tác không idempotent có thể tạo duplicate.

##### Với UDP

Không nhận response có thể do request mất, response mất, server bận hoặc server không tồn tại. Application cần timeout, retry, request ID, deduplication hoặc acknowledgement nếu use case yêu cầu.

Ở cả hai trường hợp, transport reliability không thay thế application-level correctness.

#### Những lỗi tư duy phổ biến

- Cho rằng TCP đảm bảo business operation exactly once.
- Cho rằng TCP giữ nguyên message boundary.
- Cho rằng UDP luôn nhanh hơn trong mọi workload.
- Cho rằng UDP không bao giờ có reliability.
- Dùng UDP trên Internet mà không có congestion control phù hợp.
- Retransmit real-time packet đã hết giá trị.
- Dùng TCP cho mọi loại real-time data mà không xét head-of-line blocking.
- Khẳng định mọi video streaming đều dùng UDP.
- Khẳng định DNS chỉ dùng UDP.
- Quên rằng TLS/encryption là concern riêng với TCP; còn QUIC tích hợp TLS semantics.

#### Nội dung phụ — 10 câu hỏi phỏng vấn TCP và UDP

##### 1. Khác biệt cốt lõi giữa TCP và UDP là gì?

**Câu trả lời mẫu:**

> TCP là connection-oriented transport cung cấp ordered reliable byte stream, với handshake, ACK, retransmission, flow control và congestion control. UDP là connectionless datagram transport, giữ message boundary nhưng không cung cấp delivery, ordering hay retransmission guarantee. Vì vậy, TCP phù hợp khi cần stream đầy đủ và đúng thứ tự; UDP phù hợp khi application muốn overhead thấp hoặc tự quyết định guarantee theo thời hạn của dữ liệu.

| Tiêu chí | TCP | UDP |
|---|---|---|
| Data model | Byte stream | Datagram/message |
| Setup | Có handshake | Không có transport handshake |
| Reliability | Retransmit và báo lỗi nếu connection không thể tiếp tục | Best-effort; application tự bổ sung nếu cần |
| Ordering | Có | Không mặc định |
| Header | Tối thiểu 20 byte, có thể lớn hơn do option | 8 byte |
| State | Giữ state connection ở hai endpoint | Không có connection state ở protocol, nhưng OS/NAT/firewall vẫn có thể giữ mapping tạm |
| Use case | Web/API, file, email, database | Real-time media, game update, DNS, discovery, QUIC |

**Điểm cần tránh:** không nên nói “TCP bảo đảm mọi packet luôn tới”. Nếu network hỏng kéo dài hoặc endpoint chết, connection có thể thất bại và application nhận error. Guarantee thực tế là TCP cố cung cấp ordered reliable byte stream hoặc báo lỗi, không phải giữ connection sống vô hạn.

##### 2. Khi nào nên dùng TCP thay vì UDP?

Dùng TCP hoặc một reliable stream khi:

- Mất byte làm payload không thể sử dụng.
- Dữ liệu phải được xử lý đúng thứ tự.
- Application không muốn tự xây ACK, retransmission và congestion control.
- Tương thích với proxy, firewall và hệ sinh thái hiện tại quan trọng.
- Workload là file transfer, email, database connection hoặc business API.

**Câu trả lời mẫu:**

> Tôi chọn TCP khi correctness của stream quan trọng hơn việc bỏ qua dữ liệu trễ, chẳng hạn tải file, database protocol hoặc HTTP/1.1 và HTTP/2. TCP xử lý ordering, loss recovery và congestion control. Tuy vậy, application vẫn phải có framing, timeout, retry semantics và idempotency vì TCP không bảo đảm business operation exactly once.

**Lưu ý:** TCP checksum và retransmission hỗ trợ transport integrity, nhưng application có yêu cầu chống corruption mạnh có thể vẫn dùng checksum/hash ở mức file hoặc message.

##### 3. Khi nào nên dùng UDP thay vì TCP?

Dùng UDP hoặc protocol xây trên UDP khi:

- Dữ liệu mất giá trị nhanh và packet cũ không đáng retransmit.
- Có thể chấp nhận một phần loss hoặc tự phục hồi.
- Cần datagram boundary.
- Cần multicast trong network hỗ trợ.
- Application protocol muốn tự thiết kế reliability và multiplexing, như QUIC.

**Câu trả lời mẫu:**

> Tôi cân nhắc UDP cho voice/video real-time, game-state update, telemetry loss-tolerant hoặc DNS query vì latency và freshness quan trọng hơn nhận đủ mọi datagram. Tuy nhiên, application phải có congestion control và các cơ chế như sequence number, jitter buffer, FEC hoặc selective retransmission nếu cần.

**Hiệu chỉnh về video streaming:** không nên mặc định YouTube hoặc Netflix “dùng UDP cho video”. Streaming theo yêu cầu thường dùng HTTP qua TCP hoặc HTTP/3 qua QUIC trên UDP. Real-time interactive media mới thường dùng RTP/WebRTC trên UDP khi network cho phép.

##### 4. TCP đảm bảo reliability bằng cách nào?

TCP kết hợp:

1. Three-way handshake để thiết lập state.
2. Sequence number để theo dõi byte và ordering.
3. ACK để xác nhận tiến độ nhận.
4. Retransmission khi suy ra loss.
5. Checksum để phát hiện corruption ở segment.
6. Receive window để flow control.
7. Congestion window/algorithm để điều chỉnh theo network.
8. Reassembly để giao byte đúng thứ tự lên application.

**Câu trả lời mẫu:**

> TCP đánh số dữ liệu, receiver ACK phần đã nhận và sender retransmit phần bị mất. Receiver sắp lại dữ liệu trước khi giao lên application. Flow control bảo vệ receiver, còn congestion control điều chỉnh tốc độ theo network. Nếu không thể duy trì guarantee, TCP đóng hoặc báo lỗi connection thay vì âm thầm giao một byte stream thiếu.

**Nuance:** three-way handshake thiết lập connection nhưng không phải cơ chế duy nhất tạo reliability. ACK, retransmission, sequence, flow control và congestion control mới duy trì stream trong suốt vòng đời connection.

##### 5. Vì sao UDP thường có overhead thấp hơn TCP?

- Không có transport handshake.
- Header cố định 8 byte, trong khi TCP header tối thiểu 20 byte và có thể có option.
- Không có ACK/retransmission/ordering mặc định.
- Không giữ TCP-style connection state.
- Application có thể gửi datagram ngay.

**Câu trả lời mẫu:**

> UDP có overhead protocol thấp vì không thiết lập connection và không tự thực hiện ACK, retransmission hay ordering. Header UDP chỉ 8 byte. Nhưng overhead thấp không bảo đảm end-to-end latency luôn thấp hơn: nếu application phải tự bổ sung reliability, encryption và congestion control, chi phí tổng có thể đáng kể. Network path và server processing thường quan trọng hơn chênh lệch header.

##### 6. Nhược điểm chính của TCP và UDP là gì?

| Protocol | Nhược điểm |
|---|---|
| **TCP** | Handshake và state; retransmission/ordering gây delay; head-of-line blocking; giữ buffer/resource; không có message boundary |
| **UDP** | Không guarantee delivery/order; application tự quản recovery và congestion; dễ gặp fragmentation nếu datagram lớn; NAT/firewall mapping có thể hết hạn nhanh |

**Câu trả lời mẫu:**

> TCP đơn giản hóa reliability nhưng đổi lại là connection state, overhead và head-of-line blocking. UDP nhẹ và linh hoạt nhưng đẩy responsibility về application: loss handling, ordering, duplicate, pacing, congestion và security. Không protocol nào tốt hơn tuyệt đối.

**Điểm cần tránh:** “TCP không phù hợp với real-time” là khẳng định quá tuyệt đối. Nhiều ứng dụng real-time vẫn dùng TCP/WebSocket và hoạt động tốt khi yêu cầu latency không quá khắt khe hoặc loss thấp. UDP có lợi hơn khi data deadline ngắn và application cần tránh transport-wide retransmission delay.

##### 7. Application xây reliability trên UDP như thế nào?

Các building block:

- Sequence number để phát hiện loss, duplicate và reorder.
- ACK hoặc selective ACK cho dữ liệu quan trọng.
- Timeout và retransmission có deadline.
- Deduplication/request ID.
- Jitter buffer cho audio/video.
- Forward Error Correction.
- Interpolation hoặc concealment.
- Congestion control và pacing.
- Encryption/authentication.

```text
UDP base
  + sequence/ACK tùy chọn
  + loss recovery hoặc FEC
  + congestion control
  + security
  = application-specific transport semantics
```

**Câu trả lời mẫu:**

> UDP application có thể gắn sequence number, ACK dữ liệu quan trọng, retransmit khi còn trong deadline và dùng FEC để phục hồi loss không cần round-trip. Real-time media thêm jitter buffer; game có thể interpolate state. Quan trọng nhất là phải có congestion control, nếu không sender có thể làm network tệ hơn cho chính mình và người khác.

Sequence number tự nó không “đảm bảo packet tới đúng thứ tự”; nó chỉ cung cấp thông tin để application phát hiện và xử lý ordering.

##### 8. TCP và UDP có thể được dùng cùng nhau không?

Có. Một hệ thống có thể phân loại traffic:

```text
Reliable control/state  → TCP hoặc reliable stream
Fresh real-time update  → UDP datagram
```

Ví dụ game:

- Movement/position update qua UDP vì dữ liệu mới thay thế dữ liệu cũ.
- Login, inventory hoặc transaction qua reliable protocol.

Ví dụ media:

- Signaling có thể dùng HTTP/WebSocket hoặc protocol reliable.
- Interactive audio/video có thể dùng WebRTC media transport trên UDP, với fallback tùy network.

Một lựa chọn hiện đại khác là QUIC: chạy trên UDP nhưng cung cấp nhiều reliable stream, encryption và congestion control trong cùng protocol.

**Điểm cần tránh:** không nên gắn cứng sản phẩm như Netflix/YouTube với công thức “UDP cho video, TCP cho control”. Transport thực tế thay đổi theo HTTP version, client, CDN và network.

##### 9. DNS dùng TCP hay UDP?

DNS có thể dùng cả hai:

- UDP phổ biến cho query/response thông thường vì overhead thấp.
- Nếu UDP response bị truncation, client có thể retry qua TCP.
- Zone transfer thường dùng TCP.
- DNSSEC và response lớn làm kích thước response đáng quan tâm.
- DNS over TLS dùng TCP/TLS; DNS over HTTPS phụ thuộc HTTP transport; DNS over QUIC dùng QUIC/UDP.

**Câu trả lời mẫu:**

> DNS truyền thống thường bắt đầu bằng UDP. Khi response không vừa hoặc server đặt cờ truncated, client có thể thử lại qua TCP; zone transfer cũng dùng TCP. Hệ sinh thái hiện đại còn có DoT, DoH và DoQ, nên câu trả lời đúng là DNS không chỉ dùng một transport.

EDNS cho phép thương lượng UDP payload lớn hơn giới hạn DNS cổ điển, nhưng datagram lớn hơn cũng tăng rủi ro fragmentation. Implementation thường tránh vượt kích thước an toàn và fallback khi cần.

##### 10. Firewall xử lý TCP và UDP khác nhau thế nào?

Với TCP, stateful firewall có thể theo dõi:

- SYN/SYN-ACK/ACK.
- Trạng thái established/closing.
- Sequence/flag bất thường ở mức nhất định.
- Idle timeout của connection.

Với UDP, không có handshake hoặc FIN. Firewall/NAT thường tạo **pseudo-state** theo 5-tuple khi thấy datagram đi ra và giữ mapping trong một idle timeout ngắn hơn.

```text
5-tuple = source IP + source port + destination IP + destination port + protocol
```

**Câu trả lời mẫu:**

> TCP dễ mô hình hóa thành state machine vì có handshake và teardown. UDP connectionless nên firewall suy ra flow bằng 5-tuple và timeout, chứ không có tín hiệu transport rõ ràng rằng phiên đã bắt đầu hay kết thúc. UDP không mặc nhiên nguy hiểm hơn, nhưng source spoofing và các protocol trả response lớn có thể bị lạm dụng cho reflection/amplification DDoS.

Biện pháp:

- Chỉ mở port/protocol cần thiết.
- Rate limit và anomaly detection.
- Anti-spoofing/source validation ở network edge.
- Giới hạn amplification của UDP service.
- Timeout/mapping phù hợp cho NAT và firewall.
- DPI khi có giá trị và đủ capacity, nhưng encryption có thể giới hạn khả năng nhìn payload.

#### Câu hỏi tư duy và phỏng vấn

1. TCP three-way handshake giải quyết vấn đề gì?
2. TCP phát hiện và phục hồi packet loss như thế nào?
3. Flow control khác congestion control ra sao?
4. Vì sao TCP không cung cấp message boundary?
5. Head-of-line blocking ảnh hưởng real-time workload thế nào?
6. Khi nào mất packet tốt hơn đợi retransmission?
7. Nếu UDP không reliable, QUIC làm thế nào để dùng UDP mà vẫn reliable?
8. Vì sao payment API cần idempotency dù chạy trên TCP?
9. DNS khi nào chuyển từ UDP sang TCP hoặc transport khác?
10. Online game có thể phân loại message nào reliable và message nào loss-tolerant?
11. Điều gì xảy ra nếu UDP sender gửi nhanh hơn network capacity?
12. Chọn transport cho file transfer, voice call, telemetry và market feed như thế nào?

#### Ý chính cần nhớ

- TCP và UDP cùng nằm ở transport layer nhưng cung cấp communication semantics khác nhau.
- TCP cung cấp ordered reliable byte stream, flow control và congestion control.
- TCP cần connection setup và giữ state; ordering/retransmission tạo overhead và head-of-line blocking.
- TCP không giữ message boundary và không bảo đảm application exactly-once.
- UDP truyền datagram với overhead nhỏ nhưng không có ACK, ordering hoặc retransmission mặc định.
- UDP cho phép application tự chọn reliability theo giá trị và thời hạn của dữ liệu.
- Real-time data cũ có thể ít giá trị hơn dữ liệu mới, nên retransmission không phải lúc nào cũng tốt.
- Video streaming không mặc nhiên dùng UDP; HTTP streaming thường chạy trên TCP hoặc QUIC.
- DNS thường dùng UDP nhưng có thể dùng TCP hoặc transport khác.
- QUIC chứng minh rằng protocol trên UDP vẫn có thể cung cấp reliability và congestion control.
- Protocol selection phải dựa trên loss tolerance, ordering, latency, workload và operational support.
- Transport reliability không thay thế idempotency, transaction và application error handling.

#### Công thức ghi nhớ

> **TCP cung cấp reliable ordered byte stream; UDP cung cấp datagram tối giản để application tự chọn guarantee. Hãy chọn theo giá trị của dữ liệu, không chỉ theo khẩu hiệu “độ tin cậy hay tốc độ”.**

---

### Bài 18. HTTP — Xương sống của Web

#### 1. HTTP là gì?

**HTTP (Hypertext Transfer Protocol)** là giao thức tầng ứng dụng quy định cách client và server biểu diễn, gửi và xử lý request/response. Nó là ngôn ngữ chung phía sau:

- website và trình duyệt;
- mobile app gọi backend;
- public/private API;
- giao tiếp đồng bộ giữa các microservice;
- tải HTML, CSS, JavaScript, hình ảnh, video segment và dữ liệu JSON.

HTTP định nghĩa **ý nghĩa của message**: method nào đang được thực hiện, resource nào được nhắm tới, metadata nằm trong header và kết quả được biểu diễn bằng status code. Việc truyền message dựa trên transport bên dưới:

- HTTP/1.1 và HTTP/2 thường chạy trên TCP;
- HTTP/3 chạy trên QUIC, mà QUIC sử dụng UDP;
- HTTPS bổ sung kênh truyền bảo mật bằng TLS hoặc cơ chế TLS tích hợp trong QUIC.

> Nói “HTTP là text-based” chỉ chính xác với cú pháp message của HTTP/1.x. HTTP/2 và HTTP/3 dùng binary framing trên đường truyền nhưng vẫn giữ nguyên semantics như method, URI, header và status code.

#### 2. Mô hình request–response

Một lượt tương tác cơ bản:

1. Client xác định URL và thường phân giải domain bằng DNS.
2. Client thiết lập connection tới server, load balancer, CDN hoặc reverse proxy.
3. Với HTTPS, hai bên thiết lập kênh bảo mật và xác minh certificate của server.
4. Client gửi HTTP request.
5. Hệ thống xử lý request, có thể gọi cache, database hoặc downstream service.
6. Server trả HTTP response.
7. Client diễn giải kết quả; trình duyệt có thể phát sinh thêm nhiều request cho CSS, JavaScript, font và hình ảnh.

```text
Client
  │
  │ HTTP request: method + target + headers + body?
  ▼
CDN / Load Balancer / API Gateway / Server
  │
  │ HTTP response: status + headers + body?
  ▼
Client
```

Một trang web không đồng nghĩa với một request. HTML ban đầu thường tham chiếu nhiều resource khác, nên thời gian tải chịu ảnh hưởng của số request, kích thước payload, cache, số connection, protocol version và khoảng cách mạng.

#### 3. Cấu trúc HTTP request

HTTP request có bốn phần logic chính:

| Phần | Vai trò |
|---|---|
| **Method** | Diễn tả hành động mong muốn như đọc, tạo, thay thế hoặc xóa. |
| **Request target** | Xác định resource/path và có thể chứa query string. |
| **Headers** | Metadata về host, loại dữ liệu, xác thực, cache, tracing... |
| **Body** | Payload tùy chọn, thường dùng cho POST, PUT hoặc PATCH. |

Ví dụ HTTP/1.1:

```http
POST /orders HTTP/1.1
Host: api.example.com
Authorization: Bearer <access-token>
Content-Type: application/json
Accept: application/json
Idempotency-Key: 8f9c...

{
  "productId": "p-123",
  "quantity": 2
}
```

Các header dễ nhầm:

- `Content-Type`: kiểu dữ liệu của **body đang được gửi**.
- `Accept`: kiểu representation client muốn nhận.
- `Authorization`: credential hoặc token client trình bày.
- `Host`: hostname đích, cho phép nhiều website dùng chung một IP.
- `Cookie`: cookie phù hợp mà browser gửi về server.
- `If-None-Match`: validator dùng để kiểm tra cached representation còn mới hay không.

#### 4. Cấu trúc HTTP response

HTTP response thường gồm:

| Phần | Vai trò |
|---|---|
| **Status code** | Kết quả xử lý ở mức HTTP. |
| **Headers** | Metadata về body, cache, cookie, redirect, retry... |
| **Body** | Representation hoặc thông tin lỗi; một số response không có body. |

```http
HTTP/1.1 201 Created
Content-Type: application/json
Location: /orders/o-789
Cache-Control: no-store

{
  "id": "o-789",
  "status": "created"
}
```

Status code không thay thế domain result. Ví dụ `200 OK` chỉ nói request HTTP thành công; body vẫn có thể chứa trạng thái nghiệp vụ như `payment_pending`.

#### 5. HTTP methods và semantics

| Method | Mục đích thường gặp | Safe? | Idempotent theo semantics? | Ghi chú |
|---|---|---:|---:|---|
| `GET` | Đọc representation | Có | Có | Thường cache được; không nên dùng để thay đổi nghiệp vụ. |
| `HEAD` | Lấy metadata như GET nhưng không nhận response body | Có | Có | Hữu ích để kiểm tra resource hoặc header. |
| `POST` | Submit command, tạo resource hoặc kích hoạt xử lý | Không | Không mặc định | Có thể dùng idempotency key để retry an toàn. |
| `PUT` | Tạo/thay thế trạng thái resource tại URI đã biết | Không | Có | Thường được dùng như thay thế toàn bộ theo API contract. |
| `PATCH` | Cập nhật một phần resource | Không | Không bắt buộc | Có idempotent hay không tùy patch format và operation. |
| `DELETE` | Yêu cầu xóa resource | Không | Có | Gọi lại không được tạo thêm tác động nghiệp vụ; response có thể khác. |
| `OPTIONS` | Hỏi khả năng giao tiếp của endpoint | Có | Có | Thường xuất hiện trong CORS preflight. |

Ba khái niệm phải tách biệt:

- **Safe**: method được thiết kế chỉ để đọc; logging/metrics vẫn có thể thay đổi nội bộ.
- **Idempotent**: thực hiện cùng một request nhiều lần có intended effect tương đương một lần.
- **Cacheable**: response có được phép tái sử dụng hay không, phụ thuộc method, header và cache policy.

TCP chỉ bảo đảm byte được truyền đáng tin cậy trong một connection; nó không biết request đã tạo order hay trừ tiền chưa. Nếu client timeout sau khi server đã xử lý, retry `POST` có thể tạo tác động kép. Với write quan trọng, cần idempotency key, unique constraint hoặc transaction phù hợp.

#### 6. HTTP status codes

| Nhóm | Ý nghĩa | Ví dụ quan trọng |
|---|---|---|
| `1xx` | Thông tin tạm thời | `100 Continue`, `103 Early Hints` |
| `2xx` | Request được xử lý thành công | `200 OK`, `201 Created`, `202 Accepted`, `204 No Content` |
| `3xx` | Redirect hoặc cache validation | `301`, `302`, `303`, `304`, `307`, `308` |
| `4xx` | Request không thể hoàn thành do điều kiện phía client/request | `400`, `401`, `403`, `404`, `409`, `412`, `429` |
| `5xx` | Server hoặc upstream không thể hoàn thành request hợp lệ | `500`, `502`, `503`, `504` |

Một số mã cần nhớ:

- `201 Created`: resource đã được tạo; thường đi kèm `Location`.
- `202 Accepted`: đã nhận công việc nhưng xử lý chưa hoàn tất, phù hợp job bất đồng bộ.
- `204 No Content`: thành công và không có response body.
- `301 Moved Permanently`: URI thay đổi vĩnh viễn.
- `302 Found`: redirect tạm thời; do hành vi lịch sử, method có thể bị client đổi thành GET.
- `303 See Other`: chủ động yêu cầu client theo `Location` bằng GET.
- `307 Temporary Redirect`: redirect tạm thời và giữ nguyên method/body.
- `308 Permanent Redirect`: redirect vĩnh viễn và giữ nguyên method/body.
- `304 Not Modified`: cached representation còn hợp lệ; đây là cache validation, không phải redirect thông thường và không mang representation body.
- `401 Unauthorized`: tên hơi gây hiểu nhầm; thực tế thường có nghĩa client **chưa được xác thực hợp lệ**.
- `403 Forbidden`: server hiểu danh tính/request nhưng không cho phép hành động.
- `409 Conflict`: request xung đột với trạng thái hiện tại, ví dụ version conflict.
- `429 Too Many Requests`: vượt rate limit; có thể kèm `Retry-After`.
- `502 Bad Gateway`: proxy/gateway nhận response không hợp lệ từ upstream.
- `503 Service Unavailable`: tạm thời quá tải, bảo trì hoặc không đủ backend khỏe.
- `504 Gateway Timeout`: gateway không nhận kết quả upstream kịp thời.

Không phải lỗi nào cũng có status code: DNS failure, connection refused, TLS error hoặc network timeout có thể xảy ra trước khi client nhận được HTTP response.

#### 7. Statelessness: HTTP không tự nhớ request trước

HTTP được xem là **stateless** vì mỗi request phải đủ thông tin để được diễn giải; protocol không bắt buộc server duy trì application session từ request trước. Điều này không có nghĩa hệ thống không được lưu state.

Các cách duy trì context:

- **Cookie**: dữ liệu do browser lưu. Browser chỉ tự gửi cookie khi request khớp domain, path, thời hạn và các rule như `Secure`/`SameSite`.
- **Server-side session**: server lưu session state trong database/cache; client giữ session ID, thường qua cookie.
- **Token**: client trình bày token trong `Authorization` header hoặc cookie. Bearer token bị lộ có thể bị dùng như credential.

Lưu ý:

- JWT là **định dạng token**; OAuth 2.0 là **framework ủy quyền**. Hai khái niệm không đồng nghĩa.
- Token không mặc nhiên phải đặt trong `localStorage`; cách lưu phải cân nhắc XSS, CSRF và loại client.
- Persistent connection chỉ tái sử dụng đường truyền, không tự biến HTTP thành stateful application protocol.
- “Stateless application server” thường nghĩa instance không phụ thuộc session state cục bộ; dữ liệu bền vững vẫn tồn tại ở database, cache hoặc service khác.

#### 8. HTTP caching

Caching giảm latency, bandwidth và tải lên origin. Cache có thể nằm ở browser, proxy, CDN, API gateway hoặc application layer.

Hai cơ chế chính:

1. **Freshness**: cache dùng object ngay trong thời gian còn mới.
2. **Validation**: cache hỏi origin xem object cũ còn hợp lệ không; nếu hợp lệ, origin trả `304 Not Modified` thay vì gửi lại body.

Các directive/header quan trọng:

| Header/directive | Ý nghĩa |
|---|---|
| `Cache-Control: max-age=3600` | Fresh trong 3.600 giây tại cache nhận response. |
| `s-maxage` | Freshness dành cho shared cache như CDN/proxy. |
| `public` | Cho phép shared cache lưu khi các điều kiện khác cho phép. |
| `private` | Chỉ private cache như browser được lưu. |
| `no-cache` | **Có thể lưu**, nhưng phải revalidate trước khi reuse. |
| `no-store` | Không lưu response trong cache. |
| `must-revalidate` | Khi stale, không tự dùng lại nếu chưa validation thành công. |
| `stale-while-revalidate` | Tạm phục vụ stale trong lúc refresh ở background. |
| `ETag` / `If-None-Match` | Validator theo phiên bản representation. |
| `Last-Modified` / `If-Modified-Since` | Validator dựa trên thời điểm sửa đổi. |
| `Vary` | Cho biết header request nào làm thay đổi representation/cache key. |

Cache key sai có thể làm rò dữ liệu giữa user hoặc trả nhầm ngôn ngữ/encoding. Response cá nhân hóa, `Authorization`, cookie và `Vary` cần policy rõ ràng. Caching là quyết định về **correctness** trước khi là tối ưu hiệu năng.

#### 9. HTTPS và TLS

HTTPS là HTTP được truyền qua secure transport. TLS cung cấp ba thuộc tính chính:

- **Confidentiality**: người nghe lén không đọc được plaintext.
- **Integrity**: thay đổi dữ liệu trên đường truyền bị phát hiện.
- **Authentication**: client xác minh server đang sở hữu danh tính/domain gắn với certificate; mTLS có thể xác minh cả client.

Port `80` cho HTTP và `443` cho HTTPS là mặc định theo quy ước, không phải giới hạn bắt buộc.

HTTPS không tự ngăn XSS, SQL injection, authorization bug, phishing hoặc server bị xâm nhập. Một thiết kế production còn cần:

- redirect HTTP sang HTTPS và dùng HSTS khi phù hợp;
- cookie `Secure`, `HttpOnly`, `SameSite` đúng mục đích;
- input validation, output encoding và Content Security Policy;
- authentication/authorization nhất quán;
- quản lý certificate, key rotation và TLS configuration;
- bảo vệ cả chặng proxy-to-backend bằng TLS re-encryption hoặc mTLS nếu threat model yêu cầu.

Certificate hợp lệ chứng minh kết nối tới domain được chứng nhận, không chứng minh ứng dụng phía sau là vô hại hay không có lỗ hổng.

#### 10. Sự tiến hóa của HTTP

| Phiên bản | Cải tiến chính | Điểm cần lưu ý |
|---|---|---|
| **HTTP/1.0** | Mô hình web request–response cơ bản | Thường cần connection mới cho nhiều lượt trao đổi. |
| **HTTP/1.1** | Persistent connection, Host header, chunked transfer | Có thể cần nhiều connection; pipelining ít được dùng do ordering/HOL. |
| **HTTP/2** | Binary framing, multiplexing nhiều stream, nén header HPACK | Nhiều stream cùng TCP connection vẫn chịu TCP-level head-of-line khi packet mất. |
| **HTTP/3** | HTTP trên QUIC, stream độc lập hơn, QPACK, TLS 1.3 tích hợp, connection migration | Cần hạ tầng hỗ trợ UDP/QUIC; không phải workload nào cũng tự động nhanh hơn. |

Semantics của HTTP nhìn chung không đổi qua các phiên bản. Application vẫn làm việc với method, URI, headers, status code và body; wire format và transport được tối ưu dần.

#### 11. HTTP dưới góc nhìn System Design

Khi chọn và tối ưu HTTP, cần nhìn toàn bộ request path:

- **Connection reuse** giảm handshake và setup cost.
- **HTTP/2/3 multiplexing** giảm nhu cầu mở nhiều connection cho concurrent requests.
- **Caching/CDN** tránh chuyển lại dữ liệu không đổi và giảm tải origin.
- **Compression và payload design** giảm số byte nhưng tiêu tốn CPU; tránh trả thừa field.
- **Timeout** phải có ở mỗi hop và phù hợp end-to-end latency budget.
- **Retry** chỉ nên áp dụng cho lỗi tạm thời, có backoff, jitter và retry budget.
- **Idempotency** quyết định write nào có thể retry an toàn.
- **Rate limiting/load shedding** bảo vệ backend khi tải vượt capacity.
- **Streaming/pagination** tránh giữ toàn bộ response lớn trong memory và giảm time-to-first-result.
- **Observability** nên truyền correlation/trace context và ghi nhận latency theo từng hop.

Một request qua nhiều service có thể gây fan-out lớn. Dù mỗi call chỉ chậm một chút, chuỗi dependency, retry chồng lặp và tail latency có thể làm request tổng thể vượt SLO.

#### 12. Retry an toàn

Trước khi retry, cần hỏi:

1. Client có nhận được HTTP response hay chỉ timeout?
2. Operation có safe/idempotent hay có idempotency key không?
3. Lỗi có tính tạm thời không (`429`, `502`, `503`, `504` thường là ứng viên, nhưng phải theo contract)?
4. Server có gửi `Retry-After` không?
5. Retry có còn nằm trong deadline tổng thể không?
6. Có backoff, jitter và giới hạn số lần để tránh retry storm không?

Không nên retry mù mọi `5xx`, và không retry validation/authorization error chỉ vì chúng thuộc `4xx`.

#### 13. Các lỗi tư duy thường gặp

- Nghĩ HTTP chỉ dành cho browser; thực tế nó phổ biến trong API và service-to-service.
- Đồng nhất URL với IP; URL còn chứa scheme, host, port, path, query và fragment.
- Cho rằng một page load chỉ có một HTTP request.
- Cho rằng `GET` không có bất kỳ side effect nào; “safe” nói về intended semantics, không loại trừ logging.
- Cho rằng mọi `PUT` luôn là partial update hoặc mọi `PATCH` luôn idempotent.
- Nhầm `401` là đã xác thực nhưng thiếu quyền; trường hợp đó thường là `403`.
- Dùng `200 OK` cho mọi lỗi và giấu kết quả trong body, làm client/proxy/monitoring khó hiểu.
- Nhầm `no-cache` với “không lưu”; directive cấm lưu là `no-store`.
- Cho rằng HTTPS giải quyết toàn bộ application security.
- Retry write sau timeout mà không có idempotency control.
- Gửi response cá nhân hóa vào shared cache với cache key không đủ.
- Chỉ tối ưu protocol version mà bỏ qua payload, cache, database, fan-out và downstream latency.

#### 14. Câu hỏi phỏng vấn từ tài liệu phụ

**1. HTTP là gì và hoạt động thế nào?**  
HTTP là application protocol theo mô hình request–response. Client gửi method, target, headers và body tùy chọn; server xử lý rồi trả status, headers và body tùy chọn.

**2. Vì sao HTTP được coi là stateless?**  
Mỗi request được diễn giải độc lập và protocol không bắt buộc server nhớ application context trước đó. State vẫn có thể được duy trì bằng cookie, session hoặc token.

**3. HTTP khác HTTPS ở đâu?**  
HTTPS bảo vệ HTTP bằng TLS/QUIC secure transport, cung cấp encryption, integrity và peer authentication. `80` và `443` chỉ là default ports.

**4. Hãy mô tả request–response cycle.**  
Resolve name → thiết lập connection/TLS → gửi request → routing/xử lý → trả response → client diễn giải và có thể gửi thêm request.

**5. PUT khác PATCH thế nào?**  
PUT có semantics idempotent và thường thay thế representation tại URI; PATCH mô tả partial modification và không mặc nhiên idempotent. API contract phải xác định chi tiết.

**6. Các nhóm status code là gì?**  
`1xx` thông tin, `2xx` thành công, `3xx` redirect/validation, `4xx` vấn đề ở request/client context, `5xx` server/upstream không thể hoàn thành request.

**7. Cookie, session và token duy trì state ra sao?**  
Cookie lưu dữ liệu phía browser và được gửi theo matching rule; session lưu state phía server qua session ID; token mang credential/claim để client trình bày ở các request.

**8. 301 khác 302 thế nào?**  
301 báo thay đổi vĩnh viễn, 302 báo redirect tạm thời. Nếu phải giữ method/body một cách rõ ràng, dùng 308 cho permanent hoặc 307 cho temporary.

**9. HTTP caching hoạt động ra sao?**  
Cache tái sử dụng response khi còn fresh hoặc revalidate bằng ETag/Last-Modified. `Cache-Control`, validator và `Vary` quyết định tính hợp lệ và khả năng chia sẻ.

**10. Các rủi ro bảo mật và biện pháp giảm thiểu?**  
Plain HTTP có thể bị nghe lén/chỉnh sửa; session có thể bị đánh cắp; application có thể dính XSS/injection. Dùng HTTPS, secure cookie, CSP, validation, auth đúng cách và không coi TLS là lớp bảo vệ duy nhất.

#### 15. Câu hỏi tư duy thêm

1. Client timeout khi tạo payment: làm sao biết có nên retry?
2. Vì sao `304 Not Modified` có thể giảm bandwidth nhưng vẫn cần round trip?
3. Khi nào nên trả `202 Accepted` thay vì chờ `200 OK`?
4. Vì sao HTTP/2 multiplexing không loại bỏ hoàn toàn head-of-line blocking?
5. `no-cache`, `no-store` và `private` khác nhau thế nào?
6. API dùng cookie authentication phải cân nhắc CSRF ra sao?
7. Tại sao một reverse proxy có thể trả `502` hoặc `504` dù application không phát mã đó?
8. Cách thiết kế cache key cho response phụ thuộc ngôn ngữ và user identity?
9. Khi nào một `PATCH` idempotent và khi nào không?
10. Chọn timeout và retry budget thế nào cho request fan-out qua nhiều service?

#### 16. Ý chính cần nhớ

- HTTP là giao thức tầng ứng dụng với request–response semantics, không phải transport protocol.
- Request gồm method, target, headers và body tùy chọn; response gồm status, headers và body tùy chọn.
- Safe, idempotent và cacheable là ba thuộc tính khác nhau.
- HTTP stateless không có nghĩa hệ thống không được giữ state.
- Status code giúp client, proxy và hệ thống quan sát hiểu kết quả ở mức protocol.
- `304` phục vụ cache validation; `no-cache` không đồng nghĩa với `no-store`.
- HTTPS cung cấp confidentiality, integrity và authentication nhưng không thay thế application security.
- HTTP/2 và HTTP/3 tối ưu wire protocol/transport nhưng giữ HTTP semantics.
- Retry write cần idempotency; retry phải có deadline, backoff, jitter và budget.
- Hiệu năng HTTP phụ thuộc cả cache, payload, connection, protocol, fan-out và downstream system.

#### Công thức ghi nhớ

> **HTTP định nghĩa ý nghĩa của cuộc trao đổi; transport chuyển dữ liệu; TLS bảo vệ đường truyền; cache, retry và idempotency quyết định hệ thống vừa nhanh vừa đúng khi vận hành thực tế.**

---

### Bài 19. REST và các nguyên tắc thiết kế RESTful API

#### 1. REST là gì?

**REST (Representational State Transfer)** là một **architectural style**, không phải protocol, framework hay data format. REST mô tả một tập constraint để các thành phần trong distributed hypermedia system giao tiếp theo cách đơn giản, có khả năng mở rộng và ít phụ thuộc lẫn nhau.

REST gắn chặt với kiến trúc Web và thường được hiện thực bằng HTTP:

- hệ thống được nhìn dưới dạng các **resource**;
- resource được định danh bằng URI;
- client thao tác thông qua representation và standard method;
- message đủ rõ để các intermediary như cache, proxy và gateway tham gia;
- interaction không phụ thuộc session context cục bộ trên một server cụ thể.

Ví dụ, thay vì thiết kế action endpoint:

```http
POST /createOrder
POST /cancelOrder?id=o-123
```

Ta mô hình theo resource và state transition:

```http
POST  /orders
GET   /orders/o-123
PATCH /orders/o-123
```

Tuy nhiên, không phải mọi business operation đều ánh xạ đẹp thành CRUD. Một command có domain semantics rõ vẫn có thể được mô hình thành subresource hoặc operation resource, ví dụ:

```http
POST /orders/o-123/cancellations
POST /payments/p-456/refunds
```

Điều quan trọng là contract dễ hiểu và nhất quán, không phải ép mọi hành động thành một động từ HTTP một cách máy móc.

#### 2. Vì sao REST trở nên phổ biến?

- **Tận dụng Web/HTTP**: không cần một communication model độc quyền.
- **Interoperability**: client và server có thể dùng ngôn ngữ, nền tảng khác nhau.
- **Loose coupling**: consumer phụ thuộc vào contract, không phụ thuộc implementation nội bộ.
- **Horizontal scalability**: stateless interaction giúp request được chuyển tới nhiều instance.
- **Cacheability**: HTTP cache có thể giảm latency và backend load.
- **Ecosystem lớn**: browser, proxy, CDN, gateway, monitoring và developer tooling đều hiểu HTTP.
- **Developer experience**: resource, method và status code nhất quán làm API dễ dự đoán.

REST không tự động làm API nhanh, an toàn hoặc dễ bảo trì. Những lợi ích đó chỉ xuất hiện khi resource model, HTTP semantics, cache policy, error contract và operational controls được thiết kế đúng.

#### 3. Sáu constraint của REST

| Constraint | Ý nghĩa | Giá trị kiến trúc |
|---|---|---|
| **Client–server** | Tách UI/client concern khỏi data/business concern phía server. | Hai phía có thể phát triển và triển khai độc lập hơn. |
| **Stateless** | Mỗi request chứa context cần thiết; server không phụ thuộc client session context của request trước. | Dễ load balance, scale out và failover. |
| **Cacheable** | Response cho biết rõ có được cache hay không. | Giảm latency, bandwidth và origin load. |
| **Uniform interface** | Các thành phần giao tiếp qua một interface nhất quán. | Giảm coupling, tăng khả năng hiểu và tham gia của intermediary. |
| **Layered system** | Client không cần biết đang nói trực tiếp với origin hay qua các lớp trung gian. | Cho phép thêm CDN, proxy, gateway, WAF và load balancer. |
| **Code on demand — tùy chọn** | Server có thể mở rộng chức năng client bằng code được gửi xuống. | Tăng khả năng mở rộng client nhưng giảm visibility; đây là constraint duy nhất không bắt buộc. |

**Uniform interface** là phần cốt lõi và thường bị rút gọn quá mức thành “dùng GET/POST/PUT/DELETE”. Nó gồm bốn ý:

1. **Identification of resources**: resource được định danh trong request, thường qua URI.
2. **Manipulation through representations**: client thao tác resource thông qua representation và metadata.
3. **Self-descriptive messages**: message chứa đủ thông tin để bên nhận hiểu cách xử lý.
4. **HATEOAS**: client chuyển application state dựa trên hypermedia control do server cung cấp.

> Một HTTP JSON API chưa chắc là RESTful. Dùng HTTP method chỉ là một phần; RESTfulness còn liên quan đến toàn bộ constraints, đặc biệt uniform interface.

#### 4. Statelessness không có nghĩa “không có state”

Phải phân biệt:

- **Resource state**: trạng thái nghiệp vụ như order, balance hoặc profile; vẫn được lưu ở server/database.
- **Application/session state**: tiến trình tương tác của client. Trong REST nghiêm ngặt, mỗi request mang đủ context và server không dựa vào session context lưu từ request trước.

Token trong `Authorization` header thường giúp request tự chứa authentication context. Server vẫn có thể tra user, permission, revocation hoặc resource state trong database/cache.

Server-side session affinity làm giảm một số lợi ích của statelessness vì request có thể phải quay lại instance hoặc session store. Nó không làm hệ thống “không phải HTTP”, nhưng khiến thiết kế kém sát REST hơn.

#### 5. Resource, representation và endpoint

- **Resource**: khái niệm nghiệp vụ có identity, ví dụ user, product, order hoặc invoice.
- **Representation**: biểu diễn hiện tại của resource, ví dụ JSON hoặc XML. Resource không đồng nhất với document JSON.
- **URI**: định danh resource.
- **Endpoint**: địa chỉ và interaction point cụ thể mà client gọi; trong cách nói thực tế thường là method + URL.

Ví dụ:

```http
GET /users/u-123
Accept: application/json
```

```json
{
  "id": "u-123",
  "displayName": "An",
  "status": "active"
}
```

Cùng resource có thể có representation khác nếu API hỗ trợ content negotiation:

```http
Accept: application/json
Accept: application/xml
```

#### 6. Thiết kế URI theo resource

Nguyên tắc thực dụng:

- dùng noun thay vì action verb: `/orders`, không phải `/getOrders`;
- chọn số ít hoặc số nhiều rồi dùng nhất quán; convention phổ biến là plural;
- dùng identifier ổn định: `/orders/{orderId}`;
- dùng query parameter cho filter, sort, search và pagination;
- chỉ dùng nested path khi quan hệ sở hữu hoặc scope thực sự có ý nghĩa;
- tránh nesting quá sâu vì làm contract cứng và URL khó quản lý;
- không đưa implementation detail như tên bảng hoặc tên service vào public API.

```http
GET /products?category=book&sort=-createdAt&limit=20
GET /users/u-123/orders?status=open
GET /orders/o-789/items
```

Resource modeling nên phản ánh domain boundary. Hãy dành nhiều thời gian cho resource và lifecycle hơn là chỉ đặt tên endpoint.

#### 7. HTTP method semantics trong REST

| Method | Semantics thường dùng | Safe | Idempotent |
|---|---|---:|---:|
| `GET` | Đọc representation | Có | Có |
| `HEAD` | Đọc metadata, không lấy body | Có | Có |
| `POST` | Submit command hoặc tạo subordinate resource | Không | Không mặc định |
| `PUT` | Tạo/thay thế state tại URI xác định | Không | Có |
| `PATCH` | Áp dụng partial modification | Không | Không bắt buộc |
| `DELETE` | Yêu cầu xóa resource | Không | Có |

Chọn đúng method giúp browser, cache, proxy, gateway, monitoring và client library suy luận đúng hành vi.

**PUT và PATCH:**

- `PUT /users/u-1` thường gửi representation thay thế hoàn chỉnh theo contract.
- `PATCH /users/u-1` chỉ gửi thay đổi cần áp dụng.
- PATCH có thể idempotent nếu “đặt email thành X”, nhưng không idempotent nếu “tăng balance thêm 10”.
- Khi retry write, semantics vẫn phải đi cùng idempotency key, version check hoặc database constraint phù hợp.

#### 8. Status code và response contract

Một REST API nên dùng HTTP status code đúng semantics:

| Tình huống | Status phù hợp thường gặp |
|---|---|
| Đọc/cập nhật thành công và có body | `200 OK` |
| Tạo resource | `201 Created` + `Location` |
| Nhận job bất đồng bộ | `202 Accepted` + URI kiểm tra trạng thái |
| Thành công, không cần body | `204 No Content` |
| Request malformed/validation cơ bản | `400 Bad Request` |
| Chưa authentication hợp lệ | `401 Unauthorized` |
| Đã biết principal nhưng thiếu quyền | `403 Forbidden` |
| Không tìm thấy resource | `404 Not Found` |
| Xung đột state/business invariant | `409 Conflict` |
| Optimistic concurrency check thất bại | `412 Precondition Failed` |
| Validation nghiệp vụ chi tiết | `422 Unprocessable Content` nếu contract chọn dùng |
| Vượt rate limit | `429 Too Many Requests` |
| Lỗi không dự kiến phía server | `500 Internal Server Error` |

Error body phải có schema ổn định và machine-readable:

```json
{
  "code": "ORDER_STATE_CONFLICT",
  "message": "Order cannot be cancelled after shipment",
  "requestId": "req-7f2...",
  "details": [
    {"field": "status", "reason": "already_shipped"}
  ]
}
```

Không trả stack trace hoặc secret cho client. `requestId` giúp đối chiếu log/trace nhưng không nên làm lộ thông tin nội bộ.

#### 9. JSON và XML

REST không bắt buộc JSON. Representation có thể là JSON, XML, HTML, image hoặc media type khác.

| JSON | XML |
|---|---|
| Gọn, phổ biến trong web/mobile, ánh xạ thuận tiện sang data structure. | Mạnh về document model, namespace, schema và ecosystem enterprise. |
| Thường có payload nhỏ và tooling đơn giản hơn. | Có thể phù hợp legacy integration, regulatory contract hoặc SOAP ecosystem. |

Với API mới, JSON thường là lựa chọn mặc định. XML vẫn hợp lý khi compatibility, schema hoặc hệ thống tích hợp yêu cầu. Hiệu năng thực tế còn phụ thuộc payload, parser, compression và workload; không nên kết luận chỉ từ tên format.

#### 10. Pagination, filtering và sorting

Collection lớn không nên trả toàn bộ dữ liệu.

**Offset pagination:**

```http
GET /users?offset=20&limit=10
```

- dễ hiểu và cho phép nhảy trang;
- offset lớn có thể chậm;
- dữ liệu thêm/xóa giữa các lượt có thể gây trùng hoặc bỏ sót.

**Cursor pagination:**

```http
GET /users?limit=10&after=eyJpZCI6...
```

- ổn định và hiệu quả hơn cho feed lớn/biến động;
- khó nhảy trực tiếp tới trang bất kỳ;
- cursor nên opaque và gắn với sort/filter context.

Response nên cho biết next cursor/link và contract về ordering. Sort phải deterministic, thường cần tie-breaker như unique ID.

#### 11. Caching và optimistic concurrency

REST tận dụng HTTP caching thay vì tự phát minh cơ chế riêng:

```http
Cache-Control: public, max-age=60
ETag: "user-u-123-v7"
```

Client revalidate:

```http
GET /users/u-123
If-None-Match: "user-u-123-v7"
```

Nếu không đổi, server trả `304 Not Modified`.

ETag cũng có thể chống lost update:

```http
PATCH /users/u-123
If-Match: "user-u-123-v7"
```

Nếu resource đã sang version khác, server trả `412 Precondition Failed` thay vì ghi đè thay đổi của client khác.

#### 12. Versioning và backward compatibility

Các cách thường gặp:

- URI: `/v1/orders`
- custom/version header: `Accept-Version: 1`
- media type/content negotiation: `Accept: application/vnd.example.order.v1+json`
- query parameter: `/orders?version=1`

Không có một chiến lược đúng cho mọi hệ thống. URI versioning dễ nhìn và vận hành; header/media type giữ URI sạch nhưng khó quan sát/thử nghiệm hơn; query versioning đơn giản nhưng dễ tạo cache variation ngoài dự kiến.

Trước khi tăng major version, ưu tiên evolution tương thích ngược:

- thêm optional field thay vì đổi nghĩa field cũ;
- không đổi type hoặc enum semantics tùy tiện;
- consumer phải bỏ qua field chưa biết khi contract cho phép;
- có deprecation policy, telemetry về usage và thời hạn migration;
- contract test/OpenAPI giúp phát hiện breaking change.

API version không thay thế resource version. `/v2/orders` nói về contract; `ETag` hoặc version field nói về trạng thái của một resource cụ thể.

#### 13. HATEOAS

**HATEOAS (Hypermedia as the Engine of Application State)** yêu cầu response cung cấp hypermedia control để client biết những transition hợp lệ tiếp theo, thay vì hard-code toàn bộ workflow.

```json
{
  "id": "o-123",
  "status": "pending",
  "_links": {
    "self": {"href": "/orders/o-123"},
    "cancel": {"href": "/orders/o-123/cancellations", "method": "POST"},
    "payment": {"href": "/orders/o-123/payment"}
  }
}
```

Nhiều API tự gọi là RESTful nhưng chỉ dùng một phần REST và không triển khai HATEOAS đầy đủ. Đây là khác biệt giữa usage phổ biến trong ngành và định nghĩa REST nghiêm ngặt.

#### 14. Authentication, authorization và security

- Luôn dùng HTTPS.
- **Authentication** xác minh danh tính; **authorization** quyết định quyền trên từng resource/action.
- OAuth 2.0 là authorization framework; OIDC bổ sung identity/authentication layer.
- JWT là token format, không phải cơ chế đăng nhập hay session management hoàn chỉnh.
- API key thường nhận diện application/consumer; không mặc nhiên đại diện cho user hoặc đủ an toàn nếu đứng một mình.
- Xác minh issuer, audience, signature, expiry, scope và key rotation của token.
- Thực thi object-level authorization để tránh user đổi ID và đọc resource của người khác.
- Validate input, parameterize database query, giới hạn payload và tránh mass assignment.
- Nếu credential dùng cookie, cân nhắc CSRF; nếu token cho JavaScript truy cập, cân nhắc XSS.
- Rate limit/quota theo identity, tenant, route và cost; không chỉ theo IP.
- Không đưa secret/PII vào URL vì URL thường xuất hiện trong log, history và analytics.

REST không “xử lý” security vulnerability thay ứng dụng; security là concern xuyên suốt transport, identity, authorization, validation, data và vận hành.

#### 15. REST so với SOAP, GraphQL và gRPC

| Tiêu chí | REST over HTTP | SOAP | GraphQL | gRPC |
|---|---|---|---|---|
| Bản chất | Architectural style | Messaging protocol | Query language + runtime | RPC framework |
| Contract | URI/method/schema; thường mô tả bằng OpenAPI | WSDL và XML schema | Strongly typed graph schema | `.proto` service/message schema |
| Data | Thường JSON; không bắt buộc | XML envelope | Thường JSON response | Thường Protocol Buffers |
| Interaction | Resource-oriented | Operation/message-oriented | Client chọn field qua graph query | Gọi method, hỗ trợ streaming |
| Điểm mạnh | Web ecosystem, cache, simplicity, public API | WS-* enterprise features, formal contract | Tránh over/under-fetch ở graph phức tạp | Compact, code generation, low-latency service communication |
| Đánh đổi | Nhiều endpoint/round trip, contract discipline | Verbose và phức tạp hơn | Query cost, caching/authorization phức tạp | Browser/public debugging khó hơn, coupling vào schema/tooling |

Không thể nói GraphQL luôn “nhanh” và gRPC luôn “nhanh nhất”. Kết quả phụ thuộc payload, số round trip, serialization, transport, caching, query shape, server implementation và network.

#### 16. Hiệu năng và reliability

- Dùng HTTP cache/CDN cho resource phù hợp.
- Nén response khi lợi ích bandwidth lớn hơn CPU cost.
- Pagination và field projection để tránh payload quá lớn.
- Database index theo access pattern thực tế.
- Tránh N+1 query và fan-out không kiểm soát.
- Chuyển tác vụ dài sang async job, trả `202` cùng status resource.
- Đặt timeout, retry budget, backoff và jitter.
- Dùng idempotency key cho create/payment có thể retry.
- Connection reuse, HTTP/2 hoặc HTTP/3 khi phù hợp.
- Rate limit và load shedding để bảo vệ dependency.
- Theo dõi p50/p95/p99 latency, error rate, saturation và latency từng downstream.

#### 17. Ví dụ: API cho nền tảng blog

```http
GET    /posts?limit=20&after=<cursor>
POST   /posts
GET    /posts/{postId}
PATCH  /posts/{postId}
DELETE /posts/{postId}

GET    /posts/{postId}/comments
POST   /posts/{postId}/comments
GET    /comments/{commentId}
DELETE /comments/{commentId}
```

`POST /posts` thành công nên trả `201 Created` và `Location: /posts/{id}`. Update có thể dùng `If-Match` để tránh lost update. List endpoint cần pagination, stable ordering và filter rõ ràng. Authorization phải kiểm tra author/moderator trên từng post/comment, không chỉ kiểm tra user đã đăng nhập.

#### 18. REST API và RESTful API có khác nhau không?

Trong giao tiếp hằng ngày:

- “REST API” thường chỉ HTTP API mang phong cách resource-oriented.
- “RESTful API” thường nhấn mạnh API tuân thủ REST tốt hơn.

Nhưng đây **không phải hai loại được định nghĩa bằng một tiêu chuẩn chính thức riêng biệt**. Thay vì tranh luận nhãn, hãy nói rõ API tuân thủ constraint nào, dùng HTTP semantics ra sao, có cache/HATEOAS hay không và chấp nhận trade-off gì.

#### 19. Câu hỏi phỏng vấn từ tài liệu phụ

**1. REST là gì và khác SOAP ra sao?**  
REST là architectural style resource-oriented; SOAP là protocol message-oriented dựa trên XML. SOAP có contract và WS-* mạnh; REST tận dụng HTTP/Web ecosystem. Hiệu năng phải đo theo workload, không kết luận tuyệt đối.

**2. Sáu REST constraints là gì?**  
Client–server, stateless, cacheable, uniform interface, layered system và code on demand tùy chọn.

**3. REST API khác RESTful API thế nào?**  
Không có ranh giới chuẩn chính thức; “RESTful” thường chỉ mức độ tuân thủ constraints cao hơn.

**4. Resource là gì và được biểu diễn thế nào?**  
Resource là khái niệm có identity; URI định danh nó, còn JSON/XML chỉ là representation.

**5. Endpoint là gì?**  
Interaction point mà client gọi, thường được mô tả bằng method + URL như `GET /users/{id}`.

**6. GET, POST, PUT, PATCH, DELETE khác nhau thế nào?**  
Khác nhau ở intended semantics, safety và idempotency; không chỉ là năm tên cho CRUD.

**7. Khi nào dùng PUT và PATCH?**  
PUT cho create/replace tại URI và idempotent; PATCH cho partial modification, idempotency tùy operation.

**8. Status code REST thường gặp?**  
`200`, `201`, `202`, `204`, `400`, `401`, `403`, `404`, `409`, `412`, `429`, `500` cùng các gateway error khi có intermediary.

**9. Best practices quan trọng?**  
Resource model nhất quán, đúng HTTP semantics, pagination, cache, error schema, security, compatibility, rate limit, observability và documentation/contract.

**10. Thiết kế API blog thế nào?**  
Dùng resource `/posts`, `/comments`, collection/item endpoint, pagination, ownership authorization và concurrency control như ví dụ trên.

**11. HATEOAS là gì?**  
Server đưa link/action hợp lệ trong representation để client khám phá state transition.

**12. Xử lý authentication và authorization thế nào?**  
Dùng HTTPS; chọn session/OAuth2/OIDC/token/API key đúng đối tượng; xác minh credential và thực thi quyền trên từng resource.

**13. Caching trong REST hoạt động ra sao?**  
Dùng HTTP freshness (`Cache-Control`) và validator (`ETag`, `Last-Modified`), đồng thời thiết kế cache key/`Vary` đúng.

**14. Pagination thế nào?**  
Offset đơn giản; cursor ổn định và hiệu quả hơn cho dataset lớn/biến động. Luôn quy định ordering và limit tối đa.

**15. Versioning thế nào?**  
Có thể qua URI, header, media type hoặc query. Ưu tiên backward-compatible evolution và deprecation policy trước khi tạo version mới.

**16. REST, GraphQL và gRPC khác nhau thế nào?**  
REST hướng resource và tận dụng Web; GraphQL cho client chọn graph fields; gRPC hướng method với typed schema/codegen. Chọn theo consumer, latency, query shape, streaming, cache và tooling.

**17. Tăng hiệu năng REST API ra sao?**  
Đo bottleneck rồi áp dụng cache, compression, pagination, projection, index, batching, async processing và tối ưu connection/downstream.

**18. REST API có thể stateful không?**  
Một HTTP API có thể dùng server session, nhưng điều đó vi phạm hoặc làm yếu REST stateless constraint. Resource state phía server thì hoàn toàn bình thường.

**19. REST xử lý security vulnerability ra sao?**  
REST không tự giải quyết. Cần HTTPS, authn/authz, parameterized query, validation, CSRF/XSS controls, rate limit, secret management và monitoring.

#### 20. Các lỗi tư duy thường gặp

- Xem REST là protocol hoặc đồng nhất REST với JSON over HTTP.
- Nghĩ chỉ cần endpoint dùng noun là đã RESTful.
- Hiểu stateless là server/database không lưu state.
- Gắn CRUD máy móc vào domain command phức tạp.
- Dùng `POST` cho mọi operation hoặc dùng `GET` để thay đổi state.
- Cho rằng plural noun là luật REST bắt buộc; đó là convention hữu ích, nhất quán mới là mục tiêu.
- Dùng JWT vì nghĩ “stateless” luôn tốt hơn session mà không có revoke/rotation strategy.
- Nói OAuth dùng để authentication mà bỏ qua OIDC và identity flow.
- Version API quá sớm thay vì thiết kế backward compatibility.
- Dùng offset pagination cho bảng cực lớn/biến động mà không đánh giá consistency.
- Trả `200 OK` cho mọi lỗi.
- Bỏ qua object-level authorization vì endpoint đã có authentication.
- So sánh REST, GraphQL và gRPC bằng nhãn “medium/high/very high” thay vì workload.

#### 21. Câu hỏi tư duy thêm

1. Làm sao mô hình “cancel order” mà không biến URI thành RPC tùy tiện?
2. Khi nào nested resource giúp rõ domain, khi nào gây coupling?
3. Cursor pagination cần chứa thông tin gì để không trùng/bỏ sót record?
4. Làm sao dùng ETag và `If-Match` để ngăn lost update?
5. API có server-side session còn đạt những lợi ích REST nào và mất lợi ích nào?
6. Vì sao cache response có `Authorization` hoặc user data cần đặc biệt cẩn thận?
7. Khi nào `202 Accepted` tốt hơn giữ HTTP connection chờ job hoàn tất?
8. Versioning qua URL ảnh hưởng cache, routing và developer experience thế nào?
9. Một API không dùng HATEOAS có nên tự gọi là RESTful không?
10. Khi nào REST phù hợp hơn GraphQL hoặc gRPC cho public API?

#### 22. Ý chính cần nhớ

- REST là architectural style gồm sáu constraints; HTTP là protocol thường dùng để hiện thực nó.
- Resource khác representation; URI định danh resource, JSON/XML chỉ biểu diễn nó.
- Uniform interface rộng hơn việc dùng đúng HTTP methods và bao gồm HATEOAS.
- Statelessness loại bỏ server-side client session dependency, không loại bỏ resource state.
- Correct method, status code, caching và idempotency làm contract dễ dự đoán và vận hành.
- Resource modeling và backward compatibility quan trọng hơn việc đặt tên endpoint cho đẹp.
- JSON phổ biến nhưng REST không bắt buộc JSON.
- Pagination, caching, concurrency control, rate limit và observability là phần thiết yếu ở quy mô lớn.
- OAuth, JWT và API key giải quyết các bài toán khác nhau; không thể thay thế authorization design.
- REST, SOAP, GraphQL và gRPC có trade-off theo workload; không có lựa chọn nhanh nhất cho mọi trường hợp.

#### Công thức ghi nhớ

> **REST không phải “JSON + HTTP verbs”. REST là một tập constraint xoay quanh resource, representation, stateless interaction, cache và uniform interface; API tốt biến các nguyên tắc đó thành một contract nhất quán, an toàn và có thể tiến hóa.**

---

### Bài 20. Các giao thức giao tiếp thời gian thực

#### 1. “Thời gian thực” nghĩa là gì?

Trong phần lớn web application, **real-time communication** nghĩa là cập nhật được truyền với latency đủ thấp để người dùng cảm thấy hệ thống phản ứng ngay. Đây thường là **soft real-time**, không phải cam kết deadline cứng như trong một số hệ thống điều khiển công nghiệp.

Ví dụ:

- tin nhắn và trạng thái đang nhập trong chat;
- giá thị trường và live dashboard;
- cursor/operation trong collaborative editing;
- thông báo, trạng thái đơn hàng và live sports score;
- telemetry từ thiết bị;
- state update trong multiplayer game.

Không phải mọi dữ liệu trong một ứng dụng “real-time” đều có cùng yêu cầu. Chat message có thể cần durable delivery; cursor movement có thể bỏ qua update cũ; market data cần ordering theo instrument; game state thường ưu tiên update mới hơn retransmission update đã lỗi thời.

#### 2. Vấn đề của request–response truyền thống

HTTP request–response rất phù hợp khi client chủ động hỏi dữ liệu. Khi dữ liệu thay đổi liên tục, việc chờ user refresh không đáp ứng trải nghiệm mong muốn.

Câu hỏi kiến trúc chuyển từ:

> “Khi nào client sẽ hỏi lại?”

thành:

> “Làm sao server chuyển update tới client ngay khi event xuất hiện?”

Bốn mô hình phổ biến:

1. **Short polling** — client hỏi định kỳ.
2. **Long polling** — server giữ request cho tới khi có dữ liệu hoặc timeout.
3. **Server-Sent Events (SSE)** — server stream event một chiều qua HTTP.
4. **WebSocket** — connection lâu dài, hai chiều, truyền message frame.

#### 3. Short polling

Client gửi request theo chu kỳ:

```text
Client ── GET updates ──> Server
Client <── no change ─── Server
        ... đợi 5 giây ...
Client ── GET updates ──> Server
Client <── new data ───── Server
```

**Ưu điểm:**

- đơn giản, dễ debug và tương thích gần như mọi HTTP infrastructure;
- mỗi request độc lập, dễ áp dụng auth, cache, rate limit và autoscaling quen thuộc;
- phù hợp khi latency chấp nhận được và update hiếm.

**Nhược điểm:**

- nhiều request trả về “không có gì mới”;
- latency trung bình phụ thuộc polling interval;
- interval ngắn giảm latency nhưng tăng request load, bandwidth và battery usage;
- spike đồng bộ có thể xuất hiện nếu nhiều client poll cùng lúc.

Nên thêm jitter vào polling schedule và hỗ trợ conditional request/delta token để giảm tải.

#### 4. Long polling

Long polling vẫn dùng HTTP request–response nhưng server trì hoãn response:

1. Client gửi request lấy update.
2. Server giữ request cho đến khi có event hoặc timeout.
3. Server trả event/empty timeout response.
4. Client lập tức tạo request mới để tiếp tục chờ.

```text
Client ── request ───────────────> Server
       (request đang chờ)
Client <────────────── event ───── Server
Client ── request mới ───────────> Server
```

So với short polling, update đến gần như ngay khi server có dữ liệu và giảm response vô ích. Nhưng mỗi batch/update vẫn kết thúc một HTTP exchange rồi tạo exchange mới.

Lưu ý: long polling không nhất thiết tạo TCP/TLS connection mới mỗi lần vì HTTP keep-alive có thể tái sử dụng connection. Overhead chính là các HTTP request cycle lặp lại, timeout/reconnect và tài nguyên cho waiting requests.

Phù hợp khi:

- update không quá dày;
- cần compatibility với HTTP infrastructure cũ hoặc hạn chế;
- triển khai/fallback đơn giản quan trọng hơn full-duplex;
- application đã có request–response API và chỉ cần near-real-time notification.

#### 5. Server-Sent Events — SSE

SSE cho phép server gửi stream event **một chiều từ server tới browser/client** qua HTTP response có media type `text/event-stream`.

```http
GET /notifications/stream HTTP/1.1
Host: api.example.com
Accept: text/event-stream
```

```text
event: order-status
id: 781
data: {"orderId":"o-123","status":"shipped"}

```

Đặc điểm:

- server có thể gửi nhiều event trên một HTTP response lâu dài;
- browser `EventSource` hỗ trợ reconnect; event ID có thể giúp resume bằng `Last-Event-ID`;
- format text đơn giản, tích hợp tốt với HTTP auth/proxy khi được cấu hình đúng;
- client muốn gửi command ngược lên vẫn dùng HTTP request riêng;
- proxy buffering, idle timeout và connection limit phải được kiểm tra;
- phù hợp notification, status stream, live feed và progress update một chiều.

SSE thường đơn giản hơn WebSocket nếu chỉ cần server-to-client. Không nên chọn full-duplex protocol chỉ vì từ “real-time”.

#### 6. WebSocket — persistent full-duplex communication

WebSocket cung cấp kênh message hai chiều lâu dài. Với handshake HTTP/1.1 phổ biến:

```http
GET /chat HTTP/1.1
Host: example.com
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Key: x3JJHMbDL1EzLkh9YZrd6w==
Sec-WebSocket-Version: 13
Origin: https://app.example.com
```

Server chấp nhận:

```http
HTTP/1.1 101 Switching Protocols
Upgrade: websocket
Connection: Upgrade
Sec-WebSocket-Accept: <derived-value>
```

Sau handshake, hai phía không tiếp tục mô hình một HTTP request tương ứng một response. Chúng trao đổi **WebSocket frames** trên connection đã thiết lập:

- client hoặc server có thể gửi bất cứ lúc nào;
- text và binary message được hỗ trợ;
- ping/pong và close là control frame;
- framing nhẹ hơn việc lặp HTTP headers cho từng update.

`Sec-WebSocket-Key` cùng GUID chuẩn được server xử lý để tạo `Sec-WebSocket-Accept`, chứng minh server hiểu WebSocket handshake và giúp tránh một số trường hợp nhầm/cross-protocol. Nó **không phải authentication secret**.

Trong production, dùng `wss://` để bảo vệ connection bằng TLS.

#### 7. WebSocket không thay thế hoàn toàn HTTP

Một ứng dụng thường dùng cả hai:

- HTTP/REST cho login, tải snapshot, CRUD, upload và request ít xảy ra;
- WebSocket cho live event, presence, typing, collaboration hoặc command/response tần suất cao.

WebSocket đem lại transport message channel, nhưng không tự định nghĩa:

- schema của message;
- request ID/correlation;
- authorization cho từng message;
- ordering xuyên nhiều producer;
- delivery guarantee hoặc durable storage;
- replay sau reconnect;
- idempotency/deduplication;
- error model và API versioning.

Application protocol phía trên WebSocket phải định nghĩa các phần đó.

#### 8. So sánh các mô hình

| Tiêu chí | Short polling | Long polling | SSE | WebSocket |
|---|---|---|---|---|
| Chiều giao tiếp chính | Client hỏi, server trả | Client hỏi, server trả trễ | Server → client | Hai chiều |
| Latency | Phụ thuộc interval | Thấp hơn polling | Thấp | Thấp |
| Connection | Request định kỳ | Waiting request lặp lại | Stream lâu dài | Connection lâu dài |
| Overhead/update | Cao nếu poll dày | Vẫn lặp HTTP exchange | Thấp | Thấp |
| Binary data | Qua HTTP bình thường | Qua HTTP bình thường | Chủ yếu text | Có |
| Browser reconnect | Tự viết | Tự viết | `EventSource` hỗ trợ | Application phải tự viết |
| Infrastructure | Dễ nhất | Tương đối dễ | Cần hỗ trợ streaming/no buffering | Cần hỗ trợ upgrade/long-lived connection |
| Phù hợp | Update hiếm, latency vừa | Update không thường xuyên, cần compatibility | Feed/notification một chiều | Chat, game, collaboration, interaction hai chiều |

Không có lựa chọn tốt nhất tuyệt đối. Cần xét event frequency, directionality, acceptable latency, message size, client type, proxy/network support và độ phức tạp vận hành.

#### 9. Kiến trúc WebSocket ở quy mô lớn

```text
Clients
   │  wss://
   ▼
Load Balancer / Realtime Gateway
   │
   ├── Connection Node A ──┐
   ├── Connection Node B ──┼── Broker / Event Bus ── Application Services
   └── Connection Node C ──┘              │
                 │                        └── Durable Event Store
                 └── Presence / Connection Registry
```

Các connection node giữ socket cục bộ. Khi service phát event cho user/channel, routing layer cần biết node nào đang giữ connection đích hoặc broadcast event tới nhóm node phù hợp.

Thành phần thường gặp:

- **Realtime gateway/connection node**: terminate connection, auth, heartbeat, encode/decode frame.
- **Connection registry/presence**: ánh xạ user/channel tới connection/node, thường có TTL.
- **Pub/Sub hoặc event bus**: phân phối event giữa producer và connection nodes.
- **Durable log/store**: lưu message cần replay/audit; không phải mọi pub/sub đều durable.
- **Backpressure/buffer policy**: bảo vệ server trước slow consumer.

Redis Pub/Sub có latency thấp và đơn giản nhưng message là ephemeral, không có replay mặc định. Kafka là durable partitioned log phù hợp pipeline/replay, nhưng không tự giải quyết connection presence hay định tuyến trực tiếp tới từng socket. Chọn broker theo delivery và retention requirement.

#### 10. Load balancing và connection lifecycle

WebSocket dùng được qua load balancer nếu LB/proxy hỗ trợ handshake và connection lâu dài.

- Khi connection đã thiết lập, LB tự nhiên chuyển các frame của connection đó tới cùng backend.
- **Sticky session không bắt buộc** chỉ để giữ một connection đang mở.
- Sticky routing có thể hữu ích khi reconnect hoặc application state còn nằm cục bộ, nhưng shared/externalized state thường giúp scale và failover tốt hơn.
- Cần cấu hình idle timeout, max connection duration, Upgrade headers và capacity phù hợp.
- Khi deploy, dùng **connection draining**: ngừng nhận connection mới, thông báo/retry hợp lý và cho connection cũ kết thúc hoặc migrate qua reconnect.
- Load balancing chỉ theo số connection có thể sai: một connection market feed bận có tải cao hơn nhiều connection idle. Nên cân bằng cả connection count, message rate, bandwidth và CPU.

#### 11. Capacity planning

Với real-time system, **request per second không đủ**. Cần theo dõi:

- số concurrent connections;
- connection establishment/reconnection rate;
- messages và bytes mỗi giây theo hai chiều;
- average/peak fan-out per event;
- memory và file descriptor trên mỗi connection;
- event-loop lag, CPU, network bandwidth;
- queue depth và age của buffered messages;
- slow-consumer count và dropped message rate;
- heartbeat traffic;
- connection duration và regional distribution.

Ví dụ: 1 triệu connection, mỗi connection chỉ nhận 1 KB mỗi 10 giây đã tạo khoảng 100 MB/s payload outbound trước framing, TLS và protocol overhead. Fan-out và bandwidth thường trở thành bottleneck trước CPU xử lý nghiệp vụ.

#### 12. Failure, reconnect và resume

WebSocket browser/client **không tự bảo đảm reconnect hoặc không mất message**. Application cần:

1. phát hiện connection chết qua close/error, heartbeat hoặc inactivity timeout;
2. reconnect bằng exponential backoff + jitter;
3. refresh credential nếu token đã hết hạn;
4. gửi `lastSeenSequence` hoặc resume token;
5. server replay delta còn giữ được;
6. nếu gap quá lớn, client tải snapshot mới rồi tiếp tục stream;
7. deduplicate event đã nhận lặp.

```text
Snapshot tại version 500
        │
        ├── event 501
        ├── event 502   ← connection mất
        ├── event 503
        └── reconnect(lastSeen=502) → replay 503...
```

Nếu hệ thống không có durable history, không thể hứa “reconnect mà không mất message”. Heartbeat chỉ phát hiện connectivity; nó không tạo delivery guarantee.

Ping/pong control frame tồn tại trong WebSocket protocol, nhưng browser JavaScript API không cho application trực tiếp phát protocol ping. Browser app thường dùng application-level heartbeat hoặc dựa vào server/library.

#### 13. Ordering và delivery semantics

TCP giữ byte order trong một connection, nhưng distributed real-time system vẫn có thể đảo thứ tự do:

- nhiều producer hoặc nhiều partitions;
- reconnect sang node khác;
- retry/replay;
- xử lý song song;
- snapshot và live stream giao nhau.

Nên định nghĩa:

- ordering scope: theo user, room, document hay instrument;
- monotonically increasing sequence/version trong scope đó;
- at-most-once, at-least-once hoặc loss-tolerant delivery;
- deduplication key và retention window;
- ACK khi business requirement cần xác nhận application đã xử lý;
- policy khi client chậm: buffer, coalesce, drop update cũ hay disconnect.

Exactly-once end-to-end rất khó; thường thiết kế at-least-once + idempotent/deduplicated processing hoặc snapshot + latest-state semantics.

#### 14. Backpressure và slow consumer

Server có thể tạo event nhanh hơn client đọc. Nếu buffer vô hạn, một client chậm có thể làm cạn memory.

Các policy:

- giới hạn queue theo connection;
- gộp update trạng thái, chỉ giữ bản mới nhất;
- ưu tiên message quan trọng;
- drop telemetry/cursor update có thể mất;
- pause producer/subscription khi hệ thống hỗ trợ;
- disconnect slow consumer và yêu cầu resume từ sequence/snapshot;
- giới hạn message rate và kích thước frame.

Policy phải theo giá trị dữ liệu. Không được drop payment event giống như cursor movement.

#### 15. Authentication và security

- Dùng `wss://`, kiểm tra certificate và TLS policy.
- Authenticate khi handshake hoặc bằng message đầu tiên theo contract; tránh đưa long-lived token vào URL/query vì dễ lọt vào log.
- Kiểm tra `Origin` cho browser WebSocket để giảm Cross-Site WebSocket Hijacking; CORS không tự bảo vệ WebSocket như API `fetch`.
- Authorize từng subscription, room, topic và command; authentication lúc connect chưa đủ.
- Revalidate/revoke quyền cho connection sống lâu khi role hoặc tenant membership thay đổi.
- Giới hạn connection/user/IP, message rate, payload size và subscription count.
- Validate schema, chống injection và không tin message từ client.
- Chống replay/duplicate cho command nhạy cảm.
- Không broadcast dữ liệu tenant A sang connection tenant B vì cache/registry key sai.

#### 16. Chọn protocol theo bài toán

**Dùng short polling khi:** update hiếm, latency vài giây chấp nhận được, simplicity quan trọng.

**Dùng long polling khi:** cần near-real-time qua HTTP compatibility và event không quá dày.

**Dùng SSE khi:** chủ yếu server push một chiều, muốn semantics HTTP và reconnect/resume đơn giản.

**Dùng WebSocket khi:** hai phía trao đổi thường xuyên, latency thấp, connection lâu dài và application chấp nhận complexity quản lý state/recovery.

Một số lưu ý theo use case:

- **Chat**: WebSocket hợp lý, nhưng message history/delivery cần durable store và ACK/dedup riêng.
- **Notification**: SSE hoặc long polling có thể đủ; mobile background thường còn phụ thuộc push notification service của OS.
- **Collaborative editing**: WebSocket cho operation stream; cần versioning, conflict resolution/OT/CRDT.
- **Market data**: WebSocket/SSE tùy chiều giao tiếp; cần sequence, subscription và slow-consumer policy.
- **Multiplayer game**: WebSocket phù hợp nhiều game web, nhưng fast-twitch game có thể cần UDP/QUIC-based transport và loss-tolerant update.
- **Live video/audio**: thường dùng WebRTC/media protocols hoặc HTTP streaming; WebSocket không mặc nhiên là lựa chọn tốt nhất.

#### 17. Webhook không giống WebSocket

Webhook là server-to-server HTTP callback khi event xảy ra:

- không giữ connection lâu dài;
- producer gửi HTTP request tới consumer endpoint;
- phù hợp payment event, CI/CD, SaaS integration;
- cần signature verification, retry, idempotency và dead-letter handling.

Webhook có thể “gần thời gian thực” nhưng là event delivery giữa server, không phải kênh tương tác full-duplex với browser.

#### 18. Câu hỏi phỏng vấn từ tài liệu phụ

**1. Real-time communication là gì và vì sao quan trọng?**  
Là truyền update với latency đủ thấp cho use case. Nó tạo trải nghiệm live và cần thiết cho chat, market data, game, collaboration, telemetry; “real-time” không đồng nghĩa latency bằng 0.

**2. WebSocket hoạt động thế nào và khác HTTP request–response ra sao?**  
WebSocket thiết lập message channel full-duplex lâu dài sau handshake. HTTP vẫn có persistent connection, nhưng semantics thông thường vẫn là client request–server response.

**3. Mô tả WebSocket handshake.**  
Client yêu cầu upgrade với các WebSocket headers; server chấp nhận bằng `101 Switching Protocols` và `Sec-WebSocket-Accept`; sau đó hai bên trao đổi frame. `Sec-WebSocket-Key` không phải credential.

**4. Long polling là gì?**  
Server giữ HTTP request tới khi có event/timeout, trả response rồi client lập tức mở request mới.

**5. WebSocket có lợi gì so với long polling?**  
Full-duplex, ít HTTP exchange/header lặp lại và phù hợp event tần suất cao. Đổi lại, connection lifecycle, recovery và capacity phức tạp hơn.

**6. Khi nào chọn long polling?**  
Update thưa, HTTP compatibility quan trọng, environment không hỗ trợ connection upgrade tốt hoặc cần fallback đơn giản.

**7. WebSocket xử lý connection failure thế nào?**  
Protocol không tự phục hồi application state. Client/server phải có heartbeat, reconnect backoff+jitter, resume/replay hoặc snapshot và deduplication.

**8. WebSocket có dùng qua load balancer được không?**  
Có. LB cần hỗ trợ handshake và long-lived connection. Sticky session không mặc nhiên bắt buộc; shared state, connection registry, draining và timeout đúng mới là điểm cốt lõi.

**9. Thách thức khi scale WebSocket là gì?**  
Concurrent connection, fan-out/bandwidth, routing tới đúng node, presence, slow consumer, reconnect storm, ordering, message durability, deployment draining và observability.

#### 19. Các lỗi tư duy thường gặp

- Viết nhầm **polling** thành “pooling”; đây là hai khái niệm khác nhau.
- Nghĩ real-time nghĩa là tức thời tuyệt đối hoặc không có latency.
- Cho rằng HTTP luôn đóng TCP connection sau mỗi response; HTTP hiện đại thường tái sử dụng connection.
- Chọn WebSocket cho mọi notification dù chỉ cần server-to-client SSE.
- Cho rằng WebSocket tự reconnect và không mất message.
- Đồng nhất TCP ordered delivery với global event ordering.
- Nghĩ ping/pong đồng nghĩa message đã được application xử lý.
- Cho rằng sticky session là cách duy nhất để scale WebSocket.
- Dùng Redis Pub/Sub rồi hứa replay/durability dù Pub/Sub mặc định không lưu history.
- Chỉ capacity plan theo connection count mà bỏ qua bandwidth và fan-out.
- Buffer vô hạn cho slow consumer.
- Authenticate lúc connect nhưng không authorize từng subscription/message.
- Dùng WebSocket cho live video/game networking mà không đánh giá protocol chuyên dụng.

#### 20. Câu hỏi tư duy thêm

1. Nếu 1 event phải fan-out tới 5 triệu client, bottleneck nằm ở đâu?
2. Client reconnect sau 30 giây mất mạng: làm sao khôi phục đúng thứ tự và không trùng?
3. Khi nào nên drop event cũ thay vì buffer/replay?
4. SSE có lợi gì so với WebSocket cho progress update một chiều?
5. Làm sao deploy connection node mà không ngắt đồng loạt hàng triệu client?
6. Nếu load balancer idle-timeout là 60 giây, heartbeat interval nên được thiết kế ra sao?
7. Presence registry sai lệch sẽ gây loại lỗi nào?
8. Redis Pub/Sub, Kafka và durable database giải quyết các phần khác nhau thế nào?
9. Tại sao reconnect storm có thể đánh sập auth service dù realtime nodes còn capacity?
10. Với collaborative editing, snapshot và operation stream cần ghép theo version nào?

#### 21. Ý chính cần nhớ

- Real-time là latency target theo business, không phải “zero latency”.
- Polling, long polling, SSE và WebSocket giải quyết cùng nhu cầu bằng communication model khác nhau.
- SSE phù hợp server-to-client stream; WebSocket phù hợp full-duplex interaction.
- WebSocket bắt đầu bằng handshake tương thích HTTP nhưng sau đó dùng message frames.
- Persistent connection giảm per-message overhead nhưng tăng complexity quản lý lifecycle và capacity.
- WebSocket không tự cung cấp reconnect, replay, global ordering, exactly-once hoặc domain authorization.
- Scale cần connection registry, pub/sub/event bus, durable history và backpressure policy phù hợp.
- Sticky session có thể hữu ích nhưng không phải điều kiện bắt buộc để WebSocket qua load balancer.
- Capacity phải đo connection, message rate, fan-out, bytes, buffer và slow consumer.
- Chọn protocol theo directionality, frequency, latency, delivery semantics, client và infrastructure.

#### Công thức ghi nhớ

> **Polling hỏi lại; long polling chờ câu trả lời; SSE stream một chiều; WebSocket trò chuyện hai chiều. Protocol chỉ tạo kênh — reliability, ordering, replay, authorization và backpressure vẫn là trách nhiệm của thiết kế hệ thống.**

---

### Bài 21. Các giao thức API hiện đại ngoài REST — gRPC và GraphQL

#### 1. Vì sao cần những lựa chọn ngoài REST?

REST vẫn phù hợp với rất nhiều public API và resource-oriented workflow. Nhưng một số hệ thống gặp các nhu cầu khác:

- service-to-service call dày đặc cần payload gọn, latency thấp và contract mạnh;
- client web/mobile cần các lát cắt dữ liệu khác nhau cho cùng domain;
- một màn hình phải tổng hợp dữ liệu từ nhiều backend;
- cần client/server streaming trên một contract typed;
- nhiều ngôn ngữ cần sinh SDK đồng nhất;
- over-fetching, under-fetching hoặc nhiều round trip trở thành bottleneck thực tế.

Hai hướng tiếp cận phổ biến:

- **gRPC** tối ưu remote procedure call, đặc biệt cho giao tiếp nội bộ giữa service.
- **GraphQL** cung cấp typed graph API để client chọn shape dữ liệu cần lấy.

Chúng không làm REST lỗi thời và cũng không giải quyết cùng một vấn đề. Một kiến trúc có thể dùng cả ba ở các boundary khác nhau.

#### 2. Over-fetching và under-fetching

**Over-fetching**: server trả nhiều field hơn client cần.

```text
Mobile screen chỉ cần: user.name, user.avatar
REST response trả: toàn bộ profile, address, preferences, history...
```

**Under-fetching**: một response chưa đủ để hoàn thành use case, khiến client gọi thêm endpoint.

```text
GET /users/u-1
GET /users/u-1/preferences
GET /users/u-1/notifications
GET /users/u-1/activity
```

Đây không phải nhược điểm không thể khắc phục của REST. Có thể dùng tailored endpoint, BFF, sparse fieldset, include/expand hoặc API composition. GraphQL chuẩn hóa một cách tiếp cận linh hoạt hơn, nhưng chuyển độ phức tạp từ client/network sang schema, resolver và backend execution.

---

#### Nhánh A — gRPC

#### 3. gRPC là gì?

**gRPC** là RPC framework cho phép client gọi method của remote service dựa trên contract đã định nghĩa. Stack phổ biến:

```text
Service contract (.proto)
        │
        ├── sinh client stub
        ├── sinh server interface
        ▼
Protocol Buffers messages
        ▼
gRPC framing trên HTTP/2
        ▼
TCP + TLS (thường dùng trong production)
```

gRPC thường dùng:

- **Protocol Buffers** để định nghĩa schema và serialize binary message;
- **HTTP/2** để multiplex nhiều stream trên connection;
- code generation cho nhiều ngôn ngữ;
- deadline, cancellation, metadata, status và interceptor theo framework.

Binary format không tự động bảo đảm nhanh hơn trong mọi workload. Lợi ích thực tế phụ thuộc message size, call frequency, network, CPU serialization, connection reuse và implementation.

#### 4. Contract bằng Protocol Buffers

```proto
syntax = "proto3";

package order.v1;

service OrderService {
  rpc GetOrder(GetOrderRequest) returns (Order);
  rpc WatchOrders(WatchOrdersRequest) returns (stream OrderEvent);
}

message GetOrderRequest {
  string order_id = 1;
}

message Order {
  string id = 1;
  string status = 2;
  int64 created_at_epoch_ms = 3;
}
```

`.proto` là source of truth cho message và service method. Tooling có thể sinh type, client stub và server skeleton, giúp giảm sai khác contract giữa Java, Go, Python, C#...

**Schema evolution:**

- thêm field mới với field number mới thường tương thích;
- không đổi meaning/type tùy tiện;
- không tái sử dụng field number đã xóa; nên `reserved` chúng;
- cân nhắc presence/default semantics;
- enum và `oneof` cần evolution policy;
- contract test và staged rollout vẫn cần thiết dù có code generation.

Code generation giảm boilerplate, không thay thế backward compatibility design.

#### 5. Bốn kiểu RPC của gRPC

| Kiểu | Request | Response | Ví dụ |
|---|---|---|---|
| **Unary** | Một | Một | Lấy order theo ID |
| **Server streaming** | Một | Nhiều | Theo dõi event/telemetry |
| **Client streaming** | Nhiều | Một | Upload nhiều chunk/measurement |
| **Bidirectional streaming** | Nhiều | Nhiều | Trao đổi liên tục hai chiều |

Streaming là một phần của gRPC contract và HTTP/2 stream. Tuy vậy, application vẫn phải thiết kế ordering, backpressure, retry/resume và delivery semantics.

#### 6. Vì sao gRPC thường hiệu quả?

- Protobuf thường nhỏ hơn JSON cho structured message.
- Binary encoding giảm parse/serialization cost trong nhiều workload.
- HTTP/2 multiplex nhiều RPC trên một connection.
- Header compression và persistent connection giảm overhead lặp lại.
- Streaming tránh tạo một RPC mới cho từng message.
- Generated stub giảm parsing/routing thủ công ở application layer.

Nhưng cần nhớ:

- HTTP/2 thường chạy trên một TCP connection, nên packet loss vẫn có thể gây TCP-level head-of-line blocking cho các stream trên connection đó;
- payload nhỏ không giúp nếu latency chủ yếu nằm ở database hoặc fan-out downstream;
- một connection có quá nhiều concurrent stream có thể thành hotspot;
- benchmark phải dùng payload và concurrency giống production.

#### 7. Khi nào dùng gRPC?

Phù hợp:

- internal microservice communication;
- call frequency cao, latency/bandwidth quan trọng;
- polyglot system muốn contract và SDK generation;
- telemetry, IoT hoặc edge link cần message gọn;
- unary + streaming trên cùng service interface;
- organization kiểm soát cả client và server rollout.

Cần cân nhắc lựa chọn khác khi:

- public API cho developer muốn gọi bằng browser/cURL đơn giản;
- intermediary/CDN/HTTP cache semantics rất quan trọng;
- consumer không dùng được generated client/toolchain;
- human readability và debugging thô là ưu tiên cao;
- hạ tầng proxy/load balancer chưa hỗ trợ HTTP/2 gRPC end-to-end tốt.

Browser không hỗ trợ native gRPC giống backend client. **gRPC-Web** hoặc gateway có thể làm cầu nối nhưng có capability/streaming và operational trade-off riêng.

#### 8. Deadline, cancellation và retry

Mỗi RPC nên có deadline. Không đặt deadline khiến request treo, giữ resource và khuếch đại failure.

```text
Client deadline: 800 ms
  ├── Gateway: 700 ms
  ├── Service A: 500 ms
  └── Database: 300 ms
```

- Propagate deadline/cancellation xuống downstream.
- Server nên dừng công việc không còn giá trị khi client đã cancel.
- Chỉ retry transient error theo policy và remaining deadline.
- Retry write cần idempotency hoặc deduplication.
- Dùng backoff, jitter và retry budget để tránh retry storm.
- Không retry stream dài từ đầu nếu có thể resume từ checkpoint/sequence.

#### 9. gRPC status và error model

gRPC có status model riêng như:

- `OK`
- `INVALID_ARGUMENT`
- `UNAUTHENTICATED`
- `PERMISSION_DENIED`
- `NOT_FOUND`
- `ALREADY_EXISTS`
- `FAILED_PRECONDITION`
- `ABORTED`
- `RESOURCE_EXHAUSTED`
- `UNAVAILABLE`
- `DEADLINE_EXCEEDED`
- `INTERNAL`

Chọn code theo semantics để client quyết định retry hay sửa request. Error detail có thể mang structured metadata, nhưng không được lộ stack trace, secret hoặc internal topology.

#### 10. Security trong gRPC

- TLS bảo vệ confidentiality/integrity và xác thực server.
- mTLS xác thực cả workload/client certificate, thường dùng service-to-service.
- Credential/token có thể truyền qua metadata; phải bảo vệ khỏi log và validate issuer, audience, expiry, scope.
- OAuth 2.0 là authorization framework; JWT là token format, không đồng nghĩa với authentication.
- API key không mặc nhiên an toàn hơn và không nên là lựa chọn duy nhất cho workload identity nhạy cảm.
- Authorization phải ở service/method/resource level, không chỉ ở interceptor “đã login”.
- Rate limit theo identity/method/cost; giới hạn message size và stream duration.
- Rotate certificate/key và dùng secret manager.
- Interceptor hỗ trợ auth, logging, metrics, trace và policy nhưng phải tránh biến thành lớp logic khó kiểm soát.

#### 11. Scale và vận hành gRPC

- Service discovery và client-side/proxy load balancing phải hiểu endpoint health.
- Dùng health checking, connection draining và graceful shutdown khi deploy.
- Long-lived HTTP/2 connection có thể làm traffic phân bố không đều sau khi scale out; cân nhắc connection age/rebalancing.
- Theo dõi RPC latency theo method/status, active streams, messages/bytes, deadline exceeded, retry và saturation.
- Trace metadata cần truyền qua service chain.
- Reflection hữu ích khi debug nhưng cần security policy phù hợp.

---

#### Nhánh B — GraphQL

#### 12. GraphQL là gì?

**GraphQL** là query language cho API cùng execution model dựa trên typed schema. Client mô tả các field cần lấy; server chạy resolver và trả response có shape tương ứng.

GraphQL thường dùng một HTTP endpoint, nhưng “một endpoint” không phải bản chất duy nhất. Cốt lõi là schema, type system, operation và field selection.

Ba operation type chính:

- **Query**: đọc dữ liệu.
- **Mutation**: thay đổi state.
- **Subscription**: nhận result theo event/stream theo transport được chọn.

#### 13. Schema và query

```graphql
type User {
  id: ID!
  name: String!
  recentOrders(first: Int!, after: String): OrderConnection!
}

type Query {
  user(id: ID!): User
}
```

Client chọn field:

```graphql
query UserSummary($id: ID!) {
  user(id: $id) {
    id
    name
    recentOrders(first: 3) {
      edges {
        node {
          id
          status
        }
      }
    }
  }
}
```

Response mirrors query shape:

```json
{
  "data": {
    "user": {
      "id": "u-1",
      "name": "An",
      "recentOrders": {
        "edges": [
          {"node": {"id": "o-9", "status": "SHIPPED"}}
        ]
      }
    }
  }
}
```

GraphQL giảm over-fetching ở boundary vì client chọn field, nhưng server vẫn có thể đọc thừa hoặc gọi nhiều downstream nếu resolver không được tối ưu.

#### 14. Resolver và aggregation layer

Mỗi field có thể được resolver lấy từ database, cache, REST API, gRPC service hoặc nguồn khác:

```text
Web/Mobile Client
       │ GraphQL query
       ▼
GraphQL Gateway / BFF
       ├── User service (gRPC)
       ├── Order service (gRPC/REST)
       ├── Recommendation service
       └── Cache / Database
```

GraphQL có thể che giấu topology backend khỏi frontend và tạo contract thống nhất. Đổi lại, gateway trở thành nơi orchestration, authorization, query planning và observability phức tạp.

Một request GraphQL duy nhất ở client không có nghĩa backend chỉ thực hiện một call; nó có thể fan-out thành hàng chục/hàng trăm operation.

#### 15. N+1 problem và DataLoader

Ví dụ query lấy 100 users và orders của từng user:

```text
1 query lấy 100 users
+ 100 query lấy orders theo từng user
= 101 database/downstream calls
```

Mitigation:

- batch các ID thành một query/call;
- preload/join phù hợp access pattern;
- DataLoader-style batching;
- cache trong phạm vi request để cùng key không load lặp;
- giới hạn pagination và selection.

**DataLoader không phải distributed cache hoặc response cache tổng quát.** Nó thường batch và memoize trong request context; cache xuyên user/request cần thiết kế invalidation, tenancy và authorization riêng.

#### 16. Caching trong GraphQL

GraphQL query thường có response động nên HTTP URL-based caching kém trực tiếp hơn REST. Có nhiều lớp:

- **Normalized client cache**: lưu entity theo type/ID và ghép response phía client.
- **Resolver/data-source cache**: cache kết quả đọc downstream.
- **Response/result cache**: cache toàn bộ result theo query + variables + identity/context.
- **Persisted query**: client gửi query ID/hash thay vì document đầy đủ; hỗ trợ allowlist và có thể giúp CDN khi dùng GET đúng cách.
- **CDN/edge cache**: khả thi cho persisted public query với cache key/policy rõ ràng.

Apollo Client cache, Redis và CDN giải quyết các lớp khác nhau; không thể gọi chung là một “GraphQL cache”. User-specific response cần key và authorization cực kỳ cẩn thận.

#### 17. Query complexity và bảo vệ backend

GraphQL cho client quyền chọn query shape, vì vậy rate limit chỉ theo “một request” là chưa đủ.

Cần cân nhắc:

- maximum depth;
- field cost/complexity score;
- list multiplier và pagination limit;
- timeout/deadline;
- maximum aliases, directives, variables và document size;
- persisted query/allowlist cho trusted client;
- concurrency limit theo user/tenant;
- resolver-level budget và downstream fan-out;
- introspection policy theo môi trường/threat model.

```graphql
# Một request nhưng có thể rất đắt nếu không giới hạn
query {
  organizations(first: 100) {
    users(first: 100) {
      orders(first: 100) {
        items { product { reviews { author { friends { id } } } } }
      }
    }
  }
}
```

Depth limit một mình chưa đủ: query nông với list cardinality lớn vẫn rất đắt. Cost model nên phản ánh fan-out thực tế.

#### 18. Error và partial response

GraphQL response có thể chứa cả `data` và `errors`:

```json
{
  "data": {
    "user": {
      "name": "An",
      "billingProfile": null
    }
  },
  "errors": [
    {
      "message": "Billing service unavailable",
      "path": ["user", "billingProfile"],
      "extensions": {"code": "UPSTREAM_UNAVAILABLE"}
    }
  ]
}
```

HTTP response có thể là `200` dù một field lỗi, vì GraphQL execution đã tạo partial result. Monitoring không được chỉ nhìn HTTP status; phải theo dõi GraphQL error code/path và resolver/downstream latency.

Nullability (`!`) ảnh hưởng error propagation: lỗi ở non-null field có thể làm parent trở thành null. Schema design cần cân bằng contract mạnh với khả năng degraded response.

#### 19. GraphQL mutation và idempotency

Mutation không tự động transactional hoặc idempotent. Một request có thể gọi nhiều resolver/service.

- đặt mutation theo domain intent rõ ràng;
- dùng input type và structured payload/error;
- idempotency key cho create/payment retry;
- optimistic concurrency/version khi update;
- định nghĩa transaction boundary và partial failure;
- không dựa vào client retry mù khi network timeout.

```graphql
mutation CreatePayment($input: CreatePaymentInput!) {
  createPayment(input: $input) {
    payment { id status }
    userErrors { code field message }
  }
}
```

#### 20. GraphQL subscriptions

Subscription cho phép client nhận result theo event. WebSocket là transport phổ biến, nhưng không phải lựa chọn duy nhất; SSE hoặc transport khác có thể được dùng tùy protocol/implementation.

Subscription layer vẫn cần:

- authentication khi connect và reauthorization khi quyền đổi;
- mapping event tới subscriber;
- connection scale, heartbeat và reconnect;
- durable event/replay nếu hứa không mất dữ liệu;
- backpressure và slow-consumer policy;
- filter theo tenant/object để tránh data leak.

GraphQL subscription không biến GraphQL thành message broker và không tự cung cấp exactly-once.

#### 21. Schema evolution và federation

GraphQL thường tiến hóa theo hướng additive:

- thêm field/type mới;
- đánh dấu field cũ `@deprecated`;
- đo usage trước khi xóa;
- tránh đổi type/nullability/meaning gây breaking;
- duy trì schema registry, lint, contract check và ownership.

**Federation** chia graph thành subgraph do các team/domain quản lý và gateway/router lập query plan. Nó hữu ích cho organizational scale nhưng thêm:

- distributed schema governance;
- cross-subgraph latency/fan-out;
- entity ownership/key complexity;
- partial failure và observability;
- nguy cơ tạo “distributed monolith” nếu boundary kém.

Federation không phải bước bắt buộc để “scale GraphQL”. Bắt đầu với schema/resource boundary rõ và chỉ phân tán khi organizational/domain need biện minh complexity.

#### 22. Security trong GraphQL

- Authenticate ở gateway, authorize ở object/field/action thích hợp.
- Không chỉ ẩn field khỏi UI; server phải kiểm tra quyền.
- Ngăn IDOR/object-level authorization failure khi client đổi ID.
- Query cost, rate limit và timeout chống resource exhaustion.
- Giới hạn pagination, upload và response size.
- Redact error, query variable và PII khỏi log.
- Persisted query/allowlist giảm arbitrary query surface nhưng không thay thế authorization.
- Bảo vệ subscription suốt lifecycle.
- Schema/introspection có thể làm lộ domain model; quyết định policy theo threat model, không coi tắt introspection là biện pháp duy nhất.

#### 23. Scale GraphQL thực tế

1. Stateless GraphQL execution nodes sau load balancer khi có thể.
2. Batch/load downstream hợp lý, loại bỏ N+1.
3. Cursor pagination và server-side limit.
4. Query cost/depth/time budget.
5. Cache đúng lớp và đúng identity.
6. Persisted query cho trusted/high-volume client.
7. Theo dõi latency/error theo operation name, field/resolver và downstream.
8. Giới hạn fan-out, concurrency và retry.
9. Federation chỉ khi domain/team scale yêu cầu.
10. Capacity plan theo query mix/cost, không chỉ requests per second.

Autoscaling GraphQL server không giúp nếu bottleneck thật sự là database, downstream hoặc một resolver N+1.

---

#### Nhánh C — Chọn REST, gRPC hay GraphQL

#### 24. Bảng so sánh

| Tiêu chí | REST | gRPC | GraphQL |
|---|---|---|---|
| Mô hình | Resource-oriented architectural style | RPC framework | Typed graph query API |
| Contract | HTTP semantics + schema/OpenAPI tùy chọn | `.proto` service/message | GraphQL schema |
| Payload phổ biến | JSON/XML/media khác | Protobuf binary | Thường JSON |
| Transport phổ biến | HTTP/1.1, HTTP/2, HTTP/3 | HTTP/2 | HTTP; subscription tùy transport |
| Shape response | Server/API contract quyết định | Method contract quyết định | Client chọn fields trong schema |
| Streaming | Có thể dùng HTTP streaming/SSE/WebSocket bên cạnh | Native server/client/bidi streaming | Subscription; transport tùy implementation |
| Caching | Tận dụng HTTP/CDN tự nhiên | Thường application/interceptor cache | Client/resolver/result/persisted-query cache |
| Browser/public DX | Rất tốt | Cần gRPC-Web/gateway | Tốt với GraphQL tooling |
| Điểm mạnh | Simplicity, interoperability, HTTP ecosystem | Efficient typed service communication | Flexible frontend data access/aggregation |
| Rủi ro chính | Over/under-fetch, nhiều endpoint/call | Tooling, binary debugging, browser/proxy compatibility | Query cost, N+1, cache/auth/federation complexity |

Không nên gắn nhãn tuyệt đối “REST chậm, gRPC nhanh, GraphQL vừa”. Performance phải đo theo:

- payload và serialization;
- số round trip và fan-out;
- connection/transport;
- cache hit ratio;
- resolver/database/downstream cost;
- concurrency và tail latency;
- operational maturity.

#### 25. Kiến trúc kết hợp

```text
Web / Mobile
     │
     ├── GraphQL BFF ─────┐
     │                    │
Partners ── REST API ── API Gateway
                          │
                          ├── gRPC → User Service
                          ├── gRPC → Order Service
                          └── gRPC → Recommendation Service
```

- REST phục vụ public/partner API nhờ HTTP semantics và adoption rộng.
- GraphQL làm BFF/aggregation cho frontend có data need đa dạng.
- gRPC kết nối internal services với typed contract và streaming.

Đây chỉ là pattern, không phải mặc định. Mỗi protocol thêm toolchain, gateway, observability và skill requirement; không nên dùng cả ba nếu một lựa chọn đơn giản đã đủ.

#### 26. Khung ra quyết định

1. Consumer là browser, mobile, partner hay service nội bộ?
2. Client có cần chọn field/aggregate graph linh hoạt không?
3. Latency nằm ở network/serialization hay database/business logic?
4. Cần unary, server stream hay bidirectional stream?
5. Contract có cần code generation và strong typing xuyên ngôn ngữ?
6. HTTP/CDN caching có quan trọng không?
7. Ai kiểm soát rollout của client và server?
8. Hạ tầng có hỗ trợ HTTP/2, proxying, observability và debugging không?
9. Query/call có fan-out thế nào và failure bị khuếch đại ra sao?
10. Team có đủ operational maturity cho schema governance/federation/streaming không?

#### 27. Câu hỏi phỏng vấn từ tài liệu phụ

**1. So sánh REST, gRPC và GraphQL.**  
REST hướng resource và tận dụng HTTP ecosystem; gRPC hướng typed RPC, Protobuf và streaming; GraphQL cho client chọn field trên typed graph. Không xếp hạng performance nếu chưa có workload.

**2. Khi nào dùng gRPC thay REST?**  
Khi giao tiếp nội bộ có call volume cao, cần contract/codegen đa ngôn ngữ, payload gọn hoặc native streaming và organization kiểm soát hai đầu. REST thường thực dụng hơn cho public/browser API và HTTP caching.

**3. Trade-off của GraphQL ở quy mô lớn?**  
Giảm over/under-fetch và hợp nhất data access, nhưng làm query execution, cost control, N+1, cache, authorization, partial failure và schema governance phức tạp hơn.

**4. gRPC xử lý authentication/security thế nào?**  
Dùng TLS/mTLS cho transport/workload identity, credential qua metadata khi phù hợp, authorization theo method/resource, rate limit, validation, key rotation và observability qua interceptor. OAuth không đồng nghĩa JWT authentication.

**5. Scale GraphQL hiệu quả thế nào?**  
Batch N+1, pagination, query-cost/deadline, cache đúng lớp, persisted query, horizontal execution nodes, downstream capacity protection và observability theo resolver. Federation chỉ khi domain/team scale cần nó.

#### 28. Các lỗi tư duy thường gặp

- Cho rằng REST mặc nhiên chậm vì dùng JSON; REST không bắt buộc JSON và bottleneck có thể nằm nơi khác.
- Nói REST không hỗ trợ streaming; HTTP streaming, SSE và WebSocket vẫn có thể kết hợp.
- Chọn gRPC chỉ vì “binary nhanh hơn” mà không benchmark end-to-end.
- Nghĩ Protobuf/codegen tự giải quyết schema evolution.
- Không đặt deadline cho internal RPC.
- Retry gRPC write mà không có idempotency.
- Cho rằng một GraphQL request luôn tương đương một backend call.
- Dùng DataLoader như distributed cache xuyên request/user.
- Rate limit GraphQL chỉ theo request count, bỏ qua query cost.
- Nghĩ depth limit đủ chặn mọi query đắt.
- Coi HTTP `200` là GraphQL không có lỗi.
- Cho rằng GraphQL subscription bắt buộc WebSocket hoặc tự bảo đảm delivery.
- Dùng federation như giải pháp performance mặc định.
- Dùng OAuth, JWT, mTLS và API key như các từ đồng nghĩa.

#### 29. Câu hỏi tư duy thêm

1. Khi nào một GraphQL query giảm round trip nhưng lại tăng tail latency phía server?
2. Làm sao đặt deadline cho chuỗi gRPC fan-out mà vẫn còn thời gian trả response?
3. Protobuf field nào có thể thêm an toàn và thay đổi nào gây breaking?
4. Vì sao một long-lived HTTP/2 connection có thể làm scale-out gRPC không cân bằng ngay?
5. Query-cost model phải tính list cardinality như thế nào?
6. GraphQL partial error nên ánh xạ vào SLO và alert ra sao?
7. Cache GraphQL response theo user/tenant thế nào để không rò dữ liệu?
8. Khi nào BFF REST đơn giản tốt hơn dựng GraphQL gateway?
9. Khi nào gRPC-Web đủ và khi nào nên đặt REST/GraphQL gateway trước gRPC service?
10. Một architecture dùng cả REST, GraphQL và gRPC cần thống nhất trace/error/identity context ra sao?

#### 30. Ý chính cần nhớ

- gRPC và GraphQL giải quyết hai nhóm nhu cầu khác nhau, không phải hai phiên bản thay thế REST.
- gRPC kết hợp typed RPC, Protobuf, HTTP/2 và code generation; mạnh ở internal service communication và streaming.
- Deadline, cancellation, retry/idempotency, load balancing và schema evolution quyết định reliability của gRPC.
- GraphQL cho client chọn response shape trên typed schema và rất phù hợp BFF/aggregation.
- Flexibility của GraphQL làm query planning, N+1, caching, authorization và cost control khó hơn.
- DataLoader chủ yếu batch/memoize trong request; federation chủ yếu giải quyết schema/domain organization.
- Không có protocol nhanh nhất tuyệt đối; cần benchmark bottleneck end-to-end.
- REST, GraphQL và gRPC có thể cùng tồn tại ở các system boundary khác nhau.
- Lựa chọn protocol là lựa chọn cả ecosystem vận hành, không chỉ wire format.

#### Công thức ghi nhớ

> **REST tối ưu sự phổ quát của Web; gRPC tối ưu typed service calls; GraphQL tối ưu sự linh hoạt của client query. Hãy chọn theo boundary và bottleneck, không chọn theo bảng xếp hạng công nghệ.**

---

## Phần 4 — Architecture Patterns

### Bài 23. Giới thiệu về Architectural Patterns

#### 1. Software architecture là gì?

Software architecture là tập hợp những quyết định nền tảng xác định:

- các thành phần lớn của hệ thống;
- trách nhiệm và boundary của từng thành phần;
- dependency và cách chúng giao tiếp;
- data ownership và data flow;
- cách hệ thống được build, deploy, scale, bảo vệ và vận hành;
- các constraint khó hoặc tốn kém để thay đổi về sau.

Diagram, layer và technology chỉ là biểu hiện của kiến trúc. Mục tiêu thật sự là biến business requirements thành một hệ thống có thể hoạt động hôm nay và tiếp tục tiến hóa khi tải, đội ngũ và yêu cầu thay đổi.

#### 2. Architecture quyết định hành vi khi hệ thống lớn lên

Một implementation có thể đúng về chức năng nhưng kiến trúc vẫn thất bại ở production. Các câu hỏi kiến trúc thường là:

- Traffic tăng 10 lần thì bottleneck nào xuất hiện trước?
- Có scale riêng phần nóng hay phải scale cả hệ thống?
- Một dependency lỗi có làm request chain sụp đổ không?
- Team có thể thay đổi một module mà không gây regression diện rộng không?
- Có deploy độc lập hay phải phối hợp toàn tổ chức?
- Dữ liệu có nhất quán đủ cho business invariant không?
- Debug một transaction xuyên nhiều thành phần mất bao lâu?
- Chi phí hạ tầng và vận hành có phù hợp giá trị kinh doanh không?

Architecture tác động trực tiếp đến các **quality attributes** như scalability, performance, reliability, maintainability, security, evolvability và operability.

#### 3. Ba mối quan tâm cốt lõi của phần học

**Scalability** — hệ thống có tăng capacity theo demand không, scale theo chiều nào và với chi phí gì?

**Maintainability** — thay đổi có localized, dễ test, dễ review và ít rủi ro không?

**Performance** — latency, throughput và resource efficiency có đạt mục tiêu dưới tải thật không?

Ba thuộc tính này không độc lập. Tách hệ thống thành service có thể giúp team deploy và scale độc lập, nhưng thêm network latency, failure mode và operational burden. Cache có thể tăng performance nhưng làm invalidation và correctness khó hơn. Architecture luôn là bài toán trade-off.

#### 4. Architectural pattern dùng để làm gì?

Architectural pattern/style cung cấp vocabulary và cấu trúc đã được kiểm chứng cho vấn đề lặp lại. Nó giúp team:

- thảo luận bằng mental model chung;
- nhận diện sớm ưu/nhược điểm;
- tránh thiết kế lại từ số 0;
- dự đoán failure mode và operational requirement;
- giải thích quyết định với stakeholder.

Pattern không phải template để sao chép nguyên xi. Một hệ thống thực tế thường kết hợp nhiều style ở các scope khác nhau, ví dụ modular monolith ở application boundary, layered design bên trong module và event-driven integration cho một workflow.

#### 5. Lộ trình phần 4

Phần này đi từ khái niệm tới quyết định thực tế:

1. Các style/pattern phổ biến và trade-off.
2. Multi-tier architecture.
3. Microservices architecture.
4. Event-driven architecture.
5. Cách kết hợp pattern và chọn kiến trúc theo requirements.

Mục tiêu không phải ghi nhớ tên pattern, mà xây khả năng trả lời: **pattern này giải quyết constraint nào, tạo ra complexity nào và team có đủ năng lực vận hành nó không?**

#### 6. Nguyên tắc mở đầu

- Bắt đầu từ business capability, quality attributes và constraint.
- Chọn kiến trúc đơn giản nhất còn đáp ứng yêu cầu đã biết.
- Không tối ưu cho một tương lai giả định mà không có evidence.
- Thiết kế boundary rõ trước khi phân tán deployment.
- Đánh giá cả build cost, change cost và run cost.
- Ghi lại quyết định, alternative và consequence.
- Architecture là evolutionary: đo, học và thay đổi có kiểm soát.

#### Công thức ghi nhớ

> **Architecture không phải bộ diagram; đó là những quyết định khó thay đổi, định hình cách hệ thống scale, thất bại, vận hành và tiến hóa. Pattern chỉ có giá trị khi phù hợp constraint cụ thể.**

---

### Bài 24. Software Architecture Patterns & Styles

#### 1. Pattern, style và tactic

Trong thực tế, “architecture pattern” và “architecture style” thường được dùng lẫn nhau. Có thể hiểu hữu ích như sau:

- **Architectural style**: hình dạng/tập constraint tổng thể, ví dụ layered, client–server, microservices, event-driven.
- **Architectural pattern**: giải pháp tái sử dụng cho một vấn đề kiến trúc trong context nhất định.
- **Architectural tactic**: quyết định nhỏ hơn nhằm đạt một quality attribute, ví dụ retry, replication, cache, circuit breaker.

Ranh giới thuật ngữ không hoàn toàn thống nhất giữa các tài liệu. Quan trọng hơn là mô tả rõ context, force, trade-off và consequence thay vì tranh luận nhãn.

#### 2. Bản đồ các style phổ biến

| Style | Đơn vị tổ chức chính | Điểm mạnh | Complexity chính |
|---|---|---|---|
| **Monolithic** | Một deployable application | Đơn giản khi build/test/deploy, local call nhanh | Coupling và coordination khi codebase/team lớn |
| **Layered** | Presentation, application/business, data... | Separation of concerns, cấu trúc dễ hiểu | Layer bypass, pass-through layer, dependency cứng |
| **Client–server** | Consumer và service provider | Tách trải nghiệm client khỏi shared service/data | Server bottleneck, network dependency |
| **Microservices** | Service theo business capability | Deploy/scale/ownership độc lập | Distributed systems và operational complexity |
| **Event-driven** | Producer, event, consumer | Temporal decoupling, fan-out, async scale | Eventual consistency, tracing, delivery/ordering |

Các style này **không loại trừ nhau**. Một client–server system có thể có server là layered monolith; các microservice có thể tổ chức nội bộ theo hexagonal/layered; các service có thể tích hợp bằng event.

---

#### Nhánh A — Monolithic Architecture

#### 3. Monolith là gì?

Monolith đóng gói phần lớn application thành một deployment unit/process boundary. UI/backend logic/data access có thể cùng repository và release lifecycle.

```text
                 Monolithic Application
┌──────────────────────────────────────────────────┐
│ Presentation │ Orders │ Inventory │ Payments     │
│              │        │           │ Notifications│
│ Application / Domain / Data Access               │
└──────────────────────────────────────────────────┘
                         │
                      Database
```

“Một deployable” không bắt buộc “spaghetti code”. **Modular monolith** có thể duy trì module boundary, internal API và data ownership rõ nhưng vẫn deploy cùng nhau.

#### 4. Ưu điểm của monolith

- Một codebase/release pipeline dễ bắt đầu.
- Local in-process call nhanh và dễ debug hơn network call.
- Transaction trong cùng database/process đơn giản hơn distributed transaction.
- Integration test và chạy local thường ít hạ tầng hơn.
- Refactor xuyên module thuận tiện khi boundary còn thay đổi nhanh.
- Observability, deployment và security surface ban đầu nhỏ hơn.
- Phù hợp team nhỏ, domain chưa ổn định và nhu cầu speed-to-market cao.

#### 5. Hạn chế khi monolith lớn lên

- Build/test/deploy có thể chậm và blast radius release lớn.
- Boundary yếu làm coupling tăng; thay đổi nhỏ ảnh hưởng diện rộng.
- Nhiều team cùng release cadence tạo coordination bottleneck.
- Scale deployment unit thay vì scale riêng module nóng.
- Một memory leak/resource exhaustion trong process có thể ảnh hưởng toàn application.
- Khó áp dụng runtime/technology khác cho một phần riêng.
- Ownership mơ hồ và shared database dễ tạo coupling ngầm.

Monolith vẫn có thể **scale horizontally** bằng nhiều instance sau load balancer. Nhược điểm là mọi instance chứa toàn application, có thể kém hiệu quả nếu chỉ một capability cần capacity đặc biệt.

#### 6. Khi nào modular monolith là lựa chọn tốt?

- Product/domain còn khám phá, boundary chưa ổn định.
- Team nhỏ hoặc vừa, coordination cost thấp.
- Không có nhu cầu deploy/scale capability độc lập rõ ràng.
- Strong transaction và đơn giản vận hành quan trọng.
- Hạ tầng/DevOps maturity chưa đủ cho nhiều service.
- Tải có thể xử lý bằng scale-up/scale-out application hiện tại.

Hãy xem microservices là cách mua deployment/ownership independence bằng distributed complexity; nếu chưa cần independence đó, modular monolith thường là default hợp lý.

---

#### Nhánh B — Layered và N-Tier Architecture

#### 7. Layered architecture

Layered architecture chia responsibility theo logic:

```text
┌─────────────────────────────┐
│ Presentation / API Layer    │
├─────────────────────────────┤
│ Application / Use Cases     │
├─────────────────────────────┤
│ Domain / Business Rules     │
├─────────────────────────────┤
│ Data Access / Infrastructure│
└─────────────────────────────┘
```

Mục tiêu chính là **separation of concerns** và quản lý complexity, không phải tự động scale tốt hơn.

#### 8. Layer khác tier

- **Layer** là boundary logic trong code/design.
- **Tier** là boundary triển khai/runtime vật lý hoặc process/network.

Một three-layer application có thể deploy trong một process — một tier. Ngược lại, presentation, application và database có thể deploy thành ba tier. “Layered” và “N-tier” liên quan nhưng không đồng nghĩa hoàn toàn.

#### 9. Ưu điểm và trade-off

Ưu điểm:

- responsibility rõ, onboarding dễ;
- test business logic tách khỏi UI/infrastructure;
- thay implementation data/UI qua interface dễ hơn;
- governance và tổ chức enterprise quen thuộc.

Trade-off:

- request đi qua nhiều pass-through layer tạo boilerplate và latency nếu qua process/network;
- business rule có thể bị rải giữa controller/service/repository;
- layer thấp trở thành shared dependency lớn;
- developer bypass layer để “làm nhanh”, phá boundary;
- dependency direction sai khiến domain phụ thuộc framework/database;
- tổ chức team theo technical layer có thể làm một feature phải qua nhiều handoff.

Layer chỉ hữu ích khi boundary thực sự được enforce bằng module/interface/test, không chỉ bằng folder name.

---

#### Nhánh C — Client–Server Architecture

#### 10. Client–server là gì?

Client khởi tạo interaction và tiêu thụ capability; server cung cấp shared service/resource.

```text
Web Client ──┐
Mobile App ──┼──> API / Application Server ──> Data Store
Partner App ─┘
```

Client–server mô tả **quan hệ giao tiếp**, còn layered mô tả **cách tổ chức responsibility**. Một server có thể là monolith, multi-tier hoặc nhiều microservice.

Ưu điểm:

- centralize data/business capability;
- nhiều client dùng chung service;
- client và server có thể tiến hóa theo versioned contract;
- security/policy có thể tập trung phía server.

Trade-off:

- server/dependency mạng trở thành availability và latency concern;
- backward compatibility cho nhiều client version;
- client chậm update làm API evolution khó;
- centralized server có thể là bottleneck nếu không scale/cache tốt.

---

#### Nhánh D — Microservices Architecture

#### 11. Microservice là gì?

Microservices chia system thành các service deployable độc lập, thường aligned với business capability/bounded context, sở hữu logic và dữ liệu cần thiết qua contract rõ.

```text
                    API Gateway
                         │
        ┌────────────────┼─────────────────┐
        ▼                ▼                 ▼
   Order Service   Inventory Service  Payment Service
        │                │                 │
    Order DB         Inventory DB      Payment DB
```

“Micro” không phải số dòng code. Điều quan trọng là autonomy, cohesion, ownership và deployability. Service quá nhỏ theo technical function tạo distributed monolith.

#### 12. Lợi ích có điều kiện

- Deploy capability độc lập.
- Scale phần có workload khác biệt.
- Ownership theo team/domain rõ hơn.
- Technology/data model có thể khác theo requirement.
- Failure có khả năng được cô lập bởi process/service boundary.
- Release cadence giữa domain ít phụ thuộc hơn.

Các lợi ích này **không tự động xuất hiện**. Nếu service dùng chung database, release phải đồng bộ và call chain quá chặt, ta có complexity của microservices nhưng không có autonomy.

#### 13. Complexity phải trả

- Network latency, timeout và partial failure.
- Service discovery, load balancing và secure service identity.
- Data consistency và transaction xuyên service.
- Retry, idempotency, circuit breaker và backpressure.
- Distributed tracing, centralized logs/metrics.
- Contract/schema evolution.
- Nhiều pipeline, environment, secret và dependency version.
- Test end-to-end khó và flaky hơn.
- On-call/incident ownership phức tạp.
- Chi phí hạ tầng/platform engineering cao.

Microservices không tự tạo fault tolerance. Failure một service có thể cascade qua synchronous call, retry storm hoặc shared dependency. Cần timeout, bounded retry, circuit breaker, bulkhead, graceful degradation và capacity isolation.

#### 14. Khi nào cân nhắc microservices?

Tín hiệu tốt:

- nhiều team cần deploy độc lập;
- business boundary khá ổn định;
- capability có workload/scaling profile khác rõ;
- release coordination của monolith đã thành bottleneck đo được;
- regulatory/security isolation cần process/data boundary;
- team có CI/CD, observability, SRE/DevOps maturity.

Tín hiệu chưa nên:

- team nhỏ và domain còn đổi liên tục;
- chưa có monitoring/automation căn bản;
- mục tiêu chỉ là “giống công ty lớn”;
- bottleneck nằm ở database/query chứ không phải deployment unit;
- không chấp nhận eventual consistency hoặc network failure complexity.

---

#### Nhánh E — Event-Driven Architecture

#### 15. Event-driven là gì?

Producer công bố một **event** — fact đã xảy ra — và consumer phản ứng độc lập:

```text
Order Service
     │ OrderPlaced
     ▼
Event Broker / Log
     ├──> Inventory Consumer
     ├──> Payment Workflow
     ├──> Notification Consumer
     ├──> Analytics Consumer
     └──> Shipping Consumer
```

Event nên được đặt tên ở thì quá khứ như `OrderPlaced`, `PaymentCaptured`. Command như `ChargePayment` thể hiện yêu cầu một receiver làm việc gì và có semantics khác event.

#### 16. Các dạng event communication

- **Event notification**: báo fact ngắn, consumer gọi lại nếu cần chi tiết.
- **Event-carried state transfer**: event mang đủ state cần thiết, giảm coupling runtime nhưng tăng payload/schema concern.
- **Event streaming**: chuỗi event liên tục được lưu/đọc theo partition/offset.
- **Event sourcing**: state được tái dựng từ event log; đây là pattern riêng, không đồng nghĩa mọi EDA.

#### 17. Lợi ích

- Producer không cần biết danh sách consumer.
- Consumer mới có thể được thêm mà ít đổi producer.
- Temporal decoupling: consumer có thể xử lý sau nếu broker giữ message.
- Buffer hấp thụ burst và hỗ trợ scale consumer độc lập.
- Fan-out tự nhiên cho nhiều reaction.
- Workflow async giúp request path phản hồi nhanh hơn khi công việc không cần hoàn tất ngay.

#### 18. Trade-off và failure mode

- Eventual consistency và trạng thái tạm thời khác nhau giữa service.
- Duplicate delivery đòi hỏi idempotent consumer/deduplication.
- Ordering thường chỉ bảo đảm trong partition/key scope.
- Poison message, retry loop và dead-letter queue cần vận hành.
- Schema evolution ảnh hưởng nhiều consumer.
- Debug business flow khó vì không có synchronous call stack.
- Event lag/backlog làm “real-time” trở thành delayed processing.
- Dual write database + broker có thể mất event; transactional outbox là một mitigation.
- Consumer side effect thất bại một phần cần retry/compensation.

Không nên nói queue “đảm bảo mọi component phản ứng ngay”. Broker/delivery semantics, consumer availability, backlog và retry quyết định thời điểm xử lý.

#### 19. EDA không đồng nghĩa microservices

- Monolith cũng có thể dùng internal event bus.
- Microservices có thể giao tiếp chủ yếu synchronous request–response.
- Một hệ thống có thể dùng command synchronous cho invariant cần phản hồi ngay và event async cho side effect.

Chọn theo workflow semantics, không theo nhãn kiến trúc.

---

#### 20. So sánh nhanh

| Câu hỏi | Monolith | Layered | Microservices | Event-driven |
|---|---|---|---|---|
| Deploy độc lập | Không theo module | Tùy tier, thường không | Mục tiêu chính | Tùy producer/consumer |
| Call nội bộ | In-process | Qua layer | Network/API/message | Async event/message |
| Transaction | Thường đơn giản hơn | Tùy deployment/data | Xuyên service khó | Thường eventual consistency |
| Scale riêng capability | Hạn chế | Tùy tier | Tốt nếu boundary đúng | Scale consumer độc lập |
| Vận hành ban đầu | Thấp | Thấp–vừa | Cao | Vừa–cao |
| Debug flow | Dễ hơn | Tương đối rõ | Distributed trace | Trace + event lineage |
| Team autonomy | Hạn chế khi lớn | Tùy ownership | Cao nếu contract tốt | Cao nhưng cần schema governance |

#### 21. Các yếu tố chọn kiến trúc

1. **Business goals**: speed-to-market, differentiation, revenue/risk.
2. **Domain complexity**: boundary đã rõ hay đang khám phá?
3. **Scale profile**: traffic, data, peak, growth và phần nào nóng.
4. **Performance**: latency/throughput/tail target thực tế.
5. **Consistency**: invariant nào bắt buộc atomic?
6. **Reliability**: availability target, RTO/RPO, failure isolation.
7. **Team topology**: số team, ownership, release coordination.
8. **Operational maturity**: CI/CD, observability, on-call, platform.
9. **Security/compliance**: isolation, audit, data residency.
10. **Cost**: build, migrate, infrastructure và run/on-call cost.
11. **Legacy/ecosystem**: current system, integration và skill set.
12. **Evolvability**: change nào dự kiến thường xuyên và change nào đắt.

Over-engineering cho scale chưa tồn tại có thể tốn kém như under-engineering. Quyết định nên dựa trên evidence, forecast có uncertainty và khả năng tiến hóa dần.

#### 22. Một quy trình ra quyết định

1. Liệt kê functional requirements và quality attributes có thứ tự ưu tiên.
2. Ghi constraint không thể thay đổi: deadline, ngân sách, compliance, team.
3. Xác định architecture drivers và bottleneck dự kiến.
4. Đề xuất 2–3 option khả thi, không chỉ một pattern yêu thích.
5. So sánh trade-off bằng scenario cụ thể.
6. Prototype/load test rủi ro lớn nhất.
7. Ghi **Architecture Decision Record (ADR)**: context, decision, alternatives, consequences.
8. Đặt metric/fitness function để kiểm tra assumption khi production thay đổi.
9. Review quyết định khi evidence mới xuất hiện.

#### 23. Câu hỏi phỏng vấn từ tài liệu phụ

**1. Monolith khác microservices thế nào?**  
Monolith là một deployment unit; microservices chia theo service deployable độc lập. Monolith đơn giản hơn ban đầu; microservices mua autonomy/scale isolation bằng network, data và operations complexity.

**2. Khi nào chọn layered thay microservices?**  
Khi cần separation of concerns nhưng chưa cần deploy/scale độc lập, team nhỏ, timeline/cost hạn chế hoặc hệ thống hiện tại đã phù hợp. Layered có thể tồn tại bên trong monolith lẫn service.

**3. Ưu và nhược điểm của event-driven architecture?**  
Ưu: loose/temporal coupling, async scale, fan-out. Nhược: eventual consistency, duplicate/ordering, schema evolution, tracing và broker operations.

**4. Architecture ảnh hưởng scalability và performance thế nào?**  
Nó quyết định scaling unit, communication path, contention và failure domain. Nhưng tên pattern không đủ; implementation, database, caching và workload vẫn chi phối kết quả.

**5. Business requirements ảnh hưởng quyết định ra sao?**  
Speed-to-market, growth, risk, compliance, cost và team capability xác định quality attributes nào đáng trả complexity để đạt được.

**6. Layered khác client–server thế nào?**  
Layered chia responsibility logic; client–server mô tả quan hệ requester/provider qua boundary. Chúng có thể cùng tồn tại.

**7. Thách thức duy trì monolith khi lớn?**  
Coupling, build/test time, release coordination, blast radius, ownership và scale không chọn lọc. Modular boundary và automation có thể kéo dài tuổi thọ tốt của monolith.

**8. Chọn monolith hay microservices cho hệ thống mới?**  
Mặc định nghiêng về modular monolith nếu chưa có bằng chứng cần service autonomy. Chọn microservices khi boundary, team, scaling và deployment independence biện minh operational cost.

**9. Fault tolerance trong microservices có vai trò gì?**  
Service boundary tạo cơ hội cô lập lỗi nhưng không bảo đảm. Cần timeout, circuit breaker, retry budget, bulkhead, graceful degradation và tránh shared failure domain.

**10. Event-driven system xử lý real-time data thế nào?**  
Producer ghi/publish event; broker phân phối/lưu; consumer xử lý async. Latency thật phụ thuộc broker, backlog, partition, consumer capacity và delivery policy.

#### 24. Các lỗi tư duy thường gặp

- Đồng nhất architecture với diagram hoặc danh sách công nghệ.
- Xem monolith là spaghetti code; bỏ qua modular monolith.
- Nói monolith không scale được; nó vẫn có thể scale ngang nhưng scaling unit lớn.
- Nghĩ microservices luôn dành cho “scale lớn” dù team/domain chưa cần autonomy.
- Chia service theo technical layer thay vì cohesive business capability.
- Dùng chung database rồi gọi đó là service independence.
- Cho rằng microservice failure không ảnh hưởng service khác.
- Đồng nhất logical layer với physical tier.
- Cho rằng event-driven mặc nhiên nhanh/real-time và reliable.
- Dùng event cho workflow cần immediate consistency mà không phân tích invariant.
- Chọn pattern trước rồi tìm requirement để biện minh.
- Chỉ tính development cost, bỏ qua deployment, observability và on-call cost.

#### 25. Câu hỏi tư duy thêm

1. Dấu hiệu nào cho thấy modular monolith đã thực sự cần tách service?
2. Làm sao enforce module boundary trong cùng process/database?
3. Khi nào independent scaling tiết kiệm chi phí, khi nào tăng chi phí?
4. Một service boundary sai tạo distributed monolith như thế nào?
5. Event nào nên chỉ notification, event nào nên mang state?
6. Làm sao ngăn dual-write database/broker làm mất event?
7. Layered architecture tổ chức theo technical layer ảnh hưởng team flow ra sao?
8. Architecture decision nào reversible và decision nào one-way door?
9. Làm sao đo maintainability thay vì chỉ nói cảm tính?
10. Nếu requirement thay đổi, dấu hiệu nào cho phép xem lại ADR?

#### 26. Ý chính cần nhớ

- Architecture xác định structure, boundary, interaction và các decision khó thay đổi.
- Pattern/style là công cụ reasoning, không phải đáp án mặc định.
- Monolith tối ưu simplicity; modular monolith vẫn có boundary tốt và scale ngang được.
- Layer là phân chia logic; tier là boundary triển khai.
- Client–server, layered, microservices và event-driven có thể kết hợp.
- Microservices mang lại autonomy có điều kiện và thêm distributed complexity.
- Event-driven giảm temporal coupling nhưng làm consistency, delivery và tracing khó hơn.
- Fault isolation không tự xuất hiện chỉ vì tách process/service.
- Chọn kiến trúc từ business drivers, quality attributes, team và operational constraints.
- Kiến trúc tốt là kiến trúc vừa đủ cho hiện tại và có đường tiến hóa hợp lý.

#### Công thức ghi nhớ

> **Monolith mua sự đơn giản; layers mua sự tổ chức; microservices mua quyền tự chủ; events mua sự tách rời theo thời gian. Mỗi lợi ích được thanh toán bằng một loại complexity khác nhau.**

---

### Bài 25. Multi-Tier Architecture

#### 1. Multi-tier architecture là gì?

**Multi-tier architecture** phân bố các responsibility của application qua nhiều deployment tier/process/network boundary. Các tier phổ biến:

- **Presentation tier**: giao diện hoặc edge/web serving.
- **Application/Business tier**: API, use case, business rules và orchestration.
- **Data tier**: database, object storage hoặc persistence service.

```text
User / Client
      │
      ▼
Presentation Tier
      │
      ▼
Application / Business Tier
      │
      ▼
Data Tier
```

Mục tiêu không phải “càng nhiều tier càng tốt”, mà là tạo deployment boundary có giá trị:

- scale và vận hành riêng;
- bảo vệ resource nhạy cảm;
- thay đổi implementation với contract ổn định;
- cô lập responsibility và failure domain;
- cho nhiều client tái sử dụng business capability.

#### 2. Phân biệt layer và tier

Đây là điểm dễ nhầm nhất:

- **Layer** là phân chia **logic** trong code/design.
- **Tier** là phân chia **vật lý/runtime** qua process, máy, container hoặc network boundary.

Ví dụ một application có presentation, business và data-access **layer** nhưng tất cả chạy trong một process và truy cập một database local; đó có thể là layered design nhưng không phải ba application tier độc lập.

Ngược lại, khi UI, application server và database chạy ở ba deployment boundary khác nhau, ta có 3-tier architecture.

Tách tier thêm:

- network latency và partial failure;
- deployment/monitoring/security surface;
- cơ hội scale và isolate độc lập.

Vì vậy chỉ nên tạo tier khi lợi ích boundary lớn hơn cost phân tán.

#### 3. One-tier architecture

Toàn bộ UI, logic và data nằm trong cùng application/máy hoặc local environment.

```text
┌──────────────────────────────┐
│ UI + Business Logic + Data   │
└──────────────────────────────┘
```

Ví dụ: desktop utility dùng embedded database.

Ưu điểm:

- đơn giản, latency thấp, chạy offline;
- không cần network service hoặc deployment phức tạp.

Hạn chế:

- khó chia sẻ data/capability cho nhiều user/client;
- update, backup và governance phân tán;
- scale và security control hạn chế.

#### 4. Two-tier architecture

Client giao tiếp trực tiếp với database/server data tier. Client thường chứa UI và nhiều business logic — còn gọi là **thick client**.

```text
Desktop / Thick Client
  UI + Business Logic
          │ SQL / DB protocol
          ▼
       Database
```

Ưu điểm:

- ít thành phần, dễ xây cho nhóm user nhỏ;
- ít hop, có thể cho latency tốt trong LAN;
- phù hợp internal desktop tool hoặc legacy client–database application.

Trade-off:

- credential/database protocol hiện diện ở nhiều client;
- khó enforce business rule thống nhất nếu client version khác nhau;
- database phải xử lý connection trực tiếp từ mọi client;
- schema change có thể làm nhiều client hỏng;
- attack surface và network exposure của database lớn hơn;
- khó scale, audit, rate limit và rollout logic tập trung.

Two-tier không mặc nhiên “không an toàn”, nhưng cần network isolation, least-privilege account, parameterized query và quản lý client/credential chặt. Với Internet-facing application, direct database access từ client thường là lựa chọn không phù hợp.

#### 5. Three-tier architecture

Three-tier thêm application/business tier giữa client và database:

```text
Web / Mobile / Desktop Clients
              │ HTTPS
              ▼
      Application / API Tier
       ├─ validation
       ├─ authentication/authorization
       ├─ business workflows
       └─ data-access coordination
              │ private DB protocol
              ▼
           Data Tier
```

Ba tier:

1. **Presentation**: render UI, thu input, quản lý client state.
2. **Application/Business**: validate, authorize, thực thi use case và business rule.
3. **Data**: lưu, truy xuất, index, transaction và durability.

Lợi ích:

- database không bị client Internet truy cập trực tiếp;
- business rule và policy được centralized;
- nhiều frontend dùng chung backend contract;
- application tier có thể scale horizontally;
- database technology có thể thay đổi sau abstraction phù hợp;
- release client và server có thể tách một phần qua API compatibility.

Trade-off:

- thêm network hop và serialization;
- application tier có thể trở thành bottleneck/single point of failure;
- cần deploy, observe, secure và version API;
- distributed session/cache làm state management phức tạp hơn;
- data tier thường vẫn là scaling/reliability bottleneck khó nhất.

#### 6. Request flow trong hệ thống 3-tier

Ví dụ đặt hàng:

```text
1. Browser → POST /orders
2. Application tier xác thực user và validate input
3. Application tier kiểm tra inventory/pricing rule
4. Data tier thực hiện transaction cần thiết
5. Application tier tạo response/domain event
6. Presentation tier cập nhật UI
```

Mỗi hop cần:

- timeout/deadline;
- authentication và authorization context;
- trace/correlation ID;
- error contract;
- retry/idempotency policy;
- payload và connection limit.

Không nên để presentation tier bỏ qua application tier để truy cập database “cho nhanh”, vì sẽ phá policy và boundary.

#### 7. N-tier architecture

**N-tier** mở rộng topology bằng các deployment tier chuyên biệt khi có nhu cầu rõ:

```text
Users
  │
  ▼
CDN / Edge / WAF
  │
  ▼
Load Balancer / API Gateway
  │
  ▼
Web / BFF Tier
  │
  ▼
Application / Service Tier
  ├──────────> Cache Tier
  ├──────────> Messaging Tier
  └──────────> Data Tier
```

Một số thành phần như security, observability hoặc load balancing là **cross-cutting capability/infrastructure**, không nhất thiết là “business tier” độc lập. Đừng gọi mọi box trong diagram là một tier nếu nó không tạo deployment/responsibility boundary có ý nghĩa.

N-tier và microservices là hai dimension khác nhau:

- N-tier nhấn mạnh deployment topology theo responsibility.
- Microservices nhấn mạnh service autonomy theo business capability.

Một N-tier system có thể là một layered monolith; một microservices platform cũng thường có edge, gateway, services, cache và data tiers.

#### 8. Scale presentation tier

- Đưa static asset ra CDN/edge.
- Cache HTML/response phù hợp.
- Dùng multiple web/BFF instances sau load balancer.
- Giữ instance stateless hoặc externalize session.
- Optimize asset, compression và connection reuse.
- Rate limit/bot protection tại edge.

Client-side rendering giảm một số web-server work nhưng có thể chuyển cost sang device và tăng API traffic. Scale decision phải xét cả user experience, SEO và backend load.

#### 9. Scale application tier

Horizontal scale thường hiệu quả nếu application instance stateless:

```text
             Load Balancer
          ┌──────┼──────┐
          ▼      ▼      ▼
        App A  App B  App C
          └──────┼──────┘
                 ▼
              Data Tier
```

Cần:

- health/readiness check;
- autoscaling metric phù hợp như CPU, concurrency, queue depth, latency;
- connection pool giới hạn tới database;
- external session/cache nếu cần;
- graceful shutdown và connection draining;
- bounded concurrency/backpressure;
- timeout, circuit breaker và bulkhead với downstream.

Scale app instance nhưng không giới hạn DB connection có thể làm database sụp nhanh hơn. Nếu 100 instance, mỗi instance pool 100 connection, hệ thống có thể mở tới 10.000 connection.

#### 10. Scale cache tier

- Replication tăng availability/read capacity.
- Partition/sharding tăng capacity.
- TTL, eviction và memory headroom rõ ràng.
- Cache-aside/write-through/... theo consistency need.
- Chống cache stampede bằng request coalescing/locking/jitter.
- Không coi cache là source of truth nếu không được thiết kế như vậy.
- Có policy khi cache down: fail open, fallback DB có kiểm soát hoặc load shedding.

Cache có thể giảm DB load nhưng cũng tạo stale data, invalidation và hot-key problem.

#### 11. Scale data tier

Data tier thường cần kết hợp:

- vertical scaling cho một node mạnh hơn;
- index/query/schema optimization;
- connection pooling;
- read replica cho workload đọc có thể chấp nhận replica lag;
- partitioning/sharding cho data/throughput vượt một node;
- caching và precomputation;
- archival/tiering cho data cũ;
- multi-AZ replication/failover cho availability.

Không nên gọi việc chọn replica là load balancing thông thường. Routing phải biết:

- write đi đâu;
- read nào cần read-your-writes/strong consistency;
- replica lag hiện tại;
- failover/fencing và promotion state.

Replication tăng redundancy/read capacity, nhưng không tự bảo đảm zero data loss hoặc correctness. RPO/RTO và consistency mode phải được xác định.

#### 12. Vertical và horizontal scaling

| Cách scale | Ý nghĩa | Ưu điểm | Hạn chế |
|---|---|---|---|
| **Vertical** | Thêm CPU/RAM/IOPS cho một node | Đơn giản, ít phân tán | Có giới hạn, failover và cost lớn |
| **Horizontal** | Thêm node/instance | Capacity và redundancy tốt hơn | Cần partitioning/load balancing/state management |

Mỗi tier có thể chọn khác nhau. Application tier thường scale ngang dễ; relational database write tier thường scale dọc trước rồi mới partition khi cần.

#### 13. Latency budget qua nhiều tier

Total latency không chỉ là tổng thời gian business code:

```text
DNS/TLS/edge        20 ms
Gateway             10 ms
Application         30 ms
Cache/DB            60 ms
Serialization       10 ms
Network giữa tier   20 ms
-------------------------
Tổng               150 ms
```

Mỗi tier thêm hop, queueing và failure probability. Tối ưu:

- loại bỏ pass-through tier không tạo giá trị;
- colocate workload hợp lý nhưng vẫn giữ failure isolation;
- cache tại đúng tier;
- dùng CDN cho static/public content;
- batch tránh N+1/network chatter;
- connection pooling/keep-alive;
- async hóa side effect không cần trong critical response path;
- parallelize call độc lập có giới hạn;
- giảm payload và serialization cost;
- đặt latency budget/deadline cho từng hop.

API gateway tập trung routing/auth/rate limit nhưng thường **thêm một hop**. Nó chỉ cải thiện latency nếu giảm fan-out/round trip hoặc cung cấp cache/composition hiệu quả.

#### 14. Asynchronous tier và messaging

Tác vụ dài như gửi email, tạo report hoặc media processing có thể rời synchronous path:

```text
Client → Application → Queue → Worker Tier → Data/External Service
              │
              └── 202 Accepted + Job ID
```

Lợi ích:

- response nhanh hơn;
- buffer burst;
- worker scale theo queue depth;
- retry task độc lập.

Đổi lại cần idempotent consumer, retry/DLQ, job state, observability và eventual consistency. Async không làm công việc biến mất; nó chuyển latency khỏi request path và tạo operational responsibility khác.

#### 15. Load balancing giữa các tier

Load balancer có thể xuất hiện tại nhiều boundary:

- edge → web/application nodes;
- gateway → service pool;
- application → replicated read endpoint;
- worker → partition/queue assignment.

Thuật toán thường gặp:

- round robin/weighted round robin;
- least connections/least outstanding requests;
- consistent hash theo key;
- latency/health-aware routing;
- locality/zone-aware routing.

IP hash/sticky session có thể giữ user về một backend nhưng làm phân bố tải và failover khó hơn. Ưu tiên stateless app hoặc shared session store khi hợp lý.

#### 16. Security theo tier

```text
Internet
  │ chỉ 443
  ▼
Public Edge / WAF
  │ allow-list tới app port
  ▼
Private Application Network
  │ least-privilege DB identity
  ▼
Isolated Data Network
```

Nguyên tắc:

- database/cache/message broker không public nếu không có lý do đặc biệt;
- network segmentation và firewall/security group theo flow cần thiết;
- TLS giữa tier; mTLS/workload identity khi threat model yêu cầu;
- authentication không thay authorization;
- service identity và least privilege thay shared static credential;
- secret manager, rotation và audit;
- validate input ở trust boundary, parameterize database query;
- encrypt data at rest và quản lý key;
- egress control để giảm exfiltration;
- log security event nhưng không log token/PII nhạy cảm.

JWT, OAuth và API key không phải từ đồng nghĩa. OAuth 2.0 là authorization framework; JWT là token format; API key thường nhận diện caller/application và cần policy riêng.

#### 17. Fault tolerance theo tier

Một hệ thống multi-tier chỉ available nếu critical path còn hoạt động. Nếu các tier nối tiếp có availability độc lập `A1, A2, A3`, availability lý tưởng của path xấp xỉ tích của chúng; thêm dependency có thể giảm end-to-end availability.

Mitigation:

- ít nhất nhiều instance qua nhiều availability zone cho stateless tier;
- health check và loại node lỗi;
- replication/failover data tier với RTO/RPO rõ;
- timeout và circuit breaker;
- bounded retry + exponential backoff + jitter;
- bulkhead và resource isolation;
- graceful degradation/cache stale khi business cho phép;
- queue buffer cho async workload;
- load shedding khi saturation;
- chaos/failover test định kỳ;
- backup **và restore drill**.

Retry không mặc nhiên tăng reliability. Retry storm có thể làm tier đang quá tải sụp hoàn toàn; write retry cần idempotency.

#### 18. Multi-AZ và multi-region

- **Multi-AZ** trong một region thường là bước đầu để chịu lỗi data center/zone với latency thấp hơn.
- **Multi-region** hỗ trợ disaster recovery, global latency hoặc regional availability nhưng thêm data replication, routing, consistency và operational complexity lớn.

Không nên mặc định “high traffic = multiple region”. Quyết định dựa trên availability target, RTO/RPO, data residency, user geography và chi phí.

#### 19. Observability xuyên tier

Cần nhìn cả request path chứ không chỉ từng server:

- correlation/trace ID xuyên gateway, app, cache và DB;
- latency p50/p95/p99 theo tier và dependency;
- error rate phân loại client/server/upstream;
- saturation: CPU, memory, thread/event-loop, connection pool;
- cache hit ratio/hot key/eviction;
- DB query latency, locks, connection, replica lag;
- queue depth, age và retry/DLQ;
- deployment/version tag trên trace/log;
- SLO ở user journey, không chỉ component uptime.

Một tier có average latency tốt vẫn có thể gây tail latency xấu do queueing hoặc một shard nóng.

#### 20. Deployment và compatibility

Các tier có release lifecycle riêng cần contract compatibility:

- rolling/blue-green/canary deployment;
- backward-compatible API/schema change;
- expand-and-contract database migration;
- connection draining;
- feature flag;
- rollback plan;
- version skew test.

Database migration đặc biệt nguy hiểm vì application cũ và mới có thể chạy đồng thời. Tránh rename/drop column trong cùng bước với code rollout nếu không có compatibility plan.

#### 21. Multi-tier khác microservices thế nào?

| Multi-tier | Microservices |
|---|---|
| Chia theo technical/deployment responsibility | Chia theo business capability/domain |
| Tier có thể chứa toàn bộ business application | Mỗi service hướng tới autonomy và ownership riêng |
| Thường một application release/dependency model | Hướng tới independent deployment |
| Có thể dùng chung data tier | Mỗi service lý tưởng sở hữu data qua contract |
| Ít distributed domain boundary hơn | Nhiều network/data consistency concern hơn |

Không cần chuyển sang microservices chỉ để scale web/app tier. Một well-structured 3-tier modular monolith có thể phục vụ tải rất lớn nếu bottleneck được xử lý đúng.

#### 22. Ví dụ N-tier cho banking application

Một thiết kế có thể gồm:

```text
Mobile/Web
   │
WAF + API Gateway
   │
Identity / Application Services
   ├── Fraud/Risk Engine
   ├── Ledger/Transaction Capability
   ├── Notification Queue/Workers
   ├── Cache (non-authoritative data)
   └── ACID Data Stores + Audit Log
```

Nhưng không thể kết luận “distributed N-tier + microservices là lý tưởng” chỉ từ từ *banking*. Cần biết transaction invariant, consistency, regulatory scope, team, legacy core, RTO/RPO và workload. Ledger có thể cần strong transactional boundary trong khi notification/fraud analytics có thể async.

#### 23. Câu hỏi phỏng vấn từ tài liệu phụ

**1. Multi-tier architecture là gì và vì sao dùng?**  
Là phân chia application qua deployment tier có responsibility riêng để tăng separation, security control và khả năng scale/vận hành độc lập. Đổi lại có network/operations complexity.

**2. 2-tier khác 3-tier thế nào?**  
2-tier cho client nói trực tiếp với DB; 3-tier thêm application/API tier để centralize business rule, auth và data access. 3-tier không tự “nhanh/scalable hơn”; nó tạo boundary cho phép scale và kiểm soát tốt hơn.

**3. Các thành phần của 3-tier?**  
Presentation, application/business và data tier. Technology như React, Java hay PostgreSQL chỉ là implementation option, không phải định nghĩa tier.

**4. Ví dụ N-tier thực tế?**  
Banking/web commerce có edge/WAF, gateway, application/service, cache/messaging và data tier; mỗi tier tồn tại vì một responsibility/operational need.

**5. Multi-tier cải thiện scalability thế nào?**  
Cho phép scale từng tier theo bottleneck: CDN/web/app ngang, worker theo queue, cache partition, DB optimize/replicate/shard. Independence chỉ đạt được nếu dependency và state boundary hỗ trợ.

**6. Thách thức khi thêm tier?**  
Latency, partial failure, deployment, cost, security surface, observability và compatibility. Data consistency chỉ phức tạp hơn khi state được phân tán/sao chép, không phải do “nhiều layer” tự thân.

**7. Load balancing trong N-tier?**  
Phân phối traffic giữa healthy instance theo load/locality/key. Database routing phải hiểu read/write và consistency, không chỉ round robin mọi query.

**8. Giảm latency thế nào?**  
Đo critical path rồi cache/CDN, connection pooling, batch/parallel có giới hạn, async side effect, payload optimization và loại hop không tạo giá trị. Gateway có thể thêm hop.

**9. Khi nào chọn microservices thay traditional N-tier?**  
Khi nhiều business capability/team cần deploy, scale và sở hữu độc lập, và tổ chức chấp nhận distributed complexity. N-tier modular monolith đơn giản hơn nếu chưa có nhu cầu đó.

**10. Bảo vệ inter-tier communication?**  
Segmentation, TLS/mTLS, workload identity, least privilege, authz, secret rotation, input validation, audit và egress control.

**11. Thiết kế fault-tolerant high-traffic multi-tier system?**  
Redundancy theo failure domain, autoscaling có headroom, health routing, data replication/failover, timeout/circuit breaker, safe retry, queue, graceful degradation, observability và restore/failover test.

**Bonus — Kiến trúc cho banking app?**  
Không chọn pattern chỉ từ ngành. Bắt đầu với consistency/audit/security/RTO-RPO requirements; giữ transaction boundary chặt cho ledger và chỉ phân tán những capability có lợi ích rõ.

#### 24. Các lỗi tư duy thường gặp

- Dùng “layer” và “tier” như hai từ đồng nghĩa tuyệt đối.
- Coi mọi proxy/cache/security component là một application tier.
- Nghĩ thêm tier tự động làm hệ thống scalable, secure hoặc maintainable.
- Cho client Internet truy cập database trực tiếp.
- Scale application không giới hạn DB connection pool.
- Round robin cả database write/read mà bỏ qua consistency và replica lag.
- Nói API gateway luôn giảm network hop.
- Dùng async queue nhưng không thiết kế idempotency, DLQ và job state.
- Retry mọi lỗi và gây retry storm.
- Thêm multi-region trước khi có RTO/RPO/business justification.
- Xem replication là backup hoặc bảo đảm không mất dữ liệu.
- Chọn microservices chỉ vì N-tier “cũ”.

#### 25. Câu hỏi tư duy thêm

1. Scaling app tier sẽ tác động DB connection như thế nào?
2. Session state nên đặt đâu để app tier scale ngang và failover?
3. Khi nào cache tier tăng availability, khi nào làm DB overload lúc cache down?
4. Làm sao chia latency budget cho từng tier?
5. Read replica lag ảnh hưởng API nào và cách route ra sao?
6. Gateway nên composition request hay để client gọi song song?
7. Nếu một tier có 99.9% availability, ba tier nối tiếp cho path availability bao nhiêu?
8. Làm sao deploy database schema khi app version cũ và mới cùng chạy?
9. Multi-AZ đã đủ cho threat/failure model nào và chưa đủ cho model nào?
10. Tier nào là bottleneck thật sự và metric nào chứng minh điều đó?

#### 26. Ý chính cần nhớ

- Multi-tier là deployment separation; layer là logical separation.
- 2-tier đơn giản nhưng direct DB access làm scale, security và rollout khó hơn.
- 3-tier centralize business rule và bảo vệ data sau application boundary.
- N-tier thêm specialized boundary khi scale/security/operations thực sự cần.
- Mỗi tier thêm network hop, failure mode và operational cost.
- Scale từng tier theo bottleneck; application scale có thể đẩy tải sang database.
- Caching, load balancing và async processing không tự bảo đảm correctness.
- Inter-tier security cần identity, authorization, encryption và segmentation.
- End-to-end availability/latency quan trọng hơn metric đẹp của từng component.
- Chọn số tier vừa đủ, không tối đa hóa số box trong diagram.

#### Công thức ghi nhớ

> **Layer giúp tổ chức code; tier tạo deployment boundary. Mỗi tier chỉ đáng tồn tại khi khả năng scale, bảo vệ hoặc vận hành độc lập bù được network hop và complexity mà nó thêm vào.**

---

### Bài 26. Microservices Architecture

#### 1. Microservices architecture là gì?

Microservices architecture tổ chức một hệ thống thành các service:

- xoay quanh **business capability/bounded context**;
- có contract rõ;
- có thể phát triển, deploy và scale tương đối độc lập;
- sở hữu logic và dữ liệu của mình;
- giao tiếp qua network bằng API hoặc messaging;
- do một team có quyền và trách nhiệm vận hành end-to-end.

```text
Clients
   │
API Gateway / BFF
   │
   ├── Order Service ───── Order Data
   ├── Inventory Service ─ Inventory Data
   ├── Payment Service ─── Payment Data
   └── Notification Service
             │
          Event Broker
```

“Micro” không nói về số dòng code. Một service tốt đủ nhỏ để một team hiểu và sở hữu, nhưng đủ lớn để giữ business rule/data có cohesion cao trong cùng boundary.

#### 2. Microservices muốn giải quyết vấn đề gì?

Khi monolith và organization lớn lên, có thể xuất hiện:

- nhiều team phải phối hợp một release;
- build/test/deploy toàn application ngày càng chậm;
- một module nóng buộc scale cả deployment;
- domain khác nhau cần release cadence hoặc reliability khác;
- blast radius của change/failure quá rộng;
- ownership và boundary mơ hồ;
- technology/data constraint của một capability bị ép theo toàn hệ thống.

Microservices mua **autonomy** bằng cách tạo process, deployment và data boundary. Cái giá là distributed systems complexity.

Không nên tách service chỉ vì codebase lớn. Modular monolith, build optimization và boundary cleanup có thể giải quyết vấn đề với chi phí thấp hơn.

#### 3. Monolith và microservices

| Tiêu chí | Modular Monolith | Microservices |
|---|---|---|
| Deployment unit | Một | Nhiều service |
| Call nội bộ | In-process | Network/message |
| Transaction | Dễ giữ trong một DB transaction | Chủ yếu local transaction; cross-service khó |
| Scale | Scale cả app/module không độc lập | Scale service nếu state/dependency cho phép |
| Failure mode | Process-wide | Partial/cascade/network failure |
| Refactor boundary | Dễ hơn trong repo/process | Cần contract, migration và rollout phối hợp |
| Operations | Đơn giản hơn | Nhiều pipeline, runtime, telemetry, on-call |
| Team autonomy | Có giới hạn khi nhiều team | Cao nếu boundary và ownership đúng |

Monolith không mặc nhiên chậm hoặc kém maintainable. Microservices không mặc nhiên nhanh, resilient hoặc cho phép deploy độc lập. Kết quả phụ thuộc boundary, coupling, platform và engineering discipline.

#### 4. Tiêu chí thành công thật sự

Một microservices architecture chỉ tạo giá trị khi:

- service có business purpose rõ;
- thay đổi phần lớn localized trong một service/team;
- deploy một service không buộc deploy hàng loạt service khác;
- consumer không truy cập trực tiếp database nội bộ;
- contract tiến hóa tương thích;
- failure không cascade vô hạn;
- team tự build, deploy, observe và support service;
- platform giảm cognitive/operational burden;
- autonomy tạo lợi ích lớn hơn network/consistency cost.

Nếu mọi release vẫn phải synchronized hoặc service gọi nhau như function chain cực dài, đó thường là **distributed monolith**.

---

#### Nhánh A — Xác định service boundaries

#### 5. Chia theo business capability, không theo technical layer

Boundary tốt:

```text
Orders | Payments | Inventory | Shipping | Customer Support
```

Boundary yếu nếu chỉ chia:

```text
Validation Service | Database Service | Email Utility Service | Common Service
```

Technical service dùng chung đôi khi hợp lý, nhưng nếu mọi business flow phải gọi một chuỗi utility service, coupling và latency sẽ tăng mà ownership domain không rõ.

#### 6. Dùng Domain-Driven Design

Các khái niệm hữu ích:

- **Domain/subdomain**: vùng bài toán kinh doanh.
- **Bounded context**: phạm vi một model/ngôn ngữ có meaning nhất quán.
- **Aggregate**: consistency boundary cho invariant và transaction cục bộ.
- **Ubiquitous language**: từ vựng chung giữa domain expert và team.
- **Context map**: quan hệ giữa các bounded context.

Không phải mỗi entity là một service. `Order`, `OrderLine` và một số rule có thể thuộc cùng aggregate/context; tách mỗi entity thành service tạo chatty calls và transaction phân tán.

#### 7. Các force khi vẽ boundary

Đánh giá đồng thời:

1. Business capability và language có cohesive không?
2. Dữ liệu nào phải nhất quán atomically?
3. Thay đổi nào thường đi cùng nhau?
4. Workload/scaling profile có khác đáng kể không?
5. Security/compliance boundary nào cần tách?
6. Team nào sở hữu và có thể vận hành end-to-end?
7. Service cần gọi service khác bao nhiêu trên critical path?
8. Availability target có khác không?
9. Data có thể được sở hữu một nơi và chia sẻ qua contract không?
10. Tách ra có tạo lợi ích deploy độc lập đo được không?

“Single Responsibility” trong kiến trúc không có nghĩa “một service chỉ có một hàm”. Nó nên có một cohesive reason to change gắn với business capability.

#### 8. Granularity: quá lớn và quá nhỏ

**Service quá lớn:**

- nhiều team cùng ownership/release;
- capability không liên quan chung deployment;
- scale profile xung đột;
- schema/module coupling lan rộng.

**Service quá nhỏ:**

- network call cho thao tác vụn;
- data transaction bị chia nhỏ;
- quá nhiều repository/pipeline/on-call surface;
- schema/version coordination tăng;
- latency/failure probability tích lũy;
- team phải nhảy qua nhiều service cho một feature.

Boundary có thể tiến hóa. Thường an toàn hơn nếu bắt đầu modular monolith, đo coupling/change pattern rồi tách seam có evidence.

#### 9. Ownership theo team

Service autonomy cần:

- một owning team rõ;
- code + runtime + data + dashboard + alert + runbook cùng ownership;
- quyền deploy trong guardrail;
- SLO và dependency contract;
- on-call/escalation rõ;
- tránh “platform team deploy hộ mọi service”, vì nó tái tạo coordination bottleneck.

Thiết kế service thường phản chiếu communication structure của organization. Nếu team boundary và service boundary xung đột, coordination cost quay trở lại dưới hình thức khác.

---

#### Nhánh B — Data ownership và consistency

#### 10. Database per service

Nguyên tắc quan trọng là mỗi service **sở hữu schema/data và quyết định cách truy cập**. Nó không bắt buộc mỗi service có một physical database server riêng; có thể dùng cùng cluster nhưng schema/account/ownership tách biệt.

```text
Order Service ─────> Order schema/database
Payment Service ───> Payment schema/database

Payment Service ─X─> Order tables trực tiếp
Payment Service ───> Order API/Event
```

Lợi ích:

- không coupling vào schema nội bộ service khác;
- migration và indexing theo workload riêng;
- data technology phù hợp capability;
- ownership/security boundary rõ;
- deploy độc lập tốt hơn.

Trade-off:

- join và transaction xuyên service không còn đơn giản;
- reporting/analytics cần pipeline/read model;
- duplication và eventual consistency;
- backup/retention/governance nhiều data store;
- polyglot persistence tăng skill và operational burden.

Không chọn database khác chỉ vì microservices “cho phép”. Standardization hợp lý thường giảm chi phí.

#### 11. Local transaction và distributed invariant

Trong microservices, nên giữ business invariant trong một service/aggregate khi có thể:

```text
Order Service:
  create order + order items + initial status
  → một local transaction
```

Workflow xuyên service:

```text
Create Order → Reserve Inventory → Authorize Payment → Confirm Shipping
```

Không thể giả định một ACID transaction bao phủ mọi service. Cần mô hình intermediate state như `PENDING_PAYMENT`, `RESERVATION_FAILED`, `CANCELLED` và business recovery.

#### 12. Eventual consistency

Eventual consistency nghĩa các replica/service có thể tạm thời nhìn state khác nhau nhưng sẽ hội tụ nếu không có update mới và processing thành công.

Nó không có nghĩa “cuối cùng chắc đúng” nếu thiếu:

- reliable event publication;
- idempotent processing;
- retry/DLQ/reconciliation;
- ordering/version rule;
- monitoring lag;
- repair process.

UX và API phải biểu diễn state trung gian thay vì giả vờ transaction đã hoàn tất ngay.

#### 13. Saga pattern

Saga quản lý một business transaction dài bằng chuỗi **local transaction** và **compensating action**.

**Choreography:**

```text
OrderCreated
   ├─> Inventory reserves → InventoryReserved
   ├─> Payment authorizes → PaymentAuthorized
   └─> Order confirms
```

**Orchestration:**

```text
Saga Orchestrator
   1. Create order
   2. Reserve inventory
   3. Authorize payment
   4. Confirm order
   on failure → compensate completed steps
```

| Choreography | Orchestration |
|---|---|
| Ít central coordinator | Workflow/state nhìn rõ hơn |
| Producer/consumer decoupled | Orchestrator biết sequence |
| Dễ thành event spaghetti khi flow dài | Có nguy cơ coordinator coupling |
| Hợp reaction đơn giản | Hợp business workflow nhiều bước |

Compensation không phải database rollback. Refund có thể mất phí hoặc cần review; email đã gửi không thể “unsend”. Phải thiết kế business semantics cho failure.

#### 14. Transactional outbox và inbox

**Dual-write problem:** service commit database rồi publish event; một bước thành công, bước kia thất bại.

```text
Sai:
  1. COMMIT order
  2. Publish OrderCreated  ← crash ở đây → mất event
```

Transactional outbox:

```text
Một DB transaction:
  - ghi Order
  - ghi Outbox(OrderCreated)

Publisher đọc outbox → broker → đánh dấu đã publish
```

Publisher có thể gửi trùng, vì vậy consumer cần idempotency/dedup. Inbox pattern lưu message ID đã xử lý cùng local change để tránh side effect lặp.

#### 15. 2PC và event sourcing

**Two-Phase Commit (2PC)** có thể cung cấp atomic commit qua participant hỗ trợ, nhưng coordinator/locking/availability/latency và heterogeneous support làm nó ít phù hợp cho nhiều Internet-scale microservice workflow. Không phải “cấm”, nhưng phải có lý do và infrastructure tương thích.

**Event sourcing** lưu event làm nguồn sự thật để tái dựng state. Nó hỗ trợ audit/history và temporal model nhưng thêm schema evolution, replay, projection, storage và operational complexity. Nó không tự động giải quyết mọi reliable messaging hoặc consistency problem.

---

#### Nhánh C — Giao tiếp giữa services

#### 16. Synchronous communication

Service gửi request và chờ response:

- REST/HTTP: phổ biến, dễ tích hợp, tận dụng HTTP tooling.
- gRPC: typed contract, compact message, unary/streaming, thường hợp internal call.

Phù hợp khi caller cần kết quả ngay để tiếp tục. Trade-off:

- temporal coupling: caller và callee phải available cùng lúc;
- network latency/timeout;
- call chain làm tail latency tăng;
- retry có thể khuếch đại tải;
- deploy/version contract cần compatibility.

```text
Client → A → B → C → D
```

Nếu mỗi dependency có 99.9% availability và độc lập lý tưởng, availability path giảm theo tích; thực tế shared dependency và cascade còn phức tạp hơn. Giữ synchronous chain ngắn trên critical path.

#### 17. Asynchronous communication

Producer publish message/event và không chờ consumer hoàn tất:

- queue cho work distribution;
- pub/sub cho nhiều subscriber;
- event log/stream cho retention, partition và replay.

Phù hợp khi **không cần kết quả business ngay lập tức**, muốn buffer burst, fan-out hoặc temporal decoupling.

Trade-off:

- eventual consistency;
- duplicate/out-of-order delivery;
- backlog/lag;
- harder tracing/debugging;
- schema governance;
- retry/DLQ/reconciliation.

Thông tin trong transcript “asynchronous phù hợp khi immediate response required” là ngược: nếu caller phải biết kết quả ngay, synchronous call thường tự nhiên hơn; async phù hợp khi có thể trả accepted/pending và xử lý sau.

#### 18. Command, event và query

- **Command**: yêu cầu một receiver thực hiện hành động, có thể bị từ chối.
- **Event**: fact đã xảy ra, có thể có nhiều subscriber.
- **Query**: yêu cầu dữ liệu, không thay đổi business state.

Đặt tên đúng giúp coupling và ownership rõ:

```text
Command: ReserveInventory
Event:   InventoryReserved
Query:   GetAvailableInventory
```

Không publish command như broadcast event và kỳ vọng “ai đó” xử lý critical action nếu không có ownership/delivery contract.

#### 19. Tránh chatty communication

Dấu hiệu:

- một request gọi hàng chục service tuần tự;
- mỗi field/entity cần một remote call;
- service A biết workflow nội bộ quá chi tiết của B/C/D;
- nhiều round trip cho một business operation nhỏ.

Mitigation:

- xem lại boundary/cohesion;
- coarse-grained API theo use case;
- batch endpoint/gRPC call;
- BFF/API composition có giới hạn;
- local read model/materialized view;
- event-carried state để giảm runtime lookup;
- async hóa side effect;
- cache với correctness policy.

#### 20. API Gateway

Gateway là entry point cho external traffic:

- TLS termination/routing;
- authentication context và policy enforcement;
- rate limiting/quota;
- request/response transformation;
- API composition/BFF khi hợp lý;
- logging/tracing/traffic split.

Không nên:

- nhét toàn bộ business logic vào gateway;
- coi gateway là authorization duy nhất — service vẫn phải enforce resource permission;
- tạo central bottleneck/single point of failure;
- cho mọi internal call đi vòng qua external gateway nếu không cần.

Gateway có thể load balance hoặc gọi service discovery/proxy layer, nhưng hai khái niệm không đồng nhất.

#### 21. Contract evolution

- Prefer additive field/method change.
- Consumer phải xử lý unknown/optional field theo contract.
- Không đổi meaning/type tùy tiện.
- Version/deprecate có telemetry usage.
- Consumer-driven contract test phát hiện breaking change.
- Event schema cần compatibility policy và schema registry nếu quy mô lớn.
- Producer và consumer version cũ/mới cùng tồn tại trong rolling deploy.

Independent deployment chỉ khả thi khi contract tương thích qua version skew.

---

#### Nhánh D — Resilience và scalability

#### 22. Timeouts và deadlines

Mọi network call cần timeout/deadline. Caller nên truyền remaining budget xuống downstream:

```text
End-to-end deadline: 1000 ms
  Gateway còn: 900 ms
  Order còn:   700 ms
  Payment còn: 400 ms
```

Không để mỗi hop dùng timeout 1 giây trong chain 5 hop. Cancellation nên dừng work không còn giá trị.

#### 23. Retry có kiểm soát

Retry chỉ khi:

- lỗi transient;
- operation safe/idempotent hoặc có idempotency key;
- còn time budget;
- có exponential backoff + jitter;
- giới hạn lần thử và retry budget;
- tránh nhiều layer cùng retry.

Retry payment/order create mù sau timeout có thể tạo duplicate side effect. `UNAVAILABLE`/`503` không có nghĩa mọi request đều retry an toàn.

#### 24. Circuit breaker, bulkhead và load shedding

- **Circuit breaker** ngừng gọi dependency đang lỗi để tránh cascade và cho nó phục hồi.
- **Bulkhead** tách pool/resource để failure/saturation một dependency không ăn hết capacity.
- **Load shedding** từ chối tải ít quan trọng khi hệ thống bão hòa.
- **Fallback** chỉ dùng khi business chấp nhận dữ liệu cũ/giảm chức năng.

Circuit breaker không sửa dependency; nó kiểm soát damage. Fallback sai có thể che lỗi hoặc trả dữ liệu nguy hiểm.

#### 25. Service discovery và load balancing

Service instance thay đổi do autoscale/deploy/failure. Discovery cung cấp healthy endpoint:

- client-side discovery + client load balancing;
- server-side proxy/load balancer;
- platform DNS/service abstraction;
- service mesh data plane.

Cần readiness, health, locality, connection reuse, draining và outlier detection. Liveness không nên phụ thuộc mọi downstream, nếu không failure có thể restart hàng loạt instance khỏe.

#### 26. Service mesh

Service mesh thường dùng sidecar/ambient data plane để cung cấp:

- mTLS/workload identity;
- traffic routing/retry/timeout policy;
- telemetry;
- service discovery/load balancing integration.

Trade-off:

- thêm proxy hop, CPU/memory và control plane;
- policy/debugging phức tạp;
- application semantics như idempotency, authorization và business retry vẫn không được mesh tự hiểu.

Không dùng mesh chỉ vì có nhiều service; chỉ dùng khi lợi ích policy/visibility vượt operational cost.

#### 27. Horizontal scaling

Stateless service scale qua nhiều instance sau load balancer. Nhưng phải xét toàn chuỗi:

- DB/cache/broker capacity;
- connection pool tổng;
- partition/hot key;
- downstream quota;
- autoscaling delay;
- cold start;
- retry/reconnect storm.

Autoscale theo CPU không đủ cho mọi workload. Có thể dùng concurrency, request latency, queue depth/age, messages per second hoặc custom business metric.

#### 28. Database scaling

- Index/query optimization trước.
- Vertical scale khi đơn giản và đủ.
- Read replica cho read có thể chịu lag.
- Partition/shard theo stable, well-distributed key.
- Cache/precompute cho hot read.
- Archive data cũ.
- Multi-AZ replication/failover theo RTO/RPO.

Sharding mỗi service chỉ khi bottleneck chứng minh cần; nếu áp dụng sớm, cross-shard query, rebalancing và hot partition tăng complexity.

#### 29. Autoscaling và cost

Independent scaling có giá trị khi service có workload profile thật sự khác. Tuy nhiên nhiều service kéo theo:

- baseline replica cho availability;
- sidecar/agent overhead;
- nhiều DB/cache/broker;
- observability data volume;
- CI/CD và on-call cost.

Scale-to-zero hoặc serverless có thể giảm idle cost cho workload phù hợp nhưng cold start và connection/state constraint cần đánh giá.

---

#### Nhánh E — Delivery, observability và security

#### 30. CI/CD và deployment strategies

Mỗi service cần pipeline tự động:

- unit/static/security checks;
- contract/integration test;
- immutable artifact/image;
- provenance/dependency scan;
- deployment + health verification;
- rollback/roll-forward.

**Blue–green:** hai environment/version, chuyển traffic khi version mới sẵn sàng. Rollback nhanh nhưng tốn capacity và database compatibility vẫn khó.

**Canary:** đưa traffic nhỏ sang version mới, so sánh error/latency/business metric rồi tăng dần. Cần cohort/traffic control và automated guardrail.

**Rolling:** thay instance dần; rẻ hơn nhưng version skew tồn tại lâu hơn.

#### 31. Database migration

Independent deployment yêu cầu schema compatible:

1. **Expand**: thêm column/table/API mới, code cũ vẫn chạy.
2. Deploy code đọc/ghi dạng mới trong giai đoạn chuyển tiếp.
3. Backfill/verify.
4. Chuyển consumer.
5. **Contract**: xóa dạng cũ sau khi không còn usage.

Không deploy code và drop/rename schema trong một bước nếu instance cũ còn chạy.

#### 32. Observability

Ba tín hiệu chính:

- **Logs**: structured, có service/version/trace ID; không lộ secret/PII.
- **Metrics**: request rate, error, duration, saturation; business KPI và queue/DB metric.
- **Traces**: span xuyên gateway/service/database/broker để thấy critical path.

OpenTelemetry cung cấp chuẩn instrument/transport telemetry; backend như Jaeger/Zipkin/Prometheus/Grafana/ELK là các lựa chọn, không phải mục tiêu tự thân.

Cần:

- SLI/SLO theo user journey và service;
- alert dựa trên symptom/error budget thay vì mọi metric;
- dependency map;
- tail latency p95/p99;
- correlation giữa deploy và regression;
- event lineage/lag cho async flow;
- runbook và ownership.

#### 33. Liveness, readiness và health

- **Liveness**: process có bị kẹt và cần restart không?
- **Readiness**: instance hiện có nên nhận traffic không?
- **Startup**: application đã khởi tạo xong chưa?
- **Dependency health**: service phụ thuộc đang ở trạng thái nào?

Không trả “healthy” chỉ vì process còn sống; cũng không restart service khỏe chỉ vì một downstream tạm lỗi. Readiness và degraded mode phải phản ánh khả năng phục vụ thực tế.

#### 34. Security

- TLS/mTLS và workload identity cho inter-service communication.
- Authn ở entry boundary; authz tại service/resource/action.
- Propagate identity/context có kiểm chứng, không tin header từ client.
- Least privilege cho database, queue, secret và API.
- Network segmentation/egress control.
- Secret manager và rotation.
- Validate schema/input, giới hạn payload/rate/concurrency.
- Audit sensitive actions.
- Software supply-chain scanning/signing.
- Tenant isolation trong data, cache, broker và telemetry.

API gateway, service mesh, OAuth, JWT và mTLS giải quyết các concern khác nhau. Không có một lớp nào thay thế toàn bộ security architecture.

#### 35. Testing strategy

Một test pyramid thực dụng:

- nhiều unit/component test trong service;
- contract test giữa producer–consumer;
- integration test với DB/broker thật hoặc gần thật;
- ít end-to-end test cho critical journey;
- performance/resilience/chaos test có mục tiêu;
- production canary và observability làm feedback cuối.

Mock mọi dependency có thể cho test xanh nhưng contract production sai. E2E cho mọi trường hợp lại chậm/flaky. Contract test giúp cân bằng.

---

#### 36. Migration từ monolith

Không nên “big-bang rewrite” nếu tránh được. **Strangler Fig pattern:**

1. Xác định capability có boundary/lợi ích rõ.
2. Đặt facade/gateway quanh monolith.
3. Tách data/logic dần.
4. Route một phần traffic sang service mới.
5. Theo dõi correctness/performance.
6. Loại bỏ phần cũ sau khi migration hoàn tất.

Chọn capability ít coupling nhưng có business value; tránh bắt đầu bằng phần lõi transaction phức tạp nhất nếu team chưa có kinh nghiệm.

#### 37. Khi nào không nên dùng microservices?

- Team nhỏ, domain chưa rõ.
- Product đang tìm product–market fit và change xuyên domain thường xuyên.
- Không cần deploy/scale độc lập.
- Chưa có CI/CD, monitoring, on-call và platform basics.
- Strong transaction xuyên phần lớn domain là yêu cầu trung tâm.
- Latency cực thấp và in-process/locality quan trọng.
- Ngân sách không chịu được baseline infrastructure/operations.
- Vấn đề hiện tại có thể giải bằng modularization hoặc database optimization.

#### 38. Bài học từ các công ty quy mô lớn

Netflix, Uber và Amazon thường được nhắc vì họ có capability, traffic và team với scaling/release profile khác nhau. Bài học không phải “hãy sao chép số service”, mà là:

- architecture phản ứng với bottleneck kinh doanh/tổ chức thật;
- platform engineering và automation là điều kiện;
- boundary và ownership quan trọng hơn technology list;
- kiến trúc tiến hóa qua nhiều năm, không xuất hiện hoàn chỉnh từ đầu.

Ví dụ công ty chỉ là minh họa; kiến trúc cụ thể thay đổi theo thời gian và không nên dùng làm bằng chứng rằng mọi hệ thống cùng ngành cần microservices.

#### 39. Câu hỏi phỏng vấn từ tài liệu phụ

**1. Microservices là gì và khác monolith thế nào?**  
Là các service theo business capability có deployment/data/ownership boundary. Monolith có một deployment unit và local calls; microservices đổi chúng thành network/contract để lấy autonomy.

**2. Lợi ích và thách thức chính?**  
Lợi ích: deploy/scale/team ownership độc lập. Thách thức: network failure, consistency, contract, operations, observability, security và cost. Fault isolation chỉ có khi resilience được thiết kế.

**3. Xác định service thế nào?**  
Dùng DDD/bounded context, change pattern, data invariant, workload và team ownership; tránh entity-per-service và technical-layer service.

**4. API Gateway là gì và vì sao dùng?**  
Entry reverse proxy cho external traffic, routing, auth context, rate limit và composition có kiểm soát. Nó không thay authorization/service discovery toàn bộ và không nên chứa business logic lõi.

**5. Services giao tiếp thế nào?**  
REST/gRPC đồng bộ khi cần kết quả ngay; queue/pub-sub/event log bất đồng bộ khi có thể xử lý sau và muốn decoupling/buffering. Thường dùng kết hợp.

**6. Đảm bảo data consistency thế nào?**  
Giữ invariant trong local transaction; dùng saga, outbox/inbox, idempotency, reconciliation và explicit intermediate state. 2PC/event sourcing chỉ dùng khi constraint phù hợp.

**7. Deployment strategy phổ biến?**  
CI/CD cùng rolling, blue–green hoặc canary; schema expand-contract và contract compatibility. Service mesh không phải deployment strategy, mà là networking/policy infrastructure.

**8. Scaling strategies?**  
Scale service ngang theo metric đúng, sau đó bảo vệ/scale DB, cache, broker và downstream. Read replica/sharding chỉ theo access pattern và bottleneck.

**9. Ví dụ thực tế?**  
Netflix, Uber, Amazon minh họa independent capability/team scale; không phải blueprint để sao chép.

**10. Monitoring/debugging best practices?**  
Structured logs, RED/USE metrics, distributed traces, health semantics, SLO/error budget, event lag/lineage và ownership/runbook.

#### 40. Các lỗi tư duy thường gặp

- Coi microservices là “monolith bị chặt thành nhiều process”.
- Chia service theo entity hoặc technical layer.
- Shared database và direct cross-service table access.
- Service quá nhỏ gây chatty calls và distributed transaction.
- Synchronous call chain quá dài trên critical path.
- Retry ở gateway, service và client cùng lúc.
- Cho rằng event broker tự bảo đảm exactly-once business processing.
- Dùng saga nhưng không thiết kế compensation/reconciliation.
- Gọi service mesh là deployment strategy hoặc giải pháp mọi reliability problem.
- Autoscale app mà bỏ qua database/broker/downstream quota.
- Mỗi service chọn technology riêng không có governance.
- Central platform/on-call team sở hữu mọi service, làm mất autonomy.
- Big-bang rewrite monolith.
- Sao chép kiến trúc Netflix/Amazon mà không có cùng constraint.

#### 41. Câu hỏi tư duy thêm

1. Boundary nào giữ invariant “không bán vượt tồn kho” và vì sao?
2. Khi payment timeout, order service retry thế nào để không charge hai lần?
3. Một saga compensation thất bại thì hệ thống phục hồi ra sao?
4. Làm sao phát hiện distributed monolith qua deployment/trace/data access?
5. Khi nào event-carried state tốt hơn gọi API lấy chi tiết?
6. Contract test nào cần giữa producer event và ba consumer độc lập?
7. Autoscaling order service ảnh hưởng DB connection và broker partition thế nào?
8. Service mesh retry có thể gây duplicate write ra sao?
9. Chỉ số nào chứng minh việc tách service đã cải thiện delivery/autonomy?
10. Chọn capability đầu tiên cho Strangler migration theo tiêu chí nào?

#### 42. Ý chính cần nhớ

- Microservices tối ưu autonomy theo business capability, không tối ưu số lượng service.
- Boundary đúng dựa trên domain, invariant, change pattern, workload và team ownership.
- Database-per-service là data ownership, không bắt buộc một DB server vật lý cho mỗi service.
- Synchronous call tạo temporal coupling; async messaging tạo consistency/delivery complexity.
- Saga dùng local transaction và compensation; compensation không phải rollback hoàn hảo.
- Outbox/inbox cùng idempotency giúp xử lý dual write và duplicate delivery.
- Microservices không tự fault tolerant; timeout, retry budget, circuit breaker, bulkhead và load shedding là bắt buộc theo context.
- Independent deployment phụ thuộc contract/schema compatibility và CI/CD maturity.
- Observability, security và platform engineering là phần của architecture, không phải phụ kiện.
- Nếu chưa cần autonomy, modular monolith thường là lựa chọn tốt hơn.

#### Công thức ghi nhớ

> **Microservices đổi lời gọi cục bộ và transaction chung lấy autonomy của service và team. Chỉ thực hiện cuộc đổi này khi boundary đủ tốt và tổ chức sẵn sàng trả chi phí của distributed systems.**

---

### Bài 27. Event-Driven Architecture

#### 1. Event-Driven Architecture là gì?

**Event-Driven Architecture (EDA)** tổ chức hệ thống quanh việc tạo, truyền và xử lý **event** — một fact cho biết điều có ý nghĩa đã xảy ra.

```text
Producer
   │ OrderPlaced
   ▼
Broker / Event Log
   ├──> Payment Consumer
   ├──> Inventory Consumer
   ├──> Notification Consumer
   └──> Analytics Consumer
```

Producer không gọi trực tiếp từng consumer. Consumer đăng ký/đọc event và phản ứng theo trách nhiệm riêng. Điều này có thể giảm spatial/temporal coupling, hấp thụ burst và cho phép thêm reaction mới mà không sửa producer.

EDA không đồng nghĩa toàn bộ hệ thống chỉ dùng async event. Kiến trúc thực tế thường kết hợp:

- synchronous command/query khi caller cần kết quả ngay;
- asynchronous event khi thông báo fact và side effect có thể xử lý sau;
- stream processing cho dữ liệu liên tục;
- workflow orchestration cho business process nhiều bước.

#### 2. Event không phải command hay query

| Loại message | Ý nghĩa | Ví dụ | Receiver |
|---|---|---|---|
| **Command** | Yêu cầu thực hiện hành động; có thể bị từ chối | `ReserveInventory` | Thường một owner |
| **Event** | Fact đã xảy ra, dùng thì quá khứ | `InventoryReserved` | 0..N consumer |
| **Query** | Yêu cầu dữ liệu, không đổi business state | `GetAvailableStock` | Một provider |

Đặt event ở thì quá khứ giúp contract thể hiện sự thật bất biến. `SendEmail` là command; `OrderConfirmed` là event mà notification consumer có thể dùng để quyết định gửi email.

#### 3. EDA giải quyết loại coupling nào?

- **Spatial coupling**: producer không cần biết địa chỉ/instance consumer.
- **Temporal coupling**: producer và consumer không nhất thiết online cùng lúc nếu broker lưu message.
- **Cardinality coupling**: một event có thể có nhiều consumer.
- **Workflow coupling**: producer không cần hard-code mọi downstream reaction.

Nhưng coupling không biến mất; nó chuyển thành:

- event schema/data contract;
- semantic coupling về meaning;
- broker/platform dependency;
- ordering/delivery assumption;
- shared business workflow và latency expectation.

“Loosely coupled” phải được đánh giá theo các dimension này, không chỉ vì có broker ở giữa.

#### 4. Synchronous và asynchronous

```text
Synchronous:
A ── request ──> B
A <─ response ── B
A phải chờ B

Asynchronous:
A ── event ──> Broker ──> B/C/D
A tiếp tục sau khi publication contract được đáp ứng
```

| Synchronous | Asynchronous |
|---|---|
| Dễ hiểu control flow | Temporal decoupling, buffer burst |
| Kết quả/lỗi có ngay | Kết quả xuất hiện sau qua state/event khác |
| Caller phụ thuộc availability/latency của callee | Phụ thuộc broker, lag, retention và consumer recovery |
| Transaction/request tracing trực quan hơn | Cần correlation, event lineage và reconciliation |

Async không mặc nhiên non-blocking ở mọi implementation; producer có thể chờ broker acknowledgement/durable replication. Nó chỉ không chờ consumer hoàn thành business action.

---

#### Nhánh A — Các messaging model

#### 5. Queue / competing consumers

Một message được một worker trong consumer group xử lý:

```text
Producer → Queue ─┬─> Worker A
                  ├─> Worker B
                  └─> Worker C
```

Phù hợp job distribution như resize image, gửi email, generate report. Queue có thể durable hoặc transient tùy broker/configuration. ACK, visibility/redelivery và retry semantics phụ thuộc platform.

#### 6. Publish–subscribe

Một event được phân phối tới nhiều subscription:

```text
Publisher → Topic
              ├─> Billing subscription
              ├─> Notification subscription
              └─> Analytics subscription
```

Mỗi subscription có thể có nhiều competing consumers. Pub/sub mô tả **fan-out relationship**, không quy định event phải transient. RabbitMQ queue/exchange có thể cấu hình durability; SNS có thể fan-out sang durable SQS; Redis Pub/Sub lại thiên về ephemeral delivery.

#### 7. Event streaming / durable log

Event được append vào log có retention; consumer đọc theo offset:

```text
Partition 0: e0 → e1 → e2 → e3
                         ▲
                    consumer offset
```

Đặc điểm thường gặp:

- event lưu một khoảng thời gian hoặc theo size/policy;
- nhiều consumer group đọc độc lập;
- replay từ offset cũ;
- scale bằng partition;
- ordering thường chỉ trong một partition;
- event history có giá trị cho analytics, projection và recovery.

Durable log không mặc nhiên là **event sourcing**. Event sourcing dùng event làm source of truth cho domain state; một integration event log có thể chỉ là kênh truyền/retention.

#### 8. Pub/sub và streaming không phải hai hộp tuyệt đối

| Câu hỏi | Pub/Sub thiên về routing | Event streaming thiên về log |
|---|---|---|
| Mục tiêu | Phân phối event tới subscriber | Lưu và xử lý chuỗi event |
| Retention/replay | Tùy broker/subscription | Thường là capability cốt lõi |
| Consumption | Push hoặc pull | Thường consumer tự theo offset/pull |
| Ordering | Tùy queue/topic/config | Theo partition/shard scope |
| Use case | Notification, integration, task routing | Pipeline, analytics, CDC, replayable processing |

Sản phẩm hiện đại thường chồng lấn capability. Chọn theo semantics thật — durability, replay, routing, ordering, throughput, latency, operations — thay vì chỉ theo nhãn.

---

#### Nhánh B — Thành phần và event contract

#### 9. Event producer

Producer phát hiện/commit một thay đổi có ý nghĩa và publish event. Trách nhiệm không kết thúc đơn giản ở câu lệnh `publish()`; producer còn phải bảo đảm:

- event chỉ phát khi business state hợp lệ;
- không mất event do dual-write;
- schema/semantics có owner;
- event ID, timestamp và metadata đúng;
- publication failure/retry được quan sát;
- không phát dữ liệu nhạy cảm không cần thiết.

#### 10. Broker / event bus / log

Broker có thể cung cấp một phần:

- topic/queue và routing/filter;
- persistence/replication;
- ACK/redelivery;
- partitioning/ordering;
- consumer group;
- retention/replay;
- retry/DLQ;
- schema integration;
- access control/encryption;
- metrics về throughput, lag và storage.

Broker là failure domain/critical infrastructure. Cần capacity, replication, backup/config recovery, quota và operational ownership.

#### 11. Consumer

Consumer:

1. nhận event;
2. validate schema/authorization context cần thiết;
3. kiểm tra duplicate/version;
4. thực hiện local transaction/side effect;
5. ACK/commit offset sau khi processing đạt contract;
6. retry hoặc quarantine nếu lỗi.

ACK quá sớm có thể mất xử lý khi consumer crash; ACK quá muộn có thể redeliver và tạo duplicate. Vì thế idempotency là yêu cầu cốt lõi.

#### 12. Event store và projection

Event store/log lưu history phục vụ:

- replay/reprocessing;
- audit;
- rebuild materialized view;
- analytics;
- incident investigation.

Projection/read model được tạo từ event cho access pattern cụ thể. Rebuild cần deterministic handler, schema compatibility, version/offset checkpoint và cách cô lập side effect để replay không gửi email/charge payment lại.

#### 13. Event envelope

Một integration event nên có envelope nhất quán:

```json
{
  "id": "evt-01J...",
  "type": "com.example.order.v1.OrderPlaced",
  "source": "order-service",
  "subject": "orders/o-123",
  "occurredAt": "2026-08-16T10:15:30Z",
  "schemaVersion": 1,
  "correlationId": "checkout-789",
  "causationId": "cmd-456",
  "traceparent": "00-...",
  "data": {
    "orderId": "o-123",
    "customerId": "c-9",
    "total": {"amount": "49.90", "currency": "USD"}
  }
}
```

- `id`: dedup/tracing event cụ thể.
- `type`: semantic contract ổn định.
- `source/subject`: origin và entity/stream key.
- `occurredAt`: khi business fact xảy ra; khác thời gian broker ingest.
- `correlationId`: gom các message cùng business flow.
- `causationId`: message/action trực tiếp gây ra event.
- `traceparent`: nối distributed trace khi dùng chuẩn phù hợp.

Metadata không thay thế payload semantics và authorization. Event ID phải unique trong scope đã định nghĩa.

#### 14. Event notification và event-carried state

**Event notification:**

```json
{"type":"OrderChanged", "orderId":"o-123"}
```

Consumer gọi lại producer để lấy state:

- event nhỏ và tránh duplicate data;
- nhưng tạo runtime coupling, load và race “event nói đổi nhưng API đã sang version khác”.

**Event-carried state transfer:**

```json
{"type":"OrderChanged", "orderId":"o-123", "version":7, "status":"SHIPPED"}
```

- consumer xử lý không cần gọi lại;
- nhưng payload/schema/PII và duplication lớn hơn.

Chọn theo consumer need, data sensitivity, freshness và coupling. Không publish toàn database row như mặc định.

---

#### Nhánh C — Delivery, idempotency và ordering

#### 15. Delivery semantics

| Semantics | Ý nghĩa | Trade-off |
|---|---|---|
| **At-most-once** | Message có thể mất nhưng không redeliver theo protocol path | Hợp telemetry mất được |
| **At-least-once** | Broker/consumer retry để không mất, có thể duplicate | Phổ biến; cần idempotency |
| **Exactly-once trong scope hẹp** | Platform tránh duplicate effect trong boundary/transaction hỗ trợ | Không bao phủ mặc nhiên external side effect |
| **Effectively-once** | At-least-once delivery + dedup/idempotent business processing | Mục tiêu thực dụng phổ biến |

“Exactly once end-to-end” rất khó khi workflow chạm database, broker, email, payment provider và network khác nhau. Hãy nói rõ scope guarantee.

#### 16. Idempotent consumer

Các cách:

- unique constraint trên business/idempotency key;
- inbox table lưu `(consumer, eventId)` cùng local transaction;
- compare entity version và bỏ event cũ/trùng;
- upsert/set desired state thay vì increment mù;
- external provider idempotency key;
- dedup window/cache chỉ khi mất state cũ chấp nhận được.

```text
BEGIN
  INSERT inbox(event_id)  -- UNIQUE
  UPDATE order_projection ...
COMMIT
ACK
```

Nếu insert bị duplicate, consumer biết effect đã commit và có thể ACK.

Kafka log compaction **không phải consumer deduplication**. Compaction giữ bản record mới nhất theo key theo thời gian; consumer vẫn có thể thấy duplicate trước/trong quá trình xử lý và side effect ngoài log vẫn cần idempotency.

#### 17. Ordering scope

Global ordering thường đắt và làm giảm parallelism. Hỏi business cần ordering theo:

- order ID;
- account ID;
- customer/tenant;
- device ID;
- market instrument;
- toàn hệ thống?

Partition key nên gom event cùng entity/aggregate vào một partition:

```text
key = orderId
OrderCreated(v1) → OrderPaid(v2) → OrderShipped(v3)
```

Ordering trong partition vẫn có thể bị ảnh hưởng bởi producer retry/config, consumer concurrency, manual replay và merge từ nhiều source. Cần hiểu guarantee cụ thể của broker/client.

#### 18. Sequence/version handling

Consumer có thể lưu `lastAppliedVersion`:

- version = last + 1 → apply;
- version ≤ last → duplicate/stale, bỏ;
- version > last + 1 → phát hiện gap, pause/retry/reconcile.

Deduplication chỉ loại duplicate, không tự sửa out-of-order. Global sequencing service có thể tạo total order nhưng trở thành coordination bottleneck và failure domain; chỉ dùng nếu invariant thật sự yêu cầu.

#### 19. Partitioning và consumer groups

Topic được chia partition/shard. Trong một consumer group, thường một partition tại một thời điểm do một consumer member xử lý:

```text
P0 ──> Consumer A
P1 ──> Consumer B
P2 ──> Consumer C
```

Scale consumer vượt số active partition không tăng parallelism. Chọn partition count/key cần xét:

- throughput hiện tại và tương lai;
- hot key/tenant;
- ordering scope;
- rebalance cost;
- per-partition storage/connection overhead;
- khả năng tăng partition và ảnh hưởng key mapping/order.

#### 20. Backpressure và consumer lag

Producer rate > consumer processing rate làm backlog tăng. Theo dõi:

- consumer lag theo partition;
- oldest message age/end-to-end event latency;
- processing time/error/retry rate;
- queue depth/storage growth;
- hot partition;
- rebalance và idle consumer;
- DLQ growth.

Mitigation:

- scale consumer/partition khi parallelizable;
- batch và tối ưu downstream;
- giới hạn producer/rate hoặc admission control;
- tách workload nặng;
- coalesce/drop event chỉ khi semantics cho phép;
- tăng retention/headroom;
- load shed side effect không quan trọng.

EDA không tự giải quyết overload; broker chỉ trì hoãn thời điểm consumer bị áp lực và cần đủ retention/storage.

---

#### Nhánh D — Failure handling và consistency

#### 21. Retry policy

Phân loại:

- **Transient**: timeout, temporary unavailable → retry với backoff + jitter.
- **Permanent/business**: schema invalid, account closed → không retry mù.
- **Unknown**: cần quarantine/manual/reconciliation theo risk.

Cần max attempts/time, retry budget, delayed retry topic/queue và visibility. Immediate tight loop làm nóng broker/downstream.

#### 22. Dead-letter queue

DLQ/quarantine chứa message không xử lý được sau policy retry.

DLQ không phải “đã xử lý thành công”. Cần:

- alert theo count/rate/age;
- giữ original payload + error + attempt metadata;
- bảo vệ PII/secret;
- tooling inspect/redrive có authorization;
- fix root cause trước replay;
- replay idempotent và có rate limit;
- retention/ownership/runbook rõ.

Poison message làm partition/queue kẹt nếu retry vô hạn; DLQ giúp tiếp tục nhưng có thể phá ordering. Business phải quyết định skip, pause partition hay quarantine.

#### 23. Transactional outbox

Giải quyết dual-write business database + broker:

```text
Local transaction:
  INSERT order
  INSERT outbox_event

Publisher/CDC:
  outbox → broker
```

Outbox tạo at-least-once publication thực dụng; event có thể lặp nên consumer vẫn idempotent. Cần monitor outbox lag, publisher failure và cleanup/retention.

#### 24. Saga và business consistency

EDA thường dùng saga cho workflow nhiều local transaction:

```text
OrderPlaced
  → InventoryReserved
  → PaymentAuthorized
  → OrderConfirmed

Failure:
  PaymentDeclined
  → ReleaseInventory
  → CancelOrder
```

Choreography hợp reaction ngắn; orchestration giúp workflow dài dễ thấy state/timeout/compensation hơn. Compensation không phải rollback hoàn hảo; cần manual intervention/reconciliation cho failure khó.

#### 25. Eventual consistency có kiểm soát

Xác định rõ:

- state nào là source of truth;
- độ trễ hội tụ chấp nhận được;
- user thấy trạng thái trung gian nào;
- invariant nào không được eventual;
- cách phát hiện missing/gap;
- reconciliation job/repair path;
- SLO cho event processing lag;
- hành vi khi consumer down quá retention.

Không dùng “eventual consistency” như lý do bỏ qua correctness.

#### 26. Replay và reprocessing

Replay hữu ích để:

- rebuild projection;
- backfill consumer mới;
- sửa bug logic;
- khôi phục sau outage;
- chạy analytics mới.

Rủi ro:

- phát side effect lần nữa;
- schema/code mới không đọc event cũ;
- overload downstream;
- event time khác processing time;
- dữ liệu tham chiếu đã đổi;
- non-deterministic handler.

Tách pure projection khỏi side effect, hỗ trợ dry-run/shadow output, checkpoint và throttle replay.

---

#### Nhánh E — Schema, broker và vận hành

#### 27. Schema evolution

Các khái niệm:

- **Backward compatibility**: consumer/schema mới đọc được event cũ.
- **Forward compatibility**: consumer cũ chịu được event/schema mới.
- **Full compatibility**: cả hai hướng trong phạm vi rule.

Thực hành:

- thêm optional field với default/meaning rõ;
- không đổi type/meaning hoặc tái sử dụng field identifier;
- consumer bỏ qua field chưa biết khi format cho phép;
- deprecate → đo usage → ngừng producer → xóa sau retention/migration;
- schema registry/CI compatibility check;
- version event type khi semantic breaking, không chỉ thay số tùy tiện;
- upcaster/transformer khi cần đọc history cũ;
- contract test với consumer thực tế.

Schema registry kiểm tra structural compatibility, không chứng minh semantic meaning tương thích.

#### 28. Event design best practices

- Event là fact, tên rõ domain và thì quá khứ.
- Payload vừa đủ cho consumer có lý do hợp lệ.
- Không phụ thuộc database table/ORM representation.
- Có ID, source, subject/key, event time và schema/version metadata.
- Money dùng amount + currency; timestamp có timezone/UTC semantics.
- Tránh payload khổng lồ và dữ liệu mutable qua URL không bền.
- Không đưa secret; minimize PII và áp dụng retention/access policy.
- Phân biệt integration event với internal domain event.
- Owner/documentation/catalog và example rõ.

#### 29. So sánh Kafka, RabbitMQ và EventBridge theo capability

| Tiêu chí | Kafka | RabbitMQ | AWS EventBridge |
|---|---|---|---|
| Mô hình nổi bật | Partitioned durable log/event streaming | Queue/exchange routing, work queue/pub-sub | Managed event bus/rule-based routing |
| Retention/replay | Capability cốt lõi | Message có thể durable nhưng thường consumed/acked khỏi queue | Delivery routing; archive/replay có thể cấu hình theo capability |
| Ordering | Trong partition theo điều kiện/config | Theo queue trong điều kiện nhất định; consumer concurrency ảnh hưởng processing order | Không nên giả định total order |
| Scale | Partition và broker cluster | Queue/exchange/consumer topology | Managed scaling/quota theo service |
| Điểm mạnh | High-throughput stream, replay, consumer groups | Flexible routing, task queue, per-message ACK | AWS/SaaS integration, filtering, managed operations |
| Complexity | Cluster/partition/schema/retention | Queue topology, ACK, HA và flow control | Vendor/service limits, cost, AWS coupling |

Đây không phải bảng “công nghệ nào tốt nhất”. Cần benchmark và xét durability, message size, throughput, latency, ordering scope, replay, routing, multi-tenancy, ecosystem, cost và team operations.

#### 30. Observability cho async flow

Synchronous trace dựa vào call stack; async flow cần thêm:

- event ID, correlation ID, causation ID;
- trace context qua broker;
- producer publish latency/error;
- broker ingress/egress, partition/storage;
- consumer lag, processing latency/error;
- retry/DLQ/redrive;
- end-to-end business milestone latency;
- schema version và service build version;
- audit/event lineage.

Một event “đã publish” không có nghĩa business flow hoàn tất. Dashboard/SLO phải theo milestone như `OrderPlaced → OrderConfirmed`, không chỉ broker uptime.

#### 31. Security và governance

- TLS/encryption và workload identity.
- ACL theo producer/consumer/topic/queue.
- Least privilege; producer không tự ý publish mọi event type.
- Schema validation và payload size limit.
- Tenant isolation trong topic/key/consumer/data.
- PII minimization, encryption, retention và deletion strategy.
- Audit access/replay/redrive.
- Secret rotation và no credential trong payload/log.
- Quota/rate limit để chống noisy neighbor.
- Event catalog, owner, data classification và lifecycle policy.

Immutable log làm data deletion/compliance khó hơn; cần thiết kế key-based deletion, tombstone, encryption key destruction hoặc retention phù hợp tùy platform/legal requirement.

#### 32. Khi nào nên dùng EDA?

Phù hợp:

- nhiều reaction độc lập cho một business fact;
- workload burst cần buffer;
- producer/consumer cần scale hoặc deploy độc lập;
- audit/replay/stream analytics có giá trị;
- IoT/telemetry/log/CDC;
- notification và async side effect;
- workflow chấp nhận state trung gian/eventual consistency.

Không nên dùng làm mặc định khi:

- caller cần kết quả tức thì và workflow đơn giản;
- invariant cần local atomic transaction;
- team chưa có broker/observability/on-call maturity;
- volume thấp và direct call đơn giản hơn;
- event schema/ownership chưa rõ;
- complexity replay/idempotency vượt business value.

#### 33. Các use case điển hình

**E-commerce:** order fact fan-out tới inventory, payment workflow, fraud, analytics và notification. Cần saga/idempotency; không được giả định tất cả xử lý cùng lúc.

**Audit/logging:** append fact phục vụ điều tra/compliance; cần tamper control, privacy và retention.

**Real-time notification:** event kích hoạt push/WebSocket/SSE; delivery tới broker khác delivery tới device/user.

**IoT:** ingest sensor stream, partition theo device/site, window/aggregate và xử lý late event.

**Financial systems:** event có audit value và high throughput, nhưng ledger invariant/ordering/duplicate cần scope cực rõ; không phải mọi transaction đều eventual.

**CDC/data pipeline:** database change được stream sang search index, warehouse hoặc cache; cần snapshot + offset consistency và schema handling.

#### 34. Câu hỏi phỏng vấn từ tài liệu phụ

**1. EDA là gì và khác request–response thế nào?**  
EDA truyền fact qua event để consumer phản ứng async; request–response caller biết callee và chờ kết quả. EDA giảm một số coupling nhưng thêm delivery, ordering, schema và consistency complexity.

**2. Pub/Sub khác Event Streaming?**  
Pub/sub nhấn mạnh one-to-many routing; streaming nhấn mạnh durable ordered log và replay. Retention/ordering không thể kết luận chỉ từ nhãn, phải xem broker/config/scope.

**3. Thành phần chính?**  
Producer, broker/log, consumer và tùy nhu cầu event store/projection/schema registry/operational control.

**4. Thách thức và cách xử lý eventual consistency?**  
Mô hình state trung gian, local invariant, saga, outbox/inbox, idempotency, reconciliation, lag SLO và UX rõ; event sourcing không phải giải pháp mặc định.

**5. Bảo đảm ordering thế nào?**  
Chọn ordering scope/key, partition event cùng aggregate, giới hạn consumer concurrency, dùng sequence/version để phát hiện stale/gap. Total order rất đắt.

**6. DLQ là gì và vì sao quan trọng?**  
Quarantine message không xử lý được để pipeline tiếp tục và operator điều tra. DLQ cần alert, ownership, replay tool và retention; không phải “đã giải quyết”.

**7. Kafka, RabbitMQ và EventBridge khác nhau thế nào?**  
Kafka thiên về durable partitioned log; RabbitMQ thiên về queue/routing/ACK; EventBridge là managed rule-based event bus. Chọn theo semantics và operations, không theo slogan.

**8. Làm processing idempotent thế nào?**  
Event ID/business key, inbox + local transaction, unique constraint, entity version và idempotency key ở external side effect. Log compaction không đủ.

**9. Use case EDA tốt hơn direct call?**  
Order event có nhiều independent reaction như analytics, notification và fulfillment; producer không cần sửa khi thêm consumer. Critical transaction vẫn có thể cần orchestration/synchronous boundary.

**10. Xử lý schema evolution?**  
Additive compatible change, registry/CI check, deprecation/usage telemetry, upcasting/transform khi cần và semantic versioning cho breaking meaning.

#### 35. Các lỗi tư duy thường gặp

- Xem mọi message là event, kể cả command.
- Nghĩ broker loại bỏ coupling hoàn toàn.
- Cho rằng async nghĩa producer không chờ bất kỳ ACK/durability nào.
- Nói pub/sub luôn transient hoặc streaming luôn giữ event vĩnh viễn.
- Giả định Kafka/event log có global strict order.
- Dùng timestamp thay sequence/version cho ordering tuyệt đối.
- Cho rằng deduplication sửa được out-of-order.
- Cho rằng log compaction ngăn duplicate business side effect.
- ACK trước khi local effect commit.
- Retry vô hạn poison message.
- Có DLQ nhưng không ai monitor/redrive.
- Replay production event và vô tình gửi email/charge lại.
- Publish toàn database row, PII và internal schema.
- Dùng eventual consistency để biện minh state sai không có repair path.
- Chọn broker trước khi xác định delivery/ordering/replay requirement.

#### 36. Câu hỏi tư duy thêm

1. `OrderPlaced` nên mang toàn bộ order hay chỉ ID? Trade-off là gì?
2. Làm sao bảo đảm DB commit và event publication không lệch nhau?
3. Consumer crash sau commit DB nhưng trước ACK sẽ xảy ra gì?
4. Ordering cần theo order, customer hay toàn hệ thống?
5. Khi hot customer chiếm một partition, scale thế nào mà không phá order?
6. Replay projection làm sao tránh external side effect?
7. DLQ message có thể redrive khi schema/bug đã sửa bằng cách nào?
8. Event retention ngắn hơn thời gian consumer outage thì phục hồi ra sao?
9. Metric nào đo từ `OrderPlaced` tới `OrderConfirmed` thay vì chỉ broker health?
10. Khi nào synchronous API đơn giản và đúng hơn EDA?

#### 37. Ý chính cần nhớ

- EDA thiết kế quanh business facts và reaction, không chỉ quanh broker.
- Command, event và query có ownership/semantics khác nhau.
- Pub/sub nói về fan-out; streaming nói về durable log/replay; capability có thể chồng lấn.
- Delivery phổ biến là at-least-once, nên consumer phải idempotent.
- Exactly-once phải nói rõ scope; external side effect vẫn cần dedup/idempotency.
- Ordering nên giới hạn theo business key/partition; total order làm giảm scalability.
- Outbox giải quyết dual-write publication; inbox giúp xử lý duplicate.
- DLQ cần vận hành và replay có kiểm soát, không phải thùng rác.
- Schema evolution gồm cả structural và semantic compatibility.
- EDA chuyển complexity từ direct dependency sang consistency, delivery, ordering, replay và observability.

#### Công thức ghi nhớ

> **Event là sự thật đã xảy ra; broker chỉ vận chuyển hoặc lưu nó. Một EDA đáng tin cậy cần publication không mất, consumer idempotent, ordering có scope, schema tiến hóa được và failure có đường phục hồi.**

---

### Bài 28. Tổng kết phần Architectural Patterns

#### 1. Bức tranh tổng thể

Architectural pattern không chỉ là cách vẽ các box và arrow. Đó là những cách tiếp cận đã được kiểm chứng để giải quyết các nhóm vấn đề lặp lại về:

- scalability và performance;
- maintainability và evolvability;
- deployment và team autonomy;
- reliability và failure isolation;
- data consistency;
- security và operational complexity.

Mỗi pattern tối ưu một số thuộc tính bằng cách chấp nhận một nhóm trade-off khác. Vì vậy câu hỏi đúng không phải:

> “Pattern nào tốt nhất?”

mà là:

> “Pattern nào phù hợp nhất với business goals, architecture drivers, constraint và năng lực vận hành hiện tại?”

#### 2. Multi-tier architecture

Multi-tier chia application theo deployment responsibility như presentation, application/business và data tier.

**Giá trị chính:**

- separation of concerns;
- bảo vệ data sau application boundary;
- scale từng tier theo bottleneck;
- nhiều client tái sử dụng business capability;
- deployment topology dễ hiểu.

**Chi phí:**

- thêm network hop và latency;
- nhiều failure point;
- contract/version compatibility;
- observability và security xuyên tier;
- data tier vẫn thường là bottleneck khó nhất.

Điểm cần nhớ: **layer là ranh giới logic; tier là ranh giới triển khai**. Không nên thêm tier nếu boundary mới không tạo giá trị scale, security hoặc operations đủ lớn.

#### 3. Microservices architecture

Microservices chia hệ thống theo business capability/bounded context thành các service có ownership, data và deployment boundary tương đối độc lập.

**Giá trị chính:**

- team và deployment autonomy;
- scale capability có workload khác nhau;
- fault/process isolation có điều kiện;
- release cadence và technology/data choice linh hoạt hơn.

**Chi phí:**

- network latency và partial failure;
- distributed data consistency;
- contract/schema evolution;
- nhiều pipeline, runtime và on-call surface;
- tracing, security và platform engineering phức tạp;
- nguy cơ distributed monolith nếu boundary sai.

Microservices không tự tạo resilience hoặc delivery speed. Chúng chỉ tạo boundary để đạt các thuộc tính đó nếu service autonomy, CI/CD, observability, data ownership và team ownership được thiết kế đúng.

#### 4. Event-driven architecture

EDA cho producer phát business fact và consumer phản ứng bất đồng bộ qua broker/log.

**Giá trị chính:**

- temporal/spatial decoupling;
- fan-out tới nhiều consumer;
- buffer burst và scale consumer độc lập;
- mở rộng reaction mà ít sửa producer;
- replay/audit/stream processing khi dùng durable log.

**Chi phí:**

- eventual consistency;
- duplicate và ordering có scope;
- schema/semantic coupling;
- retry, DLQ, replay và reconciliation;
- khó quan sát business flow end-to-end;
- broker trở thành hạ tầng trọng yếu.

Event-driven không có nghĩa mọi interaction phải async. Command/query cần kết quả ngay vẫn có thể dùng synchronous API; event phù hợp để công bố fact và xử lý reaction không cần hoàn tất trong cùng request.

#### 5. Ba pattern có thể cùng tồn tại

```text
Web / Mobile Clients
        │
        ▼
Presentation Tier / API Gateway
        │
        ▼
Business Capabilities
  ├── Order Service
  ├── Payment Service
  └── Inventory Service
        │
        ▼
Event Broker / Stream
  ├── Notification Consumer
  ├── Analytics Consumer
  └── Fulfillment Consumer
        │
        ▼
Independent Data Tiers
```

Trong ví dụ này:

- multi-tier mô tả topology presentation/application/data;
- microservices mô tả service boundary theo business capability;
- event-driven mô tả cách một số service tích hợp bất đồng bộ.

Pattern không phải các lựa chọn loại trừ nhau. Cần xác định chúng đang được áp dụng ở scope nào và interaction nào.

#### 6. Bảng tổng kết trade-off

| Câu hỏi | Multi-tier | Microservices | Event-driven |
|---|---|---|---|
| Đơn vị tổ chức chính | Deployment tier theo responsibility | Service theo business capability | Producer, event, broker, consumer |
| Mục tiêu nổi bật | Structure, separation, security boundary | Autonomy, independent deployment/scale | Async decoupling, fan-out, buffering |
| Communication | Thường request–response giữa tier | API đồng bộ và/hoặc messaging | Message/event bất đồng bộ |
| Data | Thường centralized data tier | Data ownership theo service | Event/log cùng projection/read model |
| Consistency | Transaction thường tập trung hơn | Local transaction + cross-service workflow | Thường eventual giữa consumer |
| Failure chính | Tier bottleneck/unavailable | Cascade/partial failure | Lag, duplicate, poison message, missing event |
| Vận hành | Thấp đến vừa | Cao | Vừa đến cao |
| Khi hợp lý | Web/enterprise app cần structure rõ | Nhiều team/capability cần autonomy | Nhiều reaction, burst, streaming/replay |

#### 7. Khung lựa chọn kiến trúc

Trước khi chọn pattern, trả lời:

1. Business outcome và deadline là gì?
2. Quality attributes nào quan trọng nhất và có mục tiêu đo được không?
3. Workload hiện tại, peak và growth uncertainty ra sao?
4. Transaction invariant nào phải atomic?
5. Capability nào cần deploy hoặc scale độc lập?
6. Team boundary và ownership hiện tại thế nào?
7. Hệ thống chấp nhận eventual consistency ở đâu?
8. Availability, RTO và RPO cần đạt mức nào?
9. Team có CI/CD, observability, on-call và platform maturity tới đâu?
10. Build cost, migration cost và run cost có nằm trong ngân sách không?

Sau đó:

- đưa ra 2–3 option khả thi;
- ghi trade-off và assumption;
- prototype/load test rủi ro lớn nhất;
- ghi Architecture Decision Record;
- đặt metric/fitness function;
- review khi evidence thay đổi.

#### 8. Các nguyên tắc xuyên suốt

- Chọn kiến trúc đơn giản nhất vẫn đáp ứng requirements đã biết.
- Boundary và ownership quan trọng hơn technology list.
- Mỗi network/process boundary thêm latency và failure mode.
- Distributed state cần consistency, idempotency và recovery path rõ.
- Scale component này có thể chuyển bottleneck sang component khác.
- Fault isolation không tự xuất hiện chỉ vì có nhiều process.
- Observability, security và deployment là phần của architecture.
- Over-engineering cho scale giả định cũng nguy hiểm như under-engineering.
- Architecture tốt có thể tiến hóa, không cần dự đoán hoàn hảo tương lai.

#### 9. Những câu hỏi tự kiểm tra

1. Vì sao modular monolith thường là điểm khởi đầu tốt?
2. Khi nào thêm application tier có giá trị hơn direct database access?
3. Dấu hiệu nào chứng minh cần tách một capability thành microservice?
4. Làm sao nhận ra distributed monolith?
5. Workflow nào nên synchronous và workflow nào nên event-driven?
6. Invariant nào không được để eventual consistency?
7. Mỗi pattern tạo thêm failure mode và operational cost nào?
8. Metric nào sẽ xác minh assumption kiến trúc sau khi lên production?

#### 10. Cầu nối sang Web Fundamentals

Phần tiếp theo chuyển sang các khái niệm nền tảng của web application:

- state management phía client/server;
- serialization và data exchange;
- browser security mechanism như CORS;
- authentication/session/cookie/token;
- các quyết định thực tế khi xây web system có khả năng scale.

Architecture pattern định hình cấu trúc cấp cao; Web Fundamentals giải thích cách browser, client và backend thực sự trao đổi state/data một cách đúng và an toàn.

#### 11. Ý chính cần nhớ

- Pattern là công cụ giải quyết context cụ thể, không phải công thức chung.
- Multi-tier mua structure và deployment separation.
- Microservices mua service/team autonomy.
- Event-driven mua temporal decoupling và fan-out.
- Mỗi lợi ích đều đi kèm latency, consistency hoặc operational complexity.
- Pattern có thể được kết hợp ở các scope khác nhau.
- Lựa chọn phải dựa trên business goals, quality attributes, team và evidence.
- Khả năng giải thích trade-off quan trọng hơn việc ghi nhớ diagram.

#### Công thức ghi nhớ

> **Không có kiến trúc đúng cho mọi hệ thống. Kiến trúc tốt là tập quyết định có chủ đích, tạo đúng lợi ích cho business và chỉ mang theo mức complexity mà đội ngũ có thể vận hành.**

---

## Thuật ngữ nhanh

| Thuật ngữ | Cách hiểu ngắn gọn |
|---|---|
| **System Design** | Thiết kế cấu trúc, thành phần, dữ liệu và cách vận hành của một hệ thống. |
| **Architecture** | Kiến trúc tổng thể và mối quan hệ giữa các thành phần. |
| **Component** | Một bộ phận đảm nhận một nhóm trách nhiệm trong hệ thống. |
| **Trade-off** | Sự đánh đổi: cải thiện một mặt có thể làm tăng chi phí hoặc ảnh hưởng mặt khác. |
| **Scalability** | Khả năng phục vụ tải ngày càng lớn. |
| **Reliability** | Khả năng hoạt động đúng và ổn định khi có sự cố. |
| **Performance** | Tốc độ phản hồi và năng lực xử lý của hệ thống. |
| **Maintainability** | Mức độ dễ vận hành, sửa đổi và phát triển hệ thống. |
| **Boundary** | Ranh giới phân chia trách nhiệm giữa các thành phần hoặc dịch vụ. |
| **Monolith** | Kiến trúc trong đó phần lớn chức năng được đóng gói và triển khai trong một ứng dụng thống nhất. |
| **Load balancer** | Thành phần phân phối yêu cầu đến nhiều máy chủ hoặc phiên bản dịch vụ. |
| **CDN** | Mạng máy chủ phân tán dùng để cung cấp nội dung từ vị trí gần người dùng. |
| **Database replication** | Duy trì các bản sao dữ liệu trên nhiều máy hoặc nút cơ sở dữ liệu. |
| **Cloud computing** | Cung cấp tài nguyên điện toán theo nhu cầu qua nền tảng đám mây. |
| **NoSQL** | Nhóm cơ sở dữ liệu không bị giới hạn trong mô hình bảng quan hệ truyền thống. |
| **Microservices** | Kiến trúc chia hệ thống thành nhiều dịch vụ nhỏ có trách nhiệm riêng. |
| **Event-driven architecture** | Kiến trúc trong đó các thành phần giao tiếp hoặc phản ứng thông qua sự kiện. |
| **API gateway** | Điểm tiếp nhận chung, định tuyến và quản lý yêu cầu đến các dịch vụ phía sau. |
| **Observability** | Khả năng suy ra trạng thái bên trong hệ thống từ log, metric, trace và tín hiệu liên quan. |
| **Elasticity** | Khả năng tự điều chỉnh tài nguyên theo mức tải. |
| **Networking** | Cách các máy và thành phần trao đổi dữ liệu qua mạng. |
| **Communication pattern** | Mẫu tương tác giữa các thành phần, chẳng hạn đồng bộ, bất đồng bộ hoặc hướng sự kiện. |
| **Storage system** | Thành phần và cơ chế dùng để lưu trữ, tổ chức và truy xuất dữ liệu. |
| **Reliability engineering** | Hoạt động thiết kế và vận hành nhằm giữ hệ thống ổn định, có khả năng chịu lỗi và phục hồi. |
| **Security architecture** | Cấu trúc và nguyên tắc bảo vệ hệ thống, dữ liệu và quyền truy cập. |
| **Case study** | Phân tích một bài toán thực tế để hiểu cách áp dụng và đánh đổi giữa các giải pháp. |
| **Mental model** | Mô hình tư duy giúp diễn giải một hệ thống và suy luận về hành vi của nó. |
| **Operational constraint** | Giới hạn phát sinh từ việc triển khai, giám sát, bảo trì và vận hành hệ thống. |
| **Second-order effect** | Tác động gián tiếp hoặc phát sinh tiếp theo từ một quyết định ban đầu. |
| **Network latency** | Thời gian cần để dữ liệu di chuyển qua mạng giữa các điểm. |
| **Network hop** | Một chặng mà dữ liệu đi qua giữa các thiết bị hoặc thành phần mạng. |
| **Hotspot** | Thành phần nhận lượng tải lớn bất thường và có nguy cơ trở thành điểm nghẽn. |
| **Horizontal scaling** | Tăng năng lực bằng cách bổ sung thêm máy hoặc instance thay vì tăng cấu hình một máy. |
| **Resilience** | Khả năng chống chịu, thích nghi và phục hồi khi một phần hệ thống gặp sự cố. |
| **Availability** | Mức độ hệ thống sẵn sàng phục vụ khi người dùng cần. |
| **Region** | Một khu vực địa lý chứa hạ tầng triển khai dịch vụ cloud. |
| **Multi-region deployment** | Triển khai hệ thống tại nhiều khu vực địa lý để giảm độ trễ hoặc tăng khả năng chịu lỗi. |
| **Hybrid cloud** | Môi trường kết hợp hạ tầng tại chỗ với dịch vụ cloud hoặc nhiều loại hạ tầng khác nhau. |
| **Proxy** | Thành phần trung gian nhận và chuyển tiếp lưu lượng giữa client và dịch vụ đích. |
| **Messaging system** | Hạ tầng truyền message giữa các thành phần, thường hỗ trợ giao tiếp bất đồng bộ. |
| **IP address** | Địa chỉ dùng để định danh và định vị một interface hoặc endpoint trong mạng IP. |
| **IPv4** | Phiên bản IP sử dụng không gian địa chỉ 32 bit. |
| **IPv6** | Phiên bản IP sử dụng không gian địa chỉ 128 bit, hướng tới quy mô Internet dài hạn. |
| **Public IP** | Địa chỉ có thể được định tuyến trên Internet và phải được quản lý duy nhất trong phạm vi công cộng. |
| **Private IP** | Địa chỉ dùng trong mạng riêng, có thể được tái sử dụng ở các mạng tách biệt. |
| **NAT** | Cơ chế chuyển đổi địa chỉ mạng, thường cho phép nhiều endpoint private chia sẻ public IP. |
| **PAT** | Một dạng NAT sử dụng cả địa chỉ và port để nhiều kết nối chia sẻ cùng public IP. |
| **Endpoint** | Điểm cuối có thể gửi, nhận hoặc cung cấp một dịch vụ qua mạng. |
| **Packet** | Đơn vị dữ liệu được đóng gói để truyền qua mạng. |
| **Routing** | Quá trình lựa chọn đường đi để chuyển packet từ nguồn đến đích. |
| **VPC** | Mạng riêng ảo được cô lập về mặt logic trong môi trường cloud. |
| **Network segmentation** | Chia mạng thành các vùng để kiểm soát luồng giao tiếp và giới hạn phạm vi rủi ro. |
| **Attack surface** | Tổng hợp những điểm mà kẻ tấn công có thể cố gắng tiếp cận hoặc khai thác. |
| **Service discovery** | Cơ chế giúp client hoặc service tìm ra địa chỉ hiện tại của service cần gọi. |
| **Zero trust** | Mô hình bảo mật không mặc định tin cậy chỉ dựa trên vị trí mạng; mọi truy cập đều phải được xác minh. |
| **IPsec** | Bộ giao thức bảo vệ lưu lượng IP bằng xác thực và mã hóa khi được cấu hình sử dụng. |
| **Layer 4 load balancing** | Phân phối kết nối dựa trên thông tin tầng vận chuyển, thường gồm IP, port và TCP/UDP. |
| **Layer 7 load balancing** | Định tuyến dựa trên thông tin giao thức ứng dụng như HTTP hostname, path hoặc header. |
| **DNS resolver** | Thành phần thay mặt client thực hiện quá trình tìm bản ghi DNS và lưu cache kết quả. |
| **Authoritative DNS server** | Máy chủ nắm giữ và trả lời có thẩm quyền cho bản ghi của một DNS zone. |
| **TTL** | Khoảng thời gian một bản ghi được phép lưu trong cache trước khi cần truy vấn lại. |
| **Dual stack** | Mô hình hệ thống hoặc thiết bị vận hành đồng thời IPv4 và IPv6. |
| **DNS** | Hệ thống tên miền phân tán dùng để ánh xạ domain tới các record phục vụ việc tìm và kết nối dịch vụ. |
| **Domain name** | Tên phân cấp, dễ nhớ được dùng để định danh một tài nguyên hoặc dịch vụ trên mạng. |
| **Root name server** | Lớp trên cùng của DNS hierarchy, chỉ resolver tới TLD name server phù hợp. |
| **TLD name server** | Máy chủ của top-level domain, chỉ tới authoritative server của domain cụ thể. |
| **Delegation** | Cơ chế một vùng DNS giao trách nhiệm quản lý namespace con cho name server khác. |
| **DNS cache** | Nơi lưu tạm kết quả phân giải để giảm latency và số truy vấn upstream. |
| **DNSSEC** | Cơ chế chữ ký số giúp kiểm tra tính xác thực và toàn vẹn của dữ liệu DNS. |
| **Cache poisoning** | Tấn công đưa dữ liệu DNS giả hoặc sai vào cache để chuyển hướng truy cập. |
| **Anycast** | Cơ chế nhiều địa điểm quảng bá cùng một IP và mạng định tuyến lưu lượng tới một địa điểm phù hợp. |
| **DNS-based routing** | Sử dụng câu trả lời DNS để định hướng client tới endpoint theo policy như geography, health hoặc weight. |
| **Failure domain** | Nhóm tài nguyên có thể cùng bị ảnh hưởng bởi một sự cố chung. |
| **A record** | DNS record ánh xạ hostname tới địa chỉ IPv4. |
| **AAAA record** | DNS record ánh xạ hostname tới địa chỉ IPv6. |
| **CNAME record** | DNS record khai báo một hostname là bí danh của hostname khác. |
| **MX record** | DNS record chỉ định mail server nhận email cho một domain. |
| **NS record** | DNS record chỉ định authoritative name server của một DNS zone. |
| **Glue record** | Bản ghi địa chỉ được cung cấp kèm delegation để resolver có thể tìm name server khi cần. |
| **Round-robin DNS** | Luân phiên thứ tự hoặc tập IP trong câu trả lời nhằm phân tán truy cập ở mức cơ bản. |
| **Weighted routing** | Phân phối câu trả lời hoặc lưu lượng theo tỷ lệ trọng số đã cấu hình. |
| **DoH** | DNS over HTTPS, mã hóa truy vấn DNS giữa client và resolver bên trong HTTPS. |
| **DoT** | DNS over TLS, mã hóa kết nối DNS giữa client và resolver bằng TLS. |
| **NXDOMAIN** | Phản hồi DNS cho biết tên miền được hỏi không tồn tại. |
| **Negative caching** | Cache câu trả lời không tồn tại để tránh lặp lại các truy vấn vô ích. |
| **RRL** | Response Rate Limiting, giới hạn tốc độ một số phản hồi DNS để giảm lạm dụng. |
| **Client** | Bên khởi tạo yêu cầu và tiêu thụ dữ liệu hoặc dịch vụ trong một interaction. |
| **Server** | Bên lắng nghe, xử lý yêu cầu và cung cấp dữ liệu hoặc dịch vụ. |
| **Request–response** | Mẫu giao tiếp trong đó một request tương ứng với một response. |
| **Round-trip** | Quãng giao tiếp từ nguồn tới đích và kết quả quay trở lại nguồn. |
| **Payload** | Phần dữ liệu nghiệp vụ được mang trong message, request hoặc response. |
| **HTTP status code** | Mã trong HTTP response biểu thị kết quả xử lý ở mức protocol. |
| **WebSocket** | Protocol cung cấp kênh giao tiếp hai chiều lâu dài giữa hai endpoint. |
| **Synchronous communication** | Kiểu giao tiếp trong đó luồng gọi chờ kết quả trước khi tiếp tục phần phụ thuộc. |
| **Asynchronous communication** | Kiểu giao tiếp tách thời điểm gửi công việc khỏi thời điểm nhận hoặc xử lý kết quả. |
| **Stateless server** | Server instance không phụ thuộc vào session state cục bộ từ request trước. |
| **Stateful server** | Server duy trì context liên quan đến client hoặc interaction qua nhiều request hay message. |
| **Session affinity** | Cơ chế cố gắng định tuyến các interaction của cùng một session tới cùng backend. |
| **Idempotency** | Thuộc tính cho phép lặp lại cùng thao tác mà không tạo thêm tác động ngoài dự kiến. |
| **Circuit breaker** | Cơ chế tạm ngừng gọi dependency đang lỗi để tránh khuếch đại sự cố. |
| **Backpressure** | Cơ chế làm chậm hoặc giới hạn nguồn gửi khi phía nhận không xử lý kịp. |
| **Jitter** | Độ biến động của latency hoặc khoảng thời gian retry. |
| **Fan-out** | Một request tạo ra nhiều lời gọi downstream song song hoặc liên tiếp. |
| **Persistent connection** | Kết nối được giữ mở để phục vụ nhiều lần trao đổi dữ liệu. |
| **Forward proxy** | Proxy đại diện cho client và kiểm soát hoặc chuyển tiếp outbound traffic tới destination. |
| **Reverse proxy** | Proxy đại diện cho backend và quản lý inbound traffic trước khi chuyển tới server nội bộ. |
| **Egress proxy** | Proxy kiểm soát traffic đi ra khỏi một network hoặc workload. |
| **Ingress** | Điểm hoặc luồng traffic đi vào một hệ thống hay cluster. |
| **Origin server** | Server nguồn chứa hoặc tạo nội dung phía sau CDN hay reverse proxy. |
| **TLS termination** | Kết thúc TLS tại proxy hoặc load balancer để giải mã và xử lý traffic. |
| **TLS passthrough** | Chuyển tiếp TLS connection mà proxy không giải mã nội dung ứng dụng. |
| **TLS re-encryption** | Tạo TLS connection mới từ proxy tới backend sau khi đã terminate connection phía client. |
| **mTLS** | Mutual TLS, trong đó hai phía cùng trình bày và xác minh certificate. |
| **WAF** | Web Application Firewall, lọc request ứng dụng theo rule hoặc tín hiệu bảo mật. |
| **X-Forwarded-For** | Header thường dùng để truyền chuỗi địa chỉ client/proxy qua các lớp trung gian. |
| **Trusted proxy** | Proxy mà backend được cấu hình tin cậy để nhận metadata đã chuẩn hóa. |
| **Egress IP** | Địa chỉ public đại diện cho traffic đi ra từ một network hoặc hệ thống. |
| **Traffic splitting** | Chia traffic theo tỷ lệ hoặc policy giữa nhiều backend hay phiên bản. |
| **TLS origination** | Proxy khởi tạo TLS connection tới upstream hoặc backend thay cho client ban đầu. |
| **Load balancer** | Thành phần phân phối connection hoặc request qua một pool backend theo health và routing policy. |
| **Vertical scaling** | Tăng capacity bằng cách bổ sung tài nguyên cho một máy hoặc node hiện có. |
| **Scale up** | Cách gọi khác của vertical scaling. |
| **Scale out** | Cách gọi khác của horizontal scaling, bổ sung nhiều instance hoặc node. |
| **Backend pool** | Tập các server hoặc endpoint có thể nhận traffic từ load balancer. |
| **Rotation** | Trạng thái một backend đang được phép tham gia nhận traffic. |
| **Health check** | Kiểm tra định kỳ để xác định backend có thể nhận traffic hay không. |
| **Liveness** | Tín hiệu cho biết process còn sống hoặc cần được khởi động lại. |
| **Readiness** | Tín hiệu cho biết instance hiện sẵn sàng nhận traffic. |
| **Connection draining** | Ngừng gửi traffic mới nhưng cho interaction đang chạy hoàn thành trước khi loại backend. |
| **Headroom** | Phần capacity dự phòng chưa sử dụng để hấp thụ spike hoặc sự cố. |
| **Load shedding** | Chủ động từ chối một phần tải để bảo vệ phần cốt lõi của hệ thống. |
| **Saturation** | Trạng thái một tài nguyên đã tiến gần hoặc đạt giới hạn sử dụng. |
| **Retry budget** | Giới hạn lượng retry để tránh retry khuếch đại tải và sự cố. |
| **Backend health** | Trạng thái phản ánh khả năng một backend tiếp nhận và xử lý traffic. |
| **Autoscaling** | Tự động điều chỉnh số lượng hoặc capacity tài nguyên theo workload và policy. |
| **API Gateway** | Entry layer Layer 7 quản lý, bảo vệ và định tuyến API traffic tới backend services. |
| **Cross-cutting concern** | Trách nhiệm xuất hiện trên nhiều thành phần như auth, logging, rate limiting hoặc tracing. |
| **API composition** | Gọi nhiều backend API và hợp nhất kết quả thành một response. |
| **BFF** | Backend for Frontend, backend hoặc gateway layer được thiết kế riêng cho một loại client. |
| **Authentication** | Quá trình xác minh danh tính của user, client hoặc service. |
| **Authorization** | Quá trình quyết định một danh tính được phép thực hiện hành động nào trên tài nguyên nào. |
| **OAuth 2.0** | Framework ủy quyền cho phép client nhận access token để truy cập tài nguyên theo phạm vi. |
| **OpenID Connect** | Identity layer xây trên OAuth 2.0 để hỗ trợ authentication. |
| **JWT** | Định dạng token dạng JSON có thể mang claim và được ký hoặc mã hóa theo cấu hình. |
| **API key** | Giá trị nhận diện consumer/application và đôi khi dùng như credential, cần được bảo vệ phù hợp. |
| **Claim** | Thuộc tính được biểu diễn trong token, chẳng hạn issuer, audience, subject hoặc scope. |
| **Rate limiting** | Giới hạn tốc độ hoặc số lượng request theo identity, route, tenant hay policy. |
| **Quota** | Giới hạn tổng mức sử dụng trong một chu kỳ hoặc kế hoạch dịch vụ. |
| **Throttling** | Điều tiết traffic vượt policy bằng cách delay, shape hoặc reject tùy implementation. |
| **Token bucket** | Thuật toán rate limit cho phép request tiêu thụ token được bổ sung theo thời gian. |
| **Leaky bucket** | Thuật toán điều tiết output theo tốc độ tương đối ổn định. |
| **Fixed window** | Đếm request trong các cửa sổ thời gian cố định. |
| **Sliding window** | Giới hạn dựa trên khoảng thời gian trượt để giảm burst tại ranh giới cửa sổ. |
| **Bottleneck** | Thành phần có capacity giới hạn hiệu năng hoặc throughput của toàn hệ thống. |
| **Control plane** | Lớp quản lý configuration, policy, lifecycle và trạng thái điều khiển. |
| **Data plane** | Lớp trực tiếp xử lý và chuyển tiếp traffic thực tế. |
| **Fail open** | Khi dependency policy lỗi, hệ thống vẫn cho request đi qua theo degraded policy. |
| **Fail closed** | Khi không xác minh được policy, hệ thống từ chối request để ưu tiên an toàn. |
| **CDN** | Mạng edge phân tán dùng để tăng tốc, cache, tối ưu và bảo vệ việc phân phối nội dung. |
| **Edge server** | Server tại edge phục vụ cache hoặc xử lý request gần user hơn về network. |
| **PoP** | Point of Presence, địa điểm CDN chứa edge capacity và kết nối mạng. |
| **Cache hit** | Request được phục vụ từ object phù hợp đã có trong cache. |
| **Cache miss** | Cache không có object usable nên cần gọi upstream hoặc origin. |
| **Cache key** | Tập thuộc tính dùng để xác định các request có thể dùng chung một cached response. |
| **Cache hit ratio** | Tỷ lệ request được phục vụ từ cache. |
| **Byte hit ratio** | Tỷ lệ tổng số byte được phục vụ từ cache thay vì origin. |
| **Cache invalidation** | Quá trình làm cached object không còn được dùng sau khi nội dung thay đổi. |
| **Purge** | Yêu cầu xóa hoặc đánh dấu stale object trong CDN cache. |
| **Stale-while-revalidate** | Cho phép tạm trả object stale trong khi refresh nội dung ở background. |
| **Stale-if-error** | Cho phép trả object stale khi upstream gặp lỗi theo policy. |
| **ETag** | Validator đại diện cho một phiên bản của resource, dùng trong conditional request. |
| **Origin shield** | Tầng cache trung gian gom cache miss từ nhiều edge trước khi gọi origin. |
| **Request coalescing** | Gom nhiều request đồng thời cho cùng object vào một upstream fetch. |
| **Cache stampede** | Nhiều request đồng thời dồn về upstream khi object nóng bị miss hoặc hết hạn. |
| **Immutable asset** | Asset được xem là không thay đổi tại cùng URL, thường dùng URL có content hash. |
| **Signed URL** | URL chứa chữ ký và điều kiện truy cập để giới hạn quyền lấy private content. |
| **Multi-CDN** | Kiến trúc sử dụng nhiều CDN provider và traffic steering giữa chúng. |
| **Adaptive bitrate streaming** | Player tự chọn chất lượng segment dựa trên bandwidth và buffer hiện tại. |
| **Video segment** | Đoạn nhỏ của luồng video được tải và cache độc lập. |
| **Origin offload** | Phần request hoặc byte không còn phải phục vụ từ origin nhờ edge/cache. |
| **Cache fragmentation** | Cache bị chia thành quá nhiều variant hoặc provider, làm giảm khả năng tái sử dụng object. |
| **Protocol** | Tập quy tắc quy định cách các hệ thống định dạng, truyền, nhận và xử lý dữ liệu. |
| **Transport layer** | Lớp cung cấp giao tiếp giữa các process/endpoints trên nền network layer. |
| **Port** | Số logic giúp transport protocol chuyển dữ liệu tới đúng process hoặc socket trên máy. |
| **TCP** | Transport protocol connection-oriented cung cấp ordered reliable byte stream. |
| **UDP** | Transport protocol connectionless truyền các datagram độc lập theo best-effort. |
| **Datagram** | Message độc lập được truyền qua một datagram-oriented protocol như UDP. |
| **TCP segment** | Đơn vị dữ liệu TCP được đóng gói để truyền trên network. |
| **Three-way handshake** | Quy trình SYN, SYN-ACK, ACK dùng để thiết lập TCP connection. |
| **Sequence number** | Số thứ tự giúp theo dõi, sắp xếp và phát hiện dữ liệu thiếu hoặc lặp. |
| **Acknowledgement** | Tín hiệu xác nhận dữ liệu đã được nhận tới một vị trí nhất định. |
| **Retransmission** | Gửi lại dữ liệu khi protocol suy ra dữ liệu trước đó đã mất. |
| **Flow control** | Điều chỉnh tốc độ gửi theo khả năng tiếp nhận của receiver. |
| **Congestion control** | Điều chỉnh traffic để phản ứng với capacity và congestion của network. |
| **Head-of-line blocking** | Dữ liệu phía sau phải chờ phần phía trước bị thiếu hoặc chậm. |
| **Byte stream** | Chuỗi byte liên tục không tự bảo toàn ranh giới message của application. |
| **Full-duplex** | Hai phía có thể gửi và nhận dữ liệu đồng thời. |
| **Best-effort delivery** | Mô hình truyền không cam kết packet chắc chắn tới, đúng thứ tự hoặc không bị lặp. |
| **QUIC** | Secure transport chạy trên UDP, cung cấp reliability, multiplexed streams và congestion control. |
| **RTP** | Real-time Transport Protocol, thường dùng để truyền media real-time trên UDP. |
| **Forward error correction** | Thêm dữ liệu dư để receiver có thể phục hồi một phần loss mà không cần retransmission. |
| **MTU** | Maximum Transmission Unit, kích thước packet tối đa có thể truyền trên một link mà không cần phân mảnh ở lớp liên quan. |
| **Fragmentation** | Chia packet/datagram lớn thành các phần nhỏ; mất một phần có thể làm toàn bộ datagram không dùng được. |
| **5-tuple** | Source IP, source port, destination IP, destination port và protocol, dùng để nhận diện network flow. |
| **Stateful firewall** | Firewall theo dõi trạng thái hoặc flow context thay vì đánh giá mỗi packet hoàn toàn độc lập. |
| **UDP pseudo-state** | Trạng thái tạm do firewall/NAT suy ra từ 5-tuple và timeout cho UDP traffic. |
| **Reflection attack** | Attacker giả mạo địa chỉ nạn nhân để server thứ ba gửi response tới nạn nhân. |
| **Amplification attack** | Tấn công tạo response lớn hơn nhiều so với request nhằm khuếch đại traffic tới nạn nhân. |
| **Jitter buffer** | Buffer làm mượt biến động thời gian đến của packet trong media real-time. |
| **Pacing** | Điều tiết thời điểm gửi packet để tránh burst và giảm congestion. |
| **EDNS** | Extension mechanisms for DNS, mở rộng khả năng DNS, gồm quảng bá kích thước UDP payload hỗ trợ. |
| **Truncation** | Trạng thái DNS response bị cắt ngắn, thường khiến client thử lại qua transport phù hợp như TCP. |
| **DoQ** | DNS over QUIC, truyền DNS qua QUIC với mã hóa và transport semantics của QUIC. |
| **HTTP** | Application protocol định nghĩa request–response semantics cho web và API. |
| **URI** | Định danh một resource theo cú pháp chuẩn; URL là một dạng URI chỉ cả cách/vị trí truy cập. |
| **URL** | Địa chỉ gồm scheme, authority/host, path và các phần tùy chọn dùng để truy cập resource. |
| **HTTP method** | Động từ protocol thể hiện intended action như GET, POST, PUT hoặc DELETE. |
| **Safe method** | Method được thiết kế chỉ để đọc và không yêu cầu thay đổi state nghiệp vụ. |
| **HTTP header** | Metadata đi kèm request hoặc response. |
| **HTTP body** | Payload tùy chọn mang representation, command data hoặc error detail. |
| **Content negotiation** | Cơ chế client và server chọn representation dựa trên header như Accept. |
| **Content-Type** | Header cho biết media type của body đang được gửi. |
| **Accept** | Header cho biết loại representation client có thể hoặc muốn nhận. |
| **Cookie** | Dữ liệu nhỏ browser lưu và gửi theo domain/path cùng policy liên quan. |
| **Session** | Context của user/client được duy trì qua nhiều request, thường lưu phía server. |
| **Bearer token** | Credential mà bên sở hữu có thể trình bày để truy cập tài nguyên theo quyền của token. |
| **HTTPS** | HTTP được bảo vệ bằng secure transport dựa trên TLS hoặc QUIC. |
| **TLS** | Giao thức cung cấp encryption, integrity và peer authentication cho connection. |
| **HSTS** | Policy yêu cầu browser chỉ kết nối tới domain bằng HTTPS trong thời hạn khai báo. |
| **HTTP/1.1** | Phiên bản HTTP hỗ trợ persistent connection, Host header và framing kiểu HTTP/1.x. |
| **HTTP/2** | Phiên bản dùng binary framing, multiplexed streams và HPACK, thường chạy trên TCP. |
| **HTTP/3** | Phiên bản HTTP chạy trên QUIC, hỗ trợ multiplexed streams và QPACK. |
| **HPACK** | Cơ chế nén header của HTTP/2. |
| **QPACK** | Cơ chế nén header được thiết kế cho HTTP/3. |
| **Multiplexing** | Truyền nhiều logical stream đồng thời trên một connection. |
| **Chunked transfer** | Cơ chế HTTP/1.1 truyền body theo chunk khi chưa biết trước tổng độ dài. |
| **Conditional request** | Request kèm validator/điều kiện để tránh gửi lại representation không đổi. |
| **304 Not Modified** | Response xác nhận cached representation vẫn dùng được và không gửi lại representation body. |
| **Cache-Control** | Header chứa directive điều khiển freshness, storage và revalidation của HTTP cache. |
| **no-cache** | Directive cho phép lưu nhưng yêu cầu revalidate trước khi tái sử dụng. |
| **no-store** | Directive yêu cầu cache không lưu response. |
| **Vary** | Header cho biết request header nào tham gia phân biệt các cached representation. |
| **Retry-After** | Header gợi ý thời điểm hoặc khoảng chờ trước khi client thử lại. |
| **Idempotency key** | Khóa nhận diện một logical write để server tránh thực hiện trùng khi request được retry. |
| **CORS** | Cơ chế HTTP header cho phép browser kiểm soát cross-origin request theo policy của server. |
| **REST** | Architectural style cho distributed hypermedia system, dựa trên sáu constraints. |
| **RESTful API** | Cách gọi phổ biến cho API tuân thủ các nguyên tắc REST ở mức đáng kể. |
| **Resource** | Khái niệm có identity mà client có thể tham chiếu và thao tác qua representation. |
| **Representation** | Biểu diễn trạng thái resource ở một media type như JSON hoặc XML. |
| **Uniform interface** | REST constraint yêu cầu interface nhất quán, self-descriptive và hướng resource/hypermedia. |
| **Self-descriptive message** | Message chứa đủ metadata để bên nhận hiểu cách diễn giải và xử lý. |
| **HATEOAS** | Dùng hypermedia control trong response để hướng dẫn các state transition hợp lệ. |
| **Code on demand** | REST constraint tùy chọn cho phép server gửi executable code mở rộng client. |
| **JSON** | Data interchange format dạng text, phổ biến cho representation trong Web API. |
| **XML** | Markup format hỗ trợ document structure, namespace và schema phong phú. |
| **Offset pagination** | Phân trang bằng vị trí bắt đầu và giới hạn; đơn giản nhưng có thể chậm hoặc thiếu ổn định. |
| **Cursor pagination** | Phân trang bằng opaque cursor dựa trên vị trí/sort key đã đọc. |
| **Optimistic concurrency control** | Chỉ cập nhật khi version vẫn đúng, tránh ghi đè thay đổi đồng thời. |
| **If-Match** | Conditional request header yêu cầu current representation khớp validator trước khi ghi. |
| **412 Precondition Failed** | Status cho biết điều kiện request như If-Match không còn đúng. |
| **OpenAPI** | Đặc tả machine-readable để mô tả HTTP API contract và sinh tooling liên quan. |
| **Backward compatibility** | Khả năng thay đổi producer mà consumer cũ vẫn tiếp tục hoạt động đúng. |
| **API versioning** | Chiến lược phân biệt các phiên bản contract qua URI, header, media type hoặc query. |
| **SOAP** | XML-based messaging protocol thường đi cùng WSDL và WS-* specifications. |
| **GraphQL** | Query language và runtime cho phép client yêu cầu các field theo typed graph schema. |
| **gRPC** | RPC framework dựa trên schema/code generation, thường dùng Protocol Buffers và HTTP/2. |
| **Object-level authorization** | Kiểm tra principal có quyền truy cập đúng object cụ thể hay không. |
| **Mass assignment** | Lỗ hổng khi server bind field client gửi vào model mà không giới hạn thuộc tính được sửa. |
| **Media type** | Nhãn mô tả định dạng và semantics của representation, ví dụ application/json. |
| **Real-time communication** | Trao đổi update với latency đủ thấp để đáp ứng yêu cầu tức thời của use case. |
| **Soft real-time** | Hệ thống ưu tiên deadline/latency thấp nhưng đôi khi trễ không gây lỗi thảm họa. |
| **Short polling** | Client gửi request định kỳ để kiểm tra dữ liệu mới. |
| **Long polling** | Server giữ HTTP request tới khi có event hoặc timeout rồi client mở request mới. |
| **SSE** | Server-Sent Events, stream event một chiều server-to-client qua HTTP. |
| **EventSource** | Browser API dùng để nhận SSE stream và hỗ trợ reconnect. |
| **Last-Event-ID** | Giá trị giúp SSE client yêu cầu tiếp tục stream sau event đã nhận cuối cùng. |
| **WebSocket** | Protocol cung cấp message channel full-duplex lâu dài sau handshake. |
| **WebSocket frame** | Đơn vị framing mang text, binary hoặc control data trên WebSocket connection. |
| **WebSocket handshake** | Quá trình khởi tạo/nâng cấp HTTP connection thành WebSocket channel. |
| **101 Switching Protocols** | HTTP status cho biết server chấp nhận đổi protocol trong HTTP/1.1 upgrade flow. |
| **wss** | WebSocket được bảo vệ bằng TLS. |
| **Heartbeat** | Tín hiệu định kỳ dùng để phát hiện connection hoặc peer không còn hoạt động. |
| **Ping/Pong** | WebSocket control frames hỗ trợ kiểm tra peer và duy trì connectivity. |
| **Reconnect storm** | Nhiều client reconnect đồng thời, tạo spike lên gateway và dependency. |
| **Resume token** | Token/context cho phép client tiếp tục stream từ vị trí đã biết sau reconnect. |
| **Sequence number** | Số thứ tự trong một ordering scope, giúp phát hiện gap, duplicate hoặc out-of-order event. |
| **Presence** | Trạng thái user/device đang online và connection/node mà nó gắn vào. |
| **Connection registry** | Ánh xạ connection/user/subscription tới node đang giữ socket. |
| **Slow consumer** | Client nhận/xử lý event chậm hơn tốc độ server tạo hoặc gửi dữ liệu. |
| **Message coalescing** | Gộp nhiều state update để chỉ gửi kết quả mới nhất hoặc một batch. |
| **Fan-out amplification** | Một event đầu vào tạo ra số lượng lớn message đầu ra tới subscriber. |
| **WebRTC** | Bộ công nghệ giao tiếp media/data peer-to-peer thời gian thực, thường dùng cho gọi audio/video. |
| **Webhook** | HTTP callback server-to-server được gửi khi event xảy ra. |
| **Cross-Site WebSocket Hijacking** | Tấn công lợi dụng browser credential để mở WebSocket trái phép từ origin khác. |
| **RPC** | Remote Procedure Call, mô hình gọi operation trên service từ xa như gọi hàm. |
| **Protocol Buffers** | Schema language và binary serialization format do Google phát triển. |
| **proto file** | File định nghĩa Protobuf message, enum và gRPC service contract. |
| **Client stub** | Generated client code đóng gói việc gọi remote method và serialize message. |
| **Unary RPC** | RPC có một request và một response. |
| **Server streaming RPC** | RPC trong đó server gửi nhiều message response cho một request. |
| **Client streaming RPC** | RPC trong đó client gửi nhiều message rồi nhận một response. |
| **Bidirectional streaming RPC** | RPC cho phép hai phía gửi nhiều message độc lập trên cùng stream. |
| **gRPC metadata** | Key-value metadata đi kèm RPC, thường mang auth hoặc tracing context. |
| **gRPC interceptor** | Hook/middleware bao quanh RPC để áp dụng policy như auth, logging và metrics. |
| **gRPC-Web** | Biến thể/cầu nối cho phép browser client giao tiếp với gRPC backend qua proxy hỗ trợ. |
| **Deadline propagation** | Truyền remaining time budget từ caller xuống downstream RPC. |
| **GraphQL schema** | Contract định nghĩa type, field, argument và operation của graph API. |
| **Resolver** | Hàm lấy hoặc tính giá trị cho một GraphQL field. |
| **GraphQL query** | Operation đọc trong đó client chọn field cần nhận. |
| **GraphQL mutation** | Operation thay đổi state theo contract GraphQL. |
| **GraphQL subscription** | Operation nhận result theo event/stream qua transport được triển khai. |
| **N+1 query problem** | Một lần tải danh sách kéo theo một query/call riêng cho từng phần tử. |
| **DataLoader** | Pattern/tool batch và memoize load theo key, thường trong phạm vi một request. |
| **Query complexity** | Ước lượng chi phí GraphQL query dựa trên field, depth, list size và fan-out. |
| **Persisted query** | GraphQL document được đăng ký/nhận diện bằng ID hoặc hash thay vì gửi toàn văn mỗi lần. |
| **Normalized cache** | Client cache lưu entity theo identity và ghép chúng vào nhiều query result. |
| **Partial response** | Response chứa một phần data hợp lệ cùng error cho phần khác. |
| **Nullability** | Quy tắc GraphQL xác định field có thể trả null và cách lỗi lan lên parent. |
| **GraphQL federation** | Kiến trúc ghép nhiều subgraph/domain schema thành một graph thống nhất. |
| **Subgraph** | Phần GraphQL schema và resolver do một service/domain sở hữu trong federation. |
| **Over-fetching** | Client nhận nhiều dữ liệu hơn mức cần cho use case. |
| **Under-fetching** | Một response không đủ dữ liệu, buộc client thực hiện thêm request. |
| **Sparse fieldset** | Cơ chế HTTP API cho phép client chọn một tập field trong representation. |
| **Architectural style** | Tập constraint/hình dạng tổng thể quy định cách tổ chức và tương tác của hệ thống. |
| **Architectural pattern** | Giải pháp kiến trúc tái sử dụng cho một vấn đề trong context và trade-off nhất định. |
| **Architectural tactic** | Quyết định có phạm vi hẹp nhằm đạt quality attribute như availability hoặc performance. |
| **Quality attribute** | Thuộc tính phi chức năng có thể đánh giá như scalability, reliability hoặc maintainability. |
| **Architecture driver** | Requirement hoặc constraint có ảnh hưởng quyết định tới cấu trúc kiến trúc. |
| **Modular monolith** | Một deployable application nhưng có module boundary và dependency được kiểm soát rõ. |
| **Layered architecture** | Tổ chức responsibility thành các lớp logic với interface/dependency xác định. |
| **Layer** | Boundary logic dùng để nhóm responsibility trong code hoặc design. |
| **Tier** | Boundary triển khai vật lý/process/network có thể scale hoặc vận hành độc lập. |
| **N-tier architecture** | Kiến trúc phân bố application qua nhiều deployment tier. |
| **Separation of concerns** | Tách các trách nhiệm khác nhau để giảm coupling và dễ thay đổi/test. |
| **Coupling** | Mức độ một component phụ thuộc vào component khác. |
| **Cohesion** | Mức độ các responsibility trong một module cùng phục vụ một mục đích liên quan. |
| **Bounded context** | Ranh giới trong đó một domain model và ngôn ngữ có meaning nhất quán. |
| **Distributed monolith** | Hệ thống tách thành service nhưng vẫn coupling chặt, phải deploy/thay đổi phối hợp. |
| **Event** | Fact bất biến mô tả điều đã xảy ra trong domain hoặc hệ thống. |
| **Command** | Message yêu cầu một receiver thực hiện hành động cụ thể. |
| **Event broker** | Hạ tầng nhận, lưu/chuyển và phân phối event tới consumer theo semantics hỗ trợ. |
| **Event notification** | Event ngắn báo có thay đổi; consumer có thể gọi nguồn để lấy chi tiết. |
| **Event-carried state transfer** | Event mang state cần thiết để consumer cập nhật mà không gọi ngược producer. |
| **Event sourcing** | Lưu chuỗi event làm nguồn sự thật để tái dựng state. |
| **Poison message** | Message liên tục xử lý thất bại do nội dung hoặc điều kiện không thể khắc phục bằng retry thường. |
| **Dead-letter queue** | Nơi cách ly message không xử lý được sau policy retry. |
| **Transactional outbox** | Ghi business state và outbox record trong cùng transaction rồi publish event sau. |
| **Architecture Decision Record** | Tài liệu ngắn ghi context, decision, alternatives và consequences của quyết định kiến trúc. |
| **Fitness function** | Phép kiểm tra/metric tự động hoặc định kỳ xác minh architecture vẫn đạt thuộc tính mong muốn. |
| **Evolutionary architecture** | Cách xây kiến trúc có khả năng thay đổi dần dựa trên feedback và constraint mới. |
| **Blast radius** | Phạm vi user/component bị ảnh hưởng khi change hoặc failure xảy ra. |
| **Multi-tier architecture** | Phân bố application qua nhiều deployment tier có responsibility riêng. |
| **One-tier architecture** | UI, logic và data cùng nằm trong một local application/deployment boundary. |
| **Two-tier architecture** | Client/thick client giao tiếp trực tiếp với data server/database tier. |
| **Three-tier architecture** | Tách presentation, application/business và data thành ba deployment tier. |
| **Presentation tier** | Tier phục vụ UI, web content hoặc interaction với client. |
| **Application tier** | Tier thực thi use case, business rule, validation và coordination. |
| **Data tier** | Tier cung cấp persistence, query, transaction và data durability. |
| **Thick client** | Client chứa đáng kể business logic và có thể truy cập data service trực tiếp. |
| **Connection pooling** | Tái sử dụng tập connection có giới hạn để giảm chi phí thiết lập và bảo vệ downstream. |
| **Replica lag** | Độ trễ giữa state ở primary và replica, có thể làm read trả dữ liệu cũ. |
| **Read-your-writes consistency** | Bảo đảm client đọc thấy write vừa hoàn tất của chính nó. |
| **Availability zone** | Failure domain hạ tầng tách biệt trong một cloud region. |
| **Multi-AZ deployment** | Triển khai qua nhiều availability zone để chịu lỗi một zone tốt hơn. |
| **Version skew** | Trạng thái nhiều phiên bản component/contract cùng tồn tại trong lúc rollout. |
| **Expand-and-contract migration** | Thay schema/contract qua các bước tương thích trước khi loại bỏ dạng cũ. |
| **Latency budget** | Phần thời gian tối đa phân cho từng hop/component trong deadline tổng. |
| **Workload identity** | Danh tính dùng để xác thực và cấp quyền cho service/process thay vì con người. |
| **Intrusion detection system** | Hệ thống phát hiện traffic hoặc hành vi có dấu hiệu xâm nhập. |
| **Service boundary** | Ranh giới ownership, contract, deployment và data của một service. |
| **Database per service** | Mỗi service sở hữu data/schema và không cho service khác truy cập trực tiếp. |
| **Polyglot persistence** | Dùng nhiều loại data store theo nhu cầu từng capability. |
| **Aggregate** | Nhóm domain object tạo thành consistency/transaction boundary. |
| **Ubiquitous language** | Từ vựng domain nhất quán được business và engineering cùng sử dụng. |
| **Context map** | Mô tả quan hệ, integration và dependency giữa các bounded context. |
| **Local transaction** | Transaction được commit trong boundary data của một service/aggregate. |
| **Saga** | Chuỗi local transaction phối hợp business workflow, có compensation khi cần. |
| **Saga choreography** | Các bước saga tiến triển nhờ service phản ứng với event của nhau. |
| **Saga orchestration** | Coordinator điều khiển sequence và trạng thái của saga. |
| **Compensating action** | Business action bù cho bước đã hoàn tất; không nhất thiết khôi phục hoàn hảo. |
| **Two-Phase Commit** | Distributed commit protocol gồm prepare và commit/abort qua các participant. |
| **Inbox pattern** | Lưu message ID/kết quả xử lý để consumer tránh side effect trùng. |
| **Dual-write problem** | Nguy cơ hai write tới DB/broker khác nhau không cùng thành công atomically. |
| **Service mesh** | Infrastructure layer quản lý traffic, identity/policy và telemetry giữa service. |
| **Sidecar proxy** | Proxy chạy cạnh workload để xử lý network concern thay application. |
| **Consumer-driven contract test** | Test contract dựa trên expectation mà consumer công bố cho producer. |
| **Schema registry** | Kho quản lý message schema, version và compatibility rule. |
| **Blue–green deployment** | Chạy hai environment/version và chuyển traffic sang version mới khi sẵn sàng. |
| **Canary deployment** | Rollout version mới cho một phần traffic rồi mở rộng dựa trên guardrail. |
| **Rolling deployment** | Thay dần instance cũ bằng instance mới trong cùng pool. |
| **Strangler Fig pattern** | Thay monolith dần bằng capability mới và chuyển traffic theo từng phần. |
| **Error budget** | Mức unreliability được phép trong SLO window để cân bằng reliability và tốc độ thay đổi. |
| **Span** | Một đơn vị công việc có thời gian/metadata trong distributed trace. |
| **Event lineage** | Khả năng theo dõi event từ producer qua broker tới các consumer và kết quả. |
| **Contract testing** | Xác minh producer và consumer cùng tuân thủ interface/schema đã thỏa thuận. |
| **Spatial coupling** | Dependency vào identity/location cụ thể của component giao tiếp. |
| **Temporal coupling** | Yêu cầu các component phải available cùng thời điểm để interaction hoàn tất. |
| **Semantic coupling** | Dependency vào meaning và business interpretation của contract/message. |
| **Event envelope** | Metadata chuẩn bao quanh event payload như ID, type, source, time và correlation. |
| **Correlation ID** | ID gom các message/operation thuộc cùng một business flow. |
| **Causation ID** | ID của message/action trực tiếp gây ra event hiện tại. |
| **Event time** | Thời điểm business event thực sự xảy ra, khác processing/ingestion time. |
| **Pub/Sub** | Mô hình publisher gửi tới topic và nhiều subscription nhận bản event riêng. |
| **Message queue** | Hàng đợi phân phối work/message, thường cho competing consumers. |
| **Topic** | Kênh logic dùng để publish và subscribe message/event. |
| **Consumer group** | Nhóm consumer chia nhau xử lý partition/message của cùng logical subscription. |
| **Partition** | Phần chia của topic/log, là đơn vị parallelism và thường là ordering scope. |
| **Offset** | Vị trí của record trong partition/log dùng để theo dõi tiến độ consumer. |
| **Retention** | Policy quy định event/message được giữ bao lâu hoặc tới kích thước nào. |
| **Event replay** | Đọc và xử lý lại event lịch sử từ offset/time/checkpoint trước. |
| **Projection** | Read model/state được xây bằng cách áp dụng chuỗi event. |
| **Materialized view** | Kết quả truy vấn/aggregation được tính và lưu sẵn để đọc nhanh. |
| **At-most-once delivery** | Delivery có thể mất message nhưng không chủ động redeliver trong scope protocol. |
| **At-least-once delivery** | Delivery retry để giảm mất message nhưng có thể đưa message trùng. |
| **Effectively-once processing** | Hiệu ứng nghiệp vụ như một lần nhờ at-least-once kết hợp idempotency/dedup. |
| **Exactly-once scope** | Boundary cụ thể mà platform cam kết tránh duplicate processing/effect. |
| **Message acknowledgement** | Tín hiệu consumer/broker xác nhận message đã đạt mốc xử lý theo contract. |
| **Consumer lag** | Khoảng cách giữa vị trí mới nhất của log và vị trí consumer đã xử lý. |
| **Hot partition** | Partition nhận tải mất cân đối do key distribution hoặc workload skew. |
| **Retry topic** | Topic/queue trung gian giữ message trước lần thử lại sau delay. |
| **Redrive** | Đưa message từ DLQ/retry store trở lại pipeline để xử lý lại có kiểm soát. |
| **Log compaction** | Retention mode giữ record mới nhất theo key theo thời gian; không phải consumer dedup. |
| **Upcaster** | Logic chuyển event schema cũ sang representation mới khi đọc/replay. |
| **Change Data Capture** | Ghi nhận thay đổi trong database log/table và phát chúng sang pipeline khác. |
| **Tombstone** | Record biểu thị xóa key/state trong log hoặc compacted stream. |
