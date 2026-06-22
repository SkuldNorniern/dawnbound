"""Project wrapper around utils/pixel_art.py: generates Dawnbound item textures."""
import os
import sys

from PIL import ImageDraw

sys.path.insert(0, os.path.join(os.path.dirname(__file__), "..", "..", "utils"))
from pixel_art import new_canvas, save, save_animated  # noqa: E402
from gen_item_definitions import generate_item_definitions  # noqa: E402

ASSETS_ROOT = os.path.join(os.path.dirname(__file__), "..", "src", "main", "resources")
ITEM_DIR = os.path.join(
    os.path.dirname(__file__), "..", "src", "main", "resources", "assets", "dawnbound", "textures", "item"
)
BLOCK_DIR = os.path.join(
    os.path.dirname(__file__), "..", "src", "main", "resources", "assets", "dawnbound", "textures", "block"
)

OUTLINE = (40, 30, 20, 255)


def gen_plant_fiber():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(4, 13), (9, 3)], fill=(150, 168, 60, 255), width=2)
    d.line([(6, 13), (11, 4)], fill=(120, 140, 45, 255), width=2)
    d.line([(2, 12), (7, 5)], fill=(170, 188, 80, 255), width=1)
    return img


def gen_cordage():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(3, 12), (12, 4)], fill=(150, 110, 60, 255), width=3)
    d.line([(3, 12), (12, 4)], fill=(180, 140, 85, 255), width=1)
    d.line([(4, 4), (13, 12)], fill=(120, 85, 45, 255), width=2)
    return img


def gen_sharp_flint():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.polygon([(8, 2), (12, 7), (9, 13), (6, 13), (4, 7)], fill=(70, 70, 78, 255), outline=OUTLINE)
    d.line([(8, 2), (8, 13)], fill=(130, 130, 140, 255))
    return img


def gen_sharp_stone():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.polygon([(7, 3), (12, 6), (11, 12), (5, 13), (3, 7)], fill=(120, 116, 110, 255), outline=OUTLINE)
    d.line([(5, 8), (10, 7)], fill=(150, 146, 138, 255))
    return img


def gen_loose_stone():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.ellipse([3, 5, 13, 12], fill=(128, 124, 118, 255), outline=OUTLINE)
    d.ellipse([5, 6, 8, 9], fill=(150, 146, 138, 255))
    return img


def gen_clay_lump():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.ellipse([3, 4, 13, 13], fill=(165, 110, 80, 255), outline=OUTLINE)
    d.ellipse([5, 6, 9, 9], fill=(190, 140, 110, 255))
    return img


def gen_bark():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([2, 2, 13, 13], fill=(92, 64, 40, 255), outline=OUTLINE)
    for y in (4, 7, 10):
        d.line([(2, y), (13, y)], fill=(70, 48, 30, 255))
    return img


def gen_rough_planks():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([2, 3, 13, 12], fill=(150, 112, 68, 255), outline=OUTLINE)
    for x in (5, 9):
        d.line([(x, 3), (x, 12)], fill=(120, 88, 50, 255))
    return img


def gen_flint_knife():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(4, 13), (10, 7)], fill=(150, 110, 60, 255), width=2)
    d.polygon([(9, 8), (13, 2), (12, 5), (8, 9)], fill=(70, 70, 78, 255), outline=OUTLINE)
    return img


def gen_stone_hatchet():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(4, 13), (10, 6)], fill=(150, 110, 60, 255), width=2)
    d.polygon([(9, 7), (14, 3), (13, 8), (9, 11)], fill=(120, 116, 110, 255), outline=OUTLINE)
    return img


def gen_digging_stick():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(4, 14), (12, 2)], fill=(150, 110, 60, 255), width=2)
    d.polygon([(11, 4), (14, 2), (12, 5)], fill=(120, 116, 110, 255), outline=OUTLINE)
    return img


def gen_saw():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(4, 13), (10, 7)], fill=(150, 110, 60, 255), width=2)
    d.polygon([(9, 8), (14, 3), (13, 6), (8, 9)], fill=(80, 80, 88, 255), outline=OUTLINE)
    for i in range(3):
        x, y = 9 + i, 7 - i
        d.point((x, y), fill=(160, 160, 168, 255))
    return img


