package vn.khoapd.kis.taxonomy.service;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.category.CategoryServiceGrpc;
import vn.khoapd.kis.category.GetCategoryRequest;
import vn.khoapd.kis.category.GetCategoryResponse;
import vn.khoapd.kis.shared.enums.ECommonErrorCode;
import vn.khoapd.kis.shared.exception.CustomRuntimeException;
import vn.khoapd.kis.taxonomy.repository.ICategoryRepository;

@Service
@RequiredArgsConstructor
public class CategoryServiceGrpcImpl extends CategoryServiceGrpc.CategoryServiceImplBase {

    private final ICategoryRepository categoryRepository;
    private final DiscoveryClient discoveryClient;

    @Override
    public void findById(GetCategoryRequest request, StreamObserver<GetCategoryResponse> responseObserver) {
        
        var item = categoryRepository.findById(request.getId()).orElseThrow(
                () -> new CustomRuntimeException(ECommonErrorCode.CATEGORY_ID_NOT_FOUND)
        );
        var itemResponse = GetCategoryResponse.newBuilder()
                .setId(item.getId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setIdParent(item.getParentId())
                .build();
        responseObserver.onNext(itemResponse);
        responseObserver.onCompleted();
    }
}
