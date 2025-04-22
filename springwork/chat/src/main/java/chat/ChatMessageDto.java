package chat;

import lombok.Data;

@Data
public class ChatMessageDto {
    private Long id;
    private String message;
    private String user;
    private String imageUrl;
    private String timestamp;
}
