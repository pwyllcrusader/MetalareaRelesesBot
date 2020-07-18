package by.pw.crr.metla.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ChatUser {
    @Id
    private Long chatId;
    private boolean isAllReleasesToShow;
}
