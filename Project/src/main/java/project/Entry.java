package project;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import project.Serialization.LocalDateTimeDeserializer;
import project.Serialization.LocalDateTimeSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Entry {

    private String category;
    private BigDecimal amount;
    private String description;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime date;

    public Entry(String category, BigDecimal amount, LocalDate date, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.date = date.atStartOfDay();
    }

    public Entry() {
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date.toLocalDate();
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Entry setCategoryAndReturn(String category){
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "category='" + category + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return Objects.equals(category, entry.category) &&
                Objects.equals(amount, entry.amount) &&
                Objects.equals(description, entry.description) &&
                Objects.equals(date, entry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, amount, description, date);
    }
}
