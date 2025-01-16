package java_use_case.rec_album;

import entity.Album;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.AlbumService;
import use_case.rec_album.*;

import java.util.ArrayList;

class RecAlbumInteractorTest {

    @Test
    void testExecuteWithAlbums() {
        // Arrange
        RecAlbumOutputBoundary outputBoundary = new TestOutputBoundary();
        RecAlbumDataAccessInterface dataAccessObject = new TestAlbumDataAccessObject();
        RecAlbumInteractor interactor = new RecAlbumInteractor(outputBoundary, dataAccessObject);

        // Act
        interactor.execute(new RecAlbumInputData());

        // Assert
        RecAlbumOutputData outputData = ((TestOutputBoundary) outputBoundary).getOutputData();
        Assertions.assertNotNull(outputData);
        Assertions.assertEquals("1", outputData.getId());
        Assertions.assertEquals("Album1", outputData.getAlbumName());
        Assertions.assertTrue(outputData.isSuccess());
    }

    @Test
    void testExecuteWithNoAlbums() {
        // Arrange
        RecAlbumOutputBoundary outputBoundary = new TestOutputBoundary();
        RecAlbumDataAccessInterface dataAccessObject = new TestAlbumDataAccessObject(true);
        RecAlbumInteractor interactor = new RecAlbumInteractor(outputBoundary, dataAccessObject);

        // Act
        interactor.execute(new RecAlbumInputData());

        // Assert
        RecAlbumOutputData outputData = ((TestOutputBoundary) outputBoundary).getOutputData();
        Assertions.assertNotNull(outputData);
        Assertions.assertNull(outputData.getId());
        Assertions.assertNull(outputData.getAlbumName());
        Assertions.assertFalse(outputData.isSuccess());
    }
}
