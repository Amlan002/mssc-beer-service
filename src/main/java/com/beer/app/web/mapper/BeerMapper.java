package com.beer.app.web.mapper;

import org.mapstruct.Mapper;

import com.beer.app.web.domain.Beer;
import com.beer.app.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
	BeerDto beerToBeerDto(Beer beer);
	Beer beerDtoToBeer(BeerDto dto);
}
