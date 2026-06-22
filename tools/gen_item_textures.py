"""Project wrapper around utils/pixel_art.py: generates Dawnbound item textures."""
import os
import sys

from PIL import ImageDraw

sys.path.insert(0, os.path.join(os.path.dirname(__file__), "..", "..", "utils"))
from pixel_art import new_canvas, save  # noqa: E402

ITEM_DIR = os.path.join(
    os.path.dirname(__file__), "..", "src", "main", "resources", "assets", "dawnbound", "textures", "item"
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


def main():
    os.makedirs(ITEM_DIR, exist_ok=True)

    items = {
        "plant_fiber": gen_plant_fiber,
        "cordage": gen_cordage,
        "sharp_flint": gen_sharp_flint,
        "sharp_stone": gen_sharp_stone,
        "loose_stone": gen_loose_stone,
        "clay_lump": gen_clay_lump,
        "bark": gen_bark,
        "rough_planks": gen_rough_planks,
        "flint_knife": gen_flint_knife,
        "stone_hatchet": gen_stone_hatchet,
        "digging_stick": gen_digging_stick,
    }
    for name, gen in items.items():
        save(gen(), os.path.join(ITEM_DIR, f"{name}.png"))


if __name__ == "__main__":
    main()
