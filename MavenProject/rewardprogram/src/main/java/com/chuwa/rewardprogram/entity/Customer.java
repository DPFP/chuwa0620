package com.chuwa.rewardprogram.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "customer",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_name"})
        }
)
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "user_name", nullable = false)
        private String userName;

        public Customer() {

        }

        public Customer(long id, String userName) {
                this.id = id;
                this.userName = userName;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }
}
