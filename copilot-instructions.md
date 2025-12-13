# Hướng dẫn sử dụng GitHub Copilot cho dự án Ngọc Rồng Online (NRO)

## Mô tả dự án

Đây là dự án game Ngọc Rồng Online (NRO) được phát triển bằng Java thuần túy, mô phỏng lại trò chơi đã ngừng hoạt động vào năm 2019.

### Tính năng chính
- Hệ thống chiến đấu
- Hệ thống nhiệm vụ
- Hệ thống bang hội
- Hệ thống trang bị và kỹ năng nhân vật
- Giao diện đồ họa đơn giản và thân thiện

## Mục tiêu dự án

- Sửa bug và cải thiện hiệu suất của trò chơi
- Thêm các tính năng mới và nội dung hấp dẫn cho người chơi
- Tạo ra một cộng đồng người chơi năng động và gắn kết
- Học hỏi và áp dụng các kỹ thuật lập trình game hiện đại

## Yêu cầu khi gợi ý mã nguồn

### 1. Phân tích dự án trước khi gợi ý

Trước khi đưa ra bất kỳ gợi ý nào, Copilot cần:
- Xem xét toàn bộ cấu trúc dự án
- Hiểu rõ phong cách code hiện tại
- Đảm bảo gợi ý phù hợp với kiến trúc đã có
- Tham khảo các file code liên quan để giữ tính nhất quán

### 2. Tuân thủ các nguyên tắc lập trình

**SOLID Principles:**
- **S**ingle Responsibility: Mỗi class chỉ nên có một trách nhiệm duy nhất
- **O**pen/Closed: Mở cho mở rộng, đóng cho sửa đổi
- **L**iskov Substitution: Các class con có thể thay thế class cha mà không làm thay đổi tính đúng đắn
- **I**nterface Segregation: Chia nhỏ interface thành các interface cụ thể hơn
- **D**ependency Inversion: Phụ thuộc vào abstraction, không phụ thuộc vào implementation cụ thể