def gen_bound_saw():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(4, 13), (10, 7)], fill=(150, 110, 60, 255), width=2)
    d.line([(5, 11), (9, 9)], fill=(195, 165, 120, 255), width=1)
    d.polygon([(9, 8), (14, 3), (13, 6), (8, 9)], fill=(140, 136, 130, 255), outline=OUTLINE)
    for i in range(3):
        x, y = 9 + i, 7 - i
        d.point((x, y), fill=(200, 198, 192, 255))
    return img


def gen_knapped_stone_head():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.polygon([(8, 2), (13, 6), (11, 13), (5, 13), (3, 6)], fill=(130, 126, 120, 255), outline=OUTLINE)
    d.line([(6, 6), (10, 8)], fill=(160, 156, 148, 255))
    d.line([(6, 9), (9, 6)], fill=(100, 96, 90, 255))
    return img


def gen_bound_stone_head():
    img = gen_knapped_stone_head()
    d = ImageDraw.Draw(img)
    d.line([(5, 12), (11, 12)], fill=(150, 110, 60, 255), width=2)
    return img


def gen_resin():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.polygon([(7, 3), (11, 6), (10, 12), (6, 12), (5, 6)], fill=(190, 120, 40, 255), outline=(140, 80, 20, 255))
    d.point((8, 6), fill=(235, 180, 100, 255))
    return img


def gen_rawhide_cord():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(3, 12), (12, 4)], fill=(195, 165, 120, 255), width=3)
    d.line([(3, 12), (12, 4)], fill=(220, 195, 155, 255), width=1)
    return img


def gen_crude_handle():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.line([(4, 13), (12, 3)], fill=(150, 110, 60, 255), width=3)
    d.line([(5, 6), (8, 9)], fill=(195, 165, 120, 255), width=1)
    return img


def gen_tool_binding():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.ellipse([3, 5, 13, 11], outline=(195, 165, 120, 255), width=2)
    d.line([(4, 8), (12, 8)], fill=(190, 120, 40, 255), width=1)
    return img


def gen_crushed_copper_ore():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.polygon([(7, 3), (12, 6), (11, 12), (5, 13), (3, 7)], fill=(120, 116, 110, 255), outline=OUTLINE)
    for x, y in [(6, 6), (9, 8), (7, 10)]:
        d.point((x, y), fill=(200, 120, 70, 255))
        d.point((x + 1, y), fill=(230, 150, 90, 255))
    return img


def gen_crushed_iron_ore():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.polygon([(7, 3), (12, 6), (11, 12), (5, 13), (3, 7)], fill=(120, 116, 110, 255), outline=OUTLINE)
    for x, y in [(6, 6), (9, 8), (7, 10)]:
        d.point((x, y), fill=(216, 178, 160, 255))
        d.point((x + 1, y), fill=(230, 200, 180, 255))
    return img


def gen_work_mat():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(150, 122, 78, 255))
    for y in range(0, 16, 3):
        d.line([(0, y), (15, y)], fill=(120, 95, 55, 255))
    for x in range(0, 16, 3):
        d.line([(x, 0), (x, 15)], fill=(170, 142, 95, 255))
    return img


def gen_stone_work_surface():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(118, 114, 108, 255))
    d.line([(2, 3), (7, 6), (5, 11)], fill=(90, 86, 80, 255))
    d.line([(9, 2), (11, 8), (14, 12)], fill=(90, 86, 80, 255))
    d.line([(3, 13), (8, 10), (13, 14)], fill=(140, 136, 128, 255))
    return img


def gen_work_stump_bark():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(92, 64, 40, 255))
    for x in (2, 5, 8, 11, 14):
        d.line([(x, 0), (x, 15)], fill=(70, 48, 30, 255))
    return img


def gen_work_stump_top():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(150, 112, 68, 255))
    for r in (6, 4, 2):
        d.ellipse([7 - r, 7 - r, 7 + r, 7 + r], outline=(120, 88, 50, 255))
    d.line([(3, 4), (10, 11)], fill=(80, 56, 32, 255), width=1)
    return img


