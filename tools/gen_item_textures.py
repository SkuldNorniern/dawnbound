"""Project wrapper around utils/pixel_art.py: generates Dawnbound item textures."""
import os
import sys

from PIL import ImageDraw

sys.path.insert(0, os.path.join(os.path.dirname(__file__), "..", "..", "utils"))
from pixel_art import new_canvas, save  # noqa: E402

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


if __name__ == "__main__":
    main()
