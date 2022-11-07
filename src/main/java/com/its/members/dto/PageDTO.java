package com.its.members.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO {
private int page;
private int maxPage;
private int startPage;
private int endPage;
}
