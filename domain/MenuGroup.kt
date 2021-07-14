package domain

data class MenuGroup(val subgroups: List<MenuGroup>, val items: List<MenuItem>)
