package java_use_case.rec_album;

import use_case.rec_album.RecAlbumOutputBoundary;
import use_case.rec_album.RecAlbumOutputData;

class TestOutputBoundary implements RecAlbumOutputBoundary {
    private RecAlbumOutputData outputData;

    @Override
    public void prepareSuccessView(RecAlbumOutputData outputData) {
        this.outputData = outputData;
    }

    @Override
    public void prepareFailView(String errorMessage) {
        this.outputData = new RecAlbumOutputData(null, null, false, errorMessage);
    }

    public RecAlbumOutputData getOutputData() {
        return outputData;
    }
}
