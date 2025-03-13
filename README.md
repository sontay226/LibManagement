
Đề bài: Hệ thống quản lý thư viện
Mô tả: Xây dựng một hệ thống quản lý thư viện cho phép người dùng thực hiện các thao tác liên quan đến mượn sách, trả sách, tìm kiếm sách và quản lý phí trễ hạn. Hệ thống cũng cần hỗ trợ việc lưu trữ thông tin về các sách, người dùng và quản lý các giao dịch mượn trả sách.
Tính năng:
    1. Quản lý sách:
        ◦ Lưu trữ thông tin về sách: tên sách, tác giả, thể loại, số lượng sách còn lại, mã sách duy nhất.
        ◦ Cho phép thêm mới sách, xóa sách khỏi hệ thống và cập nhật thông tin sách (số lượng, tên, tác giả).
    2. Quản lý người dùng:
        ◦ Lưu trữ thông tin về người dùng: tên, địa chỉ, số điện thoại, mã người dùng duy nhất.
        ◦ Thêm mới người dùng, cập nhật thông tin người dùng.
        ◦ Tìm kiếm người dùng theo mã người dùng hoặc tên.
    3. Quản lý giao dịch mượn sách:
        ◦ Mỗi giao dịch mượn sách cần ghi lại thông tin: người mượn, sách mượn, ngày mượn, ngày trả dự kiến.
        ◦ Người dùng có thể mượn nhiều sách trong một lần giao dịch.
        ◦ Giao dịch mượn sách không thể mượn khi không còn sách trong kho.
    4. Quản lý trả sách và phí trễ hạn:
        ◦ Khi người dùng trả sách, hệ thống kiểm tra nếu quá hạn và tính phí trễ hạn. Phí trễ hạn là một mức phí cố định mỗi ngày trễ.
        ◦ Tính phí trễ hạn cho từng sách trong một giao dịch trả.
    5. Lưu trữ và báo cáo giao dịch:
        ◦ Lưu trữ tất cả giao dịch mượn và trả sách.
        ◦ Cho phép xuất báo cáo về sách đã mượn, sách còn lại trong kho, phí trễ hạn của mỗi người dùng trong tháng.
    6. Các loại sách:
        ◦ Sách thông thường: Mỗi cuốn sách có số lượng sách còn lại và không có phí mượn sách.
        ◦ Sách hiếm: Sách này có phí mượn riêng và số lượng chỉ có chục cuốn duy nhất trong thư viện.
Yêu cầu kỹ thuật:
    1. Các tính năng mở rộng:
        ◦ Quản lý đặt sách trước: Cho phép người dùng đặt trước sách mà họ muốn mượn khi sách hết.
        ◦ Tính năng tìm kiếm sách nâng cao: Tìm kiếm sách theo tên, tác giả, thể loại hoặc mã sách.
    2. Báo cáo nâng cao:
        ◦ Phát triển báo cáo cho phép xuất thống kê về lượng sách mượn theo thể loại, phí trễ hạn của mỗi người dùng trong một khoảng thời gian (tuần/tháng).
Yêu cầu bổ sung:
    1. Giới hạn số sách mượn: Mỗi người dùng chỉ được mượn tối đa 5 cuốn sách cùng một lúc.
    2. Hạn chế trễ hạn: Một người dùng có thể bị đình chỉ việc mượn sách trong một khoảng thời gian nếu số lần trễ hạn vượt quá giới hạn quy định (ví dụ, quá 3 lần trong một tháng).

Directory Structure
LibraryManagement
├─ pom.xml
└─ src
   └─ main
      ├─ java
      │   ├─ Entities
      │   │   └─ ...
      │   ├─ Repository
      │   │   ├─ Interface
      │   │   │   └─ ...
      │   │   └─ Implement
      │   │       ├─ InMemory
      │   │       │   └─ ...
      │   │       └─ SqlImplement
      │   │           └─ ...
      │   ├─ Services
      │   │   └─ ...
      │   └─ Main.java
      └─ resources
          └─ ...

