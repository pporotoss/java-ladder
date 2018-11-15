package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;

public class BlockTest {

    @Test
    public void 만들기_비어있는_블록() {
        final Block block = Block.EMPTY_BLOCK;
        final String expectedShapes = BlockType.EMPTY.makeShapes(Block.WIDTH);

        assertThat(block.getType()).isSameAs(BlockType.EMPTY);
        assertThat(block.toString()).isEqualTo(expectedShapes);
    }

    @Test
    public void 만들기_채워진_블록() {
        final Block block = Block.FILLED_BLOCK;
        final String expectedShapes = BlockType.FILLED.makeShapes(Block.WIDTH);

        assertThat(block.getType()).isSameAs(BlockType.FILLED);
        assertThat(block.toString()).isEqualTo(expectedShapes);
    }

    @Test
    public void 동일성_테스트() {
        final Block block1 = Block.EMPTY_BLOCK;
        final Block block2 = Block.EMPTY_BLOCK;

        assertThat(block1).isSameAs(block2);
    }

    @Test
    public void equals_동등하지_않음() {
        final Block block = Block.FILLED_BLOCK;
        final Block other = Block.EMPTY_BLOCK;
        assertThat(block.equals(other)).isFalse();
    }

    @Test
    public void equals_동등함() {
        final Block block = Block.EMPTY_BLOCK;
        final Block other = Block.EMPTY_BLOCK;
        assertThat(block.equals(other)).isTrue();
    }

    @Test
    public void 연속_채워진_블록_확인() {
        final Block before = Block.FILLED_BLOCK;
        final Block afterFilled = Block.FILLED_BLOCK;
        final Block afterEmpty = Block.EMPTY_BLOCK;

        assertThat(before.isSequenceFilledBlock(afterFilled)).isTrue();
        assertThat(before.isSequenceFilledBlock(afterEmpty)).isFalse();
    }
}