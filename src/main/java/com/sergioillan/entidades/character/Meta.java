package com.sergioillan.entidades.character;

import lombok.Data;

@Data
public class Meta{
    public int totalItems;
    public int itemCount;
    public int itemsPerPage;
    public int totalPages;
    public int currentPage;
}