def gen_fire_pit_stone():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(118, 114, 108, 255))
    d.ellipse([2, 2, 13, 13], outline=(90, 86, 80, 255), width=2)
    d.ellipse([5, 5, 10, 10], fill=(40, 28, 20, 255))
    return img


def gen_fire_pit_logs():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(40, 28, 20, 255))
    d.line([(2, 2), (13, 13)], fill=(92, 64, 40, 255), width=2)
    d.line([(2, 13), (13, 2)], fill=(70, 48, 30, 255), width=2)
    return img


def gen_fire_pit_flame_frames():
    outer = (235, 140, 40, 255)
    outline = (150, 60, 10, 255)
    inner = (255, 220, 110, 255)
    frame_shapes = [
        ([(8, 5), (11, 9), (10, 15), (6, 15), (5, 9)], [(8, 8), (9, 11), (9, 15), (7, 15), (7, 11)]),
        ([(8, 4), (12, 9), (10, 15), (6, 15), (4, 9)], [(8, 7), (10, 11), (9, 15), (7, 15), (6, 11)]),
        ([(7, 5), (11, 9), (11, 15), (5, 15), (5, 8)], [(7, 8), (9, 11), (9, 15), (6, 15), (6, 10)]),
        ([(8, 4), (11, 8), (10, 15), (6, 15), (5, 9)], [(8, 7), (9, 10), (9, 15), (7, 15), (7, 11)]),
    ]
    frames = []
    for outer_pts, inner_pts in frame_shapes:
        img = new_canvas()
        d = ImageDraw.Draw(img)
        d.polygon(outer_pts, fill=outer, outline=outline)
        d.polygon(inner_pts, fill=inner)
        frames.append(img)
    return frames


def gen_ore_crushing_stone_base():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(118, 114, 108, 255))
    d.rectangle([1, 1, 14, 14], outline=(90, 86, 80, 255), width=1)
    return img


def gen_ore_crushing_stone_bowl():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(100, 96, 90, 255))
    d.ellipse([3, 3, 12, 12], fill=(60, 56, 52, 255), outline=(40, 36, 32, 255))
    return img


def gen_ore_crushing_stone_pestle():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(128, 124, 118, 255))
    d.rectangle([1, 1, 14, 14], outline=(100, 96, 90, 255), width=1)
    return img


def gen_clay_kiln_body():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(176, 110, 70, 255))
    d.rectangle([1, 1, 14, 14], outline=(140, 84, 50, 255), width=1)
    return img


def gen_clay_kiln_mouth_frames():
    ember_colors = [
        (60, 30, 16, 255),
        (110, 50, 20, 255),
        (150, 70, 24, 255),
        (110, 50, 20, 255),
    ]
    frames = []
    for ember in ember_colors:
        img = new_canvas()
        d = ImageDraw.Draw(img)
        d.rectangle([0, 0, 15, 15], fill=(176, 110, 70, 255))
        d.rectangle([3, 3, 12, 12], fill=(30, 22, 18, 255), outline=(90, 56, 34, 255))
        d.rectangle([5, 6, 10, 10], fill=ember)
        frames.append(img)
    return frames


def gen_bloomery_body():
    img = new_canvas()
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], fill=(96, 92, 88, 255))
    d.rectangle([1, 1, 14, 14], outline=(64, 60, 56, 255), width=1)
    for x, y in [(3, 3), (11, 4), (4, 11), (12, 12)]:
        d.point((x, y), fill=(72, 68, 64, 255))
    return img


def gen_bloomery_vent_frames():
    ember_colors = [
        (50, 24, 14, 255),
        (130, 50, 16, 255),
        (190, 90, 24, 255),
        (130, 50, 16, 255),
    ]
    frames = []
    for ember in ember_colors:
        img = new_canvas()
        d = ImageDraw.Draw(img)
        d.rectangle([0, 0, 15, 15], fill=(96, 92, 88, 255))
        d.rectangle([4, 4, 11, 11], fill=(24, 18, 16, 255), outline=(60, 54, 50, 255))
        d.rectangle([6, 7, 9, 9], fill=ember)
        frames.append(img)
    return frames


