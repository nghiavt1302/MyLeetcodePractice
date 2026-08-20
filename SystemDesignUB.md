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

## Phần 5 — Web Concepts in System Design

### Bài 29. Introduction to Web Concepts

#### 1. Vì sao kiến thức Web quan trọng trong System Design?

Hầu hết hệ thống hiện đại — e-commerce, social network, SaaS, cloud service hay internal platform — đều có web/browser/API boundary. Kiến trúc sư cần hiểu không chỉ backend topology mà cả hành vi của:

- browser và HTTP;
- cookie, session và token;
- client/server state;
- serialization/data format;
- cache và content delivery;
- authentication/authorization;
- same-origin policy và CORS;
- các trust boundary giữa browser, edge và backend.

Những khái niệm này ảnh hưởng trực tiếp tới scalability, latency, bandwidth, security và developer experience. Một lựa chọn nhỏ như đặt session ở memory local hay Redis có thể quyết định cách load balancer failover; một cookie attribute sai có thể mở ra session theft hoặc CSRF.

#### 2. Web concepts không phải kiến thức “frontend trivia”

Trong system design interview, câu hỏi về cookie, CORS, session hoặc serialization đánh giá khả năng suy luận end-to-end:

```text
Browser
  │ DNS / TLS / HTTP / Cookie / CORS
  ▼
CDN / Reverse Proxy / API Gateway
  │ auth context / cache / routing
  ▼
Application Services
  │ serialization / session / data access
  ▼
Cache / Database / Message Broker
```

Nếu chỉ nhìn backend service mà không hiểu browser tự gửi cookie khi nào, preflight hoạt động ra sao hoặc token được lưu ở đâu, thiết kế có thể đúng về capacity nhưng sai về security.

#### 3. Những architecture driver của Web

- **State**: dữ liệu nào nằm ở browser, application server, shared store hay database?
- **Trust**: dữ liệu nào do client kiểm soát và phải xác minh lại?
- **Identity**: request được gắn với user/device/session thế nào?
- **Serialization**: format ảnh hưởng payload, compatibility và CPU ra sao?
- **Origin boundary**: browser cho phép script đọc/gửi request tới domain nào?
- **Caching**: response có thể dùng chung hay chứa dữ liệu cá nhân?
- **Failure**: client retry, session store down hoặc token hết hạn thì điều gì xảy ra?
- **Scale**: state có cản horizontal scaling và multi-region routing không?

#### 4. Lộ trình phần 5

1. **Web sessions và state management** — cookie, server-side session, token và distributed session.
2. **Serialization** — JSON, XML, Protobuf, Avro và schema evolution.
3. **Browser security/CORS** — same-origin policy, preflight, credential và cấu hình an toàn.
4. **Tổng kết** — nối các khái niệm vào kiến trúc web production.

#### 5. Nguyên tắc học phần này

- Phân biệt protocol behavior với application convention.
- Không tin dữ liệu chỉ vì nó đến từ browser.
- Security phải bao phủ toàn lifecycle, không chỉ lúc login.
- “Stateless” không có nghĩa hệ thống không có state.
- “Client-side” không có nghĩa dữ liệu an toàn hoặc đáng tin.
- Chọn format/session mechanism theo threat model và workload.
- Tối ưu performance không được làm sai authorization hoặc cache isolation.

#### Công thức ghi nhớ

> **Web system design bắt đầu ở browser chứ không bắt đầu tại backend. State, identity, serialization và origin policy trên request path quyết định hệ thống có thể scale an toàn hay không.**

---

### Bài 30. Web Sessions — Quản lý trạng thái trong ứng dụng Web

#### 1. Vì sao cần web session?

HTTP là stateless: mỗi request có semantics độc lập và protocol không tự duy trì user context từ request trước. HTTP không cấm server lưu dữ liệu; nó chỉ không cung cấp application session mặc định.

Web session giúp liên kết nhiều request với cùng một user/browser context để:

- duy trì trạng thái đăng nhập;
- lưu shopping cart hoặc checkout progress;
- nhớ preference/language;
- quản lý CSRF state;
- giới hạn quyền theo authentication context;
- theo dõi device/session riêng biệt.

Không nên dồn mọi state vào authentication session. Cart dài hạn, preference và business state thường nên được lưu bền vững trong domain database; session chỉ giữ reference/context ngắn hạn.

#### 2. Bốn khái niệm dễ bị trộn lẫn

| Khái niệm | Là gì? | Ví dụ |
|---|---|---|
| **Cookie** | Cơ chế browser lưu key/value và tự gửi theo matching rules | Session ID, CSRF cookie |
| **Server-side session** | State phía server được tra bằng session ID | User ID, login time, auth level |
| **Token** | Credential/claim do issuer phát; có thể opaque hoặc self-contained | Access token, JWT |
| **Browser storage** | API lưu client data, không tự gửi với HTTP request | `localStorage`, `sessionStorage` |

Cookie có thể chứa session ID, opaque token hoặc JWT. “Cookie-based” và “token-based” không phải hai nhóm luôn loại trừ nhau; **cách vận chuyển/lưu credential** khác với **dạng credential và nơi giữ state**.

#### 3. Stateless HTTP và stateful user experience

```text
Request 1: POST /login + credential
Response : Set-Cookie: session=<opaque-id>

Request 2: GET /account + Cookie: session=<opaque-id>
Server   : tra session → xác định user/quyền
```

Mỗi request vẫn tự mang session identifier. Server không nên suy luận user chỉ từ TCP connection hoặc instance đã phục vụ request trước.

Persistent HTTP connection không đồng nghĩa persistent login session. Một connection có thể đóng nhưng session vẫn tồn tại; một connection có thể dùng nhiều request nhưng authentication context vẫn phải được xác định đúng.

---

#### Nhánh A — Server-side sessions

#### 4. Login flow

```text
Browser                  App Server                  Session Store
   │ POST /login              │                            │
   ├─────────────────────────>│ verify credentials         │
   │                          ├── create session ──────────>│
   │<── Set-Cookie: sid=R... ─┤                            │
   │                          │                            │
   │ GET /profile + sid       │                            │
   ├─────────────────────────>│── lookup sid ─────────────>│
   │                          │<─ user/session context ────│
   │<── profile response ─────│                            │
```

Session ID nên:

- được sinh bằng cryptographically secure random;
- có entropy đủ lớn và không đoán được;
- opaque, không chứa user ID/PII/role có thể sửa;
- rotate sau login, privilege change và sự kiện rủi ro;
- chỉ map tới state phía server;
- có TTL và lifecycle policy.

#### 5. Session record nên chứa gì?

Tối thiểu:

- stable user/principal ID;
- session creation/last activity;
- authentication level/method;
- expiry/idle deadline;
- device/session metadata vừa đủ cho security;
- CSRF secret nếu dùng synchronizer token pattern;
- version/revocation marker khi cần.

Tránh nhét toàn user profile, permission graph hoặc payload lớn nếu có thể lấy từ source/cache riêng. Session store sẽ trở thành hot path của mọi authenticated request.

#### 6. Lifecycle của session

1. **Create** sau authentication thành công.
2. **Rotate** session ID để chống fixation.
3. **Use** trên request phù hợp.
4. **Renew** theo idle policy nhưng không vượt absolute lifetime.
5. **Step-up authentication** cho action nhạy cảm.
6. **Revoke** khi logout, password reset, compromise hoặc admin action.
7. **Expire** theo idle và absolute timeout.
8. **Cleanup** store/index/device list.

Phân biệt:

- **Idle timeout**: hết hạn sau một khoảng không hoạt động.
- **Absolute timeout**: hết hạn sau thời gian tối đa kể từ login dù vẫn active.

#### 7. Ưu và nhược điểm

Ưu điểm:

- revoke/logout ngay bằng xóa/disable session;
- server kiểm soát session state và policy;
- cookie chỉ cần mang opaque ID nhỏ;
- dễ cập nhật quyền/context trong lần tra cứu tiếp theo;
- phù hợp browser web app và high-security session.

Trade-off:

- mỗi request có thể cần session lookup;
- store trở thành critical dependency;
- cần replication/failover/capacity/TTL;
- multi-region session routing/consistency khó;
- local session cản horizontal scaling.

Server-side session không mặc nhiên an toàn hơn token; session ID bị đánh cắp vẫn là bearer credential. Security phụ thuộc cookie, TLS, rotation, timeout và authorization.

---

#### Nhánh B — Cookies và browser storage

#### 8. Cookie matching

Browser chỉ tự gửi cookie khi request khớp các rule như domain, path, secure transport, expiry và SameSite context.

```http
Set-Cookie: __Host-session=RANDOM_OPAQUE_ID;
  Path=/;
  Secure;
  HttpOnly;
  SameSite=Lax;
  Max-Age=1800
```

- `Secure`: chỉ gửi qua secure transport như HTTPS.
- `HttpOnly`: JavaScript không đọc được qua `document.cookie`.
- `SameSite`: kiểm soát gửi cookie trong cross-site context.
- `Path`: phạm vi URL path.
- `Domain`: phạm vi host/subdomain; bỏ `Domain` tạo host-only cookie.
- `Max-Age`/`Expires`: thời hạn lưu cookie.
- prefix `__Host-`: yêu cầu `Secure`, `Path=/` và không có `Domain`, giúp giới hạn scope mạnh hơn khi browser hỗ trợ.

`HttpOnly` giảm khả năng XSS đọc cookie nhưng XSS vẫn có thể thực hiện action trong page context. Cần output encoding, CSP, input handling và giảm XSS root cause.

#### 9. SameSite

- `Strict`: cookie không được gửi trong phần lớn cross-site navigation; bảo vệ mạnh nhưng có thể làm hỏng flow từ link ngoài/SSO.
- `Lax`: cân bằng phổ biến; cho một số top-level safe navigation nhưng hạn chế cross-site subrequest/form POST.
- `None`: cho phép cross-site context và phải đi cùng `Secure` trong browser hiện đại; cần CSRF defense khác.

SameSite là defense-in-depth, không thay thế CSRF token/origin verification cho mọi use case.

#### 10. Session cookie và persistent cookie

- **Session cookie** không có `Max-Age`/`Expires`; thường tồn tại tới khi browser session kết thúc, nhưng browser restore behavior có thể khác kỳ vọng.
- **Persistent cookie** có expiry; tồn tại qua browser restart tới khi hết hạn/xóa.

Cookie lifetime không nên dài hơn server-side session validity. Server luôn phải kiểm tra session chưa expire/revoke; không tin chỉ vì browser còn cookie.

#### 11. localStorage và sessionStorage

- `localStorage`: tồn tại theo origin qua browser restart cho tới khi xóa.
- `sessionStorage`: tồn tại theo origin và tab/window session.
- Cả hai không tự gửi với request.
- JavaScript trong origin có thể đọc, nên XSS có thể đánh cắp token/data.

Không lưu long-lived bearer credential trong browser storage theo thói quen mà không threat-model XSS. `sessionStorage` không phải server-side session và không tự an toàn chỉ vì đóng tab sẽ mất.

#### 12. Cookie size và performance

Cookie matching được gửi trên nhiều request tới scope tương ứng. Cookie lớn:

- tăng request bandwidth/latency;
- có thể bị gửi cả cho asset nếu domain/path quá rộng;
- chạm browser/server header limits;
- làm log/proxy surface chứa credential nếu cấu hình sai.

Giữ session cookie nhỏ và scope hẹp. Không nhét profile/cart lớn vào cookie.

---

#### Nhánh C — Token-based authentication

#### 13. Opaque token và self-contained token

**Opaque token:** random value, resource server/gateway tra/introspect state tại authorization server/cache.

**Self-contained token:** chứa claim và được ký, ví dụ JWT; resource server có thể validate signature/claim cục bộ.

```text
JWT = header.payload.signature
```

JWT thường **được ký chứ không được mã hóa**. Payload base64url có thể đọc được; không đặt secret/PII nhạy cảm nếu không có encryption/use-case phù hợp.

#### 14. Access token flow khái quát

```text
Client ── authenticate/authorize ──> Identity Provider
Client <──── short-lived access token + refresh mechanism

Client ── Authorization: Bearer <access-token> ──> API
API ── validate signature/issuer/audience/expiry/scope ──> authorize resource
```

OAuth 2.0 là authorization framework. OpenID Connect bổ sung identity/authentication layer. JWT là token format; access token không bắt buộc là JWT.

#### 15. JWT validation checklist

- Chỉ chấp nhận algorithm dự kiến; không tin `alg` tùy ý.
- Xác minh signature bằng đúng issuer key.
- Validate `iss` (issuer).
- Validate `aud` (audience/service).
- Validate `exp`, `nbf`, clock skew hợp lý.
- Validate token type/use (`typ`, scope/purpose theo contract).
- Xác minh subject/tenant/scope/role nhưng vẫn authorize resource.
- Xử lý key ID/rotation an toàn; không fetch key từ URL không tin cậy.
- Giới hạn token lifetime và không log token.

Signature hợp lệ không có nghĩa request được phép truy cập object cụ thể.

#### 16. Statelessness và revocation trade-off

Self-contained access token giảm session lookup nhưng claim có thể stale tới khi token hết hạn:

- user bị khóa;
- role/permission thay đổi;
- device bị mất;
- token bị đánh cắp;
- logout toàn bộ session.

Mitigation:

- access token ngắn hạn;
- refresh token rotation/reuse detection;
- revocation list/token version cho high-risk case;
- introspection ở boundary cần control mạnh;
- key rotation chỉ vô hiệu hóa hàng loạt và không phải fine-grained logout;
- re-check policy/data cho action nhạy cảm.

Một token system vẫn giữ state cho refresh token, consent, revocation hoặc user status. “Stateless authentication” thường chỉ mô tả access-token validation path, không phải toàn identity system.

#### 17. Refresh token

Refresh token dùng để xin access token mới, không nên gửi tới mọi resource service.

Best practices theo loại client/threat model:

- long-lived hơn access token nhưng được bảo vệ mạnh;
- rotate sau mỗi use và phát hiện reuse;
- bind với client/device/session nếu phù hợp;
- revoke khi logout/compromise;
- lưu server-side hashed/reference state khi thiết kế yêu cầu;
- giới hạn scope/audience;
- không đưa vào URL/log.

Browser architecture thường dùng secure HttpOnly cookie hoặc BFF pattern để giảm JavaScript tiếp xúc token; lựa chọn phụ thuộc CSRF/XSS và deployment topology.

#### 18. Sessions và tokens không có bảng thắng thua tuyệt đối

| Tiêu chí | Server-side session | Self-contained access token |
|---|---|---|
| Server lookup | Thường có | Có thể không trên mỗi request |
| Revocation | Trực tiếp | Khó hơn nếu không introspect/denylist |
| Claim freshness | Có thể cập nhật nhanh | Có thể stale tới expiry |
| Payload client gửi | Session ID nhỏ | Token thường lớn hơn |
| Horizontal scale | Cần shared/routed session | Validation phân tán thuận tiện |
| Failure dependency | Session store | Key distribution/issuer và refresh system |
| Security | Phụ thuộc lifecycle/cookie/store | Phụ thuộc validation/storage/lifetime |

JWT không mặc nhiên nhanh hơn: token lớn tăng bandwidth/signature CPU; session lookup trong cache có thể rất nhanh. Hãy benchmark và chọn theo control, revocation, client type và trust boundary.

---

#### Nhánh D — Scaling session management

#### 19. Local in-memory session

```text
Load Balancer
  ├── App A [Session U1]
  └── App B [không có U1]
```

Đơn giản cho một instance, nhưng request sang B hoặc A restart làm mất session. Phù hợp prototype/small deployment nếu chấp nhận limitation.

#### 20. Sticky sessions / session affinity

Load balancer cố định user/session về cùng instance.

Ưu:

- ít thay đổi application;
- không cần shared lookup trên happy path.

Nhược:

- load skew/hot user;
- failover làm mất local session;
- deploy/scale-in/draining khó;
- multi-region mobility khó;
- che giấu state coupling.

Sticky session là tactical bridge, không phải high-availability session solution một mình.

#### 21. Session replication

Application/container replicate session giữa nodes.

- failover tốt hơn local-only;
- nhưng network/memory write amplification tăng;
- consistency/conflict phức tạp;
- membership/rebalance cost tăng theo cluster.

Không phù hợp mọi scale; cần hiểu replication mode và failure semantics.

#### 22. Distributed session store

```text
                 Load Balancer
             ┌──────┼──────┐
             ▼      ▼      ▼
           App A  App B  App C
             └──────┼──────┘
                    ▼
          Distributed Session Store
```

Mọi app instance tra cùng store như Redis, Memcached hoặc database.

Thiết kế store cần:

- HA/replication/failover;
- TTL/expiry và eviction policy;
- capacity theo active sessions × record size × replication;
- latency p95/p99;
- connection pooling;
- encryption/auth/network isolation;
- cache/store outage behavior;
- backup chỉ khi business cần session survive disaster;
- hot key/abuse/rate limit;
- multi-region consistency/routing.

Không cấu hình eviction tùy tiện làm session hợp lệ biến mất dưới memory pressure. Redis có nhiều capability hơn Memcached nhưng chọn theo requirement, không theo slogan.

#### 23. Database-backed session

Ưu:

- durability, query/audit và transaction khả dụng;
- có thể tận dụng hạ tầng hiện có.

Nhược:

- database trở thành hot path;
- cleanup/TTL/index/write amplification;
- contention và latency lớn hơn cache chuyên dụng trong nhiều workload.

Có thể dùng database làm source of truth và cache làm acceleration nếu lifecycle/consistency được thiết kế rõ.

#### 24. Stateless access token

App instance validate token cục bộ, giảm shared session lookup. Nhưng cần:

- key/config distribution;
- revocation/refresh architecture;
- claim freshness policy;
- token size/bandwidth;
- protection tại client;
- clock/key rotation/issuer availability;
- authorization consistency giữa services.

Giảm một dependency trên request path nhưng tạo complexity khác; không phải “maximum scalability miễn phí”.

#### 25. Hybrid pattern

Thực tế thường kết hợp:

- short-lived access token cho API;
- server-side refresh/session record để revoke/device management;
- gateway/BFF giữ token và browser chỉ có secure session cookie;
- distributed store cho web sessions;
- database cho user/device/security state bền vững.

Chọn từng lớp theo consumer: browser, mobile, partner API và service account có threat model khác nhau.

#### 26. Capacity planning cho session store

Ước lượng cơ bản:

```text
Memory ≈ active sessions × average record size × replication factor × overhead
```

Theo dõi:

- active/new/expired sessions per second;
- lookup/write latency và error rate;
- hit/miss;
- memory/eviction;
- replication lag/failover;
- connection count;
- session size distribution;
- logout/revocation propagation;
- login spike sau outage.

Nếu session store down làm mọi request logout/retry login, authentication service có thể bị thundering herd. Cần degrade/recovery và rate limit.

---

#### Nhánh E — Session security

#### 27. Session hijacking

Attacker lấy session ID/token và dùng như bearer credential. Nguồn rò rỉ:

- HTTP không mã hóa;
- XSS hoặc malicious extension;
- log, analytics, URL/referer;
- insecure cookie scope;
- malware/device compromise;
- proxy/cache cấu hình sai.

Defense:

- HTTPS/HSTS;
- `Secure`, `HttpOnly`, `SameSite`;
- không đặt credential trong URL;
- short lifetime và rotation;
- revoke/device session management;
- CSP/output encoding để giảm XSS;
- re-auth/step-up cho action nhạy cảm;
- detect anomalous use nhưng tránh hard-bind IP gây false positive.

#### 28. Session fixation

Attacker khiến victim dùng session ID đã biết trước login; sau login attacker dùng lại ID đó.

Defense cốt lõi: **regenerate session ID sau authentication và privilege elevation**, không chấp nhận session ID từ URL hoặc nguồn không tin cậy, invalidate ID cũ.

#### 29. CSRF

CSRF lợi dụng việc browser tự gửi cookie/credential tới site đích dù request được kích hoạt từ site độc hại.

Defense:

- SameSite phù hợp;
- synchronizer CSRF token hoặc signed double-submit pattern;
- kiểm tra `Origin`/`Referer` cho unsafe request;
- không thay đổi state bằng GET;
- re-auth/transaction confirmation cho action nhạy cảm;
- custom header khi API/client architecture phù hợp.

**CORS không phải biện pháp chống CSRF chính.** Same-origin policy thường chặn script đọc response, nhưng form/navigation có thể vẫn gửi request và browser vẫn có thể đính cookie. CORS chỉ kiểm soát việc browser cho origin khác đọc/gửi một số cross-origin request theo policy.

#### 30. XSS và token storage

- HttpOnly cookie ngăn JS đọc credential nhưng XSS vẫn có thể gửi request trong origin.
- Token trong localStorage/sessionStorage có thể bị script độc hại đọc/exfiltrate.
- In-memory token giảm persistence nhưng không loại bỏ active XSS.
- CSP, Trusted Types khi phù hợp, output encoding, dependency hygiene và no inline unsafe script giúp giảm root cause.

Thiết kế phải cân bằng CSRF và XSS; không có một storage option loại bỏ cả hai mà không cần defense khác.

#### 31. Logout và revocation

Logout nên:

- xóa/expire cookie phía client;
- revoke/delete server session hoặc refresh token;
- invalidate session ID cũ;
- tùy chọn revoke một device hoặc tất cả device;
- ghi audit event;
- propagate tới service/gateway trong thời gian đã cam kết.

Chỉ xóa JWT khỏi client không ngăn bản sao bị đánh cắp tiếp tục dùng đến expiry. Short-lived access token + revocable refresh/session state là pattern phổ biến.

#### 32. Authentication và authorization trong microservices

```text
User → Identity Provider / OIDC
     → Gateway/BFF validates token/session
     → Service receives verified identity context
     → Service authorizes action/resource
```

- Central IdP phát identity/access credential.
- Gateway có thể validate và chuẩn hóa context.
- Service phải xác minh nguồn context và enforce authorization riêng.
- Token audience nên giới hạn đúng resource service.
- Không đưa refresh token qua mọi service.
- mTLS/workload identity dành cho service-to-service; user token biểu diễn user delegation.
- Authz decision có thể cần policy/data mới hơn claim trong token.

SSO giúp dùng một identity session qua nhiều application nhưng tăng criticality của IdP và cần logout/session propagation rõ.

#### 33. Session monitoring và audit

Theo dõi:

- login success/failure/rate;
- session create/rotate/revoke;
- concurrent sessions/device;
- refresh token reuse;
- invalid/expired token rate;
- CSRF validation failure;
- anomalous geography/device/velocity;
- session store latency/error/eviction;
- authorization denial theo resource;
- key rotation/validation failure.

Không log raw password, session ID, access token, refresh token hoặc sensitive claims.

---

#### 34. Câu hỏi phỏng vấn từ tài liệu phụ

**Q1. Vì sao HTTP stateless?**  
Mỗi request có semantics độc lập và HTTP không tự giữ application session. Server vẫn có thể lưu state qua session/database.

**Q2. Web app duy trì state thế nào?**  
Cookie/session ID, server-side session, opaque/self-contained token và browser storage cho non-secret client state. Mỗi cơ chế có transport/security khác nhau.

**Q3. Server session khác client token thế nào?**  
Session tra state phía server và revoke dễ; token tự chứa claim có thể validate phân tán nhưng revocation/claim freshness khó hơn. Không thể kết luận bên nào an toàn/nhanh hơn nếu chưa có threat model và benchmark.

**Q4. Khi nào dùng JWT thay session?**  
Khi nhiều resource server cần validate short-lived access token độc lập và claim staleness/revocation trade-off chấp nhận được. Không dùng JWT chỉ vì “microservices”.

**Q5. Cookie và session phối hợp thế nào?**  
Server tạo opaque session ID, lưu session record, gửi ID trong secure cookie; browser tự gửi cookie theo matching rules; server lookup và authorize request.

**Q6. Session hijacking và phòng chống?**  
Kẻ tấn công lấy bearer session credential. Dùng TLS, secure cookie, no URL/log credential, rotation, timeout, revoke, XSS defense và step-up auth.

**Q7. CSRF khai thác session ra sao?**  
Browser tự đính cookie vào request bị site khác kích hoạt. Giảm bằng SameSite, CSRF token, Origin check và không dùng GET cho state change; CORS không đủ.

**Q8. Vì sao dùng Secure, HttpOnly và SameSite?**  
Secure hạn chế transport, HttpOnly hạn chế JS đọc cookie, SameSite hạn chế cross-site sending. Chúng là defense-in-depth, không chữa mọi XSS/CSRF.

**Q9. Scale session trong distributed system?**  
Sticky session, replication, distributed store, database hoặc token/hybrid. Chọn theo availability, revocation, region, cost và security.

**Q10. Load-balanced system xử lý session storage thế nào?**  
Externalize session vào shared HA store hoặc dùng token validation; sticky session chỉ là tactical option và cần failover strategy.

**Q11. Authentication xuyên microservices thế nào?**  
Central IdP/OIDC, short-lived audience-bound access token, gateway/context verification, service-level authorization, refresh/session state tập trung và workload identity cho service calls.

**Q12. Large-scale application quản lý session ra sao?**  
Không có một đáp án chung. Thường kết hợp distributed session, short-lived token, refresh rotation, SSO/IdP, device management, regional routing và observability theo threat model.

#### 35. Các lỗi tư duy thường gặp

- Hiểu HTTP stateless là server không được lưu state.
- Đồng nhất cookie với session.
- Nghĩ token phải nằm trong localStorage hoặc JWT phải nằm trong header.
- Cho rằng JWT luôn encrypted, nhanh và an toàn hơn session.
- Đưa role/permission dài hạn vào token sống lâu rồi không xử lý stale claim.
- Chỉ xóa token phía client và gọi đó là revocation.
- Lưu session ID/token trong URL.
- Không rotate session ID sau login, dẫn tới fixation.
- Dùng `SameSite=None` mà không hiểu cross-site credential risk.
- Coi CORS là CSRF protection.
- Dùng sticky session nhưng không có failover/session loss plan.
- Để session store eviction làm user logout ngẫu nhiên.
- Gateway authenticate rồi service bỏ object-level authorization.
- Log raw session/token để debug.

#### 36. Câu hỏi tư duy thêm

1. User đổi role: session và JWT phản ánh thay đổi nhanh thế nào?
2. Session store down: fail open, fail closed hay degraded mode?
3. Logout một device khác logout mọi device ra sao?
4. Multi-region session cần consistency và routing mức nào?
5. Refresh token bị replay: rotation/reuse detection phản ứng thế nào?
6. Browser app dùng cookie auth cần CSRF defense gì?
7. Token trong localStorage và HttpOnly cookie có threat model khác nhau ra sao?
8. 10 triệu active session × 2 KB × replication factor 3 cần bao nhiêu memory trước overhead?
9. Session ID nên rotate ở những sự kiện nào ngoài login?
10. BFF pattern giảm token exposure nhưng thêm dependency nào?

#### 37. Ý chính cần nhớ

- HTTP stateless nhưng web application vẫn duy trì state bằng explicit mechanisms.
- Cookie là browser transport/storage; session là server state; token là credential/claim.
- Server-side session cho revoke/control tốt nhưng cần shared availability khi scale.
- Self-contained token giảm lookup nhưng làm revocation và claim freshness khó hơn.
- JWT thường được ký, không mặc nhiên encrypted.
- Secure, HttpOnly và SameSite chỉ là các lớp phòng vệ, không thay thế XSS/CSRF design.
- CORS không phải CSRF defense chính.
- Sticky session đơn giản nhưng giảm failover/flexibility.
- Distributed session store là critical dependency cần TTL, HA, capacity và monitoring.
- Session security bao phủ create, rotate, use, expire, refresh, logout và revoke.

#### Công thức ghi nhớ

> **HTTP không nhớ user; application phải mang một credential để nối các request. Session giữ quyền kiểm soát phía server, token phân phối context tới client/service — và cả hai chỉ an toàn khi lifecycle, storage, revocation và authorization được thiết kế đầy đủ.**

---

### Bài 31. Serialization — Định dạng trao đổi và lưu trữ dữ liệu

#### 1. Serialization giải quyết vấn đề gì?

Trong application, dữ liệu tồn tại dưới dạng object, struct, collection hoặc graph trong bộ nhớ. Representation này phụ thuộc vào ngôn ngữ, runtime và layout bộ nhớ nên không thể gửi nguyên trạng qua network hay lưu bền vững một cách portable.

**Serialization** chuyển dữ liệu thành representation có thể truyền hoặc lưu, chẳng hạn byte sequence hay text document. **Deserialization** thực hiện chiều ngược lại: đọc representation và dựng thành cấu trúc dữ liệu mà chương trình có thể sử dụng.

```text
Object/Struct
    │ serialize
    ▼
JSON text / Protobuf bytes / Avro record / ...
    │ network, file, cache, broker, database
    ▼
Serialized payload
    │ deserialize
    ▼
Object/Struct ở phía nhận
```

Serialization tạo ra contract tại mọi ranh giới:

- client ↔ API;
- service ↔ service;
- producer ↔ message broker ↔ consumer;
- application ↔ cache;
- application ↔ database/file/object storage;
- process hiện tại ↔ dữ liệu được đọc lại trong tương lai.

Vì vậy, đây không chỉ là thao tác chuyển đổi dữ liệu. Lựa chọn format tác động đến bandwidth, latency, CPU, memory, storage cost, interoperability, debuggability và khả năng nâng cấp hệ thống.

#### 2. Một payload không chỉ có “format”

Khi thiết kế data exchange, cần tách các lớp sau:

| Lớp | Câu hỏi |
|---|---|
| **Logical model** | Dữ liệu và ý nghĩa nghiệp vụ là gì? |
| **Schema/contract** | Field, type, requiredness và compatibility rule nào được áp dụng? |
| **Encoding** | Dữ liệu được biểu diễn thành text/binary như thế nào? |
| **Framing** | Receiver biết message bắt đầu/kết thúc ở đâu? |
| **Compression** | Payload có được nén không, bằng thuật toán nào? |
| **Transport/storage** | HTTP, gRPC, Kafka, Redis, file hay database? |
| **Security** | Integrity, confidentiality, authentication và input validation ra sao? |

Format nhỏ không tự động tạo request nhanh. End-to-end latency còn gồm network round trip, queueing, compression, allocation, validation và business logic.

#### 3. Các tiêu chí lựa chọn

- **Human readability**: có cần đọc payload trực tiếp trong log, browser hoặc CLI không?
- **Payload size**: bandwidth, cache memory và storage có nhạy cảm không?
- **Encode/decode cost**: throughput, CPU budget và tail latency ra sao?
- **Schema discipline**: cần type safety, validation, code generation hay schema registry không?
- **Evolution**: producer/consumer có được deploy độc lập và nhiều version cùng tồn tại không?
- **Interoperability**: browser, đối tác và nhiều ngôn ngữ có cần hỗ trợ dễ dàng không?
- **Random access/queryability**: chỉ truyền message hay cần database/query engine hiểu field?
- **Tooling**: debug, observability, ecosystem và operational skill của đội ngũ thế nào?
- **Security**: parser có an toàn, giới hạn kích thước/depth và loại dữ liệu ra sao?

Không có format tốt nhất cho mọi workload. Cần benchmark bằng payload và thư viện thực tế thay vì suy luận chỉ từ nhãn “text” hay “binary”.

---

#### Nhánh A — Các format phổ biến

#### 4. JSON

JSON là text format phổ biến cho Web API nhờ cú pháp tương đối đơn giản, ecosystem rộng và browser/tooling hỗ trợ tốt.

```json
{
  "orderId": "ord-123",
  "amount": 125000,
  "currency": "VND"
}
```

**Ưu điểm**

- dễ đọc, log và debug;
- hỗ trợ gần như mọi ngôn ngữ;
- phù hợp public REST API và browser client;
- không bắt buộc code generation.

**Hạn chế**

- lặp field name nên payload thường lớn hơn compact binary format;
- number model và cách map type khác nhau giữa runtime;
- date/time, decimal, bytes và enum cần convention rõ ràng;
- parser text và allocation có thể tốn CPU/memory ở tải lớn;
- bản thân JSON không bắt buộc schema.

> JSON **có thể** được kiểm tra bằng JSON Schema hoặc application validation. Nói “JSON không có schema” nên hiểu là encoding không yêu cầu schema để đọc, không phải JSON không thể dùng schema.

#### 5. XML

XML là text markup format có element, attribute, namespace và hệ sinh thái schema/query/transform phong phú như XSD, XPath, XSLT.

**Phù hợp khi:** tích hợp SOAP/enterprise/legacy, document có mixed content, namespace hoặc validation phức tạp.

**Đánh đổi:** verbose, parser/configuration phức tạp hơn và cần cấu hình an toàn để tránh các lớp tấn công như external entity expansion. XML không chỉ là “JSON cũ”; nó có document model và tooling khác.

#### 6. Protocol Buffers (Protobuf)

Protobuf dùng schema `.proto`, field number và binary wire format. Compiler sinh type/code cho nhiều ngôn ngữ.

```proto
message Order {
  string order_id = 1;
  int64 amount = 2;
  string currency = 3;
}
```

**Ưu điểm**

- payload thường compact, encode/decode hiệu quả;
- type contract rõ và hỗ trợ code generation;
- phù hợp gRPC và internal service communication;
- hỗ trợ schema evolution nếu tuân thủ field-number rule.

**Đánh đổi**

- không đọc trực tiếp bằng mắt, cần schema/tooling;
- quản lý schema và generated code tạo thêm quy trình;
- không nên tái sử dụng field number đã xóa; nên đánh dấu `reserved`;
- đổi type/semantics sai cách vẫn phá compatibility dù wire format đọc được.

Protobuf là mặc định phổ biến của gRPC, nhưng gRPC có thể dùng codec khác. “gRPC bắt buộc Protobuf” là phát biểu quá tuyệt đối.

#### 7. Avro

Avro là schema-based binary format thường dùng trong data pipeline và event streaming. Dữ liệu được đọc bằng cách đối chiếu **writer schema** với **reader schema**; schema có thể đi kèm file/container hoặc được tham chiếu qua registry.

**Ưu điểm**

- compact, phù hợp throughput lớn;
- schema evolution là mối quan tâm trung tâm;
- thuận lợi cho Kafka/data lake/Hadoop ecosystem;
- không cần field name lặp trong từng record khi schema được quản lý riêng.

**Đánh đổi**

- cần schema distribution/registry và compatibility policy;
- debug cần decoder/tooling;
- thay đổi default, union/type và semantic vẫn phải được quản lý cẩn thận.

#### 8. BSON

BSON là binary document representation được MongoDB dùng, hỗ trợ thêm type như date, binary và các numeric type cụ thể. Nó giúp database parse/traverse document theo data model của MongoDB.

Không nên kết luận BSON luôn nhỏ hơn JSON. Type metadata, length prefix và field name vẫn tạo overhead; với một số document, BSON có thể lớn hơn JSON. Lợi ích chính là richer types và database-oriented representation, không phải nén dữ liệu mặc định.

#### 9. So sánh ở mức định hướng

| Tiêu chí | JSON | XML | Protobuf | Avro |
|---|---|---|---|---|
| Representation | Text | Text | Binary | Binary |
| Đọc trực tiếp | Tốt | Tốt nhưng verbose | Cần tooling/schema | Cần tooling/schema |
| Schema bắt buộc để decode | Không | Không | Có | Có reader/writer schema |
| Kích thước điển hình | Trung bình | Lớn | Nhỏ | Nhỏ |
| Web/browser ecosystem | Rất mạnh | Có, thiên enterprise | Hạn chế hơn | Không phải lựa chọn Web phổ biến |
| Điểm mạnh | Simplicity, interoperability | Document/schema/tooling phong phú | Typed RPC, compact wire | Streaming/data evolution |
| Use case thường gặp | Public REST API | SOAP, enterprise document | gRPC, internal API | Kafka, big data pipeline |

Các nhận xét về size/speed là xu hướng, không phải định luật. Kết quả phụ thuộc cấu trúc dữ liệu, implementation, compression, hardware và workload.

---

#### Nhánh B — Schema evolution và compatibility

#### 10. Vì sao evolution quan trọng?

Trong distributed system, producer và consumer hiếm khi nâng cấp cùng lúc. Một message mới có thể được đọc bởi consumer cũ; dữ liệu cũ trong broker/file có thể được xử lý lại bằng code mới.

Ba câu hỏi phải tách riêng:

- **Backward compatibility**: reader/consumer mới đọc được dữ liệu do writer/producer cũ tạo.
- **Forward compatibility**: reader/consumer cũ đọc được dữ liệu do writer/producer mới tạo.
- **Full compatibility**: cả hai chiều trong phạm vi version policy.

Thuật ngữ có thể được platform diễn đạt theo subject/version direction khác nhau; khi phỏng vấn nên định nghĩa rõ ai là reader, ai là writer.

#### 11. Quy tắc evolution thực tế

- thêm optional field với default hợp lý;
- receiver bỏ qua unknown field;
- không đổi ý nghĩa của field cũ;
- không tái sử dụng Protobuf field number;
- tránh đổi type không tương thích;
- phân biệt “wire-compatible” với “semantically compatible”;
- version schema/contract và kiểm tra compatibility trong CI;
- có migration plan cho dữ liệu lưu dài hạn và event replay;
- deploy theo thứ tự expand → migrate → contract khi cần.

Ví dụ, đổi `amount` từ đơn vị đồng sang nghìn đồng mà giữ nguyên field name/type có thể hoàn toàn wire-compatible nhưng phá business semantics.

#### 12. Schema Registry

Schema Registry quản lý schema version, subject và compatibility rule. Producer có thể gửi schema ID thay vì toàn bộ schema; consumer lấy/cache schema tương ứng để decode.

```text
Producer ── register/check schema ──> Schema Registry
   │                                      ▲
   └── schema-id + binary record ──> Broker ──> Consumer
                                             lookup/cache schema
```

Registry trở thành control-plane dependency. Cần availability, cache, access control, rollout policy và disaster recovery; không nên để mọi request data-plane buộc phải gọi registry từ xa.

---

#### Nhánh C — Ứng dụng trong kiến trúc thực tế

#### 13. API và service communication

- **Public/browser API**: JSON thường thắng về accessibility và tooling.
- **Internal high-throughput RPC**: Protobuf/gRPC thường phù hợp vì contract typed và payload compact.
- **Partner/enterprise integration**: JSON, XML hoặc industry-specific standard tùy ecosystem.
- **Long-lived event**: Avro/Protobuf/JSON đều dùng được, nhưng schema governance quan trọng hơn tên format.

API cần định nghĩa `Content-Type`, character encoding, versioning, maximum body size và behavior khi gặp unknown/missing field.

#### 14. Cache như Redis

Format ảnh hưởng:

- memory trên mỗi entry và tổng cache capacity;
- CPU encode/decode;
- network transfer tới remote cache;
- khả năng partial update/query;
- compatibility khi application version thay đổi;
- debugging khi cache corruption/mismatch xảy ra.

Cache key nên phản ánh schema/version khi representation thay đổi không tương thích, ví dụ `user:v2:{id}`. Compression chỉ đáng dùng khi byte tiết kiệm đủ bù CPU và latency; payload nhỏ có thể lớn hơn vì header/metadata.

#### 15. Event broker và data pipeline

Event sống lâu hơn request-response và thường có nhiều consumer độc lập. Vì vậy cần:

- stable event semantics;
- schema ID/version;
- backward/forward compatibility policy;
- event envelope và content type;
- replay/upcasting strategy;
- quarantine/DLQ cho payload không decode được;
- observability theo schema/version và deserialization failure.

Không publish object nội bộ của domain/framework trực tiếp làm public event contract. Nếu class đổi tên hoặc implementation thay đổi, consumer và dữ liệu lịch sử có thể vỡ.

#### 16. Database và storage

Serialization cho storage khác serialization cho RPC:

- storage cần đọc được dữ liệu nhiều năm và qua nhiều software version;
- columnar analytics format như Parquet tối ưu scan/aggregation, không giống row/message format;
- file/container format còn cần block, index, metadata, compression và corruption recovery;
- database representation cần hỗ trợ query/index, không chỉ compact bytes.

Không nên serialize object graph bằng runtime-native mechanism rồi lưu lâu dài nếu format gắn chặt với class/runtime và không có migration contract.

#### 17. Performance model

Chi phí end-to-end có thể hình dung:

```text
Tổng latency
= encode + compress + queue/network + decompress + decode + validate + allocation
```

Các metric nên benchmark:

- serialized bytes/message;
- encode/decode throughput;
- p50/p95/p99 latency;
- CPU cycles và allocation/GC;
- memory peak khi parse;
- compression ratio và break-even payload size;
- cold-start/schema lookup cost;
- failure behavior với payload lớn hoặc malformed.

Binary format thường compact và nhanh, nhưng optimized JSON library có thể đủ nhanh; compression có thể thu hẹp chênh lệch bandwidth; code generation có thể tăng build/deployment complexity. Đo trên representative dataset mới có ý nghĩa.

---

#### Nhánh D — Security và độ tin cậy

#### 18. Insecure deserialization

Rủi ro lớn nhất xuất hiện khi deserializer dựng arbitrary object/type hoặc kích hoạt constructor, callback/gadget chain từ dữ liệu không tin cậy. Hậu quả có thể gồm:

- remote code execution;
- denial of service do payload lớn, sâu hoặc recursive;
- memory/CPU exhaustion;
- injection và business-rule bypass;
- data tampering hoặc type confusion.

Không deserialize dữ liệu không tin cậy bằng native object serialization cho phép polymorphic/arbitrary type. Ưu tiên data-only format, allowlist type và map vào DTO giới hạn.

#### 19. Các lớp phòng vệ

- giới hạn request/message size, nesting depth, collection length và processing time;
- validate syntax **và** schema **và** business invariant;
- từ chối unknown field khi context nhạy cảm, hoặc định nghĩa rõ policy bỏ qua;
- dùng parser/library được cập nhật và cấu hình an toàn;
- tắt XML external entities/DTD nếu không cần;
- tránh dynamic type metadata từ client;
- xác thực integrity/authenticity bằng MAC/signature khi threat model yêu cầu;
- mã hóa TLS cho dữ liệu trên đường truyền và encryption at rest khi cần;
- sandbox/quarantine malformed payload, rate limit và monitor failure;
- không log nguyên payload chứa secret/PII.

TLS ngăn kẻ nghe lén/sửa dữ liệu trên đường truyền trong mô hình phù hợp, nhưng không làm payload của client trở nên đáng tin và không ngăn insecure deserialization tại endpoint. Encryption cũng không thay validation.

#### 20. Data fidelity

Serialization có thể làm mất hoặc đổi ý nghĩa dữ liệu:

- integer lớn bị mất chính xác khi đi qua runtime dùng floating-point number;
- decimal tiền tệ bị rounding;
- timestamp mất timezone/precision;
- `null`, missing field và default bị đồng nhất;
- enum mới không được consumer cũ xử lý;
- map ordering hoặc duplicate key được hiểu khác nhau;
- binary data bị encode/decode sai convention.

Với tiền, ID, timestamp và security claim, cần contract type/convention rõ và test round-trip/cross-language.

---

#### 21. Câu hỏi phỏng vấn và câu trả lời ngắn

**Q1. Serialization là gì và vì sao cần?**  
Là quá trình biến object/data structure thành representation có thể truyền/lưu và dựng lại. Nó tạo khả năng interoperability qua process, language, network và thời gian.

**Q2. Format ảnh hưởng data exchange/storage thế nào?**  
Ảnh hưởng bytes, CPU, memory, latency, fidelity, compatibility, tooling và chi phí vận hành.

**Q3. JSON, XML, Protobuf và Avro khác nhau ra sao?**  
JSON ưu tiên simplicity/Web interoperability; XML có document/schema/namespace tooling mạnh; Protobuf ưu tiên typed compact RPC; Avro phù hợp data streaming và writer/reader schema evolution.

**Q4. Khi nào chọn Protobuf thay JSON?**  
Khi internal contract typed, throughput/bandwidth hoặc gRPC quan trọng và tổ chức chấp nhận schema/codegen/tooling. Chọn JSON khi public/browser accessibility và debug đơn giản quan trọng hơn.

**Q5. Serialization tác động API performance thế nào?**  
Qua payload size, encode/decode CPU, allocation/GC và compression. Tuy nhiên phải đo end-to-end; database/network/business logic có thể mới là bottleneck.

**Q6. Vì sao gRPC thường dùng Protobuf?**  
Vì schema typed, code generation, compact binary encoding và streaming/RPC tooling kết hợp tốt. Đây là mặc định phổ biến chứ không phải codec duy nhất về mặt khái niệm.

**Q7. Serialization ảnh hưởng caching ra sao?**  
Nó quyết định memory/transfer cost, decode latency, compatibility và khả năng debug. Cần version key/payload và đánh giá compression threshold.

**Q8. Đánh đổi readability, efficiency và compatibility?**  
Text dễ quan sát nhưng thường verbose; binary thường compact nhưng cần tooling/schema. Compatibility không tự sinh từ format mà đến từ rule, governance và cách thay đổi semantics.

**Q9. Ảnh hưởng CPU/memory?**  
Parsing, allocation, copy và object construction tiêu tốn tài nguyên. Binary thường có lợi nhưng không bảo đảm; benchmark implementation và representative payload.

**Q10. Avro có lợi gì trong big data?**  
Compact record, writer/reader schema resolution và ecosystem data pipeline. Hiệu quả phụ thuộc schema registry/governance và workload.

**Q11. Vì sao MongoDB dùng BSON?**  
Để có binary document model với richer data type và representation phù hợp storage/query. BSON không mặc nhiên nhỏ hơn JSON.

**Q12. Rủi ro bảo mật nào liên quan serialization?**  
Insecure deserialization, parser exploit, resource exhaustion, injection, tampering và leak dữ liệu nhạy cảm.

**Q13. Giảm rủi ro deserialization thế nào?**  
Dùng data-only format, allowlist/DTO, schema và business validation, resource limit, parser an toàn/cập nhật, integrity protection và không tin input dù đã qua TLS.

#### 22. Các lỗi tư duy thường gặp

- Chọn format theo benchmark trên payload “hello world”.
- Khẳng định binary luôn nhanh và nhỏ hơn text.
- Nói JSON không thể có schema.
- Nghĩ schema tồn tại đồng nghĩa compatibility tự động.
- Đổi semantics nhưng chỉ kiểm tra wire compatibility.
- Dùng JSON number cho mọi integer/decimal mà không xét cross-language fidelity.
- Publish runtime object/class trực tiếp làm durable event.
- Nén mọi payload kể cả message rất nhỏ.
- Không version cache value và stored blob.
- Cho phép arbitrary type/polymorphic deserialization từ input ngoài.
- Dùng encryption thay cho validation và integrity/authentication.
- Log payload chứa token, password hoặc PII.

#### 23. Checklist thiết kế

1. Ai là producer/consumer và họ được deploy độc lập không?
2. Dữ liệu sống trong một request hay nhiều năm?
3. Payload size/distribution thực tế là gì?
4. Readability/debugging hay throughput quan trọng hơn?
5. Schema nằm ở đâu và ai sở hữu?
6. Backward/forward compatibility được định nghĩa và test thế nào?
7. Missing, unknown, null, default và enum mới được xử lý ra sao?
8. Có giới hạn size, depth, count và timeout không?
9. Dữ liệu cần integrity, confidentiality và authenticity mức nào?
10. Khi decode thất bại, retry, DLQ, quarantine và alert ra sao?
11. Có benchmark cross-language và production-like payload chưa?
12. Có migration/replay plan cho dữ liệu cũ không?

#### 24. Ý chính cần nhớ

- Serialization biến in-memory data thành representation có thể truyền/lưu; deserialization dựng lại dữ liệu.
- Format là một phần của contract, không chỉ là chi tiết implementation.
- JSON mạnh về Web interoperability; XML về document/enterprise tooling; Protobuf về typed RPC; Avro về data pipeline/schema resolution.
- Text so với binary là đánh đổi theo workload, không phải bảng xếp hạng tuyệt đối.
- Schema evolution phải xét cả wire syntax và business semantics.
- Dữ liệu durable cần migration/replay strategy dài hạn.
- Serialization tác động bandwidth, CPU, memory, cache capacity và storage cost.
- Deserialization là trust boundary: giới hạn, validate và không dựng arbitrary object từ input.
- TLS/encryption không thay thế validation hay authorization.
- Quyết định đúng đến từ representative benchmark và operational constraints.

#### Công thức ghi nhớ

> **Chọn serialization format theo consumer, lifecycle và workload: contract phải tiến hóa an toàn, encoding phải đủ hiệu quả, dữ liệu phải giữ đúng ý nghĩa, và mọi bước deserialization phải được xem là một trust boundary.**

---

### Bài 32. CORS — Cross-Origin Resource Sharing & Web Security

#### 1. Bài toán CORS giải quyết

Một frontend tại `https://app.example.com` có thể cần gọi API tại `https://api.example.com`. Đây là hai **origin** khác nhau, dù cùng site `example.com`.

Browser áp dụng **Same-Origin Policy (SOP)** để hạn chế script từ một origin đọc hoặc tương tác với tài nguyên thuộc origin khác. Nếu không có ranh giới này, JavaScript trên trang độc hại có thể lợi dụng phiên đăng nhập của user để đọc dữ liệu từ nhiều website khác.

**CORS** là protocol dựa trên HTTP header cho phép server tuyên bố origin nào được browser chia sẻ response. Browser gửi `Origin`, đọc policy trong response và quyết định JavaScript có được truy cập response hay không.

```text
JavaScript ở app.example.com
          │ cross-origin fetch
          ▼
Browser ───────────────> api.example.com
   │                         │
   │<── CORS response headers┤
   │
   └─ cho JS đọc response hoặc chặn theo policy
```

Điểm cần nhớ:

- server phát policy qua header;
- browser thực thi policy;
- CORS không áp dụng như một access-control boundary cho `curl`, mobile app hoặc server-to-server client;
- CORS không thay authentication, authorization, CSRF protection hoặc input validation.

#### 2. Origin là gì?

Origin là bộ ba:

```text
scheme + hostname + port
```

| URL A | URL B | Same origin? | Lý do |
|---|---|---:|---|
| `https://app.com/a` | `https://app.com/b` | Có | Cùng scheme, host, port mặc định |
| `https://app.com` | `http://app.com` | Không | Khác scheme |
| `https://app.com` | `https://api.app.com` | Không | Khác hostname |
| `https://app.com` | `https://app.com:8443` | Không | Khác port |

**Same-origin** khác **same-site**. Cookie `SameSite`, CSRF và SOP/CORS dùng các khái niệm boundary không hoàn toàn giống nhau; không nên thay thế thuật ngữ này cho thuật ngữ kia.

#### 3. SOP thực sự chặn điều gì?

Nói “browser chặn cross-origin request” là cách rút gọn dễ gây hiểu nhầm. Browser từ lâu vẫn cho phép nhiều cross-origin resource/request như:

- `<img src="...">`, `<script src="...">`, stylesheet;
- navigation và form submission;
- một số `fetch`/request ở chế độ phù hợp.

SOP chủ yếu hạn chế script **đọc response** hoặc truy cập document/data của origin khác. Với một số request cần preflight, browser có thể không gửi actual request nếu preflight thất bại. Nhưng một “simple” cross-origin POST có thể đã đến server dù JavaScript không đọc được response.

Đây là lý do CORS không phải lớp chống CSRF chính: không đọc được response không đồng nghĩa side effect chưa xảy ra.

---

#### Nhánh A — CORS request flow

#### 4. Simple request

Một request được CORS xem là **simple** khi đáp ứng các điều kiện safelist, tiêu biểu:

- method là `GET`, `HEAD` hoặc `POST`;
- chỉ dùng CORS-safelisted request headers;
- nếu có `Content-Type`, giá trị thuộc `application/x-www-form-urlencoded`, `multipart/form-data` hoặc `text/plain`;
- không sử dụng các tính năng khiến request rời safelist.

Browser gửi simple request ngay, kèm `Origin`. Server trả response, ví dụ:

```http
GET /profile HTTP/1.1
Host: api.example.com
Origin: https://app.example.com
```

```http
HTTP/1.1 200 OK
Access-Control-Allow-Origin: https://app.example.com
Content-Type: application/json
```

Nếu `Access-Control-Allow-Origin` không phù hợp, JavaScript nhận lỗi CORS và không đọc được response. Request vẫn có thể đã được server xử lý.

> “Simple” chỉ là thuật ngữ của CORS, không có nghĩa request an toàn, read-only hoặc không tạo side effect. `POST` có thể là simple request.

#### 5. Preflight request

Với request ngoài safelist, browser gửi `OPTIONS` để hỏi trước. Các nguyên nhân thường gặp:

- method như `PUT`, `PATCH`, `DELETE`;
- `Authorization` hoặc custom request header;
- `Content-Type: application/json`;
- các request option không thuộc safelist.

```http
OPTIONS /orders/123 HTTP/1.1
Host: api.example.com
Origin: https://app.example.com
Access-Control-Request-Method: PUT
Access-Control-Request-Headers: authorization, content-type
```

Server có thể trả:

```http
HTTP/1.1 204 No Content
Access-Control-Allow-Origin: https://app.example.com
Access-Control-Allow-Methods: GET, POST, PUT
Access-Control-Allow-Headers: Authorization, Content-Type
Access-Control-Max-Age: 600
Vary: Origin
```

Nếu policy khớp, browser mới gửi actual `PUT`. Preflight là permission negotiation của browser, không chứng minh user đã được authorize cho resource `orders/123`.

#### 6. CORS headers quan trọng

| Header | Hướng | Vai trò |
|---|---|---|
| `Origin` | Request | Origin khởi tạo request |
| `Access-Control-Request-Method` | Preflight request | Method dự định dùng |
| `Access-Control-Request-Headers` | Preflight request | Các header dự định gửi |
| `Access-Control-Allow-Origin` | Response | Origin được phép đọc response |
| `Access-Control-Allow-Methods` | Preflight response | Method được phép cho actual request |
| `Access-Control-Allow-Headers` | Preflight response | Request header được phép gửi |
| `Access-Control-Allow-Credentials` | Response | Cho browser expose credentialed response khi policy khác cũng hợp lệ |
| `Access-Control-Expose-Headers` | Response | Response header ngoài safelist mà JS được phép đọc |
| `Access-Control-Max-Age` | Preflight response | Browser có thể cache kết quả preflight bao lâu |
| `Vary: Origin` | Response/cache metadata | Báo cache rằng representation/header thay đổi theo `Origin` |

`Access-Control-Allow-Headers` không làm lộ response header. Nó cho phép client **gửi request header** đã liệt kê. Muốn JavaScript đọc custom response header như `X-Request-Id`, dùng `Access-Control-Expose-Headers`.

#### 7. Preflight và performance

Preflight thêm một round trip trước actual request, đặc biệt đáng kể trên mobile/high-latency network. Các cách giảm chi phí:

- dùng `Access-Control-Max-Age` hợp lý;
- xử lý `OPTIONS` nhanh tại edge/gateway;
- giữ policy ổn định để browser reuse cache;
- dùng same-origin reverse proxy/BFF khi kiến trúc phù hợp;
- tránh custom header không cần thiết, nhưng không làm yếu security chỉ để né preflight.

Preflight cache là cache riêng của browser, không đơn giản là HTTP response cache thông thường. Browser cũng có thể áp giới hạn riêng lên `Max-Age`.

---

#### Nhánh B — Credentials và CORS policy

#### 8. Credentialed request

Credential có thể gồm cookie, TLS client certificate hoặc HTTP authentication information. Với Fetch, cross-origin credential thường cần client opt-in, ví dụ:

```javascript
fetch("https://api.example.com/me", {
  credentials: "include"
});
```

Server phải trả policy cụ thể:

```http
Access-Control-Allow-Origin: https://app.example.com
Access-Control-Allow-Credentials: true
Vary: Origin
```

Không thể dùng `Access-Control-Allow-Origin: *` để browser chia sẻ response cho request dùng credentials. Ngoài CORS, cookie vẫn chịu các rule `Domain`, `Path`, `Secure` và `SameSite`; CORS không ép browser gửi cookie trái với cookie policy.

#### 9. Wildcard không mặc nhiên là lỗ hổng

```http
Access-Control-Allow-Origin: *
```

Wildcard phù hợp với public resource thật sự công khai, không dùng browser credential và không chứa dữ liệu nhạy cảm theo caller. Nó không tự động “mở server cho Internet” — endpoint vốn đã có thể bị gọi bằng non-browser client.

Rủi ro xuất hiện khi:

- response có dữ liệu không nên cho mọi website đọc;
- server phản chiếu origin tùy ý rồi cho credentials;
- authentication/authorization dựa sai vào Origin/CORS;
- cache trộn response/policy giữa các origin;
- allowlist quá rộng hoặc regex/subdomain matching sai.

#### 10. Dynamic origin allowlist

Khi hỗ trợ nhiều trusted origin, server có thể kiểm tra request `Origin` rồi phản hồi chính xác origin đó nếu được phép:

```text
allowed = exactMatch(origin, configuredOrigins)
if allowed:
    Access-Control-Allow-Origin = origin
    Vary = Origin
```

Không phản chiếu `Origin` vô điều kiện. Cần:

- parse URL chuẩn thay vì suffix/string contains;
- chỉ cho scheme/host/port chính xác;
- thận trọng với wildcard subdomain và dangling DNS;
- định nghĩa policy cho `null` origin;
- không tin Origin như bằng chứng authentication;
- có test cho allow/deny và cache behavior.

Ví dụ, kiểm tra “hostname kết thúc bằng `example.com`” sai cách có thể chấp nhận `attackerexample.com`.

#### 11. `Origin: null`

Một số sandboxed iframe, local file hoặc opaque origin có thể gửi `Origin: null`. Cho phép literal `null` rộng rãi có thể biến các context không tin cậy thành origin được cấp quyền. Chỉ cho phép khi có use case được xác định và có lớp kiểm soát khác.

#### 12. CORS policy theo loại API

Không nên dùng một policy cho toàn platform:

| Loại endpoint | Định hướng policy |
|---|---|
| Public static/data API | Có thể `*`, không credential, rate limit phù hợp |
| First-party user API | Exact trusted origins, credentials khi cần, CSRF defense |
| Partner API | Thường dùng auth mạnh; CORS chỉ cần nếu partner gọi từ browser |
| Internal service API | CORS không bảo vệ server-to-server; dùng network/workload identity/authz |
| Admin API | Allowlist hẹp, auth mạnh, audit và thường tách boundary |

---

#### Nhánh C — CORS trong kiến trúc thực tế

#### 13. REST và GraphQL

CORS phụ thuộc browser/origin, không phụ thuộc REST hay GraphQL.

- REST frontend và API khác origin thường cần CORS.
- GraphQL `POST` với `application/json`, `Authorization` hoặc custom headers thường preflight.
- GraphQL chỉ có một endpoint không làm giảm yêu cầu authentication, field/object authorization hay CSRF protection.
- WebSocket handshake có `Origin` nhưng không dùng CORS theo đúng cơ chế Fetch; server WebSocket phải tự validate Origin và authentication theo threat model.

#### 14. Reverse proxy và same-origin routing

Reverse proxy có thể phục vụ frontend và proxy `/api` dưới cùng public origin:

```text
https://app.example.com/       ──> Frontend
https://app.example.com/api/*  ──> Reverse Proxy ──> Backend service
```

Browser thấy same-origin nên frontend không cần CORS cho path này. Lợi ích:

- đơn giản hóa browser policy và cookie scope;
- ẩn topology nội bộ;
- tập trung TLS, routing, limits và observability.

Nhưng proxy không tự tạo security: backend vẫn cần authentication, authorization, CSRF defense, input validation và network policy.

#### 15. API Gateway

Gateway có thể tập trung:

- origin allowlist;
- preflight/`OPTIONS` response;
- method/header policy;
- consistent `Vary`/cache behavior;
- authentication, rate limit và audit;
- metrics cho rejected origin/preflight.

Đánh đổi là policy drift giữa gateway và service, route-specific requirements, vendor configuration và nguy cơ gateway thêm header cho cả error response không đúng cách. Cần một nguồn cấu hình rõ ràng và integration test từ browser perspective.

#### 16. CDN và cache

Nếu response thay đổi `Access-Control-Allow-Origin` theo request origin, shared cache phải phân biệt đúng variant, thường qua:

```http
Vary: Origin
```

Nếu không, cache có thể trả header dành cho origin A cho origin B, gây lỗi hoặc tạo exposure tùy cấu hình. Cần cân nhắc cache-key cardinality khi có rất nhiều origin; gateway/CDN policy phải nhất quán với origin allowlist.

#### 17. Backend-for-Frontend (BFF)

BFF cho phép browser chỉ nói chuyện với same-origin backend; BFF giữ access token phía server và gọi downstream services. Mẫu này có thể giảm token exposure trong JavaScript và giảm CORS complexity, nhưng tạo thêm state/dependency, CSRF concern với cookie session và operational hop.

#### 18. JSONP không phải giải pháp hiện đại

JSONP lợi dụng `<script>` để tải cross-origin JavaScript và chỉ hỗ trợ mô hình GET. Response được thực thi như code, không có security model thích hợp cho API hiện đại. Nó đã lỗi thời; không dùng thay CORS.

---

#### Nhánh D — Quan hệ với các cơ chế bảo mật khác

#### 19. CORS và authentication/authorization

CORS trả lời:

> Browser có cho script của origin này đọc response không?

Authentication/authorization trả lời:

> Caller là ai và có quyền thực hiện action trên resource này không?

API phải kiểm tra quyền bất kể CORS header. Attacker có thể gọi API trực tiếp ngoài browser, và CORS không hề ngăn việc đó.

#### 20. CORS và CSRF

CSRF lợi dụng credential mà browser tự gửi, thường là cookie, để tạo request ngoài ý muốn. Vì simple request có thể được gửi mà không preflight, CORS không phải biện pháp chống CSRF đầy đủ.

Phòng vệ thường kết hợp:

- `SameSite` cookie phù hợp;
- anti-CSRF token;
- kiểm tra `Origin`/`Referer` như defense-in-depth;
- yêu cầu custom header cho API flow được thiết kế cẩn thận;
- re-authentication cho action nhạy cảm;
- không dùng `GET` cho state-changing action.

Preflight/custom header có thể tăng rào cản với một số CSRF flow, nhưng vẫn không thay thế CSRF design và authorization.

#### 21. CORS và XSS

Nếu attacker chạy JavaScript trong một **trusted allowed origin** do XSS, CORS thường không cứu được hệ thống: script đang hoạt động với origin đã được cho phép và có thể gửi request/đọc response theo quyền của user.

Phòng XSS cần output encoding, safe DOM API, CSP, dependency hygiene và tránh unsafe HTML/script execution. `HttpOnly` bảo vệ việc đọc cookie nhưng không ngăn script XSS thực hiện request dưới phiên user.

#### 22. Các browser security header liên quan

CORS chỉ là một phần của web security model:

- **Content-Security-Policy (CSP)**: giới hạn nguồn script/resource và giảm tác động XSS.
- **Cross-Origin-Resource-Policy (CORP)**: resource chỉ định ai được phép nhúng/đọc theo mode nhất định.
- **Cross-Origin-Opener-Policy (COOP)** và **Cross-Origin-Embedder-Policy (COEP)**: tạo cross-origin isolation cho document khi cấu hình phù hợp.
- **Fetch Metadata** (`Sec-Fetch-*`): giúp server suy luận context như site/mode/destination để từ chối request đáng ngờ.
- **Frame protections**: CSP `frame-ancestors` chống clickjacking tốt hơn cấu hình frame legacy.

Các cơ chế này bổ trợ nhau; không header đơn lẻ nào thay thế thiết kế trust boundary đầy đủ.

#### 23. Các misconfiguration phổ biến

- Phản chiếu mọi `Origin` và bật credentials.
- Cho phép `null` origin không có lý do.
- Match allowlist bằng substring/suffix sai.
- Dùng `*` cho user-specific sensitive response.
- Quên `Vary: Origin` khi response thay đổi theo origin.
- Chỉ thêm CORS header cho response thành công, khiến lỗi/401 khó debug.
- Bắt `OPTIONS` phải có user credential trong khi preflight không mang credential như actual flow mong đợi.
- Redirect preflight/actual request qua origin khác mà không kiểm thử browser behavior.
- Cho rằng chặn JavaScript đọc response nghĩa server chưa xử lý request.
- Dùng CORS thay authentication, authorization hoặc CSRF protection.
- Cho phép production origin kiểu `*.example.com` trong khi subdomain có thể bị takeover.
- Config gateway và application mâu thuẫn, tạo header trùng hoặc policy khó đoán.

---

#### 24. Câu hỏi phỏng vấn và trả lời ngắn

**Q1. Same-Origin Policy là gì, vì sao tồn tại?**  
Là browser policy cô lập document/script theo scheme-host-port, chủ yếu hạn chế cross-origin read/DOM access để website độc hại không đọc dữ liệu trong phiên của user ở origin khác.

**Q2. CORS cho phép cross-origin request thế nào?**  
Browser gửi `Origin`; server trả `Access-Control-*` policy; browser quyết định có chia sẻ response với JavaScript không. Một số request cần preflight trước actual request.

**Q3. Preflight là gì và khi nào cần?**  
Là `OPTIONS` request mang intended method/header khi request nằm ngoài CORS safelist, ví dụ `PUT`, `Authorization` hoặc `application/json`.

**Q4. Cấu hình CORS trên server thế nào?**  
Validate origin bằng allowlist, trả exact `Access-Control-Allow-Origin`, các method/header cần thiết, credentials nếu thực sự dùng, `Vary: Origin`, và xử lý `OPTIONS`/error response nhất quán.

**Q5. Rủi ro CORS phổ biến?**  
Arbitrary origin reflection với credentials, allowlist sai, wildcard cho sensitive response, cache không vary theo origin và nhầm CORS là authorization.

**Q6. Có thể tránh CORS bằng cách nào?**  
Dùng same-origin reverse proxy/BFF. JSONP là giải pháp legacy không an toàn và không nên dùng. Non-browser server-to-server call vốn không chịu browser CORS enforcement.

**Q7. Gateway/reverse proxy giúp gì?**  
Tập trung routing/policy, trả preflight nhanh và giảm cấu hình phân tán. Nhưng vẫn cần authn/authz, CSRF và service security.

**Q8. Vì sao Postman/curl chạy nhưng browser báo CORS?**  
Vì CORS do browser thực thi; generic HTTP client không áp SOP/CORS như browser.

**Q9. `Access-Control-Allow-Headers` và `Expose-Headers` khác gì?**  
`Allow-Headers` cho phép request header trong preflight; `Expose-Headers` cho phép JavaScript đọc response header ngoài safelist.

**Q10. CORS có ngăn CSRF không?**  
Không đầy đủ. Simple credentialed request có thể đến server dù response bị chặn đọc. Dùng SameSite, CSRF token, Origin checking và authorization theo threat model.

**Q11. Có được dùng wildcard với credentials không?**  
Không dùng `Access-Control-Allow-Origin: *` để chia sẻ credentialed response; phải trả origin cụ thể được tin cậy và `Access-Control-Allow-Credentials: true`.

**Q12. CORS áp dụng cho microservice nội bộ không?**  
Chỉ có ý nghĩa khi browser trực tiếp gọi cross-origin endpoint. Service-to-service cần workload identity, TLS/network policy và authorization riêng.

#### 25. Quy trình debug CORS

1. Xác định chính xác page origin và target origin.
2. Kiểm tra browser Network panel: có `OPTIONS` không?
3. Xem `Origin`, requested method/header trong preflight.
4. Kiểm tra response status và toàn bộ `Access-Control-*` headers.
5. Nếu dùng cookie, kiểm tra `credentials`, `SameSite`, `Secure`, domain/path.
6. Kiểm tra redirect, CDN/cache và `Vary: Origin`.
7. Xác minh `OPTIONS` không bị auth middleware/routing chặn sai.
8. Kiểm tra actual response, kể cả 4xx/5xx, có policy nhất quán không.
9. Thử bằng origin được phép và bị từ chối; không dùng việc `curl` thành công làm bằng chứng CORS đúng.
10. Sau khi sửa CORS, vẫn kiểm tra authn/authz/CSRF độc lập.

#### 26. Checklist production

- Exact allowlist, owner và quy trình cập nhật rõ ràng.
- Không phản chiếu origin tùy ý.
- Credentials chỉ bật cho endpoint/origin thực sự cần.
- Allowed methods/headers theo least privilege.
- `Vary: Origin` và cache key đúng.
- `Max-Age` cân bằng latency với tốc độ thay đổi/revoke policy.
- `OPTIONS`, success và error response được kiểm thử.
- Không dùng CORS làm API authorization.
- CSRF, XSS, cookie và CSP được thiết kế riêng.
- Gateway/service không sinh header trùng hoặc mâu thuẫn.
- Metrics/log không chứa token nhưng đủ thấy origin, route, decision và failure.
- Automated browser integration test cho các origin quan trọng.

#### 27. Ý chính cần nhớ

- Origin = scheme + hostname + port; same-origin khác same-site.
- SOP chủ yếu hạn chế cross-origin read/interaction, không ngăn mọi request được gửi.
- CORS là server-declared, browser-enforced response-sharing protocol.
- Simple request đi thẳng; request ngoài safelist thường cần `OPTIONS` preflight.
- Preflight không phải authentication hay authorization.
- `Allow-Headers` áp dụng cho request header; `Expose-Headers` áp dụng cho response header JS đọc được.
- Credentialed response cần explicit origin và `Access-Control-Allow-Credentials: true`.
- Wildcard phù hợp với public non-credentialed resource, không phù hợp cho dữ liệu user nhạy cảm.
- CORS không bảo vệ non-browser client và không thay CSRF/XSS defense.
- Reverse proxy, gateway và BFF có thể tập trung hoặc loại bỏ cross-origin browser path.
- Dynamic origin policy cần allowlist chính xác và `Vary: Origin`.
- Security phải được kiểm tra end-to-end ở browser, edge, gateway và application.

#### Công thức ghi nhớ

> **SOP dựng hàng rào giữa các origin; CORS mở một cánh cửa có điều kiện để browser cho script đọc response. Cánh cửa đó không xác thực người dùng, không cấp quyền trên tài nguyên và không thay thế CSRF/XSS protection.**

---

### Bài 33. Tổng kết — Web Concepts in System Design

#### 1. Bức tranh tổng thể

Các khái niệm Web không tồn tại độc lập. Trong một request production, session, serialization, browser security, routing và authorization phối hợp trên cùng một đường đi:

```text
Browser
  │ Cookie / token / Origin
  │ Serialized HTTP request
  ▼
CDN / Reverse Proxy / API Gateway
  │ TLS, CORS, routing, rate limit, authentication
  ▼
Application Service
  │ Session lookup, authorization, validation
  │ Serialize / deserialize
  ▼
Cache / Database / Message Broker
```

Một thiết kế Web tốt phải trả lời đồng thời:

- Client và server giao tiếp theo contract nào?
- User identity và state được nối qua các request ra sao?
- Credential được lưu, gửi, rotate và revoke thế nào?
- Dữ liệu được serialize bằng format nào và tiến hóa ra sao?
- Browser được phép giao tiếp giữa những origin nào?
- Trust boundary nằm ở đâu và thành phần nào thực thi policy?
- Khi traffic, dữ liệu hoặc số service tăng, kiến trúc còn vận hành được không?

#### 2. State trên một protocol stateless

HTTP không tự ghi nhớ user giữa các request. Application tạo trải nghiệm stateful bằng cookie, server-side session, token hoặc mô hình hybrid.

Các lựa chọn này ảnh hưởng trực tiếp tới kiến trúc:

| Lựa chọn | Lợi ích | Đánh đổi chính |
|---|---|---|
| Local server session | Đơn giản ở quy mô nhỏ | Khó failover và horizontal scaling |
| Distributed session store | Shared state, revoke nhanh | Thêm critical dependency và network hop |
| Self-contained access token | Giảm lookup trên request path | Revocation và stale claim khó hơn |
| Hybrid session/token | Cân bằng control và phân phối context | Lifecycle phức tạp hơn |

Không nên chỉ hỏi “session hay JWT?”. Cần xét threat model, browser/mobile client, revoke requirement, multi-region, latency, consistency và khả năng vận hành.

#### 3. Data contract qua ranh giới hệ thống

Serialization biến in-memory object thành representation có thể truyền hoặc lưu. Format được chọn sẽ ảnh hưởng:

- payload size và bandwidth;
- CPU, allocation và latency encode/decode;
- khả năng debug và interoperability;
- schema validation và type fidelity;
- backward/forward compatibility;
- replay/migration của dữ liệu dài hạn.

JSON, XML, Protobuf và Avro tối ưu cho những mục tiêu khác nhau. Quyết định đúng không đến từ việc format nào “nhanh nhất” nói chung, mà từ consumer, lifecycle, ecosystem và benchmark trên workload thực tế.

#### 4. Browser security và cross-origin communication

Same-Origin Policy tạo ranh giới mặc định giữa các origin. CORS cho server tuyên bố trường hợp browser được chia sẻ cross-origin response với JavaScript.

Cần giữ đúng phạm vi trách nhiệm:

- CORS không thay authentication hoặc authorization;
- CORS không phải lớp chống CSRF đầy đủ;
- CORS không bảo vệ API trước non-browser client;
- `HttpOnly`, `SameSite`, CSP và CSRF token giải quyết những phần khác nhau của threat model;
- reverse proxy, API Gateway hoặc BFF có thể tập trung policy và tạo same-origin browser path.

Security không phải một header hay middleware riêng lẻ. Nó phải bao phủ credential lifecycle, input validation, data exposure, object-level authorization, cache isolation và observability.

#### 5. Các mối liên hệ quan trọng

| Quyết định ban đầu | Tác động tiếp theo |
|---|---|
| Session lưu local | Load balancer cần affinity hoặc user mất state khi đổi instance |
| Session đưa vào Redis | Scale dễ hơn nhưng Redis trở thành availability/capacity concern |
| Token sống lâu | Giảm refresh nhưng tăng cửa sổ rủi ro và stale authorization |
| Cookie tự gửi | Tiện cho browser nhưng phải thiết kế CSRF và SameSite |
| JSON public API | Dễ tích hợp nhưng cần schema/convention và kiểm soát payload |
| Binary internal API | Giảm payload nhưng tăng schema/tooling dependency |
| Dynamic CORS origin | Hỗ trợ nhiều frontend nhưng cần allowlist và cache `Vary` đúng |
| Same-origin reverse proxy | Giảm CORS complexity nhưng thêm routing/security responsibility ở proxy |

Architectural thinking bắt đầu khi nhìn thấy các tác động bậc hai này, thay vì tối ưu từng component riêng lẻ.

#### 6. Một request được thiết kế an toàn

Ví dụ browser gọi API dùng cookie session:

1. DNS/TLS đưa request tới edge đáng tin cậy.
2. Browser áp cookie scope, `Secure`, `SameSite` và CORS behavior.
3. Gateway kiểm tra route, size, rate limit và CORS policy.
4. Application tra session trong shared store.
5. Authorization được kiểm tra trên action và resource cụ thể.
6. Payload được deserialize với size/schema/business validation.
7. Service đọc/ghi cache hoặc database theo consistency requirement.
8. Response được serialize, gắn cache/security header phù hợp.
9. Log, metric và trace ghi nhận kết quả mà không làm lộ credential/PII.

Không bước nào đơn lẻ đủ bảo vệ toàn hệ thống. Độ an toàn đến từ nhiều lớp có trách nhiệm rõ ràng.

#### 7. Checklist ôn tập Phần 5

- Phân biệt HTTP stateless với application state.
- Phân biệt cookie, session, browser storage và token.
- Giải thích server-side session, JWT/access token và hybrid pattern.
- Nêu được cách scale session qua sticky routing, shared store hoặc token.
- Thiết kế timeout, rotation, logout và revocation.
- So sánh JSON, XML, Protobuf, Avro theo workload.
- Giải thích schema evolution và compatibility.
- Nhận diện insecure deserialization và data fidelity risk.
- Xác định origin bằng scheme, hostname và port.
- Phân biệt simple CORS request với preflight request.
- Giải thích credentialed CORS và giới hạn của wildcard.
- Phân biệt CORS với authentication, authorization, CSRF và XSS.
- Biết khi nào reverse proxy, API Gateway hoặc BFF giúp đơn giản hóa browser architecture.
- Suy luận end-to-end từ browser tới storage thay vì nhìn từng công nghệ riêng lẻ.

#### 8. Các câu hỏi tự kiểm tra

1. Vì sao HTTP stateless nhưng application vẫn có thể lưu server-side session?
2. Khi nào distributed session store phù hợp hơn self-contained token?
3. User đổi quyền thì session và access token phản ánh thay đổi khác nhau thế nào?
4. Vì sao JSON dễ tích hợp nhưng vẫn cần contract governance?
5. Một thay đổi wire-compatible có thể phá business semantics như thế nào?
6. Simple cross-origin POST thất bại CORS có thể vẫn tạo side effect không?
7. Vì sao `Access-Control-Allow-Origin` không phải authorization rule?
8. Cookie `SameSite`, CSRF token và CORS bảo vệ những boundary nào khác nhau?
9. Khi đưa CORS lên API Gateway, service còn trách nhiệm bảo mật gì?
10. Traffic tăng gấp mười lần sẽ gây áp lực trước tiên lên session store, serialization CPU hay gateway trong workload của bạn?

#### 9. Chuyển sang Scalability

Phần tiếp theo đi sâu vào khả năng hệ thống tiếp tục đáp ứng khi user, traffic và dữ liệu tăng. Những khái niệm Web vừa học sẽ trở thành đầu vào cho các quyết định scale:

- session state quyết định khả năng thêm application instance;
- serialization ảnh hưởng bandwidth, CPU và storage capacity;
- proxy/gateway trở thành điểm routing, policy và observability;
- cache giúp giảm work phía backend nhưng tạo consistency concern;
- security policy phải duy trì đúng khi hệ thống phân tán qua nhiều instance hoặc region.

Các chủ đề tiếp theo gồm scaling strategy, load distribution, autoscaling, cloud-native architecture và những đánh đổi giữa performance, reliability, cost và operational complexity.

#### Ý chính cần nhớ

- Web concepts là nền móng của distributed system, không phải chi tiết frontend.
- State, identity, data contract và browser security cùng tồn tại trên một request path.
- Mỗi lựa chọn đều có tác động tới scalability, reliability, security và vận hành.
- Policy cần được đặt tại boundary rõ ràng nhưng vẫn kiểm tra defense-in-depth.
- Thiết kế production phải xử lý lifecycle, failure, compatibility và observability.
- Tư duy kiến trúc là khả năng nối các quyết định nhỏ thành hành vi end-to-end của hệ thống.

#### Công thức ghi nhớ

> **Một Web system vững chắc phải quản lý đúng state, trao đổi dữ liệu bằng contract có thể tiến hóa, bảo vệ browser boundary và duy trì các thuộc tính đó khi tải tăng.**

---

## Phần 6 — Scalability in System Design

### Bài 34. Introduction to Scalability

#### 1. Scalability là gì?

**Scalability** là khả năng hệ thống tiếp nhận mức tải ngày càng tăng mà vẫn duy trì các mục tiêu chấp nhận được về performance, reliability, availability và cost, đồng thời không phải thiết kế lại toàn bộ kiến trúc.

```text
Load tăng
   │
   ▼
Thêm hoặc tái phân bổ capacity
   │
   ▼
SLO vẫn đạt: latency, throughput, error rate, availability, cost
```

Một hệ thống không được gọi là scalable chỉ vì nó “chịu được nhiều user”. Cần nói rõ:

- workload nào tăng;
- tăng đến mức nào và trong bao lâu;
- resource nào được bổ sung;
- service-level objective nào phải giữ;
- chi phí và độ phức tạp tăng ra sao.

Ví dụ, “hệ thống scale được tới 100.000 request/giây, p99 dưới 300 ms, error rate dưới 0,1%, khi chạy qua hai availability zone” có ý nghĩa hơn “hệ thống rất scalable”.

#### 2. Những chiều tăng trưởng của hệ thống

Growth không chỉ là số user:

| Chiều tăng trưởng | Ví dụ áp lực tạo ra |
|---|---|
| **Traffic** | Request/second, connection, message/event rate |
| **Concurrency** | User/session/socket/job cùng hoạt động |
| **Data volume** | Storage, index size, backup, replication, scan time |
| **Data velocity** | Write ingestion, streaming, CDC, analytics pipeline |
| **Geography** | Latency đường dài, data residency, multi-region consistency |
| **Feature/tenant** | Query phức tạp, noisy neighbor, metadata/configuration growth |
| **Team/organization** | Ownership, deployment coordination, service boundary |

Một kiến trúc có thể scale tốt theo một chiều nhưng kém ở chiều khác. Stateless API tier dễ thêm instance, trong khi database write throughput hoặc một partition nóng vẫn giới hạn toàn hệ thống.

#### 3. Scalability không đồng nghĩa performance

- **Performance** mô tả hệ thống nhanh hoặc xử lý được bao nhiêu tại một cấu hình/tải cụ thể.
- **Scalability** mô tả output/SLO thay đổi thế nào khi tăng load và tăng resource.
- **Elasticity** là khả năng điều chỉnh resource theo demand, thường tự động và có thể scale cả lên lẫn xuống.

Một server cực nhanh chưa chắc scalable nếu không thể bổ sung capacity. Ngược lại, một hệ thống có thể scale tuyến tính nhưng latency cơ sở vẫn kém.

#### 4. Vì sao hệ thống cần scale?

Các động lực phổ biến:

- user/product tăng trưởng từ nghìn lên hàng triệu người dùng;
- mở rộng sang thị trường hoặc region mới;
- log, event, transaction và IoT data tích lũy liên tục;
- traffic spike do flash sale, mở bán vé hoặc nội dung viral;
- batch/analytics cạnh tranh resource với online workload;
- SLA/SLO buộc latency và availability không được giảm khi tải tăng;
- business muốn tăng doanh thu mà cost trên mỗi transaction không tăng mất kiểm soát.

Scalability biến thành công từ một rủi ro vận hành thành khả năng tăng trưởng có kế hoạch.

#### 5. Steady growth và burst khác nhau

```text
Load
 ▲                    /
 │  steady growth    /
 │                  /
 │        spike  /\
 │              /  \____
 └────────────────────────> time
```

- **Steady growth** cho phép capacity planning, migration và mua/provision resource trước.
- **Predictable peak** có thể chuẩn bị theo lịch, pre-scale và warm cache.
- **Unpredictable burst** cần headroom, elasticity, queue, load shedding và graceful degradation.

Autoscaling không phản ứng tức thì: provisioning, boot, scheduling, health check và warm-up đều có độ trễ. Nếu spike tăng nhanh hơn thời gian scale-out, hệ thống vẫn cần capacity dự phòng hoặc cơ chế hấp thụ tải.

#### 6. Đo scalability bằng gì?

Không chỉ nhìn CPU. Một bộ đo thường gồm:

- request/transaction/message per second;
- concurrent users/connections/jobs;
- latency p50, p95, p99;
- error, timeout và rejection rate;
- saturation của CPU, memory, disk, network, thread/connection pool;
- queue depth, age of oldest job và consumer lag;
- database QPS, lock wait, replication lag và hot partition;
- cost trên request, user, GB hoặc transaction;
- time-to-scale, cooldown và capacity headroom.

Average có thể che giấu tail latency. Khi fan-out tới nhiều dependency, một downstream chậm có thể kéo p99 của toàn request lên mạnh dù mean vẫn đẹp.

#### 7. Capacity, load và utilization

Một mô hình đơn giản:

```text
required capacity ≈ peak load × safety factor
instance count    ≈ required capacity / safe capacity per instance
```

Ví dụ:

```text
Peak dự kiến                 = 24.000 RPS
Safety factor                = 1,5
Safe capacity mỗi instance  = 1.200 RPS

Số instance ≈ 24.000 × 1,5 / 1.200 = 30
```

“Safe capacity” phải được đo tại SLO mong muốn, không phải throughput tối đa trước khi process sập. Cũng cần trừ capacity mất khi một zone/node bị lỗi hoặc khi deployment đang diễn ra.

#### 8. Scaling luôn theo bottleneck

Throughput end-to-end bị giới hạn bởi thành phần bão hòa đầu tiên:

```text
Client → Edge → API → Service → Cache → Database → External dependency
                        ▲                    ▲
                 thêm instance dễ      write bottleneck
```

Thêm application server không giúp nếu database connection pool, lock, storage IOPS hoặc third-party quota đã chạm trần. Quy trình đúng là:

1. xác định workload và SLO;
2. đo utilization/saturation;
3. tìm bottleneck hiện tại;
4. giảm work hoặc tăng capacity tại đúng điểm;
5. load test lại vì bottleneck sẽ dịch chuyển.

#### 9. Những thách thức khi scale

**Latency**

- thêm network hop, serialization và queueing;
- fan-out làm tail latency tích lũy;
- cross-region call làm tăng RTT.

**Bottleneck và contention**

- database write leader, global lock, hot key/partition;
- shared connection/thread pool;
- singleton coordinator hoặc sequential stage.

**Reliability và availability**

- nhiều component tạo thêm failure mode;
- retry có thể khuếch đại overload;
- deployment/scale event cần readiness và connection draining.

**State và consistency**

- state cục bộ cản request distribution;
- replication/sharding tạo stale read, conflict và coordination cost;
- transaction xuyên partition/service khó hơn.

**Cost**

- overprovision lãng phí, underprovision vi phạm SLO;
- data transfer, managed service và observability có thể tăng nhanh;
- hiệu quả trên mỗi request quan trọng không kém tổng capacity.

**Operational complexity**

- monitoring, incident response, configuration và deployment nhiều node;
- capacity model phải tính failure, maintenance và traffic skew;
- đội ngũ cần đủ năng lực vận hành distributed system.

#### 10. Hai hướng scale cơ bản

- **Vertical scaling (scale up/down)**: tăng hoặc giảm CPU, memory, storage, IOPS hay network capacity của một node.
- **Horizontal scaling (scale out/in)**: tăng hoặc giảm số node/instance cùng chia workload.

Hầu hết hệ thống thực tế kết hợp cả hai theo từng component và từng giai đoạn.

#### 11. Nguyên tắc kiến trúc

- Tối ưu work trước khi thêm resource: query, cache, batching, indexing, algorithm.
- Đo theo bottleneck và SLO, không scale theo một metric tiện nhìn.
- Giữ application tier stateless khi có lợi, nhưng không giả vờ state biến mất.
- Tách workload có đặc điểm khác nhau để scale độc lập.
- Thiết kế overload behavior: queue, rate limit, backpressure, shed load, degrade.
- Capacity phải bao phủ spike, failure và deployment, không chỉ average traffic.
- Tự động hóa chỉ sau khi hiểu signal, lag và failure mode.
- Không over-engineer cho quy mô chưa có, nhưng giữ đường tiến hóa rõ ràng.

#### 12. Câu hỏi phỏng vấn nền tảng

**Q1. Scalability là gì?**  
Khả năng tăng capacity để xử lý load tăng mà vẫn giữ SLO và economics chấp nhận được.

**Q2. Vì sao performance tốt chưa chắc scalable?**  
Performance đo tại một điểm; scalability đo cách hệ thống phản ứng khi cả load và resource thay đổi.

**Q3. Dấu hiệu một hệ thống không scale tốt?**  
Latency/error tăng phi tuyến, thêm resource không tăng throughput tương ứng, cost mỗi request tăng mạnh hoặc một shared component bão hòa.

**Q4. Nên scale component nào trước?**  
Component đang giới hạn SLO/throughput theo đo đạc. Không mặc định scale application tier.

**Q5. Làm sao chuẩn bị traffic spike?**  
Forecast/pre-scale, headroom, cache, queue/backpressure, rate limit/load shedding, dependency quota và thử nghiệm peak/failure.

#### 13. Nội dung phỏng vấn bổ sung từ PDF

**Q6. Nêu ví dụ thực tế về scalability thành công hoặc thất bại.**  
PDF dùng Twitter thời kỳ “Fail Whale” và Zoom trong giai đoạn COVID-19 để minh họa. Cách trả lời tốt không dừng ở tên công ty mà nêu được chuỗi nhân quả:

```text
Demand thay đổi mạnh
→ bottleneck/SLO bị phá
→ kiến trúc/capacity/process phải thay đổi
→ đo được kết quả và trade-off mới
```

Không nên quy toàn bộ thành công hoặc thất bại cho một nhãn như “monolith”, “microservices”, “cloud-native” hay “autoscaling”. Production outcome còn phụ thuộc workload, data architecture, operational maturity và rất nhiều thay đổi qua thời gian. Con số “daily participants” cũng không đồng nghĩa số user duy nhất.

**Q7. Quy trình xác định bottleneck nên diễn ra thế nào?**

1. Chọn SLO và workload đại diện thay vì chỉ nhìn dashboard ngẫu nhiên.
2. Tạo baseline về throughput, latency percentile, error và utilization.
3. Tăng tải có kiểm soát cho tới khi SLO bắt đầu suy giảm.
4. Tìm resource có saturation/queue tăng cùng thời điểm.
5. Dùng distributed trace/profile/query plan để định vị thời gian và work.
6. Thay đổi một yếu tố: thêm capacity, cache, index hoặc giới hạn concurrency.
7. Chạy lại cùng test để xác nhận throughput/SLO cải thiện.

CPU hoặc memory spike chỉ là tương quan. Bottleneck được xác nhận khi thay đổi capacity/work tại điểm đó làm kết quả end-to-end thay đổi như dự đoán.

**Q8. Vì sao latency thường tăng khi hệ thống lớn hơn?**  
Không phải scale tự động buộc phải thêm microservice/hop. Latency tăng khi thiết kế đưa thêm network call, fan-out, coordination, cross-partition aggregation hoặc queueing vào critical path. Giảm bằng cache, async non-critical work, tối ưu query, batching, giảm chatty call, edge/CDN và deadline/latency budget.

**Q9. Cân bằng scalability và cloud cost thế nào?**  
Kết hợp right-sizing, autoscaling có min/max, tiered caching, baseline commitment phù hợp, interruptible capacity cho workload chịu ngắt và theo dõi unit cost. Serverless/FaaS không mặc nhiên rẻ: còn phụ thuộc request duration, concurrency, cold start, data transfer và steady utilization.

**Q10. “Scalable system tăng tuyến tính hoặc elastic” có phải định nghĩa bắt buộc?**  
Không. Linear scalability là kết quả lý tưởng trong một range, không phải điều kiện định nghĩa. Hệ thống vẫn có thể được xem là scalable nếu capacity tăng hữu ích và SLO/cost chấp nhận được dù efficiency giảm vì coordination, contention hoặc phần tuần tự.

#### 14. Ý chính cần nhớ

- Scalability là duy trì SLO và cost khi demand tăng, không chỉ “thêm server”.
- Growth gồm traffic, concurrency, data, geography và organizational scale.
- Performance, scalability và elasticity là ba khái niệm liên quan nhưng khác nhau.
- Hệ thống scale theo bottleneck nhỏ nhất; bottleneck sẽ dịch chuyển sau mỗi tối ưu.
- Average load không đại diện peak, burst hoặc tail latency.
- Capacity planning phải tính headroom, failure và thời gian scale.
- State, consistency, reliability, cost và vận hành là phần của bài toán scale.
- Vertical và horizontal scaling là hai công cụ nền tảng, thường được phối hợp.

#### Công thức ghi nhớ

> **Scalability = tăng demand + tăng capacity có kiểm soát + vẫn giữ SLO và economics chấp nhận được.**

---

### Bài 35. Scaling Strategies — Horizontal, Vertical & Diagonal

#### 1. Ba chiến lược tổng quát

```text
Vertical scaling       Horizontal scaling       Diagonal scaling

   ┌───────┐             ┌───┐ ┌───┐ ┌───┐       ┌─────┐ ┌─────┐
   │       │             │   │ │   │ │   │       │     │ │     │
   │ BIGGER│             └───┘ └───┘ └───┘       │     │ │     │
   │ NODE  │              MORE NODES             └─────┘ └─────┘
   └───────┘                                      BIGGER + MORE
```

- **Vertical**: làm một node mạnh hơn.
- **Horizontal**: thêm nhiều node để chia tải.
- **Diagonal**: tăng kích thước node tới một ngưỡng hợp lý rồi mở rộng số node; hoặc phối hợp cả hai theo thời gian.

“Diagonal scaling” là cách gọi thông dụng, không phải một primitive kỹ thuật hoàn toàn tách biệt. Nó mô tả chiến lược kết hợp vertical và horizontal scaling.

---

#### Nhánh A — Vertical scaling

#### 2. Scale up và scale down

Vertical scaling tăng capacity của một node bằng:

- thêm CPU/core;
- tăng RAM;
- dùng storage nhanh/lớn hơn hoặc tăng provisioned IOPS;
- nâng network bandwidth;
- chuyển sang machine class mạnh hơn.

Chiều ngược lại là **scale down** để giảm resource/cost khi capacity dư thừa.

#### 3. Ưu điểm

- thay đổi kiến trúc ít nhất;
- nhanh triển khai trong giai đoạn đầu;
- không cần phân phối state/data ngay;
- transaction và consistency trong một node/process đơn giản hơn;
- giảm số node cần deploy, monitor và patch;
- phù hợp software/license hoặc database workload khó phân mảnh.

#### 4. Giới hạn và rủi ro

- có trần phần cứng/cloud instance;
- high-end machine thường có giá tăng không tuyến tính;
- resize có thể cần restart/downtime/failover;
- failure blast radius lớn vì nhiều capacity tập trung;
- một node không tự tạo redundancy;
- process/application có thể không tận dụng thêm core/RAM;
- scale-up không giải quyết giới hạn software lock, algorithm hay external dependency.

Vertical scaling không mặc nhiên đồng nghĩa single point of failure. Có thể chạy nhiều replica lớn hoặc HA database pair. Tuy nhiên, nếu toàn workload chỉ nằm trên một node, node đó rõ ràng vẫn là failure domain tập trung.

#### 5. Khi nào nên chọn?

- MVP hoặc traffic còn nhỏ và chưa chắc chắn;
- cần capacity nhanh với engineering effort thấp;
- monolith/stateful workload chưa sẵn sàng phân phối;
- database cần thêm RAM để tăng cache hit hoặc IOPS;
- license/operational overhead tính theo node;
- scale-up vẫn còn rẻ hơn chi phí xây/vận hành distributed architecture.

#### 6. Điểm dừng của vertical scaling

Nên chuẩn bị chuyển chiến lược khi:

- gần chạm machine class lớn nhất;
- cost/performance xấu dần;
- maintenance/failure của một node ảnh hưởng quá lớn;
- cần availability qua nhiều failure domain;
- một node không đủ peak throughput;
- tốc độ tăng demand vượt khả năng resize thủ công;
- business cần deploy/scale từng workload độc lập.

---

#### Nhánh B — Horizontal scaling

#### 7. Scale out và scale in

Horizontal scaling thêm node/instance vào pool để chia workload; **scale in** loại bớt node khi không cần.

```text
Client
  │
  ▼
Load Balancer
  ├── Instance A
  ├── Instance B
  ├── Instance C
  └── Instance D
```

Thêm node chỉ hữu ích khi traffic/data có thể được phân phối và shared dependency còn capacity.

#### 8. Điều kiện để scale-out hiệu quả

- có load balancer/routing/discovery;
- instance có readiness/liveness và connection draining;
- application state được externalize, replicate hoặc partition hợp lý;
- request/job có thể xử lý song song;
- database/cache/broker không trở thành bottleneck mới;
- idempotency và retry được thiết kế;
- telemetry cho từng instance và toàn pool;
- deployment/configuration đồng nhất;
- traffic không skew mạnh vào một key/tenant/partition.

#### 9. Stateless compute là trường hợp dễ nhất

Nếu instance không giữ session/local state cần thiết cho request tiếp theo, load balancer có thể gửi request tới bất kỳ replica khỏe mạnh nào. Scale-out/in và failover trở nên linh hoạt.

State không biến mất; nó chuyển sang:

- distributed cache/session store;
- database;
- object storage;
- message broker;
- client/token khi phù hợp.

Vì vậy, stateless application tier thường đổi local simplicity lấy dependency và network cost ở lớp state bên dưới.

#### 10. Stateful system khó scale hơn

Database, broker và storage cần thêm quyết định:

- **replication** để tăng availability/read capacity;
- **partitioning/sharding** để chia data/write load;
- leader/follower hoặc multi-leader coordination;
- rebalancing khi thêm/bớt node;
- consistency và quorum;
- backup/restore và disaster recovery;
- hot partition, skew và cross-shard query/transaction.

Không thể chỉ đặt load balancer trước một database rồi coi như đã scale ngang an toàn.

#### 11. Ưu điểm

- growth ceiling cao hơn nhờ thêm nhiều commodity node;
- tăng redundancy và khả năng chịu node failure;
- scale theo traffic và thường hỗ trợ autoscaling;
- rolling deployment và fault isolation tốt hơn khi thiết kế đúng;
- có thể phân phối qua zone/region;
- từng service/workload có thể scale độc lập.

#### 12. Đánh đổi

- distributed coordination, consistency và partial failure;
- load balancing, discovery và health management;
- network/serialization overhead;
- state synchronization, replication và partitioning;
- quan sát/debug phức tạp hơn;
- retry storm, duplicate work và thundering herd;
- data transfer và platform cost;
- hiệu quả không tuyến tính vì contention và coordination overhead.

Nếu tăng số node gấp đôi nhưng shared database vẫn cố định, throughput toàn hệ thống hiếm khi tăng đúng gấp đôi.

#### 13. Scale out khác high availability

Nhiều instance không tự động tạo HA nếu:

- tất cả nằm trong cùng rack/zone/failure domain;
- load balancer hoặc database là single point of failure;
- deploy/config sai đồng loạt;
- shared dependency hết capacity;
- dữ liệu không được replicate/backup;
- health check đánh dấu instance lỗi là khỏe.

Scalability và availability hỗ trợ nhau nhưng phải được thiết kế, đo và thử nghiệm riêng.

---

#### Nhánh C — Diagonal scaling

#### 14. Cách hoạt động

Diagonal scaling thường đi theo lộ trình:

```text
1 node nhỏ
   │ scale up
1 node lớn hơn
   │ chuẩn hóa stateless/routing/state
N node vừa hoặc lớn
   │ scale out + selective scale up
Nhiều pool/service scale độc lập
```

Vertical scaling **mua thời gian** và giữ hệ thống đơn giản. Horizontal scaling mở rộng trần capacity và resilience. Diagonal scaling là con đường thực dụng nối hai giai đoạn.

#### 15. Vì sao phổ biến trên cloud?

- machine size thay đổi dễ hơn hạ tầng vật lý;
- container/task/node pool có thể vừa resize vừa thay replica count;
- managed database hỗ trợ đổi instance class và read replica/sharding;
- autoscaler có thể scale workload horizontally, trong khi node provisioner chọn machine size;
- team có thể trì hoãn distributed complexity tới khi business thật sự cần.

#### 16. Ví dụ theo component

| Component | Vertical | Horizontal | Diagonal |
|---|---|---|---|
| Web/API tier | Instance lớn hơn | Thêm replica sau LB | Chọn size hiệu quả rồi autoscale replica |
| Relational DB | Tăng RAM/CPU/IOPS | Read replica, partition/shard | Scale primary trước, thêm replica rồi shard khi cần |
| Cache | Node nhiều memory hơn | Cluster/shard | Resize node rồi tăng shard/replica |
| Message consumer | Worker mạnh hơn | Thêm consumer theo partition | Chọn worker size rồi scale consumer group |
| Search/analytics | Heap/CPU lớn hơn | Thêm data/compute node | Cân bằng node size, shard count và replica |

Không nhất thiết mọi component dùng cùng chiến lược. API có thể scale ngang trong khi primary database vẫn scale dọc và dùng read replica.

#### 17. Rủi ro của diagonal scaling

- trì hoãn partitioning quá lâu khiến migration khẩn cấp;
- kết hợp hai cơ chế nhưng không có capacity model rõ;
- node quá lớn làm bin-packing kém và blast radius cao;
- node quá nhỏ làm tăng coordination/network/operational overhead;
- vertical autoscaler và horizontal autoscaler phản ứng xung đột;
- resize/rebalance stateful node tạo performance dip.

Diagonal không phải “tốt nhất của cả hai” miễn phí; nó kế thừa cả ưu điểm lẫn failure mode của hai hướng.

---

#### Nhánh D — Chọn chiến lược theo trade-off

#### 18. So sánh nhanh

| Tiêu chí | Vertical | Horizontal | Diagonal |
|---|---|---|---|
| Thay đổi kiến trúc | Ít | Nhiều hơn | Tăng dần |
| Tốc độ có thêm capacity | Thường nhanh đến một ngưỡng | Phụ thuộc automation/warm-up | Linh hoạt |
| Trần tăng trưởng | Giới hạn bởi node lớn nhất | Cao hơn | Cao nếu có đường scale-out |
| Resilience | Không tự có | Có thể tốt hơn qua replica/failure domain | Tùy giai đoạn |
| State management | Đơn giản hơn | Khó hơn | Chuyển đổi dần |
| Cost curve | Có thể tăng mạnh ở high-end | Tốn platform/operations | Tối ưu theo giai đoạn |
| Operational complexity | Thấp hơn | Cao | Trung bình rồi tăng |
| Use case điển hình | MVP, monolith, DB scale-up | Internet-scale stateless/distributed workload | Cloud system phát triển theo thời gian |

#### 19. Cost không chỉ là hóa đơn hạ tầng

Total cost gồm:

```text
Infrastructure
+ engineering effort
+ operational/on-call burden
+ migration risk
+ downtime/SLO violation
+ licensing/data transfer
```

Một cụm node rẻ hơn trên bảng giá có thể đắt hơn nếu cần nhiều tháng engineering và vận hành. Ngược lại, một máy lớn đơn giản có thể trở nên đắt/rủi ro khi demand và availability requirement tăng.

#### 20. Diminishing returns

Scale không tuyến tính vô hạn. Phần tuần tự, shared lock, coordination và contention giới hạn speedup:

```text
Resource tăng:      1x   2x   4x   8x
Throughput thực tế: 1x  1,8x 3,1x 4,7x   (ví dụ)
```

Cần đo marginal throughput và marginal cost của lần scale tiếp theo. Khi thêm node gần như không tăng output, hãy tìm bottleneck/coordination thay vì tiếp tục scale mù quáng.

#### 21. Theo giai đoạn sản phẩm

**MVP/early stage**

- ưu tiên simplicity và tốc độ học từ thị trường;
- monolith + một database có HA/backup hợp lý;
- scale up và tối ưu query/cache trước;
- tránh xây distributed system cho traffic chưa tồn tại.

**Growing product**

- load test và thiết lập SLO/capacity model;
- làm application tier stateless, thêm load balancer;
- tách background job, cache và read replica nếu bottleneck yêu cầu;
- tự động deployment, observability và recovery.

**Large/mature platform**

- scale từng workload theo bottleneck;
- partition data/traffic, multi-zone/region khi business cần;
- backpressure, load shedding, quota và failure isolation;
- cost efficiency, governance và organizational ownership trở thành driver lớn.

Ví dụ tên công ty chỉ minh họa xu hướng. Không nên suy luận rằng một platform chuyển trực tiếp từ monolith sang microservices chỉ vì horizontal scaling; sự tiến hóa thực tế thường gồm nhiều bước và chịu ảnh hưởng của tổ chức, sản phẩm lẫn dữ liệu.

#### 22. Decision framework

1. **Xác định demand**: steady, spike, seasonal; RPS, data, concurrency.
2. **Đặt SLO**: latency, availability, error và cost target.
3. **Đo bottleneck**: CPU, memory, I/O, lock, connection, dependency quota.
4. **Giảm work**: optimize, cache, batch, async, index trước khi mua capacity.
5. **Đánh giá vertical headroom**: trần, giá, downtime, blast radius.
6. **Đánh giá parallelism**: workload/state có chia được không?
7. **Tính distributed cost**: LB, replication, consistency, observability, on-call.
8. **Chọn bước nhỏ nhất đủ dùng**: vertical, horizontal hoặc phối hợp.
9. **Thiết kế scale-down/failure**: drain, rebalance, cooldown, rollback.
10. **Load/failure test** và cập nhật model từ production telemetry.

#### 23. Các anti-pattern phổ biến

- Scale tất cả component cùng tỷ lệ dù bottleneck chỉ ở một nơi.
- Dùng average CPU làm signal duy nhất.
- Thêm replica nhưng giữ session trong local memory.
- Scale application trong khi database connection đã cạn.
- Dùng sticky session thay cho kế hoạch availability của state.
- Cho rằng nhiều instance tự động đồng nghĩa HA.
- Autoscale quá nhanh gây oscillation hoặc scale-out khi dependency đang lỗi.
- Scale in không drain connection/job.
- Chọn shard count theo hiện tại nhưng không có đường rebalance.
- Dùng máy lớn để che query/algorithm kém vô thời hạn.
- Xây microservices/sharding quá sớm cho tải chưa có.
- Chỉ tính infrastructure cost, bỏ qua engineering và operations.

#### 24. Câu hỏi phỏng vấn và câu trả lời ngắn

**Q1. Vertical và horizontal scaling khác gì?**  
Vertical tăng resource một node; horizontal tăng số node và phân phối workload. Vertical đơn giản nhưng có trần; horizontal có trần cao hơn nhưng đưa vào distributed complexity.

**Q2. Diagonal scaling là gì?**  
Chiến lược kết hợp: resize node tới mức hiệu quả rồi thêm node, hoặc phối hợp cả hai theo từng component/giai đoạn.

**Q3. Khi nào scale up trước?**  
Khi còn headroom kinh tế, cần capacity nhanh, workload stateful/monolithic và chi phí phân phối lớn hơn lợi ích hiện tại.

**Q4. Điều gì cản scale out?**  
Local state, sequential work, shared database/lock, hot partition, coordination, license hoặc dependency quota.

**Q5. Horizontal scaling có luôn rẻ hơn không?**  
Không. Commodity nodes có thể rẻ nhưng LB, network, replication, platform, observability và nhân lực làm tăng total cost.

**Q6. Vì sao stateless service dễ scale ngang?**  
Request không phụ thuộc instance trước nên có thể route tới replica bất kỳ và loại/thêm node linh hoạt.

**Q7. Làm sao biết đã tới lúc chuyển từ vertical sang horizontal?**  
Khi gần trần node, marginal cost xấu, failure/maintenance impact quá lớn, cần multi-zone resilience hoặc demand tăng nhanh hơn khả năng resize.

**Q8. Có thể scale database ngang giống web server không?**  
Không đơn giản. Database cần replication/partitioning, consistency, transaction, rebalancing và data ownership strategy.

**Q9. Autoscaling liên quan thế nào?**  
Autoscaling tự động điều chỉnh capacity; nó có thể scale ngang replica hoặc scale dọc resource. Cần signal, cooldown, warm-up và overload plan.

**Q10. Scaling tốt được đánh giá thế nào?**  
SLO giữ ổn định, throughput tăng đủ theo resource, failure vẫn chịu được và marginal/total cost hợp lý.

#### 25. Nội dung phỏng vấn bổ sung từ PDF

**Q11. Khi nào horizontal scaling không giúp?**

- workload có phần tuần tự hoặc global lock lớn;
- bottleneck là singleton/shared dependency không scale theo;
- request không thể chia độc lập;
- database write path vẫn tập trung;
- traffic dồn vào một hot key/partition;
- state cục bộ làm request chỉ chạy đúng trên một node;
- coordination overhead lớn hơn parallelism thu được.

Thêm node trong các trường hợp này có thể làm tăng connection, contention và chi phí nhưng throughput gần như không đổi.

**Q12. State management khi scale ngang nên xử lý thế nào?**  
Các lựa chọn gồm externalize session vào shared store, client/token phù hợp, partition state theo key hoặc replicate state theo consistency requirement. Sticky session chỉ giúp route cùng client về một node; nó không tạo durability, không giải quyết node failure và có thể gây skew.

**Q13. “Dùng distributed transaction, eventual consistency hoặc CQRS” có phải một bộ giải pháp thay thế tương đương?**  
Không. Đây là các công cụ giải quyết vấn đề khác nhau:

- distributed transaction bảo vệ atomicity trong một số boundary với availability/coordination cost;
- eventual consistency chấp nhận độ trễ hội tụ khi business invariant cho phép;
- CQRS tách read/write model, không tự giải quyết consistency;
- saga/compensation phù hợp một số workflow dài qua service.

Chọn từ invariant và failure semantics, không chọn theo danh sách công nghệ.

**Q14. Horizontal scaling có gần tuyến tính không?**  
Chỉ trong một khoảng khi work parallelizable, traffic cân bằng, shared dependency còn headroom và coordination nhỏ. Scalability efficiency có thể đo gần đúng:

```text
efficiency(N) = throughput(N) / (N × throughput(1))
```

Ví dụ 4 node đạt 3,2 lần throughput một node thì efficiency khoảng 80%, không phải 100%.

**Q15. Diagonal scaling có phù hợp burst vì vertical scaling phản ứng nhanh không?**  
Không mặc định. Resize VM/database có thể cần restart, failover hoặc lâu hơn việc thêm replica đã warm. Với burst, cách phù hợp thường là giữ baseline size hợp lý, pre-scale/scale-out và có queue/headroom. “Vertical trước, horizontal sau” là roadmap tổ chức phổ biến, không phải quy luật tốc độ runtime.

**Q16. Orchestrator và service discovery có bắt buộc cho scale ngang không?**  
Không ở mọi quy mô. Một pool VM nhỏ sau managed load balancer có thể scale ngang mà không cần Kubernetes. Khi số workload, deployment và scheduling constraint tăng, orchestrator giúp tự động hóa nhưng cũng thêm control-plane complexity.

#### 26. Ý chính cần nhớ

- Vertical = bigger node; horizontal = more nodes; diagonal = kết hợp theo lộ trình.
- Vertical scaling nhanh và đơn giản nhưng có hardware/economic/failure-domain limit.
- Horizontal scaling tăng capacity/resilience tiềm năng nhưng cần phân phối traffic, state và data.
- Stateless compute dễ scale out; stateful storage cần replication/partitioning/consistency.
- Thêm node không bảo đảm throughput tuyến tính hoặc high availability.
- Mỗi component có thể dùng một chiến lược khác nhau.
- Diagonal scaling là cách tiến hóa thực dụng, không phải lợi ích miễn phí.
- Chọn theo product stage, bottleneck, SLO, team capability và total cost.
- Scale-down, failure và rebalancing quan trọng như scale-up.
- Tối ưu đúng workload trước khi thêm resource.

#### Công thức ghi nhớ

> **Vertical scaling mua thời gian; horizontal scaling nâng trần tăng trưởng; diagonal scaling tạo con đường chuyển đổi thực dụng — nhưng chỉ đo bottleneck, SLO và total cost mới cho biết bước tiếp theo đúng là gì.**

---

### Bài 36. Understanding Load Balancers — Types, Algorithms & Cloud Solutions

#### 1. Vì sao horizontal scaling cần load balancer?

Khi chỉ có một server, client có một endpoint nhưng hệ thống có hai giới hạn:

- capacity bị giới hạn bởi một máy;
- máy đó là single point of failure.

Load balancer tạo một entry point ổn định trước một pool backend động:

```text
Clients
   │ stable endpoint
   ▼
Load Balancer
   ├── Backend A
   ├── Backend B
   ├── Backend C
   └── Backend D
```

Các trách nhiệm cốt lõi:

- chọn backend cho connection/request;
- chỉ route tới backend đủ khỏe và sẵn sàng;
- thêm/bớt instance mà client không đổi endpoint;
- hỗ trợ failover, deployment và connection draining;
- phân phối tải phù hợp với capacity;
- có thể terminate/proxy TLS và thực hiện application-aware routing;
- cung cấp metrics về traffic, latency và backend health.

Load balancer là **enabler** của horizontal scaling, không phải phép màu khiến mọi component tự scale. Nếu session nằm cục bộ, database đã bão hòa hoặc request không thể song song, thêm backend có thể không tăng capacity hữu ích.

#### 2. Request flow cơ bản

```text
1. Client resolve public endpoint
2. Client mở connection/gửi request tới load-balancer tier
3. Load balancer áp listener, route, health và balancing policy
4. Load balancer chọn một healthy backend
5. Connection/request được forward tới backend
6. Backend trả response trực tiếp hoặc qua load balancer
7. Telemetry cập nhật health/load/latency signal
```

Tùy implementation, load balancer có thể là full proxy, NAT-based forwarding, direct server return hoặc distributed data plane. Không nên mặc định mọi load balancer đều xử lý response theo cùng một đường.

#### 3. Control plane và data plane

- **Control plane** quản lý listener, route, certificate, backend membership, weight và policy.
- **Data plane** trực tiếp nhận, phân loại và chuyển traffic.

Control plane chậm hoặc tạm lỗi không nhất thiết làm traffic đang chạy dừng nếu data plane còn cached configuration. Ngược lại, rollout cấu hình sai có thể tác động đồng loạt lên nhiều data-plane instance. Cần versioning, validation, staged rollout và rollback cho policy.

---

#### Nhánh A — Phân loại load balancer

#### 4. Layer 4 load balancing

Layer 4 làm việc chủ yếu với TCP/UDP flow và thông tin như source/destination IP, port, protocol.

**Ưu điểm**

- ít application parsing, throughput cao và latency thấp;
- phù hợp TCP/UDP protocol không phải HTTP;
- có thể giữ end-to-end TLS nếu dùng passthrough;
- xử lý connection lớn hoặc network service tổng quát.

**Giới hạn**

- không route theo URL path, HTTP header, cookie hay method nếu không terminate/hiểu application protocol;
- health/application semantics thường ít sâu hơn;
- đơn vị balance thường là flow/connection.

L4 không luôn “nhanh hơn tuyệt đối”; performance phụ thuộc kiến trúc proxy/NAT, TLS, hardware offload, packet size và feature đang bật.

#### 5. Layer 7 load balancing

Layer 7 hiểu application protocol như HTTP/HTTPS và có thể route theo:

- hostname;
- path, method và query trong phạm vi policy;
- header hoặc cookie;
- content type, tenant hoặc API version;
- weight giữa các deployment/version.

Ví dụ:

```text
/products/* ──> Catalog pool
/checkout/* ──> Checkout pool
/images/*   ──> Static/media pool
Host admin.example.com ──> Admin pool
```

L7 hỗ trợ TLS termination, redirect, header normalization, WAF/rate limit integration và observability phong phú hơn. Đổi lại, proxy phải parse protocol, quản lý connection hai phía và thường dùng nhiều CPU/memory hơn.

#### 6. Hardware, software và managed load balancer

| Mô hình | Điểm mạnh | Đánh đổi |
|---|---|---|
| **Hardware appliance** | Specialized networking, enterprise feature/performance | Chi phí, procurement, capacity planning và vendor operations |
| **Software LB** | Linh hoạt, chạy trên commodity VM/container, kiểm soát cao | Đội ngũ tự scale, patch, HA và vận hành |
| **Cloud-managed LB** | Managed data plane, integration cloud, elasticity/HA thuận tiện | Chi phí dịch vụ, quota, feature/behavior theo provider và lock-in |

Ví dụ software phổ biến gồm NGINX, HAProxy và Envoy. Các cloud lớn cung cấp managed load-balancing family cho application, network và global/edge traffic; tên sản phẩm và chi tiết khả năng có thể thay đổi, nên chọn theo semantics thay vì chỉ nhớ tên dịch vụ.

#### 7. External, internal, local và global

- **External/public LB** nhận traffic từ Internet.
- **Internal/private LB** phân phối traffic trong private network/VPC.
- **Local/regional LB** chọn backend trong một region/cluster/failure domain.
- **Global load balancing/traffic steering** chọn region/edge endpoint trước, thường dựa trên anycast, DNS hoặc global proxy.

Một kiến trúc lớn có nhiều tầng:

```text
User
  │
  ▼
Global traffic steering
  ├── Region A → Regional LB → Service pool
  └── Region B → Regional LB → Service pool
```

Global routing phải cân bằng latency, regional health, capacity, data residency và consistency. Không nên route user sang region “gần nhất” nếu region đó không có data hoặc không đủ capacity.

---

#### Nhánh B — Thuật toán phân phối tải

#### 8. Chọn đúng đơn vị tải

“Chia đều request” chưa chắc chia đều work. Một request có thể kéo dài 5 ms, request khác 30 giây; một connection HTTP/2 có thể mang nhiều stream; một response có thể 1 KB hoặc 1 GB.

Trước khi chọn thuật toán, cần xác định đơn vị gây saturation:

- connection đang mở;
- request đang xử lý;
- queue/outstanding work;
- CPU/memory;
- bytes/second;
- response time;
- tenant/key/partition;
- backend capacity tương đối.

#### 9. Round Robin

```text
Request 1 → A
Request 2 → B
Request 3 → C
Request 4 → A
```

Phù hợp khi backend gần đồng nhất và request có cost tương tự.

**Ưu:** đơn giản, deterministic, ít telemetry.  
**Nhược:** không phản ánh connection duration, request cost hoặc backend đang chậm.

#### 10. Weighted Round Robin

Mỗi backend/pool nhận traffic theo weight, ví dụ A:B:C = 4:2:1. Dùng khi:

- máy có capacity khác nhau;
- canary/blue-green traffic split;
- region/pool có capacity khác nhau;
- backend mới cần tăng traffic dần.

Weight tĩnh cần được cập nhật khi performance thực tế đổi; weight không chính xác có thể tạo hotspot.

#### 11. Least Connections

Chọn backend có ít active connection hơn. Hữu ích khi connection có duration khác nhau, như long polling hoặc TCP session.

Hạn chế:

- số connection không phản ánh work bên trong connection;
- HTTP/2/gRPC multiplex nhiều request/stream trên một connection;
- backend vừa khởi động có 0 connection nên có thể nhận burst nếu không slow start;
- cần state/counter chính xác trong phạm vi load-balancer node hoặc toàn tier.

#### 12. Least Outstanding Requests / Least Load

Chọn backend có ít request/work đang xử lý hơn; đôi khi kết hợp weight/capacity. Nó phản ánh request-level pressure tốt hơn least connections cho HTTP workload, nhưng vẫn cần đo đúng và xử lý delayed/stale signal.

#### 13. Least Response Time

Ưu tiên backend có observed latency thấp, thường kết hợp active connection. Có thể thích ứng với backend chậm nhưng dễ tạo feedback loop:

```text
Backend chậm → nhận ít traffic → hồi phục
Backend nhanh → nhận nhiều traffic → có thể bị quá tải
```

Metrics phải làm mượt, giới hạn tốc độ thay đổi và tránh đánh giá backend chỉ từ ít sample.

#### 14. Random và Power of Two Choices

- **Random** chọn ngẫu nhiên một backend khỏe; đơn giản và tránh global coordination lớn.
- **Power of Two Choices** lấy ngẫu nhiên hai backend rồi chọn backend ít tải hơn. Với pool lớn, cách này thường cân bằng tốt hơn random trong khi tránh phải biết state chính xác của mọi node.

#### 15. IP hash và session affinity

Hash source IP để cùng client thường tới cùng backend:

```text
backend = hash(client_ip) mod N
```

Hữu ích cho cache locality hoặc legacy local session, nhưng có vấn đề:

- nhiều user sau NAT/proxy có cùng IP và tạo skew;
- mobile client đổi IP;
- thêm/bớt backend làm nhiều mapping thay đổi;
- backend lỗi khiến affinity bị mất;
- client IP cần được lấy từ trusted proxy chain.

Cookie-based affinity có thể chính xác ở session hơn IP hash nhưng vẫn tạo uneven load và coupling vào instance.

> Session affinity là tactical routing optimization, không phải chiến lược durability/availability của session state.

#### 16. Consistent và rendezvous hashing

Hash-based routing theo key như tenant, cache key hoặc object ID có thể tăng locality. **Consistent hashing** hoặc **rendezvous hashing** giảm tỷ lệ key phải remap khi membership thay đổi so với modulo hash đơn giản.

Đánh đổi:

- hot key vẫn tạo hot backend;
- weight/rebalancing phức tạp hơn;
- membership phải nhất quán đủ mức cần thiết;
- affinity/locality có thể đối lập với load balance tức thời.

#### 17. Adaptive load balancing

Adaptive policy có thể kết hợp:

- active requests/connections;
- latency/error rate;
- CPU/memory/queue depth;
- backend health và outlier score;
- preconfigured weight/capacity;
- locality và network cost.

Nhiều signal không tự động tốt hơn. Telemetry có delay, metric có thể nhiễu, và feedback controller có thể oscillate. Policy cần bounded adjustment, smoothing, cooldown, fallback và observability.

#### 18. Bảng chọn thuật toán

| Workload | Điểm khởi đầu hợp lý | Cần lưu ý |
|---|---|---|
| Request ngắn, backend đồng nhất | Round robin | Theo dõi request cost/skew |
| Backend capacity khác nhau | Weighted round robin | Calibrate weight |
| TCP/long-lived connection | Least connections | Connection không luôn bằng load |
| HTTP request cost biến động | Least outstanding/load | Signal delay và queue |
| Pool rất lớn | Power of two choices | Local view có thể đủ |
| Cần key/cache locality | Consistent/rendezvous hash | Hot key, membership change |
| Canary rollout | Weighted routing | Guardrail và rollback |

Không có thuật toán tốt nhất. Nên bắt đầu đơn giản, đo imbalance/SLO rồi chỉ tăng tính thích ứng khi workload chứng minh cần thiết.

---

#### Nhánh C — Health, lifecycle và reliability

#### 19. Active và passive health check

**Active health check** chủ động gửi probe định kỳ:

- TCP connect;
- HTTP `/health` hoặc `/ready`;
- protocol-specific probe.

**Passive health check/outlier detection** suy ra trạng thái từ traffic thật:

- timeout/reset tăng;
- consecutive 5xx;
- latency lệch xa pool;
- connection failure.

Kết hợp cả hai giúp phát hiện process chết lẫn backend “vẫn trả health 200 nhưng request thật liên tục lỗi”.

#### 20. Liveness, readiness và deep health

- **Liveness:** process có sống hay cần restart?
- **Readiness:** instance hiện có nên nhận traffic mới không?
- **Deep health:** kiểm tra dependency/business flow sâu hơn.

Readiness endpoint nên phản ánh khả năng phục vụ nhưng không phụ thuộc mù quáng vào mọi shared dependency. Nếu database tạm chậm làm tất cả instance cùng fail readiness, load balancer có thể loại toàn pool và khuếch đại outage.

#### 21. Threshold và hysteresis

Không nên eject backend sau một probe lỗi ngẫu nhiên hoặc đưa lại ngay sau một probe thành công. Dùng:

- unhealthy threshold;
- healthy threshold;
- interval/timeout;
- success/error window;
- eject duration và maximum ejection percentage.

Hysteresis giúp tránh backend liên tục flap giữa healthy/unhealthy.

#### 22. Slow start và warm-up

Backend mới có thể cần:

- JIT/runtime warm-up;
- connection pool establishment;
- cache warming;
- model/data loading.

Nếu nhận full share ngay khi healthy, nó có thể quá tải rồi lại bị eject. **Slow start** tăng weight/traffic dần cho tới mức bình thường.

#### 23. Connection draining

Khi deploy/scale in:

1. đánh dấu backend draining/not ready;
2. dừng connection/request mới;
3. cho request/stream hiện tại hoàn tất trong grace period;
4. timeout/close phần còn lại;
5. dừng instance.

Đặc biệt quan trọng với upload, WebSocket, SSE, gRPC stream và long-running request. Grace period quá ngắn làm lỗi client; quá dài làm rollout/scale-in chậm.

#### 24. Failover và capacity sau lỗi

Loại backend lỗi chỉ hữu ích nếu phần còn lại đủ capacity:

```text
N backend × safe capacity
- capacity của failure domain lớn nhất
≥ peak load cần phục vụ
```

Nếu chạy 4 node ở 80% tải, mất một node khiến ba node còn lại vượt 100%. Load balancer có route đúng vẫn không cứu được. Cần headroom, autoscaling, load shedding và priority policy.

#### 25. Load balancer cũng có thể là bottleneck/SPOF

Load-balancer tier cần:

- nhiều data-plane instance qua failure domain;
- stable discovery/failover như managed service, anycast hoặc DNS;
- capacity và connection/packet-per-second headroom;
- configuration distribution an toàn;
- DDoS/connection exhaustion protection;
- metrics, alert và tested failure behavior.

Một “HA load balancer” đặt trước một database đơn lẻ vẫn không tạo end-to-end HA.

---

#### Nhánh D — Connection, protocol và security

#### 26. Connection-level và request-level balancing

L4 thường chọn backend khi flow được tạo; mọi dữ liệu của connection đó tiếp tục tới cùng backend. L7 proxy có thể chọn theo request/stream, nhưng hành vi phụ thuộc protocol và upstream connection pool.

Ví dụ:

- HTTP/1.1 keep-alive có nhiều request tuần tự trên connection;
- HTTP/2/gRPC multiplex nhiều stream trên một connection;
- WebSocket là connection dài sau handshake;
- QUIC có connection semantics khác TCP và connection migration.

Nếu chỉ có vài persistent connection từ upstream proxy tới backend, “round robin theo connection” có thể phân phối kém dù request count rất lớn. Cần quan sát đúng layer.

#### 27. TLS termination, passthrough và re-encryption

| Mô hình | Đặc điểm |
|---|---|
| **TLS termination** | LB giải mã client TLS, có thể L7 route và quản lý certificate |
| **TLS passthrough** | LB chuyển encrypted flow, backend terminate TLS |
| **TLS re-encryption** | LB terminate phía client rồi tạo TLS mới tới backend |

Termination tập trung certificate/WAF/routing nhưng load balancer trở thành plaintext trust boundary. Kết nối backend cần network isolation, authentication/mTLS hoặc re-encryption theo threat model.

#### 28. Client IP và trusted proxy chain

Khi proxy đứng giữa, backend có thể thấy IP của proxy. L7 thường truyền metadata như `X-Forwarded-For` hoặc standardized `Forwarded`; một số L4 setup dùng proxy protocol hoặc preserve source IP.

Backend chỉ nên tin header client identity/address do **trusted proxy** ghi/chuẩn hóa. Nếu chấp nhận `X-Forwarded-For` do Internet client tự gửi, rate limit, audit hoặc allowlist có thể bị bypass.

#### 29. Security responsibilities

Load balancer có thể tích hợp:

- TLS/certificate management;
- WAF và DDoS protection;
- IP/network policy;
- authentication hook ở một số kiến trúc;
- request size/header limit;
- rate limiting và bot controls;
- security logging.

Nhưng backend vẫn cần authentication, object/action authorization, input validation và safe business logic. Entry-layer filtering là defense-in-depth, không thay service security.

#### 30. Timeout, retry và overload

Các timeout cần phối hợp:

- client timeout/deadline;
- load balancer request/idle/connect timeout;
- backend timeout;
- stream/keep-alive duration.

Retry tại load balancer chỉ an toàn khi operation retryable/idempotent và còn time budget. Retry quá mức biến lỗi backend thành load amplification. Cần retry budget, backoff, attempt limit và không retry request body không thể replay an toàn.

Khi toàn pool bão hòa, route “thông minh” không tạo thêm capacity. Load balancer nên hỗ trợ queue giới hạn, rate limit, load shedding hoặc trả lỗi nhanh để tránh resource collapse.

---

#### Nhánh E — Cloud solutions và lựa chọn kiến trúc

#### 31. Managed cloud load balancing

Cloud providers thường cung cấp nhiều family thay vì một load balancer duy nhất:

- L4 network load balancing cho TCP/UDP/high throughput;
- L7 application load balancing cho HTTP routing/TLS;
- internal/private load balancing;
- regional và global/edge load balancing;
- gateway/appliance insertion cho network/security virtual appliance;
- integration với autoscaling, service discovery, certificate, WAF và logging.

Các tên thường gặp trong hệ sinh thái cloud gồm AWS Elastic Load Balancing, Google Cloud Load Balancing và Azure Load Balancer/Application Gateway/Front Door. Khi thiết kế, ánh xạ requirement vào capability thay vì giả định các sản phẩm cùng semantics.

#### 32. Câu hỏi cần hỏi khi chọn managed service

- L4 hay L7; protocol/version nào được hỗ trợ?
- Regional hay global; external hay internal?
- Proxy hay passthrough; client IP được bảo toàn thế nào?
- TLS termination, certificate và mTLS ra sao?
- Health check, outlier detection, draining và slow start có gì?
- Thuật toán/routing/weight/affinity được hỗ trợ tới đâu?
- Connection, rule, target, bandwidth và request quota/limit là gì?
- Cross-zone/region data transfer và pricing thế nào?
- Log/metric/trace có đủ cho SLO và incident response không?
- Failure/maintenance semantics và SLA của control/data plane ra sao?
- Có thể export/migrate configuration hay bị lock-in tới mức nào?

#### 33. Software LB khi nào phù hợp?

Chọn software LB khi cần:

- protocol/filter/routing tùy biến;
- chạy on-premises, hybrid hoặc multi-cloud nhất quán;
- kiểm soát version/configuration và data path;
- sidecar/ingress/service proxy trong platform;
- economics hợp lý ở quy mô/traffic cụ thể.

Đổi lại, team sở hữu HA, scaling, patching, certificate, CVE, metrics, tuning kernel/network và on-call.

#### 34. Hardware appliance khi nào phù hợp?

Có thể hợp lý với data center lớn, compliance, specialized network integration, legacy enterprise feature hoặc performance/offload rất cụ thể. Không nên chọn chỉ vì “hardware luôn nhanh hơn”; cần so total cost, failure model, procurement time và operational skill.

#### 35. Decision framework

1. Xác định protocol và đơn vị balance: packet, flow, connection, request hay key.
2. Đặt SLO, peak traffic, connection count và failure requirement.
3. Xác định cần L7 routing/TLS/WAF hay chỉ L4 forwarding.
4. Mô tả backend: đồng nhất hay khác capacity; short hay long-lived work.
5. Chọn thuật toán đơn giản nhất phù hợp workload.
6. Thiết kế health, warm-up, drain và failure headroom.
7. Quyết định affinity/state; ưu tiên shared/durable state khi cần availability.
8. Chọn deployment model theo team capability, compliance và total cost.
9. Kiểm tra LB tier, control plane và downstream đều không là SPOF/bottleneck.
10. Load/failure test với traffic skew, backend chậm, zone loss và config rollback.

#### 36. Failure modes thường gặp

| Failure mode | Hậu quả | Hướng xử lý |
|---|---|---|
| Health check quá nông | Backend lỗi logic vẫn nhận traffic | Passive signal, check đúng readiness |
| Health check quá sâu | Shared dependency lỗi làm eject toàn pool | Tách liveness/readiness, threshold |
| Backend mới nhận full load | Cold instance quá tải/flap | Slow start, warm-up |
| Sticky session + node lỗi | User mất state | Shared session/recovery strategy |
| Long-lived connection skew | Một backend nóng | Connection-aware policy/rebalance design |
| Retry mọi lỗi | Retry storm | Budget, idempotency, deadline |
| LB đủ capacity, DB không đủ | Backend đẩy DB quá tải | End-to-end capacity model |
| LB một instance | Entry point SPOF | HA/multi-zone/managed data plane |
| Config rollout sai | Global traffic outage | Validate, canary, version, rollback |
| Tin client-supplied proxy header | Bypass audit/rate limit | Trusted proxy chain, overwrite header |
| Thiếu failure headroom | Eject node gây cascading overload | N+failure capacity, shed load |

#### 37. Câu hỏi phỏng vấn và trả lời ngắn

**Q1. Load balancer giải quyết gì?**  
Tạo entry point ổn định, phân phối traffic qua healthy backends, hỗ trợ scale-out, failover và deployment mà client không biết topology.

**Q2. Layer 4 và Layer 7 khác nhau thế nào?**  
L4 route flow dựa vào network/transport metadata; L7 hiểu application protocol và route theo HTTP attributes. L7 linh hoạt hơn nhưng parse/proxy nhiều hơn.

**Q3. Round robin và least connections dùng khi nào?**  
Round robin cho backend/request tương đối đồng nhất; least connections hữu ích với connection duration khác nhau, nhưng connection count không luôn phản ánh work.

**Q4. Weighted balancing dùng làm gì?**  
Phản ánh backend capacity khác nhau hoặc chia traffic cho canary/region theo tỷ lệ.

**Q5. IP hash có nhược điểm gì?**  
NAT gây skew, client đổi IP, membership change remap và backend failure phá affinity.

**Q6. Load balancer phát hiện backend lỗi thế nào?**  
Active health probe kết hợp passive observation/outlier detection, với threshold và recovery hysteresis.

**Q7. Load balancer có tạo high availability không?**  
Chỉ khi LB tier, backend, shared dependency và data đều có redundancy qua failure domain, cùng đủ capacity sau lỗi.

**Q8. Tại sao sticky session không phải giải pháp scale tốt dài hạn?**  
Nó tạo coupling/skew và mất state khi node lỗi; shared/durable session state thường linh hoạt hơn.

**Q9. Vì sao HTTP/2 làm least-connections khó diễn giải?**  
Một connection có thể mang nhiều concurrent streams, nên ít connection chưa chắc ít request/load.

**Q10. Managed hay self-hosted LB?**  
Managed giảm operational burden; self-hosted tăng control/customization. Chọn theo feature, SLO, compliance, team và total cost.

**Q11. Nếu tất cả backend đều quá tải thì thuật toán nào tốt nhất?**  
Không thuật toán nào tạo capacity. Cần autoscaling/headroom, admission control, backpressure, load shedding và graceful degradation.

**Q12. Cần theo dõi metric gì?**  
Traffic/connection, LB latency/error, backend latency/error/outstanding work, healthy target count, eject rate, queue/rejection, TLS/network saturation và distribution skew.

#### 38. Nội dung phỏng vấn bổ sung từ PDF

**Q13. Active-active và active-passive load-balancer tier khác gì?**

- **Active-active:** nhiều LB instance cùng nhận traffic; capacity được dùng tốt hơn nhưng cần state/config/traffic distribution phù hợp.
- **Active-passive:** standby tiếp quản khi active lỗi; đơn giản hơn ở một số môi trường nhưng có failover delay và capacity nhàn rỗi.

Dù dùng mô hình nào, virtual/public endpoint, health/failover mechanism và configuration plane đều phải tránh trở thành single point of failure.

**Q14. Session persistence hỗ trợ failover thế nào?**  
Affinity giữ client trên cùng backend khi backend còn khỏe, nhưng khi node lỗi, mapping phải chuyển và local session có thể mất. High availability cần shared/replicated session hoặc khả năng tạo lại state; persistence không phải failover strategy đầy đủ.

**Q15. Thiết kế load balancing cho e-commerce lớn ra sao?**

```text
Users
  ▼
DNS / Anycast / Global traffic steering
  ▼
CDN + DDoS/WAF controls
  ▼
Multi-zone L7 Load Balancer tier
  ├── Catalog/Search pool
  ├── Cart pool
  ├── Checkout/Payment pool
  └── Static/Media origin pool
         │
         ▼
Cache / Queue / Database / External payment
```

Thiết kế cần multi-zone healthy capacity, autoscaling, endpoint-specific timeout/rate limit, connection draining, idempotent checkout, shared cart/session, downstream budgets và graceful degradation. Không chọn Round Robin chỉ vì “static” hay Least Connections chỉ vì “dynamic”; phải đo cost/connection/request thực tế.

**Q16. Có nên dùng Layer 4 load balancer cho database connection?**  
Có thể, nhưng “database → L4” không phải quy luật. Database proxy/load balancer còn phải hiểu primary/replica role, transaction/session semantics, connection pool, failover và read/write routing. Một TCP balancer mù có thể gửi write tới read replica hoặc phá connection state nếu topology không được quản lý đúng.

**Q17. Load balancer cải thiện security tới đâu?**  
LB có thể tạo enforcement point cho TLS, network ACL, rate limit và tích hợp DDoS/WAF. Bản thân load balancing không tự phát hiện mọi DDoS, ngăn SQL injection hay XSS. WAF chỉ giảm một số pattern; application vẫn phải validate input, encode output và authorize đúng object/action.

**Q18. Compression/minification có phải load-balancing strategy không?**  
Không. Chúng là content-delivery/performance optimization. Compression có thể giảm bandwidth nhưng tăng CPU và có security/cache trade-off; minification thường là build-time concern cho static asset. Không nên trộn chúng với thuật toán chọn backend.

**Q19. Weighted Load Balancing khác priority/failover thế nào?**  
Weight chia traffic theo tỷ lệ giữa các backend đang active. Priority/failover thường ưu tiên một pool và chỉ chuyển sang pool khác khi điều kiện xảy ra. Cần xác định rõ semantics vì “trọng số cao” không luôn đồng nghĩa “primary”.

#### 39. Ý chính cần nhớ

- Load balancer tách client khỏi topology backend và là nền tảng của scale-out.
- L4 balance flow/connection; L7 hiểu application request và route linh hoạt hơn.
- Hardware, software và managed cloud LB khác nhau ở ownership, feature, cost và operations.
- Thuật toán phải phù hợp đơn vị tải thực, không chỉ số request.
- Round robin đơn giản; least-load thích ứng hơn; hashing ưu tiên locality/affinity.
- HTTP/2, gRPC, WebSocket và long-lived connection thay đổi cách hiểu “load”.
- Health cần active/passive signal, threshold, slow start và draining.
- Session affinity không thay thế shared/durable state.
- LB tier cũng cần HA, capacity, secure config rollout và overload protection.
- TLS/client-IP handling tạo trust boundary cần cấu hình rõ.
- Managed cloud service giảm vận hành nhưng vẫn có quota, pricing và provider semantics.
- Availability phải được đánh giá end-to-end tới database/dependency, không chỉ backend pool.

#### Công thức ghi nhớ

> **Load balancer không chỉ chia traffic: nó chọn đúng healthy capacity, che giấu topology động và điều phối lifecycle của backend. Nhưng nó chỉ tạo scalability và resilience khi state, downstream capacity, failure domains và chính load-balancer tier cũng được thiết kế đúng.**

---

### Bài 37. Autoscaling & Best Practices in Cloud Environments

#### 1. Autoscaling là gì?

**Autoscaling** là cơ chế tự động điều chỉnh capacity của hệ thống dựa trên demand và policy nhằm giữ cân bằng giữa:

- performance/SLO;
- availability và failure headroom;
- resource utilization;
- infrastructure cost.

```text
Demand tăng → thêm capacity → giữ latency/error trong SLO
Demand giảm → bớt capacity → giảm tài nguyên nhàn rỗi và chi phí
```

Autoscaling không chỉ là “thấy CPU cao thì thêm server”. Một hệ thống production cần chọn đúng signal, tính đúng capacity, phối hợp lifecycle và bảo vệ downstream khi capacity chưa kịp xuất hiện.

#### 2. Autoscaling là một feedback control loop

```text
Workload
   │
   ▼
System ──> Metrics ──> Policy/Controller ──> Scaling action
   ▲                                            │
   └──────────────── new capacity ──────────────┘
```

Vòng điều khiển gồm:

1. **Observe:** thu thập CPU, request rate, queue depth, latency...
2. **Aggregate:** làm mượt và tổng hợp theo window.
3. **Decide:** so metric với target/forecast/policy.
4. **Actuate:** thêm/bớt replica hoặc resource.
5. **Provision:** scheduler/cloud tạo capacity.
6. **Warm:** application khởi động, load data/cache và mở connection.
7. **Register:** readiness đạt, load balancer/broker bắt đầu giao việc.
8. **Re-evaluate:** đo ảnh hưởng và quyết định vòng tiếp theo.

Autoscaling không phản ứng tức thời. Tổng độ trễ có thể hình dung:

```text
reaction lag
= metric collection
+ aggregation/evaluation
+ provisioning/scheduling
+ boot/startup
+ warm-up/readiness
+ traffic redistribution
```

Nếu traffic spike nhanh hơn reaction lag, hệ thống vẫn cần minimum capacity, headroom, queue, cache, admission control hoặc load shedding.

#### 3. Scaling và healing là hai mục tiêu khác nhau

- **Autoscaling** thay đổi capacity theo demand.
- **Auto-healing** thay thế/restart instance không khỏe để giữ desired capacity.

CPU thấp vì nhiều instance đã crash không phải tín hiệu để scale in. Controller cần health/desired-state logic tách với workload scaling logic.

#### 4. Các chiều autoscaling

| Chiều | Hành động | Điểm cần lưu ý |
|---|---|---|
| **Horizontal** | Tăng/giảm replica, VM, container, worker | Cần phân phối traffic/work và quản lý state |
| **Vertical** | Tăng/giảm CPU, RAM, IOPS của workload/node | Có thể restart/reschedule, phản ứng chậm hơn |
| **Cluster/node** | Thêm/bớt compute node cho scheduler | Workload replica chỉ chạy khi cluster có chỗ |
| **Concurrency/serverless** | Tạo execution environment theo request/event | Cold start, quota, downstream connection |
| **Storage/data tier** | Replica, throughput unit, partition hoặc instance class | Stateful, rebalance và consistency nên scale chậm/cẩn thận |

Trong container platform, workload autoscaler có thể tăng pod nhưng pod vẫn `Pending` nếu node pool hết capacity. Vì vậy workload scaling và infrastructure scaling phải phối hợp.

---

#### Nhánh A — Chọn scaling signal

#### 5. Infrastructure metrics

- CPU utilization;
- memory working set/pressure;
- disk IOPS, throughput và queue;
- network bandwidth/packet/connection;
- GPU/accelerator utilization;
- node/pod resource request và saturation.

Ưu điểm là dễ thu thập, nhưng chúng không luôn đại diện demand hoặc user experience.

#### 6. Application và workload metrics

- request/transaction rate;
- concurrent request/connection;
- in-flight/outstanding work;
- queue depth và age of oldest message;
- consumer lag;
- latency và error rate;
- thread/connection pool utilization;
- cache miss/DB connection pressure;
- event ingestion/processing rate.

Các metric gần nguyên nhân gây work thường là scaling signal tốt hơn metric hậu quả. Ví dụ request rate hoặc queue backlog có thể dự báo capacity cần trước khi latency tăng.

#### 7. Business metrics

- orders/checkouts per minute;
- active tenants/users/sessions;
- video transcoding jobs;
- files/pages cần xử lý;
- device telemetry rate.

Business metric hữu ích khi tương quan ổn định với resource consumption. Nếu mỗi order có cost rất khác nhau, đếm order đơn thuần có thể gây scale sai.

#### 8. CPU khi nào tốt, khi nào kém?

CPU target phù hợp với CPU-bound stateless workload và mỗi replica có resource/cost tương đối đồng nhất.

CPU có thể gây hiểu sai khi:

- workload I/O-bound, chờ database/network nên CPU thấp dù latency cao;
- request queue nằm trước service nên instance chưa thấy work;
- GC/lock contention làm performance kém không tỷ lệ thuận CPU;
- mỗi tenant/request có cost rất khác nhau;
- downstream bị throttle, service chỉ chờ;
- resource request/limit cấu hình sai làm utilization denominator sai.

#### 9. Memory không phải signal scale-down đơn giản

Application cache và runtime thường giữ memory dù traffic giảm. Scale theo memory có thể chỉ tăng replica mà tổng memory/cache duplication còn lớn hơn. Cần hiểu working set, leak, cache behavior và giới hạn memory; memory leak cần sửa hoặc restart policy, không phải scale-out vô hạn.

#### 10. Queue-based autoscaling

Queue giúp tách arrival rate khỏi processing rate. Một ước lượng worker đơn giản:

```text
workers cần thiết
≈ arrival rate × average processing time / target utilization
```

Ví dụ:

```text
Arrival rate             = 600 jobs/s
Average processing time  = 0,2 s/job
Target utilization       = 0,75

Workers ≈ 600 × 0,2 / 0,75 = 160
```

Chỉ dùng queue depth có thể không đủ:

- 1.000 job × 10 ms khác 1.000 job × 10 phút;
- backlog 0 không có nghĩa đủ capacity nếu arrival tăng rất nhanh;
- poison message có thể giữ queue age cao;
- retry/requeue làm sai signal.

Nên kết hợp arrival rate, processing time, backlog per worker, queue age và completion/error rate.

#### 11. Latency và error rate là guardrail hơn là signal duy nhất

Latency/error trực tiếp phản ánh user impact nhưng thường xuất hiện sau khi saturation đã xảy ra. Nếu scale chỉ khi p99 vi phạm, phản ứng có thể quá muộn. Chúng phù hợp làm:

- SLO guardrail;
- trigger khẩn cấp kết hợp demand metric;
- tín hiệu xác minh policy có hiệu quả;
- điều kiện rollback hoặc load shedding.

Error tăng vì code bug/dependency outage mà autoscaler thêm replica có thể chỉ khuếch đại traffic và chi phí.

#### 12. Đặc tính của scaling signal tốt

- có quan hệ nhân quả tương đối ổn định với capacity cần;
- xuất hiện đủ sớm trước SLO violation;
- có thể chuẩn hóa theo replica/capacity;
- không quá nhiễu và không dễ bị thao túng;
- có metric pipeline đáng tin cậy;
- đo được cả tăng và giảm demand;
- không khiến nhiều autoscaler phản ứng ngược nhau.

---

#### Nhánh B — Scaling policies

#### 13. Threshold/reactive scaling

Ví dụ:

```text
Nếu average CPU > 70% trong 5 phút → thêm 2 replica
Nếu average CPU < 30% trong 15 phút → bớt 1 replica
```

Đơn giản, dễ hiểu nhưng threshold cứng có thể oscillate quanh biên. Dùng window, hysteresis, cooldown và scale-up/scale-down behavior khác nhau.

#### 14. Target tracking

Controller điều chỉnh replica để giữ metric gần target, ví dụ average CPU 60% hoặc 100 outstanding request/replica.

Mô hình trực giác:

```text
desired replicas
≈ current replicas × current metric / target metric
```

Ví dụ 10 replica đang ở 90% CPU, target 60%:

```text
desired ≈ 10 × 90 / 60 = 15 replica
```

Thực tế controller còn làm tròn, giới hạn tốc độ, stabilization và xét missing/unready replica.

#### 15. Step scaling

Mức scale phụ thuộc độ lệch:

```text
CPU 70–80%  → +2 replica
CPU 80–90%  → +5 replica
CPU > 90%   → +10 replica
```

Cho phản ứng mạnh hơn với spike lớn, nhưng nhiều threshold khó tune và dễ tạo overshoot nếu signal trễ.

#### 16. Scheduled scaling

Thêm capacity theo lịch đã biết:

- giờ làm việc;
- batch window;
- chiến dịch marketing;
- mở bán vé/flash sale;
- seasonal event.

Scheduled scaling nên bổ sung reactive policy vì demand thực tế có thể lệch dự báo.

#### 17. Predictive scaling

Dùng historical pattern/forecast để provision trước demand. Phù hợp workload tuần/ngày có tính lặp lại.

Rủi ro:

- product launch hoặc sự kiện bất thường phá pattern;
- concept drift làm model lỗi thời;
- forecast quá thấp vi phạm SLO, quá cao lãng phí;
- metric/data pipeline lỗi;
- không phản ứng tốt với incident hoặc viral spike chưa từng có.

Predictive policy cần confidence/guardrail, fallback reactive scaling và thường xuyên đánh giá forecast error.

#### 18. Event-driven scaling

Scale theo external work source như queue/topic/event stream. Worker count có thể liên hệ với backlog, lag và target processing time. Nó phù hợp background job, consumer và event-driven system hơn CPU-only scaling.

#### 19. Minimum, maximum và desired capacity

- **Minimum capacity** bảo đảm baseline, availability và giảm cold-start risk.
- **Maximum capacity** giới hạn blast radius/cost và bảo vệ downstream quota.
- **Desired capacity** là capacity controller đang cố duy trì.

Maximum không chỉ là cost guardrail. Nếu database chỉ chịu 200 connection, scale app lên 1.000 replica có thể làm outage nặng hơn. Limit phải dựa trên end-to-end capacity.

#### 20. Scale-up và scale-down nên bất đối xứng

Thông thường:

- scale up nhanh để bảo vệ SLO;
- scale down chậm để tránh oscillation và giữ headroom.

```text
Scale up:   window ngắn, bước lớn hơn
Scale down: window dài, stabilization, bước nhỏ hơn
```

Scale down phải drain connection/job và cân nhắc cache locality, rebalance, minimum replica qua zone.

#### 21. Cooldown, warm-up và stabilization

- **Cooldown:** khoảng tạm không thực hiện thêm một số action sau scale.
- **Warm-up:** thời gian instance mới chưa được xem là cung cấp full capacity.
- **Stabilization window:** xem lịch sử recommendation để tránh thay đổi quá nhanh.

Cooldown quá dài làm phản ứng chậm; quá ngắn gây thrashing. Warm-up phải phản ánh startup thật của application, không dùng con số mặc định thiếu kiểm chứng.

#### 22. Rate limit cho scaling action

Giới hạn:

- số replica hoặc phần trăm thay đổi mỗi window;
- tốc độ scale in/out;
- số concurrent provisioning operation;
- maximum surge khi rollout;
- minimum lifetime trước termination.

Mục tiêu là tránh overshoot, API quota exhaustion và simultaneous churn.

---

#### Nhánh C — Kiến trúc để autoscale an toàn

#### 23. Stateless application tier

Instance dễ scale-out/in nhất khi không giữ state bắt buộc cho request tiếp theo. Session/business state cần externalize hoặc replicate phù hợp.

Local cache vẫn có thể dùng, nhưng instance mới có cold cache và scale-in làm mất cache locality. Cache-warming traffic có thể tăng tải origin/database đúng lúc spike.

#### 24. Phối hợp với load balancer

Scale-out lifecycle:

```text
Provision → Start → Warm → Ready → Register → Slow-start traffic
```

Scale-in lifecycle:

```text
Select → Mark unready/draining → Stop new traffic
       → Finish/timeout in-flight work → Deregister → Terminate
```

Không route traffic khi process mới chỉ “đã chạy” nhưng chưa ready. Không terminate instance còn giữ WebSocket, upload hoặc job chưa checkpoint.

#### 25. Downstream capacity và connection storm

Thêm 100 replica có thể tạo:

- hàng nghìn database connection mới;
- cache miss/warm-up storm;
- authentication/config/secrets lookup burst;
- message partition contention;
- third-party API quota violation.

Cần connection pool budget, startup jitter, warm-up rate limit, shared cache, dependency quota và maximum scaling step.

Autoscaling app tier phải bị giới hạn bởi capacity của bottleneck downstream hoặc kết hợp backpressure/load shedding.

#### 26. Backpressure và admission control

Autoscaling là capacity response chậm; backpressure là overload response nhanh hơn.

Khi capacity chưa kịp tăng:

- queue work có giới hạn;
- rate limit/quota;
- reject sớm request ưu tiên thấp;
- shed optional feature;
- degrade response/cache stale data;
- giảm fan-out;
- trả retry hint có jitter.

Queue không vô hạn: backlog lớn chỉ chuyển outage thành latency dài và recovery kéo dài.

#### 27. Idempotency và worker termination

Scale-in hoặc spot interruption có thể dừng worker giữa job. Worker cần:

- acknowledgement đúng thời điểm;
- idempotent processing/deduplication;
- checkpoint hoặc lease/visibility timeout;
- graceful shutdown và termination notice;
- retry/DLQ policy;
- giới hạn thời gian job so với termination grace period.

#### 28. Stateful workloads

Stateful system scale chậm hơn vì cần replicate/rebalance data. Trước khi autoscale:

- xác định partition/replica placement;
- tính migration bandwidth và thời gian;
- ngăn nhiều rebalance chồng nhau;
- bảo vệ quorum/availability;
- scale storage và network cùng compute;
- hiểu scale-in có thể nguy hiểm hơn scale-out.

Database thường cần planned/scheduled/predictive capacity, read replica hoặc managed throughput policy hơn là phản ứng nhanh như stateless web tier.

#### 29. Multiple autoscalers và control-loop interaction

Ví dụ một hệ thống có:

- horizontal workload autoscaler;
- vertical resource recommender/autoscaler;
- node/cluster autoscaler;
- database autoscaling;
- queue consumer scaler.

Nếu HPA tăng pod vì CPU cao trong khi vertical autoscaler đồng thời tăng CPU request, denominator/signal đổi; cluster autoscaler lại thêm node. Các vòng điều khiển có thể tranh chấp hoặc oscillate.

Cần owner, priority, boundary và test cho tương tác giữa controller; tránh để nhiều policy cùng điều khiển một resource từ signal mâu thuẫn.

#### 30. Multi-zone và availability

Autoscaler cần duy trì:

- minimum replica qua nhiều failure domain;
- capacity sau mất một zone/node pool;
- topology spread/anti-affinity;
- quota đủ ở từng zone;
- không scale-in hết một zone vì traffic tạm lệch;
- load balancer health/routing phù hợp.

Autoscaling theo average toàn region có thể che giấu một zone/pool đã bão hòa.

#### 31. Deployments và autoscaling

Rolling/canary deployment làm capacity và metric thay đổi:

- old/new version có efficiency khác nhau;
- rollout surge dùng thêm resource;
- cold instance làm latency tăng;
- lỗi version mới có thể kích autoscaler thêm replica sai hướng.

Capacity plan phải tính deployment surge; policy cần version-aware telemetry và guardrail để rollback code/config thay vì chỉ scale lỗi.

---

#### Nhánh D — Failure modes và observability

#### 32. Oscillation/thrashing

```text
Load tăng → scale out quá mạnh → utilization giảm
→ scale in nhanh → utilization tăng → scale out lại
```

Nguyên nhân: threshold sát nhau, window ngắn, reaction lag, warm-up không tính, noisy metric. Giải pháp: hysteresis, stabilization, asymmetric policy, smoothing và bounded scaling rate.

#### 33. Scaling too late

Nguyên nhân:

- metric là lagging indicator;
- evaluation window/cooldown quá dài;
- provisioning/warm-up chậm;
- quota/capacity cloud không đủ;
- image/dependency lớn;
- readiness sai.

Giải pháp: demand-leading signal, scheduled/predictive pre-scale, minimum headroom, tối ưu startup và overload protection.

#### 34. Scaling too early hoặc sai nguyên nhân

- CPU spike ngắn gây overprovision;
- error do dependency outage kích thêm replica;
- memory leak kích scale-out vô hạn;
- retry storm làm request rate tăng giả;
- metric không normalize theo capacity;
- business event không tạo work tương ứng.

Cần multi-signal guardrail, max capacity, anomaly/runaway alert và root-cause telemetry.

#### 35. Metric pipeline failure

Nếu metric mất, trễ hoặc sai, autoscaler có thể giữ nguyên, scale theo stale data hoặc đi về default. Cần định nghĩa:

- fail-safe behavior;
- missing-data treatment;
- alert khi controller không có fresh metric;
- minimum capacity;
- manual override/runbook;
- audit log cho recommendation/action.

#### 36. Cloud quota và capacity shortage

Autoscaling policy đúng vẫn thất bại nếu:

- đạt account/project/region quota;
- instance type hết capacity;
- subnet hết IP;
- image registry/secrets/service discovery lỗi;
- scheduler không tìm được node phù hợp;
- load balancer target/rule limit đạt trần.

Theo dõi quota, dùng nhiều instance type/pool khi phù hợp, reservation cho critical baseline và diễn tập scale-out failure.

#### 37. Cold start và scale-to-zero

Scale-to-zero tiết kiệm khi idle nhưng request đầu phải chờ:

- provision runtime;
- tải code/image/dependency;
- initialize framework/model;
- mở connection và warm cache.

Phù hợp asynchronous, dev/test hoặc workload chấp nhận startup latency. Với latency-sensitive API, giữ minimum warm capacity hoặc dùng pre-warming/scheduled scale.

#### 38. Observability cho autoscaling

Dashboard/alert nên nối ba lớp:

**Demand**

- arrival/request/event rate;
- concurrency, queue depth/age;
- traffic theo tenant/route/region.

**Decision/action**

- current/desired/min/max capacity;
- recommendation, scale event và reason;
- provisioning/warm-up/readiness time;
- failed/limited action, quota và cooldown.

**Outcome**

- utilization/saturation;
- latency/error/SLO;
- throughput/completion rate;
- cost và unit cost;
- downstream pressure.

Chỉ quan sát replica count không đủ để biết autoscaling đúng hay chỉ đang che một bottleneck.

---

#### Nhánh E — Cost optimization và cloud practices

#### 39. Right-sizing trước khi autoscaling

Replica quá lớn gây lãng phí và scale granularity thô; replica quá nhỏ tăng overhead, connection và scheduling churn. Benchmark nhiều size để tìm vùng hiệu quả theo throughput/SLO/cost.

Resource request/limit sai cũng ảnh hưởng scheduling và utilization signal. Right-sizing cần được xem lại khi code, workload hoặc dependency đổi.

#### 40. Base capacity và burst capacity

Một mô hình thực dụng:

```text
Predictable baseline → stable/committed capacity
Variable burst       → on-demand autoscaled capacity
Interruptible work   → spot/preemptible capacity
```

Không dùng interruptible capacity cho toàn bộ critical serving tier nếu không có diversity, fallback và graceful interruption handling.

#### 41. Spot/preemptible capacity

Phù hợp:

- batch/ETL;
- retryable background jobs;
- stateless replica có on-demand baseline;
- distributed compute có checkpoint.

Cần:

- đa dạng instance type/zone;
- interruption signal và graceful shutdown;
- idempotency/checkpoint;
- fallback capacity;
- không giả định discount luôn có sẵn.

Tên thương mại khác nhau theo provider, nhưng bản chất là capacity giá thấp đổi lấy khả năng bị thu hồi.

#### 42. Guardrail chống runaway cost

- maximum replicas/capacity;
- quota theo environment/team/tenant;
- budget và cost anomaly alert;
- rate limit cho scaling action;
- policy-as-code và approval cho limit lớn;
- tag/label/owner đầy đủ;
- kill switch/manual override;
- dev/staging schedule hoặc auto-pause;
- monitor cost per request/job/tenant.

Maximum quá thấp gây outage; maximum quá cao có thể phá downstream và ngân sách. Guardrail phải gắn với capacity test.

#### 43. Scale-to-zero và auto-pause

Hiệu quả cho workload idle dài, nhưng cần đánh giá:

- startup latency/SLO;
- concurrent burst đầu tiên;
- state/connection initialization;
- minimum billing unit;
- metric/event có thể đánh thức workload không;
- dependency vẫn phát sinh fixed cost không.

Scale-to-zero không phải lúc nào rẻ hơn nếu cold start khiến retry, timeout hoặc overprovision downstream.

#### 44. Unit economics

Theo dõi:

```text
cost / request
cost / successful order
cost / active user
cost / processed event or GB
```

Tổng hóa đơn tăng cùng business có thể bình thường; dấu hiệu xấu là unit cost tăng do scaling efficiency giảm, overprovision, data transfer hoặc bottleneck.

#### 45. Cloud-neutral principles

AWS, Azure, Google Cloud và các nền tảng container/serverless cung cấp autoscaling với tên dịch vụ khác nhau. Kiến thức bền vững là:

- workload-to-signal mapping;
- feedback-loop stability;
- provisioning/warm-up lag;
- stateless/stateful boundary;
- downstream protection;
- quota/failure behavior;
- cost and SLO guardrails.

Monitoring service tích hợp hoặc Prometheus/Grafana có thể cung cấp signal/visibility, nhưng dashboard không tự biến metric thành policy đúng.

#### 46. Best-practice checklist

1. Định nghĩa workload, peak/burst và SLO.
2. Load test để đo safe capacity mỗi replica.
3. Chọn leading signal gần work, dùng latency/error làm guardrail.
4. Đặt min/max/desired capacity theo availability, quota và downstream.
5. Scale up nhanh hơn scale down; thêm hysteresis/stabilization.
6. Đo startup, warm-up và time-to-ready thực tế.
7. Phối hợp readiness, slow start và connection draining với load balancer.
8. Bảo vệ database/cache/external API bằng pool, quota và backpressure.
9. Thiết kế idempotency/checkpoint cho worker và interruption.
10. Tính zone failure, deployment surge và cloud quota.
11. Quan sát demand → decision → outcome → cost.
12. Test spike, metric loss, quota exhaustion, dependency outage và scale-in.
13. Có manual override, rollback và incident runbook.
14. Rà soát right-sizing và unit economics định kỳ.

#### 47. Câu hỏi phỏng vấn và trả lời ngắn

**Q1. Autoscaling là gì?**  
Feedback loop tự điều chỉnh capacity theo workload/policy để giữ SLO, availability và cost mục tiêu.

**Q2. Reactive, scheduled và predictive khác gì?**  
Reactive đáp lại metric hiện tại; scheduled provision theo lịch; predictive forecast demand. Production thường kết hợp và luôn cần fallback/guardrail.

**Q3. CPU có phải metric tốt nhất?**  
Không. Nó tốt cho CPU-bound workload; queue, concurrency hoặc request rate có thể phù hợp hơn với I/O/event workload.

**Q4. Cooldown để làm gì?**  
Cho action trước có thời gian tác động và tránh thay đổi liên tục; phải tune cùng warm-up và stabilization.

**Q5. Vì sao scale up nhanh, scale down chậm?**  
Thiếu capacity phá SLO ngay; capacity dư tạm thời chủ yếu tốn cost. Scale-down chậm giữ headroom và tránh oscillation.

**Q6. Autoscaling có thay capacity planning không?**  
Không. Vẫn phải biết peak, safe capacity, reaction lag, quota, failure headroom và downstream limit.

**Q7. Làm sao autoscale queue consumer?**  
Dùng arrival rate, average processing time, backlog/age và target drain time; không chỉ CPU hoặc queue length thô.

**Q8. Scale-to-zero khi nào phù hợp?**  
Khi idle dài và workload chấp nhận cold start hoặc asynchronous. Latency-sensitive serving thường cần minimum warm capacity.

**Q9. Spot instance dùng thế nào an toàn?**  
Dùng cho interruptible/idempotent/checkpointable work, có diversified pool, baseline/fallback và graceful termination.

**Q10. Autoscaler có thể làm outage nặng hơn thế nào?**  
Scale theo error/retry storm, mở quá nhiều DB connection, oscillate, terminate job sớm hoặc thêm replica khi shared dependency đã quá tải.

**Q11. Metric nào cho biết policy hoạt động tốt?**  
SLO giữ ổn định, backlog/lag được kiểm soát, time-to-scale đủ nhanh, ít oscillation, downstream an toàn và unit cost hợp lý.

**Q12. Autoscaling và load balancing liên hệ thế nào?**  
Autoscaler tạo/loại capacity; load balancer chỉ đưa traffic tới instance ready và drain instance bị loại. Lifecycle phải được phối hợp.

#### 48. Nội dung phỏng vấn bổ sung từ PDF

**Q13. Autoscaling được ánh xạ thế nào trên các cloud?**  
PDF đưa các ví dụ sau để minh họa cùng một control-loop concept:

| Lớp workload | AWS examples | Azure examples | Google Cloud examples |
|---|---|---|---|
| VM fleet | Auto Scaling Groups | Virtual Machine Scale Sets | Managed Instance Groups |
| Container/Kubernetes | ECS/EKS scaling | AKS scaling | GKE/HPA |
| Serverless/container service | Lambda | Functions/App Service ecosystem | Cloud Functions/Cloud Run |
| Metrics | CloudWatch | Azure Monitor | Cloud Monitoring |

Tên và capability dịch vụ thay đổi theo thời gian. Khi phỏng vấn, nên giải thích signal → policy → capacity → readiness thay vì chỉ liệt kê sản phẩm.

**Q14. Thiết kế autoscaling cho containerized application thế nào?**

1. Đặt resource request/limit từ load test.
2. Chọn HPA/custom/external metric gần workload.
3. Cấu hình min/max, scale-up/down behavior và stabilization.
4. Bảo đảm cluster/node autoscaler có quota và instance type phù hợp.
5. Dùng readiness/startup probe, LB registration và graceful termination.
6. Phân bố replica qua zone/node, giữ availability khi scale-in.
7. Theo dõi pending pod, time-to-ready, desired/current replica và SLO.
8. Bảo vệ database/queue bằng connection/concurrency budget.

HPA tăng pod không tạo node capacity ngay; node autoscaler và scheduler là các vòng điều khiển riêng.

**Q15. Metrics nào cần theo dõi để autoscale hiệu quả?**  
Phân thành bốn nhóm:

- **Demand:** request rate, concurrency, queue arrival/depth/age, consumer lag.
- **Capacity:** CPU, memory, connection, ready replica và node headroom.
- **Outcome:** latency, error, throughput/completion rate và SLO.
- **Economics:** current/desired capacity, spend và cost per unit.

Không scale trực tiếp theo business metric nếu mối quan hệ với work không ổn định.

**Q16. Thách thức của autoscaling cho real-time system?**  
Connection dài và state/presence làm scale-in khó; cold start và provisioning lag làm scale-out muộn; reconnect storm có thể tạo demand giả; moving connection giữa node thường không trong suốt. Cần minimum warm capacity, connection registry/routing, graceful drain, reconnect jitter và capacity theo concurrent connection/fan-out chứ không chỉ CPU.

**Q17. Predictive autoscaling có cần machine learning không?**  
Không bắt buộc. Forecast có thể dùng mô hình thống kê/scheduled pattern đơn giản. Giá trị nằm ở việc provision trước reaction lag và đo forecast error; “có ML” không bảo đảm dự báo chính xác.

**Q18. Reserved/committed và spot/preemptible capacity khác vai trò gì?**  
Committed capacity phù hợp baseline dự đoán được và đổi flexibility lấy chiết khấu; spot/preemptible phù hợp phần interruptible, có thể bị thu hồi. Autoscaling quyết định lượng capacity; purchasing model quyết định economics/availability của capacity đó.

**Q19. Autoscaling có bảo đảm high availability không?**  
Không. Nó có thể thay instance lỗi hoặc thêm capacity, nhưng HA còn cần multi-zone placement, load balancing, healthy dependencies, state replication, quota và đủ headroom trong thời gian scale.

#### 49. Những lỗi tư duy thường gặp

- Nghĩ autoscaling tạo capacity ngay lập tức.
- Chỉ dùng average CPU cho mọi workload.
- Scale khi latency/error đã vi phạm mà không có leading signal.
- Không tính startup/warm-up và readiness.
- Scale app vượt capacity database hoặc external quota.
- Scale out để “sửa” memory leak hay dependency outage.
- Cho queue tăng vô hạn trong lúc chờ capacity.
- Scale in không drain/checkpoint.
- Dùng spot cho toàn bộ critical baseline.
- Đặt max replica theo ngân sách nhưng không theo SLO/downstream.
- Nhiều autoscaler cùng điều khiển resource mà không phối hợp.
- Không kiểm thử metric mất, quota hết hoặc cloud capacity shortage.
- Chỉ nhìn tổng cost, không theo dõi unit economics.

#### 50. Ý chính cần nhớ

- Autoscaling là feedback loop, không chỉ là threshold rule.
- Mọi action có metric, provisioning, startup và warm-up lag.
- Chọn signal gần nguồn work; latency/error thường là guardrail trễ.
- Horizontal, vertical, cluster và serverless scaling có lifecycle khác nhau.
- Reactive, scheduled, predictive và event-driven policy có thể phối hợp.
- Scale-up và scale-down nên bất đối xứng để bảo vệ SLO và tránh thrashing.
- Min/max capacity phải tính availability, quota, cost và downstream limits.
- Stateless tier dễ autoscale; stateful tier cần rebalance/consistency cẩn thận.
- Load balancer, readiness, slow start và draining phải đi cùng autoscaler.
- Backpressure/load shedding bảo vệ hệ thống trong thời gian capacity chưa kịp tới.
- Right-sizing, spot capacity, scale-to-zero và unit economics tối ưu chi phí theo workload.
- Observability phải nối demand, decision, action, outcome và cost.

#### Công thức ghi nhớ

> **Autoscaling tốt không phải thêm máy thật nhanh, mà là dùng đúng signal để tạo đúng capacity trước khi SLO vỡ, đưa capacity vào phục vụ an toàn, rồi thu hồi chậm và có kiểm soát — trong giới hạn downstream, quota và chi phí.**

---

### Bài 38. Tổng kết — Scalability in System Design

#### 1. Scalability là tập hợp quyết định kiến trúc

Scalability không phải một công nghệ hoặc một nút “bật tự động”. Đó là khả năng hệ thống hấp thụ sự tăng trưởng của traffic, concurrency và dữ liệu trong khi vẫn giữ:

- latency, throughput và error rate trong SLO;
- availability và reliability mong muốn;
- chi phí trên mỗi đơn vị sử dụng hợp lý;
- độ phức tạp mà đội ngũ có thể vận hành.

```text
Demand tăng
   │
   ▼
Quan sát bottleneck và SLO
   │
   ├── Tối ưu lượng work
   ├── Scale up / scale out
   ├── Phân phối traffic
   ├── Tự động điều chỉnh capacity
   └── Bảo vệ khi overload
          │
          ▼
Performance + Reliability + Cost vẫn chấp nhận được
```

#### 2. Ba chiến lược scaling

| Chiến lược | Ý tưởng | Điểm mạnh | Giới hạn |
|---|---|---|---|
| **Vertical** | Làm một node mạnh hơn | Nhanh, ít thay đổi kiến trúc | Trần phần cứng, cost curve, blast radius |
| **Horizontal** | Thêm nhiều node chia tải | Capacity ceiling và resilience cao hơn | State, consistency và distributed complexity |
| **Diagonal** | Kết hợp scale up rồi scale out | Lộ trình tiến hóa thực dụng | Kế thừa failure mode của cả hai hướng |

Không có chiến lược đúng cho mọi component. API tier có thể scale ngang, primary database scale dọc, cache scale theo shard và worker scale theo queue backlog.

#### 3. Load balancing biến capacity thành khả năng phục vụ

Thêm instance chỉ có giá trị khi traffic/work được phân phối tới đúng healthy capacity. Load balancer cung cấp:

- stable entry point;
- Layer 4 hoặc Layer 7 routing;
- thuật toán phân phối theo request, connection, load hoặc key;
- health check, failover, slow start và draining;
- traffic splitting cho deployment;
- integration với TLS, security và observability.

Load balancer không tạo capacity và không chữa bottleneck downstream. Nếu database bão hòa hoặc toàn pool quá tải, hệ thống cần backpressure, admission control, load shedding và graceful degradation.

#### 4. Autoscaling đóng vòng điều khiển capacity

Autoscaler nối demand với scaling action:

```text
Metrics → Policy → Provision → Warm → Ready → Serve → Re-evaluate
```

Một policy tốt cần:

- signal gần nguyên nhân tạo work;
- min/max capacity và failure headroom;
- scale-up đủ nhanh, scale-down có stabilization;
- tính provisioning/warm-up lag;
- phối hợp readiness/draining với load balancer;
- giới hạn theo database, quota và external dependency;
- observability cho recommendation, action, outcome và cost.

Autoscaling không thay capacity planning. Nó chỉ tự động thực hiện trong những boundary đã được thiết kế.

#### 5. Chuỗi phụ thuộc của scalability

```text
Traffic
  ▼
Load Balancer
  ▼
Application Replicas
  ▼
Cache / Queue / Database / External API
```

Capacity hữu dụng end-to-end bị giới hạn bởi mắt xích bão hòa đầu tiên. Khi tăng application replica:

- database connection có thể cạn;
- cache miss/warm-up có thể tạo spike;
- queue partition giới hạn parallelism;
- third-party quota có thể bị vượt;
- network và serialization trở thành bottleneck mới.

Sau mỗi lần scale hoặc tối ưu, bottleneck có thể dịch chuyển. Vì vậy cần đo lại thay vì tiếp tục thêm cùng một loại resource.

#### 6. Bốn lớp của một thiết kế scalable

**Capacity**

- đo safe capacity và peak demand;
- giữ headroom cho spike, deployment và failure;
- scale đúng bottleneck.

**Distribution**

- load balancing, partitioning và queueing;
- giảm hotspot, skew và local-state coupling;
- scale từng workload độc lập.

**Protection**

- timeout, retry budget và circuit breaker;
- rate limit, backpressure và load shedding;
- graceful degradation khi thiếu capacity.

**Control & Operations**

- metrics, SLO và capacity forecast;
- autoscaling policy ổn định;
- tested deployment, failover và rollback;
- unit economics và cloud quota.

#### 7. Những trade-off xuyên suốt

| Muốn cải thiện | Chi phí hoặc rủi ro thường phát sinh |
|---|---|
| Thêm replica | Network, coordination và downstream load |
| Giảm latency bằng cache | Consistency, invalidation và warm-up |
| Sticky session | Traffic skew và failover kém linh hoạt |
| Predictive scaling | Forecast error và overprovision |
| Scale-to-zero | Cold-start latency |
| Multi-region | Data consistency, routing và transfer cost |
| Nhiều health check sâu | Probe load và cascading ejection |
| Capacity headroom lớn | Chi phí tài nguyên nhàn rỗi |

Vai trò của architect không phải tối đa hóa một thuộc tính, mà chọn điểm cân bằng phù hợp với business stage, SLO, threat/failure model và năng lực vận hành.

#### 8. Checklist ôn tập Phần 6

- Định nghĩa scalability bằng workload, capacity, SLO và cost cụ thể.
- Phân biệt performance, scalability và elasticity.
- Tìm bottleneck bằng saturation/queue/tail-latency thay vì phỏng đoán.
- Giải thích vertical, horizontal và diagonal scaling cùng trade-off.
- Nhận biết stateless workload dễ scale-out hơn stateful workload vì sao.
- Phân biệt Layer 4 với Layer 7 load balancing.
- Chọn thuật toán balancing theo đơn vị tải thực.
- Thiết kế health check, slow start, draining và failure headroom.
- Chọn autoscaling signal theo workload, không mặc định CPU.
- Giải thích reactive, scheduled, predictive và event-driven scaling.
- Tính provisioning/warm-up lag, cooldown và stabilization.
- Bảo vệ downstream bằng connection budget, quota và backpressure.
- Thiết kế overload behavior trước khi traffic vượt capacity.
- Theo dõi cost trên request/order/user, không chỉ tổng hóa đơn.
- Load test và failure test toàn request path.

#### 9. Câu hỏi tự kiểm tra

1. Vì sao thêm gấp đôi instance không bảo đảm throughput tăng gấp đôi?
2. Khi nào scale up hợp lý hơn scale out?
3. Session state cục bộ ảnh hưởng load balancing và scale-in thế nào?
4. HTTP/2/gRPC làm thuật toán least-connections khó diễn giải ra sao?
5. Health check quá sâu có thể khuếch đại outage như thế nào?
6. Vì sao CPU thấp vẫn có thể đi cùng latency cao?
7. Queue consumer nên scale theo những signal nào?
8. Autoscaler cần làm gì nếu metric pipeline mất dữ liệu?
9. Mất một availability zone thì phần capacity còn lại có giữ được peak SLO không?
10. Unit cost thay đổi thế nào khi hệ thống scale và bottleneck dịch chuyển?

#### 10. Chuyển sang Database & Storage

Compute tier thường là phần dễ scale nhất. Dữ liệu khó hơn vì phải duy trì durability, consistency, queryability và ownership khi volume/throughput tăng.

Phần tiếp theo sẽ đi sâu vào:

- cách tổ chức và lựa chọn data store;
- relational và non-relational model;
- indexing, partitioning và sharding;
- replication và consistency;
- transaction và distributed data;
- storage capacity, availability và failure recovery.

Các nguyên tắc scalability vẫn tiếp tục áp dụng, nhưng data tier bổ sung một ràng buộc quan trọng: không chỉ xử lý thêm work, hệ thống còn phải bảo toàn và diễn giải đúng state lâu dài.

#### Ý chính cần nhớ

- Scalability là tập hợp quyết định về capacity, distribution, protection và operations.
- Vertical, horizontal và diagonal scaling là công cụ, không phải mục tiêu.
- Load balancer đưa traffic tới healthy capacity nhưng không loại bỏ downstream bottleneck.
- Autoscaling là feedback loop có độ trễ và boundary, không thay capacity planning.
- State, database và shared dependency thường quyết định trần scale thật sự.
- Scale-up phải đi cùng scale-down, failure handling và overload behavior.
- Mọi tối ưu đều làm bottleneck dịch chuyển; cần quan sát và kiểm thử lại.
- Thiết kế tốt cân bằng SLO, reliability, complexity và unit economics.

#### Công thức ghi nhớ

> **Scalability bền vững = capacity phù hợp + phân phối đúng + bảo vệ khi overload + vòng điều khiển ổn định + dữ liệu/downstream không trở thành nút thắt mới.**

---

## Phần 7 — Storage & Databases

### Bài 39. Introduction to Storage in System Design & CAP Theorem

#### 1. Vì sao storage là quyết định kiến trúc nền tảng?

Khi dữ liệu phải tồn tại lâu hơn một request, process hoặc server restart, storage trở thành một phần của system contract. User và business kỳ vọng:

- dữ liệu đã xác nhận không bị mất;
- dữ liệu được truy xuất trong latency chấp nhận được;
- hệ thống tiếp tục phục vụ khi disk/node/zone lỗi;
- quyền truy cập và lịch sử thay đổi được kiểm soát;
- dữ liệu tăng trưởng mà chi phí không mất kiểm soát;
- schema, format và query có thể tiến hóa.

```text
Users create data
      │
      ▼
Application validates and transforms
      │
      ▼
Storage persists, indexes, replicates, protects and serves
      │
      ├── Online reads/writes
      ├── Search/analytics
      ├── Events/audit
      └── Backup/archive/recovery
```

Một application nhanh nhưng storage chậm sẽ bị giới hạn bởi I/O/query. Một storage nhanh nhưng không durable có thể biến lỗi nhỏ thành mất dữ liệu vĩnh viễn. Vì vậy storage ảnh hưởng đồng thời tới performance, reliability, availability, scalability, security và cost.

#### 2. Bắt đầu từ data và access pattern, không bắt đầu từ tên sản phẩm

Trước khi chọn database/storage, cần trả lời:

- Dữ liệu có hình dạng và quan hệ thế nào?
- Read/write ratio và peak throughput là bao nhiêu?
- Point lookup, range scan, join, full-text hay aggregate?
- Record/object size và tổng volume tăng ra sao?
- Update in place, append-only hay immutable?
- Cần transaction/constraint ở boundary nào?
- Consistency nào cần cho từng operation?
- Latency p99 và availability target là gì?
- Retention, audit, backup và delete requirement thế nào?
- Một region hay nhiều region; data residency ra sao?
- Cost theo GB, IOPS, request và data transfer là bao nhiêu?

Hai workload có cùng “structured data” vẫn có thể cần storage khác nhau nếu access pattern khác nhau.

---

#### Nhánh A — Data models và các loại storage

#### 3. Structured, semi-structured và unstructured data

| Nhóm | Đặc điểm | Ví dụ |
|---|---|---|
| **Structured** | Schema/type/constraint rõ, các record có shape kiểm soát | Account, order, inventory, ledger |
| **Semi-structured** | Có key/tag/schema linh hoạt hoặc thay đổi giữa record | JSON document, event, log record |
| **Unstructured** | Nội dung không thuận tiện biểu diễn thành field để query trực tiếp | Image, video, audio, PDF |

Phân loại này không tuyệt đối:

- ảnh là unstructured content nhưng metadata ảnh là structured/semi-structured;
- social post có text tự do nhưng author, timestamp, visibility là field rõ ràng;
- log text thô có thể được parse thành structured event;
- JSON có thể được kiểm tra bằng schema.

“Unstructured” không có nghĩa không có cấu trúc byte hoặc không thể index; nó chỉ nói data model/query không phù hợp với bảng field truyền thống ở cấp nội dung.

#### 4. Database

Database cung cấp data model, query, index, concurrency và durability/transaction semantics. Các nhóm thường gặp:

- relational/SQL;
- key-value;
- document;
- wide-column;
- graph;
- time-series;
- search/index engine;
- analytical/columnar warehouse.

Database không chỉ dành cho structured data. Document database lưu semi-structured JSON/BSON; relational database cũng có JSON/blob type; metadata của unstructured asset thường nằm trong database.

Database có thể được xây trên block, file hoặc object storage. Vì vậy “database” và “block/file/object” không phải bốn tầng loại trừ hoàn toàn; một bên là data service/interface, bên kia mô tả storage abstraction phía dưới.

#### 5. Object storage

Object storage lưu object theo key/ID trong namespace/bucket, thường qua HTTP/API:

```text
key       → products/42/image-v7.jpg
metadata  → content-type, size, checksum, tags
data      → object bytes
```

**Phù hợp**

- image, video, document và static asset;
- backup, archive, data lake và raw logs;
- immutable/versioned artifact;
- khối lượng object rất lớn và durability cao.

**Đánh đổi**

- không cung cấp POSIX file semantics đầy đủ;
- thường thao tác theo whole object/range hơn là random block update;
- rename/folder có thể chỉ là key-prefix convention;
- latency và request cost khác local/block disk;
- query nội dung cần metadata/index/catalog riêng.

Không nên lưu binary lớn trực tiếp trong transactional database chỉ để “mọi thứ ở một chỗ” nếu access, backup và cost không phù hợp. Pattern phổ biến là database giữ metadata/ownership/status, object storage giữ bytes.

#### 6. File storage

File storage cung cấp hierarchy thư mục/file và filesystem semantics, thường qua NFS/SMB hoặc distributed filesystem.

**Phù hợp**

- shared directories;
- legacy/application cần filesystem API;
- home directory, content collaboration;
- workload cần file locking/path semantics;
- một số ML/HPC/shared-data workflow.

**Đánh đổi**

- metadata/path/lock có thể là bottleneck;
- scale namespace và concurrent access phức tạp;
- semantics caching/locking qua network cần hiểu rõ;
- không mặc nhiên durable/HA chỉ vì được mount bởi nhiều máy.

#### 7. Block storage

Block storage trình bày volume như dãy block raw cho host. Filesystem hoặc database phía trên quyết định layout, page, log và index.

**Phù hợp**

- VM boot/data disk;
- database volume;
- low-latency random I/O;
- application cần kiểm soát filesystem/storage engine.

**Đánh đổi**

- attach/mount và multi-writer semantics bị giới hạn theo hệ thống;
- volume thường gắn với zone/failure domain cụ thể;
- user tự quản filesystem, corruption, snapshot/backup và resize;
- block device không tự cung cấp query/schema/transaction.

#### 8. So sánh object, file và block

| Thuộc tính | Object | File | Block |
|---|---|---|---|
| Interface | Object API/key | File/path + filesystem call | Raw block/device |
| Đơn vị thao tác | Object/range | File/byte range | Block |
| Namespace | Flat/key prefix | Hierarchical directory | Do filesystem/DB quản lý |
| Shared access | Qua API | Tự nhiên cho shared filesystem | Phụ thuộc attach/cluster FS |
| Scale điển hình | Rất lớn về object/capacity | Tùy metadata/filesystem design | Theo volume/array/service |
| Update pattern | Whole-object/immutable thuận lợi | File mutation | Random read/write |
| Use case | Media, backup, lake | Shared directory, legacy | DB, VM, I/O-intensive app |

“Object luôn scalable”, “block luôn nhanh” chỉ là xu hướng. Kết quả phụ thuộc service class, network, access pattern, concurrency và durability settings.

#### 9. Storage stack có nhiều lớp

```text
Application data model
        ▼
Database / filesystem / object API
        ▼
Storage engine / cache / log / index
        ▼
Block, file or object substrate
        ▼
Disk/SSD/network/replication
```

Đánh giá đúng layer rất quan trọng. Database latency có thể đến từ query plan hoặc lock chứ không phải disk; object upload chậm có thể do network/concurrency; filesystem issue có thể nằm ở metadata server.

---

#### Nhánh B — Thuộc tính và guarantee của storage

#### 10. Persistence và durability

- **Persistence**: state tồn tại ngoài lifetime của process/session.
- **Durability**: sau khi operation được báo thành công, dữ liệu tồn tại qua failure trong failure model đã cam kết.

Durability không phải cảm giác “đã ghi xuống disk”. Cần biết:

- acknowledgement xảy ra sau memory, local disk hay quorum replication?
- power loss, disk/node/zone/region loss có nằm trong guarantee?
- checksum/scrubbing phát hiện corruption thế nào?
- backup/PITR có phục hồi lỗi logic/ransomware không?
- retention/versioning/delete policy ra sao?

Replication tăng khả năng sống qua hardware failure nhưng có thể sao chép ngay dữ liệu bị xóa/corrupt. Backup độc lập mới hỗ trợ phục hồi về trạng thái trước đó.

#### 11. Availability

Operational availability thường được đo bằng tỷ lệ/thời gian request hợp lệ được phục vụ theo SLO. Nó phụ thuộc:

- redundancy và failover;
- health/routing;
- quorum và leader election;
- dependency/network;
- capacity sau failure;
- maintenance/deployment;
- recovery process.

Storage trả response lỗi nhanh vẫn là “response” ở nghĩa HTTP, nhưng không nhất thiết đáp ứng availability SLO. Trong CAP, availability có định nghĩa lý thuyết cụ thể hơn sẽ được tách ở phần sau.

#### 12. Consistency

Consistency không chỉ có mạnh hoặc eventual. Các guarantee thường gặp:

- linearizable/strong read;
- serializable transaction;
- snapshot isolation;
- read-your-writes;
- monotonic reads;
- causal consistency;
- bounded staleness;
- eventual consistency.

Cần phát biểu theo operation và scope:

> “Sau khi cập nhật profile thành công, chính user đọc lại ở region đó phải thấy giá trị mới trong 1 giây” rõ hơn “database consistent”.

#### 13. Atomicity

Atomicity là all-or-nothing trong một transaction boundary: hoặc mọi thay đổi commit, hoặc không thay đổi nào được nhìn thấy như đã commit.

Ví dụ chuyển tiền cần debit và credit cùng transaction/invariant. Nhưng trong distributed workflow, “rollback” không luôn hoàn nguyên vật lý mọi side effect. Có thể cần saga, compensation, idempotency hoặc reconciliation.

Atomicity khác consistency:

- atomicity nói một nhóm operation commit cùng nhau;
- consistency có thể nói database constraint, read visibility hoặc distributed replica guarantee tùy context.

#### 14. Reliability, durability và availability khác nhau

| Khái niệm | Câu hỏi |
|---|---|
| **Durability** | Dữ liệu đã xác nhận có sống qua failure không? |
| **Availability** | Hệ thống có phục vụ operation trong SLO không? |
| **Reliability** | Hệ thống có thực hiện đúng và ổn định trong khoảng thời gian không? |
| **Recoverability** | Sau sự cố/lỗi logic, phục hồi state/service nhanh và đúng tới đâu? |

Một hệ thống có thể durable nhưng tạm unavailable; available nhưng trả stale data; replicated nhưng không recover được accidental deletion.

#### 15. Latency, throughput và IOPS

- **Latency**: thời gian hoàn tất một operation, cần nhìn percentile.
- **Throughput**: bytes hoặc operation hoàn tất trên đơn vị thời gian.
- **IOPS**: số I/O operation mỗi giây, ý nghĩa phụ thuộc block size/read-write mix.

Sequential throughput cao không bảo đảm random I/O latency thấp. Benchmark phải phản ánh:

- read/write ratio;
- request/block/object size;
- sequential/random;
- concurrency/queue depth;
- cache hit/miss;
- sync/durability level;
- compaction/checkpoint/backup chạy nền;
- dataset lớn hơn memory hay không.

#### 16. Scalability và elasticity của storage

Storage scale theo nhiều dimension:

- capacity bytes/object/row;
- read throughput;
- write throughput;
- query complexity/index;
- partition/shard count;
- connection/concurrency;
- geographic replicas.

Thêm capacity không mặc nhiên tăng throughput; thêm read replica không tăng write capacity; shard nhiều hơn có thể tăng fan-out/rebalance. Stateful scaling cần data movement, consistency và recovery planning.

#### 17. Security, privacy và governance

Storage design phải bao phủ:

- encryption in transit/at rest và key management;
- authentication, authorization và least privilege;
- tenant/data isolation;
- audit log và tamper resistance;
- data classification/PII;
- retention, legal hold và deletion;
- residency/sovereignty;
- backup access và secret exposure;
- masking/tokenization cho analytics/non-production.

Encrypted storage vẫn có thể bị đọc bởi principal có quyền sai; encryption không thay authorization và audit.

#### 18. Replication, backup và snapshot

| Cơ chế | Mục tiêu chính | Không tự giải quyết |
|---|---|---|
| **Replication** | Availability, read scale, hardware failure | Lỗi logic/xóa dữ liệu bị replicate |
| **Snapshot** | Point-in-time copy nhanh theo storage semantics | Independence/long-term retention nếu cùng failure domain |
| **Backup** | Recovery độc lập, giữ nhiều restore point | Immediate failover/zero downtime |
| **PITR** | Restore tới thời điểm qua base backup + log | Recovery tức thì hoặc không mất dữ liệu nếu log thiếu |

Backup chỉ có giá trị khi restore được kiểm thử. Cần encrypt, immutable/isolated copy, retention và access control.

#### 19. RPO và RTO

- **RPO (Recovery Point Objective):** có thể chấp nhận mất tối đa bao nhiêu dữ liệu theo thời gian.
- **RTO (Recovery Time Objective):** dịch vụ phải phục hồi trong bao lâu.

```text
failure at 12:00
latest recoverable state 11:55 → RPO = 5 phút
service restored 12:30         → RTO = 30 phút
```

RPO/RTO là business requirement để thiết kế replication, backup frequency, failover và recovery automation; không phải con số tự sinh từ công nghệ.

---

#### Nhánh C — Storage trade-offs và lựa chọn

#### 20. Scalability, reliability, performance và cost

Các mục tiêu thường kéo theo trade-off:

- sync replication tăng failure tolerance nhưng tăng write latency;
- nhiều replica tăng availability/read scale nhưng tăng cost và lag/conflict concern;
- nhiều index tăng read/query performance nhưng làm write/storage/maintenance đắt hơn;
- cache giảm latency nhưng tạo staleness/invalidation;
- compression giảm bytes nhưng tốn CPU;
- multi-region giảm user latency/tăng disaster resilience nhưng làm consistency và data transfer phức tạp;
- high durability/availability tier thường có giá cao hơn archive tier.

Câu hỏi đúng là “requirement nào cần guarantee nào với cost nào?”, không phải “storage tốt nhất là gì?”.

#### 21. Access-pattern checklist

| Dimension | Câu hỏi thiết kế |
|---|---|
| Read | Point/range/scan/search/aggregate? |
| Write | Insert/update/append; sync hay async? |
| Ratio | Read-heavy, write-heavy hay balanced? |
| Size | Record/object và working set bao nhiêu? |
| Locality | Key/time/geography có locality không? |
| Transaction | Invariant và atomic boundary ở đâu? |
| Consistency | Operation nào cần latest; stale bao lâu? |
| Retention | TTL, archive, legal hold, delete? |
| Scale | Peak RPS, bytes/day, growth và skew? |
| Recovery | Failure model, RPO, RTO? |
| Cost | Storage, request, I/O, egress và operations? |

#### 22. Hot, warm và cold storage

- **Hot:** dữ liệu truy cập thường xuyên, latency thấp, giá cao hơn.
- **Warm:** ít truy cập hơn, latency/throughput trung gian.
- **Cold/archive:** truy cập hiếm, retrieval chậm/fee/constraint cao hơn nhưng lưu rẻ.

Lifecycle policy có thể chuyển log/media/backup theo tuổi. Cần tính retrieval time/cost, minimum retention, delete và compliance; không chuyển dữ liệu xuống cold tier nếu incident/audit cần đọc nhanh.

#### 23. Polyglot persistence

Một hệ thống có thể dùng:

```text
Orders/payments     → relational transactional DB
Sessions/hot keys   → distributed cache/key-value
Images/videos       → object storage + CDN
Search              → search index
Events              → durable log/broker
Analytics           → object lake + columnar engine
```

Lợi ích là fit theo workload; chi phí là nhiều contract, pipeline, consistency, security, backup, skill và operational surface. Không dùng nhiều storage chỉ vì công nghệ hấp dẫn; mỗi store cần owner và source-of-truth rõ.

#### 24. Source of truth và derived data

Phân biệt:

- **system of record/source of truth:** state có thẩm quyền;
- **derived projection/index/cache:** có thể tái tạo từ nguồn hoặc event;
- **archive/backup:** phục vụ recovery/compliance;
- **analytical copy:** tối ưu scan/aggregation, có freshness lag.

Nếu search index và database khác nhau, phải xác định cái nào thắng khi conflict và cách rebuild/reconcile.

#### 25. Tránh chọn storage chỉ theo data shape

“Structured → SQL, unstructured → object, scale lớn → NoSQL” là heuristic quá thô. Cần thêm:

- transaction/invariant;
- query và index;
- consistency;
- latency/throughput;
- data lifecycle;
- scale pattern;
- team/managed-service capability;
- migration/exit strategy.

SQL system có thể scale lớn; NoSQL có thể hỗ trợ strong consistency/transaction trong scope; object storage có metadata/query integration. Product category không thay requirement analysis.

---

#### Nhánh D — CAP Theorem

#### 26. Phát biểu CAP chính xác hơn

Trong một distributed read/write data system, **khi network partition xảy ra**, không thể đồng thời bảo đảm cả:

- **C — Consistency:** theo ngữ cảnh CAP thường là single-copy/linearizable behavior; mọi operation trông như tác động lên một bản sao duy nhất theo thứ tự hợp lệ.
- **A — Availability:** mọi request tới non-failing node cuối cùng nhận non-error response, không phụ thuộc việc response có phải dữ liệu mới nhất.
- **P — Partition tolerance:** hệ thống tiếp tục có behavior được định nghĩa dù message giữa các nhóm node bị mất hoặc trì hoãn vô hạn.

Cách nói “chọn hai trong ba” dễ sai. Khi không partition, hệ thống có thể cung cấp cả C và A. Khi partition chia các replica có thể nhận request, thiết kế phải hy sinh availability của một số operation/nodes hoặc cho phép behavior không còn linearizable.

#### 27. Network partition là gì?

```text
          network link broken/delayed
Replica A  X────────────────X  Replica B
    │                             │
 Client A                      Client B
```

Hai phía không biết chắc peer đã chết hay network chỉ chậm. Nếu cả hai nhận write độc lập, chúng có thể diverge. Nếu chỉ một phía được phép write để giữ consistency, phía kia phải reject/wait — giảm CAP availability.

Partition không chỉ là cáp đứt: packet loss, firewall/config, route issue, overload, long pause hoặc region isolation có thể tạo hiệu ứng tương tự trong time window của hệ thống.

#### 28. CP behavior

Khi partition, CP-oriented operation ưu tiên single-copy consistency:

- chỉ quorum/leader side tiếp tục;
- minority/isolate side reject hoặc chờ;
- một số request timeout/unavailable;
- tránh conflicting committed write.

Phù hợp khi sai state gây hậu quả lớn, ví dụ unique allocation, leader metadata hoặc một số transaction/inventory invariant. Nhưng “CP database” vẫn có thể có stale read option hoặc operation khác với guarantee khác.

#### 29. AP behavior

Khi partition, AP-oriented operation ưu tiên nhận và trả lời request ở nhiều phía:

- write có thể được nhận ở các partition;
- read có thể stale;
- replica diverge tạm thời;
- cần merge/conflict resolution/reconciliation sau khi heal.

Phù hợp khi offline/continued operation quan trọng và conflict có semantics xử lý được, như một số feed, preference, cart hoặc telemetry workload. “Eventual consistency” không nói conflict được giải quyết đúng nghiệp vụ; application phải định nghĩa merge/invariant.

#### 30. CA có phải loại database thứ ba không?

CA thường không phải lựa chọn hữu ích cho một distributed system phải chịu partition. Single-node database không có inter-node partition nên CAP trade-off giữa replicas không được kích hoạt; gọi nó “CA database” dễ khiến hiểu nhầm.

Một cluster trong mạng “tốt” vẫn phải quyết định behavior nếu communication bị chia cắt. Vì vậy đừng phân loại sản phẩm bằng ba nhãn cố định mà hãy hỏi operation/topology/configuration ứng xử thế nào khi partition.

#### 31. CAP availability khác availability SLO

CAP availability là thuộc tính mô hình rất mạnh cho mọi request tới non-failing node. Operational availability thường đo theo tỷ lệ, time window và operation class, ví dụ 99,99% successful reads mỗi tháng.

Một CP system có thể đạt availability SLO cực cao vì partition hiếm và failover nhanh. Một AP system có thể vẫn outage do bug, overload hoặc mất quorum metadata. CAP label không dự báo toàn bộ uptime thực tế.

#### 32. Trade-off không phải lựa chọn vĩnh viễn cho toàn hệ thống

Quyết định có thể khác theo:

- read so với write;
- key/partition;
- endpoint/business operation;
- consistency level client yêu cầu;
- local region so với cross-region;
- normal mode so với degraded mode.

Ví dụ catalog read có thể cho stale data, nhưng inventory reservation cần reject khi không xác nhận được authoritative stock.

#### 33. PACELC mở rộng góc nhìn

CAP tập trung lúc partition. PACELC nhắc rằng:

```text
If Partition: trade off Availability vs Consistency
Else:         trade off Latency vs Consistency
```

Ngay khi network khỏe, synchronous coordination qua nhiều replica/region để lấy strong consistency vẫn có thể tăng latency. Đây là trade-off thường xuyên hơn partition và cần đo theo user geography/SLO.

PACELC là mnemonic/model bổ sung, không thay thế việc đọc guarantee cụ thể của storage.

#### 34. Cách trả lời câu hỏi CAP trong phỏng vấn

1. Định nghĩa C, A, P trong đúng ngữ cảnh CAP.
2. Nói trade-off bị ép khi partition, không phải mọi lúc.
3. Chọn một operation/business invariant cụ thể.
4. Mô tả behavior của từng phía partition.
5. Nêu failure/timeout/conflict/recovery semantics.
6. Phân biệt CAP availability với uptime/SLA.
7. Tránh gắn database cố định vào CP/AP nếu chưa nói configuration/operation.

#### 35. CAP không bao phủ mọi storage concern

CAP không trực tiếp giải quyết:

- durability và data loss;
- transaction isolation/atomicity;
- backup/recovery;
- latency/throughput/cost;
- security/compliance;
- disk corruption/software bug;
- schema/query/index;
- exactly-once business effect.

Một storage design tốt không thể kết thúc sau câu “chọn CP hay AP”.

---

#### Nhánh E — Real-world storage composition

#### 36. E-commerce

```text
Users / Products / Orders / Payments → transactional database(s)
Product images / invoices           → object storage + CDN
Cart/session hot state               → key-value/cache with persistence policy
Product search                       → derived search index
Events/audit                         → durable log + archive
Analytics                            → object lake/warehouse
```

Inventory và payment cần invariant/consistency mạnh hơn product description/feed. Search/index/cache là derived views và cần freshness/rebuild strategy.

#### 37. Photo-sharing application

**Photo bytes**

- direct/multipart upload tới object storage;
- unique immutable object key/version;
- checksum, content-type, size và malware processing;
- lifecycle/replication/CDN;
- authorization qua service hoặc signed URL.

**Metadata**

- owner, visibility, caption, object key, state;
- likes/comments/relationship/query theo access pattern;
- transactional DB, document/wide-column hoặc kết hợp;
- database record không nên công bố asset trước khi upload/processing hoàn tất;
- orphan object/metadata cần reconciliation.

#### 38. Streaming platform

- media segment/master → object storage;
- global delivery → CDN/cache;
- user/profile/subscription → transactional database;
- playback position/history → high-write data store;
- recommendation feature/event → event log + analytical storage;
- entitlement/DRM metadata → strongly controlled data path.

Media bytes và user/payment metadata có durability, latency, query và security requirement khác nhau.

#### 39. Logs, metrics và analytics

```text
Agents → Buffer/Broker → Hot search/time-series store
                  └───→ Raw object storage/data lake
                              └── batch/columnar analytics
```

Cần cân nhắc:

- append/ingestion throughput;
- partition theo time/tenant;
- high-cardinality field;
- retention và downsampling;
- compression/columnar format;
- late/out-of-order data;
- hot search window và cold archive;
- PII redaction/access control;
- replay/backfill.

Object storage cho raw logs, time-series/search/columnar engine cho query nhanh là pattern thường gặp, không phải rule duy nhất.

---

#### 40. 13 câu hỏi phỏng vấn từ tài liệu phụ

**Q1. Vì sao storage quan trọng trong system design?**  
Nó giữ state qua request/failure và quyết định performance, durability, availability, scalability, security, recovery và cost.

**Q2. Structured và unstructured data khác gì?**  
Structured có schema/field rõ; unstructured là content khó query trực tiếp theo field. Thực tế còn semi-structured và một asset thường có unstructured bytes cùng structured metadata.

**Q3. Các loại storage chính và use case?**  
Database cho query/transaction theo data model; object cho media/backup/lake; file cho hierarchy/shared filesystem; block cho raw random I/O của DB/VM. Các lớp có thể chồng lên nhau.

**Q4. Durability, availability và consistency là gì?**  
Durability giữ acknowledged data qua failure model; availability phục vụ operation trong guarantee/SLO; consistency xác định visibility/order của state giữa operation/replica.

**Q5. Atomicity là gì?**  
All-or-nothing trong transaction boundary. Distributed business workflow có thể cần saga/compensation thay vì rollback toàn cục.

**Q6. Hệ thống có thể vừa highly available vừa strongly consistent không?**  
Có trong normal operation và có thể đạt uptime cao. Nhưng khi partition chia các replica nhận request, CAP không cho bảo đảm đồng thời linearizability và availability theo định nghĩa CAP ở mọi phía.

**Q7. CAP theorem là gì?**  
Trong partitioned distributed data system, phải hy sinh CAP availability của một số operation hoặc single-copy consistency; partition tolerance là failure condition phải xử lý.

**Q8. CP và AP khác gì?**  
CP reject/wait ở phía không thể xác nhận authoritative state; AP tiếp tục đáp ứng nhưng có thể diverge/stale và cần conflict resolution. Hành vi phụ thuộc operation/configuration.

**Q9. Vì sao CA hiếm/không thực dụng?**  
Vì distributed replicas có thể partition. Single-node không phải ví dụ “CA distributed system”; theorem không bị kích hoạt giữa node nếu chỉ có một node.

**Q10. Chọn consistency hay availability thế nào?**  
Theo invariant và hậu quả: sai/duplicate/oversell nguy hiểm hơn reject hay không; conflict có merge được không; stale tối đa bao lâu; degraded mode và reconciliation thế nào.

**Q11. Photo và metadata lưu thế nào?**  
Photo bytes ở object storage/CDN; metadata/quyền/quan hệ ở database theo query/transaction requirement, liên kết qua stable object key và lifecycle state.

**Q12. Storage cho logs/metrics analytics?**  
Buffer/broker để ingest, object storage cho raw/retention, time-series/search/columnar store cho query; partition, tiering và retention theo workload.

**Q13. Object khác file và block ra sao?**  
Object dùng key/API và object semantics; file dùng hierarchy/filesystem; block cung cấp raw blocks cho filesystem/DB. Chọn theo interface, mutation, sharing, latency và scale.

#### 41. Những lỗi tư duy thường gặp

- Nói mọi data chỉ structured hoặc unstructured, bỏ qua semi-structured.
- Nghĩ database chỉ lưu structured data.
- Xem database, object, file và block như bốn loại loại trừ nhau.
- Cho rằng object storage là filesystem có folder thật.
- Lưu large blob trong database mà không xét backup/query/cost.
- Đồng nhất replication với backup.
- Chưa test restore nhưng tin backup sẽ dùng được.
- Nói consistency luôn có nghĩa “đọc latest” mà không nêu model/scope.
- Đồng nhất atomicity với distributed rollback mọi side effect.
- Học CAP thành “chọn hai trong ba” ở mọi thời điểm.
- Coi P là một feature tùy chọn có thể bỏ trong distributed deployment.
- Gắn cả database cố định vào CP hoặc AP không xét operation/configuration.
- Gọi single-node database là CA distributed system.
- Nghĩ AP đồng nghĩa dữ liệu sai mà không cần merge/reconciliation design.
- Nghĩ CP đồng nghĩa uptime production thấp.
- Chọn store theo trend thay vì access pattern và invariant.

#### 42. Storage design checklist

1. Data model và source of truth là gì?
2. Access pattern/read-write ratio/peak throughput?
3. Record/object/working-set và growth rate?
4. Transaction/invariant boundary?
5. Consistency guarantee cho từng operation?
6. Latency percentile và availability SLO?
7. Failure model: disk, node, zone, region, partition, corruption?
8. Durability acknowledgement/quorum thế nào?
9. Replication, backup, PITR, RPO và RTO?
10. Partition/shard key, hot key và rebalance path?
11. Index/query và write amplification?
12. Retention, archive, delete, residency và compliance?
13. Encryption, access control, audit và tenant isolation?
14. Capacity/cost theo storage, I/O, request và transfer?
15. Migration, schema evolution và vendor exit/rebuild?
16. Monitoring: latency, error, saturation, lag, storage growth, restore test?

#### 43. Ý chính cần nhớ

- Storage bắt đầu từ data, access pattern, invariant và lifecycle.
- Structured, semi-structured và unstructured thường cùng tồn tại.
- Database là data service; object/file/block là storage abstractions có thể làm nền cho nhau.
- Durability, availability, consistency, atomicity và recoverability là guarantee khác nhau.
- Replication không thay backup; backup phải được restore-test.
- RPO/RTO biến yêu cầu business thành recovery architecture.
- Storage performance phải đo đúng mix, size, concurrency và durability level.
- Polyglot persistence hữu ích khi mỗi store có vai trò/source-of-truth rõ.
- CAP trade-off C/A chỉ bị ép trong network partition.
- CAP consistency gần với linearizability; CAP availability khác uptime percentage.
- CP/AP là behavior theo operation/topology/configuration, không chỉ nhãn database.
- PACELC nhắc tới latency-consistency trade-off ngay cả khi không partition.
- Chọn storage là chọn trade-off phù hợp, không phải tìm công nghệ tốt nhất tuyệt đối.

#### Công thức ghi nhớ

> **Thiết kế storage tốt = hiểu data và access pattern + chọn interface/guarantee đúng + chuẩn bị failure/recovery + chấp nhận rõ trade-off về consistency, availability, latency và cost.**

---

### Bài 40. Understanding Database Models — SQL vs. NoSQL

#### 1. Database model trả lời câu hỏi gì?

Database không chỉ là nơi “cất dữ liệu”. Nó cung cấp một **data model** và một tập guarantee để application:

- biểu diễn entity và quan hệ;
- kiểm tra constraint/invariant;
- đọc, ghi và truy vấn dữ liệu;
- xử lý concurrent updates;
- duy trì durability, replication và recovery;
- mở rộng theo traffic, data volume và topology.

Vì vậy, chọn database không nên bắt đầu bằng câu hỏi “SQL hay NoSQL tốt hơn?”, mà bằng:

1. Dữ liệu có hình dạng và quan hệ như thế nào?
2. Invariant nào tuyệt đối không được vi phạm?
3. Access pattern chính là gì?
4. Transaction cần bao phủ bao nhiêu record/partition/service?
5. Consistency, latency, availability, scale và cost cần tới mức nào?

> **SQL và NoSQL không phải hai mức chất lượng, cũng không phải hai phía loại trừ nhau. Chúng là các nhóm mô hình với thế mạnh và trade-off khác nhau.**

Lưu ý thêm: **SQL** vốn là ngôn ngữ truy vấn, còn **relational** là mô hình dữ liệu. Trong thực tế, “SQL database” thường được dùng như cách gọi ngắn cho relational database có hỗ trợ SQL.

---

#### 2. Relational/SQL database

Relational database biểu diễn dữ liệu bằng các **relation**, thường được trình bày dưới dạng bảng:

- **row**: một record;
- **column**: một thuộc tính có type/domain;
- **primary key**: định danh duy nhất cho row;
- **foreign key**: tham chiếu tới row ở bảng khác;
- **constraint**: quy tắc như `NOT NULL`, `UNIQUE`, `CHECK`, referential integrity.

Ví dụ rút gọn:

```text
customers(customer_id, name, email)
orders(order_id, customer_id, status, total)
order_items(order_id, product_id, quantity, unit_price)
```

`orders.customer_id` tham chiếu `customers.customer_id`; mỗi đơn hàng có nhiều dòng trong `order_items`. Database có thể bảo vệ một phần tính hợp lệ ngay tại data layer thay vì hoàn toàn phụ thuộc application.

##### 2.1 Schema-first và migration

Relational database thường theo hướng **schema-on-write**: cấu trúc, type và constraint được định nghĩa trước hoặc được kiểm tra khi ghi.

Ưu điểm:

- dữ liệu nhất quán về shape và type;
- lỗi bị chặn gần nguồn;
- dễ dùng constraint, join, reporting và công cụ BI;
- contract dữ liệu rõ ràng cho nhiều consumer.

Chi phí:

- thay đổi schema cần migration và compatibility plan;
- migration lớn có thể lock, rewrite data hoặc gây tải;
- deploy application và schema phải phối hợp an toàn.

Schema “cố định” không có nghĩa không thể đổi. Hệ thống production thường dùng migration có version, thay đổi tương thích ngược, backfill theo batch, quan sát rollout rồi mới xóa field/index cũ.

##### 2.2 Join, normalization và denormalization

**Join** kết hợp dữ liệu liên quan giữa các relation. **Normalization** chia dữ liệu theo entity/dependency để giảm trùng lặp và update anomaly.

Ví dụ: thông tin khách hàng nằm ở `customers`, không copy toàn bộ vào từng `orders`. Khi email đổi, chỉ một nguồn chính cần cập nhật.

Tuy nhiên, normalization không phải mục tiêu tuyệt đối. **Denormalization** có chủ đích có thể:

- giảm join trên hot read path;
- tạo read model/materialized view;
- giữ snapshot lịch sử, ví dụ địa chỉ giao hàng tại thời điểm đặt đơn;
- tối ưu báo cáo hoặc phân phối dữ liệu.

Đổi lại, dữ liệu lặp cần cơ chế cập nhật, versioning hoặc reconciliation rõ ràng.

##### 2.3 ACID chính xác là gì?

Một transaction thường được mô tả bởi **ACID**:

| Thuộc tính | Ý nghĩa thực tế |
|---|---|
| **Atomicity** | Các thay đổi trong transaction cùng commit hoặc cùng rollback trong transaction boundary. |
| **Consistency** | Transaction hợp lệ đưa database từ một state thỏa các constraint/invariant đã khai báo sang state hợp lệ khác. Database không tự biết mọi quy tắc nghiệp vụ nếu ta không biểu diễn/kiểm tra chúng. |
| **Isolation** | Quy định mức độ transaction đồng thời quan sát và ảnh hưởng lẫn nhau. Guarantee cụ thể phụ thuộc isolation level. |
| **Durability** | Sau khi database xác nhận commit, dữ liệu tồn tại qua các failure nằm trong durability contract đã cam kết. |

Hai điểm rất dễ nhầm:

- **Consistency trong ACID** nói về tính hợp lệ của state/invariant; **consistency trong CAP** gần với linearizability/single-copy behavior. Chúng không phải cùng một khái niệm.
- “Có ACID” không đồng nghĩa mọi transaction chạy ở mức `SERIALIZABLE`. `READ COMMITTED`, snapshot isolation và serializable có anomaly, concurrency và cost khác nhau.

ACID cũng không dừng ở SQL. Nhiều document, key-value hoặc distributed database hỗ trợ transaction với boundary và guarantee riêng.

##### 2.4 Thế mạnh điển hình

Relational database thường phù hợp khi:

- có nhiều quan hệ và truy vấn kết hợp linh hoạt;
- constraint và referential integrity quan trọng;
- cần multi-row/multi-table transaction;
- cần ad-hoc query, aggregation, reporting hoặc ecosystem SQL;
- data model tương đối rõ và cần governance mạnh.

Ví dụ: ledger, order/inventory, billing, ERP, booking và hệ thống quản lý nghiệp vụ.

##### 2.5 Giới hạn — nhưng không nên học thành định kiến

Các khó khăn thường gặp:

- join phân tán và cross-shard transaction đắt hơn local operation;
- scale write ngang đòi hỏi partition/sharding strategy tốt;
- schema migration trên bảng rất lớn cần thận trọng;
- một node hoặc một primary có thể trở thành bottleneck nếu topology không phù hợp;
- ORM/query/index kém vẫn làm một SQL system chậm dù model đúng.

Nhưng “SQL chỉ scale dọc” là sai. Relational database có thể dùng read replica, partitioning, sharding, caching và distributed SQL. Đổi lại, càng phân tán thì coordination, latency, rebalancing và vận hành càng phức tạp.

---

#### 3. NoSQL là một họ database, không phải một model duy nhất

**NoSQL** thường được hiểu là “Not Only SQL”: nhóm database không bị giới hạn ở relational tables và SQL interface truyền thống. Mỗi họ tối ưu cho một cách biểu diễn/truy cập khác nhau.

NoSQL không mặc định có tất cả các đặc tính sau:

- schema-less;
- eventual consistency;
- không transaction;
- scale ngang vô hạn;
- nhanh hơn SQL.

Guarantee thực tế phụ thuộc product, topology, operation và cấu hình.

##### 3.1 Document database

Lưu một aggregate dưới dạng document, thường gần với JSON/BSON:

```json
{
  "productId": "p-42",
  "name": "Running Shoes",
  "attributes": {
    "size": [39, 40, 41],
    "material": "mesh"
  },
  "tags": ["sport", "summer"]
}
```

Phù hợp khi:

- dữ liệu tự nhiên là aggregate lồng nhau;
- các document có optional/evolving fields;
- phần lớn operation đọc/ghi trọn aggregate theo ID hoặc index đã biết;
- muốn mapping gần với object của application.

Ví dụ: product catalog, content, user profile, configuration. MongoDB là ví dụ phổ biến.

Trade-off cần xét:

- embed quá nhiều làm document lớn và update contention;
- reference nhiều lại tạo join/application-side composition;
- unique/referential constraint xuyên document khó hơn;
- shard key và query/index vẫn phải thiết kế từ đầu.

##### 3.2 Key-value database

Mô hình logic tối giản:

```text
key -> value
```

Phù hợp khi access pattern chính là get/put/delete theo key:

- cache;
- session/state ngắn hạn;
- feature/config lookup;
- idempotency key;
- shopping cart hoặc metadata lookup tùy guarantee.

Redis và DynamoDB đều có thể được mô tả là key-value-oriented nhưng **không thể coi là thay thế trực tiếp**: persistence model, query capability, transaction, consistency, topology và failure behavior rất khác nhau.

##### 3.3 Wide-column database

Wide-column store như Cassandra hoặc HBase thường tổ chức dữ liệu quanh row/partition key và column family, hỗ trợ row thưa và phân phối lớn. Data model thường được thiết kế **từ query/access pattern**, với denormalization có chủ đích.

Phù hợp cho:

- write throughput lớn;
- time-ordered/event/IoT data;
- truy vấn đã biết theo partition key và clustering/order key;
- triển khai nhiều node/region khi consistency model phù hợp.

Cần tránh partition quá lớn, hot partition, scan ngoài access pattern và secondary index không phù hợp.

> **Wide-column không đồng nghĩa analytical columnar database.** Cassandra/HBase tổ chức dữ liệu phân tán theo row/partition và column family; các analytical column store/columnar format lại đặt giá trị cùng cột gần nhau để scan, compression và aggregation hiệu quả.

##### 3.4 Graph database

Biểu diễn dữ liệu bằng:

- **node/vertex**: thực thể;
- **edge/relationship**: quan hệ có hướng/loại/thuộc tính;
- **property**: metadata của node hoặc edge.

Phù hợp khi traversal nhiều bước là truy vấn trung tâm:

- mạng xã hội;
- fraud ring;
- knowledge graph;
- dependency/authorization graph;
- recommendation dựa trên quan hệ.

Graph database không tự động tốt hơn relational cho mọi dữ liệu có quan hệ. Cần đánh giá traversal depth, update rate, partitioning, query language, transaction và operational ecosystem. Neo4j là ví dụ phổ biến.

##### 3.5 “Schema-less” thực chất là gì?

Document hoặc key-value store có thể không ép mọi record cùng shape ở storage layer, nhưng dữ liệu vẫn có schema ngầm trong:

- application code;
- validation rule;
- API contract;
- serializer/deserializer;
- index và query;
- downstream analytics.

Vì vậy “schema-less” thường nghĩa là **schema linh hoạt hoặc được kiểm tra ở nơi khác**, không phải không có schema. Linh hoạt quá mức có thể tạo mixed types, field trùng nghĩa, version khó hiểu và migration bị dồn sang read path.

---

#### 4. BASE và eventual consistency

**BASE** là một mnemonic không chặt như ACID:

- **Basically Available**: thiết kế ưu tiên tiếp tục phục vụ trong phạm vi đã chọn;
- **Soft State**: state quan sát được có thể thay đổi do propagation/convergence dù không có input mới trực tiếp;
- **Eventually Consistent**: nếu không còn update mới và các điều kiện cần được đáp ứng, replica cuối cùng hội tụ.

Không nên hiểu BASE là “luôn trả lời, dữ liệu sai cũng được”. Một thiết kế eventual consistency cần trả lời:

- stale tối đa bao lâu?
- read-your-writes có cần không?
- update đồng thời có conflict thế nào?
- merge theo last-write-wins, version/vector clock, CRDT hay business rule?
- duplicate/reorder xử lý ra sao?
- reconciliation và observability nằm ở đâu?

ACID và BASE không loại trừ nhau. Một hệ thống có thể dùng ACID transaction trong một partition/document, rồi replicate hoặc cập nhật view khác theo eventual consistency.

---

#### 5. So sánh cân bằng SQL và NoSQL

| Khía cạnh | Relational/SQL | NoSQL |
|---|---|---|
| **Data model** | Relation, row, column, key và constraint | Document, key-value, wide-column, graph hoặc model chuyên biệt |
| **Schema** | Thường schema-on-write, migration rõ | Thường linh hoạt hơn; schema có thể do app/validator quản lý |
| **Quan hệ** | Join và referential integrity là năng lực cốt lõi | Thường embed, denormalize hoặc traversal tùy model |
| **Transaction** | Mature multi-row/table transaction | Có thể có transaction nhưng boundary/cost khác nhau theo product |
| **Query** | SQL chuẩn hóa tương đối, mạnh cho ad-hoc query | API/query language phụ thuộc store; thường tối ưu access pattern đã biết |
| **Scale** | Scale dọc và ngang đều có thể; distributed coordination có giá | Nhiều hệ được thiết kế scale ngang; shard key/hotspot/rebalance vẫn là bài toán khó |
| **Consistency** | Thường strong trong một primary/transaction boundary; replication có thể lag | Có thể strong, eventual hoặc tunable theo operation/configuration |
| **Modeling** | Thường entity/relationship và normalization trước | Thường query/access-pattern-first, embed/denormalize nhiều hơn |
| **Vận hành** | Ecosystem/migration/query tooling trưởng thành | Mỗi product có semantics và công cụ riêng, dễ tăng cognitive/operational load |
| **Dùng khi** | Invariant, relationship, transaction, reporting quan trọng | Shape/access pattern chuyên biệt hoặc scale/topology cần model phù hợp |

Đây là xu hướng, không phải định luật. PostgreSQL có `JSONB`; MongoDB có validation, index và transaction; distributed SQL có scale ngang; nhiều NoSQL store cung cấp strong consistency cho một số operation.

---

#### 6. CAP liên quan thế nào đến SQL/NoSQL?

Không nên gắn nhãn cứng:

```text
SQL = CP
NoSQL = AP
```

CAP chỉ ép trade-off khi có **network partition** trong một distributed deployment. Khi đó, với một operation cụ thể, hệ thống phải chọn giữa:

- giữ linearizable/single-copy behavior và từ chối/chờ ở phía không đủ điều kiện (**CP behavior**);
- tiếp tục đáp ứng ở nhiều phía nhưng chấp nhận state có thể stale/diverge (**AP behavior**).

Database có thể thay đổi behavior theo:

- read/write concern hoặc consistency level;
- quorum size;
- leader/follower routing;
- topology và replication mode;
- operation (read, write, metadata, transaction);
- failure đang xảy ra.

Vì vậy, các câu như “MongoDB là CP”, “Cassandra là AP”, “Neo4j là CP” chỉ có giá trị khi kèm deployment, configuration, operation và failure scenario. CAP cũng không nói mọi điều về latency, durability, isolation hay recovery; dùng thêm PACELC và workload-specific guarantees để đánh giá.

---

#### 7. Chọn database theo yêu cầu

##### 7.1 Checklist quyết định

1. **Entity và relationship:** dữ liệu là aggregate độc lập hay graph/quan hệ chéo dày đặc?
2. **Invariant:** điều gì tuyệt đối không được sai — số dư, tồn kho, uniqueness, quyền?
3. **Access pattern:** point lookup, range scan, traversal, search, aggregation hay full scan?
4. **Transaction boundary:** một row/document, nhiều record, nhiều shard hay nhiều service?
5. **Consistency:** strong ở đâu, stale bao lâu, session guarantee nào?
6. **Scale:** read/write throughput, data size, growth, hot key và geographic distribution?
7. **Schema evolution:** tốc độ thay đổi shape, compatibility và backfill?
8. **Availability/recovery:** SLO, RPO, RTO, multi-zone/region và degraded mode?
9. **Vận hành:** kỹ năng đội ngũ, managed service, backup/restore, monitoring và migration?
10. **Cost:** compute, storage, I/O, network, license và chi phí phức tạp?

##### 7.2 Ba tình huống thường gặp trong phỏng vấn

**Financial ledger**

- Thường chọn relational hoặc distributed transactional database.
- Cần atomic transaction, uniqueness, auditability và reconciliation.
- Nên dùng double-entry/append-only ledger; balance có thể là derived view.
- “Dùng SQL” chưa đủ: phải nêu isolation, idempotency, durability, backup và invariant.

**Product catalog**

- Document model hợp lý khi thuộc tính thay đổi mạnh theo category và thường đọc cả product aggregate.
- Relational + `JSONB` cũng có thể phù hợp nếu vẫn cần constraint, join, reporting và ecosystem PostgreSQL.
- Search index thường là derived store; catalog database vẫn là source of truth.

**Real-time chat**

- Message bền vững có thể partition theo conversation/channel và sequence/time trong relational, document hoặc wide-column store.
- Presence, typing indicator và ephemeral session state hợp với in-memory/key-value store.
- Broker/stream hỗ trợ fan-out và xử lý bất đồng bộ.
- Không nên trả lời “Redis cho toàn bộ chat” nếu chưa làm rõ durability, history, ordering, retention và recovery.

##### 7.3 MongoDB hay PostgreSQL?

Ưu tiên MongoDB khi aggregate document là boundary tự nhiên, shape biến đổi nhiều, query đã biết phù hợp index/shard key và đội ngũ chấp nhận semantics/vận hành của document store.

Ưu tiên PostgreSQL khi có relationship, constraint, transaction chéo entity, ad-hoc query/reporting hoặc hệ sinh thái SQL là trọng tâm.

Không chọn MongoDB chỉ vì input là JSON: PostgreSQL có `JSONB`. Cũng không loại MongoDB chỉ vì cần transaction: nó có transaction, nhưng cần đánh giá boundary, latency và scale cost. Quyết định cuối cùng nên dựa trên workload test, failure behavior và khả năng vận hành.

---

#### 8. Polyglot persistence

Một hệ thống có thể dùng nhiều store, mỗi store cho một nhiệm vụ:

```text
Order service       -> relational DB (transaction/source of truth)
Product catalog     -> document DB
Session/cache       -> key-value store
Search              -> search index
Analytics/raw logs  -> object storage + columnar analytics engine
Recommendation      -> graph/feature store tùy bài toán
```

Lợi ích:

- dùng data model phù hợp access pattern;
- scale từng workload độc lập;
- tránh ép một database xử lý mọi loại truy vấn.

Chi phí:

- nhiều công nghệ, kỹ năng, backup và monitoring hơn;
- consistency giữa store trở thành bài toán application/distributed systems;
- dual write có thể tạo partial failure;
- migration, data ownership và incident response phức tạp hơn.

Mỗi dataset phải có **một source of truth rõ ràng**. Các cache, index và projection nên được coi là derived data có thể rebuild. Đồng bộ thường dùng outbox/CDC/event, kèm idempotency, retry, lag monitoring và reconciliation — không dựa vào hai lệnh ghi độc lập rồi hy vọng cùng thành công.

---

#### 9. 10 câu hỏi phỏng vấn từ tài liệu phụ

**Q1. Khác biệt chính giữa SQL và NoSQL là gì?**  
SQL/relational tập trung vào relation, schema, constraint, join và transaction; NoSQL là họ document, key-value, wide-column, graph... thường tối ưu model/access pattern chuyên biệt. Không dùng các cặp tuyệt đối như fixed/flexible, vertical/horizontal hay ACID/BASE nếu chưa nói product và cấu hình.

**Q2. Giải thích ACID và BASE.**  
ACID mô tả atomicity, invariant consistency, isolation và durability của transaction. BASE là mnemonic cho thiết kế ưu tiên availability/soft state/eventual convergence. Một hệ có thể dùng cả hai ở các boundary khác nhau.

**Q3. Có những loại NoSQL nào và dùng khi nào?**  
Document cho aggregate lồng nhau; key-value cho lookup theo key; wide-column cho workload phân tán theo partition/access pattern; graph cho traversal quan hệ. “Columnar analytics” là nhánh khác wide-column.

**Q4. Khi nào chọn MongoDB thay PostgreSQL?**  
Khi document aggregate, schema evolution, access pattern và shard strategy phù hợp MongoDB hơn. Vẫn phải so transaction, constraint, join/reporting, consistency, vận hành và benchmark; JSON một mình không đủ để quyết định.

**Q5. CAP trade-off là gì?**  
Khi network partition, một distributed data operation không thể vừa bảo đảm linearizable consistency vừa bảo đảm CAP availability ở mọi non-failing node. Hệ thống chọn reject/wait hoặc tiếp tục với khả năng stale/divergent state.

**Q6. SQL và NoSQL nằm ở đâu trong CAP?**  
Không có mapping theo nhãn SQL/NoSQL. Phải mô tả deployment, operation, quorum/consistency setting và behavior khi partition.

**Q7. Chọn model nào cho ledger, catalog và chat?**  
Ledger thường cần transactional relational store; catalog có thể document hoặc relational + JSON; chat thường kết hợp durable message store, key-value cho ephemeral state và broker cho fan-out. Nêu invariant và access pattern quan trọng hơn tên sản phẩm.

**Q8. Relational database có hạn chế gì trong distributed systems?**  
Cross-shard join/transaction, rebalancing và global coordination có thể đắt; schema migration lớn khó. Tuy nhiên relational database vẫn scale ngang được, còn NoSQL cũng có hotspot, consistency và operational challenges.

**Q9. Polyglot persistence là gì?**  
Dùng nhiều data store theo capability. Nó hữu ích nếu source of truth, ownership và synchronization semantics rõ; nếu không, lợi ích dễ bị nuốt bởi complexity và inconsistency.

**Q10. Data modeling khác nhau thế nào?**  
Relational thường bắt đầu từ entity, dependency, constraint và normalization; NoSQL thường bắt đầu từ access pattern, partition key, aggregate và denormalization. Cả hai vẫn có thể kết hợp normalization/denormalization theo mục tiêu.

---

#### 10. Những ngộ nhận và lỗi thiết kế thường gặp

- Chọn database theo độ phổ biến thay vì requirement và access pattern.
- Nói SQL là một data model thay vì phân biệt SQL language với relational model.
- Tin SQL chỉ scale dọc hoặc NoSQL tự động scale ngang vô hạn.
- Đồng nhất SQL với ACID/strong consistency và NoSQL với BASE/eventual consistency.
- Nhầm consistency của ACID với consistency của CAP.
- Nghĩ “ACID” mặc định nghĩa là serializable isolation.
- Hiểu “schema-less” là không cần schema governance hay migration.
- Dùng flexible schema để đẩy mọi validation sang production data.
- Nhầm wide-column store với analytical column store.
- Chọn document DB chỉ vì API dùng JSON.
- Embed document không giới hạn hoặc tạo partition/hot key quá lớn.
- Normalization hay denormalization cực đoan mà không xét read/write path.
- Gắn nhãn database cố định là CP/AP, bỏ qua operation và cấu hình.
- Dùng cache/index làm source of truth mà không có recovery/rebuild strategy.
- Dùng nhiều database nhưng không quy định ownership, propagation và reconciliation.
- Dual-write trực tiếp vào hai store mà không thiết kế partial failure.
- Chỉ benchmark happy path, không thử failover, partition, lag, restore và rebalancing.

---

#### 11. Database design checklist

1. Source of truth và owner của từng dataset?
2. Entity, aggregate, relationship và lifecycle?
3. Business invariant/constraint cần database bảo vệ?
4. Query/read/write pattern và percentile latency?
5. Transaction boundary và isolation level?
6. Consistency/session guarantees theo từng operation?
7. Schema evolution, versioning, backfill và rollback?
8. Primary/partition/shard key có phân bố đều và hỗ trợ query không?
9. Index nào cần thiết; write/storage amplification chấp nhận được không?
10. Read replica, cache hoặc derived view có stale/rebuild semantics gì?
11. Multi-zone/region, failover và partition behavior?
12. Backup, PITR, restore test, RPO và RTO?
13. Encryption, access control, audit, retention và data residency?
14. Capacity, cost và growth plan?
15. Observability cho latency, error, saturation, replication lag và hot partition?
16. Migration/exit plan nếu model hoặc product không còn phù hợp?

#### 12. Ý chính cần nhớ

- Chọn database là chọn data model và guarantee phù hợp requirement.
- SQL/relational mạnh về relation, constraint, transaction và query ecosystem.
- NoSQL là một họ model; document, key-value, wide-column và graph giải các access pattern khác nhau.
- Schema linh hoạt không có nghĩa không có schema.
- ACID và BASE không phải hai phe loại trừ; guarantee phải nêu theo boundary.
- Consistency trong ACID khác consistency trong CAP.
- SQL có thể scale ngang; NoSQL vẫn có shard key, hotspot, transaction và vận hành phức tạp.
- Wide-column khác analytical columnar storage.
- CP/AP là behavior theo partition, operation và cấu hình, không phải nhãn cố định của sản phẩm.
- Polyglot persistence chỉ đáng giá khi ownership, source of truth và synchronization rõ ràng.
- Hãy mô hình hóa theo invariant và access pattern, rồi mới chọn công nghệ.

#### Công thức ghi nhớ

> **Database phù hợp = data model đúng + invariant/transaction đủ mạnh + access pattern hiệu quả + scale/failure behavior chấp nhận được + đội ngũ vận hành được.**

---

### Bài 41. Advanced Database Topics — Sharding, Replication & Polyglot Persistence

#### 1. Ba kỹ thuật giải ba nhóm vấn đề khác nhau

Khi database trở thành bottleneck, cần xác định đúng bottleneck trước khi chọn giải pháp:

| Kỹ thuật | Vấn đề chính cần giải | Không tự động giải quyết |
|---|---|---|
| **Vertical scaling** | Một node thiếu CPU, RAM, I/O hoặc storage | Trần phần cứng, single-node failure, scale vô hạn |
| **Replication/read replica** | Availability, failover và read throughput | Write throughput của một leader, tổng dataset quá lớn, backup |
| **Sharding** | Storage capacity và read/write throughput vượt một node | Consistency, cross-shard transaction, hotspot, vận hành đơn giản |
| **Polyglot persistence** | Một data model/query engine không phù hợp mọi workload | Đồng bộ dữ liệu, ownership, backup và operational complexity |

Các kỹ thuật thường được kết hợp:

```text
                   Shard router / application routing
                         /                    \
                    Shard A                  Shard B
                  leader A1                leader B1
                  /       \                /       \
            follower A2  A3          follower B2  B3
```

Trong ví dụ này:

- **sharding** chia dataset và write load giữa A/B;
- **replication** tạo nhiều bản sao bên trong từng shard;
- **routing** đưa request tới đúng shard và đúng replica theo consistency requirement.

> **Không có kiến trúc database phổ quát. Hãy tìm giới hạn đang gặp — compute, read, write, storage, availability, locality hay query model — rồi chọn kỹ thuật tương ứng.**

---

#### 2. Scaling SQL và NoSQL: tránh kết luận quá đơn giản

Mô hình thường gặp trong lịch sử:

- relational database bắt đầu bằng một primary mạnh, scale dọc và thêm read replica;
- nhiều NoSQL database được thiết kế ngay từ đầu để partition/replicate trên nhiều node.

Nhưng đây không phải ranh giới tuyệt đối:

- SQL có partitioning, sharding và distributed SQL;
- NoSQL vẫn có thể bị giới hạn bởi hot key, coordination, quorum, index hoặc partition quá lớn;
- scale ngang không “gần như vô hạn”: throughput tăng đến khi chạm shared bottleneck, skew, network, coordination hoặc chi phí;
- strong consistency và transaction không chỉ tồn tại trong SQL;
- eventual consistency không phải đặc tính bắt buộc của NoSQL.

Scale dọc có lợi thế đơn giản, latency nội bộ thấp và transaction dễ hơn. Scale ngang tăng tổng capacity và fault domains, nhưng thêm routing, replication, consistency, rebalancing và failure modes. Quyết định đúng phụ thuộc workload và economics, không chỉ tên loại database.

---

#### 3. Replication là gì?

**Replication** duy trì nhiều bản sao của cùng logical data trên các node/failure domain khác nhau.

Mục tiêu có thể gồm:

- tăng availability và hỗ trợ failover;
- mở rộng tải đọc;
- đặt dữ liệu gần người dùng;
- giảm blast radius của node/zone failure;
- hỗ trợ bảo trì hoặc nâng cấp.

Replication tạo thêm bản sao đang hoạt động, nhưng không tự động tạo một nguồn recovery độc lập.

> **Replication không phải backup.** Lệnh xóa nhầm, update lỗi, corruption hoặc ransomware có thể nhanh chóng lan tới mọi replica. Vẫn cần backup/PITR, retention độc lập và restore test.

##### 3.1 Replication log và thứ tự thay đổi

Một node thường ghi thay đổi vào transaction/replication log rồi truyền tới replica. Tùy hệ thống, replica có thể nhận:

- statement/command;
- row-level logical changes;
- physical log/page changes;
- event/change stream.

Thiết kế phải biết:

- thứ tự change được bảo đảm trong scope nào;
- replica apply đến vị trí nào;
- retry có tạo duplicate không;
- schema change tương thích thế nào;
- snapshot/bootstrap replica mới ra sao.

##### 3.2 Synchronous, asynchronous và semi-synchronous replication

**Synchronous replication**

- leader chỉ xác nhận write sau khi số replica yêu cầu đã nhận hoặc durable-commit;
- giảm RPO khi leader hỏng;
- tăng write latency và có thể giảm availability nếu replica/quorum không liên lạc được.

**Asynchronous replication**

- leader xác nhận trước khi follower bắt kịp;
- write latency thấp hơn và leader ít phụ thuộc follower;
- replica có lag; failover có thể mất acknowledged writes chưa replicate.

**Semi-synchronous/quorum-based replication**

- xác nhận sau một ngưỡng replica/quorum hoặc theo policy;
- cân bằng durability, latency và availability;
- cần hiểu chính xác “acknowledged” nghĩa là nhận vào memory, ghi log hay fsync.

Không chỉ hỏi “sync hay async”; phải hỏi **acknowledgement point**, quorum, timeout và failure model.

---

#### 4. Leader–follower replication

Trong mô hình leader–follower:

1. client gửi write tới leader;
2. leader xác định thứ tự và commit theo durability policy;
3. change được truyền tới follower;
4. follower replay/apply change;
5. read có thể đi tới leader hoặc follower.

Ưu điểm:

- một write authority giúp conflict/order dễ quản lý hơn;
- follower có thể scale read;
- failover follower lên leader khi leader hỏng;
- backup/analytics có thể giảm tải khỏi primary nếu được thiết kế đúng.

Giới hạn:

- leader vẫn là bottleneck của write path;
- asynchronous follower có replication lag;
- failover cần election, fencing và client rerouting;
- long-running query trên follower có thể cạnh tranh I/O/apply;
- follower càng nhiều, replication/network cost càng lớn.

##### 4.1 Read replica

Read replica là replica được dùng chủ yếu để phục vụ read. Nó phù hợp khi workload read-heavy như catalog, content, news hoặc reporting có thể chịu mức stale nhất định.

Read replica **không**:

- tăng trực tiếp write capacity của leader;
- bảo đảm đọc thấy write vừa commit nếu replication async;
- loại bỏ nhu cầu index/query optimization;
- thay thế cache cho mọi use case;
- thay thế backup.

##### 4.2 Replica lag và stale read

Có thể tách lag thành:

- **transport lag**: change chưa tới replica;
- **apply lag**: đã nhận nhưng chưa replay;
- **visibility lag**: đã apply nhưng read path/cache chưa quan sát theo guarantee.

Hậu quả:

- user cập nhật profile rồi đọc lại thấy dữ liệu cũ;
- vừa đặt đơn nhưng trang lịch sử chưa có đơn;
- workflow quyết định dựa trên inventory/balance cũ;
- pagination hoặc nhiều lần đọc quan sát thời gian “đi lùi”.

Các kỹ thuật giảm vấn đề:

- read critical data từ leader;
- **read-your-writes** bằng sticky routing trong một khoảng thời gian;
- truyền commit position/token và chỉ đọc replica đã bắt kịp;
- dùng bounded-staleness SLA;
- route theo replication lag/health;
- tách read model eventual khỏi command/invariant path.

##### 4.3 Failover không chỉ là “chọn replica khác”

Một failover an toàn cần:

1. phát hiện leader thực sự không còn hợp lệ;
2. chọn follower đủ mới và promote;
3. ngăn leader cũ tiếp tục nhận write bằng **fencing**;
4. cập nhật routing/service discovery;
5. xác định acknowledged write nào có thể mất;
6. đưa node cũ trở lại mà không tạo split-brain;
7. kiểm tra consistency và phục hồi capacity/replica count.

Các metric cần theo dõi: replication lag theo bytes/time/log position, apply errors, replica health, quorum, failover duration, data loss window và read correctness.

##### 4.4 Các topology khác

- **Multi-leader**: nhiều leader nhận write, hữu ích cho multi-region/offline use case nhưng cần conflict detection/resolution.
- **Leaderless/quorum**: client/coordinator ghi và đọc từ nhiều replica; cần quorum math, hinted handoff, read repair, anti-entropy và conflict semantics.

Chúng không mặc định tốt hơn leader–follower; chỉ chuyển trade-off sang write conflict, convergence và application complexity.

---

#### 5. Partitioning và sharding

**Partitioning** là chia logical dataset thành các phần. **Sharding** thường chỉ partition dữ liệu ngang qua nhiều database node/instance độc lập để phân tán storage và traffic.

```text
users 1..N
   | shard key = user_id
   +--> shard 0: một phần user
   +--> shard 1: một phần user
   +--> shard 2: một phần user
```

Mỗi shard sở hữu một subset dữ liệu và thường có replication riêng.

##### 5.1 Horizontal và “vertical” sharding

- **Horizontal sharding**: chia các row/entity cùng loại theo key/range/hash; mục tiêu chính là phân tán dataset và traffic.
- **Vertical partitioning**: tách cột hoặc nhóm dữ liệu theo access pattern.
- Việc tách profile, billing, analytics sang database/service khác thường được gọi không chính xác là **vertical sharding**; trong kiến trúc service, nó gần với functional decomposition/database-per-service hơn.

Thuật ngữ có thể khác giữa tài liệu, vì vậy khi phỏng vấn nên mô tả cụ thể dữ liệu nào được chia và routing ra sao.

##### 5.2 Khi nào cần sharding?

Sharding đáng cân nhắc khi:

- dataset/working set/index không còn phù hợp một node;
- write throughput vượt khả năng primary;
- maintenance/backup/recovery window của một database quá lớn;
- cần locality/data residency theo tenant/region;
- vertical scaling, indexing, caching, archival và read replica đã không đủ.

Không nên shard quá sớm. Trước đó có thể tối ưu query/index, archive cold data, cache, read replica, partition trong một database hoặc chọn máy phù hợp. Sharding thêm một distributed system vào data layer và rất khó đảo ngược.

---

#### 6. Chọn shard key

Shard key quyết định:

- dữ liệu nằm ở đâu;
- request có route tới một shard hay phải fan-out;
- load/storage phân bố đều không;
- transaction và uniqueness có local được không;
- resharding khó tới mức nào.

Một shard key tốt thường:

- có cardinality đủ cao;
- phân bố tương đối đều theo data size và request rate;
- ổn định, hiếm đổi;
- xuất hiện trong phần lớn query quan trọng;
- giữ entity cần transaction cùng shard;
- tránh monotonically increasing hotspot nếu write được dồn vào một range;
- không tạo tenant khổng lồ chiếm trọn shard nếu chưa có split strategy.

> **Phân bố row đều chưa chắc phân bố tải đều.** Một celebrity, tenant lớn hoặc hot product vẫn tạo hotspot dù số record mỗi shard bằng nhau.

##### 6.1 Range-based sharding

Ví dụ:

```text
A–F -> shard 1
G–M -> shard 2
N–Z -> shard 3
```

Ưu điểm:

- range scan/local ordering hiệu quả;
- routing và hiểu data locality tương đối đơn giản.

Nhược điểm:

- skew nếu phân bố hoặc tăng trưởng không đều;
- timestamp/sequential ID có thể dồn write vào shard cuối;
- split/merge range và migration phải được vận hành tốt.

##### 6.2 Hash-based sharding

```text
shard = hash(shard_key) mod N
```

Ưu điểm:

- phân bố key thường đều hơn;
- giảm hotspot do key tăng tuần tự.

Nhược điểm:

- mất natural ordering/locality;
- range query có thể scatter-gather;
- modulo hashing làm nhiều key bị remap khi `N` thay đổi;
- hot key vẫn nóng vì mọi request của key đó vẫn tới một shard.

##### 6.3 Consistent hashing

Consistent hashing ánh xạ key và node lên hash ring/token space. Khi membership đổi, chỉ một phần key range được chuyển thay vì remap gần như toàn bộ.

Thực tế thường cần:

- virtual nodes/tokens để cân bằng;
- replication factor;
- weighted capacity;
- movement throttling;
- health và ownership metadata;
- xử lý node join/leave/failure.

Consistent hashing **giảm** data movement, không loại bỏ rebalancing và không tự xử lý hot key.

##### 6.4 Directory-based sharding

Một lookup service/catalog lưu mapping:

```text
tenant_id -> shard_id
```

Ưu điểm:

- placement linh hoạt;
- dễ chuyển tenant cụ thể hoặc tách tenant lớn;
- phù hợp khi capacity/tenant không đồng đều.

Đổi lại, directory trở thành critical metadata plane: cần cache, replication, versioning, atomic update và tránh stale routing.

##### 6.5 Geo-based sharding

Chia theo country/region để:

- giảm latency;
- đáp ứng data residency/sovereignty;
- cô lập failure domain;
- vận hành theo market.

Khó khăn xuất hiện khi user di chuyển, data cần truy cập xuyên region, global uniqueness/transaction hoặc regulation thay đổi. Geo placement không chỉ là bài toán performance mà còn là ownership và compliance.

##### 6.6 Composite/hybrid strategy

Hệ thống lớn thường kết hợp:

```text
region -> hash(tenant_id) -> time range
```

Ví dụ region tạo locality, hash tenant phân bố tải, còn time partition hỗ trợ lifecycle. Mỗi tầng tăng khả năng tối ưu nhưng cũng tăng routing, migration và debugging complexity.

---

#### 7. Những bài toán sharding làm khó hơn

##### 7.1 Routing và metadata

Application, proxy hoặc database coordinator phải biết shard ownership. Routing metadata cần có version và cơ chế invalidation để tránh request đi nhầm shard trong migration.

##### 7.2 Scatter–gather query

Nếu query không có shard key, coordinator có thể phải gửi tới mọi shard rồi merge/sort/aggregate kết quả:

```text
latency ~= shard chậm nhất + fan-out/merge overhead
```

Fan-out làm tăng tail latency, connection usage và blast radius. Giải pháp có thể là global index, search/analytics derived store, query restriction hoặc data model khác.

##### 7.3 Cross-shard transaction

Transaction trên nhiều shard cần distributed coordination như two-phase commit, consensus-backed transaction hoặc saga/compensation tùy invariant. Nó có latency, failure mode và operational cost cao hơn local transaction.

Thiết kế tốt cố gắng chọn aggregate/shard key để invariant quan trọng nằm trong một shard, nhưng không hy sinh mọi query khác một cách mù quáng.

##### 7.4 Global uniqueness và ID

Auto-increment cục bộ có thể đụng ID giữa shard. Các hướng:

- UUID/ULID hoặc ID generator phân tán;
- prefix theo shard/region;
- central allocation theo block;
- unique registry/index nếu cần uniqueness toàn cục.

Mỗi hướng đánh đổi locality, ordering, index locality và coordination.

##### 7.5 Hot shard và hot key

Giải pháp tùy nguyên nhân:

- đổi/composite shard key;
- split tenant/range lớn;
- add salt/bucket cho write-heavy key;
- cache/fan-out read;
- rate limit/isolate noisy tenant;
- adaptive partitioning;
- tách workload/time window.

Salting giúp phân tán write nhưng làm read/aggregation phải fan-out; cần nêu rõ trade-off.

##### 7.6 Resharding và rebalancing

Khi thêm shard, thay capacity hoặc skew tăng, dữ liệu phải di chuyển. Một online migration thường cần:

1. tạo target shard/range;
2. copy snapshot/backfill;
3. capture change phát sinh trong lúc copy;
4. bắt kịp và kiểm tra checksum/count/invariant;
5. chuyển read/write routing bằng version/fencing;
6. quan sát, rollback window;
7. xóa source sau retention an toàn.

Dual-write đơn giản dễ mất nhất quán khi một phía thành công, một phía thất bại. Nên dùng database-native migration, log/CDC, outbox hoặc protocol có idempotency và reconciliation rõ ràng.

---

#### 8. Kết hợp sharding với replication

Production database thường không chọn một trong hai mà dùng cả hai:

```text
logical dataset
  -> shard theo tenant/user/order
  -> mỗi shard replicate qua node/zone
```

Khi một node lỗi, replica của shard đó failover. Khi tổng tải tăng, thêm shard và rebalance dataset. Điều này tạo hai control loops khác nhau:

- **replica management** giữ đủ bản sao và leader/quorum khỏe;
- **partition management** giữ ownership, size và load cân bằng.

Các failure cần diễn tập:

- leader của một shard chết;
- cả zone chứa nhiều replica mất;
- router/catalog stale;
- resharding bị dừng giữa chừng;
- một shard lag hoặc đầy disk;
- network partition tạo competing leaders;
- backup chỉ restore được một phần shard hoặc không đồng nhất theo thời điểm.

Backup toàn cluster cần consistent snapshot hoặc recovery procedure biết log/time position của từng shard.

---

#### 9. Polyglot persistence ở quy mô lớn

Polyglot persistence dùng nhiều data store vì các workload có data model và guarantee khác nhau:

| Workload | Store thường cân nhắc |
|---|---|
| Transactional order/payment | Relational/distributed transactional DB |
| Flexible product/profile aggregate | Document hoặc relational + JSON |
| Cache/session/ephemeral state | In-memory key-value store |
| Full-text search | Search engine/index |
| Relationship traversal | Graph database |
| High-volume event/time series | Wide-column, time-series hoặc log store |
| Raw logs/media/backup | Object storage |
| BI/large aggregation | Columnar warehouse/lakehouse engine |

Nguyên tắc quan trọng:

1. **Bắt đầu đơn giản:** một database đủ tốt thường tốt hơn năm database “tối ưu”.
2. **Một source of truth:** cache, search index, warehouse và projection là derived data nếu có thể.
3. **Ownership rõ:** service nào được quyền ghi dataset nào?
4. **Propagation contract:** event/CDC gửi gì, ordering và delivery guarantee ra sao?
5. **Idempotency/reconciliation:** duplicate, missing và out-of-order update xử lý thế nào?
6. **Independent recovery:** backup/restore từng store và cách rebuild derived store?
7. **Quan sát end-to-end:** lag, freshness, divergence, failed event và replay progress.
8. **Justify complexity:** thêm store chỉ khi lợi ích đo được vượt chi phí vận hành.

##### 9.1 Tránh dual-write inconsistency

Tình huống nguy hiểm:

```text
1. Ghi order DB thành công
2. Ghi search index thất bại
3. API báo gì? Retry có tạo duplicate không?
```

Pattern thường dùng:

- commit business state và outbox record trong cùng local transaction;
- relay/CDC phát event at-least-once;
- consumer cập nhật derived store idempotently;
- theo dõi lag/failure và có replay/rebuild;
- không giả vờ có transaction toàn cục nếu hệ thống không cung cấp.

Eventual consistency ở đây phải có freshness SLO và repair path, không chỉ là lời hứa “rồi sẽ đồng bộ”.

---

#### 10. Các tình huống quyết định nhanh

**Read tăng mạnh, write và data size vẫn vừa một primary**  
Tối ưu query/index trước, sau đó cân nhắc cache và read replica. Định tuyến read cần xét freshness.

**Write hoặc dataset vượt một node**  
Chọn partition/shard key theo access pattern và invariant; thiết kế replication cho từng shard, resharding và cross-shard behavior.

**Multi-region nhưng dữ liệu không được rời quốc gia**  
Geo-shard theo residency boundary, sau đó replicate trong vùng hợp lệ; xử lý user migration/global query riêng.

**Một tenant tạo phần lớn tải**  
Hash tenant đơn thuần không đủ. Cần khả năng split tenant theo bucket/entity/time, isolate hoặc dedicated shard.

**Cần search và analytics trên transactional data**  
Giữ transactional DB làm source of truth, đồng bộ search/warehouse bằng outbox/CDC; thiết kế lag, replay và rebuild.

**Cần đọc ngay dữ liệu vừa ghi từ replica**  
Route tạm về leader, dùng commit token/replica position hoặc session consistency; không chỉ “chờ vài giây” không có contract.

---

#### 11. 18 câu hỏi ôn tập và phỏng vấn

##### 11.1 Tám câu hỏi từ tài liệu PDF

**Q1. Horizontal scaling và vertical scaling khác nhau thế nào? Khi nào chọn mỗi loại?**  
Vertical scaling tăng CPU, RAM, I/O hoặc storage của một node; đơn giản hơn và phù hợp khi workload còn nằm trong giới hạn một máy. Horizontal scaling thêm node để phân tán tải/data; phù hợp khi capacity, availability hoặc locality vượt giới hạn một máy, nhưng thêm routing, consistency và vận hành phân tán. Đây không phải phân chia SQL–NoSQL tuyệt đối: cả hai nhóm đều có thể dùng hai hướng.

**Q2. Leader–follower replication hoạt động ra sao và ảnh hưởng consistency/availability thế nào?**  
Write đi qua leader rồi được truyền tới follower; read có thể đi từ follower để giảm tải. Với async replication, follower có thể stale và failover có nguy cơ mất write chưa replicate. Sync replication giảm data-loss window nhưng tăng write latency và có thể làm write unavailable khi không đủ replica. Việc truyền đồng bộ **không tự nó** bảo đảm mọi read đều strong consistent; còn phụ thuộc read routing, commit rule và protocol.

**Q3. Read replica có ưu và nhược điểm gì?**  
Ưu điểm là tăng read throughput, tách reporting/analytics workload và cho phép một số read tiếp tục khi primary gặp sự cố. Nhược điểm là replication lag, routing phức tạp và không tăng write capacity của leader. Replica chỉ trở thành failover target an toàn nếu có promotion, fencing và mức dữ liệu đủ mới; nó không thay backup.

**Q4. So sánh range-based và hash-based sharding.**  
Range sharding giữ ordering/locality nên range query hiệu quả, nhưng dễ skew hoặc hot range. Hash sharding thường phân bố key đều hơn, nhưng phá vỡ natural ordering và range query có thể phải fan-out. Hash chỉ giảm skew do phân bố key; một hot key hoặc hot tenant vẫn làm một shard quá tải.

**Q5. Vì sao consistent hashing quan trọng?**  
Với `hash(key) mod N`, thay đổi `N` có thể remap phần lớn key. Consistent hashing giúp chỉ một phần key range đổi owner khi node thêm/bớt, nhờ đó giảm data movement và hỗ trợ elasticity. Nó vẫn cần virtual node/token, replication, movement throttling và rebalancing; không tự bảo đảm availability hay loại hotspot.

**Q6. CAP ảnh hưởng thiết kế distributed database thế nào? Cho ví dụ CP/AP.**  
Khi network partition xảy ra, một operation không thể đồng thời bảo đảm linearizable consistency và CAP availability ở mọi phía. CP behavior sẽ reject/wait ở phía không thể xác nhận authoritative state; AP behavior tiếp tục đáp ứng nhưng chấp nhận stale/divergent state và cần conflict resolution. MongoDB, Cassandra hoặc DynamoDB không nên bị gắn nhãn cố định nếu chưa nêu topology, read/write setting và operation cụ thể.

**Q7. Polyglot persistence là gì và vì sao dùng nhiều database?**  
Đó là dùng data store chuyên biệt cho các workload khác nhau, chẳng hạn relational DB cho transaction, document DB cho aggregate linh hoạt, search index cho full-text search và key-value store cho cache/session. Lợi ích là data model và performance phù hợp hơn; chi phí là nhiều hệ cần quản lý, bảo mật, backup và đồng bộ. Phải có source of truth, ownership và repair path rõ ràng.

**Q8. Netflix hoặc Uber dùng nhiều công nghệ database như thế nào?**  
PDF nêu các ví dụ minh họa: Netflix kết hợp Cassandra, MySQL, Elasticsearch và DynamoDB; Uber kết hợp PostgreSQL/MySQL, Redis, BigQuery và Hadoop cho các workload khác nhau. Cách trả lời quan trọng hơn danh sách sản phẩm: transaction, high-write/geo-distributed data, cache/geospatial state, search và analytics có yêu cầu khác nhau nên có thể cần store khác nhau. Danh sách công nghệ của công ty lớn thay đổi theo thời gian và từng service, vì vậy không nên coi đây là inventory hiện hành hay architecture duy nhất của họ.

##### 11.2 Mười câu hỏi đào sâu thêm

**Q9. Replication và sharding khác nhau thế nào?**  
Replication tạo nhiều bản sao của cùng data để availability/read scale; sharding chia các subset khác nhau để scale storage và read/write. Thực tế thường replicate từng shard.

**Q10. Synchronous và asynchronous replication đánh đổi gì?**  
Synchronous giảm data-loss window nhưng tăng latency/phụ thuộc replica; asynchronous giảm write latency nhưng có lag và nguy cơ mất acknowledged write khi failover.

**Q11. Làm sao đạt read-your-writes với replica?**  
Đọc từ leader, sticky session, dùng commit position/token để chọn replica đã bắt kịp hoặc cung cấp session/bounded-staleness guarantee.

**Q12. Vì sao failover có thể gây split-brain?**  
Leader cũ vẫn nhận write trong khi leader mới đã được promote. Cần quorum/lease/consensus và fencing để chỉ một writer hợp lệ.

**Q13. Shard key tốt có đặc điểm gì?**  
Cardinality cao, ổn định, phân bố cả data lẫn traffic, có trong query chính và co-locate transaction/invariant quan trọng.

**Q14. Scatter–gather có vấn đề gì?**  
Query chạm nhiều shard, latency phụ thuộc shard chậm nhất và fan-out khuếch đại tải/lỗi. Nên tránh trên hot path hoặc dùng derived global index.

**Q15. Cross-shard transaction xử lý thế nào?**  
Co-locate invariant nếu có thể; nếu bắt buộc, dùng database-supported distributed transaction hoặc workflow saga/compensation với semantics được nêu rõ.

**Q16. Reshard online cần gì?**  
Snapshot/backfill, capture change, validation, versioned routing/fencing, idempotency, monitoring, rollback window và cleanup an toàn.

**Q17. Vì sao replication không phải backup?**  
Replica thường sao chép cả lỗi logic/xóa/corruption. Backup có retention và recovery boundary độc lập, kèm PITR và restore test.

**Q18. SQL có shard được không?**  
Có. Application sharding, middleware và distributed SQL đều tồn tại; transaction, join, routing và rebalancing trở nên phức tạp hơn.

---

#### 12. Những lỗi tư duy thường gặp

- Cho rằng SQL chỉ scale dọc và NoSQL luôn scale ngang.
- Thêm replica để xử lý write bottleneck của một leader.
- Đọc mọi request từ replica mà không phân loại freshness.
- Chỉ đo replica lag trung bình, bỏ qua tail lag và apply error.
- Promote leader mới mà không fencing leader cũ.
- Xem replication là backup.
- Shard trước khi tối ưu index/query, archive, cache hoặc scale đơn giản hơn.
- Chọn shard key chỉ vì cardinality cao mà bỏ qua traffic skew/query locality.
- Dùng timestamp range khiến mọi write dồn vào shard mới nhất.
- Nghĩ hash sharding loại bỏ hot key.
- Dùng modulo hashing rồi bất ngờ khi thêm node phải remap gần toàn bộ.
- Không thiết kế query thiếu shard key và scatter–gather cost.
- Giả định uniqueness, join và transaction xuyên shard vẫn rẻ như một node.
- Reshard bằng dual-write không có idempotency/reconciliation.
- Dùng nhiều store nhưng không xác định source of truth.
- Thêm polyglot persistence theo xu hướng dù đội ngũ không vận hành nổi.
- Không diễn tập failover, restore và migration khi tải thật.

---

#### 13. Advanced database checklist

1. Bottleneck hiện tại là CPU, memory, I/O, read, write, storage hay locality?
2. Có thể giải bằng index/query/cache/archive/read replica trước sharding không?
3. Replication mode và acknowledgement point là gì?
4. RPO khi failover và RTO/election/routing time?
5. Read nào chịu stale; freshness/read-your-writes contract?
6. Lag, apply error, quorum và failover được quan sát thế nào?
7. Fencing và split-brain prevention?
8. Shard key phân bố data và traffic ra sao ở hiện tại/tương lai?
9. Hot tenant/key/range được split hoặc isolate thế nào?
10. Query thiếu shard key, global index và scatter–gather behavior?
11. Cross-shard transaction, uniqueness và ID generation?
12. Online resharding, validation, rollback và throttling?
13. Mỗi shard có replication/failure-domain placement phù hợp không?
14. Cluster-wide backup/PITR có consistent recovery point không?
15. Với polyglot persistence, source of truth và data owner là ai?
16. Outbox/CDC propagation, idempotency, ordering, lag và replay?
17. Security, residency, retention và deletion có đi qua mọi copy/store?
18. Cost/complexity có được biện minh bằng SLO hoặc business requirement đo được?

#### 14. Ý chính cần nhớ

- Vertical scaling đơn giản nhưng có trần; horizontal scaling tăng capacity cùng distributed complexity.
- SQL/NoSQL không quyết định một mình cách scale hay consistency model.
- Replication phục vụ availability/read scale; sharding phục vụ phân tán data và write/read load.
- Read replica có thể stale; critical read cần freshness strategy.
- Replication mode là trade-off giữa acknowledgement latency, availability và data-loss window.
- Failover cần election, fencing, routing và recovery — không chỉ promote một node.
- Replication không thay backup.
- Shard key là quyết định cốt lõi; phải cân bằng distribution, locality, transaction và future growth.
- Range, hash, consistent hashing, directory và geo sharding có mục tiêu khác nhau.
- Consistent hashing giảm remapping nhưng không loại hotspot hay rebalancing.
- Cross-shard query/transaction/uniqueness và resharding là phần giá của sharding.
- Polyglot persistence bắt đầu bằng một source of truth và synchronization contract rõ.
- Start simple; chỉ thêm distributed complexity khi requirement biện minh được.

#### Công thức ghi nhớ

> **Database scale tốt = replication cho availability/read + sharding cho data/write + routing/consistency đúng + failover/resharding đã diễn tập + polyglot có ownership rõ.**

---

### Bài 42. Object Storage in Modern Systems

#### 1. Object storage giải bài toán gì?

Object storage được thiết kế để lưu lượng dữ liệu rất lớn dưới dạng các **object độc lập**, truy cập qua API bằng một key. Nó đặc biệt phù hợp với:

- ảnh, video, audio và tài liệu;
- user upload và static asset;
- backup, archive và compliance record;
- log, event file và data lake;
- model, dataset và artifact của ML/AI;
- package, build artifact và large binary.

Mục tiêu chính là durability, throughput tổng, quy mô và chi phí trên dung lượng — không phải low-latency random mutation như block storage hoặc filesystem semantics đầy đủ.

> **Object storage phù hợp khi application có thể coi dữ liệu là object hoàn chỉnh: tạo/đọc/thay thế/xóa theo key, thay vì sửa byte/block tùy ý tại chỗ.**

---

#### 2. Object, bucket, key và metadata

Một object có thể hình dung như:

```text
object = bytes + object key + system metadata + custom metadata/tags
```

##### 2.1 Object

Object chứa payload bytes và thông tin mô tả. Storage service không nhất thiết hiểu nội dung nghiệp vụ bên trong; application chịu trách nhiệm encoding, format, schema và validation.

##### 2.2 Bucket/container

Bucket là logical container và thường là boundary cho:

- namespace;
- access policy;
- versioning;
- lifecycle;
- replication;
- logging/audit;
- region và một phần compliance configuration.

Không nên tạo bucket tùy tiện cho từng user nếu provider quota/policy model không phù hợp. Multi-tenant system thường dùng một số bucket theo environment/data class rồi cô lập bằng key prefix, identity/policy và metadata database.

##### 2.3 Object key và prefix

Object được định danh bằng key, ví dụ:

```text
tenant-42/videos/01J.../source.mp4
```

Dấu `/` thường chỉ là ký tự trong key. Console có thể hiển thị giống folder, nhưng phần lớn object store dùng namespace logic phẳng và mô phỏng hierarchy bằng **prefix**.

Thiết kế key cần xét:

- uniqueness và idempotency;
- tenant isolation;
- lifecycle/query/list pattern;
- khả năng đoán key;
- rename/move cost;
- tránh đưa PII/secret vào key hoặc URL/log;
- tránh phụ thuộc filename do user cung cấp.

“Đổi tên” object thường thực chất là copy sang key mới rồi xóa key cũ; không có atomic filesystem rename mặc định.

##### 2.4 Metadata và tags

Metadata có thể gồm:

- content type, content length, timestamp;
- checksum/validation information;
- encryption/version/storage class;
- owner, project, classification;
- application-specific fields.

Metadata hữu ích cho policy và xử lý, nhưng object store không phải lúc nào cũng hỗ trợ ad-hoc query metadata như database. Nhiều hệ thống giữ metadata có thể truy vấn trong relational/document/search store, còn object storage giữ bytes và một số metadata kỹ thuật.

---

#### 3. Object storage khác file và block storage

| Khía cạnh | Object storage | File storage | Block storage |
|---|---|---|---|
| **Đơn vị** | Object hoàn chỉnh | File/directory | Block/volume |
| **Addressing** | Bucket + key qua API | Path trong hierarchy | Block offset/device |
| **Metadata** | Rich system/custom metadata | Filesystem metadata | Ít semantics; filesystem/DB tự quản lý |
| **Mutation** | Thường replace object; multipart cho upload | Read/write/append theo file semantics | Random read/write block |
| **Latency** | Network/API latency, tối ưu throughput/scale | Phù hợp shared file access | Thường thấp, phù hợp DB/VM |
| **Sharing** | HTTP/API, dễ truy cập ở quy mô lớn | POSIX/NFS/SMB-like semantics | Thường attach vào host/cluster cụ thể |
| **Use case** | Media, backup, lake, static asset | Shared workspace, home directory, legacy app | Database volume, VM disk, transactional I/O |

Object storage không mặc định là “tốt hơn”; nó cung cấp semantics khác. Database thường không nên đặt active data files trực tiếp trên generic object APIs nếu database engine không được thiết kế cho điều đó.

---

#### 4. Nền tảng phổ biến

- Amazon S3;
- Azure Blob Storage;
- Google Cloud Storage;
- MinIO/S3-compatible deployments;
- Ceph Object Gateway và các private/hybrid object stores.

S3-compatible API không bảo đảm mọi implementation có cùng consistency, IAM, versioning, event, lifecycle, multipart, checksum hoặc failure semantics. Khi chọn nền tảng, cần so sánh:

- ecosystem và API compatibility;
- region/data residency;
- durability/availability commitment;
- consistency theo operation;
- identity, encryption và audit;
- lifecycle/archive/replication;
- request, retrieval và egress pricing;
- managed service so với self-operated complexity;
- migration/portability và test thực tế.

---

#### 5. Request path điển hình

```text
Client
  -> application/API xin quyền hoặc metadata
  -> presigned upload/download URL
  -> object storage
  -> event/queue
  -> scanner/transcoder/indexer
  -> metadata DB cập nhật trạng thái
  -> CDN phục vụ object/variant đã duyệt
```

Application không nhất thiết proxy toàn bộ bytes. Direct upload/download bằng quyền tạm thời giúp:

- giảm bandwidth và memory/connection load của application server;
- tăng throughput;
- cho client dùng multipart/resume;
- tách control plane khỏi data plane.

Nhưng application vẫn phải kiểm soát object key, tenant, size, content type thực, checksum, thời hạn, trạng thái upload và bước xử lý sau upload.

---

#### 6. Consistency và object semantics

Consistency của object store có thể khác theo:

- tạo object mới;
- overwrite cùng key;
- delete;
- list/prefix enumeration;
- metadata/tag update;
- cross-region replication;
- event notification;
- CDN/cache visibility.

Không nên học một câu chung như “object storage là eventual consistency”. Nhiều managed service hiện cung cấp strong consistency cho một số hoặc phần lớn operation, nhưng guarantee phải được kiểm tra trong tài liệu provider và region/configuration đang dùng.

Các pattern an toàn:

- dùng immutable key/versioned key thay vì overwrite hot object;
- ghi object trước rồi commit metadata/status trong database;
- coi event notification là at-least-once nếu contract không nói khác;
- consumer xử lý idempotently;
- không suy ra upload hoàn tất chỉ từ việc nhận callback phía client;
- không coi `LIST` là transaction/query database;
- version hoặc cache-bust URL khi nội dung đổi;
- thiết kế reconciliation nếu object và metadata DB lệch nhau.

##### 6.1 Whole-object replacement

Object store thường không hỗ trợ random in-place update như block device. Muốn đổi vài byte, application thường tạo object/version mới. Append-heavy log nên gom/buffer thành chunk/file hoặc dùng log/stream store trước khi compact sang object storage.

##### 6.2 Range request

Client có thể yêu cầu một byte range để đọc một phần object nếu service hỗ trợ. Điều này hữu ích cho media seeking, parallel download và format có index/footer, nhưng không biến object store thành low-latency block storage.

##### 6.3 Multipart upload

Object lớn được chia thành parts để upload song song và retry riêng:

1. khởi tạo upload;
2. upload từng part có số thứ tự/checksum;
3. complete để tạo object;
4. abort nếu thất bại.

Cần lifecycle dọn incomplete multipart upload; nếu không, các part bỏ dở vẫn có thể phát sinh storage cost.

---

#### 7. Durability, availability và integrity

- **Durability**: xác suất acknowledged object không bị mất trong failure model đã cam kết.
- **Availability**: khả năng request được phục vụ tại thời điểm cần.
- **Integrity**: bytes đọc ra đúng với bytes đã ghi.
- **Recoverability**: có thể khôi phục đúng object/version sau lỗi vận hành hoặc logic.

Object store có thể dùng replication, erasure coding, checksum/scrubbing và nhiều failure domain để đạt durability cao. Tuy nhiên:

- durability cao không bảo đảm service luôn reachable;
- availability cao không bảo đảm không xóa nhầm;
- replication/versioning không tự thay backup độc lập;
- cross-region replication có lag và có thể replicate thao tác xóa/lỗi theo policy;
- client nên xác minh checksum cho đường truyền và, khi phù hợp, end-to-end integrity.

`ETag` có thể hỗ trợ conditional request/cache validation, nhưng **không nên mặc định coi ETag là checksum nội dung**: semantics có thể thay đổi theo multipart upload, encryption hoặc provider.

---

#### 8. Performance và access pattern

Object storage thường mạnh ở:

- nhiều client song song;
- large sequential transfer;
- aggregate throughput lớn;
- write-once/read-many;
- distribution qua CDN và batch analytics.

Nó thường yếu hơn ở:

- rất nhiều object cực nhỏ;
- frequent overwrite/append;
- random small read/write;
- filesystem locking/rename semantics;
- low-latency transaction;
- query theo field bên trong object.

##### 8.1 Small-object problem

Hàng tỷ object vài KB có thể khiến request cost, metadata/list overhead và processing latency lớn hơn chi phí bytes. Có thể gom record thành larger immutable files/chunks, dùng columnar formats cho analytics hoặc giữ hot small records trong database phù hợp.

##### 8.2 Tối ưu thường dùng

- multipart upload/download cho object lớn;
- parallelism có giới hạn và retry với backoff/jitter;
- byte-range request;
- CDN/cache cho public hoặc distributed read;
- compression phù hợp khả năng truy cập;
- immutable/versioned asset names;
- regional placement gần producer/consumer;
- connection reuse và request batching nơi API hỗ trợ;
- benchmark theo object-size distribution và concurrency thật.

Không tối ưu chỉ theo bandwidth tối đa; cần đo p50/p95/p99 latency, error/throttle, time-to-first-byte, requests/second, transfer volume và cost.

---

#### 9. Security và chia sẻ object

##### 9.1 Nguyên tắc nền tảng

- private by default và chặn public access ngoài ý muốn;
- least-privilege identity/role thay cho long-lived access key;
- bucket/container policy rõ và tránh ACL rải rác nếu không cần;
- TLS khi truyền; encryption at rest;
- tách role upload, processing, read và administration;
- audit data access/configuration change;
- key rotation và quyền KMS phù hợp;
- tenant isolation được kiểm tra ở cả API lẫn storage policy.

##### 9.2 Presigned URL

Presigned URL cấp quyền tạm thời cho một operation/object cụ thể mà client không cần cloud credential trực tiếp.

Cần giới hạn:

- method (`GET`, `PUT`...);
- bucket/key chính xác;
- thời hạn ngắn phù hợp;
- content length/type/checksum nếu cơ chế ký hỗ trợ;
- quyền tạo URL chỉ ở trusted backend;
- không log/chia sẻ URL như dữ liệu công khai;
- trạng thái object sau upload phải được backend xác nhận.

Ai có URL còn hiệu lực thường có thể dùng quyền đó, nên presigned URL là bearer capability chứ không phải xác thực user liên tục.

##### 9.3 Upload không tin cậy

User upload nên đi vào quarantine prefix/bucket, sau đó:

1. xác minh size/checksum;
2. kiểm tra MIME bằng content, không chỉ extension/header;
3. malware scan/content moderation;
4. normalize/transcode nếu cần;
5. ghi metadata và trạng thái;
6. chỉ publish qua key/CDN path đã duyệt.

Object key do backend sinh; sanitize filename và response headers để tránh path confusion, content sniffing hoặc stored content attack.

##### 9.4 Encryption và KMS

- provider-managed server-side encryption đơn giản hơn;
- KMS/customer-managed key tăng control/audit nhưng thêm quota, latency, availability và key-lifecycle dependency;
- client-side encryption bảo vệ trước khi upload nhưng làm search, range, key recovery và processing phức tạp hơn.

Encryption không thay authorization, audit, backup hay data deletion policy.

---

#### 10. Storage class, lifecycle và cost

Các tier thường trải từ hot/standard tới infrequent-access, archive và deep archive. Tên/đặc tính tùy provider.

Tổng chi phí không chỉ là GB/tháng:

```text
total cost
  = capacity
  + PUT/GET/LIST requests
  + data retrieval
  + network egress/transfer
  + replication
  + encryption/key operations
  + early deletion/minimum duration
  + processing/observability
```

Lifecycle rule có thể tự động:

- chuyển object/version sang tier rẻ hơn;
- hết hạn current hoặc noncurrent versions;
- xóa delete marker;
- abort incomplete multipart upload;
- giữ object theo retention/compliance rule.

Trước khi chuyển archive cần biết:

- restore mất bao lâu;
- retrieval fee và request fee;
- minimum storage duration;
- object có cần restore tạm trước khi đọc không;
- business RTO có đáp ứng không;
- disaster recovery có cần restore song song ở quy mô lớn không.

Tier rẻ nhất chưa chắc rẻ nhất nếu thường xuyên retrieve hoặc giữ object ngắn hơn minimum duration.

---

#### 11. Versioning, immutability và retention

**Versioning** giữ nhiều version của cùng key, hỗ trợ phục hồi overwrite/delete nhầm. Cần quản lý:

- noncurrent-version lifecycle;
- delete marker;
- storage growth;
- quyền xóa version;
- cách application chọn version hiện hành.

**Object Lock/WORM** ngăn overwrite/delete trong retention period theo mode và policy; **legal hold** giữ object cho tới khi được gỡ bởi quyền phù hợp.

Những cơ chế này hữu ích cho compliance và ransomware resistance, nhưng:

- cấu hình sai có thể khóa dữ liệu lâu và tạo chi phí lớn;
- retention không tự xác minh backup có thể restore;
- versioning trong cùng account/failure boundary không phải backup độc lập;
- quyền quản trị, key encryption và audit log vẫn cần bảo vệ.

---

#### 12. Các kiến trúc điển hình

##### 12.1 Media hosting/video streaming

```text
Client
  -> API tạo upload session + immutable object key
  -> multipart upload trực tiếp vào quarantine bucket
  -> object-created event / completion verification
  -> queue
  -> scan + transcode nhiều bitrate/resolution
  -> HLS/DASH manifest và segments trong object storage
  -> metadata DB chuyển trạng thái READY
  -> CDN phân phối tới viewer
```

Các quyết định cần nêu:

- upload resume, checksum và size limit;
- idempotent processing khi event trùng;
- original/derived object ownership;
- metadata DB là nguồn trạng thái nghiệp vụ;
- CDN authorization/signed URL/cookie cho nội dung private;
- cache key/invalidation và immutable variant;
- lifecycle cho source, rendition cũ và failed uploads;
- moderation, deletion và copyright workflow.

##### 12.2 Backup hàng petabyte

- gom/compress log theo time/tenant và tạo manifest;
- checksum từng object và manifest;
- versioning/Object Lock khi requirement cần immutability;
- lifecycle từ hot sang archive theo access/RTO;
- replication hoặc account/region isolation theo threat model;
- catalog/index để tìm recovery set;
- kiểm thử restore có đo throughput, thời gian và chi phí;
- lifecycle dọn expired versions/incomplete upload;
- không chỉ đo backup success, phải đo recovery success.

##### 12.3 Microservices chia sẻ file lớn

- service sở hữu file phát presigned URL có scope/thời hạn;
- consumer truyền object reference thay vì bytes qua message/API;
- object reference gồm bucket/key/version/checksum/content type;
- quyền storage gắn với workload identity;
- event/outbox thông báo trạng thái, consumer idempotent;
- audit, retention và deletion đi theo data ownership;
- tránh một shared bucket trở thành nơi mọi service đọc/ghi tùy ý.

##### 12.4 Data lake

Object storage giữ raw/curated datasets; catalog/metastore giữ schema/partition metadata; compute engine đọc theo batch hoặc interactive query.

Cần thiết kế file format, partitioning, compaction, schema evolution, small files, table format/transaction layer, access policy và data quality — không chỉ “ném file vào bucket”.

##### 12.5 Static website và CDN origin

Object storage có thể giữ HTML/CSS/JS/media; CDN cung cấp edge cache, TLS, custom domain và bảo vệ origin. Tránh public bucket nếu có thể dùng private origin access. Với SPA cần cấu hình routing/error fallback; deployment nên dùng immutable asset hash và atomic pointer/version strategy.

---

#### 13. Chín câu hỏi phỏng vấn từ tài liệu PDF

##### Nhóm khái niệm

**Q1. Object storage khác file và block storage thế nào?**  
Object storage truy cập object bằng key/API và có rich metadata; file storage cung cấp hierarchy/filesystem semantics; block storage cung cấp raw blocks cho filesystem/DB. Chọn theo mutation, latency, sharing và access pattern, không chỉ loại dữ liệu.

**Q2. Khi nào chọn object storage thay filesystem?**  
Khi cần lưu lượng lớn media, backup, log, dataset hoặc static asset với durability, scale và HTTP/API access; không cần POSIX locking, atomic rename hoặc frequent in-place mutation.

**Q3. Một object gồm gì và metadata có vai trò gì?**  
Gồm payload bytes, key/identifier và system/custom metadata. Metadata hỗ trợ content handling, policy, lifecycle, classification và processing; ad-hoc business search thường vẫn cần metadata DB/index riêng.

##### Nhóm tình huống system design

**Q4. Dùng object storage để thiết kế nền tảng video thế nào?**  
Client upload trực tiếp bằng presigned multipart URL vào khu vực quarantine; event kích hoạt scan/transcode; mỗi resolution/segment là object; metadata DB theo dõi trạng thái; CDN phân phối HLS/DASH. Bổ sung checksum, idempotency, authorization và lifecycle.

**Q5. Thiết kế backup tiết kiệm chi phí cho hàng petabyte log?**  
Gom/compress theo partition, tạo manifest/checksum, dùng lifecycle chuyển tier, versioning/Object Lock theo threat/compliance model và đo access pattern. Quan trọng nhất là catalog, retention, PITR/restore procedure và restore drill phù hợp RTO/RPO.

**Q6. Microservices chia sẻ file lớn an toàn thế nào?**  
Truyền object reference và phát presigned URL ngắn hạn; workload identity/IAM chỉ cấp quyền tối thiểu; TLS và encryption at rest; audit access; kiểm tra checksum/version. Không gửi long-lived credential hoặc payload lớn qua message bus.

##### Nhóm thực tế và trade-off

**Q7. Performance trade-off của object storage cho real-time access?**  
Network/API latency cao hơn local block, small random I/O và frequent mutation kém phù hợp. Bù lại, object storage có aggregate throughput và scale lớn. Consistency không nên khẳng định chung là eventual; phải kiểm tra provider/operation và cả CDN/cache layer.

**Q8. Storage tiers ảnh hưởng thiết kế thế nào?**  
Hot tier có latency/availability tốt hơn nhưng storage cost cao; archive rẻ hơn nhưng retrieval chậm và có fee/minimum duration. Lifecycle phải xuất phát từ access frequency, legal retention, RTO và tổng chi phí, không chỉ giá GB.

**Q9. Kiểm soát truy cập dữ liệu từng user thế nào?**  
Backend xác thực user rồi ánh xạ sang tenant/object ownership; dùng role/policy least privilege và presigned URL đúng key/method/thời hạn; mã hóa, audit và public-access guardrail. Không tin object key do client gửi nếu chưa kiểm tra ownership.

---

#### 14. Những lỗi tư duy thường gặp

- Nghĩ prefix là directory thật và kỳ vọng atomic rename/locking.
- Dùng object storage như filesystem hoặc database volume dù workload không phù hợp.
- Đưa mọi object qua application server, tạo bandwidth bottleneck.
- Phát presigned URL quá lâu, quá rộng hoặc cho key do client tự chọn.
- Tin extension/`Content-Type` của upload mà không kiểm tra nội dung.
- Publish object trước khi scan/transcode/validation hoàn tất.
- Nghĩ object-created event chỉ đến đúng một lần và đúng thứ tự.
- Nói mọi object store đều eventual consistent hoặc mọi operation đều strong consistent.
- Coi ETag luôn là checksum nội dung.
- Dùng overwrite cùng key rồi quên CDN/browser cache cũ.
- Tạo hàng tỷ object rất nhỏ mà không tính request/metadata cost.
- Bật versioning nhưng không dọn noncurrent versions/delete markers.
- Coi versioning/replication là backup.
- Chuyển mọi dữ liệu sang archive rẻ nhất mà không xét retrieval/RTO.
- Chỉ tính GB/tháng, bỏ qua request, retrieval, egress và KMS cost.
- Bật Object Lock/retention mà không kiểm thử governance và chi phí.
- Dùng một shared bucket với quyền rộng cho mọi service/tenant.
- Không lưu checksum/version trong metadata DB hoặc manifest.
- Có backup nhưng chưa thử restore ở quy mô thực.

---

#### 15. Object storage design checklist

1. Object là gì, kích thước và số lượng/growth distribution?
2. Key scheme có unique, immutable, tenant-safe và không chứa PII?
3. Access pattern: PUT/GET/LIST/range/overwrite/delete?
4. Latency, throughput, concurrency và availability SLO?
5. Consistency guarantee theo create/overwrite/delete/list/replication?
6. Multipart threshold, retry, checksum và incomplete-upload cleanup?
7. Metadata nào ở object store, metadata nào ở database/index?
8. Direct upload/download hay proxy qua application?
9. Presigned URL scope, TTL, size/type/checksum constraints?
10. Quarantine, malware scan, moderation và publish workflow?
11. Private access, IAM/bucket policy, public guardrail và audit?
12. TLS, at-rest encryption, KMS dependency và key recovery?
13. Versioning, Object Lock, retention, legal hold và deletion?
14. Replication/failure domains, backup và restore test?
15. Storage class/lifecycle theo access, RTO và minimum duration?
16. Request/retrieval/egress/replication/KMS cost model?
17. CDN cache key, invalidation, authorization và origin protection?
18. Event delivery, idempotency, lag và reconciliation?
19. Data residency, compliance và secure deletion?
20. Portability/API compatibility và migration/exit strategy?

#### 16. Ý chính cần nhớ

- Object storage lưu bytes cùng key và metadata, truy cập qua API.
- Bucket/prefix là logical organization; prefix thường không phải folder thật.
- Object storage khác file/block ở interface và mutation semantics.
- Nó mạnh về durability, scale và aggregate throughput; yếu hơn ở low-latency random mutation.
- Consistency phải kiểm tra theo provider, operation và cache/replication layer.
- Immutable/versioned key thường an toàn hơn overwrite hot object.
- Multipart upload, range request, checksum và CDN là building blocks quan trọng.
- Durability khác availability, integrity và recoverability.
- ETag không mặc định là content checksum.
- Presigned URL là quyền tạm thời; phải giới hạn key, method, TTL và kiểm tra hậu upload.
- Versioning/Object Lock hỗ trợ recovery/compliance nhưng không thay backup/restore test.
- Tổng chi phí gồm request, retrieval, egress và operation khác ngoài storage bytes.
- Lifecycle phải dựa trên access pattern, retention và RTO.
- Metadata DB thường quản lý business state; object store giữ large bytes.
- Thiết kế tốt bao gồm upload, processing, delivery, retention và deletion end-to-end.

#### Công thức ghi nhớ

> **Object storage tốt = immutable objects + key/metadata rõ + direct secure transfer + consistency/integrity có contract + lifecycle đúng RTO/cost + recovery đã kiểm thử.**

---

### Bài 43. File Systems and Distributed Storage

#### 1. File system là lớp abstraction nào?

Raw block device chỉ cung cấp các vùng byte/block. **File system** biến chúng thành abstraction quen thuộc:

- file và directory;
- path/name resolution;
- metadata như size, owner, permission và timestamp;
- mapping logical file offset tới physical blocks/extents;
- create, read, write, append, rename và delete semantics;
- allocation/free-space management;
- caching, buffering và recovery sau crash.

```text
Application
  -> system calls / file API
  -> virtual file system + concrete filesystem
  -> page cache / I/O scheduler
  -> block device / volume
```

Application làm việc với path/file descriptor thay vì tự quản từng disk block.

Ví dụ local filesystem: ext4, XFS, NTFS, APFS. Tên filesystem không đủ để quyết định; cần xét workload, mount options, storage device, kernel, durability mode và cách vận hành.

> **File system là một hợp đồng về namespace và file semantics, không chỉ là cách đặt dữ liệu lên đĩa.**

---

#### 2. Thành phần và đặc tính của filesystem truyền thống

##### 2.1 Namespace và path lookup

Directory tạo hierarchy:

```text
/data/projects/p42/events.parquet
```

Filesystem phân giải từng thành phần của path, kiểm tra quyền rồi tìm metadata/data tương ứng. Directory cực lớn hoặc path lookup dày đặc có thể trở thành metadata workload đáng kể.

##### 2.2 Inode/file metadata

Nhiều Unix-like filesystem dùng cấu trúc tương tự **inode** để giữ metadata và pointer/extent tới data blocks. Filename thường nằm trong directory entry trỏ tới inode; vì vậy tên/path và nội dung không nhất thiết là cùng một record.

##### 2.3 Allocation và fragmentation

Filesystem phải cấp phát block/extent, thu hồi free space và hạn chế fragmentation. Large sequential files, hàng triệu small files và random overwrite tạo profile I/O khác nhau.

##### 2.4 Cache, buffer và durability

Write trả về thành công ở application chưa chắc bytes đã durable trên media. Cần hiểu:

- page cache;
- buffered/direct I/O;
- flush/`fsync` semantics;
- device/controller cache;
- write ordering và barrier;
- failure model của volume.

##### 2.5 Journaling và crash recovery

Journaling ghi trước metadata hoặc thay đổi theo transaction-like log để filesystem khôi phục structure nhất quán sau crash. Nó không tự bảo vệ khỏi xóa nhầm, corruption ở mọi lớp hoặc mất cả thiết bị; backup và integrity checks vẫn cần.

##### 2.6 Local filesystem không nhất thiết là “một disk”

Local filesystem có thể nằm trên partition, RAID, logical volume, SAN block device hoặc volume do cloud cung cấp. Điểm phân biệt quan trọng là filesystem semantics được một host/kernel quản lý trực tiếp hay được cung cấp như shared/distributed service — không chỉ số ổ đĩa bên dưới.

---

#### 3. Local, network và distributed filesystem

| Mô hình | Cách nhìn từ client | Dữ liệu/metadata | Điểm mạnh | Giới hạn chính |
|---|---|---|---|---|
| **Local filesystem** | Mount/device của một host | Host/filesystem quản lý | Latency thấp, semantics rõ, đơn giản | Chia sẻ và scale-out cần lớp khác |
| **Network filesystem** | Remote share được mount | Có thể tập trung ở server/appliance | Dễ chia sẻ file qua NFS/SMB | Server/network bottleneck và failure domain tùy kiến trúc |
| **Distributed filesystem (DFS)** | Một logical namespace trên cluster | Metadata và file chunks/blocks phân tán/được phối hợp | Scale-out, throughput và fault tolerance | Consistency, metadata, repair và vận hành phức tạp |
| **Object storage** | Bucket + key qua API | Object độc lập, không full filesystem semantics | Massive scale, durability, API/HTTP | Không mặc định POSIX, random in-place update hoặc atomic rename |

Network filesystem và distributed filesystem có thể chồng lấn: một DFS có thể được expose qua NFS/SMB/POSIX-like mount. Khi thảo luận, nên mô tả implementation và guarantee thay vì chỉ dùng nhãn.

---

#### 4. Vì sao cần distributed filesystem?

Khi một storage server không đáp ứng đủ:

- tổng capacity;
- aggregate throughput;
- số client đồng thời;
- availability;
- recovery time;
- failure-domain isolation;
- compute/data locality;

DFS chia file thành block/chunk và đặt chúng trên nhiều storage node, trong khi vẫn trình bày một logical namespace.

Lợi ích:

- thêm node để tăng capacity/throughput;
- đọc/ghi nhiều block song song;
- replica/parity chịu node/disk failure;
- rebalance khi membership/capacity đổi;
- scheduling compute gần data cho một số workload.

Chi phí:

- network hop và coordination;
- metadata service phải scale và HA;
- consistency/cache/locking phức tạp;
- background repair/rebalance cạnh tranh I/O;
- rolling upgrade, capacity skew và incident blast radius;
- semantics có thể yếu/khác POSIX để đổi lấy throughput.

> **DFS không làm latency của một operation tự động thấp hơn; nó chủ yếu tăng aggregate capacity, parallelism và resilience.**

---

#### 5. Kiến trúc DFS tổng quát

```text
                         Metadata service
                      namespace + block map
                         /      |      \
Client -- metadata lookup      health   placement
  |                              |         |
  +-------- direct data I/O ---> Data node A
  +-------- direct data I/O ---> Data node B
  +-------- direct data I/O ---> Data node C
```

##### 5.1 Metadata plane

Metadata service quản lý hoặc phối hợp:

- directory tree và filename;
- ownership/permission/ACL;
- file -> block/chunk mapping;
- replica placement;
- lease/lock và open-file state tùy hệ thống;
- node health/membership;
- namespace mutation và recovery log.

Metadata cần high availability. Các cách triển khai có thể dùng active/standby, replicated state machine, partitioned metadata hoặc distributed metadata servers. “Một metadata server” trong logical design không có nghĩa production chỉ có một process không dự phòng.

##### 5.2 Data plane

Storage/data node giữ bytes của block/chunk, phục vụ client I/O, báo health/inventory và tham gia replication/repair.

Trong nhiều DFS, client hỏi metadata service để biết block ở đâu rồi truyền bytes **trực tiếp** với data nodes. Điều này tránh đưa mọi data qua metadata coordinator.

##### 5.3 Control plane

Control plane theo dõi desired state:

- node heartbeat và block report;
- under/over-replication;
- disk usage và hot spots;
- re-replication/recovery;
- placement theo rack/zone;
- decommission và rebalance;
- corruption/checksum repair.

---

#### 6. HDFS như một ví dụ kiến trúc

HDFS được tối ưu lịch sử cho large files, sequential streaming và batch analytics hơn là OLTP hoặc hàng triệu tiny random updates.

##### 6.1 NameNode

NameNode quản lý namespace và metadata như:

- hierarchy/permission;
- file-to-block mapping;
- block location/replication state;
- namespace operation;
- lease và recovery coordination tùy operation.

NameNode không phục vụ payload file trong normal data path. HA deployment cần standby/failover và cơ chế ngăn hai active cùng điều phối sai.

##### 6.2 DataNode

DataNode:

- giữ actual blocks trên local volumes;
- phục vụ client read/write;
- gửi heartbeat và block report;
- tạo/xóa/replicate block theo instruction;
- xác minh checksum và báo lỗi.

##### 6.3 Read path rút gọn

1. Client hỏi NameNode metadata và block locations.
2. NameNode trả danh sách replica, thường có ưu tiên locality/topology.
3. Client đọc trực tiếp từ DataNode phù hợp.
4. Nếu replica lỗi/corrupt, client thử replica khác và báo lỗi để hệ thống repair.

##### 6.4 Write path rút gọn

1. Client yêu cầu tạo file và nhận placement/pipeline.
2. Data được chia thành packets/chunks và gửi vào pipeline DataNodes.
3. Các DataNode forward/ghi theo replication protocol.
4. Acknowledgement đi ngược pipeline.
5. NameNode cập nhật namespace/block state theo protocol.
6. Close/commit làm file visible theo semantics của hệ thống.

Chi tiết acknowledgement và durability phải kiểm tra theo version/configuration; không suy ra chỉ từ replication factor.

##### 6.5 Block size và replication factor

Large block giúp:

- giảm số metadata entries;
- giảm seek/setup overhead;
- tăng sequential throughput;
- tạo đơn vị scheduling/parallelism đủ lớn.

Nhưng block quá lớn giảm parallelism cho file nhỏ và tăng recovery granularity. Block size và replication factor là **cấu hình**, không nên học thuộc một con số như guarantee vĩnh viễn. Replication factor cao tăng resilience/read options nhưng tốn capacity/network và repair bandwidth.

---

#### 7. Fault tolerance và reliability

##### 7.1 Failure là bình thường

Trong cluster lớn, disk, process, server, rack, switch và network link đều có thể lỗi. DFS phải phát hiện, cô lập và repair liên tục.

##### 7.2 Heartbeat và block report

- **Heartbeat** cho biết DataNode còn sống/đáp ứng control protocol.
- **Block report** cho biết node đang giữ những block nào.

Không nhận heartbeat chỉ chứng minh node không liên lạc trong threshold, chưa chỉ ra nguyên nhân. Failure detector luôn có trade-off giữa phát hiện nhanh và false positive.

##### 7.3 Replication placement

Replica nên trải qua failure domains phù hợp, ví dụ nhiều disk/node/rack/zone. Ba copy trên cùng rack không bảo vệ khỏi mất rack.

Placement cân bằng:

- fault tolerance;
- write/read locality;
- cross-rack/zone bandwidth;
- storage utilization;
- compliance/residency.

##### 7.4 Re-replication và repair

Khi block under-replicated:

1. metadata/control plane phát hiện;
2. chọn healthy source và target;
3. copy block, xác minh checksum;
4. cập nhật ownership/location;
5. throttle để tránh repair storm ảnh hưởng foreground traffic.

Khi nhiều node cùng lỗi, repair bandwidth và time-to-repair quyết định exposure window. Chỉ biết replication factor là chưa đủ.

##### 7.5 Erasure coding

Erasure coding giảm storage overhead so với full replicas ở quy mô lớn, nhưng encode/reconstruct có CPU/network cost và thường phù hợp cold/large data hơn latency-sensitive small writes.

##### 7.6 Metadata durability và HA

Data blocks còn nguyên nhưng mất authoritative namespace/block mapping vẫn có thể khiến hệ thống khó sử dụng. Cần:

- replicated metadata/log;
- active/standby hoặc consensus;
- checkpoint/snapshot theo design;
- fencing khi failover;
- backup và restore test metadata;
- kiểm tra namespace/data consistency.

##### 7.7 Replication không thay backup

Lệnh xóa, corruption, bug hoặc ransomware có thể tác động nhiều replica. Vẫn cần snapshot/backup/versioning theo threat model, retention độc lập và recovery drill.

---

#### 8. Scalability và những bottleneck thực tế

##### 8.1 Capacity và throughput

Thêm node có thể tăng disk capacity và aggregate bandwidth, nhưng không tuyến tính mãi vì:

- metadata coordination;
- network/oversubscription;
- skew/hot files;
- background replication/rebalance;
- client/scheduler limits;
- shared rack/zone failure domains.

##### 8.2 Metadata bottleneck

Workload nhiều create/open/stat/list/rename hoặc hàng tỷ small files có thể giới hạn metadata plane trước khi hết data capacity.

Giải pháp tùy hệ thống:

- metadata sharding/federation;
- cache có coherence đúng;
- batch operation;
- gom small files;
- tránh deep/hot directory patterns;
- tăng metadata node capacity;
- dùng object/table store phù hợp hơn.

##### 8.3 Small-file problem

Nhiều file rất nhỏ tạo:

- metadata entry và memory overhead lớn;
- nhiều RPC/open/close;
- poor sequential throughput;
- nhiều tiny tasks trong analytics;
- namespace scan/backup chậm.

Có thể compact thành larger files/container, dùng Parquet/ORC cho analytics hoặc chọn key-value/object storage tùy access pattern.

##### 8.4 Rebalancing

Khi thêm/bớt node, hệ thống di chuyển block để cân bằng capacity/load và giữ placement policy. Rebalance phải:

- có bandwidth/IO limit;
- ưu tiên dữ liệu rủi ro cao;
- tránh phá locality quá mức;
- quan sát queue, ETA và impact;
- hỗ trợ pause/resume/recovery;
- phân biệt capacity balance với traffic balance.

##### 8.5 Hot file, hot directory và skew

Replica có thể scale một số read, nhưng một hot writer/metadata path vẫn nghẽn. Có thể partition workload, cache read-only data, tăng replica, tách namespace, rate limit hoặc thay data model. Cần đo request distribution, không chỉ dung lượng.

---

#### 9. Latency, throughput và data locality

**Latency** là thời gian hoàn tất một operation; **throughput** là tổng bytes/operations theo thời gian. DFS cho analytics thường chọn:

- large sequential I/O;
- read-ahead/buffering;
- parallel scan;
- batching;
- compression;
- large files/blocks.

Điều này tăng throughput nhưng không tối ưu small random read/write hoặc metadata-heavy OLTP.

##### 9.1 Data locality

Nếu compute chạy gần node/rack chứa data, có thể giảm network transfer và tăng throughput. Scheduler có thể ưu tiên node-local, rack-local rồi remote.

Trong cloud/disaggregated architecture, compute và storage thường tách rời; locality có thể chuyển thành region/AZ/cache locality thay vì cùng physical host. Vì vậy data locality là cost/performance strategy, không phải quy tắc bất biến.

##### 9.2 Đo hiệu năng đúng

Cần đo:

- p50/p95/p99 open/read/write/close latency;
- aggregate và per-node throughput;
- metadata ops/s;
- network/disk utilization;
- cache hit ratio;
- under-replicated/corrupt blocks;
- repair/rebalance backlog;
- client retry/throttle/error;
- file-size distribution và skew.

---

#### 10. Consistency, caching và concurrency

POSIX-like expectations gồm read-after-write visibility, atomic rename, permissions, file locking và concurrent writer behavior. Distributed implementation phải coordination qua network nên mỗi guarantee có giá.

Các model có thể gồm:

- strong/linearizable metadata operation trong boundary nhất định;
- close-to-open consistency;
- session consistency;
- write-once/read-many;
- single-writer lease;
- append với giới hạn cụ thể;
- eventual propagation của cache/replica.

Không nên nói “DFS hỗ trợ POSIX” rồi suy ra mọi corner case giống local ext4. Cần kiểm tra semantics của:

- concurrent read/write;
- rename/replace;
- file lock/lease expiry;
- append;
- partial write/client crash;
- cache invalidation;
- failover và stale client;
- permission/ACL update.

##### 10.1 Client caching

Cache data/metadata giảm latency và tải server nhưng tạo coherence problem. TTL đơn giản có thể trả stale; callback/lease/invalidation mạnh hơn nhưng thêm state và failure handling.

##### 10.2 Lease, lock và fencing

Lease cho writer quyền trong một khoảng thời gian. Khi lease hết hoặc failover, writer cũ có thể vẫn chạy. Fencing token/epoch giúp storage từ chối write của owner cũ, tránh split-brain và stale writer corruption.

---

#### 11. Chọn HDFS, CephFS, GlusterFS, network FS hay object storage

| Nhu cầu | Hướng thường cân nhắc |
|---|---|
| Large sequential batch analytics, ecosystem Hadoop/Spark | HDFS hoặc storage connector tương thích workload |
| Shared POSIX-like namespace cho nhiều client | CephFS hoặc distributed/network filesystem phù hợp |
| Shared enterprise/legacy file access | Managed NFS/SMB/NAS hoặc scale-out file platform |
| Media/archive/data lake qua API, không cần POSIX | Object storage |
| Database/VM low-latency random I/O | Block storage/filesystem được database hỗ trợ |

Ceph có thể cung cấp object, block và file interfaces qua các thành phần khác nhau; CephFS là file interface. GlusterFS là một scale-out filesystem khác. HDFS được thiết kế quanh analytics/data-local processing và semantics riêng.

Không chọn dựa trên bảng tên sản phẩm. Cần proof-of-concept theo:

- POSIX/API compatibility thật sự cần;
- small/large file mix;
- latency/throughput/concurrency;
- metadata scale;
- write/append/locking semantics;
- rack/AZ/region placement;
- failure/recovery/rebalance;
- backup/snapshot;
- đội ngũ và managed/self-hosted operation;
- roadmap/support của sản phẩm tại thời điểm triển khai.

---

#### 12. Thiết kế storage cho high-throughput analytics

Một pipeline điển hình:

```text
Sources -> ingest/broker -> distributed/object storage
                              |
                       partitioned datasets
                              |
                     compute scheduler/engine
                              |
                   curated tables / serving layer
```

Quyết định quan trọng:

1. Partition theo time/tenant/domain để pruning nhưng tránh quá nhiều partition nhỏ.
2. Dùng Parquet/ORC hoặc format phù hợp để column pruning/compression.
3. Compact small files và kiểm soát target file size.
4. Replicate/erasure-code theo durability và cost.
5. Đặt compute gần data hoặc cache hot working set.
6. Tách ingest, compaction, query và repair bandwidth.
7. Thêm node dựa trên disk, network, metadata và recovery headroom — không chỉ dung lượng.
8. Rebalance có throttling và capacity reserve.
9. Catalog/schema/lineage và access control phải scale cùng bytes.
10. Backup, DR, restore và corruption detection được kiểm thử.

Autoscaling storage node không tức thời: provision, data movement và rebalance có thể mất lâu. Cần capacity planning và headroom thay vì đợi cluster gần đầy mới scale.

---

#### 13. Sáu câu hỏi phỏng vấn từ tài liệu PDF

**Q1. File system và distributed file system khác nhau thế nào?**  
Filesystem quản lý namespace, metadata và block mapping của file. Local filesystem do một host quản lý; DFS phối hợp metadata/data qua nhiều node nhưng trình bày logical namespace chung. DFS tăng capacity, throughput và fault tolerance, đổi lại thêm network, consistency và operational complexity.

**Q2. HDFS bảo đảm fault tolerance/reliability ra sao?**  
File được chia thành block và đặt nhiều replica hoặc protection scheme trên các DataNode/failure domain; health được theo dõi bằng heartbeat/block report; block thiếu replica được repair. Block size và replication factor là cấu hình. Reliability còn cần metadata HA, checksum, rack awareness, fencing, backup và restore test — không chỉ “ba bản sao”.

**Q3. NameNode và DataNode có vai trò gì?**  
NameNode quản namespace, permission và file-to-block/location metadata; DataNode lưu actual blocks và phục vụ I/O. Client thường lấy block location từ NameNode rồi truyền dữ liệu trực tiếp với DataNode. Production cần HA/failover cho metadata plane.

**Q4. Latency và throughput đánh đổi thế nào trong distributed storage?**  
Network/coordination làm operation latency cao hơn; parallel sequential I/O, large block và batching tăng aggregate throughput. Tối ưu analytics scan không đồng nghĩa phù hợp small random transactional reads/writes. Chọn theo latency percentile và workload mix.

**Q5. Khi nào cân nhắc CephFS/GlusterFS thay HDFS?**  
Khi cần shared/general-purpose hoặc POSIX-like file access hơn là semantics batch analytics của HDFS. CephFS phù hợp trong Ceph ecosystem; GlusterFS là một lựa chọn scale-out khác. Tuy nhiên phải kiểm tra feature/support/operations hiện hành và benchmark — không nên mặc định một hệ “đơn giản hơn” trong mọi môi trường.

**Q6. Scale storage cho high-throughput analytics thế nào?**  
Dùng distributed/object storage phù hợp; partition data, large efficient formats như Parquet/ORC, compression và compaction; thêm storage node có headroom; tận dụng locality/cache; tách foreground traffic khỏi repair/rebalance; theo dõi metadata, network, skew và recovery time.

---

#### 14. Những lỗi tư duy thường gặp

- Nói filesystem truyền thống luôn nằm trên đúng một physical disk.
- Đồng nhất network filesystem với distributed filesystem mà không mô tả architecture.
- Nghĩ DFS làm mọi read/write nhanh hơn local storage.
- Đưa mọi payload qua metadata server/NameNode trong sơ đồ.
- Coi NameNode production luôn là single point of failure mà không xét HA design.
- Học thuộc block size/replication factor như hằng số của HDFS.
- Nghĩ replication factor đủ để bảo đảm durability/recovery.
- Đặt replica cùng failure domain.
- Coi replication là backup.
- Chỉ scale data nodes, bỏ qua metadata capacity.
- Lưu hàng tỷ small files mà không tính metadata/RPC/task overhead.
- Nghĩ capacity cân bằng đồng nghĩa traffic cân bằng.
- Rebalance không throttling làm foreground workload suy giảm.
- Không reserve capacity cho repair khi node/rack lỗi.
- Khẳng định “POSIX-compatible” mà không kiểm tra rename, lock, append và cache semantics.
- Dùng TTL cache nhưng không chấp nhận stale metadata/data.
- Dùng lease mà không fencing stale writer.
- Chỉ đo throughput trung bình, bỏ qua tail latency và repair backlog.
- Bật autoscaling nhưng không tính thời gian provision/rebalance.
- Chọn HDFS/CephFS/GlusterFS theo tên tuổi thay vì workload và khả năng vận hành.

---

#### 15. Distributed filesystem design checklist

1. File-size/count distribution và growth rate?
2. Read/write ratio; sequential, random, append hay overwrite?
3. Namespace/stat/list/rename/lock workload?
4. POSIX/NFS/SMB/API semantics nào thực sự bắt buộc?
5. Latency percentile, throughput và concurrency SLO?
6. Metadata architecture, capacity, HA và recovery?
7. Data block/chunk size và placement policy?
8. Replication factor hay erasure coding theo data class?
9. Failure domains: disk, node, rack, AZ, region?
10. Heartbeat/failure detection và false-positive policy?
11. Re-replication priority, bandwidth và time-to-repair?
12. Rebalance/decommission có throttling và rollback không?
13. Hot file/directory/node và small-file mitigation?
14. Cache consistency, lease, lock và fencing semantics?
15. Checksums, scrubbing và corruption repair?
16. Capacity headroom cho failure, repair và growth?
17. Data locality/network topology và scheduler integration?
18. Encryption, ACL, tenant isolation và audit?
19. Snapshot/backup/DR, RPO/RTO và restore test?
20. Upgrade, compatibility, observability và operational ownership?

#### 16. Ý chính cần nhớ

- Filesystem biến raw blocks thành file, directory, metadata và operation semantics.
- Local filesystem có thể nằm trên nhiều lớp/device; “local” không đồng nghĩa một disk.
- DFS trình bày logical namespace trên nhiều storage node.
- Metadata plane và data plane nên được phân biệt rõ.
- Client thường truyền payload trực tiếp với data nodes, không qua metadata coordinator.
- HDFS tối ưu large sequential/batch workload, không phải mọi file workload.
- Block size và replication factor là cấu hình, không phải con số bất biến.
- Replication/erasure coding, placement, checksum và repair cùng tạo fault tolerance.
- Metadata HA quan trọng ngang data replication.
- Replication không thay backup.
- DFS thường tăng aggregate throughput và scale, không tự giảm single-operation latency.
- Small files và metadata-heavy workload có thể làm cluster nghẽn trước khi hết disk.
- Data locality vẫn hữu ích nhưng hình thức thay đổi trong cloud/disaggregated systems.
- POSIX, cache, lock, lease và failover semantics phải được kiểm tra cụ thể.
- Rebalance/repair cần capacity reserve, throttling và observability.
- Chọn storage theo workload, guarantee và operational capability.

#### Công thức ghi nhớ

> **Distributed filesystem tốt = namespace/metadata HA + data placement đúng failure domain + replication/repair có kiểm soát + semantics phù hợp workload + capacity/recovery đã diễn tập.**

---

### Bài 44. Big Data Fundamentals

#### 1. Big Data là gì?

Big Data không có một ngưỡng cố định như “từ 1 TB trở lên”. Một workload trở thành bài toán big data khi quy mô, tốc độ, độ đa dạng hoặc yêu cầu xử lý khiến cách làm thông thường không còn đáp ứng được SLO, chi phí hay khả năng vận hành.

```text
Big Data problem
  = data vượt giới hạn của cách xử lý hiện tại
  + cần storage/compute phân tán hoặc chuyên biệt
  + vẫn phải tạo ra giá trị đáng tin cậy với chi phí hợp lý
```

Dữ liệu có thể đến từ:

- click, page view và user behavior;
- API/application/database logs;
- transaction và change events;
- IoT/sensor/vehicle telemetry;
- hình ảnh, video và tài liệu;
- security/audit signals;
- dataset, feature và artifact của ML.

Big data không phải một sản phẩm. Nó là tập các bài toán về ingest, storage, processing, quality, governance, serving và cost ở quy mô lớn.

> **“Lưu được nhiều byte” chưa phải thành công. Dữ liệu chỉ có giá trị khi hệ thống biến nó thành quyết định hoặc sản phẩm đáng tin cậy, đúng thời điểm và với chi phí chấp nhận được.**

---

#### 2. 5V và 6V của Big Data

Tài liệu PDF dùng **5V**; transcript dùng **6V** bằng cách thêm **Variability**. Đây là các biến thể của cùng framework, không phải hai định nghĩa mâu thuẫn.

| V | Câu hỏi kiến trúc | Hệ quả thường gặp |
|---|---|---|
| **Volume** | Bao nhiêu byte/record, tăng nhanh đến đâu, giữ bao lâu? | Partition, distributed storage, compression, tiering và lifecycle |
| **Velocity** | Tốc độ đến và mức burst? Insight cần sau bao lâu? | Broker, backpressure, stream processing, autoscaling và buffering |
| **Variety** | Structured, semi-structured, binary và schema khác nhau thế nào? | Flexible ingestion, schema registry/evolution, nhiều format và engine |
| **Veracity** | Dữ liệu có đúng, đủ, không trùng và truy xuất nguồn được không? | Validation, dedup, quality rule, lineage và reconciliation |
| **Value** | Dữ liệu cải thiện quyết định/sản phẩm/KPI gì? | Ưu tiên use case, freshness/SLO, ROI và tránh giữ data vô mục đích |
| **Variability** | Distribution, traffic, schema hoặc ý nghĩa thay đổi ra sao? | Adaptive capacity, drift detection, versioning và semantic governance |

Một số tài liệu còn thêm các V khác. Không cần học thuộc số lượng; điều quan trọng là dùng framework để tìm requirement và bottleneck.

##### 2.1 Volume không chỉ là tổng dung lượng

Cần biết:

- record/object/file count;
- average và tail size;
- raw, compressed và replicated size;
- hot working set;
- retention/growth;
- bytes scanned mỗi query;
- tốc độ restore/reprocess.

##### 2.2 Velocity không đồng nghĩa mọi thứ phải real-time

Ingest 1 triệu event/giây không có nghĩa mọi insight cần dưới 1 giây. Có thể buffer stream rồi xử lý micro-batch hoặc batch. Business latency quyết định processing model.

##### 2.3 Variety không buộc phải bỏ schema

Schema vẫn tồn tại trong event contract, table format, validation và consumer. Variety đòi hỏi schema evolution tốt, không phải schema chaos.

##### 2.4 Veracity thường khó hơn analytics

Duplicate, missing field, late event, clock skew, bot traffic, unit mismatch và semantic drift có thể khiến dashboard chính xác về phép tính nhưng sai về ý nghĩa.

---

#### 3. Vì sao cách xử lý truyền thống có thể gặp giới hạn?

Các giới hạn thường xuất hiện ở:

- một node không chứa/scan được dataset trong thời gian yêu cầu;
- ingest/write vượt throughput của một primary;
- nhiều query cạnh tranh CPU, memory, I/O;
- backup/restore/reindex mất quá lâu;
- schema và format đa dạng;
- failure ở quy mô lớn xảy ra thường xuyên;
- scale dọc có diminishing returns;
- workload batch làm ảnh hưởng OLTP;
- analytics cần lịch sử dài và full scan.

Nhưng không nên kết luận:

```text
RDBMS = không dùng được cho Big Data
NoSQL/Hadoop = luôn là đáp án
```

Modern relational/distributed SQL và warehouses có thể scale rất lớn. Ngược lại, một cluster phân tán thiết kế kém vẫn chậm và đắt. Thường cần tách:

- **OLTP system of record** cho transaction/invariant;
- **analytical platform** cho scan, aggregation, ML và lịch sử;
- pipeline đồng bộ có freshness/reconciliation contract.

Vấn đề là workload và SLO, không phải nhãn “truyền thống” hay “hiện đại”.

---

#### 4. Kiến trúc Big Data tổng quát

```text
Operational DBs / Apps / Devices / Files
                    |
             CDC / logs / events
                    v
          Ingestion & durable buffer
                    |
          +---------+----------+
          |                    |
     Stream processing     Raw landing zone
          |                    |
    real-time views       batch ETL/ELT
          |                    |
          +------ curated tables ------+
                         |              |
                 SQL/BI/ML engines   Serving stores
                         |
                  dashboards/models/APIs

Cross-cutting: catalog, schema, lineage, quality, security,
               orchestration, observability, cost and recovery
```

##### 4.1 Sources

Nguồn dữ liệu phải có owner, schema/version, event time, unique ID và change semantics. Trích xuất từ database cần tránh polling/full dump liên tục nếu CDC phù hợp hơn.

##### 4.2 Ingestion và durable buffer

Broker/log hoặc managed stream giúp:

- tách producer khỏi consumer;
- hấp thụ burst;
- replay;
- partition để scale;
- theo dõi lag;
- cho nhiều processing pipelines đọc độc lập.

Phải thiết kế retention, partition key, ordering scope, delivery guarantee, schema compatibility và backpressure.

##### 4.3 Storage layers

- raw/bronze: dữ liệu gần nguồn, immutable, phục vụ audit/replay;
- cleaned/silver: chuẩn hóa, dedup, quality checks và conformed fields;
- curated/gold: aggregate/table tối ưu cho business query hoặc ML.

Tên layer không quan trọng bằng contract, ownership và khả năng rebuild.

##### 4.4 Processing

- stream cho low-latency transformation/alert/stateful computation;
- batch cho backfill, historical aggregation, model training và large recomputation;
- interactive SQL cho exploration và BI;
- specialized compute cho graph, search hoặc ML.

##### 4.5 Serving

Không nên cho mọi user/API scan data lake. Derived serving layers có thể là warehouse, OLAP store, search index, feature store, time-series DB hoặc key-value cache tùy latency/query.

---

#### 5. Batch processing

Batch xử lý một tập dữ liệu hữu hạn hoặc snapshot tại một thời điểm.

Phù hợp với:

- daily/hourly ETL;
- billing/reconciliation;
- historical reporting;
- large joins/aggregations;
- model training;
- backfill/recompute;
- compaction và data quality audit.

Ưu điểm:

- throughput và cost efficiency tốt cho dữ liệu lớn;
- logic dễ reason/replay hơn stream trong nhiều trường hợp;
- có thể retry partition/job;
- tận dụng columnar scan và distributed parallelism.

Nhược điểm:

- kết quả có latency theo lịch/cycle;
- job dài tạo large failure/retry scope;
- shuffle/skew/straggler có thể chi phối runtime;
- backfill cạnh tranh resource với job hiện tại.

##### 5.1 MapReduce mental model

```text
Input splits
   -> Map: transform/filter thành key-value
   -> Shuffle: partition/sort/group theo key
   -> Reduce: aggregate/join/output
```

MapReduce quan trọng về tư duy: đưa computation tới data, partition work và chịu failure bằng retry. Shuffle thường là phần đắt vì network, disk, sort và skew.

##### 5.2 Spark mental model

Spark xây execution plan/DAG từ transformations, chia thành stages/tasks quanh shuffle boundary rồi chạy phân tán. Nó có thể cache data nhưng không phải “mọi thứ luôn ở RAM”. Performance phụ thuộc partition count, shuffle, serialization, spill, file layout, skew và executor sizing.

---

#### 6. Stream processing

Stream xử lý dữ liệu **không giới hạn** khi events tiếp tục đến. “Real-time” thường là một dải từ milliseconds tới minutes; cần nêu latency SLO thay vì chỉ dùng nhãn.

Phù hợp với:

- fraud/risk signals;
- monitoring và alert;
- IoT anomaly;
- personalization/recommendation features;
- live counters/dashboard;
- CDC materialized views;
- online enrichment/routing.

##### 6.1 Event time và processing time

- **event time**: thời điểm sự kiện xảy ra ở nguồn;
- **processing time**: thời điểm operator xử lý sự kiện;
- **ingestion time**: thời điểm platform nhận sự kiện.

Network delay, retry và offline device làm event đến trễ hoặc sai thứ tự.

##### 6.2 Window

Unbounded stream phải được giới hạn khi aggregate:

- tumbling window: các cửa sổ cố định không chồng;
- sliding/hopping window: cửa sổ chồng theo bước;
- session window: nhóm events theo khoảng hoạt động;
- global/custom window: theo logic riêng.

##### 6.3 Watermark và late data

Watermark là ước lượng rằng event time đã tiến tới mốc nào. Nó giúp engine quyết định khi nào emit/close window nhưng không bảo đảm không còn event cũ.

Cần quyết định:

- allowed lateness;
- update/retract kết quả cũ;
- late-event side output/DLQ;
- backfill/reconciliation;
- dashboard có hiển thị preliminary hay final.

##### 6.4 Stateful processing và recovery

Stateful operator giữ window, aggregate, join hoặc dedup state. Cần checkpoint/snapshot, durable input offsets và restore coordination.

“Exactly-once” luôn có scope. Source, processing state và sink phải phối hợp; external side effect thường vẫn cần idempotency, transaction hoặc dedup.

##### 6.5 Backpressure

Khi consumer xử lý chậm hơn ingest, backlog/lag tăng. Hệ thống cần buffer, autoscale, admission control, degrade/drop policy hoặc replay plan — không thể giả định stream processor luôn bắt kịp.

---

#### 7. Batch hay stream?

| Tiêu chí | Batch | Stream |
|---|---|---|
| **Input** | Bounded dataset/snapshot | Unbounded event flow |
| **Latency** | Phút, giờ hoặc theo lịch | Millisecond tới phút tùy SLO |
| **Throughput** | Tối ưu large scan/aggregation | Tối ưu continuous incremental updates |
| **State/time** | Snapshot/job semantics | Event time, window, watermark, late data |
| **Failure recovery** | Retry job/partition | Replay + checkpoint/state recovery |
| **Use case** | ETL, report, train, backfill | Alert, fraud, monitoring, live feature |
| **Độ phức tạp** | Thường dễ hơn | Cao hơn vì ordering, time, state và continuous ops |

Nhiều hệ thống dùng cả hai:

- stream tạo quyết định/view nhanh;
- batch tính lại authoritative result hoặc train model;
- cùng đọc raw immutable data và dùng common business definitions.

**Fraud detection** thường cần stream scoring để phản ứng nhanh, nhưng batch vẫn dùng để train model, tìm pattern lịch sử, backtest và reconciliation. Stream không thay toàn bộ batch.

##### 7.1 Lambda và Kappa architecture

- **Lambda**: batch layer và speed layer chạy song song rồi merge view; linh hoạt nhưng dễ duplicate logic.
- **Kappa**: coi stream/replay log là nền tảng chính và reprocess bằng replay; đơn giản hóa số pipeline nhưng replay/state/cost vẫn khó.

Đây là mental models, không phải pattern bắt buộc. Unified engines/table formats có thể cho batch và stream dùng chung nhiều logic.

---

#### 8. Storage: HDFS, object storage, warehouse và lakehouse

##### 8.1 HDFS

- distributed filesystem trong cluster;
- data locality với compute trong mô hình truyền thống;
- large sequential/high-throughput workload;
- metadata/data node và cluster operations do đội ngũ quản lý;
- semantics phù hợp hệ Hadoop hơn generic object API.

##### 8.2 Object storage như S3-style systems

- compute và storage tách rời;
- managed elasticity/durability và nhiều storage tiers;
- API/object semantics, không phải HDFS/POSIX;
- nhiều engine có thể đọc cùng data lake;
- request/list/egress/retrieval cost và small-file issue cần quản lý.

##### 8.3 Data warehouse

Warehouse cung cấp managed/optimized SQL analytics, schema/governance và performance features. Nó phù hợp BI và curated datasets nhưng cost/concurrency/load patterns phải được quản lý.

##### 8.4 Data lake

Lake lưu raw và processed files trên distributed/object storage. Nếu thiếu catalog, schema, quality, ownership và lifecycle, nó dễ thành “data swamp”.

##### 8.5 Lakehouse và table format

Lakehouse cố gắng giữ storage mở/giá hợp lý của lake đồng thời thêm table semantics như:

- ACID commit/concurrent writer coordination;
- schema enforcement/evolution;
- snapshots/time travel;
- partition metadata;
- compaction và file management;
- data skipping/pruning tùy implementation.

**Delta Lake** là một table/storage layer dựa trên transaction log và data files trên storage như object store/HDFS. Nó không phải replacement ngang hàng với underlying storage. Apache Iceberg và Apache Hudi là các table-format/lakehouse approaches khác với trade-off riêng.

---

#### 9. File layout, partitioning và query performance

##### 9.1 Row và columnar formats

- JSON/CSV dễ trao đổi/debug nhưng type/schema/scan efficiency hạn chế;
- Avro phù hợp row-oriented serialization/event/data exchange;
- Parquet/ORC lưu theo cột, hỗ trợ compression, column pruning và analytics scan.

##### 9.2 Partitioning

Ví dụ:

```text
events/date=2026-08-20/region=ap-southeast-1/part-....parquet
```

Partition giúp query bỏ qua data không liên quan. Nhưng:

- partition quá thô làm scan nhiều;
- quá mịn tạo nhiều directory/file/metadata;
- high-cardinality partition key gây explosion;
- event-time partition gặp late data;
- skew tạo partition rất lớn hoặc rất nhỏ.

##### 9.3 Partition pruning và predicate pushdown

- partition pruning bỏ hẳn partition không phù hợp filter;
- predicate pushdown dùng file statistics/index để bỏ row groups/pages hoặc chỉ đọc cần thiết;
- column pruning chỉ đọc cột truy vấn.

Các tối ưu chỉ hiệu quả nếu query predicate, statistics và file layout phù hợp.

##### 9.4 Compaction và small files

Streaming/micro-batch dễ tạo nhiều small files. Compaction gộp thành file lớn hơn để giảm metadata/request overhead và tăng scan throughput.

Compaction phải phối hợp transaction/snapshot để không làm reader thấy thiếu/trùng data; đồng thời tốn compute/I/O và cần lifecycle xóa file cũ an toàn.

##### 9.5 Data skew

Một key/partition nhận quá nhiều data làm một task chạy lâu và giữ cả job. Kỹ thuật gồm repartition, salting, skew-aware join, pre-aggregation, split hot key và adaptive execution; mỗi cách ảnh hưởng query/reconciliation.

---

#### 10. Data quality, governance và security

##### 10.1 Schema contract

Producer/consumer cần schema version và compatibility. Schema evolution phải quy định add/remove/rename/type change, default và semantic meaning.

##### 10.2 Quality dimensions

- completeness;
- validity;
- uniqueness;
- consistency;
- timeliness/freshness;
- accuracy;
- referential integrity trong scope phù hợp.

Quality check cần có owner, threshold, alert và quarantine/repair path; không chỉ dashboard màu xanh.

##### 10.3 Lineage và catalog

- catalog cho biết dataset/table/schema/owner/location/classification;
- lineage cho biết data đến từ đâu, qua transform nào, phục vụ output nào;
- lineage hỗ trợ impact analysis, audit, debugging và deletion/compliance.

##### 10.4 Security

- workload/user identity và least privilege;
- encryption in transit/at rest;
- row/column/object-level control tùy system;
- masking/tokenization cho PII;
- audit query/data access;
- tenant isolation;
- retention, legal hold và deletion propagation;
- secret/key management.

##### 10.5 Semantic governance

Hai dashboard có thể tính “active user” khác nhau dù cùng source. Metric definitions, timezone, late-data policy và dimension history phải được version/owned như code.

---

#### 11. Reliability và vận hành pipeline

Một pipeline production cần:

- idempotent ingestion/processing;
- durable offsets/checkpoints;
- retry có backoff và poison-data handling;
- replay/backfill không phá current workload;
- freshness/completeness SLO;
- monitoring source-to-sink lag;
- schema/data-quality alerts;
- lineage và run metadata;
- capacity/headroom cho burst/recovery;
- DR cho metadata/catalog/state, không chỉ raw files;
- cost guardrail và quota.

##### 11.1 Observability nên đo gì?

- ingest rate và rejected records;
- broker lag/oldest event age;
- watermark/event-time delay;
- batch duration và schedule delay;
- task failure/retry/straggler;
- shuffle bytes/spill/skew;
- file count/average size;
- data freshness/completeness/duplicate rate;
- query latency/bytes scanned;
- checkpoint duration/failure;
- compute/storage/egress cost theo pipeline/tenant.

##### 11.2 Backfill

Backfill cần versioned code/schema, bounded date range, idempotent output, isolated resource pool hoặc throttling, validation và atomic publish. Không chạy lại cả lịch sử trực tiếp vào production tables mà không có collision/overwrite plan.

---

#### 12. Thiết kế pipeline xử lý hàng terabyte log mỗi ngày

```text
Applications/agents
   -> broker/managed stream
   -> raw immutable object storage
   -> stream processor -> alerts / live metrics / serving store
   -> batch processor  -> cleaned Parquet/table format
   -> SQL engine/warehouse -> dashboards, investigations
```

##### 12.1 Ingestion

- log/event có timestamp, source, schema version và unique ID;
- partition broker theo service/tenant/key phù hợp ordering;
- compression/batching;
- backpressure và local buffering có giới hạn;
- không để logging làm application hết disk/memory.

##### 12.2 Raw storage

- immutable, partition theo event date/hour và coarse dimensions;
- checksum, retention/lifecycle;
- schema catalog;
- tránh object quá nhỏ bằng batching;
- raw data đủ để replay nhưng vẫn tuân thủ PII/security.

##### 12.3 Stream path

- parse/validate/redact;
- alert/rule/anomaly;
- window/watermark/late-event policy;
- idempotent sink;
- checkpoint và lag SLO.

##### 12.4 Batch path

- dedup, normalize và enrich;
- Parquet/ORC + table format;
- partition pruning và compaction;
- aggregate theo service/customer/use case;
- backfill/reconciliation.

##### 12.5 Query và visualization

- SQL query engine/warehouse cho investigation/BI;
- pre-aggregated serving tables cho dashboards;
- search system cho full-text/interactive log exploration nếu cần;
- quota/workload isolation để một query không quét cả lake ngoài ý muốn.

##### 12.6 Những câu hỏi quyết định

- alert cần trong 1 giây, 1 phút hay 15 phút?
- raw/curated giữ bao lâu?
- search window bao lâu?
- duplicate/lost log chấp nhận mức nào?
- event đến trễ bao lâu?
- tenant nào tạo skew?
- PII cần redact ở source hay ingest?
- replay một ngày mất bao lâu và chi phí bao nhiêu?
- dashboard freshness/completeness SLO là gì?

---

#### 13. Tám câu hỏi phỏng vấn từ tài liệu PDF

**Q1. 5V của Big Data là gì và vì sao quan trọng?**  
Volume, Velocity, Variety, Veracity và Value giúp xác định scale, latency, format, quality và business outcome. Transcript thêm Variability để nhấn mạnh drift/biến động. Framework dùng để hỏi requirement, không phải checklist công nghệ.

**Q2. Vì sao database truyền thống gặp khó với Big Data?**  
Một primary hoặc OLTP schema/query engine có thể bị giới hạn bởi capacity, ingest, large scan, concurrency và cost. Nhưng không nên nói RDBMS không scale được; giải pháp thường là tách OLTP khỏi analytics, dùng partition/distributed compute/storage hoặc warehouse thích hợp.

**Q3. So sánh HDFS và S3-style object storage.**  
HDFS là distributed filesystem gắn với cluster và có data-locality semantics; object storage là API service tách compute/storage, dễ dùng bởi nhiều engine và có cost model request/transfer. Chọn theo deployment, locality, semantics, managed operations, latency, cost và ecosystem — không chỉ “on-prem hay cloud”.

**Q4. Workload nào là Big Data problem?**  
Clickstream, logs, IoT, fraud signals, video, ad bidding và ML có thể là big data khi volume/velocity/variety hoặc processing SLO vượt cách hiện tại. Dataset nhỏ nhưng velocity/complexity cao vẫn có thể là bài toán lớn; petabyte không có value cũng chỉ là chi phí.

**Q5. Batch và stream khác nhau thế nào? Dùng gì cho fraud detection?**  
Batch xử lý bounded dataset với throughput cao và latency lớn hơn; stream xử lý continuous events với event-time/state/recovery complexity. Fraud thường dùng stream để score/alert nhanh và batch để train, backtest, recompute và reconciliation.

**Q6. Delta Lake là gì và cải thiện data lake thế nào?**  
Delta Lake dùng transaction log và data files để thêm ACID table commits, schema enforcement/evolution, snapshot/time travel và file management trên lake storage. Nó giúp concurrent operations đáng tin cậy hơn nhưng không tự giải quyết governance, data quality, access control hay mọi performance problem.

**Q7. Thiết kế hệ thống xử lý hàng terabyte log mỗi ngày thế nào?**  
Dùng durable ingest/broker, raw immutable object storage, stream processor cho alert, batch engine cho ETL/aggregation, columnar/table format cho curated data và query/serving layer theo use case. Bổ sung schema, dedup, late data, security, backfill, freshness SLO và cost controls.

**Q8. Chọn storage và processing framework nào, vì sao?**  
HDFS/object storage/warehouse/lakehouse table theo deployment và query semantics; Spark cho nhiều batch/ETL workloads; Flink/Kafka Streams cho stateful/low-latency stream tùy requirement; Trino/Presto-style engines cho distributed interactive SQL. Tên công cụ đứng sau latency, scale, state, correctness, team skill và operating model.

---

#### 14. Những lỗi tư duy thường gặp

- Định nghĩa Big Data chỉ bằng số TB/PB.
- Thu thập mọi dữ liệu mà không có value, owner hoặc retention.
- Nghĩ velocity cao đồng nghĩa mọi thứ cần real-time.
- Bỏ schema vì dữ liệu đa dạng.
- Đồng nhất Big Data với Hadoop hoặc NoSQL.
- Nói relational database không thể scale ngang.
- Dùng stream cho workload batch đủ đáp ứng, tăng complexity vô ích.
- Gọi micro-batch là “real-time” mà không nêu latency SLO.
- Không phân biệt event time và processing time.
- Bỏ qua late/out-of-order events và watermark policy.
- Tuyên bố exactly-once end-to-end mà không nêu source/state/sink scope.
- Không thiết kế backpressure, replay và checkpoint recovery.
- Dùng cùng business logic riêng biệt ở batch/stream rồi để kết quả lệch nhau.
- Coi data lake chỉ là bucket chứa file.
- Xem Delta Lake là underlying storage ngang hàng với S3/HDFS.
- Partition theo high-cardinality field và tạo hàng triệu partition nhỏ.
- Tạo small files liên tục nhưng không có compaction.
- Chỉ tăng executor mà bỏ qua shuffle/skew/file layout.
- Dùng JSON/CSV cho large analytical scan mà không cân nhắc columnar format.
- Chỉ theo dõi job success, không đo freshness/completeness.
- Backfill không idempotent làm dữ liệu trùng hoặc overwrite sai.
- Dùng dashboard kết quả nhưng không có lineage/metric definition.
- Chỉ tính storage cost, bỏ qua compute, scan, shuffle và egress.

---

#### 15. Big Data design checklist

1. Use case/value và người ra quyết định từ output?
2. 5V/6V: volume, velocity, variety, veracity, value, variability?
3. Ingest average/peak/burst và retention?
4. Business latency/freshness/completeness SLO?
5. Batch, stream hay hybrid; vì sao?
6. Event ID, event time, ordering và duplicate semantics?
7. Schema owner, registry/evolution và compatibility?
8. Broker partition key, retention, replay và backpressure?
9. Raw source of truth và rebuild strategy?
10. Storage: HDFS, object, warehouse hoặc lakehouse table?
11. File format, target size, partitioning và compaction?
12. Query pattern, pruning, bytes scanned và concurrency?
13. Stateful processing, window, watermark và late data?
14. Checkpoint/recovery và exactly-once scope?
15. Data-quality rules, quarantine và reconciliation?
16. Catalog, lineage, ownership và semantic definitions?
17. PII, access control, encryption, audit và deletion?
18. Serving layer cho API/search/dashboard/ML?
19. Backfill/replay isolation, idempotency và atomic publish?
20. Observability từ source tới sink và cost attribution?
21. Capacity/headroom cho burst, failure và recovery?
22. RPO/RTO, metadata recovery và disaster drill?

#### 16. Ý chính cần nhớ

- Big Data là vấn đề tương đối theo workload, SLO, cost và công cụ hiện tại.
- 5V là Volume, Velocity, Variety, Veracity, Value; Variability thường được thêm thành V thứ sáu.
- Big data platform gồm ingest, storage, processing, serving, governance và operations.
- Tách OLTP khỏi large-scale analytics thường quan trọng hơn tranh luận SQL/NoSQL.
- Batch tối ưu bounded historical work; stream tối ưu continuous low-latency work.
- Stream processing phải xử lý event time, window, watermark, late data, state và backpressure.
- Exactly-once luôn cần nêu scope và sink side effects.
- HDFS và object storage có semantics/operating model khác nhau.
- Lake không tự có table semantics; table formats/lakehouse layers bổ sung transaction, schema và snapshots.
- Delta Lake không thay underlying object/distributed storage.
- Columnar formats, partition pruning và compaction quyết định nhiều tới analytics performance.
- Small files, shuffle và skew là bottleneck phổ biến.
- Data quality, lineage, catalog và semantic ownership quan trọng ngang compute.
- Stream cho fraud alert vẫn cần batch train/recompute/reconciliation.
- Raw immutable data và idempotent backfill giúp hệ thống sửa sai/rebuild.
- Giá trị và correctness quan trọng hơn số lượng công nghệ.

#### Công thức ghi nhớ

> **Big Data platform tốt = value/SLO rõ + ingest chịu burst + storage có thể replay + batch/stream đúng latency + dữ liệu có quality/governance + serving hiệu quả + cost/recovery quan sát được.**

---

### Bài 45. Section Summary — Storage and Databases

#### 1. Tư duy cốt lõi của phần Storage

Phần này không nhằm tìm ra một công nghệ lưu trữ “tốt nhất”. Mục tiêu là học cách nhìn **data như một phần của toàn hệ thống** và chọn giải pháp dựa trên:

- bản chất và cấu trúc dữ liệu;
- access pattern đọc/ghi;
- invariant và transaction boundary;
- consistency, durability và availability;
- latency, throughput và quy mô;
- failure/recovery requirement;
- lifecycle, compliance và chi phí;
- khả năng vận hành của đội ngũ.

```text
Business requirement
  -> data + invariant + access pattern
  -> storage interface và data model
  -> consistency/durability/availability contract
  -> scale, replication và partitioning
  -> backup/recovery/lifecycle
  -> đo lường, kiểm thử và vận hành
```

> **Chọn storage là chọn một tập guarantee và trade-off, không chỉ chọn nơi chứa bytes.**

---

#### 2. Những mảnh ghép đã học

##### 2.1 Storage foundations và CAP

- Phân biệt structured, semi-structured và unstructured data.
- Phân biệt database với object, file và block storage.
- Xác định access pattern, source of truth và derived data.
- Hiểu durability, availability, consistency, atomicity và recoverability là các guarantee khác nhau.
- CAP chỉ ép lựa chọn giữa linearizable consistency và CAP availability khi network partition xảy ra.
- CP/AP là behavior theo operation, topology và configuration — không phải nhãn cố định của sản phẩm.
- Replication không thay backup; backup chỉ có ý nghĩa khi restore được.

##### 2.2 SQL và NoSQL

- Relational/SQL mạnh về relation, constraint, transaction, join và query ecosystem.
- NoSQL là một họ gồm document, key-value, wide-column, graph và các model chuyên biệt.
- NoSQL không mặc định schema-less, eventual consistent hoặc không transaction.
- SQL không chỉ scale dọc; relational system vẫn có thể partition, shard và phân tán.
- ACID và BASE không phải hai phía loại trừ nhau.
- Consistency trong ACID khác consistency trong CAP.
- Quyết định phải xuất phát từ invariant và access pattern, không từ xu hướng công nghệ.

##### 2.3 Replication, sharding và polyglot persistence

- Replication tạo nhiều copy của cùng data để tăng availability/read scale.
- Sharding chia dataset để phân tán storage và read/write load.
- Read replica có thể stale và không giải quyết write bottleneck của leader.
- Failover cần election, fencing, routing và recovery procedure.
- Shard key quyết định distribution, locality, hot spot và cross-shard complexity.
- Resharding, scatter–gather và cross-shard transaction là phần chi phí của scale ngang.
- Polyglot persistence chỉ hữu ích khi mỗi store có owner, source of truth và synchronization contract rõ.

##### 2.4 Object storage

- Lưu object bytes cùng key và metadata qua API.
- Bucket/prefix là logical organization; prefix thường không phải directory thật.
- Phù hợp media, backup, archive, data lake và large immutable artifacts.
- Mạnh về durability, scale và aggregate throughput; không tối ưu random in-place mutation.
- Multipart upload, byte range, checksum, CDN và presigned URL là các building blocks quan trọng.
- Versioning/Object Lock hỗ trợ recovery/compliance nhưng không thay backup.
- Lifecycle phải xét request, retrieval, egress và restore latency ngoài giá dung lượng.

##### 2.5 File systems và distributed storage

- Filesystem cung cấp file, directory, metadata và operation semantics trên raw storage.
- DFS trình bày một logical namespace trên nhiều metadata/data nodes.
- Metadata plane và data plane có trách nhiệm khác nhau.
- HDFS tối ưu large sequential/batch workloads; không phải mọi file workload.
- Replication/erasure coding, placement, checksum và repair tạo fault tolerance.
- Metadata scale, small files, rebalancing và hot directories là bottleneck phổ biến.
- POSIX, caching, lease, locking và failover semantics phải được kiểm tra cụ thể.

##### 2.6 Big Data

- Big Data được đánh giá qua Volume, Velocity, Variety, Veracity, Value và có thể thêm Variability.
- Data platform gồm ingestion, storage, batch/stream processing, serving, governance và operations.
- Batch xử lý bounded historical workloads; stream xử lý continuous low-latency events.
- Stream cần event time, window, watermark, late-data, state, checkpoint và backpressure.
- Data lake không tự có table semantics; table format/lakehouse layer bổ sung transaction, schema và snapshot.
- File format, partitioning, compaction, skew và small files ảnh hưởng trực tiếp tới analytics performance.
- Data quality, catalog, lineage và semantic ownership quan trọng ngang compute.

---

#### 3. Bản đồ lựa chọn storage rút gọn

| Nhu cầu chính | Hướng thường cân nhắc | Câu hỏi cần hỏi thêm |
|---|---|---|
| Transaction và relationship phức tạp | Relational database | Isolation, constraints, scale và recovery? |
| Aggregate/document linh hoạt | Document database hoặc relational + JSON | Query, transaction và shard key? |
| Lookup theo key, cache/session | Key-value store | Durability, eviction và source of truth? |
| Write lớn theo partition/access pattern | Wide-column store | Hot partition, consistency và query shape? |
| Traversal quan hệ nhiều bước | Graph database | Graph size, partitioning và transaction? |
| Low-latency DB/VM volume | Block storage | IOPS, latency, attachment và failure model? |
| Shared hierarchy/file semantics | File/network/distributed filesystem | POSIX, locking, metadata scale và HA? |
| Media, backup, archive, raw data lake | Object storage | Consistency, lifecycle, egress và retrieval? |
| Large SQL analytics/BI | Warehouse/lakehouse/OLAP engine | Freshness, concurrency, scan cost và governance? |
| Real-time event processing | Broker + stream processor + serving store | Ordering, window, state và replay? |

Bảng này chỉ là điểm bắt đầu. Một hệ thống thực tế thường kết hợp nhiều lớp, nhưng mỗi lớp phải có vai trò và ownership rõ ràng.

---

#### 4. Quy trình ra quyết định

##### Bước 1 — Bắt đầu từ business requirement

- Dữ liệu phục vụ quyết định/chức năng nào?
- Sai dữ liệu gây hậu quả gì?
- Chậm hoặc unavailable trong bao lâu thì chấp nhận được?
- Luật retention, residency và privacy là gì?

##### Bước 2 — Mô tả dữ liệu

- Entity, relationship, aggregate và lifecycle?
- Record/object/file size và growth?
- Structured, semi-structured hay binary?
- Schema thay đổi ra sao?

##### Bước 3 — Mô tả access pattern

- Point lookup, range scan, join, traversal, full-text search hay aggregation?
- Read/write ratio và peak throughput?
- Hot key/tenant/time range?
- Latency percentile và concurrency?

##### Bước 4 — Xác định guarantee

- Transaction/invariant boundary?
- Strong, session, bounded-staleness hay eventual consistency?
- Durability acknowledgement ở đâu?
- Availability/degraded mode khi partition hoặc dependency lỗi?

##### Bước 5 — Chọn model/interface đơn giản nhất đủ dùng

Ưu tiên một store quen thuộc nếu nó đáp ứng requirement. Chỉ thêm cache, replica, shard, search index, event pipeline hoặc store mới khi bottleneck/use case đủ rõ để biện minh complexity.

##### Bước 6 — Thiết kế failure và recovery

- Replication/failover/fencing?
- Backup/PITR/restore test?
- RPO/RTO?
- Corruption, xóa nhầm và regional failure?
- Rebuild derived data?

##### Bước 7 — Xác minh bằng workload thật

- Benchmark theo data shape và access mix thực tế.
- Thử skew, burst, lag, partition và node failure.
- Đo migration, rebalance, backup và restore.
- Kiểm tra cost theo request, storage, compute và network.

---

#### 5. Những nguyên tắc xuyên suốt

1. **Access pattern trước công nghệ.** Một data model chỉ tốt khi phục vụ đúng các thao tác quan trọng.
2. **Invariant quyết định consistency.** Không phải mọi field cần strong consistency như nhau.
3. **Source of truth phải rõ.** Cache, search index, projection và warehouse thường là derived data.
4. **Replication khác backup.** Một bản sao online thường sao chép cả lỗi logic.
5. **Scale ngang có giá.** Routing, coordination, shard key, rebalance và failure modes đều tăng.
6. **Schema linh hoạt vẫn là schema.** Contract chỉ được chuyển sang application/read path, không biến mất.
7. **Không gắn nhãn sản phẩm tuyệt đối.** Guarantee phụ thuộc operation, deployment và configuration.
8. **Durability khác availability.** Dữ liệu có thể còn nguyên nhưng service tạm không truy cập được, và ngược lại.
9. **Cost là một thuộc tính kiến trúc.** Cần tính compute, I/O, request, retrieval, egress và vận hành.
10. **Recovery phải được diễn tập.** Backup chưa restore-test chỉ là một giả định.
11. **Derived data nên rebuild được.** Có event/log/source và procedure đủ rõ.
12. **Start simple.** Chỉ thêm distributed complexity khi requirement hoặc measurement biện minh được.

---

#### 6. Checklist tổng kết Storage & Databases

1. Dataset nào là source of truth và service nào sở hữu?
2. Data model, schema và relationship?
3. Access pattern và query quan trọng nhất?
4. Transaction/invariant boundary?
5. Consistency theo từng operation?
6. Durability acknowledgement và failure model?
7. Latency, throughput, availability SLO?
8. Capacity, growth, retention và lifecycle?
9. Index/partition/shard key và hot-spot strategy?
10. Replica lag/read routing/failover/fencing?
11. Backup, PITR, RPO/RTO và restore drill?
12. Derived stores, propagation, idempotency và reconciliation?
13. File/object size, format, compaction và small-file risk?
14. Batch/stream latency, state, replay và late-data policy?
15. Encryption, authorization, audit, residency và deletion?
16. Schema evolution, migration, resharding và rollback?
17. Observability cho latency, saturation, lag, skew và recovery?
18. Cost attribution và guardrails?
19. Đội ngũ có đủ khả năng vận hành công nghệ này không?
20. Phương án đơn giản hơn có đáp ứng requirement không?

#### 7. Ý chính cần nhớ

- Storage architecture bắt đầu từ data, invariant và access pattern.
- SQL và NoSQL là các lựa chọn trade-off, không phải đối thủ tuyệt đối.
- Replication, sharding và polyglot persistence là phản ứng với requirement tăng trưởng, không phải mặc định ngày đầu.
- Object storage phù hợp large unstructured/immutable data và API access.
- Distributed filesystem phù hợp shared namespace hoặc high-throughput distributed file workloads.
- Big Data cần distributed storage/processing khi scale, speed hoặc complexity vượt cách hiện tại.
- Batch và stream thường bổ sung cho nhau.
- Quality, governance, security, recovery và cost là một phần của thiết kế dữ liệu.
- Kiến trúc tốt không phải kiến trúc nhiều công nghệ nhất, mà là kiến trúc đáp ứng đúng requirement với complexity có thể kiểm soát.

#### Công thức ghi nhớ

> **Storage architecture tốt = đúng data model + đúng access pattern + guarantee đủ mạnh + scale/recovery có kế hoạch + complexity và cost được kiểm soát.**

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
| **Web session** | Context liên kết nhiều web request với cùng user/browser interaction. |
| **Session ID** | Opaque random identifier dùng để tra session state phía server. |
| **Session cookie** | Cookie không có persistent expiry, thường tồn tại trong browser session. |
| **Persistent cookie** | Cookie có Max-Age/Expires và có thể tồn tại qua browser restart. |
| **Cookie Domain** | Attribute xác định host/subdomain scope mà cookie có thể được gửi tới. |
| **Cookie Path** | Attribute giới hạn URL path mà cookie được gửi kèm. |
| **Secure cookie** | Cookie chỉ được browser gửi qua secure transport như HTTPS. |
| **HttpOnly cookie** | Cookie không thể được đọc qua JavaScript document.cookie. |
| **SameSite** | Cookie attribute kiểm soát việc gửi cookie trong cross-site context. |
| **Idle timeout** | Session hết hạn sau một khoảng không có hoạt động. |
| **Absolute timeout** | Session hết hạn sau thời gian tối đa kể từ lúc tạo/login dù vẫn active. |
| **Session rotation** | Cấp session ID mới và vô hiệu ID cũ tại sự kiện nhạy cảm. |
| **Session fixation** | Tấn công buộc victim dùng session ID attacker đã biết trước authentication. |
| **Session hijacking** | Chiếm session credential để giả mạo user. |
| **CSRF** | Tấn công lợi dụng browser tự gửi credential để thực hiện request ngoài ý muốn của user. |
| **CSRF token** | Giá trị khó đoán được server kiểm tra để xác minh unsafe request đến từ flow hợp lệ. |
| **localStorage** | Browser storage theo origin tồn tại tới khi bị xóa và JavaScript có thể truy cập. |
| **sessionStorage** | Browser storage theo origin/tab session, JavaScript có thể truy cập. |
| **Opaque token** | Token không tự bộc lộ claim; server cần lookup/introspection để hiểu state. |
| **Self-contained token** | Token mang claim và có thể được xác minh mà không cần lookup mỗi request. |
| **Access token** | Credential cho phép client truy cập resource theo scope/audience/thời hạn. |
| **Refresh token** | Credential dùng để xin access token mới, cần bảo vệ và revoke/rotate. |
| **Token introspection** | Cơ chế resource server hỏi authorization server về trạng thái/metadata token. |
| **Token revocation** | Vô hiệu credential/session trước thời điểm hết hạn tự nhiên. |
| **Refresh token rotation** | Thay refresh token sau mỗi lần dùng và vô hiệu token cũ. |
| **Reuse detection** | Phát hiện refresh/session credential cũ bị dùng lại sau rotation. |
| **Single Sign-On** | Cho phép một identity session dùng để đăng nhập nhiều application tin cậy. |
| **Identity Provider** | Hệ thống xác thực danh tính và phát identity/authentication assertions hoặc token. |
| **Step-up authentication** | Yêu cầu xác thực mạnh/bổ sung trước action có rủi ro cao. |
| **Bearer credential** | Credential mà bên sở hữu có thể sử dụng; bị đánh cắp đồng nghĩa có thể bị mạo danh. |
| **BFF token pattern** | Backend-for-Frontend giữ token phía server, browser dùng secure session cookie với BFF. |
| **Serialization** | Chuyển object/data structure thành representation có thể truyền hoặc lưu. |
| **Deserialization** | Đọc serialized representation và dựng thành cấu trúc dữ liệu cho application. |
| **Encoding** | Quy tắc biểu diễn logical data thành text hoặc bytes. |
| **Framing** | Cách xác định ranh giới bắt đầu/kết thúc của message trên stream/storage. |
| **Avro** | Schema-based binary serialization format phổ biến trong data pipeline và event streaming. |
| **BSON** | Binary document representation với richer data types, được MongoDB sử dụng. |
| **JSON Schema** | Cơ chế mô tả và kiểm tra cấu trúc/constraint của JSON document. |
| **Writer schema** | Schema mà producer dùng khi ghi một Avro record. |
| **Reader schema** | Schema mà consumer dùng để đọc và resolve Avro record. |
| **Forward compatibility** | Khả năng reader/consumer cũ xử lý dữ liệu do writer/producer mới tạo. |
| **Full compatibility** | Compatibility theo cả backward và forward direction trong policy đã định. |
| **Wire compatibility** | Hai version vẫn encode/decode được trên wire, chưa chắc giữ đúng business semantics. |
| **Semantic compatibility** | Thay đổi vẫn giữ cách hiểu và hành vi nghiệp vụ mà consumer kỳ vọng. |
| **Insecure deserialization** | Deserialization dữ liệu không tin cậy theo cách có thể tạo object/hành vi nguy hiểm. |
| **Data fidelity** | Mức độ dữ liệu giữ nguyên giá trị, kiểu, precision và ý nghĩa qua round-trip. |
| **Same-Origin Policy** | Browser policy cô lập document/script theo origin và hạn chế cross-origin data access. |
| **Simple request** | Cross-origin request thỏa CORS safelist nên được gửi mà không cần preflight trước. |
| **Preflight request** | `OPTIONS` request để browser hỏi server về method/header của actual cross-origin request. |
| **CORS-safelisted request header** | Nhóm request header/value được phép trong simple CORS request theo điều kiện của chuẩn. |
| **Access-Control-Allow-Origin** | Response header chỉ origin mà browser được phép chia sẻ response. |
| **Access-Control-Allow-Methods** | Preflight response header liệt kê method được phép. |
| **Access-Control-Allow-Headers** | Preflight response header liệt kê request header được phép gửi. |
| **Access-Control-Allow-Credentials** | Response header cho phép browser expose credentialed CORS response khi policy hợp lệ. |
| **Access-Control-Expose-Headers** | Response header liệt kê custom response header mà JavaScript được phép đọc. |
| **Access-Control-Max-Age** | Thời gian browser có thể cache kết quả preflight. |
| **Vary: Origin** | Chỉ dẫn cache rằng response representation/header phụ thuộc request `Origin`. |
| **Credentialed request** | Request có browser credential như cookie hoặc HTTP authentication information. |
| **Origin allowlist** | Danh sách origin được kiểm tra chính xác trước khi cấp CORS access. |
| **Opaque origin** | Origin không có tuple scheme-host-port thông thường và có thể serialize thành `null`. |
| **JSONP** | Kỹ thuật legacy tải cross-origin data như script; không phù hợp API hiện đại. |
| **Content Security Policy** | Response policy giới hạn nguồn và hành vi resource/script để giảm các lớp tấn công như XSS. |
| **Cross-Origin Resource Policy** | Header cho resource khai báo phạm vi cross-origin có thể tải/nhúng tài nguyên. |
| **Cross-Origin Opener Policy** | Policy cô lập browsing context khỏi cross-origin opener. |
| **Cross-Origin Embedder Policy** | Policy yêu cầu resource nhúng đáp ứng điều kiện cross-origin phù hợp. |
| **Fetch Metadata** | Nhóm `Sec-Fetch-*` header mô tả context của request để server áp dụng policy. |
| **Diagonal scaling** | Chiến lược phối hợp tăng kích thước node và tăng số node theo workload hoặc giai đoạn. |
| **Scale down** | Giảm resource của một node theo hướng vertical scaling. |
| **Scale in** | Giảm số node hoặc instance trong horizontal scaling. |
| **Capacity planning** | Dự báo demand và xác định resource/headroom cần để giữ SLO. |
| **Safety factor** | Hệ số dự phòng dùng khi tính capacity cho biến động và bất định. |
| **Safe capacity** | Mức tải một resource xử lý được trong khi vẫn giữ SLO, không phải ngưỡng tối đa trước khi lỗi. |
| **Time-to-scale** | Thời gian từ lúc phát hiện nhu cầu đến khi capacity mới thực sự nhận tải. |
| **Diminishing returns** | Hiện tượng thêm resource nhưng lợi ích biên giảm do phần tuần tự, contention hoặc coordination. |
| **Coordination overhead** | Chi phí giao tiếp và đồng bộ giữa các node khi hệ thống phân tán. |
| **Marginal cost** | Chi phí phát sinh để có thêm một đơn vị capacity hoặc output. |
| **Traffic spike** | Mức tải tăng đột ngột trong khoảng thời gian ngắn. |
| **Noisy neighbor** | Workload/tenant dùng quá nhiều shared resource và làm workload khác suy giảm. |
| **Round robin algorithm** | Phân phối connection/request luân phiên qua các backend khỏe. |
| **Weighted round robin** | Round robin có trọng số để backend/pool nhận tỷ lệ traffic khác nhau. |
| **Least connections** | Chọn backend có ít active connection hơn tại thời điểm quyết định. |
| **Least outstanding requests** | Chọn backend có ít request/work chưa hoàn tất hơn. |
| **Least response time** | Ưu tiên backend có observed latency thấp theo policy đo và làm mượt. |
| **Power of Two Choices** | Lấy ngẫu nhiên hai backend rồi chọn backend có load thấp hơn. |
| **IP hash** | Ánh xạ client IP qua hàm hash để chọn backend và tạo affinity tương đối. |
| **Consistent hashing** | Hash scheme giảm số key bị remap khi backend membership thay đổi. |
| **Rendezvous hashing** | Chọn node có score hash cao nhất cho key, hỗ trợ membership change với remapping hạn chế. |
| **Adaptive load balancing** | Điều chỉnh lựa chọn backend dựa trên runtime signal như latency, error hoặc load. |
| **Active health check** | Probe chủ động, định kỳ để đánh giá backend có sẵn sàng không. |
| **Passive health check** | Suy ra backend health từ kết quả traffic thật như timeout, reset hoặc lỗi. |
| **Outlier detection** | Nhận diện và tạm eject backend có hành vi lệch xấu đáng kể khỏi pool. |
| **Health-check hysteresis** | Dùng threshold/window khác nhau để tránh backend flap liên tục giữa healthy và unhealthy. |
| **Slow start** | Tăng traffic/weight dần cho backend mới hoặc vừa hồi phục trong thời gian warm-up. |
| **Global load balancing** | Steering traffic giữa nhiều region/edge endpoint theo health, locality, capacity hoặc policy. |
| **Internal load balancer** | Load balancer chỉ cung cấp private/internal endpoint trong network. |
| **Direct Server Return** | Mô hình LB xử lý inbound selection nhưng backend trả response trực tiếp theo thiết kế mạng. |
| **Proxy Protocol** | Protocol truyền metadata connection gốc như client address qua proxy tới backend. |
| **Forwarded header** | HTTP header chuẩn hóa mang thông tin proxy như client, host và scheme gốc. |
| **Reactive scaling** | Điều chỉnh capacity sau khi metric hiện tại vượt hoặc rời target. |
| **Scheduled scaling** | Điều chỉnh capacity theo lịch demand đã biết trước. |
| **Predictive scaling** | Dự báo demand từ dữ liệu lịch sử để provision capacity trước tải. |
| **Event-driven scaling** | Scale worker/workload dựa trên nguồn work như queue, topic hoặc event stream. |
| **Target tracking** | Policy điều chỉnh capacity để giữ một metric gần target mong muốn. |
| **Step scaling** | Policy thay đổi capacity theo các mức tương ứng độ lệch của metric. |
| **Scaling policy** | Tập signal, target, limit và rule quyết định khi nào/cách thay capacity. |
| **Desired capacity** | Mức capacity controller đang cố gắng duy trì. |
| **Minimum capacity** | Baseline capacity autoscaler không được giảm thấp hơn. |
| **Maximum capacity** | Giới hạn capacity autoscaler không được vượt quá. |
| **Cooldown** | Khoảng chờ sau scaling action nhằm hạn chế phản ứng liên tiếp quá sớm. |
| **Warm-up period** | Thời gian instance mới cần trước khi cung cấp full usable capacity. |
| **Stabilization window** | Cửa sổ dùng recommendation lịch sử để tránh scaling dao động quá nhanh. |
| **Autoscaling oscillation** | Capacity liên tục tăng giảm do signal, policy hoặc reaction lag không ổn định. |
| **Scale-to-zero** | Giảm workload về không instance khi idle rồi tạo lại khi có demand. |
| **Cold start** | Độ trễ khởi tạo execution environment/application trước khi xử lý work đầu tiên. |
| **Right-sizing** | Chọn resource size phù hợp workload, SLO và cost thay vì over/under-provision. |
| **Spot capacity** | Cloud capacity giá thấp hơn nhưng có thể bị provider thu hồi với thông báo hạn chế. |
| **Auto-healing** | Tự phát hiện và thay thế/restart resource không khỏe để giữ desired state. |
| **Provisioning lag** | Thời gian từ quyết định scale tới lúc resource mới được tạo và sẵn sàng. |
| **Queue age** | Thời gian một item đã chờ trong queue, phản ánh latency/backlog pressure. |
| **Unit economics** | Chi phí trên một đơn vị business/output như request, order, user hoặc event. |
| **Runaway scaling** | Autoscaler tăng capacity mất kiểm soát do signal/policy lỗi hoặc vòng khuếch đại. |
| **Manual override** | Cơ chế operator tạm thay quyết định tự động khi sự cố hoặc bảo trì. |
| **Linear scalability** | Trường hợp lý tưởng trong đó throughput tăng gần tỷ lệ với resource trong một phạm vi. |
| **Scalability efficiency** | Tỷ lệ speedup thực tế so với speedup tuyến tính lý tưởng khi tăng resource. |
| **Active-active** | Nhiều instance/tier cùng chủ động phục vụ traffic tại một thời điểm. |
| **Active-passive** | Một instance/tier phục vụ, phần standby tiếp quản khi active lỗi. |
| **Tiered caching** | Tổ chức nhiều lớp cache như client, edge, application và distributed cache. |
| **FaaS** | Function as a Service, mô hình chạy function theo event/request dưới nền tảng managed. |
| **Horizontal Pod Autoscaler** | Kubernetes controller điều chỉnh số pod theo resource, custom hoặc external metrics. |
| **Cluster autoscaler** | Controller điều chỉnh số node của cluster khi workload cần thêm hoặc bớt scheduling capacity. |
| **Pending pod** | Pod chưa được scheduler đặt lên node, thường do thiếu resource hoặc constraint không thỏa. |
| **Committed capacity** | Capacity được cam kết trước để đổi lấy economics ổn định hơn, kèm ràng buộc sử dụng/thời hạn. |
| **Structured data** | Dữ liệu có schema, type và field được tổ chức rõ ràng. |
| **Semi-structured data** | Dữ liệu có key/tag/shape nhưng schema có thể linh hoạt giữa record. |
| **Unstructured data** | Nội dung không thuận tiện truy vấn trực tiếp bằng schema field cố định như ảnh hoặc video. |
| **Persistence** | Khả năng state tồn tại ngoài lifetime của process, session hoặc request. |
| **Durability** | Guarantee rằng acknowledged data sống qua failure trong failure model đã cam kết. |
| **Object storage** | Storage lưu object bytes và metadata theo key, thường truy cập qua API. |
| **File storage** | Storage cung cấp hierarchy file/directory cùng filesystem semantics. |
| **Block storage** | Storage trình bày raw blocks/volume để filesystem hoặc database quản lý layout. |
| **Blob** | Binary Large Object, khối dữ liệu nhị phân như media hoặc document. |
| **Access pattern** | Cách workload đọc, ghi, scan, cập nhật và phân bố truy cập dữ liệu. |
| **IOPS** | Số I/O operation hoàn tất mỗi giây với workload/block-size cụ thể. |
| **Recoverability** | Khả năng phục hồi đúng state và service sau failure hoặc lỗi logic. |
| **Snapshot** | Ảnh chụp state tại một thời điểm theo semantics của storage. |
| **Backup** | Bản sao phục vụ recovery, thường độc lập và giữ theo retention policy. |
| **Point-in-time recovery** | Khả năng restore dữ liệu tới một thời điểm nhờ backup và change/transaction logs. |
| **RPO** | Recovery Point Objective, lượng dữ liệu theo thời gian có thể chấp nhận mất. |
| **RTO** | Recovery Time Objective, thời gian tối đa mong muốn để phục hồi dịch vụ. |
| **Hot storage** | Tier cho dữ liệu truy cập thường xuyên với latency thấp. |
| **Warm storage** | Tier trung gian cho dữ liệu ít truy cập hơn với cost/latency cân bằng. |
| **Cold storage** | Tier rẻ cho dữ liệu hiếm truy cập, thường có retrieval delay hoặc fee. |
| **Source of truth** | Nguồn state có thẩm quyền khi nhiều copy/view khác nhau tồn tại. |
| **Derived data** | Dữ liệu như cache/index/projection được tạo từ source of truth và có thể rebuild. |
| **CAP theorem** | Giới hạn giữa linearizable consistency và CAP availability khi distributed system bị partition. |
| **Network partition** | Tình trạng các nhóm node không thể trao đổi message tin cậy trong time window liên quan. |
| **CAP consistency** | Single-copy/linearizable behavior trong mô hình CAP. |
| **CAP availability** | Mọi request tới non-failing node cuối cùng nhận non-error response trong mô hình CAP. |
| **Partition tolerance** | Hệ thống có behavior được định nghĩa dù message giữa các nhóm node bị mất/trì hoãn. |
| **CP behavior** | Khi partition, hy sinh availability của một số operation để giữ consistency. |
| **AP behavior** | Khi partition, tiếp tục đáp ứng nhưng cho phép stale/divergent state cần hội tụ. |
| **Linearizability** | Operation trông như xảy ra atomically theo một thứ tự real-time hợp lệ trên một bản sao logic. |
| **PACELC** | Mô hình: khi partition chọn A/C; khi bình thường thường đánh đổi latency với consistency. |
| **Conflict resolution** | Quy tắc phát hiện, merge hoặc chọn kết quả khi replica có thay đổi xung đột. |
| **Data lifecycle** | Các giai đoạn tạo, dùng, tier, archive, retain và delete dữ liệu. |
| **Relational model** | Mô hình dữ liệu tổ chức thông tin thành các relation và dùng key/constraint để biểu diễn liên hệ. |
| **SQL** | Structured Query Language, ngôn ngữ khai báo để định nghĩa, truy vấn và thao tác dữ liệu; không đồng nhất hoàn toàn với relational model. |
| **Primary key** | Thuộc tính hoặc nhóm thuộc tính định danh duy nhất một row. |
| **Foreign key** | Constraint/tham chiếu liên kết giá trị ở một relation với key của relation khác. |
| **Referential integrity** | Guarantee rằng reference giữa các relation tuân theo quy tắc tồn tại/cập nhật/xóa đã định. |
| **Normalization** | Tổ chức relation theo dependency để giảm lặp dữ liệu và update anomaly. |
| **Denormalization** | Lặp hoặc tính sẵn dữ liệu có chủ đích để tối ưu access pattern, đổi lại cần quản lý consistency. |
| **Schema-on-write** | Kiểm tra/áp schema khi dữ liệu được ghi vào store. |
| **Schema-on-read** | Diễn giải/áp schema khi dữ liệu được đọc hoặc xử lý. |
| **ACID** | Atomicity, Consistency, Isolation, Durability — nhóm thuộc tính của transaction. |
| **ACID consistency** | Transaction giữ các constraint/invariant đã định; khác CAP consistency. |
| **Isolation level** | Mức guarantee quy định các transaction đồng thời có thể quan sát và ảnh hưởng lẫn nhau ra sao. |
| **BASE** | Mnemonic: Basically Available, Soft State, Eventually Consistent; không phải đối cực loại trừ của ACID. |
| **Document database** | Database lưu aggregate dưới dạng document có field và cấu trúc lồng nhau. |
| **Key-value database** | Database truy cập value chủ yếu thông qua một key. |
| **Wide-column database** | Database phân tán tổ chức dữ liệu quanh row/partition key và column family, thường model theo access pattern. |
| **Columnar database** | Database phân tích lưu giá trị theo cột để tối ưu scan, compression và aggregation. |
| **Graph database** | Database biểu diễn entity bằng node và quan hệ bằng edge để tối ưu traversal. |
| **JSONB** | Kiểu lưu JSON dạng nhị phân có thể index/query trong PostgreSQL. |
| **Replication** | Duy trì nhiều bản sao của cùng logical data trên các node/failure domain. |
| **Leader–follower replication** | Một leader nhận/sắp thứ tự write rồi truyền thay đổi tới các follower. |
| **Read replica** | Replica chủ yếu phục vụ read để giảm tải primary, có thể trả dữ liệu stale. |
| **Replication lag** | Khoảng cách về thời gian/log position giữa source và replica đã nhận hoặc apply. |
| **Synchronous replication** | Chỉ acknowledge write sau khi số replica yêu cầu đạt mốc nhận/durable đã định. |
| **Asynchronous replication** | Acknowledge write trước khi replica bắt kịp, đổi latency thấp hơn lấy lag/data-loss window. |
| **Fencing** | Cơ chế ngăn leader/worker cũ tiếp tục ghi sau khi authority đã chuyển sang bên mới. |
| **Split-brain** | Nhiều node cùng tin mình có quyền leader/writer và tạo các lịch sử dữ liệu xung đột. |
| **Sharding** | Chia dataset ngang qua nhiều database node/instance để phân tán storage và traffic. |
| **Shard key** | Thuộc tính dùng để xác định shard sở hữu một record/entity. |
| **Range-based sharding** | Chia key space thành các khoảng liên tiếp, giữ locality nhưng có thể tạo skew/hot range. |
| **Hash-based sharding** | Dùng hash của key để phân bố dữ liệu, thường đều hơn nhưng làm range query khó hơn. |
| **Directory-based sharding** | Dùng catalog tra mapping entity/tenant tới shard để placement linh hoạt. |
| **Geo-sharding** | Đặt/chia dữ liệu theo vùng địa lý nhằm phục vụ latency, residency hoặc fault isolation. |
| **Scatter–gather query** | Fan-out query tới nhiều shard rồi thu và hợp nhất kết quả. |
| **Resharding** | Thay partition ownership/boundary và di chuyển dữ liệu khi topology hoặc tải thay đổi. |
| **Rebalancing** | Phân phối lại data/load giữa node hoặc shard để khôi phục cân bằng. |
| **Multi-leader replication** | Nhiều leader nhận write và sau đó đồng bộ, đòi hỏi conflict semantics rõ. |
| **Leaderless replication** | Read/write qua nhiều replica theo quorum/coordination thay vì một leader duy nhất. |
| **Data residency** | Yêu cầu dữ liệu phải được lưu hoặc xử lý trong location/jurisdiction nhất định. |
| **Bucket** | Logical container/namespace chứa object và thường là policy/configuration boundary. |
| **Object key** | Identifier dùng để định vị object trong bucket; có thể chứa dấu `/` nhưng không nhất thiết tạo directory thật. |
| **Object prefix** | Phần đầu chung của key dùng để group/list/policy object theo logic. |
| **Object metadata** | System hoặc application attributes mô tả object, tách khỏi payload bytes. |
| **Storage class** | Tier có profile khác nhau về availability, access latency, retrieval và cost. |
| **Lifecycle rule** | Policy tự động transition hoặc expire object/version theo tuổi, tag hoặc điều kiện. |
| **Presigned URL** | URL được ký để cấp quyền tạm thời cho operation cụ thể trên object. |
| **Multipart upload** | Upload object lớn thành nhiều part có thể truyền/retry song song rồi complete. |
| **Byte-range request** | Request chỉ đọc một khoảng byte của object/resource. |
| **Object versioning** | Giữ nhiều version của cùng object key để hỗ trợ recovery và history. |
| **Delete marker** | Marker biểu thị logical delete trong versioned bucket mà chưa nhất thiết xóa version cũ. |
| **Object Lock** | Cơ chế retention/immutability ngăn object version bị xóa hoặc ghi đè theo policy. |
| **WORM** | Write Once Read Many, dữ liệu sau khi ghi không được sửa/xóa trong thời hạn quy định. |
| **Legal hold** | Giữ object khỏi bị xóa cho tới khi hold được gỡ bởi quyền thích hợp, độc lập với thời hạn thông thường. |
| **Server-side encryption** | Storage service mã hóa object at rest sau khi nhận dữ liệu. |
| **KMS** | Key Management Service, hệ thống quản lý key và operation mật mã cùng policy/audit. |
| **Network egress** | Dữ liệu truyền ra khỏi provider/region/boundary và thường phát sinh phí. |
| **Retrieval fee** | Phí đọc/khôi phục dữ liệu từ một số storage class, đặc biệt tier lạnh. |
| **Data lake** | Kho lưu raw/curated datasets quy mô lớn để nhiều engine xử lý và phân tích. |
| **Erasure coding** | Mã hóa dữ liệu thành data/parity fragments để chịu mất một số fragment với overhead thấp hơn full replication. |
| **Small-object problem** | Overhead request/metadata/list và cost tăng cao khi lưu số lượng rất lớn object quá nhỏ. |
| **File system** | Lớp tổ chức raw storage thành file, directory, metadata và operation semantics. |
| **Distributed file system** | Filesystem cung cấp logical namespace trên nhiều node và phối hợp metadata/data phân tán. |
| **Network file system** | Filesystem/share được client truy cập qua mạng, ví dụ thông qua NFS hoặc SMB. |
| **POSIX semantics** | Tập hành vi file/process API theo chuẩn POSIX; mức hỗ trợ thực tế cần kiểm tra theo filesystem. |
| **Inode** | Cấu trúc metadata của file trong nhiều Unix-like filesystem, tách khỏi filename/directory entry. |
| **Journaling** | Ghi log thay đổi filesystem để hỗ trợ khôi phục cấu trúc nhất quán sau crash. |
| **Metadata server** | Thành phần quản lý namespace, attribute và mapping từ file tới data location. |
| **NameNode** | Metadata coordinator của HDFS, quản namespace và block mapping/location. |
| **DataNode** | Storage worker của HDFS, lưu block và phục vụ client data I/O. |
| **Block report** | Báo cáo định kỳ từ DataNode về tập block nó đang lưu. |
| **Replication factor** | Số bản sao mong muốn của một block/chunk trong replication policy. |
| **Rack awareness** | Placement/scheduling có hiểu network và failure domain theo rack. |
| **Data locality** | Đặt/chạy compute gần nơi dữ liệu nằm để giảm network transfer và tăng throughput. |
| **Small-file problem** | Metadata/RPC/task overhead cao khi filesystem hoặc analytics engine xử lý quá nhiều file nhỏ. |
| **Write pipeline** | Chuỗi node/step mà data và acknowledgement đi qua khi ghi/replicate. |
| **Lease** | Quyền có thời hạn cho client/writer; cần expiry/recovery và thường kết hợp fencing. |
| **Re-replication** | Tạo thêm replica để khôi phục replication level sau failure hoặc placement change. |
| **CephFS** | Distributed filesystem interface trong hệ sinh thái Ceph. |
| **HDFS** | Hadoop Distributed File System, tối ưu lịch sử cho large sequential data và batch analytics. |
| **GlusterFS** | Scale-out distributed filesystem cung cấp shared file namespace. |
| **Parquet** | Columnar file format phổ biến cho analytics, hỗ trợ compression và column pruning. |
| **ORC** | Optimized Row Columnar, columnar file format cho analytics/big-data workloads. |
| **Big Data** | Bài toán dữ liệu có scale, speed hoặc complexity vượt cách xử lý hiện tại theo SLO/cost. |
| **Volume** | Khối lượng và tốc độ tăng của dữ liệu cần lưu/xử lý. |
| **Velocity** | Tốc độ dữ liệu được tạo, đến và cần được xử lý. |
| **Variety** | Độ đa dạng về nguồn, format, schema và kiểu dữ liệu. |
| **Veracity** | Mức độ đúng, đủ, nhất quán và đáng tin cậy của dữ liệu. |
| **Value** | Giá trị business/sản phẩm/insight thu được từ dữ liệu. |
| **Variability** | Mức biến động của traffic, distribution, schema hoặc ý nghĩa dữ liệu theo thời gian/context. |
| **Batch processing** | Xử lý bounded dataset hoặc snapshot theo job/lịch, thường tối ưu throughput. |
| **Stream processing** | Xử lý continuous unbounded events với latency thấp và state/time semantics. |
| **Processing time** | Thời điểm processing engine xử lý event. |
| **Ingestion time** | Thời điểm event được platform/broker tiếp nhận. |
| **Window** | Cách chia unbounded stream thành phạm vi hữu hạn để aggregate/join. |
| **Watermark** | Ước lượng tiến độ event time dùng để quyết định emit/close window và xử lý late data. |
| **Late event** | Event đến processor sau watermark/cửa sổ kỳ vọng của event time. |
| **Backpressure** | Cơ chế/tình trạng downstream chậm khiến upstream phải giảm tốc, buffer hoặc áp dụng policy. |
| **MapReduce** | Processing model gồm map, shuffle/group và reduce trên dữ liệu phân tán. |
| **Shuffle** | Trao đổi/repartition dữ liệu giữa workers theo key hoặc partition boundary. |
| **Straggler** | Task/partition chậm bất thường làm kéo dài completion time của stage/job. |
| **Apache Spark** | Distributed processing engine dùng DAG/stages/tasks cho batch, SQL, streaming và workload khác. |
| **Apache Flink** | Distributed engine tập trung vào stateful stream processing và cũng hỗ trợ bounded data. |
| **Kafka Streams** | Client library xử lý stream dựa trên Kafka topics, partition và local state. |
| **Data warehouse** | Hệ thống quản lý/compute dữ liệu đã tổ chức để phục vụ SQL analytics và BI. |
| **Lakehouse** | Kiến trúc kết hợp data-lake storage với table/transaction/governance semantics gần warehouse. |
| **Table format** | Metadata/protocol tổ chức data files thành table có snapshot, schema và commit semantics. |
| **Delta Lake** | Table/storage layer dùng transaction log và data files để thêm ACID table semantics trên data lake. |
| **Time travel** | Đọc table/dataset tại snapshot hoặc version lịch sử còn được retention. |
| **Schema enforcement** | Chặn/kiểm soát write không tuân schema/constraint đã khai báo. |
| **ETL** | Extract, Transform, Load: biến đổi trước khi nạp vào target chính. |
| **ELT** | Extract, Load, Transform: nạp raw trước rồi biến đổi trong analytical platform. |
| **Data catalog** | Inventory metadata về dataset, schema, owner, location và classification. |
| **Data lineage** | Quan hệ nguồn–biến đổi–đích cho biết dữ liệu được tạo và sử dụng thế nào. |
| **Partition pruning** | Bỏ qua toàn bộ partition không thỏa filter khi query. |
| **Predicate pushdown** | Đẩy filter xuống storage/scan layer để bỏ dữ liệu sớm. |
| **Compaction** | Gộp/rewrite nhiều file/segment nhỏ thành layout hiệu quả hơn theo transaction/snapshot semantics. |
