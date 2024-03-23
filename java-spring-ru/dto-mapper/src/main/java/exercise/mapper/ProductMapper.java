package exercise.mapper;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapper;

// BEGIN
@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ProductMapper {
    @Mapping(source = "title", target = "name")
    @Mapping(source = "price", target = "cost")
    @Mapping(source = "vendorCode", target = "barcode")
    public abstract Product map(ProductCreateDTO productCreateDTO);

    @Mapping(source = "name", target = "title")
    @Mapping(source = "cost", target = "price")
    @Mapping(source = "barcode", target = "vendorCode")
    public abstract ProductDTO map(Product product);

    @Mapping(source = "price", target = "cost")
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product product);
}
// END
