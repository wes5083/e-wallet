package com.demo.ewallet.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntityVo implements Serializable {

	private static final long serialVersionUID = -5380572378318854841L;

	private Long id;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
}