**Clean Code:**
- Tên biến, hàm, class phải có ý nghĩa và dễ hiểu
- Hàm ngắn gọn, chỉ làm một việc
- Tránh code lặp (DRY - Don't Repeat Yourself)
- Code dễ đọc hơn là dễ viết
- Xử lý exception một cách rõ ràng và có ý nghĩa

**Best Practices:**
- Sử dụng design patterns phù hợp
- Tối ưu hóa performance (tránh nested loops không cần thiết, sử dụng cấu trúc dữ liệu phù hợp)
- Đảm bảo thread-safety khi cần thiết (game server thường là multi-threaded)
- Quản lý tài nguyên đúng cách (đóng connections, streams, etc.)
- Validate input từ client để tránh lỗi và tấn công

### 3. Chú thích code rõ ràng và đầy đủ

**Yêu cầu về comments:**
- Mỗi class phải có Javadoc mô tả mục đích và chức năng
- Các phương thức public phải có Javadoc giải thích:
  - Mục đích của phương thức
  - Các tham số đầu vào (@param)
  - Giá trị trả về (@return)
  - Các exception có thể throw (@throws)
- Comments inline cho các đoạn logic phức tạp
- Sử dụng tiếng Việt có dấu trong comments để dễ hiểu

**Ví dụ:**
```java
/**
 * Xử lý logic tấn công của nhân vật
 * 
 * @param attacker Nhân vật tấn công
 * @param target Nhân vật bị tấn công
 * @param skill Kỹ năng sử dụng
 * @return Damage gây ra
 * @throws IllegalArgumentException nếu tham số null
 */
public int processAttack(Player attacker, Player target, Skill skill) {
    // Validate tham số đầu vào
    // Tính toán damage dựa trên stats của attacker, target và skill
    // Kiểm tra các buff/debuff ảnh hưởng đến damage
    // Áp dụng damage lên target và cập nhật HP
    // Ghi log và gửi thông báo đến client
    return calculatedDamage;
}
```

### 4. Kiểm tra kỹ lưỡng

Trước khi đưa ra gợi ý, cần:
- Đảm bảo code compile được
- Không gây conflict với code hiện có
- Không phá vỡ các chức năng đang hoạt động
- Xem xét các edge cases và xử lý lỗi
- Kiểm tra null safety
- Đảm bảo không có memory leaks

### 5. Tối ưu hiệu suất

**Performance:**
- Tránh tạo object không cần thiết trong vòng lặp
- Sử dụng StringBuilder thay vì nối chuỗi với +
- Cache các giá trị tính toán phức tạp nếu có thể
- Sử dụng collection phù hợp (ArrayList vs LinkedList, HashMap vs TreeMap)
- Lazy loading cho dữ liệu lớn
- Tối ưu query database (sử dụng prepared statements, batch operations)

**Ví dụ tối ưu:**
```java
// Không tốt
String result = "";
for (int i = 0; i < 1000; i++) {
    result += i + ",";
}

// Tốt hơn
StringBuilder result = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    result.append(i).append(",");
}
```

### 6. Bảo mật

**Security Best Practices:**
- Validate tất cả input từ client
- Không tin tưởng dữ liệu từ client
- Sử dụng prepared statements để tránh SQL injection
- Mã hóa mật khẩu (sử dụng BCrypt hoặc tương tự)
- Không log thông tin nhạy cảm (password, token, etc.)
- Kiểm tra quyền truy cập trước khi thực hiện action
- Rate limiting để chống spam/flood
- Validate số lượng item, gold để tránh dupe

**Ví dụ validation:**
```java
// Validate input từ client
public void buyItem(Player player, int itemId, int quantity) {
    // Kiểm tra tham số hợp lệ
    if (player == null || itemId <= 0 || quantity <= 0) {
        throw new IllegalArgumentException("Tham số không hợp lệ");
    }
    
    // Kiểm tra số lượng hợp lý (chống dupe)
    if (quantity > 999) {
        player.sendMessage("Số lượng không hợp lệ");
        return;
    }
    
    // Kiểm tra đủ tiền
    if (player.getGold() < calculatePrice(itemId, quantity)) {
        player.sendMessage("Không đủ vàng");
        return;
    }
    
    // Thực hiện mua hàng
    long price = calculatePrice(itemId, quantity);
    player.subtractGold(price);
    player.addItemToInventory(itemId, quantity);
    player.sendMessage("Mua thành công " + quantity + " item");
    // Ghi log giao dịch để tracking
}
```

## Cách sử dụng GitHub Copilot hiệu quả

### 1. Cung cấp context đầy đủ

Khi cần gợi ý code:
- Mô tả rõ ràng yêu cầu bằng comment
- Đưa ra ví dụ về input/output mong muốn
- Nêu các ràng buộc và điều kiện đặc biệt

**Ví dụ:**
```java
// TODO: Tạo phương thức tính damage dựa trên:
// - Sức mạnh của người tấn công (attacker.getPower())
// - Phòng thủ của người bị tấn công (defender.getDefense())
// - Hệ số kỹ năng (skill.getDamageMultiplier())
// Công thức: (power * multiplier - defense) * random(0.9, 1.1)
// Damage tối thiểu là 1
```

### 2. Sử dụng các câu lệnh cụ thể

**Tốt:**
```java
// Tạo class PlayerInventory để quản lý túi đồ của người chơi
// Bao gồm: thêm item, xóa item, tìm item, sắp xếp item
```

**Chưa tốt:**
```java
// Tạo class inventory
```

### 3. Review và test kỹ

Sau khi nhận gợi ý từ Copilot:
- Đọc kỹ code được sinh ra
- Kiểm tra xem có phù hợp với yêu cầu không
- Test với các test cases khác nhau
- Refactor nếu cần thiết

### 4. Tận dụng các tính năng

**Auto-completion:**
- Viết comment mô tả chức năng, để Copilot gợi ý implementation
- Bắt đầu viết method signature, Copilot sẽ gợi ý body

**Code generation:**
- Tạo test cases
- Tạo boilerplate code
- Tạo documentation

**Code explanation:**
- Hỏi Copilot giải thích đoạn code phức tạp
- Yêu cầu suggest cải tiến

### 5. Cập nhật và tùy chỉnh

- Cập nhật file này khi có thay đổi về coding standards
- Thêm các patterns/conventions cụ thể của dự án
- Cập nhật danh sách các vấn đề thường gặp và cách xử lý

## Lưu ý quan trọng

### Ngôn ngữ

**BẮT BUỘC: Tất cả gợi ý, comments, documentation phải sử dụng tiếng Việt có dấu**

- Comments trong code: Tiếng Việt
- Documentation: Tiếng Việt
- Tên biến, hàm, class: Tiếng Anh (theo convention Java)
- Thông báo lỗi: Tiếng Việt
- Log messages: Tiếng Việt

**Ví dụ:**
```java
/**
 * Lớp quản lý thông tin người chơi
 */
public class Player {
    private String name;      // Tên nhân vật
    private int level;        // Cấp độ
    private long experience;  // Kinh nghiệm
    
    /**
     * Tăng kinh nghiệm cho người chơi
     * 
     * @param exp Số kinh nghiệm tăng thêm
     */
    public void addExperience(long exp) {
        if (exp <= 0) {
            throw new IllegalArgumentException("Kinh nghiệm phải lớn hơn 0");
        }
        
        this.experience += exp;
        
        // Kiểm tra xem có đủ exp để lên cấp không
        while (this.experience >= getRequiredExpForNextLevel()) {
            levelUp();
        }
    }
    
    /**
     * Xử lý logic lên cấp cho nhân vật
     */
    private void levelUp() {
        this.level++;
        this.experience -= getRequiredExpForNextLevel();
        // Tăng stats khi lên cấp
        // Gửi thông báo đến client
    }
}
```

### Cấu trúc dự án

```
SourceNro/
├── src/
│   ├── dragon/          # Core game logic
│   │   ├── server/      # Server components
│   │   └── t/           # Game templates and utilities
│   ├── hethong/         # System components
│   └── io/              # Network I/O
├── res/                 # Resources (images, data)
├── lib/                 # External libraries
└── build.xml            # Ant build file
```

### Coding Conventions

- Package names: lowercase (dragon, hethong, io)
- Class names: PascalCase (Player, ItemManager, GameServer)
- Method names: camelCase (processAttack, updatePlayer)
- Constants: UPPER_SNAKE_CASE (MAX_LEVEL, DEFAULT_HP)
- Private fields: camelCase with descriptive names
- Indentation: 4 spaces (không dùng tabs)

## Kết luận

Hãy luôn nhớ: Code không chỉ để máy chạy mà còn để người đọc hiểu. Viết code sạch, an toàn và hiệu quả sẽ giúp dự án phát triển bền vững trong tương lai.

Khi gặp vấn đề hoặc cần thêm hướng dẫn, hãy tham khảo:
- Clean Code by Robert C. Martin
- Effective Java by Joshua Bloch
- Java Concurrency in Practice by Brian Goetz
- OWASP Top 10 cho security guidelines
