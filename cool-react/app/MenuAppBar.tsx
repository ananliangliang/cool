'use client'
import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import MenuOpenIcon from '@mui/icons-material/MenuOpen';

import AccountCircle from '@mui/icons-material/AccountCircle';
import MenuItem from '@mui/material/MenuItem';
import Menu from '@mui/material/Menu';
import {Button, Drawer, MenuList, styled} from "@mui/material";
import CookieIcon from "@mui/icons-material/CookieRounded";
import DoneIcon from "@mui/icons-material/DoneOutlineRounded";
import HomeIcon from "@mui/icons-material/HomeRounded";

const DrawerHeader = styled('div')(({ theme }) => ({
  display: 'flex',
  alignItems: 'center',
  padding: theme.spacing(0, 1),
  // necessary for content to be below app bar
  ...theme.mixins.toolbar,
  justifyContent: 'flex-start',
}));


export default function MenuAppBar() {
  const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);

  const [showSideBar, setShowSideBar] = React.useState(false);


  const handleMenu = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleDrawerClose = () => {
    setShowSideBar(false);
  }

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
            onClick={() => setShowSideBar(true)}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            COOL
          </Typography>
            <div>
              <IconButton
                size="large"
                aria-label="account of current user"
                aria-controls="menu-appbar"
                aria-haspopup="true"
                onClick={handleMenu}
                color="inherit"
              >
                <AccountCircle />
              </IconButton>
              <Menu
                id="menu-appbar"
                anchorEl={anchorEl}
                anchorOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                keepMounted
                transformOrigin={{
                  vertical: 'top',
                  horizontal: 'right',
                }}
                open={Boolean(anchorEl)}
                onClose={handleClose}
              >
                <MenuItem onClick={handleClose}>Profile</MenuItem>
                <MenuItem onClick={handleClose}>My account</MenuItem>
              </Menu>
            </div>
        </Toolbar>
      </AppBar>
      <Drawer onClose={handleDrawerClose} open={showSideBar} anchor={"left"}>
        <DrawerHeader>
          <IconButton onClick={handleDrawerClose}>
            <MenuOpenIcon />
          </IconButton>
        </DrawerHeader>
        <MenuList className={"mx-2"}>
          <MenuItem selected={true} className={"rounded-full"}><HomeIcon/>首页</MenuItem>
          <MenuItem className={"rounded-full"}><DoneIcon/>代办事项</MenuItem>
          <MenuItem className={"rounded-full"}><CookieIcon/>炸厨房</MenuItem>
        </MenuList>
        <Button variant="outlined" color="secondary">Hello world11</Button>
      </Drawer>
    </Box>
  );
}