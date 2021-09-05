package ru.fr.quest.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class UserSingleAnswer extends UserAnswer {

    @OneToOne(fetch = FetchType.EAGER)
    public Answer answer;

}