def main():
    os.makedirs(ITEM_DIR, exist_ok=True)
    os.makedirs(BLOCK_DIR, exist_ok=True)

    items = {
        "materials/plant_fiber": gen_plant_fiber,
        "materials/cordage": gen_cordage,
        "materials/sharp_flint": gen_sharp_flint,
        "materials/sharp_stone": gen_sharp_stone,
        "materials/loose_stone": gen_loose_stone,
        "materials/clay_lump": gen_clay_lump,
        "materials/bark": gen_bark,
        "materials/rough_planks": gen_rough_planks,
        "tools/flint_knife": gen_flint_knife,
        "tools/stone_hatchet": gen_stone_hatchet,
        "tools/digging_stick": gen_digging_stick,
        "tools/saw": gen_saw,
        "tools/bound_saw": gen_bound_saw,
        "materials/knapped_stone_head": gen_knapped_stone_head,
        "materials/bound_stone_head": gen_bound_stone_head,
        "materials/resin": gen_resin,
        "materials/rawhide_cord": gen_rawhide_cord,
        "materials/crude_handle": gen_crude_handle,
        "materials/tool_binding": gen_tool_binding,
        "materials/crushed_copper_ore": gen_crushed_copper_ore,
        "materials/crushed_iron_ore": gen_crushed_iron_ore,
    }
    for name, gen in items.items():
        out_path = os.path.join(ITEM_DIR, f"{name}.png")
        os.makedirs(os.path.dirname(out_path), exist_ok=True)
        save(gen(), out_path)

    save(gen_work_mat(), os.path.join(BLOCK_DIR, "primitive_work_mat.png"))
    save(gen_stone_work_surface(), os.path.join(BLOCK_DIR, "flat_stone_work_surface.png"))
    os.makedirs(os.path.join(BLOCK_DIR, "primitive_work_stump"), exist_ok=True)
    save(gen_work_stump_bark(), os.path.join(BLOCK_DIR, "primitive_work_stump", "bark.png"))
    save(gen_work_stump_top(), os.path.join(BLOCK_DIR, "primitive_work_stump", "top.png"))

    os.makedirs(os.path.join(BLOCK_DIR, "fire_pit"), exist_ok=True)
    save(gen_fire_pit_stone(), os.path.join(BLOCK_DIR, "fire_pit", "stone.png"))
    save(gen_fire_pit_logs(), os.path.join(BLOCK_DIR, "fire_pit", "logs.png"))
    save_animated(gen_fire_pit_flame_frames(), os.path.join(BLOCK_DIR, "fire_pit", "flame.png"), frametime=4)

    os.makedirs(os.path.join(BLOCK_DIR, "ore_crushing_stone"), exist_ok=True)
    save(gen_ore_crushing_stone_base(), os.path.join(BLOCK_DIR, "ore_crushing_stone", "base.png"))
    save(gen_ore_crushing_stone_bowl(), os.path.join(BLOCK_DIR, "ore_crushing_stone", "bowl.png"))
    save(gen_ore_crushing_stone_pestle(), os.path.join(BLOCK_DIR, "ore_crushing_stone", "pestle.png"))

    os.makedirs(os.path.join(BLOCK_DIR, "clay_kiln"), exist_ok=True)
    save(gen_clay_kiln_body(), os.path.join(BLOCK_DIR, "clay_kiln", "body.png"))
    save_animated(gen_clay_kiln_mouth_frames(), os.path.join(BLOCK_DIR, "clay_kiln", "mouth.png"), frametime=6)

    os.makedirs(os.path.join(BLOCK_DIR, "bloomery"), exist_ok=True)
    save(gen_bloomery_body(), os.path.join(BLOCK_DIR, "bloomery", "body.png"))
    save_animated(gen_bloomery_vent_frames(), os.path.join(BLOCK_DIR, "bloomery", "vent.png"), frametime=5)

    generate_item_definitions(ASSETS_ROOT, "dawnbound")


if __name__ == "__main__":
    main()
